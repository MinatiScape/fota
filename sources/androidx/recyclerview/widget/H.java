package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
class H {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.s sVar, w wVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        int max;
        if (iVar.e() == 0 || sVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar.l(view), iVar.l(view2));
        int max2 = Math.max(iVar.l(view), iVar.l(view2));
        if (z2) {
            max = Math.max(0, (sVar.a() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (z) {
            return Math.round((max * (Math.abs(wVar.a(view2) - wVar.d(view)) / (Math.abs(iVar.l(view) - iVar.l(view2)) + 1))) + (wVar.f() - wVar.d(view)));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.s sVar, w wVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.e() == 0 || sVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return sVar.a();
        }
        return (int) (((wVar.a(view2) - wVar.d(view)) / (Math.abs(iVar.l(view) - iVar.l(view2)) + 1)) * sVar.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.s sVar, w wVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.e() == 0 || sVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.l(view) - iVar.l(view2)) + 1;
        }
        return Math.min(wVar.g(), wVar.a(view2) - wVar.d(view));
    }
}
