package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
/* loaded from: classes.dex */
public class TarArchiveEntry implements TarConstants, ArchiveEntry {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    private boolean checkSumOK;
    private int devMajor;
    private int devMinor;
    private final File file;
    private int groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private String magic;
    private long modTime;
    private int mode;
    private String name;
    private long realSize;
    private long size;
    private int userId;
    private String userName;
    private String version;

    private TarArchiveEntry() {
        this.name = "";
        this.userId = 0;
        this.groupId = 0;
        this.size = 0L;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        String property = System.getProperty("user.name", "");
        this.userName = property.length() > 31 ? property.substring(0, 31) : property;
        this.file = null;
    }

    private int evaluateType(byte[] bArr) {
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, TarConstants.MAGIC_OFFSET, 6)) {
            return 2;
        }
        return ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, TarConstants.MAGIC_OFFSET, 6) ? 3 : 0;
    }

    private static String normalizeFileName(String str, boolean z) {
        int indexOf;
        String lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (lowerCase != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.indexOf("netware") > -1 && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        String replace = str.replace(File.separatorChar, '/');
        while (!z && replace.startsWith("/")) {
            replace = replace.substring(1);
        }
        return replace;
    }

    private int writeEntryHeaderField(long j, byte[] bArr, int i, int i2, boolean z) {
        if (!z && (j < 0 || j >= (1 << ((i2 - 1) * 3)))) {
            return TarUtils.formatLongOctalBytes(0L, bArr, i, i2);
        }
        return TarUtils.formatLongOctalOrBinaryBytes(j, bArr, i, i2);
    }

    public boolean equals(TarArchiveEntry tarArchiveEntry) {
        return getName().equals(tarArchiveEntry.getName());
    }

    public int getDevMajor() {
        return this.devMajor;
    }

    public int getDevMinor() {
        return this.devMinor;
    }

    public TarArchiveEntry[] getDirectoryEntries() {
        File file = this.file;
        if (file != null && file.isDirectory()) {
            String[] list = this.file.list();
            TarArchiveEntry[] tarArchiveEntryArr = new TarArchiveEntry[list.length];
            for (int i = 0; i < list.length; i++) {
                tarArchiveEntryArr[i] = new TarArchiveEntry(new File(this.file, list[i]));
            }
            return tarArchiveEntryArr;
        }
        return new TarArchiveEntry[0];
    }

    public File getFile() {
        return this.file;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName.toString();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return getModTime();
    }

    public String getLinkName() {
        return this.linkName.toString();
    }

    public Date getModTime() {
        return new Date(this.modTime * 1000);
    }

    public int getMode() {
        return this.mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name.toString();
    }

    public long getRealSize() {
        return this.realSize;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName.toString();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isBlockDevice() {
        return this.linkFlag == 52;
    }

    public boolean isCharacterDevice() {
        return this.linkFlag == 51;
    }

    public boolean isCheckSumOK() {
        return this.checkSumOK;
    }

    public boolean isDescendent(TarArchiveEntry tarArchiveEntry) {
        return tarArchiveEntry.getName().startsWith(getName());
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        File file = this.file;
        if (file != null) {
            return file.isDirectory();
        }
        return this.linkFlag == 53 || getName().endsWith("/");
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    public boolean isFIFO() {
        return this.linkFlag == 54;
    }

    public boolean isFile() {
        File file = this.file;
        if (file != null) {
            return file.isFile();
        }
        byte b2 = this.linkFlag;
        if (b2 == 0 || b2 == 48) {
            return true;
        }
        return !getName().endsWith("/");
    }

    public boolean isGNULongLinkEntry() {
        return this.linkFlag == 75 && this.name.equals(TarConstants.GNU_LONGLINK);
    }

    public boolean isGNULongNameEntry() {
        return this.linkFlag == 76 && this.name.equals(TarConstants.GNU_LONGLINK);
    }

    public boolean isGNUSparse() {
        return this.linkFlag == 83;
    }

    public boolean isGlobalPaxHeader() {
        return this.linkFlag == 103;
    }

    public boolean isLink() {
        return this.linkFlag == 49;
    }

    public boolean isPaxHeader() {
        byte b2 = this.linkFlag;
        return b2 == 120 || b2 == 88;
    }

    public boolean isSymbolicLink() {
        return this.linkFlag == 50;
    }

    public void parseTarHeader(byte[] bArr) {
        try {
            try {
                parseTarHeader(bArr, TarUtils.DEFAULT_ENCODING);
            } catch (IOException unused) {
                parseTarHeader(bArr, TarUtils.DEFAULT_ENCODING, true);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDevMajor(int i) {
        if (i >= 0) {
            this.devMajor = i;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i);
    }

    public void setDevMinor(int i) {
        if (i >= 0) {
            this.devMinor = i;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i);
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIds(int i, int i2) {
        setUserId(i);
        setGroupId(i2);
    }

    public void setLinkName(String str) {
        this.linkName = str;
    }

    public void setModTime(long j) {
        this.modTime = j / 1000;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setName(String str) {
        this.name = normalizeFileName(str, false);
    }

    public void setNames(String str, String str2) {
        setUserName(str);
        setGroupName(str2);
    }

    public void setSize(long j) {
        if (j >= 0) {
            this.size = j;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j);
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void writeEntryHeader(byte[] bArr) {
        try {
            try {
                writeEntryHeader(bArr, TarUtils.DEFAULT_ENCODING, false);
            } catch (IOException unused) {
                writeEntryHeader(bArr, TarUtils.FALLBACK_ENCODING, false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || TarArchiveEntry.class != obj.getClass()) {
            return false;
        }
        return equals((TarArchiveEntry) obj);
    }

    public void setModTime(Date date) {
        this.modTime = date.getTime() / 1000;
    }

    public void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        parseTarHeader(bArr, zipEncoding, false);
    }

    public void writeEntryHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z) throws IOException {
        int writeEntryHeaderField = writeEntryHeaderField(this.modTime, bArr, writeEntryHeaderField(this.size, bArr, writeEntryHeaderField(this.groupId, bArr, writeEntryHeaderField(this.userId, bArr, writeEntryHeaderField(this.mode, bArr, TarUtils.formatNameBytes(this.name, bArr, 0, 100, zipEncoding), 8, z), 8, z), 8, z), 12, z), 12, z);
        int i = writeEntryHeaderField;
        int i2 = 0;
        while (i2 < 8) {
            bArr[i] = 32;
            i2++;
            i++;
        }
        bArr[i] = this.linkFlag;
        for (int writeEntryHeaderField2 = writeEntryHeaderField(this.devMinor, bArr, writeEntryHeaderField(this.devMajor, bArr, TarUtils.formatNameBytes(this.groupName, bArr, TarUtils.formatNameBytes(this.userName, bArr, TarUtils.formatNameBytes(this.version, bArr, TarUtils.formatNameBytes(this.magic, bArr, TarUtils.formatNameBytes(this.linkName, bArr, i + 1, 100, zipEncoding), 6), 2), 32, zipEncoding), 32, zipEncoding), 8, z), 8, z); writeEntryHeaderField2 < bArr.length; writeEntryHeaderField2++) {
            bArr[writeEntryHeaderField2] = 0;
        }
        TarUtils.formatCheckSumOctalBytes(TarUtils.computeCheckSum(bArr), bArr, writeEntryHeaderField, 8);
    }

    private void parseTarHeader(byte[] bArr, ZipEncoding zipEncoding, boolean z) throws IOException {
        this.name = z ? TarUtils.parseName(bArr, 0, 100) : TarUtils.parseName(bArr, 0, 100, zipEncoding);
        this.mode = (int) TarUtils.parseOctalOrBinary(bArr, 100, 8);
        this.userId = (int) TarUtils.parseOctalOrBinary(bArr, 108, 8);
        this.groupId = (int) TarUtils.parseOctalOrBinary(bArr, 116, 8);
        this.size = TarUtils.parseOctalOrBinary(bArr, 124, 12);
        this.modTime = TarUtils.parseOctalOrBinary(bArr, 136, 12);
        this.checkSumOK = TarUtils.verifyCheckSum(bArr);
        this.linkFlag = bArr[156];
        this.linkName = z ? TarUtils.parseName(bArr, 157, 100) : TarUtils.parseName(bArr, 157, 100, zipEncoding);
        this.magic = TarUtils.parseName(bArr, TarConstants.MAGIC_OFFSET, 6);
        this.version = TarUtils.parseName(bArr, TarConstants.VERSION_OFFSET, 2);
        this.userName = z ? TarUtils.parseName(bArr, 265, 32) : TarUtils.parseName(bArr, 265, 32, zipEncoding);
        this.groupName = z ? TarUtils.parseName(bArr, 297, 32) : TarUtils.parseName(bArr, 297, 32, zipEncoding);
        this.devMajor = (int) TarUtils.parseOctalOrBinary(bArr, 329, 8);
        this.devMinor = (int) TarUtils.parseOctalOrBinary(bArr, 337, 8);
        if (evaluateType(bArr) != 2) {
            String parseName = z ? TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN) : TarUtils.parseName(bArr, 345, TarConstants.PREFIXLEN, zipEncoding);
            if (isDirectory() && !this.name.endsWith("/")) {
                this.name += "/";
            }
            if (parseName.length() > 0) {
                this.name = parseName + "/" + this.name;
                return;
            }
            return;
        }
        this.isExtended = TarUtils.parseBoolean(bArr, 482);
        this.realSize = TarUtils.parseOctal(bArr, 483, 12);
    }

    public TarArchiveEntry(String str) {
        this(str, false);
    }

    public TarArchiveEntry(String str, boolean z) {
        this();
        String normalizeFileName = normalizeFileName(str, z);
        boolean endsWith = normalizeFileName.endsWith("/");
        this.name = normalizeFileName;
        this.mode = endsWith ? DEFAULT_DIR_MODE : DEFAULT_FILE_MODE;
        this.linkFlag = endsWith ? TarConstants.LF_DIR : TarConstants.LF_NORMAL;
        this.modTime = new Date().getTime() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(String str, byte b2) {
        this(str, b2, false);
    }

    public TarArchiveEntry(String str, byte b2, boolean z) {
        this(str, z);
        this.linkFlag = b2;
        if (b2 == 76) {
            this.magic = TarConstants.MAGIC_GNU;
            this.version = TarConstants.VERSION_GNU_SPACE;
        }
    }

    public TarArchiveEntry(File file) {
        this(file, normalizeFileName(file.getPath(), false));
    }

    public TarArchiveEntry(File file, String str) {
        this.name = "";
        this.userId = 0;
        this.groupId = 0;
        this.size = 0L;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = TarConstants.VERSION_POSIX;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.file = file;
        if (file.isDirectory()) {
            this.mode = DEFAULT_DIR_MODE;
            this.linkFlag = TarConstants.LF_DIR;
            int length = str.length();
            if (length != 0 && str.charAt(length - 1) == '/') {
                this.name = str;
            } else {
                this.name = str + "/";
            }
        } else {
            this.mode = DEFAULT_FILE_MODE;
            this.linkFlag = TarConstants.LF_NORMAL;
            this.size = file.length();
            this.name = str;
        }
        this.modTime = file.lastModified() / 1000;
        this.userName = "";
    }

    public TarArchiveEntry(byte[] bArr) {
        this();
        parseTarHeader(bArr);
    }

    public TarArchiveEntry(byte[] bArr, ZipEncoding zipEncoding) throws IOException {
        this();
        parseTarHeader(bArr, zipEncoding);
    }
}
