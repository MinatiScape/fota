package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
/* loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] c = {16842912};
    private boolean d;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.d) {
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + c.length), c);
        }
        return super.onCreateDrawableState(i);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.d != z) {
            this.d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        androidx.core.h.t.a(this, new a(this));
    }
}
