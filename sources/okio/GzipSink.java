package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
/* loaded from: classes.dex */
public final class GzipSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f1468a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f1469b;
    private final DeflaterSink c;
    private boolean d;
    private final CRC32 e;

    private void a(Buffer buffer, long j) {
        Segment segment = buffer.f1462b;
        while (j > 0) {
            int min = (int) Math.min(j, segment.c - segment.f1487b);
            this.e.update(segment.f1486a, segment.f1487b, min);
            j -= min;
            segment = segment.f;
        }
    }

    private void d() throws IOException {
        this.f1468a.a((int) this.e.getValue());
        this.f1468a.a(this.f1469b.getTotalIn());
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        try {
            this.c.d();
            d();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f1469b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f1468a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.d = true;
        if (th == null) {
            return;
        }
        Util.a(th);
        throw null;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.c.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f1468a.timeout();
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
        } else {
            a(buffer, j);
            this.c.write(buffer, j);
        }
    }
}
