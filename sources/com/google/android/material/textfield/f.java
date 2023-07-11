package com.google.android.material.textfield;

import android.animation.ValueAnimator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
public class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextInputLayout f1437a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TextInputLayout textInputLayout) {
        this.f1437a = textInputLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1437a.aa.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
