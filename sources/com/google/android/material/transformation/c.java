package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* compiled from: FabTransformationBehavior.java */
/* loaded from: classes.dex */
class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1445a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f1446b;
    final /* synthetic */ View c;
    final /* synthetic */ FabTransformationBehavior d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
        this.d = fabTransformationBehavior;
        this.f1445a = z;
        this.f1446b = view;
        this.c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f1445a) {
            return;
        }
        this.f1446b.setVisibility(4);
        this.c.setAlpha(1.0f);
        this.c.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.f1445a) {
            this.f1446b.setVisibility(0);
            this.c.setAlpha(0.0f);
            this.c.setVisibility(4);
        }
    }
}
