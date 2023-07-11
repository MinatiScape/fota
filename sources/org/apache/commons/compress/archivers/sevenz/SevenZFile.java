package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;
/* loaded from: classes.dex */
public class SevenZFile implements Closeable {
    static final int SIGNATURE_HEADER_SIZE = 32;
    static final byte[] sevenZSignature = {TarConstants.LF_CONTIG, 122, -68, -81, 39, 28};
    private final Archive archive;
    private int currentEntryIndex;
    private InputStream currentEntryInputStream;
    private int currentFolderIndex;
    private InputStream currentFolderInputStream;
    private RandomAccessFile file;
    private byte[] password;

    public SevenZFile(File file, byte[] bArr) throws IOException {
        this.currentEntryIndex = -1;
        this.currentFolderIndex = -1;
        this.currentFolderInputStream = null;
        this.currentEntryInputStream = null;
        this.file = new RandomAccessFile(file, "r");
        try {
            this.archive = readHeaders(bArr);
            if (bArr != null) {
                this.password = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.password, 0, bArr.length);
                return;
            }
            this.password = null;
        } catch (Throwable th) {
            this.file.close();
            throw th;
        }
    }

    private InputStream buildDecoderStack(Folder folder, long j, int i, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        this.file.seek(j);
        BoundedRandomAccessFileInputStream boundedRandomAccessFileInputStream = new BoundedRandomAccessFileInputStream(this.file, this.archive.packSizes[i]);
        LinkedList linkedList = new LinkedList();
        InputStream inputStream = boundedRandomAccessFileInputStream;
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams == 1 && coder.numOutStreams == 1) {
                SevenZMethod byId = SevenZMethod.byId(coder.decompressionMethodId);
                inputStream = Coders.addDecoder(inputStream, folder.getUnpackSizeForCoder(coder), coder, this.password);
                linkedList.addFirst(new SevenZMethodConfiguration(byId, Coders.findByMethod(byId).getOptionsFromCoder(coder, inputStream)));
            } else {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
        }
        sevenZArchiveEntry.setContentMethods(linkedList);
        return folder.hasCrc ? new CRC32VerifyingInputStream(inputStream, folder.getUnpackSize(), folder.crc) : inputStream;
    }

    private void buildDecodingStream() throws IOException {
        Archive archive = this.archive;
        int[] iArr = archive.streamMap.fileFolderIndex;
        int i = this.currentEntryIndex;
        int i2 = iArr[i];
        if (i2 < 0) {
            this.currentEntryInputStream = new BoundedInputStream(new ByteArrayInputStream(new byte[0]), 0L);
            return;
        }
        SevenZArchiveEntry sevenZArchiveEntry = archive.files[i];
        if (this.currentFolderIndex == i2) {
            drainPreviousEntry();
            sevenZArchiveEntry.setContentMethods(this.archive.files[this.currentEntryIndex - 1].getContentMethods());
        } else {
            this.currentFolderIndex = i2;
            InputStream inputStream = this.currentFolderInputStream;
            if (inputStream != null) {
                inputStream.close();
                this.currentFolderInputStream = null;
            }
            Archive archive2 = this.archive;
            Folder folder = archive2.folders[i2];
            StreamMap streamMap = archive2.streamMap;
            int i3 = streamMap.folderFirstPackStreamIndex[i2];
            this.currentFolderInputStream = buildDecoderStack(folder, streamMap.packStreamOffsets[i3] + archive2.packPos + 32, i3, sevenZArchiveEntry);
        }
        BoundedInputStream boundedInputStream = new BoundedInputStream(this.currentFolderInputStream, sevenZArchiveEntry.getSize());
        if (sevenZArchiveEntry.getHasCrc()) {
            this.currentEntryInputStream = new CRC32VerifyingInputStream(boundedInputStream, sevenZArchiveEntry.getSize(), sevenZArchiveEntry.getCrcValue());
        } else {
            this.currentEntryInputStream = boundedInputStream;
        }
    }

    private void calculateStreamMap(Archive archive) throws IOException {
        StreamMap streamMap = new StreamMap();
        Folder[] folderArr = archive.folders;
        int length = folderArr != null ? folderArr.length : 0;
        streamMap.folderFirstPackStreamIndex = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            streamMap.folderFirstPackStreamIndex[i2] = i;
            i += archive.folders[i2].packedStreams.length;
        }
        long[] jArr = archive.packSizes;
        int length2 = jArr != null ? jArr.length : 0;
        streamMap.packStreamOffsets = new long[length2];
        long j = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            streamMap.packStreamOffsets[i3] = j;
            j += archive.packSizes[i3];
        }
        streamMap.folderFirstFileIndex = new int[length];
        streamMap.fileFolderIndex = new int[archive.files.length];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            SevenZArchiveEntry[] sevenZArchiveEntryArr = archive.files;
            if (i4 < sevenZArchiveEntryArr.length) {
                if (!sevenZArchiveEntryArr[i4].hasStream() && i5 == 0) {
                    streamMap.fileFolderIndex[i4] = -1;
                } else {
                    if (i5 == 0) {
                        while (true) {
                            Folder[] folderArr2 = archive.folders;
                            if (i6 >= folderArr2.length) {
                                break;
                            }
                            streamMap.folderFirstFileIndex[i6] = i4;
                            if (folderArr2[i6].numUnpackSubStreams > 0) {
                                break;
                            }
                            i6++;
                        }
                        if (i6 >= archive.folders.length) {
                            throw new IOException("Too few folders in archive");
                        }
                    }
                    streamMap.fileFolderIndex[i4] = i6;
                    if (archive.files[i4].hasStream() && (i5 = i5 + 1) >= archive.folders[i6].numUnpackSubStreams) {
                        i6++;
                        i5 = 0;
                    }
                }
                i4++;
            } else {
                archive.streamMap = streamMap;
                return;
            }
        }
    }

    private void drainPreviousEntry() throws IOException {
        InputStream inputStream = this.currentEntryInputStream;
        if (inputStream != null) {
            IOUtils.skip(inputStream, Long.MAX_VALUE);
            this.currentEntryInputStream.close();
            this.currentEntryInputStream = null;
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < sevenZSignature.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = sevenZSignature;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private BitSet readAllOrBits(DataInput dataInput, int i) throws IOException {
        if (dataInput.readUnsignedByte() != 0) {
            BitSet bitSet = new BitSet(i);
            for (int i2 = 0; i2 < i; i2++) {
                bitSet.set(i2, true);
            }
            return bitSet;
        }
        return readBits(dataInput, i);
    }

    private void readArchiveProperties(DataInput dataInput) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        while (readUnsignedByte != 0) {
            dataInput.readFully(new byte[(int) readUint64(dataInput)]);
            readUnsignedByte = dataInput.readUnsignedByte();
        }
    }

    private BitSet readBits(DataInput dataInput, int i) throws IOException {
        BitSet bitSet = new BitSet(i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 == 0) {
                i2 = CpioConstants.C_IWUSR;
                i3 = dataInput.readUnsignedByte();
            }
            bitSet.set(i4, (i3 & i2) != 0);
            i2 >>>= 1;
        }
        return bitSet;
    }

    private DataInputStream readEncodedHeader(DataInputStream dataInputStream, Archive archive, byte[] bArr) throws IOException {
        readStreamsInfo(dataInputStream, archive);
        Folder folder = archive.folders[0];
        this.file.seek(archive.packPos + 32 + 0);
        BoundedRandomAccessFileInputStream boundedRandomAccessFileInputStream = new BoundedRandomAccessFileInputStream(this.file, archive.packSizes[0]);
        InputStream inputStream = boundedRandomAccessFileInputStream;
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams == 1 && coder.numOutStreams == 1) {
                inputStream = Coders.addDecoder(inputStream, folder.getUnpackSizeForCoder(coder), coder, bArr);
            } else {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
        }
        InputStream cRC32VerifyingInputStream = folder.hasCrc ? new CRC32VerifyingInputStream(inputStream, folder.getUnpackSize(), folder.crc) : inputStream;
        byte[] bArr2 = new byte[(int) folder.getUnpackSize()];
        DataInputStream dataInputStream2 = new DataInputStream(cRC32VerifyingInputStream);
        try {
            dataInputStream2.readFully(bArr2);
            dataInputStream2.close();
            return new DataInputStream(new ByteArrayInputStream(bArr2));
        } catch (Throwable th) {
            dataInputStream2.close();
            throw th;
        }
    }

    private void readFilesInfo(DataInput dataInput, Archive archive) throws IOException {
        SevenZArchiveEntry[] sevenZArchiveEntryArr = new SevenZArchiveEntry[(int) readUint64(dataInput)];
        for (int i = 0; i < sevenZArchiveEntryArr.length; i++) {
            sevenZArchiveEntryArr[i] = new SevenZArchiveEntry();
        }
        BitSet bitSet = null;
        BitSet bitSet2 = null;
        BitSet bitSet3 = null;
        while (true) {
            int readUnsignedByte = dataInput.readUnsignedByte();
            if (readUnsignedByte == 0) {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < sevenZArchiveEntryArr.length; i4++) {
                    boolean z = true;
                    sevenZArchiveEntryArr[i4].setHasStream(bitSet == null || !bitSet.get(i4));
                    if (sevenZArchiveEntryArr[i4].hasStream()) {
                        sevenZArchiveEntryArr[i4].setDirectory(false);
                        sevenZArchiveEntryArr[i4].setAntiItem(false);
                        sevenZArchiveEntryArr[i4].setHasCrc(archive.subStreamsInfo.hasCrc.get(i2));
                        sevenZArchiveEntryArr[i4].setCrcValue(archive.subStreamsInfo.crcs[i2]);
                        sevenZArchiveEntryArr[i4].setSize(archive.subStreamsInfo.unpackSizes[i2]);
                        i2++;
                    } else {
                        SevenZArchiveEntry sevenZArchiveEntry = sevenZArchiveEntryArr[i4];
                        if (bitSet2 != null && bitSet2.get(i3)) {
                            z = false;
                        }
                        sevenZArchiveEntry.setDirectory(z);
                        sevenZArchiveEntryArr[i4].setAntiItem(bitSet3 == null ? false : bitSet3.get(i3));
                        sevenZArchiveEntryArr[i4].setHasCrc(false);
                        sevenZArchiveEntryArr[i4].setSize(0L);
                        i3++;
                    }
                }
                archive.files = sevenZArchiveEntryArr;
                calculateStreamMap(archive);
                return;
            }
            long readUint64 = readUint64(dataInput);
            switch (readUnsignedByte) {
                case 14:
                    bitSet = readBits(dataInput, sevenZArchiveEntryArr.length);
                    break;
                case 15:
                    if (bitSet != null) {
                        bitSet2 = readBits(dataInput, bitSet.cardinality());
                        break;
                    } else {
                        throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
                    }
                case 16:
                    if (bitSet != null) {
                        bitSet3 = readBits(dataInput, bitSet.cardinality());
                        break;
                    } else {
                        throw new IOException("Header format error: kEmptyStream must appear before kAnti");
                    }
                case 17:
                    if (dataInput.readUnsignedByte() != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j = readUint64 - 1;
                    if ((1 & j) == 0) {
                        byte[] bArr = new byte[(int) j];
                        dataInput.readFully(bArr);
                        int i5 = 0;
                        int i6 = 0;
                        for (int i7 = 0; i7 < bArr.length; i7 += 2) {
                            if (bArr[i7] == 0 && bArr[i7 + 1] == 0) {
                                sevenZArchiveEntryArr[i6].setName(new String(bArr, i5, i7 - i5, CharsetNames.UTF_16LE));
                                i5 = i7 + 2;
                                i6++;
                            }
                        }
                        if (i5 == bArr.length && i6 == sevenZArchiveEntryArr.length) {
                            break;
                        }
                    } else {
                        throw new IOException("File names length invalid");
                    }
                    break;
                case 18:
                    BitSet readAllOrBits = readAllOrBits(dataInput, sevenZArchiveEntryArr.length);
                    if (dataInput.readUnsignedByte() == 0) {
                        for (int i8 = 0; i8 < sevenZArchiveEntryArr.length; i8++) {
                            sevenZArchiveEntryArr[i8].setHasCreationDate(readAllOrBits.get(i8));
                            if (sevenZArchiveEntryArr[i8].getHasCreationDate()) {
                                sevenZArchiveEntryArr[i8].setCreationDate(Long.reverseBytes(dataInput.readLong()));
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 19:
                    BitSet readAllOrBits2 = readAllOrBits(dataInput, sevenZArchiveEntryArr.length);
                    if (dataInput.readUnsignedByte() == 0) {
                        for (int i9 = 0; i9 < sevenZArchiveEntryArr.length; i9++) {
                            sevenZArchiveEntryArr[i9].setHasAccessDate(readAllOrBits2.get(i9));
                            if (sevenZArchiveEntryArr[i9].getHasAccessDate()) {
                                sevenZArchiveEntryArr[i9].setAccessDate(Long.reverseBytes(dataInput.readLong()));
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 20:
                    BitSet readAllOrBits3 = readAllOrBits(dataInput, sevenZArchiveEntryArr.length);
                    if (dataInput.readUnsignedByte() == 0) {
                        for (int i10 = 0; i10 < sevenZArchiveEntryArr.length; i10++) {
                            sevenZArchiveEntryArr[i10].setHasLastModifiedDate(readAllOrBits3.get(i10));
                            if (sevenZArchiveEntryArr[i10].getHasLastModifiedDate()) {
                                sevenZArchiveEntryArr[i10].setLastModifiedDate(Long.reverseBytes(dataInput.readLong()));
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 21:
                    BitSet readAllOrBits4 = readAllOrBits(dataInput, sevenZArchiveEntryArr.length);
                    if (dataInput.readUnsignedByte() == 0) {
                        for (int i11 = 0; i11 < sevenZArchiveEntryArr.length; i11++) {
                            sevenZArchiveEntryArr[i11].setHasWindowsAttributes(readAllOrBits4.get(i11));
                            if (sevenZArchiveEntryArr[i11].getHasWindowsAttributes()) {
                                sevenZArchiveEntryArr[i11].setWindowsAttributes(Integer.reverseBytes(dataInput.readInt()));
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 22:
                case 23:
                default:
                    if (skipBytesFully(dataInput, readUint64) < readUint64) {
                        throw new IOException("Incomplete property of type " + readUnsignedByte);
                    }
                    break;
                case 24:
                    throw new IOException("kStartPos is unsupported, please report");
                case 25:
                    if (skipBytesFully(dataInput, readUint64) < readUint64) {
                        throw new IOException("Incomplete kDummy property");
                    }
                    break;
            }
        }
        throw new IOException("Error parsing file names");
    }

    private Folder readFolder(DataInput dataInput) throws IOException {
        int i;
        Folder folder = new Folder();
        Coder[] coderArr = new Coder[(int) readUint64(dataInput)];
        long j = 0;
        long j2 = 0;
        for (int i2 = 0; i2 < coderArr.length; i2++) {
            coderArr[i2] = new Coder();
            int readUnsignedByte = dataInput.readUnsignedByte();
            int i3 = readUnsignedByte & 15;
            boolean z = (readUnsignedByte & 16) == 0;
            boolean z2 = (readUnsignedByte & 32) != 0;
            boolean z3 = (readUnsignedByte & CpioConstants.C_IWUSR) != 0;
            coderArr[i2].decompressionMethodId = new byte[i3];
            dataInput.readFully(coderArr[i2].decompressionMethodId);
            if (z) {
                coderArr[i2].numInStreams = 1L;
                coderArr[i2].numOutStreams = 1L;
            } else {
                coderArr[i2].numInStreams = readUint64(dataInput);
                coderArr[i2].numOutStreams = readUint64(dataInput);
            }
            j += coderArr[i2].numInStreams;
            j2 += coderArr[i2].numOutStreams;
            if (z2) {
                coderArr[i2].properties = new byte[(int) readUint64(dataInput)];
                dataInput.readFully(coderArr[i2].properties);
            }
            if (z3) {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
        }
        folder.coders = coderArr;
        folder.totalInputStreams = j;
        folder.totalOutputStreams = j2;
        if (j2 != 0) {
            long j3 = j2 - 1;
            BindPair[] bindPairArr = new BindPair[(int) j3];
            for (int i4 = 0; i4 < bindPairArr.length; i4++) {
                bindPairArr[i4] = new BindPair();
                bindPairArr[i4].inIndex = readUint64(dataInput);
                bindPairArr[i4].outIndex = readUint64(dataInput);
            }
            folder.bindPairs = bindPairArr;
            if (j >= j3) {
                long j4 = j - j3;
                int i5 = (int) j4;
                long[] jArr = new long[i5];
                if (j4 == 1) {
                    int i6 = 0;
                    while (true) {
                        i = (int) j;
                        if (i6 >= i || folder.findBindPairForInStream(i6) < 0) {
                            break;
                        }
                        i6++;
                    }
                    if (i6 != i) {
                        jArr[0] = i6;
                    } else {
                        throw new IOException("Couldn't find stream's bind pair index");
                    }
                } else {
                    for (int i7 = 0; i7 < i5; i7++) {
                        jArr[i7] = readUint64(dataInput);
                    }
                }
                folder.packedStreams = jArr;
                return folder;
            }
            throw new IOException("Total input streams can't be less than the number of bind pairs");
        }
        throw new IOException("Total output streams can't be 0");
    }

    private void readHeader(DataInput dataInput, Archive archive) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 2) {
            readArchiveProperties(dataInput);
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte == 3) {
            throw new IOException("Additional streams unsupported");
        }
        if (readUnsignedByte == 4) {
            readStreamsInfo(dataInput, archive);
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte == 5) {
            readFilesInfo(dataInput, archive);
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte == 0) {
            return;
        }
        throw new IOException("Badly terminated header, found " + readUnsignedByte);
    }

    private Archive readHeaders(byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[6];
        this.file.readFully(bArr2);
        if (Arrays.equals(bArr2, sevenZSignature)) {
            byte readByte = this.file.readByte();
            byte readByte2 = this.file.readByte();
            if (readByte == 0) {
                StartHeader readStartHeader = readStartHeader(4294967295L & Integer.reverseBytes(this.file.readInt()));
                long j = readStartHeader.nextHeaderSize;
                int i = (int) j;
                if (i == j) {
                    this.file.seek(readStartHeader.nextHeaderOffset + 32);
                    byte[] bArr3 = new byte[i];
                    this.file.readFully(bArr3);
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr3);
                    if (readStartHeader.nextHeaderCrc == crc32.getValue()) {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
                        Archive archive = new Archive();
                        int readUnsignedByte = dataInputStream.readUnsignedByte();
                        if (readUnsignedByte == 23) {
                            dataInputStream = readEncodedHeader(dataInputStream, archive, bArr);
                            archive = new Archive();
                            readUnsignedByte = dataInputStream.readUnsignedByte();
                        }
                        if (readUnsignedByte == 1) {
                            readHeader(dataInputStream, archive);
                            dataInputStream.close();
                            return archive;
                        }
                        throw new IOException("Broken or unsupported archive: no Header");
                    }
                    throw new IOException("NextHeader CRC mismatch");
                }
                throw new IOException("cannot handle nextHeaderSize " + readStartHeader.nextHeaderSize);
            }
            throw new IOException(String.format("Unsupported 7z version (%d,%d)", Byte.valueOf(readByte), Byte.valueOf(readByte2)));
        }
        throw new IOException("Bad 7z signature");
    }

    private void readPackInfo(DataInput dataInput, Archive archive) throws IOException {
        archive.packPos = readUint64(dataInput);
        long readUint64 = readUint64(dataInput);
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 9) {
            archive.packSizes = new long[(int) readUint64];
            int i = 0;
            while (true) {
                long[] jArr = archive.packSizes;
                if (i >= jArr.length) {
                    break;
                }
                jArr[i] = readUint64(dataInput);
                i++;
            }
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte == 10) {
            int i2 = (int) readUint64;
            archive.packCrcsDefined = readAllOrBits(dataInput, i2);
            archive.packCrcs = new long[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                if (archive.packCrcsDefined.get(i3)) {
                    archive.packCrcs[i3] = 4294967295L & Integer.reverseBytes(dataInput.readInt());
                }
            }
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte == 0) {
            return;
        }
        throw new IOException("Badly terminated PackInfo (" + readUnsignedByte + ")");
    }

    private StartHeader readStartHeader(long j) throws IOException {
        DataInputStream dataInputStream;
        StartHeader startHeader = new StartHeader();
        try {
            dataInputStream = new DataInputStream(new CRC32VerifyingInputStream(new BoundedRandomAccessFileInputStream(this.file, 20L), 20L, j));
            try {
                startHeader.nextHeaderOffset = Long.reverseBytes(dataInputStream.readLong());
                startHeader.nextHeaderSize = Long.reverseBytes(dataInputStream.readLong());
                startHeader.nextHeaderCrc = 4294967295L & Integer.reverseBytes(dataInputStream.readInt());
                dataInputStream.close();
                return startHeader;
            } catch (Throwable th) {
                th = th;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dataInputStream = null;
        }
    }

    private void readStreamsInfo(DataInput dataInput, Archive archive) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 6) {
            readPackInfo(dataInput, archive);
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte == 7) {
            readUnpackInfo(dataInput, archive);
            readUnsignedByte = dataInput.readUnsignedByte();
        } else {
            archive.folders = new Folder[0];
        }
        if (readUnsignedByte == 8) {
            readSubStreamsInfo(dataInput, archive);
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte != 0) {
            throw new IOException("Badly terminated StreamsInfo");
        }
    }

    private void readSubStreamsInfo(DataInput dataInput, Archive archive) throws IOException {
        boolean z;
        Folder[] folderArr;
        Folder[] folderArr2;
        Folder[] folderArr3;
        Folder[] folderArr4 = archive.folders;
        int length = folderArr4.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            folderArr4[i].numUnpackSubStreams = 1;
            i++;
        }
        int length2 = archive.folders.length;
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 13) {
            int i2 = 0;
            for (Folder folder : archive.folders) {
                long readUint64 = readUint64(dataInput);
                folder.numUnpackSubStreams = (int) readUint64;
                i2 = (int) (i2 + readUint64);
            }
            readUnsignedByte = dataInput.readUnsignedByte();
            length2 = i2;
        }
        SubStreamsInfo subStreamsInfo = new SubStreamsInfo();
        subStreamsInfo.unpackSizes = new long[length2];
        subStreamsInfo.hasCrc = new BitSet(length2);
        subStreamsInfo.crcs = new long[length2];
        int i3 = 0;
        for (Folder folder2 : archive.folders) {
            if (folder2.numUnpackSubStreams != 0) {
                long j = 0;
                if (readUnsignedByte == 9) {
                    int i4 = i3;
                    int i5 = 0;
                    while (i5 < folder2.numUnpackSubStreams - 1) {
                        long readUint642 = readUint64(dataInput);
                        subStreamsInfo.unpackSizes[i4] = readUint642;
                        j += readUint642;
                        i5++;
                        i4++;
                    }
                    i3 = i4;
                }
                subStreamsInfo.unpackSizes[i3] = folder2.getUnpackSize() - j;
                i3++;
            }
        }
        if (readUnsignedByte == 9) {
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        int i6 = 0;
        for (Folder folder3 : archive.folders) {
            if (folder3.numUnpackSubStreams != 1 || !folder3.hasCrc) {
                i6 += folder3.numUnpackSubStreams;
            }
        }
        if (readUnsignedByte == 10) {
            BitSet readAllOrBits = readAllOrBits(dataInput, i6);
            long[] jArr = new long[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                if (readAllOrBits.get(i7)) {
                    jArr[i7] = 4294967295L & Integer.reverseBytes(dataInput.readInt());
                }
            }
            Folder[] folderArr5 = archive.folders;
            int length3 = folderArr5.length;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < length3) {
                Folder folder4 = folderArr5[i8];
                if (folder4.numUnpackSubStreams == z && folder4.hasCrc) {
                    subStreamsInfo.hasCrc.set(i9, z);
                    subStreamsInfo.crcs[i9] = folder4.crc;
                    i9++;
                } else {
                    for (int i11 = 0; i11 < folder4.numUnpackSubStreams; i11++) {
                        subStreamsInfo.hasCrc.set(i9, readAllOrBits.get(i10));
                        subStreamsInfo.crcs[i9] = jArr[i10];
                        i9++;
                        i10++;
                    }
                }
                i8++;
                z = true;
            }
            readUnsignedByte = dataInput.readUnsignedByte();
        }
        if (readUnsignedByte == 0) {
            archive.subStreamsInfo = subStreamsInfo;
            return;
        }
        throw new IOException("Badly terminated SubStreamsInfo");
    }

    private static long readUint64(DataInput dataInput) throws IOException {
        long readUnsignedByte = dataInput.readUnsignedByte();
        int i = CpioConstants.C_IWUSR;
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            if ((i & readUnsignedByte) == 0) {
                return ((readUnsignedByte & (i - 1)) << (i2 * 8)) | j;
            }
            j |= dataInput.readUnsignedByte() << (i2 * 8);
            i >>>= 1;
        }
        return j;
    }

    private void readUnpackInfo(DataInput dataInput, Archive archive) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 11) {
            int readUint64 = (int) readUint64(dataInput);
            Folder[] folderArr = new Folder[readUint64];
            archive.folders = folderArr;
            if (dataInput.readUnsignedByte() == 0) {
                for (int i = 0; i < readUint64; i++) {
                    folderArr[i] = readFolder(dataInput);
                }
                int readUnsignedByte2 = dataInput.readUnsignedByte();
                if (readUnsignedByte2 == 12) {
                    for (Folder folder : folderArr) {
                        folder.unpackSizes = new long[(int) folder.totalOutputStreams];
                        for (int i2 = 0; i2 < folder.totalOutputStreams; i2++) {
                            folder.unpackSizes[i2] = readUint64(dataInput);
                        }
                    }
                    int readUnsignedByte3 = dataInput.readUnsignedByte();
                    if (readUnsignedByte3 == 10) {
                        BitSet readAllOrBits = readAllOrBits(dataInput, readUint64);
                        for (int i3 = 0; i3 < readUint64; i3++) {
                            if (readAllOrBits.get(i3)) {
                                folderArr[i3].hasCrc = true;
                                folderArr[i3].crc = 4294967295L & Integer.reverseBytes(dataInput.readInt());
                            } else {
                                folderArr[i3].hasCrc = false;
                            }
                        }
                        readUnsignedByte3 = dataInput.readUnsignedByte();
                    }
                    if (readUnsignedByte3 != 0) {
                        throw new IOException("Badly terminated UnpackInfo");
                    }
                    return;
                }
                throw new IOException("Expected kCodersUnpackSize, got " + readUnsignedByte2);
            }
            throw new IOException("External unsupported");
        }
        throw new IOException("Expected kFolder, got " + readUnsignedByte);
    }

    private static long skipBytesFully(DataInput dataInput, long j) throws IOException {
        int skipBytes;
        if (j < 1) {
            return 0L;
        }
        long j2 = 0;
        while (j > 2147483647L) {
            long skipBytesFully = skipBytesFully(dataInput, 2147483647L);
            if (skipBytesFully == 0) {
                return j2;
            }
            j2 += skipBytesFully;
            j -= skipBytesFully;
        }
        while (j > 0 && (skipBytes = dataInput.skipBytes((int) j)) != 0) {
            long j3 = skipBytes;
            j2 += j3;
            j -= j3;
        }
        return j2;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.RandomAccessFile, byte[]] */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } finally {
                this.file = null;
                byte[] bArr = this.password;
                if (bArr != null) {
                    Arrays.fill(bArr, (byte) 0);
                }
                this.password = null;
            }
        }
    }

    public SevenZArchiveEntry getNextEntry() throws IOException {
        int i = this.currentEntryIndex;
        SevenZArchiveEntry[] sevenZArchiveEntryArr = this.archive.files;
        if (i >= sevenZArchiveEntryArr.length - 1) {
            return null;
        }
        this.currentEntryIndex = i + 1;
        SevenZArchiveEntry sevenZArchiveEntry = sevenZArchiveEntryArr[this.currentEntryIndex];
        buildDecodingStream();
        return sevenZArchiveEntry;
    }

    public int read() throws IOException {
        InputStream inputStream = this.currentEntryInputStream;
        if (inputStream != null) {
            return inputStream.read();
        }
        throw new IllegalStateException("No current 7z entry");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStream = this.currentEntryInputStream;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        throw new IllegalStateException("No current 7z entry");
    }

    public SevenZFile(File file) throws IOException {
        this(file, null);
    }
}
