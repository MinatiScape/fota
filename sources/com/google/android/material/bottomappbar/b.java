package com.google.android.material.bottomappbar;

import android.animation.ValueAnimator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
public class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BottomAppBar bottomAppBar) {
        this.f1277a = bottomAppBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        i iVar;
        com.google.android.material.i.c cVar;
        iVar = this.f1277a.R;
        iVar.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
        cVar = this.f1277a.Q;
        cVar.invalidateSelf();
    }
}
