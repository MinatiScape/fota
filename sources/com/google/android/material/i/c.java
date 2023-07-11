package com.google.android.material.i;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable implements androidx.core.graphics.drawable.b {
    private e m;
    private PorterDuffColorFilter x;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1353a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f1354b = new Matrix[4];
    private final Matrix[] c = new Matrix[4];
    private final d[] d = new d[4];
    private final Matrix e = new Matrix();
    private final Path f = new Path();
    private final PointF g = new PointF();
    private final d h = new d();
    private final Region i = new Region();
    private final Region j = new Region();
    private final float[] k = new float[2];
    private final float[] l = new float[2];
    private boolean n = false;
    private boolean o = false;
    private float p = 1.0f;
    private int q = -16777216;
    private int r = 5;
    private int s = 10;
    private int t = 255;
    private float u = 1.0f;
    private float v = 0.0f;
    private Paint.Style w = Paint.Style.FILL_AND_STROKE;
    private PorterDuff.Mode y = PorterDuff.Mode.SRC_IN;
    private ColorStateList z = null;

    public c(e eVar) {
        this.m = null;
        this.m = eVar;
        for (int i = 0; i < 4; i++) {
            this.f1354b[i] = new Matrix();
            this.c[i] = new Matrix();
            this.d[i] = new d();
        }
    }

    private static int a(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private void c(int i, int i2, int i3) {
        a(i, i2, i3, this.g);
        a(i).a(a(i, i2, i3), this.p, this.d[i]);
        this.f1354b[i].reset();
        Matrix matrix = this.f1354b[i];
        PointF pointF = this.g;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f1354b[i].preRotate((float) Math.toDegrees(b(((i - 1) + 4) % 4, i2, i3) + 1.5707964f));
    }

    private void d(int i, int i2, int i3) {
        float[] fArr = this.k;
        d[] dVarArr = this.d;
        fArr[0] = dVarArr[i].c;
        fArr[1] = dVarArr[i].d;
        this.f1354b[i].mapPoints(fArr);
        float b2 = b(i, i2, i3);
        this.c[i].reset();
        Matrix matrix = this.c[i];
        float[] fArr2 = this.k;
        matrix.setTranslate(fArr2[0], fArr2[1]);
        this.c[i].preRotate((float) Math.toDegrees(b2));
    }

    public void a(boolean z) {
        this.n = z;
        invalidateSelf();
    }

    public ColorStateList b() {
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1353a.setColorFilter(this.x);
        int alpha = this.f1353a.getAlpha();
        this.f1353a.setAlpha(a(alpha, this.t));
        this.f1353a.setStrokeWidth(this.v);
        this.f1353a.setStyle(this.w);
        int i = this.r;
        if (i > 0 && this.n) {
            this.f1353a.setShadowLayer(this.s, 0.0f, i, this.q);
        }
        if (this.m != null) {
            b(canvas.getWidth(), canvas.getHeight(), this.f);
            canvas.drawPath(this.f, this.f1353a);
        } else {
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f1353a);
        }
        this.f1353a.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.i.set(bounds);
        b(bounds.width(), bounds.height(), this.f);
        this.j.setPath(this.f, this.i);
        this.i.op(this.j, Region.Op.DIFFERENCE);
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1353a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.z = colorStateList;
        c();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.y = mode;
        c();
        invalidateSelf();
    }

    private void b(int i, Path path) {
        int i2 = (i + 1) % 4;
        float[] fArr = this.k;
        d[] dVarArr = this.d;
        fArr[0] = dVarArr[i].c;
        fArr[1] = dVarArr[i].d;
        this.f1354b[i].mapPoints(fArr);
        float[] fArr2 = this.l;
        d[] dVarArr2 = this.d;
        fArr2[0] = dVarArr2[i2].f1355a;
        fArr2[1] = dVarArr2[i2].f1356b;
        this.f1354b[i2].mapPoints(fArr2);
        float[] fArr3 = this.k;
        float f = fArr3[0];
        float[] fArr4 = this.l;
        this.h.b(0.0f, 0.0f);
        b(i).a((float) Math.hypot(f - fArr4[0], fArr3[1] - fArr4[1]), this.p, this.h);
        this.h.a(this.c[i], path);
    }

    public float a() {
        return this.p;
    }

    public void a(float f) {
        this.p = f;
        invalidateSelf();
    }

    public void a(Paint.Style style) {
        this.w = style;
        invalidateSelf();
    }

    private void c() {
        ColorStateList colorStateList = this.z;
        if (colorStateList != null && this.y != null) {
            int colorForState = colorStateList.getColorForState(getState(), 0);
            this.x = new PorterDuffColorFilter(colorForState, this.y);
            if (this.o) {
                this.q = colorForState;
                return;
            }
            return;
        }
        this.x = null;
    }

    public void a(int i, int i2, Path path) {
        path.rewind();
        if (this.m == null) {
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            c(i3, i, i2);
            d(i3, i, i2);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            a(i4, path);
            b(i4, path);
        }
        path.close();
    }

    private b b(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return this.m.f();
                }
                return this.m.d();
            }
            return this.m.a();
        }
        return this.m.e();
    }

    private void a(int i, Path path) {
        float[] fArr = this.k;
        d[] dVarArr = this.d;
        fArr[0] = dVarArr[i].f1355a;
        fArr[1] = dVarArr[i].f1356b;
        this.f1354b[i].mapPoints(fArr);
        if (i == 0) {
            float[] fArr2 = this.k;
            path.moveTo(fArr2[0], fArr2[1]);
        } else {
            float[] fArr3 = this.k;
            path.lineTo(fArr3[0], fArr3[1]);
        }
        this.d[i].a(this.f1354b[i], path);
    }

    private float b(int i, int i2, int i3) {
        a(i, i2, i3, this.g);
        PointF pointF = this.g;
        float f = pointF.x;
        float f2 = pointF.y;
        a((i + 1) % 4, i2, i3, pointF);
        PointF pointF2 = this.g;
        return (float) Math.atan2(pointF2.y - f2, pointF2.x - f);
    }

    private a a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return this.m.g();
                }
                return this.m.b();
            }
            return this.m.c();
        }
        return this.m.h();
    }

    private void a(int i, int i2, int i3, PointF pointF) {
        if (i == 1) {
            pointF.set(i2, 0.0f);
        } else if (i == 2) {
            pointF.set(i2, i3);
        } else if (i != 3) {
            pointF.set(0.0f, 0.0f);
        } else {
            pointF.set(0.0f, i3);
        }
    }

    private void b(int i, int i2, Path path) {
        a(i, i2, path);
        if (this.u == 1.0f) {
            return;
        }
        this.e.reset();
        Matrix matrix = this.e;
        float f = this.u;
        matrix.setScale(f, f, i / 2, i2 / 2);
        path.transform(this.e);
    }

    private float a(int i, int i2, int i3) {
        float f;
        a(((i - 1) + 4) % 4, i2, i3, this.g);
        PointF pointF = this.g;
        float f2 = pointF.x;
        float f3 = pointF.y;
        a((i + 1) % 4, i2, i3, pointF);
        PointF pointF2 = this.g;
        float f4 = pointF2.x;
        float f5 = pointF2.y;
        a(i, i2, i3, pointF2);
        PointF pointF3 = this.g;
        float f6 = pointF3.x;
        float atan2 = ((float) Math.atan2(f3 - f, f2 - f6)) - ((float) Math.atan2(f5 - pointF3.y, f4 - f6));
        if (atan2 < 0.0f) {
            double d = atan2;
            Double.isNaN(d);
            return (float) (d + 6.283185307179586d);
        }
        return atan2;
    }
}
