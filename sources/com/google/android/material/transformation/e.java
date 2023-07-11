package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
/* compiled from: FabTransformationBehavior.java */
/* loaded from: classes.dex */
class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.material.circularreveal.e f1449a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Drawable f1450b;
    final /* synthetic */ FabTransformationBehavior c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.e eVar, Drawable drawable) {
        this.c = fabTransformationBehavior;
        this.f1449a = eVar;
        this.f1450b = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1449a.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1449a.setCircularRevealOverlayDrawable(this.f1450b);
    }
}
