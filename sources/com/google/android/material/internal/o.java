package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar) {
        this.f1385a = pVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        p pVar = this.f1385a;
        if (pVar.c == animator) {
            pVar.c = null;
        }
    }
}
