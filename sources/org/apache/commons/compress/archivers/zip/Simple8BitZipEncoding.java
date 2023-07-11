package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Simple8BitZipEncoding implements ZipEncoding {
    private final char[] highChars;
    private final List<Simple8BitChar> reverseMapping;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Simple8BitChar implements Comparable<Simple8BitChar> {
        public final byte code;
        public final char unicode;

        Simple8BitChar(byte b2, char c) {
            this.code = b2;
            this.unicode = c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Simple8BitChar) {
                Simple8BitChar simple8BitChar = (Simple8BitChar) obj;
                return this.unicode == simple8BitChar.unicode && this.code == simple8BitChar.code;
            }
            return false;
        }

        public int hashCode() {
            return this.unicode;
        }

        public String toString() {
            return "0x" + Integer.toHexString(this.unicode & 65535) + "->0x" + Integer.toHexString(this.code & 255);
        }

        @Override // java.lang.Comparable
        public int compareTo(Simple8BitChar simple8BitChar) {
            return this.unicode - simple8BitChar.unicode;
        }
    }

    public Simple8BitZipEncoding(char[] cArr) {
        this.highChars = (char[]) cArr.clone();
        ArrayList arrayList = new ArrayList(this.highChars.length);
        byte b2 = Byte.MAX_VALUE;
        for (char c : this.highChars) {
            b2 = (byte) (b2 + 1);
            arrayList.add(new Simple8BitChar(b2, c));
        }
        Collections.sort(arrayList);
        this.reverseMapping = Collections.unmodifiableList(arrayList);
    }

    private Simple8BitChar encodeHighChar(char c) {
        int size = this.reverseMapping.size();
        int i = 0;
        while (size > i) {
            int i2 = ((size - i) / 2) + i;
            Simple8BitChar simple8BitChar = this.reverseMapping.get(i2);
            char c2 = simple8BitChar.unicode;
            if (c2 == c) {
                return simple8BitChar;
            }
            if (c2 < c) {
                i = i2 + 1;
            } else {
                size = i2;
            }
        }
        if (i >= this.reverseMapping.size()) {
            return null;
        }
        Simple8BitChar simple8BitChar2 = this.reverseMapping.get(i);
        if (simple8BitChar2.unicode != c) {
            return null;
        }
        return simple8BitChar2;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public boolean canEncode(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!canEncodeChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean canEncodeChar(char c) {
        return (c >= 0 && c < 128) || encodeHighChar(c) != null;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public String decode(byte[] bArr) throws IOException {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = decodeByte(bArr[i]);
        }
        return new String(cArr);
    }

    public char decodeByte(byte b2) {
        return b2 >= 0 ? (char) b2 : this.highChars[b2 + 128];
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public ByteBuffer encode(String str) {
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + 6 + ((str.length() + 1) / 2));
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (allocate.remaining() < 6) {
                allocate = ZipEncodingHelper.growBuffer(allocate, allocate.position() + 6);
            }
            if (!pushEncodedChar(allocate, charAt)) {
                ZipEncodingHelper.appendSurrogate(allocate, charAt);
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }

    public boolean pushEncodedChar(ByteBuffer byteBuffer, char c) {
        if (c >= 0 && c < 128) {
            byteBuffer.put((byte) c);
            return true;
        }
        Simple8BitChar encodeHighChar = encodeHighChar(c);
        if (encodeHighChar == null) {
            return false;
        }
        byteBuffer.put(encodeHighChar.code);
        return true;
    }
}
