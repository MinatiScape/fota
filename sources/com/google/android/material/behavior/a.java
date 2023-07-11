package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HideBottomViewOnScrollBehavior.java */
/* loaded from: classes.dex */
public class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HideBottomViewOnScrollBehavior f1273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.f1273a = hideBottomViewOnScrollBehavior;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1273a.c = null;
    }
}
