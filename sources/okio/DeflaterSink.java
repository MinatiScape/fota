package okio;

import java.io.IOException;
import java.util.zip.Deflater;
/* loaded from: classes.dex */
public final class DeflaterSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f1465a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f1466b;
    private boolean c;

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.a(sink), deflater);
    }

    private void a(boolean z) throws IOException {
        Segment c;
        int deflate;
        Buffer a2 = this.f1465a.a();
        while (true) {
            c = a2.c(1);
            if (z) {
                Deflater deflater = this.f1466b;
                byte[] bArr = c.f1486a;
                int i = c.c;
                deflate = deflater.deflate(bArr, i, 2048 - i, 2);
            } else {
                Deflater deflater2 = this.f1466b;
                byte[] bArr2 = c.f1486a;
                int i2 = c.c;
                deflate = deflater2.deflate(bArr2, i2, 2048 - i2);
            }
            if (deflate > 0) {
                c.c += deflate;
                a2.c += deflate;
                this.f1465a.c();
            } else if (this.f1466b.needsInput()) {
                break;
            }
        }
        if (c.f1487b == c.c) {
            a2.f1462b = c.b();
            SegmentPool.a(c);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        try {
            d();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f1466b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f1465a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th == null) {
            return;
        }
        Util.a(th);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() throws IOException {
        this.f1466b.finish();
        a(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f1465a.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f1465a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f1465a + ")";
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        Util.a(buffer.c, 0L, j);
        while (j > 0) {
            Segment segment = buffer.f1462b;
            int min = (int) Math.min(j, segment.c - segment.f1487b);
            this.f1466b.setInput(segment.f1486a, segment.f1487b, min);
            a(false);
            long j2 = min;
            buffer.c -= j2;
            segment.f1487b += min;
            if (segment.f1487b == segment.c) {
                buffer.f1462b = segment.b();
                SegmentPool.a(segment);
            }
            j -= j2;
        }
    }

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater != null) {
            this.f1465a = bufferedSink;
            this.f1466b = deflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
}
