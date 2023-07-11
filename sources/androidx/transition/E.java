package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: GhostViewUtils.java */
/* loaded from: classes.dex */
class E {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static D a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C.a(view, viewGroup, matrix);
        }
        return B.a(view, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            C.a(view);
        } else {
            B.b(view);
        }
    }
}
