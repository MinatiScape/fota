package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;
/* loaded from: classes.dex */
public final class RetryableSink implements Sink {
    private boolean closed;
    private final Buffer content;
    private final int limit;

    public RetryableSink(int i) {
        this.content = new Buffer();
        this.limit = i;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        if (this.content.p() >= this.limit) {
            return;
        }
        throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.p());
    }

    public long contentLength() throws IOException {
        return this.content.p();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (!this.closed) {
            Util.checkOffsetAndCount(buffer.p(), 0L, j);
            if (this.limit != -1 && this.content.p() > this.limit - j) {
                throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
            }
            this.content.write(buffer, j);
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void writeToSocket(Sink sink) throws IOException {
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.content;
        buffer2.a(buffer, 0L, buffer2.p());
        sink.write(buffer, buffer.p());
    }

    public RetryableSink() {
        this(-1);
    }
}
