package org.apache.commons.compress.archivers.dump;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.apache.commons.compress.utils.IOUtils;
/* loaded from: classes.dex */
class TapeInputStream extends FilterInputStream {
    private static final int recordSize = 1024;
    private byte[] blockBuffer;
    private int blockSize;
    private long bytesRead;
    private int currBlkIdx;
    private boolean isCompressed;
    private int readOffset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.apache.commons.compress.archivers.dump.TapeInputStream$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE = new int[DumpArchiveConstants.COMPRESSION_TYPE.values().length];

        static {
            try {
                $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.ZLIB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.BZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.LZO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TapeInputStream(InputStream inputStream) {
        super(inputStream);
        this.blockBuffer = new byte[1024];
        this.currBlkIdx = -1;
        this.blockSize = 1024;
        this.readOffset = 1024;
        this.isCompressed = false;
        this.bytesRead = 0L;
    }

    private boolean readBlock(boolean z) throws IOException {
        boolean readFully;
        if (((FilterInputStream) this).in != null) {
            if (this.isCompressed && this.currBlkIdx != -1) {
                if (!readFully(this.blockBuffer, 0, 4)) {
                    return false;
                }
                this.bytesRead += 4;
                int convert32 = DumpArchiveUtil.convert32(this.blockBuffer, 0);
                if (!((convert32 & 1) == 1)) {
                    readFully = readFully(this.blockBuffer, 0, this.blockSize);
                    this.bytesRead += this.blockSize;
                } else {
                    int i = (convert32 >> 1) & 7;
                    int i2 = (convert32 >> 4) & 268435455;
                    byte[] bArr = new byte[i2];
                    boolean readFully2 = readFully(bArr, 0, i2);
                    this.bytesRead += i2;
                    if (!z) {
                        Arrays.fill(this.blockBuffer, (byte) 0);
                    } else {
                        int i3 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.find(i & 3).ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    throw new UnsupportedCompressionAlgorithmException();
                                }
                                throw new UnsupportedCompressionAlgorithmException("LZO");
                            }
                            throw new UnsupportedCompressionAlgorithmException("BZLIB2");
                        }
                        try {
                            Inflater inflater = new Inflater();
                            inflater.setInput(bArr, 0, bArr.length);
                            if (inflater.inflate(this.blockBuffer) == this.blockSize) {
                                inflater.end();
                            } else {
                                throw new ShortFileException();
                            }
                        } catch (DataFormatException e) {
                            throw new DumpArchiveException("bad data", e);
                        }
                    }
                    readFully = readFully2;
                }
            } else {
                readFully = readFully(this.blockBuffer, 0, this.blockSize);
                this.bytesRead += this.blockSize;
            }
            this.currBlkIdx++;
            this.readOffset = 0;
            return readFully;
        }
        throw new IOException("input buffer is closed");
    }

    private boolean readFully(byte[] bArr, int i, int i2) throws IOException {
        if (IOUtils.readFully(((FilterInputStream) this).in, bArr, i, i2) >= i2) {
            return true;
        }
        throw new ShortFileException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.readOffset;
        int i2 = this.blockSize;
        return i < i2 ? i2 - i : ((FilterInputStream) this).in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (((FilterInputStream) this).in == null || ((FilterInputStream) this).in == System.in) {
            return;
        }
        ((FilterInputStream) this).in.close();
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public byte[] peek() throws IOException {
        if (this.readOffset != this.blockSize || readBlock(true)) {
            byte[] bArr = new byte[1024];
            System.arraycopy(this.blockBuffer, this.readOffset, bArr, 0, bArr.length);
            return bArr;
        }
        return null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }

    public byte[] readRecord() throws IOException {
        byte[] bArr = new byte[1024];
        if (-1 != read(bArr, 0, bArr.length)) {
            return bArr;
        }
        throw new ShortFileException();
    }

    public void resetBlockSize(int i, boolean z) throws IOException {
        this.isCompressed = z;
        this.blockSize = i * 1024;
        byte[] bArr = this.blockBuffer;
        this.blockBuffer = new byte[this.blockSize];
        System.arraycopy(bArr, 0, this.blockBuffer, 0, 1024);
        readFully(this.blockBuffer, 1024, this.blockSize - 1024);
        this.currBlkIdx = 0;
        this.readOffset = 1024;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        if (j % PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID == 0) {
            while (j2 < j) {
                int i = this.readOffset;
                int i2 = this.blockSize;
                if (i == i2) {
                    if (!readBlock(j - j2 < ((long) i2))) {
                        return -1L;
                    }
                }
                int i3 = this.readOffset;
                long j3 = j - j2;
                int i4 = this.blockSize;
                if (i3 + j3 > i4) {
                    j3 = i4 - i3;
                }
                this.readOffset = (int) (this.readOffset + j3);
                j2 += j3;
            }
            return j2;
        }
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 % 1024 == 0) {
            int i3 = 0;
            while (i3 < i2) {
                if (this.readOffset == this.blockSize && !readBlock(true)) {
                    return -1;
                }
                int i4 = this.readOffset;
                int i5 = i2 - i3;
                int i6 = i4 + i5;
                int i7 = this.blockSize;
                if (i6 > i7) {
                    i5 = i7 - i4;
                }
                System.arraycopy(this.blockBuffer, this.readOffset, bArr, i, i5);
                this.readOffset += i5;
                i3 += i5;
                i += i5;
            }
            return i3;
        }
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }
}
