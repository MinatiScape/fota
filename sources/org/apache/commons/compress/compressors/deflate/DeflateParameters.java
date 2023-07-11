package org.apache.commons.compress.compressors.deflate;
/* loaded from: classes.dex */
public class DeflateParameters {
    private boolean zlibHeader = true;
    private int compressionLevel = -1;

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i >= -1 && i <= 9) {
            this.compressionLevel = i;
            return;
        }
        throw new IllegalArgumentException("Invalid Deflate compression level: " + i);
    }

    public void setWithZlibHeader(boolean z) {
        this.zlibHeader = z;
    }

    public boolean withZlibHeader() {
        return this.zlibHeader;
    }
}
