package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.e;
/* compiled from: FabTransformationBehavior.java */
/* loaded from: classes.dex */
class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.material.circularreveal.e f1451a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f1452b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.e eVar) {
        this.f1452b = fabTransformationBehavior;
        this.f1451a = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e.d revealInfo = this.f1451a.getRevealInfo();
        revealInfo.c = Float.MAX_VALUE;
        this.f1451a.setRevealInfo(revealInfo);
    }
}
