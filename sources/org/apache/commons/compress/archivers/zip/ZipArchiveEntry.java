package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.zip.ExtraFieldUtils;
/* loaded from: classes.dex */
public class ZipArchiveEntry extends ZipEntry implements ArchiveEntry {
    private static final byte[] EMPTY = new byte[0];
    public static final int PLATFORM_FAT = 0;
    public static final int PLATFORM_UNIX = 3;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_SHIFT = 16;
    private long externalAttributes;
    private LinkedHashMap<ZipShort, ZipExtraField> extraFields;
    private GeneralPurposeBit gpb;
    private int internalAttributes;
    private int method;
    private String name;
    private int platform;
    private byte[] rawName;
    private long size;
    private UnparseableExtraFieldData unparseableExtra;

    public ZipArchiveEntry(String str) {
        super(str);
        this.method = -1;
        this.size = -1L;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        setName(str);
    }

    private void mergeExtraFields(ZipExtraField[] zipExtraFieldArr, boolean z) throws ZipException {
        ZipExtraField extraField;
        if (this.extraFields == null) {
            setExtraFields(zipExtraFieldArr);
            return;
        }
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipExtraField instanceof UnparseableExtraFieldData) {
                extraField = this.unparseableExtra;
            } else {
                extraField = getExtraField(zipExtraField.getHeaderId());
            }
            if (extraField == null) {
                addExtraField(zipExtraField);
            } else if (z) {
                byte[] localFileDataData = zipExtraField.getLocalFileDataData();
                extraField.parseFromLocalFileData(localFileDataData, 0, localFileDataData.length);
            } else {
                byte[] centralDirectoryData = zipExtraField.getCentralDirectoryData();
                extraField.parseFromCentralDirectoryData(centralDirectoryData, 0, centralDirectoryData.length);
            }
        }
        setExtra();
    }

    public void addAsFirstExtraField(ZipExtraField zipExtraField) {
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else {
            LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap = this.extraFields;
            this.extraFields = new LinkedHashMap<>();
            this.extraFields.put(zipExtraField.getHeaderId(), zipExtraField);
            if (linkedHashMap != null) {
                linkedHashMap.remove(zipExtraField.getHeaderId());
                this.extraFields.putAll(linkedHashMap);
            }
        }
        setExtra();
    }

    public void addExtraField(ZipExtraField zipExtraField) {
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else {
            if (this.extraFields == null) {
                this.extraFields = new LinkedHashMap<>();
            }
            this.extraFields.put(zipExtraField.getHeaderId(), zipExtraField);
        }
        setExtra();
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) super.clone();
        zipArchiveEntry.setInternalAttributes(getInternalAttributes());
        zipArchiveEntry.setExternalAttributes(getExternalAttributes());
        zipArchiveEntry.setExtraFields(getExtraFields(true));
        return zipArchiveEntry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) obj;
        String name = getName();
        String name2 = zipArchiveEntry.getName();
        if (name == null) {
            if (name2 != null) {
                return false;
            }
        } else if (!name.equals(name2)) {
            return false;
        }
        String comment = getComment();
        String comment2 = zipArchiveEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        return getTime() == zipArchiveEntry.getTime() && comment.equals(comment2) && getInternalAttributes() == zipArchiveEntry.getInternalAttributes() && getPlatform() == zipArchiveEntry.getPlatform() && getExternalAttributes() == zipArchiveEntry.getExternalAttributes() && getMethod() == zipArchiveEntry.getMethod() && getSize() == zipArchiveEntry.getSize() && getCrc() == zipArchiveEntry.getCrc() && getCompressedSize() == zipArchiveEntry.getCompressedSize() && Arrays.equals(getCentralDirectoryExtra(), zipArchiveEntry.getCentralDirectoryExtra()) && Arrays.equals(getLocalFileDataExtra(), zipArchiveEntry.getLocalFileDataExtra()) && this.gpb.equals(zipArchiveEntry.gpb);
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getExtraFields(true));
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public ZipExtraField getExtraField(ZipShort zipShort) {
        LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap = this.extraFields;
        if (linkedHashMap != null) {
            return linkedHashMap.get(zipShort);
        }
        return null;
    }

    public ZipExtraField[] getExtraFields() {
        return getExtraFields(false);
    }

    public GeneralPurposeBit getGeneralPurposeBit() {
        return this.gpb;
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return new Date(getTime());
    }

    public byte[] getLocalFileDataExtra() {
        byte[] extra = getExtra();
        return extra != null ? extra : EMPTY;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.method;
    }

    @Override // java.util.zip.ZipEntry, org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        String str = this.name;
        return str == null ? super.getName() : str;
    }

    public int getPlatform() {
        return this.platform;
    }

    public byte[] getRawName() {
        byte[] bArr = this.rawName;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return null;
    }

    @Override // java.util.zip.ZipEntry, org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.size;
    }

    public int getUnixMode() {
        if (this.platform != 3) {
            return 0;
        }
        return (int) ((getExternalAttributes() >> 16) & 65535);
    }

    public UnparseableExtraFieldData getUnparseableExtraFieldData() {
        return this.unparseableExtra;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    @Override // java.util.zip.ZipEntry, org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        return getName().endsWith("/");
    }

    public boolean isUnixSymlink() {
        return (getUnixMode() & 40960) == 40960;
    }

    public void removeExtraField(ZipShort zipShort) {
        LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap = this.extraFields;
        if (linkedHashMap != null) {
            if (linkedHashMap.remove(zipShort) != null) {
                setExtra();
                return;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public void removeUnparseableExtraFieldData() {
        if (this.unparseableExtra != null) {
            this.unparseableExtra = null;
            setExtra();
            return;
        }
        throw new NoSuchElementException();
    }

    public void setCentralDirectoryExtra(byte[] bArr) {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, false, ExtraFieldUtils.UnparseableExtraField.READ), false);
        } catch (ZipException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void setExternalAttributes(long j) {
        this.externalAttributes = j;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, true, ExtraFieldUtils.UnparseableExtraField.READ), true);
        } catch (ZipException e) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
        }
    }

    public void setExtraFields(ZipExtraField[] zipExtraFieldArr) {
        this.extraFields = new LinkedHashMap<>();
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipExtraField instanceof UnparseableExtraFieldData) {
                this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
            } else {
                this.extraFields.put(zipExtraField.getHeaderId(), zipExtraField);
            }
        }
        setExtra();
    }

    public void setGeneralPurposeBit(GeneralPurposeBit generalPurposeBit) {
        this.gpb = generalPurposeBit;
    }

    public void setInternalAttributes(int i) {
        this.internalAttributes = i;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i) {
        if (i >= 0) {
            this.method = i;
            return;
        }
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setName(String str) {
        if (str != null && getPlatform() == 0 && str.indexOf("/") == -1) {
            str = str.replace('\\', '/');
        }
        this.name = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPlatform(int i) {
        this.platform = i;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j) {
        if (j >= 0) {
            this.size = j;
            return;
        }
        throw new IllegalArgumentException("invalid entry size");
    }

    public void setUnixMode(int i) {
        setExternalAttributes(((i & CpioConstants.C_IWUSR) == 0 ? 1 : 0) | (i << 16) | (isDirectory() ? 16 : 0));
        this.platform = 3;
    }

    public ZipExtraField[] getExtraFields(boolean z) {
        UnparseableExtraFieldData unparseableExtraFieldData;
        UnparseableExtraFieldData unparseableExtraFieldData2;
        LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap = this.extraFields;
        if (linkedHashMap == null) {
            return (!z || (unparseableExtraFieldData2 = this.unparseableExtra) == null) ? new ZipExtraField[0] : new ZipExtraField[]{unparseableExtraFieldData2};
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.values());
        if (z && (unparseableExtraFieldData = this.unparseableExtra) != null) {
            arrayList.add(unparseableExtraFieldData);
        }
        return (ZipExtraField[]) arrayList.toArray(new ZipExtraField[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getExtraFields(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setName(String str, byte[] bArr) {
        setName(str);
        this.rawName = bArr;
    }

    public ZipArchiveEntry(ZipEntry zipEntry) throws ZipException {
        super(zipEntry);
        this.method = -1;
        this.size = -1L;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        setName(zipEntry.getName());
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            setExtraFields(ExtraFieldUtils.parse(extra, true, ExtraFieldUtils.UnparseableExtraField.READ));
        } else {
            setExtra();
        }
        setMethod(zipEntry.getMethod());
        this.size = zipEntry.getSize();
    }

    public ZipArchiveEntry(ZipArchiveEntry zipArchiveEntry) throws ZipException {
        this((ZipEntry) zipArchiveEntry);
        setInternalAttributes(zipArchiveEntry.getInternalAttributes());
        setExternalAttributes(zipArchiveEntry.getExternalAttributes());
        setExtraFields(zipArchiveEntry.getExtraFields(true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ZipArchiveEntry() {
        this("");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ZipArchiveEntry(java.io.File r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L1d
            java.lang.String r0 = "/"
            boolean r1 = r4.endsWith(r0)
            if (r1 != 0) goto L1d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            java.lang.String r4 = r1.toString()
        L1d:
            r2.<init>(r4)
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L2d
            long r0 = r3.length()
            r2.setSize(r0)
        L2d:
            long r3 = r3.lastModified()
            r2.setTime(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.<init>(java.io.File, java.lang.String):void");
    }
}
