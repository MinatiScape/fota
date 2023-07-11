package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* compiled from: CircularBorderDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable {
    float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private int k;
    private float m;

    /* renamed from: b  reason: collision with root package name */
    final Rect f1369b = new Rect();
    final RectF c = new RectF();
    final a d = new a();
    private boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    final Paint f1368a = new Paint(1);

    /* compiled from: CircularBorderDrawable.java */
    /* loaded from: classes.dex */
    private class a extends Drawable.ConstantState {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c() {
        this.f1368a.setStyle(Paint.Style.STROKE);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public final void b(float f) {
        if (f != this.m) {
            this.m = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            this.f1368a.setShader(a());
            this.l = false;
        }
        float strokeWidth = this.f1368a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        copyBounds(this.f1369b);
        rectF.set(this.f1369b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f1368a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.e > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int round = Math.round(this.e);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.j;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.k)) != this.k) {
            this.l = true;
            this.k = colorForState;
        }
        if (this.l) {
            invalidateSelf();
        }
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1368a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1368a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void a(float f) {
        if (this.e != f) {
            this.e = f;
            this.f1368a.setStrokeWidth(f * 1.3333f);
            this.l = true;
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        invalidateSelf();
    }

    private Shader a() {
        Rect rect = this.f1369b;
        copyBounds(rect);
        float height = this.e / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{androidx.core.a.a.a(this.f, this.k), androidx.core.a.a.a(this.g, this.k), androidx.core.a.a.a(androidx.core.a.a.b(this.g, 0), this.k), androidx.core.a.a.a(androidx.core.a.a.b(this.i, 0), this.k), androidx.core.a.a.a(this.i, this.k), androidx.core.a.a.a(this.h, this.k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }
}
