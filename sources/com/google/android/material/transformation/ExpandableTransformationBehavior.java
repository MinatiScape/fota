package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b  reason: collision with root package name */
    private AnimatorSet f1439b;

    public ExpandableTransformationBehavior() {
    }

    protected abstract AnimatorSet b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f1439b != null;
        if (z3) {
            this.f1439b.cancel();
        }
        this.f1439b = b(view, view2, z, z3);
        this.f1439b.addListener(new b(this));
        this.f1439b.start();
        if (!z2) {
            this.f1439b.end();
        }
        return true;
    }
}
