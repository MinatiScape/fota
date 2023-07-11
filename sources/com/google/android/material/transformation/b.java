package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpandableTransformationBehavior.java */
/* loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExpandableTransformationBehavior f1444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ExpandableTransformationBehavior expandableTransformationBehavior) {
        this.f1444a = expandableTransformationBehavior;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1444a.f1439b = null;
    }
}
