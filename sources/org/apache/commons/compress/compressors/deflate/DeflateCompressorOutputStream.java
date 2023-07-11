package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
/* loaded from: classes.dex */
public class DeflateCompressorOutputStream extends CompressorOutputStream {
    private final DeflaterOutputStream out;

    public DeflateCompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, new DeflateParameters());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    public void finish() throws IOException {
        this.out.finish();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public DeflateCompressorOutputStream(OutputStream outputStream, DeflateParameters deflateParameters) throws IOException {
        this.out = new DeflaterOutputStream(outputStream, new Deflater(deflateParameters.getCompressionLevel(), !deflateParameters.withZlibHeader()));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }
}
