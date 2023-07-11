package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes.dex */
public final class GzipSource implements Source {

    /* renamed from: b  reason: collision with root package name */
    private final BufferedSource f1471b;
    private final Inflater c;
    private final InflaterSource d;

    /* renamed from: a  reason: collision with root package name */
    private int f1470a = 0;
    private final CRC32 e = new CRC32();

    public GzipSource(Source source) {
        if (source != null) {
            this.c = new Inflater(true);
            this.f1471b = Okio.a(source);
            this.d = new InflaterSource(this.f1471b, this.c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(Buffer buffer, long j, long j2) {
        int i;
        Segment segment = buffer.f1462b;
        while (true) {
            int i2 = segment.c;
            int i3 = segment.f1487b;
            if (j < i2 - i3) {
                break;
            }
            j -= i2 - i3;
            segment = segment.f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.c - i, j2);
            this.e.update(segment.f1486a, (int) (segment.f1487b + j), min);
            j2 -= min;
            segment = segment.f;
            j = 0;
        }
    }

    private void b() throws IOException {
        this.f1471b.d(10L);
        byte f = this.f1471b.a().f(3L);
        boolean z = ((f >> 1) & 1) == 1;
        if (z) {
            a(this.f1471b.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f1471b.readShort());
        this.f1471b.skip(8L);
        if (((f >> 2) & 1) == 1) {
            this.f1471b.d(2L);
            if (z) {
                a(this.f1471b.a(), 0L, 2L);
            }
            long e = this.f1471b.a().e();
            this.f1471b.d(e);
            if (z) {
                a(this.f1471b.a(), 0L, e);
            }
            this.f1471b.skip(e);
        }
        if (((f >> 3) & 1) == 1) {
            long a2 = this.f1471b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f1471b.a(), 0L, a2 + 1);
                }
                this.f1471b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((f >> 4) & 1) == 1) {
            long a3 = this.f1471b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f1471b.a(), 0L, a3 + 1);
                }
                this.f1471b.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.f1471b.e(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.f1471b.i(), (int) this.e.getValue());
        a("ISIZE", this.f1471b.i(), this.c.getTotalOut());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0L;
        } else {
            if (this.f1470a == 0) {
                b();
                this.f1470a = 1;
            }
            if (this.f1470a == 1) {
                long j2 = buffer.c;
                long read = this.d.read(buffer, j);
                if (read != -1) {
                    a(buffer, j2, read);
                    return read;
                }
                this.f1470a = 2;
            }
            if (this.f1470a == 2) {
                c();
                this.f1470a = 3;
                if (!this.f1471b.g()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f1471b.timeout();
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
