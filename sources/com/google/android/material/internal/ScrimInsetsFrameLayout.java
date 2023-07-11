package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.h.D;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f1365a;

    /* renamed from: b  reason: collision with root package name */
    Rect f1366b;
    private Rect c;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(D d) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f1366b == null || this.f1365a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        this.c.set(0, 0, width, this.f1366b.top);
        this.f1365a.setBounds(this.c);
        this.f1365a.draw(canvas);
        this.c.set(0, height - this.f1366b.bottom, width, height);
        this.f1365a.setBounds(this.c);
        this.f1365a.draw(canvas);
        Rect rect = this.c;
        Rect rect2 = this.f1366b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f1365a.setBounds(this.c);
        this.f1365a.draw(canvas);
        Rect rect3 = this.c;
        Rect rect4 = this.f1366b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f1365a.setBounds(this.c);
        this.f1365a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f1365a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f1365a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        TypedArray a2 = s.a(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f1365a = a2.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        a2.recycle();
        setWillNotDraw(true);
        androidx.core.h.t.a(this, new n(this));
    }
}
