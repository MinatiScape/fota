package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.view.View;
/* compiled from: FabTransformationBehavior.java */
/* loaded from: classes.dex */
class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1447a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f1448b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f1448b = fabTransformationBehavior;
        this.f1447a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1447a.invalidate();
    }
}
