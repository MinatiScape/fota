package com.google.android.material.bottomappbar;

import android.animation.ValueAnimator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
public class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BottomAppBar bottomAppBar) {
        this.f1282a = bottomAppBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        com.google.android.material.i.c cVar;
        cVar = this.f1282a.Q;
        cVar.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
