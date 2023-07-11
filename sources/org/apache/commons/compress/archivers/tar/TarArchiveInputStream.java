package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;
/* loaded from: classes.dex */
public class TarArchiveInputStream extends ArchiveInputStream {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final byte[] SMALL_BUF;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    private final ZipEncoding encoding;
    private long entryOffset;
    private long entrySize;
    private boolean hasHitEOF;
    private final InputStream is;
    private final int recordSize;

    public TarArchiveInputStream(InputStream inputStream) {
        this(inputStream, (int) TarConstants.DEFAULT_BLKSIZE, 512);
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("path".equals(key)) {
                this.currEntry.setName(value);
            } else if ("linkpath".equals(key)) {
                this.currEntry.setLinkName(value);
            } else if ("gid".equals(key)) {
                this.currEntry.setGroupId(Integer.parseInt(value));
            } else if ("gname".equals(key)) {
                this.currEntry.setGroupName(value);
            } else if ("uid".equals(key)) {
                this.currEntry.setUserId(Integer.parseInt(value));
            } else if ("uname".equals(key)) {
                this.currEntry.setUserName(value);
            } else if ("size".equals(key)) {
                this.currEntry.setSize(Long.parseLong(value));
            } else if ("mtime".equals(key)) {
                this.currEntry.setModTime((long) (Double.parseDouble(value) * 1000.0d));
            } else if ("SCHILY.devminor".equals(key)) {
                this.currEntry.setDevMinor(Integer.parseInt(value));
            } else if ("SCHILY.devmajor".equals(key)) {
                this.currEntry.setDevMajor(Integer.parseInt(value));
            }
        }
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long bytesRead = getBytesRead();
        int i = this.blockSize;
        long j = bytesRead % i;
        if (j > 0) {
            count(IOUtils.skip(this.is, i - j));
        }
    }

    private byte[] getRecord() throws IOException {
        byte[] readRecord = readRecord();
        this.hasHitEOF = isEOFRecord(readRecord);
        if (!this.hasHitEOF || readRecord == null) {
            return readRecord;
        }
        tryToConsumeSecondEOFRecord();
        consumeRemainderOfLastBlock();
        return null;
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < 265) {
            return false;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, TarConstants.MAGIC_OFFSET, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_POSIX, bArr, TarConstants.VERSION_OFFSET, 2)) {
            return true;
        }
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, TarConstants.MAGIC_OFFSET, 6) && (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_SPACE, bArr, TarConstants.VERSION_OFFSET, 2) || ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_ZERO, bArr, TarConstants.VERSION_OFFSET, 2))) {
            return true;
        }
        return ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, TarConstants.MAGIC_OFFSET, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_ANT, bArr, TarConstants.VERSION_OFFSET, 2);
    }

    private void paxHeaders() throws IOException {
        Map<String, String> parsePaxHeaders = parsePaxHeaders(this);
        getNextEntry();
        applyPaxHeadersToCurrentEntry(parsePaxHeaders);
    }

    private void readGNUSparse() throws IOException {
        byte[] record;
        if (this.currEntry.isExtended()) {
            do {
                record = getRecord();
                if (record == null) {
                    this.currEntry = null;
                    return;
                }
            } while (new TarArchiveSparseEntry(record).isExtended());
        }
    }

    private void skipRecordPadding() throws IOException {
        long j = this.entrySize;
        if (j > 0) {
            int i = this.recordSize;
            if (j % i != 0) {
                count(IOUtils.skip(this.is, (((j / i) + 1) * i) - j));
            }
        }
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean markSupported = this.is.markSupported();
        if (markSupported) {
            this.is.mark(this.recordSize);
        }
        try {
            if ((!isEOFRecord(readRecord())) && markSupported) {
            }
        } finally {
            if (markSupported) {
                pushedBackBytes(this.recordSize);
                this.is.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long j = this.entrySize;
        long j2 = this.entryOffset;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (archiveEntry instanceof TarArchiveEntry) {
            return !((TarArchiveEntry) archiveEntry).isGNUSparse();
        }
        return false;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.is.close();
    }

    public TarArchiveEntry getCurrentEntry() {
        return this.currEntry;
    }

    protected byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = read(this.SMALL_BUF);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(this.SMALL_BUF, 0, read);
        }
        getNextEntry();
        if (this.currEntry == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length != byteArray.length) {
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 0, bArr, 0, length);
            return bArr;
        }
        return byteArray;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextTarEntry();
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (this.hasHitEOF) {
            return null;
        }
        if (this.currEntry != null) {
            IOUtils.skip(this, Long.MAX_VALUE);
            skipRecordPadding();
        }
        byte[] record = getRecord();
        if (record == null) {
            this.currEntry = null;
            return null;
        }
        try {
            this.currEntry = new TarArchiveEntry(record, this.encoding);
            this.entryOffset = 0L;
            this.entrySize = this.currEntry.getSize();
            if (this.currEntry.isGNULongLinkEntry()) {
                byte[] longNameData = getLongNameData();
                if (longNameData == null) {
                    return null;
                }
                this.currEntry.setLinkName(this.encoding.decode(longNameData));
            }
            if (this.currEntry.isGNULongNameEntry()) {
                byte[] longNameData2 = getLongNameData();
                if (longNameData2 == null) {
                    return null;
                }
                this.currEntry.setName(this.encoding.decode(longNameData2));
            }
            if (this.currEntry.isPaxHeader()) {
                paxHeaders();
            }
            if (this.currEntry.isGNUSparse()) {
                readGNUSparse();
            }
            this.entrySize = this.currEntry.getSize();
            return this.currEntry;
        } catch (IllegalArgumentException e) {
            IOException iOException = new IOException("Error detected parsing the header");
            iOException.initCause(e);
            throw iOException;
        }
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    protected final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    protected boolean isEOFRecord(byte[] bArr) {
        return bArr == null || ArchiveUtils.isArrayZero(bArr, this.recordSize);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    Map<String, String> parsePaxHeaders(InputStream inputStream) throws IOException {
        int read;
        int read2;
        HashMap hashMap = new HashMap();
        do {
            int i = 0;
            int i2 = 0;
            while (true) {
                read = inputStream.read();
                if (read != -1) {
                    i++;
                    if (read == 32) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            read2 = inputStream.read();
                            if (read2 == -1) {
                                break;
                            }
                            i++;
                            if (read2 == 61) {
                                String byteArrayOutputStream2 = byteArrayOutputStream.toString(CharsetNames.UTF_8);
                                int i3 = i2 - i;
                                byte[] bArr = new byte[i3];
                                int readFully = IOUtils.readFully(inputStream, bArr);
                                if (readFully == i3) {
                                    hashMap.put(byteArrayOutputStream2, new String(bArr, 0, i3 - 1, CharsetNames.UTF_8));
                                } else {
                                    throw new IOException("Failed to read Paxheader. Expected " + i3 + " bytes, read " + readFully);
                                }
                            } else {
                                byteArrayOutputStream.write((byte) read2);
                            }
                        }
                        read = read2;
                        continue;
                    } else {
                        i2 = (i2 * 10) + (read - 48);
                    }
                }
            }
        } while (read != -1);
        return hashMap;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.hasHitEOF || this.entryOffset >= this.entrySize) {
            return -1;
        }
        if (this.currEntry != null) {
            int min = Math.min(i2, available());
            int read = this.is.read(bArr, i, min);
            if (read != -1) {
                count(read);
                this.entryOffset += read;
            } else if (min <= 0) {
                this.hasHitEOF = true;
            } else {
                throw new IOException("Truncated TAR archive");
            }
            return read;
        }
        throw new IllegalStateException("No current tar entry");
    }

    protected byte[] readRecord() throws IOException {
        byte[] bArr = new byte[this.recordSize];
        int readFully = IOUtils.readFully(this.is, bArr);
        count(readFully);
        if (readFully != this.recordSize) {
            return null;
        }
        return bArr;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    protected final void setAtEOF(boolean z) {
        this.hasHitEOF = z;
    }

    protected final void setCurrentEntry(TarArchiveEntry tarArchiveEntry) {
        this.currEntry = tarArchiveEntry;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        long skip = this.is.skip(Math.min(j, this.entrySize - this.entryOffset));
        count(skip);
        this.entryOffset += skip;
        return skip;
    }

    public TarArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, String str) {
        this(inputStream, i, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, null);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2, String str) {
        this.SMALL_BUF = new byte[256];
        this.is = inputStream;
        this.hasHitEOF = false;
        this.encoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordSize = i2;
        this.blockSize = i;
    }
}
