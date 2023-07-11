package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.widget.TextView;
/* compiled from: TextScale.java */
/* loaded from: classes.dex */
class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextView f1390a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ r f1391b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(r rVar, TextView textView) {
        this.f1391b = rVar;
        this.f1390a = textView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f1390a.setScaleX(floatValue);
        this.f1390a.setScaleY(floatValue);
    }
}
