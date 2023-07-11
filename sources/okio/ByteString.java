package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString EMPTY = of(new byte[0]);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    private ByteString a(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static ByteString decodeBase64(String str) {
        if (str != null) {
            byte[] a2 = Base64.a(str);
            if (a2 != null) {
                return new ByteString(a2);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public static ByteString decodeHex(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                byte[] bArr = new byte[str.length() / 2];
                for (int i = 0; i < bArr.length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
                }
                return of(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    public static ByteString encodeUtf8(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(Util.f1490a));
            byteString.utf8 = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        if (inputStream != null) {
            if (i >= 0) {
                byte[] bArr = new byte[i];
                int i2 = 0;
                while (i2 < i) {
                    int read = inputStream.read(bArr, i2, i - i2);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    i2 += read;
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        throw new IllegalArgumentException("in == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public String base64() {
        return Base64.a(this.data);
    }

    public String base64Url() {
        return Base64.b(this.data);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.data;
            if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.hashCode = hashCode;
        return hashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public ByteString md5() {
        return a("MD5");
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.data, i, i3);
    }

    public ByteString sha256() {
        return a("SHA-256");
    }

    public int size() {
        return this.data.length;
    }

    public ByteString substring(int i) {
        return substring(i, this.data.length);
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i++;
        }
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 97 && b2 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr2[i2] = (byte) (b3 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i++;
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        byte[] bArr = this.data;
        return bArr.length == 0 ? "ByteString[size=0]" : bArr.length <= 16 ? String.format("ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), hex()) : String.format("ByteString[size=%s md5=%s]", Integer.valueOf(bArr.length), md5().hex());
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, Util.f1490a);
        this.utf8 = str2;
        return str2;
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.data);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = getByte(i) & 255;
            int i3 = byteString.getByte(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.data;
        return i <= bArr2.length - i3 && i2 <= bArr.length - i3 && Util.a(bArr2, i, bArr, i2, i3);
    }

    public ByteString substring(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.data;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(this.data, i, bArr2, 0, i3);
                return new ByteString(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    private static int a(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c);
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            Util.a(bArr.length, i, i2);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new ByteString(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        byte[] bArr = this.data;
        buffer.write(bArr, 0, bArr.length);
    }
}
