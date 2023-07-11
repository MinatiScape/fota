package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastScroller.java */
/* renamed from: androidx.recyclerview.widget.n  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0100n extends RecyclerView.h implements RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f848a = {16842919};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f849b = new int[0];
    private final int c;
    private final int d;
    final StateListDrawable e;
    final Drawable f;
    private final int g;
    private final int h;
    private final StateListDrawable i;
    private final Drawable j;
    private final int k;
    private final int l;
    int m;
    int n;
    float o;
    int p;
    int q;
    float r;
    private RecyclerView u;
    private int s = 0;
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = 0;
    private final int[] z = new int[2];
    private final int[] A = new int[2];
    final ValueAnimator B = ValueAnimator.ofFloat(0.0f, 1.0f);
    int C = 0;
    private final Runnable D = new RunnableC0098l(this);
    private final RecyclerView.m E = new C0099m(this);

    /* compiled from: FastScroller.java */
    /* renamed from: androidx.recyclerview.widget.n$a */
    /* loaded from: classes.dex */
    private class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f850a = false;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f850a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f850a) {
                this.f850a = false;
            } else if (((Float) C0100n.this.B.getAnimatedValue()).floatValue() == 0.0f) {
                C0100n c0100n = C0100n.this;
                c0100n.C = 0;
                c0100n.b(0);
            } else {
                C0100n c0100n2 = C0100n.this;
                c0100n2.C = 2;
                c0100n2.a();
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: androidx.recyclerview.widget.n$b */
    /* loaded from: classes.dex */
    private class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C0100n.this.e.setAlpha(floatValue);
            C0100n.this.f.setAlpha(floatValue);
            C0100n.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0100n(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.e = stateListDrawable;
        this.f = drawable;
        this.i = stateListDrawable2;
        this.j = drawable2;
        this.g = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.h = Math.max(i, drawable.getIntrinsicWidth());
        this.k = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.l = Math.max(i, drawable2.getIntrinsicWidth());
        this.c = i2;
        this.d = i3;
        this.e.setAlpha(255);
        this.f.setAlpha(255);
        this.B.addListener(new a());
        this.B.addUpdateListener(new b());
        a(recyclerView);
    }

    private void c() {
        this.u.removeCallbacks(this.D);
    }

    private void d() {
        this.u.b(this);
        this.u.removeOnItemTouchListener(this);
        this.u.removeOnScrollListener(this.E);
        c();
    }

    private int[] e() {
        int[] iArr = this.A;
        int i = this.d;
        iArr[0] = i;
        iArr[1] = this.s - i;
        return iArr;
    }

    private int[] f() {
        int[] iArr = this.z;
        int i = this.d;
        iArr[0] = i;
        iArr[1] = this.t - i;
        return iArr;
    }

    private boolean g() {
        return androidx.core.h.t.k(this.u) == 1;
    }

    private void h() {
        this.u.a(this);
        this.u.addOnItemTouchListener(this);
        this.u.addOnScrollListener(this.E);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            d();
        }
        this.u = recyclerView;
        if (this.u != null) {
            h();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void a(boolean z) {
    }

    void b(int i) {
        if (i == 2 && this.x != 2) {
            this.e.setState(f848a);
            c();
        }
        if (i == 0) {
            a();
        } else {
            b();
        }
        if (this.x == 2 && i != 2) {
            this.e.setState(f849b);
            c(1200);
        } else if (i == 1) {
            c(1500);
        }
        this.x = i;
    }

    private void c(int i) {
        c();
        this.u.postDelayed(this.D, i);
    }

    void a() {
        this.u.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int i2 = this.C;
        if (i2 == 1) {
            this.B.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.C = 3;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.B.setDuration(i);
        this.B.start();
    }

    public void b() {
        int i = this.C;
        if (i != 0) {
            if (i != 3) {
                return;
            }
            this.B.cancel();
        }
        this.C = 1;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.B.setDuration(500L);
        this.B.setStartDelay(0L);
        this.B.start();
    }

    private void a(Canvas canvas) {
        int i = this.t;
        int i2 = this.k;
        int i3 = i - i2;
        int i4 = this.q;
        int i5 = this.p;
        int i6 = i4 - (i5 / 2);
        this.i.setBounds(0, 0, i5, i2);
        this.j.setBounds(0, 0, this.s, this.l);
        canvas.translate(0.0f, i3);
        this.j.draw(canvas);
        canvas.translate(i6, 0.0f);
        this.i.draw(canvas);
        canvas.translate(-i6, -i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (this.s == this.u.getWidth() && this.t == this.u.getHeight()) {
            if (this.C != 0) {
                if (this.v) {
                    b(canvas);
                }
                if (this.w) {
                    a(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.s = this.u.getWidth();
        this.t = this.u.getHeight();
        b(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        int computeVerticalScrollRange = this.u.computeVerticalScrollRange();
        int i3 = this.t;
        this.v = computeVerticalScrollRange - i3 > 0 && i3 >= this.c;
        int computeHorizontalScrollRange = this.u.computeHorizontalScrollRange();
        int i4 = this.s;
        this.w = computeHorizontalScrollRange - i4 > 0 && i4 >= this.c;
        if (!this.v && !this.w) {
            if (this.x != 0) {
                b(0);
                return;
            }
            return;
        }
        if (this.v) {
            float f = i3;
            this.n = (int) ((f * (i2 + (f / 2.0f))) / computeVerticalScrollRange);
            this.m = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (this.w) {
            float f2 = i4;
            this.q = (int) ((f2 * (i + (f2 / 2.0f))) / computeHorizontalScrollRange);
            this.p = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
        }
        int i5 = this.x;
        if (i5 == 0 || i5 == 1) {
            b(1);
        }
    }

    private void b(Canvas canvas) {
        int i = this.s;
        int i2 = this.g;
        int i3 = i - i2;
        int i4 = this.n;
        int i5 = this.m;
        int i6 = i4 - (i5 / 2);
        this.e.setBounds(0, 0, i2, i5);
        this.f.setBounds(0, 0, this.h, this.t);
        if (g()) {
            this.f.draw(canvas);
            canvas.translate(this.g, i6);
            canvas.scale(-1.0f, 1.0f);
            this.e.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.g, -i6);
            return;
        }
        canvas.translate(i3, 0.0f);
        this.f.draw(canvas);
        canvas.translate(0.0f, i6);
        this.e.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.x == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (b2 || a2) {
                if (a2) {
                    this.y = 1;
                    this.r = (int) motionEvent.getX();
                } else if (b2) {
                    this.y = 2;
                    this.o = (int) motionEvent.getY();
                }
                b(2);
            }
        } else if (motionEvent.getAction() == 1 && this.x == 2) {
            this.o = 0.0f;
            this.r = 0.0f;
            b(1);
            this.y = 0;
        } else if (motionEvent.getAction() == 2 && this.x == 2) {
            b();
            if (this.y == 1) {
                a(motionEvent.getX());
            }
            if (this.y == 2) {
                b(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.x;
        if (i == 1) {
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!b2 && !a2) {
                return false;
            }
            if (a2) {
                this.y = 1;
                this.r = (int) motionEvent.getX();
            } else if (b2) {
                this.y = 2;
                this.o = (int) motionEvent.getY();
            }
            b(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    private void b(float f) {
        int[] f2 = f();
        float max = Math.max(f2[0], Math.min(f2[1], f));
        if (Math.abs(this.n - max) < 2.0f) {
            return;
        }
        int a2 = a(this.o, max, f2, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
        if (a2 != 0) {
            this.u.scrollBy(0, a2);
        }
        this.o = max;
    }

    private void a(float f) {
        int[] e = e();
        float max = Math.max(e[0], Math.min(e[1], f));
        if (Math.abs(this.q - max) < 2.0f) {
            return;
        }
        int a2 = a(this.r, max, e, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
        if (a2 != 0) {
            this.u.scrollBy(a2, 0);
        }
        this.r = max;
    }

    boolean b(float f, float f2) {
        if (!g() ? f >= this.s - this.g : f <= this.g / 2) {
            int i = this.n;
            int i2 = this.m;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    private int a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    boolean a(float f, float f2) {
        if (f2 >= this.t - this.k) {
            int i = this.q;
            int i2 = this.p;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }
}
