package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.h.t;
/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int f554a = ViewConfiguration.getTapTimeout();
    final View d;
    private Runnable e;
    private int h;
    private int i;
    private boolean m;
    boolean n;
    boolean o;
    boolean p;
    private boolean q;
    private boolean r;

    /* renamed from: b  reason: collision with root package name */
    final C0016a f555b = new C0016a();
    private final Interpolator c = new AccelerateInterpolator();
    private float[] f = {0.0f, 0.0f};
    private float[] g = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] j = {0.0f, 0.0f};
    private float[] k = {0.0f, 0.0f};
    private float[] l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016a {

        /* renamed from: a  reason: collision with root package name */
        private int f556a;

        /* renamed from: b  reason: collision with root package name */
        private int f557b;
        private float c;
        private float d;
        private float j;
        private int k;
        private long e = Long.MIN_VALUE;
        private long i = -1;
        private long f = 0;
        private int g = 0;
        private int h = 0;

        C0016a() {
        }

        private float a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        public void a(int i) {
            this.f557b = i;
        }

        public void b(int i) {
            this.f556a = i;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            float f = this.c;
            return (int) (f / Math.abs(f));
        }

        public int e() {
            float f = this.d;
            return (int) (f / Math.abs(f));
        }

        public boolean f() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void g() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.e), 0, this.f557b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void h() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        private float a(long j) {
            if (j < this.e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 >= 0 && j >= j2) {
                long j3 = j - j2;
                float f = this.j;
                return (1.0f - f) + (f * a.a(((float) j3) / this.k, 0.0f, 1.0f));
            }
            return a.a(((float) (j - this.e)) / this.f556a, 0.0f, 1.0f) * 0.5f;
        }

        public int b() {
            return this.g;
        }

        public void a() {
            if (this.f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                this.f = currentAnimationTimeMillis;
                float f = ((float) (currentAnimationTimeMillis - this.f)) * a2;
                this.g = (int) (this.c * f);
                this.h = (int) (f * this.d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f, float f2) {
            this.c = f;
            this.d = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    aVar.f555b.h();
                }
                C0016a c0016a = a.this.f555b;
                if (!c0016a.f() && a.this.b()) {
                    a aVar2 = a.this;
                    if (aVar2.o) {
                        aVar2.o = false;
                        aVar2.a();
                    }
                    c0016a.a();
                    a.this.a(c0016a.b(), c0016a.c());
                    t.a(a.this.d, this);
                    return;
                }
                a.this.p = false;
            }
        }
    }

    public a(View view) {
        this.d = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        b(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        c(f3, f3);
        d(1);
        a(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        e(1.0f, 1.0f);
        c(f554a);
        f(500);
        e(500);
    }

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public a a(boolean z) {
        if (this.q && !z) {
            c();
        }
        this.q = z;
        return this;
    }

    public abstract void a(int i, int i2);

    public abstract boolean a(int i);

    public a b(float f, float f2) {
        float[] fArr = this.l;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public abstract boolean b(int i);

    public a c(float f, float f2) {
        float[] fArr = this.k;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a d(int i) {
        this.h = i;
        return this;
    }

    public a e(float f, float f2) {
        float[] fArr = this.j;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public a f(int i) {
        this.f555b.b(i);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.c()
            goto L58
        L1a:
            r5.o = r2
            r5.m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f555b
            r7.a(r0, r6)
            boolean r6 = r5.p
            if (r6 != 0) goto L58
            boolean r6 = r5.b()
            if (r6 == 0) goto L58
            r5.d()
        L58:
            boolean r6 = r5.r
            if (r6 == 0) goto L61
            boolean r6 = r5.p
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.h;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.p && this.h == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    public a d(float f, float f2) {
        float[] fArr = this.f;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    boolean b() {
        C0016a c0016a = this.f555b;
        int e = c0016a.e();
        int d = c0016a.d();
        return (e != 0 && b(e)) || (d != 0 && a(d));
    }

    public a c(int i) {
        this.i = i;
        return this;
    }

    public a e(int i) {
        this.f555b.a(i);
        return this;
    }

    private void c() {
        if (this.n) {
            this.p = false;
        } else {
            this.f555b.g();
        }
    }

    private void d() {
        int i;
        if (this.e == null) {
            this.e = new b();
        }
        this.p = true;
        this.n = true;
        if (!this.m && (i = this.i) > 0) {
            t.a(this.d, this.e, i);
        } else {
            this.e.run();
        }
        this.m = true;
    }

    public a a(float f, float f2) {
        float[] fArr = this.g;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    private float a(int i, float f, float f2, float f3) {
        float a2 = a(this.f[i], f2, this.g[i], f);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f4 = this.j[i];
        float f5 = this.k[i];
        float f6 = this.l[i];
        float f7 = f4 * f3;
        if (a2 > 0.0f) {
            return a(a2 * f7, f5, f6);
        }
        return -a((-a2) * f7, f5, f6);
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float a2 = a(f * f2, 0.0f, f3);
        float f5 = f(f2 - f4, a2) - f(f4, a2);
        if (f5 < 0.0f) {
            interpolation = -this.c.getInterpolation(-f5);
        } else if (f5 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.c.getInterpolation(f5);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.d.onTouchEvent(obtain);
        obtain.recycle();
    }
}
