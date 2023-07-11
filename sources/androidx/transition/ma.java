package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class ma {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static la a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ka(viewGroup);
        }
        return ja.a(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            pa.a(viewGroup, z);
        } else {
            oa.a(viewGroup, z);
        }
    }
}
