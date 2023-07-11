package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes.dex */
public final class Http1xStream implements HttpStream {
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private HttpEngine httpEngine;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state = 0;
    private final StreamAllocation streamAllocation;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class AbstractSource implements Source {
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1xStream.this.source.timeout());
        }

        protected final void endOfInput() throws IOException {
            if (Http1xStream.this.state == 5) {
                Http1xStream.this.detachTimeout(this.timeout);
                Http1xStream.this.state = 6;
                if (Http1xStream.this.streamAllocation != null) {
                    Http1xStream.this.streamAllocation.streamFinished(Http1xStream.this);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + Http1xStream.this.state);
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        protected final void unexpectedEndOfInput() {
            if (Http1xStream.this.state == 6) {
                return;
            }
            Http1xStream.this.state = 6;
            if (Http1xStream.this.streamAllocation != null) {
                Http1xStream.this.streamAllocation.noNewStreams();
                Http1xStream.this.streamAllocation.streamFinished(Http1xStream.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        private ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1xStream.this.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1xStream.this.sink.a("0\r\n\r\n");
            Http1xStream.this.detachTimeout(this.timeout);
            Http1xStream.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1xStream.this.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1xStream.this.sink.b(j);
            Http1xStream.this.sink.a("\r\n");
            Http1xStream.this.sink.write(buffer, j);
            Http1xStream.this.sink.a("\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine) throws IOException {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.httpEngine = httpEngine;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1xStream.this.source.d();
            }
            try {
                this.bytesRemainingInChunk = Http1xStream.this.source.j();
                String trim = Http1xStream.this.source.d().trim();
                if (this.bytesRemainingInChunk >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.bytesRemainingInChunk == 0) {
                        this.hasMoreChunks = false;
                        this.httpEngine.receiveHeaders(Http1xStream.this.readHeaders());
                        endOfInput();
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.closed) {
                    if (this.hasMoreChunks) {
                        long j2 = this.bytesRemainingInChunk;
                        if (j2 == 0 || j2 == -1) {
                            readChunkSize();
                            if (!this.hasMoreChunks) {
                                return -1L;
                            }
                        }
                        long read = Http1xStream.this.source.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                        if (read != -1) {
                            this.bytesRemainingInChunk -= read;
                            return read;
                        }
                        unexpectedEndOfInput();
                        throw new ProtocolException("unexpected end of stream");
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout;

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining <= 0) {
                Http1xStream.this.detachTimeout(this.timeout);
                Http1xStream.this.state = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1xStream.this.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(buffer.p(), 0L, j);
                if (j <= this.bytesRemaining) {
                    Http1xStream.this.sink.write(buffer, j);
                    this.bytesRemaining -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        private FixedLengthSink(long j) {
            this.timeout = new ForwardingTimeout(Http1xStream.this.sink.timeout());
            this.bytesRemaining = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.closed) {
                    if (this.bytesRemaining == 0) {
                        return -1L;
                    }
                    long read = Http1xStream.this.source.read(buffer, Math.min(this.bytesRemaining, j));
                    if (read != -1) {
                        this.bytesRemaining -= read;
                        if (this.bytesRemaining == 0) {
                            endOfInput();
                        }
                        return read;
                    }
                    unexpectedEndOfInput();
                    throw new ProtocolException("unexpected end of stream");
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j >= 0) {
                if (!this.closed) {
                    if (this.inputExhausted) {
                        return -1L;
                    }
                    long read = Http1xStream.this.source.read(buffer, j);
                    if (read == -1) {
                        this.inputExhausted = true;
                        endOfInput();
                        return -1L;
                    }
                    return read;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public Http1xStream(StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout a2 = forwardingTimeout.a();
        forwardingTimeout.a(Timeout.NONE);
        a2.clearDeadline();
        a2.clearTimeout();
    }

    private Source getTransferStream(Response response) throws IOException {
        if (!HttpEngine.hasBody(response)) {
            return newFixedLengthSource(0L);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return newChunkedSource(this.httpEngine);
        }
        long contentLength = OkHeaders.contentLength(response);
        if (contentLength != -1) {
            return newFixedLengthSource(contentLength);
        }
        return newUnknownLengthSource();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Sink createRequestBody(Request request, long j) throws IOException {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpEngine);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            StreamAllocation streamAllocation = this.streamAllocation;
            if (streamAllocation != null) {
                this.state = 5;
                streamAllocation.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.a(getTransferStream(response)));
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String d = this.source.d();
            if (d.length() != 0) {
                Internal.instance.addLenient(builder, d);
            } else {
                return builder.build();
            }
        }
    }

    public Response.Builder readResponse() throws IOException {
        StatusLine parse;
        Response.Builder headers;
        int i = this.state;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        do {
            try {
                parse = StatusLine.parse(this.source.d());
                headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                iOException.initCause(e);
                throw iOException;
            }
        } while (parse.code == 100);
        this.state = 4;
        return headers;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Response.Builder readResponseHeaders() throws IOException {
        return readResponse();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void setHttpEngine(HttpEngine httpEngine) {
        this.httpEngine = httpEngine;
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.a(str).a("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.sink.a(headers.name(i)).a(": ").a(headers.value(i)).a("\r\n");
            }
            this.sink.a("\r\n");
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state == 1) {
            this.state = 3;
            retryableSink.writeToSocket(this.sink);
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestHeaders(Request request) throws IOException {
        this.httpEngine.writingRequestHeaders();
        writeRequest(request.headers(), RequestLine.get(request, this.httpEngine.getConnection().getRoute().getProxy().type()));
    }
}
