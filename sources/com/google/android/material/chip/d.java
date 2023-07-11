package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.a.h;
import com.google.android.material.R$styleable;
import com.google.android.material.a.h;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* compiled from: ChipDrawable.java */
/* loaded from: classes.dex */
public class d extends Drawable implements androidx.core.graphics.drawable.b, Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1313a = {16842910};
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private final Context H;
    private final Paint K;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private int T;
    private ColorFilter V;
    private PorterDuffColorFilter W;
    private ColorStateList X;
    private int[] Z;
    private boolean aa;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1314b;
    private ColorStateList ba;
    private float c;
    private float d;
    private ColorStateList e;
    private float ea;
    private float f;
    private TextUtils.TruncateAt fa;
    private ColorStateList g;
    private boolean ga;
    private int ha;
    private CharSequence i;
    private com.google.android.material.f.c j;
    private boolean l;
    private Drawable m;
    private ColorStateList n;
    private float o;
    private boolean p;
    private Drawable q;
    private ColorStateList r;
    private float s;
    private CharSequence t;
    private boolean u;
    private boolean v;
    private Drawable w;
    private h x;
    private h y;
    private float z;
    private final h.a k = new c(this);
    private final TextPaint I = new TextPaint(1);
    private final Paint J = new Paint(1);
    private final Paint.FontMetrics L = new Paint.FontMetrics();
    private final RectF M = new RectF();
    private final PointF N = new PointF();
    private int U = 255;
    private PorterDuff.Mode Y = PorterDuff.Mode.SRC_IN;
    private WeakReference<a> ca = new WeakReference<>(null);
    private boolean da = true;
    private CharSequence h = "";

    /* compiled from: ChipDrawable.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    private d(Context context) {
        this.H = context;
        this.I.density = context.getResources().getDisplayMetrics().density;
        this.K = null;
        Paint paint = this.K;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(f1313a);
        a(f1313a);
        this.ga = true;
    }

    private float K() {
        if (R()) {
            return this.E + this.s + this.F;
        }
        return 0.0f;
    }

    private float L() {
        this.I.getFontMetrics(this.L);
        Paint.FontMetrics fontMetrics = this.L;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean M() {
        return this.v && this.w != null && this.u;
    }

    private float N() {
        if (!this.da) {
            return this.ea;
        }
        this.ea = c(this.i);
        this.da = false;
        return this.ea;
    }

    private ColorFilter O() {
        ColorFilter colorFilter = this.V;
        return colorFilter != null ? colorFilter : this.W;
    }

    private boolean P() {
        return this.v && this.w != null && this.S;
    }

    private boolean Q() {
        return this.l && this.m != null;
    }

    private boolean R() {
        return this.p && this.q != null;
    }

    private void S() {
        this.ba = this.aa ? com.google.android.material.g.a.a(this.g) : null;
    }

    private void b(Canvas canvas, Rect rect) {
        this.J.setColor(this.O);
        this.J.setStyle(Paint.Style.FILL);
        this.J.setColorFilter(O());
        this.M.set(rect);
        RectF rectF = this.M;
        float f = this.d;
        canvas.drawRoundRect(rectF, f, f, this.J);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.I.measureText(charSequence, 0, charSequence.length());
    }

    private void d(Canvas canvas, Rect rect) {
        if (this.f > 0.0f) {
            this.J.setColor(this.P);
            this.J.setStyle(Paint.Style.STROKE);
            this.J.setColorFilter(O());
            RectF rectF = this.M;
            float f = this.f;
            rectF.set(rect.left + (f / 2.0f), rect.top + (f / 2.0f), rect.right - (f / 2.0f), rect.bottom - (f / 2.0f));
            float f2 = this.d - (this.f / 2.0f);
            canvas.drawRoundRect(this.M, f2, f2, this.J);
        }
    }

    private void e(Canvas canvas, Rect rect) {
        if (R()) {
            c(rect, this.M);
            RectF rectF = this.M;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.q.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.q.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void g(Canvas canvas, Rect rect) {
        Paint paint = this.K;
        if (paint != null) {
            paint.setColor(androidx.core.a.a.b(-16777216, 127));
            canvas.drawRect(rect, this.K);
            if (Q() || P()) {
                a(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            if (this.i != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.K);
            }
            if (R()) {
                c(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            this.K.setColor(androidx.core.a.a.b(-65536, 127));
            b(rect, this.M);
            canvas.drawRect(this.M, this.K);
            this.K.setColor(androidx.core.a.a.b(-16711936, 127));
            d(rect, this.M);
            canvas.drawRect(this.M, this.K);
        }
    }

    private void h(Canvas canvas, Rect rect) {
        if (this.i != null) {
            Paint.Align a2 = a(rect, this.N);
            e(rect, this.M);
            if (this.j != null) {
                this.I.drawableState = getState();
                this.j.b(this.H, this.I, this.k);
            }
            this.I.setTextAlign(a2);
            int i = 0;
            boolean z = Math.round(N()) > Math.round(this.M.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.M);
            }
            CharSequence charSequence = this.i;
            if (z && this.fa != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.I, this.M.width(), this.fa);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.N;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.I);
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    public com.google.android.material.f.c A() {
        return this.j;
    }

    public float B() {
        return this.D;
    }

    public float C() {
        return this.C;
    }

    public boolean D() {
        return this.u;
    }

    public boolean E() {
        return this.v;
    }

    public boolean F() {
        return this.l;
    }

    public boolean G() {
        return e(this.q);
    }

    public boolean H() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        a aVar = this.ca.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J() {
        return this.ga;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.U;
        int a2 = i < 255 ? com.google.android.material.b.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        b(canvas, bounds);
        d(canvas, bounds);
        f(canvas, bounds);
        c(canvas, bounds);
        a(canvas, bounds);
        if (this.ga) {
            h(canvas, bounds);
        }
        e(canvas, bounds);
        g(canvas, bounds);
        if (this.U < 255) {
            canvas.restoreToCount(a2);
        }
    }

    public void f(boolean z) {
        if (this.aa != z) {
            this.aa = z;
            S();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.U;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.V;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.z + a() + this.C + N() + this.D + K() + this.G), this.ha);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.d);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.d);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public float i() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return f(this.f1314b) || f(this.e) || (this.aa && f(this.ba)) || b(this.j) || M() || e(this.m) || e(this.w) || f(this.X);
    }

    public void j(int i) {
        c(this.H.getResources().getBoolean(i));
    }

    public void k(int i) {
        d(this.H.getResources().getDimension(i));
    }

    public float l() {
        return this.f;
    }

    public void m(int i) {
        c(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void n(int i) {
        f(this.H.getResources().getDimension(i));
    }

    public float o() {
        return this.F;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (Q()) {
            onLayoutDirectionChanged |= this.m.setLayoutDirection(i);
        }
        if (P()) {
            onLayoutDirectionChanged |= this.w.setLayoutDirection(i);
        }
        if (R()) {
            onLayoutDirectionChanged |= this.q.setLayoutDirection(i);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (Q()) {
            onLevelChange |= this.m.setLevel(i);
        }
        if (P()) {
            onLevelChange |= this.w.setLevel(i);
        }
        if (R()) {
            onLevelChange |= this.q.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return a(iArr, r());
    }

    public void p(int i) {
        c(androidx.appcompat.a.a.a.b(this.H, i));
    }

    public void q(int i) {
        h(this.H.getResources().getDimension(i));
    }

    public int[] r() {
        return this.Z;
    }

    public ColorStateList s() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.U != i) {
            this.U = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.V != colorFilter) {
            this.V = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.Y != mode) {
            this.Y = mode;
            this.W = com.google.android.material.c.a.a(this, this.X, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (Q()) {
            visible |= this.m.setVisible(z, z2);
        }
        if (P()) {
            visible |= this.w.setVisible(z, z2);
        }
        if (R()) {
            visible |= this.q.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public TextUtils.TruncateAt t() {
        return this.fa;
    }

    public com.google.android.material.a.h u() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v() {
        return this.B;
    }

    public float w() {
        return this.A;
    }

    public ColorStateList x() {
        return this.g;
    }

    public void y(int i) {
        e(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public CharSequence z() {
        return this.h;
    }

    public static d a(Context context, AttributeSet attributeSet, int i, int i2) {
        d dVar = new d(context);
        dVar.a(attributeSet, i, i2);
        return dVar;
    }

    private void c(Canvas canvas, Rect rect) {
        if (Q()) {
            a(rect, this.M);
            RectF rectF = this.M;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.m.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.m.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public void A(int i) {
        a(new com.google.android.material.f.c(this.H, i));
    }

    public void B(int i) {
        l(this.H.getResources().getDimension(i));
    }

    public void C(int i) {
        m(this.H.getResources().getDimension(i));
    }

    public void i(int i) {
        b(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public float j() {
        return this.z;
    }

    public ColorStateList k() {
        return this.e;
    }

    public void l(int i) {
        e(this.H.getResources().getDimension(i));
    }

    public Drawable m() {
        Drawable drawable = this.q;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public CharSequence n() {
        return this.t;
    }

    public void o(int i) {
        g(this.H.getResources().getDimension(i));
    }

    public float p() {
        return this.s;
    }

    public float q() {
        return this.E;
    }

    public void r(int i) {
        i(this.H.getResources().getDimension(i));
    }

    public void s(int i) {
        d(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void t(int i) {
        d(this.H.getResources().getBoolean(i));
    }

    public void u(int i) {
        a(com.google.android.material.a.h.a(this.H, i));
    }

    public void v(int i) {
        j(this.H.getResources().getDimension(i));
    }

    public void w(int i) {
        k(this.H.getResources().getDimension(i));
    }

    public void x(int i) {
        this.ha = i;
    }

    public com.google.android.material.a.h y() {
        return this.x;
    }

    public void z(int i) {
        b(com.google.android.material.a.h.a(this.H, i));
    }

    public void i(float f) {
        if (this.E != f) {
            this.E = f;
            invalidateSelf();
            if (R()) {
                I();
            }
        }
    }

    public void j(float f) {
        if (this.B != f) {
            float a2 = a();
            this.B = f;
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void k(float f) {
        if (this.A != f) {
            float a2 = a();
            this.A = f;
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void l(float f) {
        if (this.D != f) {
            this.D = f;
            invalidateSelf();
            I();
        }
    }

    public void m(float f) {
        if (this.C != f) {
            this.C = f;
            invalidateSelf();
            I();
        }
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        TypedArray a2 = s.a(this.H, attributeSet, R$styleable.Chip, i, i2, new int[0]);
        a(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_chipBackgroundColor));
        d(a2.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        a(a2.getDimension(R$styleable.Chip_chipCornerRadius, 0.0f));
        c(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_chipStrokeColor));
        f(a2.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        e(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_rippleColor));
        b(a2.getText(R$styleable.Chip_android_text));
        a(com.google.android.material.f.a.c(this.H, a2, R$styleable.Chip_android_textAppearance));
        int i3 = a2.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i3 == 1) {
            a(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            a(TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            a(TextUtils.TruncateAt.END);
        }
        c(a2.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            c(a2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        b(com.google.android.material.f.a.b(this.H, a2, R$styleable.Chip_chipIcon));
        b(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_chipIconTint));
        c(a2.getDimension(R$styleable.Chip_chipIconSize, 0.0f));
        d(a2.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            d(a2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        c(com.google.android.material.f.a.b(this.H, a2, R$styleable.Chip_closeIcon));
        d(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_closeIconTint));
        h(a2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        a(a2.getBoolean(R$styleable.Chip_android_checkable, false));
        b(a2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            b(a2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        a(com.google.android.material.f.a.b(this.H, a2, R$styleable.Chip_checkedIcon));
        b(com.google.android.material.a.h.a(this.H, a2, R$styleable.Chip_showMotionSpec));
        a(com.google.android.material.a.h.a(this.H, a2, R$styleable.Chip_hideMotionSpec));
        e(a2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        k(a2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        j(a2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        m(a2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        l(a2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        i(a2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        g(a2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        b(a2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        x(a2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        a2.recycle();
    }

    private void f(Canvas canvas, Rect rect) {
        this.J.setColor(this.Q);
        this.J.setStyle(Paint.Style.FILL);
        this.M.set(rect);
        RectF rectF = this.M;
        float f = this.d;
        canvas.drawRoundRect(rectF, f, f, this.J);
    }

    private void b(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (R()) {
            float f = this.G + this.F + this.s + this.E + this.D;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    private void d(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (R()) {
            float f = this.G + this.F + this.s + this.E + this.D;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.i != null) {
            float a2 = this.z + a() + this.C;
            float K = this.G + K() + this.D;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = rect.left + a2;
                rectF.right = rect.right - K;
            } else {
                rectF.left = rect.left + K;
                rectF.right = rect.right - a2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean f(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (R()) {
            float f = this.G + this.F;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.s;
            } else {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.s;
            }
            float exactCenterY = rect.exactCenterY();
            float f2 = this.s;
            rectF.top = exactCenterY - (f2 / 2.0f);
            rectF.bottom = rectF.top + f2;
        }
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void f(float f) {
        if (this.f != f) {
            this.f = f;
            this.J.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    private static boolean b(com.google.android.material.f.c cVar) {
        ColorStateList colorStateList;
        return (cVar == null || (colorStateList = cVar.f1333b) == null || !colorStateList.isStateful()) ? false : true;
    }

    public void b(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.h != charSequence) {
            this.h = charSequence;
            this.i = androidx.core.f.a.a().a(charSequence);
            this.da = true;
            invalidateSelf();
            I();
        }
    }

    public Drawable f() {
        Drawable drawable = this.m;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public void f(int i) {
        b(this.H.getResources().getDimension(i));
    }

    public ColorStateList h() {
        return this.n;
    }

    public void h(int i) {
        c(this.H.getResources().getDimension(i));
    }

    private void d(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.a(drawable, androidx.core.graphics.drawable.a.e(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.q) {
                if (drawable.isStateful()) {
                    drawable.setState(r());
                }
                androidx.core.graphics.drawable.a.a(drawable, this.r);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    public void h(float f) {
        if (this.s != f) {
            this.s = f;
            invalidateSelf();
            if (R()) {
                I();
            }
        }
    }

    private static boolean e(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public void b(Drawable drawable) {
        Drawable f = f();
        if (f != drawable) {
            float a2 = a();
            this.m = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            float a3 = a();
            f(f);
            if (Q()) {
                d(this.m);
            }
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public ColorStateList c() {
        return this.f1314b;
    }

    public void g(int i) {
        b(androidx.appcompat.a.a.a.b(this.H, i));
    }

    public void c(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            onStateChange(getState());
        }
    }

    public void e(int i) {
        a(this.H.getResources().getDimension(i));
    }

    public float g() {
        return this.o;
    }

    public void e(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            S();
            onStateChange(getState());
        }
    }

    public void g(float f) {
        if (this.F != f) {
            this.F = f;
            invalidateSelf();
            if (R()) {
                I();
            }
        }
    }

    public void c(boolean z) {
        if (this.l != z) {
            boolean Q = Q();
            this.l = z;
            boolean Q2 = Q();
            if (Q != Q2) {
                if (Q2) {
                    d(this.m);
                } else {
                    f(this.m);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void e(float f) {
        if (this.z != f) {
            this.z = f;
            invalidateSelf();
            I();
        }
    }

    public void d(int i) {
        a(androidx.appcompat.a.a.a.a(this.H, i));
    }

    public void b(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            if (Q()) {
                androidx.core.graphics.drawable.a.a(this.m, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void d(float f) {
        if (this.c != f) {
            this.c = f;
            invalidateSelf();
            I();
        }
    }

    public float e() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z) {
        this.ga = z;
    }

    public void c(float f) {
        if (this.o != f) {
            float a2 = a();
            this.o = f;
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public float d() {
        return this.d;
    }

    public void b(boolean z) {
        if (this.v != z) {
            boolean P = P();
            this.v = z;
            boolean P2 = P();
            if (P != P2) {
                if (P2) {
                    d(this.w);
                } else {
                    f(this.w);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void d(boolean z) {
        if (this.p != z) {
            boolean R = R();
            this.p = z;
            boolean R2 = R();
            if (R != R2) {
                if (R2) {
                    d(this.q);
                } else {
                    f(this.q);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void c(Drawable drawable) {
        Drawable m = m();
        if (m != drawable) {
            float K = K();
            this.q = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            float K2 = K();
            f(m);
            if (R()) {
                d(this.q);
            }
            invalidateSelf();
            if (K != K2) {
                I();
            }
        }
    }

    public Drawable b() {
        return this.w;
    }

    public void d(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            if (R()) {
                androidx.core.graphics.drawable.a.a(this.q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b(int i) {
        a(androidx.appcompat.a.a.a.b(this.H, i));
    }

    public void b(com.google.android.material.a.h hVar) {
        this.x = hVar;
    }

    public void b(float f) {
        if (this.G != f) {
            this.G = f;
            invalidateSelf();
            I();
        }
    }

    public void c(int i) {
        b(this.H.getResources().getBoolean(i));
    }

    public void a(a aVar) {
        this.ca = new WeakReference<>(aVar);
    }

    public void a(RectF rectF) {
        d(getBounds(), rectF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        if (Q() || P()) {
            return this.A + this.o + this.B;
        }
        return 0.0f;
    }

    private void a(Canvas canvas, Rect rect) {
        if (P()) {
            a(rect, this.M);
            RectF rectF = this.M;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.w.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.w.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Q() || P()) {
            float f = this.z + this.A;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.o;
            } else {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.o;
            }
            float exactCenterY = rect.exactCenterY();
            float f2 = this.o;
            rectF.top = exactCenterY - (f2 / 2.0f);
            rectF.bottom = rectF.top + f2;
        }
    }

    Paint.Align a(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.i != null) {
            float a2 = this.z + a() + this.C;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                pointF.x = rect.left + a2;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - a2;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - L();
        }
        return align;
    }

    public boolean a(int[] iArr) {
        if (Arrays.equals(this.Z, iArr)) {
            return false;
        }
        this.Z = iArr;
        if (R()) {
            return a(getState(), iArr);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(int[] r6, int[] r7) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.d.a(int[], int[]):boolean");
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public void a(ColorStateList colorStateList) {
        if (this.f1314b != colorStateList) {
            this.f1314b = colorStateList;
            onStateChange(getState());
        }
    }

    public void a(float f) {
        if (this.d != f) {
            this.d = f;
            invalidateSelf();
        }
    }

    public void a(com.google.android.material.f.c cVar) {
        if (this.j != cVar) {
            this.j = cVar;
            if (cVar != null) {
                cVar.c(this.H, this.I, this.k);
                this.da = true;
            }
            onStateChange(getState());
            I();
        }
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.fa = truncateAt;
    }

    public void a(CharSequence charSequence) {
        if (this.t != charSequence) {
            this.t = androidx.core.f.a.a().a(charSequence);
            invalidateSelf();
        }
    }

    public void a(int i) {
        a(this.H.getResources().getBoolean(i));
    }

    public void a(boolean z) {
        if (this.u != z) {
            this.u = z;
            float a2 = a();
            if (!z && this.S) {
                this.S = false;
            }
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void a(Drawable drawable) {
        if (this.w != drawable) {
            float a2 = a();
            this.w = drawable;
            float a3 = a();
            f(this.w);
            d(this.w);
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void a(com.google.android.material.a.h hVar) {
        this.y = hVar;
    }
}
