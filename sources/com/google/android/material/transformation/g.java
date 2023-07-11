package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* compiled from: FabTransformationScrimBehavior.java */
/* loaded from: classes.dex */
class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1453a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f1454b;
    final /* synthetic */ FabTransformationScrimBehavior c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
        this.c = fabTransformationScrimBehavior;
        this.f1453a = z;
        this.f1454b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f1453a) {
            return;
        }
        this.f1454b.setVisibility(4);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.f1453a) {
            this.f1454b.setVisibility(0);
        }
    }
}
