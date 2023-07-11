package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f1483a;

    /* renamed from: b  reason: collision with root package name */
    public final Source f1484b;
    private boolean c;

    public RealBufferedSource(Source source, Buffer buffer) {
        if (source != null) {
            this.f1483a = buffer;
            this.f1484b = source;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSource
    public byte[] c(long j) throws IOException {
        d(j);
        return this.f1483a.c(j);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f1484b.close();
        this.f1483a.l();
    }

    @Override // okio.BufferedSource
    public void d(long j) throws IOException {
        if (!a(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public ByteString e(long j) throws IOException {
        d(j);
        return this.f1483a.e(j);
    }

    @Override // okio.BufferedSource
    public byte[] f() throws IOException {
        this.f1483a.a(this.f1484b);
        return this.f1483a.f();
    }

    @Override // okio.BufferedSource
    public boolean g() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.f1483a.g() && this.f1484b.read(this.f1483a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1;
    }

    @Override // okio.BufferedSource
    public long h() throws IOException {
        byte f;
        d(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!a(i2)) {
                break;
            }
            f = this.f1483a.f(i);
            if ((f < 48 || f > 57) && !(i == 0 && f == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(f)));
        }
        return this.f1483a.h();
    }

    @Override // okio.BufferedSource
    public int i() throws IOException {
        d(4L);
        return this.f1483a.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long j() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.d(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L4a
            okio.Buffer r3 = r6.f1483a
            long r4 = (long) r1
            byte r3 = r3.f(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            okio.Buffer r0 = r6.f1483a
            long r0 = r0.j()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.j():long");
    }

    @Override // okio.BufferedSource
    public InputStream k() {
        return new InputStream() { // from class: okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (!RealBufferedSource.this.c) {
                    return (int) Math.min(RealBufferedSource.this.f1483a.c, 2147483647L);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (!RealBufferedSource.this.c) {
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.f1483a;
                    if (buffer.c == 0 && realBufferedSource.f1484b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.f1483a.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!RealBufferedSource.this.c) {
                    Util.a(bArr.length, i, i2);
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.f1483a;
                    if (buffer.c == 0 && realBufferedSource.f1484b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.f1483a.a(bArr, i, i2);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        if (buffer != null) {
            if (j >= 0) {
                if (!this.c) {
                    Buffer buffer2 = this.f1483a;
                    if (buffer2.c == 0 && this.f1484b.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                        return -1L;
                    }
                    return this.f1483a.read(buffer, Math.min(j, this.f1483a.c));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        d(1L);
        return this.f1483a.readByte();
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        d(4L);
        return this.f1483a.readInt();
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        d(2L);
        return this.f1483a.readShort();
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            Buffer buffer = this.f1483a;
            if (buffer.c == 0 && this.f1484b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f1483a.p());
            this.f1483a.skip(min);
            j -= min;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f1484b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f1484b + ")";
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer a() {
        return this.f1483a;
    }

    @Override // okio.BufferedSource
    public String d() throws IOException {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return this.f1483a.h(a2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.f1483a;
        buffer2.a(buffer, 0L, Math.min(32L, buffer2.p()));
        throw new EOFException("\\n not found: size=" + this.f1483a.p() + " content=" + buffer.n().hex() + "...");
    }

    public boolean a(long j) throws IOException {
        Buffer buffer;
        if (j >= 0) {
            if (!this.c) {
                do {
                    buffer = this.f1483a;
                    if (buffer.c >= j) {
                        return true;
                    }
                } while (this.f1484b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.BufferedSource
    public short e() throws IOException {
        d(2L);
        return this.f1483a.e();
    }

    public RealBufferedSource(Source source) {
        this(source, new Buffer());
    }

    @Override // okio.BufferedSource
    public long a(byte b2) throws IOException {
        return a(b2, 0L);
    }

    public long a(byte b2, long j) throws IOException {
        Buffer buffer;
        if (!this.c) {
            do {
                buffer = this.f1483a;
                if (j < buffer.c) {
                    while (true) {
                        long a2 = this.f1483a.a(b2, j);
                        if (a2 != -1) {
                            return a2;
                        }
                        Buffer buffer2 = this.f1483a;
                        long j2 = buffer2.c;
                        if (this.f1484b.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                            return -1L;
                        }
                        j = j2;
                    }
                }
            } while (this.f1484b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
            return -1L;
        }
        throw new IllegalStateException("closed");
    }
}
