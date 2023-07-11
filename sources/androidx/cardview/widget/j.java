package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;
/* compiled from: RoundRectDrawableWithShadow.java */
/* loaded from: classes.dex */
class j extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private static final double f384a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b  reason: collision with root package name */
    static a f385b;
    private final int c;
    private Paint e;
    private Paint f;
    private final RectF g;
    private float h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private ColorStateList m;
    private final int o;
    private final int p;
    private boolean n = true;
    private boolean q = true;
    private boolean r = false;
    private Paint d = new Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    /* loaded from: classes.dex */
    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.o = resources.getColor(R$color.cardview_shadow_start_color);
        this.p = resources.getColor(R$color.cardview_shadow_end_color);
        this.c = resources.getDimensionPixelSize(R$dimen.cardview_compat_inset_shadow);
        b(colorStateList);
        this.e = new Paint(5);
        this.e.setStyle(Paint.Style.FILL);
        this.h = (int) (f + 0.5f);
        this.g = new RectF();
        this.f = new Paint(this.e);
        this.f.setAntiAlias(false);
        a(f2, f3);
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private int d(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void g() {
        float f = this.h;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.k;
        rectF2.inset(-f2, -f2);
        Path path = this.i;
        if (path == null) {
            this.i = new Path();
        } else {
            path.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.h, 0.0f);
        this.i.rLineTo(-this.k, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f3 = this.h;
        float f4 = this.k;
        Paint paint = this.e;
        float f5 = f3 + f4;
        int i = this.o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.p}, new float[]{0.0f, f3 / (f3 + f4), 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f;
        float f6 = this.h;
        float f7 = this.k;
        int i2 = this.o;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f.setAntiAlias(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        a(f, this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.l) / 2.0f);
        f385b.a(canvas, this.g, this.h, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        float f = this.j;
        return (Math.max(f, this.h + this.c + (f / 2.0f)) * 2.0f) + ((this.j + this.c) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(b(this.j, this.h, this.q));
        int ceil2 = (int) Math.ceil(a(this.j, this.h, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.d.getColor() == colorForState) {
            return false;
        }
        this.d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d.setAlpha(i);
        this.e.setAlpha(i);
        this.f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        float f = this.j;
        return (Math.max(f, this.h + this.c + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.j * 1.5f) + this.c) * 2.0f);
    }

    private void a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float d = d(f);
            float d2 = d(f2);
            if (d > d2) {
                if (!this.r) {
                    this.r = true;
                }
                d = d2;
            }
            if (this.l == d && this.j == d2) {
                return;
            }
            this.l = d;
            this.j = d2;
            this.k = (int) ((d * 1.5f) + this.c + 0.5f);
            this.n = true;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f, float f2, boolean z) {
        if (z) {
            double d = f * 1.5f;
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (d + ((1.0d - f384a) * d2));
        }
        return f * 1.5f;
    }

    private void b(Rect rect) {
        float f = this.j;
        float f2 = 1.5f * f;
        this.g.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        a(this.l, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f, float f2, boolean z) {
        if (z) {
            double d = f;
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (d + ((1.0d - f384a) * d2));
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        if (f >= 0.0f) {
            float f2 = (int) (f + 0.5f);
            if (this.h == f2) {
                return;
            }
            this.h = f2;
            this.n = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    private void a(Canvas canvas) {
        float f = this.h;
        float f2 = (-f) - this.k;
        float f3 = f + this.c + (this.l / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.g.width() - f4 > 0.0f;
        boolean z2 = this.g.height() - f4 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.g;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.i, this.e);
        if (z) {
            canvas.drawRect(0.0f, f2, this.g.width() - f4, -this.h, this.f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.g;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (z) {
            canvas.drawRect(0.0f, f2, this.g.width() - f4, (-this.h) + this.k, this.f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.g;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.g.height() - f4, -this.h, this.f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.g;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.g.height() - f4, -this.h, this.f);
        }
        canvas.restoreToCount(save4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.m;
    }
}
