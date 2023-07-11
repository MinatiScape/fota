package com.google.android.material.h;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.b.a.e;
import com.google.android.material.R$color;
/* compiled from: ShadowDrawableWrapper.java */
/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b  reason: collision with root package name */
    static final double f1352b = Math.cos(Math.toRadians(45.0d));
    final Paint c;
    final Paint d;
    final RectF e;
    float f;
    Path g;
    float h;
    float i;
    float j;
    float k;
    private boolean l;
    private final int m;
    private final int n;
    private final int o;
    private boolean p;
    private float q;
    private boolean r;

    public a(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.l = true;
        this.p = true;
        this.r = false;
        this.m = androidx.core.content.a.a(context, R$color.design_fab_shadow_start_color);
        this.n = androidx.core.content.a.a(context, R$color.design_fab_shadow_mid_color);
        this.o = androidx.core.content.a.a(context, R$color.design_fab_shadow_end_color);
        this.c = new Paint(5);
        this.c.setStyle(Paint.Style.FILL);
        this.f = Math.round(f);
        this.e = new RectF();
        this.d = new Paint(this.c);
        this.d.setAntiAlias(false);
        a(f2, f3);
    }

    private static int c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void a(boolean z) {
        this.p = z;
        invalidateSelf();
    }

    public void b(float f) {
        a(f, this.i);
    }

    @Override // androidx.appcompat.b.a.e, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            a(getBounds());
            this.l = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    @Override // androidx.appcompat.b.a.e, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.b.a.e, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(b(this.i, this.f, this.p));
        int ceil2 = (int) Math.ceil(a(this.i, this.f, this.p));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // androidx.appcompat.b.a.e, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.l = true;
    }

    @Override // androidx.appcompat.b.a.e, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.c.setAlpha(i);
        this.d.setAlpha(i);
    }

    public float b() {
        return this.k;
    }

    public static float b(float f, float f2, boolean z) {
        if (z) {
            double d = f * 1.5f;
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (d + ((1.0d - f1352b) * d2));
        }
        return f * 1.5f;
    }

    private void c() {
        float f = this.f;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.j;
        rectF2.inset(-f2, -f2);
        Path path = this.g;
        if (path == null) {
            this.g = new Path();
        } else {
            path.reset();
        }
        this.g.setFillType(Path.FillType.EVEN_ODD);
        this.g.moveTo(-this.f, 0.0f);
        this.g.rLineTo(-this.j, 0.0f);
        this.g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.g.arcTo(rectF, 270.0f, -90.0f, false);
        this.g.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            float f4 = this.f / f3;
            this.c.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.m, this.n, this.o}, new float[]{0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.d.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.m, this.n, this.o}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.d.setAntiAlias(false);
    }

    public void a(float f, float f2) {
        if (f >= 0.0f && f2 >= 0.0f) {
            float c = c(f);
            float c2 = c(f2);
            if (c > c2) {
                if (!this.r) {
                    this.r = true;
                }
                c = c2;
            }
            if (this.k == c && this.i == c2) {
                return;
            }
            this.k = c;
            this.i = c2;
            this.j = Math.round(c * 1.5f);
            this.h = c2;
            this.l = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    public static float a(float f, float f2, boolean z) {
        if (z) {
            double d = f;
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (d + ((1.0d - f1352b) * d2));
        }
        return f;
    }

    public final void a(float f) {
        if (this.q != f) {
            this.q = f;
            invalidateSelf();
        }
    }

    private void a(Canvas canvas) {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        int save = canvas.save();
        canvas.rotate(this.q, this.e.centerX(), this.e.centerY());
        float f5 = this.f;
        float f6 = (-f5) - this.j;
        float f7 = f5 * 2.0f;
        boolean z = this.e.width() - f7 > 0.0f;
        boolean z2 = this.e.height() - f7 > 0.0f;
        float f8 = this.k;
        float f9 = f5 / ((f8 - (0.5f * f8)) + f5);
        float f10 = f5 / ((f8 - (0.25f * f8)) + f5);
        float f11 = f5 / ((f8 - (f8 * 1.0f)) + f5);
        int save2 = canvas.save();
        RectF rectF = this.e;
        canvas.translate(rectF.left + f5, rectF.top + f5);
        canvas.scale(f9, f10);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            i = save2;
            f = f11;
            i2 = save;
            f2 = f10;
            canvas.drawRect(0.0f, f6, this.e.width() - f7, -this.f, this.d);
        } else {
            i = save2;
            f = f11;
            i2 = save;
            f2 = f10;
        }
        canvas.restoreToCount(i);
        int save3 = canvas.save();
        RectF rectF2 = this.e;
        canvas.translate(rectF2.right - f5, rectF2.bottom - f5);
        float f12 = f;
        canvas.scale(f9, f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            f3 = f2;
            f4 = f12;
            canvas.drawRect(0.0f, f6, this.e.width() - f7, (-this.f) + this.j, this.d);
        } else {
            f3 = f2;
            f4 = f12;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.e;
        canvas.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas.scale(f9, f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f6, this.e.height() - f7, -this.f, this.d);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.e;
        canvas.translate(rectF4.right - f5, rectF4.top + f5);
        float f13 = f3;
        canvas.scale(f9, f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f6, this.e.height() - f7, -this.f, this.d);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i2);
    }

    private void a(Rect rect) {
        float f = this.i;
        float f2 = 1.5f * f;
        this.e.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        Drawable a2 = a();
        RectF rectF = this.e;
        a2.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        c();
    }
}
