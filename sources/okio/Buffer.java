package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;
/* loaded from: classes.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1461a = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b  reason: collision with root package name */
    Segment f1462b;
    long c;

    /* renamed from: okio.Buffer$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Buffer f1463a;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.f1463a.writeByte((int) ((byte) i));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f1463a.write(bArr, i, i2);
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer a() {
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink b() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer c() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.BufferedSource
    public void d(long j) throws EOFException {
        if (this.c < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public short e() {
        return Util.a(readShort());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.c;
            if (j != buffer.c) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.f1462b;
            Segment segment2 = buffer.f1462b;
            int i = segment.f1487b;
            int i2 = segment2.f1487b;
            while (j2 < this.c) {
                long min = Math.min(segment.c - i, segment2.c - i2);
                int i3 = i2;
                int i4 = i;
                int i5 = 0;
                while (i5 < min) {
                    int i6 = i4 + 1;
                    int i7 = i3 + 1;
                    if (segment.f1486a[i4] != segment2.f1486a[i3]) {
                        return false;
                    }
                    i5++;
                    i4 = i6;
                    i3 = i7;
                }
                if (i4 == segment.c) {
                    segment = segment.f;
                    i = segment.f1487b;
                } else {
                    i = i4;
                }
                if (i3 == segment2.c) {
                    segment2 = segment2.f;
                    i2 = segment2.f1487b;
                } else {
                    i2 = i3;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public byte f(long j) {
        Util.a(this.c, j, 1L);
        Segment segment = this.f1462b;
        while (true) {
            int i = segment.c;
            int i2 = segment.f1487b;
            long j2 = i - i2;
            if (j < j2) {
                return segment.f1486a[i2 + ((int) j)];
            }
            j -= j2;
            segment = segment.f;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource
    public boolean g() {
        return this.c == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae A[EDGE_INSN: B:47:0x00ae->B:39:0x00ae ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long h() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lb9
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L10:
            okio.Segment r10 = r0.f1462b
            byte[] r11 = r10.f1486a
            int r12 = r10.f1487b
            int r13 = r10.c
        L18:
            if (r12 >= r13) goto L9a
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6c
            r1 = 57
            if (r15 > r1) goto L6c
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L38
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L76
        L3f:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.a(r3)
            okio.Buffer r1 = r1.writeByte(r15)
            if (r5 != 0) goto L51
            r1.readByte()
        L51:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.o()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6c:
            r1 = 45
            if (r15 != r1) goto L7b
            if (r7 != 0) goto L7b
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L76:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L18
        L7b:
            if (r7 == 0) goto L7f
            r6 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9a:
            if (r12 != r13) goto La6
            okio.Segment r1 = r10.b()
            r0.f1462b = r1
            okio.SegmentPool.a(r10)
            goto La8
        La6:
            r10.f1487b = r12
        La8:
            if (r6 != 0) goto Lae
            okio.Segment r1 = r0.f1462b
            if (r1 != 0) goto L10
        Lae:
            long r1 = r0.c
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.c = r1
            if (r5 == 0) goto Lb7
            goto Lb8
        Lb7:
            long r3 = -r3
        Lb8:
            return r3
        Lb9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto Lc2
        Lc1:
            throw r1
        Lc2:
            goto Lc1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.h():long");
    }

    public int hashCode() {
        Segment segment = this.f1462b;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.c;
            for (int i3 = segment.f1487b; i3 < i2; i3++) {
                i = (i * 31) + segment.f1486a[i3];
            }
            segment = segment.f;
        } while (segment != this.f1462b);
        return i;
    }

    @Override // okio.BufferedSource
    public int i() {
        return Util.a(readInt());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[EDGE_INSN: B:43:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long j() {
        /*
            r15 = this;
            long r0 = r15.c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.Segment r6 = r15.f1462b
            byte[] r7 = r6.f1486a
            int r8 = r6.f1487b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.b(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.o()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r1 == 0) goto L76
            r0 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            okio.Segment r7 = r6.b()
            r15.f1462b = r7
            okio.SegmentPool.a(r6)
            goto L9f
        L9d:
            r6.f1487b = r8
        L9f:
            if (r0 != 0) goto La5
            okio.Segment r6 = r15.f1462b
            if (r6 != 0) goto Lb
        La5:
            long r2 = r15.c
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.c = r2
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb5
        Lb4:
            throw r0
        Lb5:
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.j():long");
    }

    @Override // okio.BufferedSource
    public InputStream k() {
        return new InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.c, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.c > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.a(bArr, i, i2);
            }
        };
    }

    public void l() {
        try {
            skip(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public long m() {
        long j = this.c;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.f1462b.g;
        int i = segment.c;
        return (i >= 2048 || !segment.e) ? j : j - (i - segment.f1487b);
    }

    public ByteString n() {
        return new ByteString(f());
    }

    public String o() {
        try {
            return a(this.c, Util.f1490a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public long p() {
        return this.c;
    }

    public ByteString q() {
        long j = this.c;
        if (j <= 2147483647L) {
            return b((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.c);
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer != null) {
            if (j >= 0) {
                long j2 = this.c;
                if (j2 == 0) {
                    return -1L;
                }
                if (j > j2) {
                    j = j2;
                }
                buffer.write(this, j);
                return j;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.c;
        if (j != 0) {
            Segment segment = this.f1462b;
            int i = segment.f1487b;
            int i2 = segment.c;
            int i3 = i + 1;
            byte b2 = segment.f1486a[i];
            this.c = j - 1;
            if (i3 == i2) {
                this.f1462b = segment.b();
                SegmentPool.a(segment);
            } else {
                segment.f1487b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.c;
        if (j >= 4) {
            Segment segment = this.f1462b;
            int i = segment.f1487b;
            int i2 = segment.c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.f1486a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.c = j - 4;
            if (i8 == i2) {
                this.f1462b = segment.b();
                SegmentPool.a(segment);
            } else {
                segment.f1487b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.c);
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.c;
        if (j >= 2) {
            Segment segment = this.f1462b;
            int i = segment.f1487b;
            int i2 = segment.c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.f1486a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.c = j - 2;
            if (i4 == i2) {
                this.f1462b = segment.b();
                SegmentPool.a(segment);
            } else {
                segment.f1487b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.c);
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        Segment segment;
        while (j > 0) {
            if (this.f1462b != null) {
                int min = (int) Math.min(j, segment.c - segment.f1487b);
                long j2 = min;
                this.c -= j2;
                j -= j2;
                Segment segment2 = this.f1462b;
                segment2.f1487b += min;
                if (segment2.f1487b == segment2.c) {
                    this.f1462b = segment2.b();
                    SegmentPool.a(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        long j = this.c;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.c), clone().n().hex());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f1462b.f1486a, this.f1462b.f1487b, this.f1462b.c - this.f1462b.f1487b);
            Segment segment = this.f1462b;
            while (true) {
                segment = segment.f;
                if (segment != this.f1462b) {
                    messageDigest.update(segment.f1486a, segment.f1487b, segment.c - segment.f1487b);
                } else {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.c), ByteString.of(messageDigest.digest()).hex());
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // okio.BufferedSink
    public Buffer b(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment c = c(numberOfTrailingZeros);
        byte[] bArr = c.f1486a;
        int i = c.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f1461a[(int) (15 & j)];
            j >>>= 4;
        }
        c.c += numberOfTrailingZeros;
        this.c += numberOfTrailingZeros;
        return this;
    }

    @Override // okio.BufferedSource
    public byte[] c(long j) throws EOFException {
        Util.a(this.c, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.c == 0) {
            return buffer;
        }
        buffer.f1462b = new Segment(this.f1462b);
        Segment segment = buffer.f1462b;
        segment.g = segment;
        segment.f = segment;
        Segment segment2 = this.f1462b;
        while (true) {
            segment2 = segment2.f;
            if (segment2 != this.f1462b) {
                buffer.f1462b.g.a(new Segment(segment2));
            } else {
                buffer.c = this.c;
                return buffer;
            }
        }
    }

    @Override // okio.BufferedSource
    public String d() throws EOFException {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return h(a2);
        }
        Buffer buffer = new Buffer();
        a(buffer, 0L, Math.min(32L, this.c));
        throw new EOFException("\\n not found: size=" + p() + " content=" + buffer.n().hex() + "...");
    }

    @Override // okio.BufferedSource
    public ByteString e(long j) throws EOFException {
        return new ByteString(c(j));
    }

    public String g(long j) throws EOFException {
        return a(j, Util.f1490a);
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment c = c(1);
        byte[] bArr = c.f1486a;
        int i2 = c.c;
        c.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.c++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment c = c(4);
        byte[] bArr = c.f1486a;
        int i2 = c.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        c.c = i5 + 1;
        this.c += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment c = c(2);
        byte[] bArr = c.f1486a;
        int i2 = c.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        c.c = i3 + 1;
        this.c += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer a(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            Util.a(this.c, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.c += j2;
            Segment segment = this.f1462b;
            while (true) {
                int i = segment.c;
                int i2 = segment.f1487b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                segment = segment.f;
            }
            while (j2 > 0) {
                Segment segment2 = new Segment(segment);
                segment2.f1487b = (int) (segment2.f1487b + j);
                segment2.c = Math.min(segment2.f1487b + ((int) j2), segment2.c);
                Segment segment3 = buffer.f1462b;
                if (segment3 == null) {
                    segment2.g = segment2;
                    segment2.f = segment2;
                    buffer.f1462b = segment2;
                } else {
                    segment3.g.a(segment2);
                }
                j2 -= segment2.c - segment2.f1487b;
                segment = segment.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            Util.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment c = c(1);
                int min = Math.min(i3 - i, 2048 - c.c);
                System.arraycopy(bArr, i, c.f1486a, c.c, min);
                i += min;
                c.c += min;
            }
            this.c += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment c(int i) {
        if (i >= 1 && i <= 2048) {
            Segment segment = this.f1462b;
            if (segment == null) {
                this.f1462b = SegmentPool.a();
                Segment segment2 = this.f1462b;
                segment2.g = segment2;
                segment2.f = segment2;
                return segment2;
            }
            Segment segment3 = segment.g;
            return (segment3.c + i > 2048 || !segment3.e) ? segment3.a(SegmentPool.a()) : segment3;
        }
        throw new IllegalArgumentException();
    }

    @Override // okio.BufferedSource
    public byte[] f() {
        try {
            return c(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public Buffer d(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | CpioConstants.C_IWUSR);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            writeByte((i >> 12) | 224);
            writeByte(((i >> 6) & 63) | CpioConstants.C_IWUSR);
            writeByte((i & 63) | CpioConstants.C_IWUSR);
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | CpioConstants.C_IWUSR);
            writeByte(((i >> 6) & 63) | CpioConstants.C_IWUSR);
            writeByte((i & 63) | CpioConstants.C_IWUSR);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public ByteString b(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            Util.a(buffer.c, 0L, j);
            while (j > 0) {
                Segment segment = buffer.f1462b;
                if (j < segment.c - segment.f1487b) {
                    Segment segment2 = this.f1462b;
                    Segment segment3 = segment2 != null ? segment2.g : null;
                    if (segment3 != null && segment3.e) {
                        if ((segment3.c + j) - (segment3.d ? 0 : segment3.f1487b) <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            buffer.f1462b.a(segment3, (int) j);
                            buffer.c -= j;
                            this.c += j;
                            return;
                        }
                    }
                    buffer.f1462b = buffer.f1462b.a((int) j);
                }
                Segment segment4 = buffer.f1462b;
                long j2 = segment4.c - segment4.f1487b;
                buffer.f1462b = segment4.b();
                Segment segment5 = this.f1462b;
                if (segment5 == null) {
                    this.f1462b = segment4;
                    Segment segment6 = this.f1462b;
                    segment6.g = segment6;
                    segment6.f = segment6;
                } else {
                    segment5.g.a(segment4).a();
                }
                buffer.c -= j2;
                this.c += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public String a(long j, Charset charset) throws EOFException {
        Util.a(this.c, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.f1462b;
                int i = segment.f1487b;
                if (i + j > segment.c) {
                    return new String(c(j), charset);
                }
                String str = new String(segment.f1486a, i, (int) j, charset);
                segment.f1487b = (int) (segment.f1487b + j);
                this.c -= j;
                if (segment.f1487b == segment.c) {
                    this.f1462b = segment.b();
                    SegmentPool.a(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (f(j2) == 13) {
                String g = g(j2);
                skip(2L);
                return g;
            }
        }
        String g2 = g(j);
        skip(1L);
        return g2;
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        Util.a(bArr.length, i, i2);
        Segment segment = this.f1462b;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.c - segment.f1487b);
        System.arraycopy(segment.f1486a, segment.f1487b, bArr, i, min);
        segment.f1487b += min;
        this.c -= min;
        if (segment.f1487b == segment.c) {
            this.f1462b = segment.b();
            SegmentPool.a(segment);
        }
        return min;
    }

    @Override // okio.BufferedSink
    public Buffer a(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.BufferedSink
    public Buffer a(String str) {
        return a(str, 0, str.length());
    }

    public Buffer a(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                }
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        Segment c = c(1);
                        byte[] bArr = c.f1486a;
                        int i3 = c.c - i;
                        int min = Math.min(i2, 2048 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = c.c;
                        int i6 = (i3 + i4) - i5;
                        c.c = i5 + i6;
                        this.c += i6;
                        i = i4;
                    } else {
                        if (charAt < 2048) {
                            writeByte((charAt >> 6) | 192);
                            writeByte((charAt & '?') | CpioConstants.C_IWUSR);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i7 = i + 1;
                            char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i8 >> 18) | 240);
                                writeByte(((i8 >> 12) & 63) | CpioConstants.C_IWUSR);
                                writeByte(((i8 >> 6) & 63) | CpioConstants.C_IWUSR);
                                writeByte((i8 & 63) | CpioConstants.C_IWUSR);
                                i += 2;
                            } else {
                                writeByte(63);
                                i = i7;
                            }
                        } else {
                            writeByte((charAt >> '\f') | 224);
                            writeByte(((charAt >> 6) & 63) | CpioConstants.C_IWUSR);
                            writeByte((charAt & '?') | CpioConstants.C_IWUSR);
                        }
                        i++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public Buffer a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public Buffer a(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(Util.f1490a)) {
                            return a(str);
                        }
                        byte[] bytes = str.substring(i, i2).getBytes(charset);
                        return write(bytes, 0, bytes.length);
                    }
                    throw new IllegalArgumentException("charset == null");
                }
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // okio.BufferedSink
    public long a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.BufferedSink
    public Buffer a(int i) {
        return writeInt(Util.a(i));
    }

    @Override // okio.BufferedSink
    public Buffer a(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return a("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment c = c(i);
        byte[] bArr = c.f1486a;
        int i2 = c.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f1461a[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        c.c += i;
        this.c += i;
        return this;
    }

    @Override // okio.BufferedSource
    public long a(byte b2) {
        return a(b2, 0L);
    }

    public long a(byte b2, long j) {
        long j2;
        if (j >= 0) {
            Segment segment = this.f1462b;
            if (segment == null) {
                return -1L;
            }
            long j3 = j;
            long j4 = 0;
            while (true) {
                int i = segment.c;
                int i2 = segment.f1487b;
                long j5 = i - i2;
                if (j3 >= j5) {
                    j2 = j3 - j5;
                } else {
                    byte[] bArr = segment.f1486a;
                    for (int i3 = (int) (i2 + j3); i3 < i; i3++) {
                        if (bArr[i3] == b2) {
                            return (j4 + i3) - segment.f1487b;
                        }
                    }
                    j2 = 0;
                }
                j4 += j5;
                segment = segment.f;
                if (segment == this.f1462b) {
                    return -1L;
                }
                j3 = j2;
            }
        } else {
            throw new IllegalArgumentException("fromIndex < 0");
        }
    }
}
