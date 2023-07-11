package com.google.android.material.appbar;

import android.animation.ValueAnimator;
/* compiled from: CollapsingToolbarLayout.java */
/* loaded from: classes.dex */
class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CollapsingToolbarLayout f1263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f1263a = collapsingToolbarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1263a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
