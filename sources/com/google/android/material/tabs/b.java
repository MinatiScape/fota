package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import com.google.android.material.tabs.TabLayout;
/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1423a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1424b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ TabLayout.e e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TabLayout.e eVar, int i, int i2, int i3, int i4) {
        this.e = eVar;
        this.f1423a = i;
        this.f1424b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.e.b(com.google.android.material.a.a.a(this.f1423a, this.f1424b, animatedFraction), com.google.android.material.a.a.a(this.c, this.d, animatedFraction));
    }
}
