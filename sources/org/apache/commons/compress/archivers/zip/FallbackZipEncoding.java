package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class FallbackZipEncoding implements ZipEncoding {
    private final String charsetName;

    public FallbackZipEncoding() {
        this.charsetName = null;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public boolean canEncode(String str) {
        return true;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public String decode(byte[] bArr) throws IOException {
        String str = this.charsetName;
        if (str == null) {
            return new String(bArr);
        }
        return new String(bArr, str);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public ByteBuffer encode(String str) throws IOException {
        String str2 = this.charsetName;
        if (str2 == null) {
            return ByteBuffer.wrap(str.getBytes());
        }
        return ByteBuffer.wrap(str.getBytes(str2));
    }

    public FallbackZipEncoding(String str) {
        this.charsetName = str;
    }
}
