package com.google.android.material.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1302a;

    /* renamed from: b  reason: collision with root package name */
    private final MaterialButton f1303b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private boolean w = false;

    static {
        f1302a = Build.VERSION.SDK_INT >= 21;
    }

    public b(MaterialButton materialButton) {
        this.f1303b = materialButton;
    }

    private Drawable i() {
        this.p = new GradientDrawable();
        this.p.setCornerRadius(this.g + 1.0E-5f);
        this.p.setColor(-1);
        this.q = androidx.core.graphics.drawable.a.i(this.p);
        androidx.core.graphics.drawable.a.a(this.q, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.q, mode);
        }
        this.r = new GradientDrawable();
        this.r.setCornerRadius(this.g + 1.0E-5f);
        this.r.setColor(-1);
        this.s = androidx.core.graphics.drawable.a.i(this.r);
        androidx.core.graphics.drawable.a.a(this.s, this.l);
        return a(new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    @TargetApi(21)
    private Drawable j() {
        this.t = new GradientDrawable();
        this.t.setCornerRadius(this.g + 1.0E-5f);
        this.t.setColor(-1);
        n();
        this.u = new GradientDrawable();
        this.u.setCornerRadius(this.g + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.h, this.k);
        InsetDrawable a2 = a(new LayerDrawable(new Drawable[]{this.t, this.u}));
        this.v = new GradientDrawable();
        this.v.setCornerRadius(this.g + 1.0E-5f);
        this.v.setColor(-1);
        return new a(com.google.android.material.g.a.a(this.l), a2, this.v);
    }

    private GradientDrawable k() {
        if (!f1302a || this.f1303b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f1303b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable l() {
        if (!f1302a || this.f1303b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f1303b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void m() {
        if (f1302a && this.u != null) {
            this.f1303b.setInternalBackground(j());
        } else if (f1302a) {
        } else {
            this.f1303b.invalidate();
        }
    }

    private void n() {
        GradientDrawable gradientDrawable = this.t;
        if (gradientDrawable != null) {
            androidx.core.graphics.drawable.a.a(gradientDrawable, this.j);
            PorterDuff.Mode mode = this.i;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.t, mode);
            }
        }
    }

    public void a(TypedArray typedArray) {
        this.c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        this.g = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, 0);
        this.h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.i = t.a(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = com.google.android.material.f.a.a(this.f1303b.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.k = com.google.android.material.f.a.a(this.f1303b.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.l = com.google.android.material.f.a.a(this.f1303b.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.h);
        Paint paint = this.m;
        ColorStateList colorStateList = this.k;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.f1303b.getDrawableState(), 0) : 0);
        int o = androidx.core.h.t.o(this.f1303b);
        int paddingTop = this.f1303b.getPaddingTop();
        int n = androidx.core.h.t.n(this.f1303b);
        int paddingBottom = this.f1303b.getPaddingBottom();
        this.f1303b.setInternalBackground(f1302a ? j() : i());
        androidx.core.h.t.b(this.f1303b, o + this.c, paddingTop + this.e, n + this.d, paddingBottom + this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (f1302a) {
                n();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, this.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode f() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.w = true;
        this.f1303b.setSupportBackgroundTintList(this.j);
        this.f1303b.setSupportBackgroundTintMode(this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            this.m.setColor(colorStateList != null ? colorStateList.getColorForState(this.f1303b.getDrawableState(), 0) : 0);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        GradientDrawable gradientDrawable;
        if (this.g != i) {
            this.g = i;
            if (f1302a && this.t != null && this.u != null && this.v != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f = i + 1.0E-5f;
                    k().setCornerRadius(f);
                    l().setCornerRadius(f);
                }
                float f2 = i + 1.0E-5f;
                this.t.setCornerRadius(f2);
                this.u.setCornerRadius(f2);
                this.v.setCornerRadius(f2);
            } else if (f1302a || (gradientDrawable = this.p) == null || this.r == null) {
            } else {
                float f3 = i + 1.0E-5f;
                gradientDrawable.setCornerRadius(f3);
                this.r.setCornerRadius(f3);
                this.f1303b.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        if (this.h != i) {
            this.h = i;
            this.m.setStrokeWidth(i);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (canvas == null || this.k == null || this.h <= 0) {
            return;
        }
        this.n.set(this.f1303b.getBackground().getBounds());
        RectF rectF = this.o;
        Rect rect = this.n;
        int i = this.h;
        rectF.set(rect.left + (i / 2.0f) + this.c, rect.top + (i / 2.0f) + this.e, (rect.right - (i / 2.0f)) - this.d, (rect.bottom - (i / 2.0f)) - this.f);
        float f = this.g - (this.h / 2.0f);
        canvas.drawRoundRect(this.o, f, f, this.m);
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.c, this.e, this.d, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2;
        if (this.i != mode) {
            this.i = mode;
            if (f1302a) {
                n();
                return;
            }
            Drawable drawable = this.q;
            if (drawable == null || (mode2 = this.i) == null) {
                return;
            }
            androidx.core.graphics.drawable.a.a(drawable, mode2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        GradientDrawable gradientDrawable = this.v;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.c, this.e, i2 - this.d, i - this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (f1302a && (gradientDrawable2 = this.t) != null) {
            gradientDrawable2.setColor(i);
        } else if (f1302a || (gradientDrawable = this.p) == null) {
        } else {
            gradientDrawable.setColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (f1302a && (this.f1303b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f1303b.getBackground()).setColor(colorStateList);
            } else if (f1302a || (drawable = this.s) == null) {
            } else {
                androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.g;
    }
}
