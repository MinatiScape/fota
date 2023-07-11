package androidx.viewpager.widget;

import android.view.animation.Interpolator;
/* compiled from: ViewPager.java */
/* loaded from: classes.dex */
class e implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
