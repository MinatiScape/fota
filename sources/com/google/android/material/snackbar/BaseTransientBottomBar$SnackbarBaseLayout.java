package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.h.a.b;
import androidx.core.h.t;
import com.google.android.material.R$styleable;
/* loaded from: classes.dex */
public class BaseTransientBottomBar$SnackbarBaseLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityManager f1395a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f1396b;
    private c c;
    private b d;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar$SnackbarBaseLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
        setClickable(!z);
        setFocusable(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        t.D(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
        androidx.core.h.a.b.b(this.f1395a, this.f1396b);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this, i, i2, i3, i4);
        }
    }

    void setOnAttachStateChangeListener(b bVar) {
        this.d = bVar;
    }

    void setOnLayoutChangeListener(c cVar) {
        this.c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar$SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
            t.a(this, obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        this.f1395a = (AccessibilityManager) context.getSystemService("accessibility");
        this.f1396b = new d(this);
        androidx.core.h.a.b.a(this.f1395a, this.f1396b);
        setClickableOrFocusableBasedOnAccessibility(this.f1395a.isTouchExplorationEnabled());
    }
}
