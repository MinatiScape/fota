package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public class d extends Drawable implements Animatable {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f883a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f884b = new a.d.a.a.b();
    private static final int[] c = {-16777216};
    private final a d;
    private float e;
    private Resources f;
    private Animator g;
    float h;
    boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public static class a {
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float q;
        int r;
        int s;
        int u;

        /* renamed from: a  reason: collision with root package name */
        final RectF f885a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f886b = new Paint();
        final Paint c = new Paint();
        final Paint d = new Paint();
        float e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        float h = 5.0f;
        float p = 1.0f;
        int t = 255;

        a() {
            this.f886b.setStrokeCap(Paint.Cap.SQUARE);
            this.f886b.setAntiAlias(true);
            this.f886b.setStyle(Paint.Style.STROKE);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
            this.d.setColor(0);
        }

        void a(float f, float f2) {
            this.r = (int) f;
            this.s = (int) f2;
        }

        void b(int i) {
            this.u = i;
        }

        void c(int i) {
            this.j = i;
            this.u = this.i[this.j];
        }

        int d() {
            return (this.j + 1) % this.i.length;
        }

        void e(float f) {
            this.e = f;
        }

        void f(float f) {
            this.h = f;
            this.f886b.setStrokeWidth(f);
        }

        float g() {
            return this.l;
        }

        float h() {
            return this.m;
        }

        float i() {
            return this.k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void j() {
            c(d());
        }

        void k() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            e(0.0f);
            c(0.0f);
            d(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void l() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }

        float b() {
            return this.f;
        }

        void d(float f) {
            this.g = f;
        }

        float e() {
            return this.e;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f885a;
            float f = this.q;
            float f2 = (this.h / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
            float f3 = this.e;
            float f4 = this.g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f + f4) * 360.0f) - f5;
            this.f886b.setColor(this.u);
            this.f886b.setAlpha(this.t);
            float f7 = this.h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.f886b);
            a(canvas, f5, f6, rectF);
        }

        void b(float f) {
            this.q = f;
        }

        int c() {
            return this.i[d()];
        }

        int f() {
            return this.i[this.j];
        }

        void c(float f) {
            this.f = f;
        }

        void a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path2 = this.o;
                float f3 = this.p;
                path2.lineTo((this.r * f3) / 2.0f, this.s * f3);
                this.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.r * this.p) / 2.0f), rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }

        void a(int[] iArr) {
            this.i = iArr;
            c(0);
        }

        void a(ColorFilter colorFilter) {
            this.f886b.setColorFilter(colorFilter);
        }

        void a(int i) {
            this.t = i;
        }

        int a() {
            return this.t;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void a(float f) {
            if (f != this.p) {
                this.p = f;
            }
        }
    }

    public d(Context context) {
        androidx.core.g.h.a(context);
        this.f = context.getResources();
        this.d = new a();
        this.d.a(c);
        c(2.5f);
        a();
    }

    private int a(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((i2 & 255) - i6))));
    }

    private void a(float f, float f2, float f3, float f4) {
        a aVar = this.d;
        float f5 = this.f.getDisplayMetrics().density;
        aVar.f(f2 * f5);
        aVar.b(f * f5);
        aVar.c(0);
        aVar.a(f3 * f5, f4 * f5);
    }

    private void d(float f) {
        this.e = f;
    }

    public void b(float f) {
        this.d.d(f);
        invalidateSelf();
    }

    public void c(float f) {
        this.d.f(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.e, bounds.exactCenterX(), bounds.exactCenterY());
        this.d.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.d.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d.a(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.g.cancel();
        this.d.l();
        if (this.d.b() != this.d.e()) {
            this.i = true;
            this.g.setDuration(666L);
            this.g.start();
            return;
        }
        this.d.c(0);
        this.d.k();
        this.g.setDuration(1332L);
        this.g.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.g.cancel();
        d(0.0f);
        this.d.a(false);
        this.d.c(0);
        this.d.k();
        invalidateSelf();
    }

    private void b(float f, a aVar) {
        a(f, aVar);
        aVar.e(aVar.i() + (((aVar.g() - 0.01f) - aVar.i()) * f));
        aVar.c(aVar.g());
        aVar.d(aVar.h() + ((((float) (Math.floor(aVar.h() / 0.8f) + 1.0d)) - aVar.h()) * f));
    }

    public void a(int i) {
        if (i == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(boolean z) {
        this.d.a(z);
        invalidateSelf();
    }

    public void a(float f) {
        this.d.a(f);
        invalidateSelf();
    }

    public void a(float f, float f2) {
        this.d.e(f);
        this.d.c(f2);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.d.a(iArr);
        this.d.c(0);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, a aVar) {
        if (f > 0.75f) {
            aVar.b(a((f - 0.75f) / 0.25f, aVar.f(), aVar.c()));
        } else {
            aVar.b(aVar.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, a aVar, boolean z) {
        float i;
        float interpolation;
        if (this.i) {
            b(f, aVar);
        } else if (f != 1.0f || z) {
            float h = aVar.h();
            if (f < 0.5f) {
                float i2 = aVar.i();
                i = (f884b.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + i2;
                interpolation = i2;
            } else {
                i = aVar.i() + 0.79f;
                interpolation = i - (((1.0f - f884b.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            aVar.e(interpolation);
            aVar.c(i);
            aVar.d(h + (0.20999998f * f));
            d((f + this.h) * 216.0f);
        }
    }

    private void a() {
        a aVar = this.d;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this, aVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f883a);
        ofFloat.addListener(new c(this, aVar));
        this.g = ofFloat;
    }
}
