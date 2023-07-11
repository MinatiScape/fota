package androidx.core.e;

import java.util.Comparator;
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
class e implements Comparator<byte[]> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        if (bArr.length != bArr2.length) {
            i = bArr.length;
            i2 = bArr2.length;
        } else {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    i = bArr[i3];
                    i2 = bArr2[i3];
                }
            }
            return 0;
        }
        return i - i2;
    }
}
