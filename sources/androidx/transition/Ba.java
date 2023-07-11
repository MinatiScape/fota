package androidx.transition;

import android.view.View;
/* compiled from: VisibilityPropagation.java */
/* loaded from: classes.dex */
public abstract class Ba extends AbstractC0108da {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f903a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    @Override // androidx.transition.AbstractC0108da
    public void a(ga gaVar) {
        View view = gaVar.f960b;
        Integer num = (Integer) gaVar.f959a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        gaVar.f959a.put("android:visibilityPropagation:visibility", num);
        view.getLocationOnScreen(r2);
        int[] iArr = {iArr[0] + Math.round(view.getTranslationX())};
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        gaVar.f959a.put("android:visibilityPropagation:center", iArr);
    }

    public int b(ga gaVar) {
        Integer num;
        if (gaVar == null || (num = (Integer) gaVar.f959a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int c(ga gaVar) {
        return a(gaVar, 0);
    }

    public int d(ga gaVar) {
        return a(gaVar, 1);
    }

    @Override // androidx.transition.AbstractC0108da
    public String[] a() {
        return f903a;
    }

    private static int a(ga gaVar, int i) {
        int[] iArr;
        if (gaVar == null || (iArr = (int[]) gaVar.f959a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }
}
