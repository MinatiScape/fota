package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
/* compiled from: CircularPropagation.java */
/* renamed from: androidx.transition.s  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0123s extends Ba {

    /* renamed from: b  reason: collision with root package name */
    private float f985b = 3.0f;

    @Override // androidx.transition.AbstractC0108da
    public long a(ViewGroup viewGroup, Transition transition, ga gaVar, ga gaVar2) {
        int i;
        int round;
        int i2;
        if (gaVar == null && gaVar2 == null) {
            return 0L;
        }
        if (gaVar2 == null || b(gaVar) == 0) {
            i = -1;
        } else {
            gaVar = gaVar2;
            i = 1;
        }
        int c = c(gaVar);
        int d = d(gaVar);
        Rect c2 = transition.c();
        if (c2 != null) {
            i2 = c2.centerX();
            round = c2.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round2 = Math.round(iArr[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            round = Math.round(iArr[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            i2 = round2;
        }
        float a2 = a(c, d, i2, round) / a(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long b2 = transition.b();
        if (b2 < 0) {
            b2 = 300;
        }
        return Math.round((((float) (b2 * i)) / this.f985b) * a2);
    }

    private static float a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }
}
