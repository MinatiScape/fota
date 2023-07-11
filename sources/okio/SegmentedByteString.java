package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Util.a(buffer.c, 0L, i);
        int i2 = 0;
        Segment segment = buffer.f1462b;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.c;
            int i6 = segment.f1487b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i4];
        this.directory = new int[i4 * 2];
        Segment segment2 = buffer.f1462b;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.segments;
            bArr[i7] = segment2.f1486a;
            int i8 = segment2.c;
            int i9 = segment2.f1487b;
            i2 += i8 - i9;
            int[] iArr = this.directory;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            segment2.d = true;
            i7++;
            segment2 = segment2.f;
        }
    }

    private int a(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    private Object writeReplace() {
        return a();
    }

    @Override // okio.ByteString
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public byte getByte(int i) {
        Util.a(this.directory[this.segments.length - 1], i, 1L);
        int a2 = a(i);
        int i2 = a2 == 0 ? 0 : this.directory[a2 - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[a2][(i - i2) + iArr[bArr.length + a2]];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return a().md5();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i > size() - i3) {
            return false;
        }
        int a2 = a(i);
        while (i3 > 0) {
            int i4 = a2 == 0 ? 0 : this.directory[a2 - 1];
            int min = Math.min(i3, ((this.directory[a2] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[a2], (i - i4) + iArr[bArr.length + a2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a2++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return a().sha256();
    }

    @Override // okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public ByteString substring(int i) {
        return a().substring(i);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public String toString() {
        return a().toString();
    }

    @Override // okio.ByteString
    public String utf8() {
        return a().utf8();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.directory;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                outputStream.write(this.segments[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    private ByteString a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        return a().substring(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // okio.ByteString
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment segment = new Segment(this.segments[i], i3, (i3 + i4) - i2);
            Segment segment2 = buffer.f1462b;
            if (segment2 == null) {
                segment.g = segment;
                segment.f = segment;
                buffer.f1462b = segment;
            } else {
                segment2.g.a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.c += i2;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i > size() - i3 || i2 > bArr.length - i3) {
            return false;
        }
        int a2 = a(i);
        while (i3 > 0) {
            int i4 = a2 == 0 ? 0 : this.directory[a2 - 1];
            int min = Math.min(i3, ((this.directory[a2] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.a(bArr2[a2], (i - i4) + iArr[bArr2.length + a2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a2++;
        }
        return true;
    }
}
