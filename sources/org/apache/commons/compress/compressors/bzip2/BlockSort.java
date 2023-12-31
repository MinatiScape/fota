package org.apache.commons.compress.compressors.bzip2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.BitSet;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final char[] quadrant;
    private int workDone;
    private int workLimit;
    private final int[] stack_ll = new int[TarArchiveEntry.MILLIS_PER_SECOND];
    private final int[] stack_hh = new int[TarArchiveEntry.MILLIS_PER_SECOND];
    private final int[] stack_dd = new int[TarArchiveEntry.MILLIS_PER_SECOND];
    private final int[] mainSort_runningOrder = new int[CpioConstants.C_IRUSR];
    private final int[] mainSort_copy = new int[CpioConstants.C_IRUSR];
    private final boolean[] mainSort_bigDone = new boolean[CpioConstants.C_IRUSR];
    private final int[] ftab = new int[65537];

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockSort(BZip2CompressorOutputStream.Data data) {
        this.quadrant = data.sfmap;
    }

    private void fallbackQSort3(int[] iArr, int[] iArr2, int i, int i2) {
        int i3;
        int i4;
        char c = 0;
        fpush(0, i, i2);
        long j = 0;
        int i5 = 1;
        long j2 = 0;
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            int[] fpop = fpop(i6);
            int i7 = fpop[c];
            int i8 = fpop[i5];
            if (i8 - i7 < 10) {
                fallbackSimpleSort(iArr, iArr2, i7, i8);
            } else {
                j2 = ((j2 * 7621) + 1) % PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                long j3 = j2 % 3;
                if (j3 == j) {
                    i3 = iArr2[iArr[i7]];
                } else if (j3 == 1) {
                    i3 = iArr2[iArr[(i7 + i8) >>> i5]];
                } else {
                    i3 = iArr2[iArr[i8]];
                }
                long j4 = i3;
                int i9 = i8;
                int i10 = i9;
                int i11 = i7;
                int i12 = i11;
                while (true) {
                    if (i12 <= i9) {
                        int i13 = iArr2[iArr[i12]] - ((int) j4);
                        if (i13 == 0) {
                            fswap(iArr, i12, i11);
                            i11++;
                            i12++;
                        } else if (i13 <= 0) {
                            i12++;
                        }
                    }
                    i4 = i10;
                    while (i12 <= i9) {
                        int i14 = iArr2[iArr[i9]] - ((int) j4);
                        if (i14 == 0) {
                            fswap(iArr, i9, i4);
                            i4--;
                        } else if (i14 < 0) {
                            break;
                        }
                        i9--;
                    }
                    if (i12 > i9) {
                        break;
                    }
                    fswap(iArr, i12, i9);
                    i12++;
                    i9--;
                    i10 = i4;
                }
                if (i4 >= i11) {
                    int fmin = fmin(i11 - i7, i12 - i11);
                    fvswap(iArr, i7, i12 - fmin, fmin);
                    int i15 = i8 - i4;
                    int i16 = i4 - i9;
                    int fmin2 = fmin(i15, i16);
                    fvswap(iArr, i9 + 1, (i8 - fmin2) + 1, fmin2);
                    int i17 = ((i12 + i7) - i11) - 1;
                    int i18 = (i8 - i16) + 1;
                    if (i17 - i7 > i8 - i18) {
                        int i19 = i6 + 1;
                        fpush(i6, i7, i17);
                        fpush(i19, i18, i8);
                        i6 = i19 + 1;
                    } else {
                        int i20 = i6 + 1;
                        fpush(i6, i18, i8);
                        fpush(i20, i7, i17);
                        i6 = i20 + 1;
                    }
                }
                c = 0;
                j = 0;
                i5 = 1;
            }
        }
    }

    private void fallbackSimpleSort(int[] iArr, int[] iArr2, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 - i > 3) {
            for (int i3 = i2 - 4; i3 >= i; i3--) {
                int i4 = iArr[i3];
                int i5 = iArr2[i4];
                int i6 = i3 + 4;
                while (i6 <= i2 && i5 > iArr2[iArr[i6]]) {
                    iArr[i6 - 4] = iArr[i6];
                    i6 += 4;
                }
                iArr[i6 - 4] = i4;
            }
        }
        for (int i7 = i2 - 1; i7 >= i; i7--) {
            int i8 = iArr[i7];
            int i9 = iArr2[i8];
            int i10 = i7 + 1;
            while (i10 <= i2 && i9 > iArr2[iArr[i10]]) {
                iArr[i10 - 1] = iArr[i10];
                i10++;
            }
            iArr[i10 - 1] = i8;
        }
    }

    private int fmin(int i, int i2) {
        return i < i2 ? i : i2;
    }

    private int[] fpop(int i) {
        return new int[]{this.stack_ll[i], this.stack_hh[i]};
    }

    private void fpush(int i, int i2, int i3) {
        this.stack_ll[i] = i2;
        this.stack_hh[i] = i3;
    }

    private void fswap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private void fvswap(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0) {
            fswap(iArr, i, i2);
            i++;
            i2++;
            i3--;
        }
    }

    private int[] getEclass() {
        int[] iArr = this.eclass;
        if (iArr == null) {
            int[] iArr2 = new int[this.quadrant.length / 2];
            this.eclass = iArr2;
            return iArr2;
        }
        return iArr;
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data data, int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr = this.stack_ll;
        int[] iArr2 = this.stack_hh;
        int[] iArr3 = this.stack_dd;
        int[] iArr4 = data.fmap;
        byte[] bArr = data.block;
        iArr[0] = i;
        iArr2[0] = i2;
        iArr3[0] = i3;
        int i6 = 1;
        int i7 = 1;
        while (true) {
            int i8 = i7 - 1;
            if (i8 < 0) {
                return;
            }
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            int i11 = iArr3[i8];
            if (i10 - i9 >= 20 && i11 <= 10) {
                int i12 = i11 + 1;
                int med3 = med3(bArr[iArr4[i9] + i12], bArr[iArr4[i10] + i12], bArr[iArr4[(i9 + i10) >>> i6] + i12]) & 255;
                int i13 = i9;
                int i14 = i13;
                int i15 = i10;
                int i16 = i15;
                while (true) {
                    if (i13 <= i15) {
                        int i17 = (bArr[iArr4[i13] + i12] & 255) - med3;
                        if (i17 == 0) {
                            int i18 = iArr4[i13];
                            iArr4[i13] = iArr4[i14];
                            iArr4[i14] = i18;
                            i14++;
                            i13++;
                        } else if (i17 < 0) {
                            i13++;
                        }
                    }
                    i5 = i16;
                    while (i13 <= i15) {
                        int i19 = (bArr[iArr4[i15] + i12] & 255) - med3;
                        if (i19 != 0) {
                            if (i19 <= 0) {
                                break;
                            }
                            i15--;
                        } else {
                            int i20 = iArr4[i15];
                            iArr4[i15] = iArr4[i5];
                            iArr4[i5] = i20;
                            i5--;
                            i15--;
                        }
                    }
                    if (i13 > i15) {
                        break;
                    }
                    int i21 = iArr4[i13];
                    iArr4[i13] = iArr4[i15];
                    iArr4[i15] = i21;
                    i15--;
                    i13++;
                    i16 = i5;
                }
                if (i5 < i14) {
                    iArr[i8] = i9;
                    iArr2[i8] = i10;
                    iArr3[i8] = i12;
                    i7 = i8 + 1;
                    i6 = 1;
                } else {
                    int i22 = i14 - i9;
                    int i23 = i13 - i14;
                    if (i22 >= i23) {
                        i22 = i23;
                    }
                    vswap(iArr4, i9, i13 - i22, i22);
                    int i24 = i10 - i5;
                    int i25 = i5 - i15;
                    if (i24 >= i25) {
                        i24 = i25;
                    }
                    vswap(iArr4, i13, (i10 - i24) + 1, i24);
                    int i26 = ((i13 + i9) - i14) - 1;
                    int i27 = (i10 - i25) + 1;
                    iArr[i8] = i9;
                    iArr2[i8] = i26;
                    iArr3[i8] = i11;
                    int i28 = i8 + 1;
                    iArr[i28] = i26 + 1;
                    iArr2[i28] = i27 - 1;
                    iArr3[i28] = i12;
                    int i29 = i28 + 1;
                    iArr[i29] = i27;
                    iArr2[i29] = i10;
                    iArr3[i29] = i11;
                    i8 = i29 + 1;
                }
            } else if (mainSimpleSort(data, i9, i10, i11, i4)) {
                return;
            }
            i7 = i8;
            i6 = 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
        r27 = r12;
        r28 = r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean mainSimpleSort(org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.Data r30, int r31, int r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BlockSort.mainSimpleSort(org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream$Data, int, int, int, int):boolean");
    }

    private static byte med3(byte b2, byte b3, byte b4) {
        if (b2 < b3) {
            if (b3 >= b4) {
                if (b2 >= b4) {
                    return b2;
                }
                return b4;
            }
            return b3;
        }
        if (b3 <= b4) {
            if (b2 <= b4) {
                return b2;
            }
            return b4;
        }
        return b3;
    }

    private static void vswap(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i5;
            i2++;
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void blockSort(BZip2CompressorOutputStream.Data data, int i) {
        this.workLimit = i * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if (i + 1 < 10000) {
            fallbackSort(data, i);
        } else {
            mainSort(data, i);
            if (this.firstAttempt && this.workDone > this.workLimit) {
                fallbackSort(data, i);
            }
        }
        int[] iArr = data.fmap;
        data.origPtr = -1;
        for (int i2 = 0; i2 <= i; i2++) {
            if (iArr[i2] == 0) {
                data.origPtr = i2;
                return;
            }
        }
    }

    final void fallbackSort(BZip2CompressorOutputStream.Data data, int i) {
        byte[] bArr = data.block;
        int i2 = i + 1;
        bArr[0] = bArr[i2];
        fallbackSort(data.fmap, bArr, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int[] iArr = data.fmap;
            iArr[i3] = iArr[i3] - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr2 = data.fmap;
            if (iArr2[i4] == -1) {
                iArr2[i4] = i;
                return;
            }
        }
    }

    final void mainSort(BZip2CompressorOutputStream.Data data, int i) {
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr2 = this.mainSort_runningOrder;
        int[] iArr3 = this.mainSort_copy;
        boolean[] zArr = this.mainSort_bigDone;
        int[] iArr4 = this.ftab;
        byte[] bArr = data.block;
        int[] iArr5 = data.fmap;
        char[] cArr = this.quadrant;
        int i8 = this.workLimit;
        boolean z = this.firstAttempt;
        int i9 = 65537;
        while (true) {
            i9--;
            if (i9 < 0) {
                break;
            }
            iArr4[i9] = 0;
        }
        for (int i10 = 0; i10 < 20; i10++) {
            bArr[i + i10 + 2] = bArr[(i10 % (i + 1)) + 1];
        }
        int i11 = i + 20 + 1;
        while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            cArr[i11] = 0;
        }
        int i12 = i + 1;
        bArr[0] = bArr[i12];
        int i13 = 255;
        int i14 = bArr[0] & 255;
        int i15 = 0;
        while (i15 <= i) {
            i15++;
            int i16 = bArr[i15] & 255;
            int i17 = (i14 << 8) + i16;
            iArr4[i17] = iArr4[i17] + 1;
            i14 = i16;
        }
        for (int i18 = 1; i18 <= 65536; i18++) {
            iArr4[i18] = iArr4[i18] + iArr4[i18 - 1];
        }
        int i19 = bArr[1] & 255;
        int i20 = 0;
        while (i20 < i) {
            int i21 = bArr[i20 + 2] & 255;
            int i22 = (i19 << 8) + i21;
            int i23 = iArr4[i22] - 1;
            iArr4[i22] = i23;
            iArr5[i23] = i20;
            i20++;
            i19 = i21;
        }
        int i24 = ((bArr[i12] & 255) << 8) + (bArr[1] & 255);
        int i25 = iArr4[i24] - 1;
        iArr4[i24] = i25;
        iArr5[i25] = i;
        int i26 = CpioConstants.C_IRUSR;
        while (true) {
            i26--;
            if (i26 < 0) {
                break;
            }
            zArr[i26] = false;
            iArr2[i26] = i26;
        }
        int i27 = 364;
        while (i27 != 1) {
            i27 /= 3;
            int i28 = i27;
            while (i28 <= i13) {
                int i29 = iArr2[i28];
                int i30 = iArr4[(i29 + 1) << 8] - iArr4[i29 << 8];
                int i31 = i27 - 1;
                int i32 = iArr2[i28 - i27];
                int i33 = i28;
                while (true) {
                    i6 = i8;
                    if (iArr4[(i32 + 1) << 8] - iArr4[i32 << 8] <= i30) {
                        i7 = i33;
                        break;
                    }
                    iArr2[i33] = i32;
                    i7 = i33 - i27;
                    if (i7 <= i31) {
                        break;
                    }
                    i32 = iArr2[i7 - i27];
                    i33 = i7;
                    i8 = i6;
                }
                iArr2[i7] = i29;
                i28++;
                i8 = i6;
                i13 = 255;
            }
        }
        int i34 = i8;
        int i35 = 0;
        while (i35 <= i13) {
            int i36 = iArr2[i35];
            int i37 = 0;
            while (i37 <= i13) {
                int i38 = (i36 << 8) + i37;
                int i39 = iArr4[i38];
                if ((i39 & SETMASK) != SETMASK) {
                    int i40 = i39 & CLEARMASK;
                    int i41 = (iArr4[i38 + 1] & CLEARMASK) - 1;
                    if (i41 > i40) {
                        i5 = SETMASK;
                        i2 = i37;
                        i3 = i34;
                        iArr = iArr2;
                        i4 = i35;
                        mainQSort3(data, i40, i41, 2, i);
                        if (z && this.workDone > i3) {
                            return;
                        }
                    } else {
                        i2 = i37;
                        i3 = i34;
                        i5 = SETMASK;
                        iArr = iArr2;
                        i4 = i35;
                    }
                    iArr4[i38] = i39 | i5;
                } else {
                    i2 = i37;
                    i3 = i34;
                    iArr = iArr2;
                    i4 = i35;
                }
                i37 = i2 + 1;
                i35 = i4;
                iArr2 = iArr;
                i13 = 255;
                i34 = i3;
            }
            int i42 = i34;
            int[] iArr6 = iArr2;
            int i43 = i35;
            for (int i44 = 0; i44 <= 255; i44++) {
                iArr3[i44] = iArr4[(i44 << 8) + i36] & CLEARMASK;
            }
            int i45 = i36 << 8;
            int i46 = iArr4[i45] & CLEARMASK;
            int i47 = (i36 + 1) << 8;
            int i48 = iArr4[i47] & CLEARMASK;
            while (i46 < i48) {
                int i49 = iArr5[i46];
                int i50 = i48;
                int i51 = bArr[i49] & 255;
                if (!zArr[i51]) {
                    iArr5[iArr3[i51]] = i49 == 0 ? i : i49 - 1;
                    iArr3[i51] = iArr3[i51] + 1;
                }
                i46++;
                i48 = i50;
            }
            int i52 = CpioConstants.C_IRUSR;
            while (true) {
                i52--;
                if (i52 < 0) {
                    break;
                }
                int i53 = (i52 << 8) + i36;
                iArr4[i53] = iArr4[i53] | SETMASK;
            }
            zArr[i36] = true;
            if (i43 < 255) {
                int i54 = iArr4[i45] & CLEARMASK;
                int i55 = (CLEARMASK & iArr4[i47]) - i54;
                int i56 = 0;
                while ((i55 >> i56) > 65534) {
                    i56++;
                }
                int i57 = 0;
                while (i57 < i55) {
                    int i58 = iArr5[i54 + i57];
                    char c = (char) (i57 >> i56);
                    cArr[i58] = c;
                    int i59 = i54;
                    if (i58 < 20) {
                        cArr[i58 + i + 1] = c;
                    }
                    i57++;
                    i54 = i59;
                }
            }
            i35 = i43 + 1;
            iArr2 = iArr6;
            i13 = 255;
            i34 = i42;
        }
    }

    final void fallbackSort(int[] iArr, byte[] bArr, int i) {
        int i2;
        int[] iArr2 = new int[TarConstants.MAGIC_OFFSET];
        int[] eclass = getEclass();
        for (int i3 = 0; i3 < i; i3++) {
            eclass[i3] = 0;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = bArr[i4] & 255;
            iArr2[i5] = iArr2[i5] + 1;
        }
        for (int i6 = 1; i6 < 257; i6++) {
            iArr2[i6] = iArr2[i6] + iArr2[i6 - 1];
        }
        for (int i7 = 0; i7 < i; i7++) {
            int i8 = bArr[i7] & 255;
            int i9 = iArr2[i8] - 1;
            iArr2[i8] = i9;
            iArr[i9] = i7;
        }
        BitSet bitSet = new BitSet(i + 64);
        for (int i10 = 0; i10 < 256; i10++) {
            bitSet.set(iArr2[i10]);
        }
        for (int i11 = 0; i11 < 32; i11++) {
            int i12 = (i11 * 2) + i;
            bitSet.set(i12);
            bitSet.clear(i12 + 1);
        }
        int i13 = 1;
        do {
            int i14 = 0;
            for (int i15 = 0; i15 < i; i15++) {
                if (bitSet.get(i15)) {
                    i14 = i15;
                }
                int i16 = iArr[i15] - i13;
                if (i16 < 0) {
                    i16 += i;
                }
                eclass[i16] = i14;
            }
            int i17 = -1;
            i2 = 0;
            while (true) {
                int nextClearBit = bitSet.nextClearBit(i17 + 1);
                int i18 = nextClearBit - 1;
                if (i18 < i && (i17 = bitSet.nextSetBit(nextClearBit + 1) - 1) < i) {
                    if (i17 > i18) {
                        i2 += (i17 - i18) + 1;
                        fallbackQSort3(iArr, eclass, i18, i17);
                        int i19 = -1;
                        while (i18 <= i17) {
                            int i20 = eclass[iArr[i18]];
                            if (i19 != i20) {
                                bitSet.set(i18);
                                i19 = i20;
                            }
                            i18++;
                        }
                    }
                }
            }
            i13 *= 2;
            if (i13 > i) {
                return;
            }
        } while (i2 != 0);
    }
}
