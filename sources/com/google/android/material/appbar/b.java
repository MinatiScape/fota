package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
/* compiled from: AppBarLayout.java */
/* loaded from: classes.dex */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f1260a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppBarLayout f1261b;
    final /* synthetic */ AppBarLayout.BaseBehavior c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c = baseBehavior;
        this.f1260a = coordinatorLayout;
        this.f1261b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.c(this.f1260a, (CoordinatorLayout) this.f1261b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
