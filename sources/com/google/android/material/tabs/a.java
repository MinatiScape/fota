package com.google.android.material.tabs;

import android.animation.ValueAnimator;
/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TabLayout f1422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TabLayout tabLayout) {
        this.f1422a = tabLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1422a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
