package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f1367a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f1367a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f1367a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1367a = getVisibility();
    }
}
