package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes.dex */
public final class InflaterSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f1472a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f1473b;
    private int c;
    private boolean d;

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.a(source), inflater);
    }

    private void c() throws IOException {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f1473b.getRemaining();
        this.c -= remaining;
        this.f1472a.skip(remaining);
    }

    public boolean b() throws IOException {
        if (this.f1473b.needsInput()) {
            c();
            if (this.f1473b.getRemaining() == 0) {
                if (this.f1472a.g()) {
                    return true;
                }
                Segment segment = this.f1472a.a().f1462b;
                int i = segment.c;
                int i2 = segment.f1487b;
                this.c = i - i2;
                this.f1473b.setInput(segment.f1486a, i2, this.c);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.f1473b.end();
        this.d = true;
        this.f1472a.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        Segment c;
        if (j >= 0) {
            if (this.d) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return 0L;
            }
            while (true) {
                boolean b2 = b();
                try {
                    c = buffer.c(1);
                    int inflate = this.f1473b.inflate(c.f1486a, c.c, 2048 - c.c);
                    if (inflate > 0) {
                        c.c += inflate;
                        long j2 = inflate;
                        buffer.c += j2;
                        return j2;
                    } else if (this.f1473b.finished() || this.f1473b.needsDictionary()) {
                        break;
                    } else if (b2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            c();
            if (c.f1487b == c.c) {
                buffer.f1462b = c.b();
                SegmentPool.a(c);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f1472a.timeout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f1472a = bufferedSource;
            this.f1473b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
}
