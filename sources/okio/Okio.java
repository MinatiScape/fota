package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class Okio {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f1474a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static Sink b(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source c(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static BufferedSource a(Source source) {
        if (source != null) {
            return new RealBufferedSource(source);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static Source b(Socket socket) throws IOException {
        if (socket != null) {
            AsyncTimeout c = c(socket);
            return c.source(a(socket.getInputStream(), c));
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static AsyncTimeout c(final Socket socket) {
        return new AsyncTimeout() { // from class: okio.Okio.3
            @Override // okio.AsyncTimeout
            protected IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // okio.AsyncTimeout
            protected void timedOut() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (e.getCause() != null && e.getMessage() != null && e.getMessage().contains("getsockname failed")) {
                        Logger logger = Okio.f1474a;
                        Level level = Level.WARNING;
                        logger.log(level, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    Logger logger2 = Okio.f1474a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    public static BufferedSink a(Sink sink) {
        if (sink != null) {
            return new RealBufferedSink(sink);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static Sink a(OutputStream outputStream) {
        return a(outputStream, new Timeout());
    }

    private static Sink a(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream != null) {
            if (timeout != null) {
                return new Sink() { // from class: okio.Okio.1
                    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        outputStream.close();
                    }

                    @Override // okio.Sink, java.io.Flushable
                    public void flush() throws IOException {
                        outputStream.flush();
                    }

                    @Override // okio.Sink
                    public Timeout timeout() {
                        return Timeout.this;
                    }

                    public String toString() {
                        return "sink(" + outputStream + ")";
                    }

                    @Override // okio.Sink
                    public void write(Buffer buffer, long j) throws IOException {
                        Util.a(buffer.c, 0L, j);
                        while (j > 0) {
                            Timeout.this.throwIfReached();
                            Segment segment = buffer.f1462b;
                            int min = (int) Math.min(j, segment.c - segment.f1487b);
                            outputStream.write(segment.f1486a, segment.f1487b, min);
                            segment.f1487b += min;
                            long j2 = min;
                            j -= j2;
                            buffer.c -= j2;
                            if (segment.f1487b == segment.c) {
                                buffer.f1462b = segment.b();
                                SegmentPool.a(segment);
                            }
                        }
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static Sink a(Socket socket) throws IOException {
        if (socket != null) {
            AsyncTimeout c = c(socket);
            return c.sink(a(socket.getOutputStream(), c));
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static Source a(InputStream inputStream) {
        return a(inputStream, new Timeout());
    }

    private static Source a(final InputStream inputStream, final Timeout timeout) {
        if (inputStream != null) {
            if (timeout != null) {
                return new Source() { // from class: okio.Okio.2
                    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }

                    @Override // okio.Source
                    public long read(Buffer buffer, long j) throws IOException {
                        if (j < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j);
                        } else if (j == 0) {
                            return 0L;
                        } else {
                            Timeout.this.throwIfReached();
                            Segment c = buffer.c(1);
                            int read = inputStream.read(c.f1486a, c.c, (int) Math.min(j, 2048 - c.c));
                            if (read == -1) {
                                return -1L;
                            }
                            c.c += read;
                            long j2 = read;
                            buffer.c += j2;
                            return j2;
                        }
                    }

                    @Override // okio.Source
                    public Timeout timeout() {
                        return Timeout.this;
                    }

                    public String toString() {
                        return "source(" + inputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static Sink a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }
}
