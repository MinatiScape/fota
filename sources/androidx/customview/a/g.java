package androidx.customview.a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.h.t;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f574a = new e();

    /* renamed from: b  reason: collision with root package name */
    private int f575b;
    private int c;
    private float[] e;
    private float[] f;
    private float[] g;
    private float[] h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int l;
    private VelocityTracker m;
    private float n;
    private float o;
    private int p;
    private int q;
    private OverScroller r;
    private final a s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private int d = -1;
    private final Runnable w = new f(this);

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public int a(int i) {
            return i;
        }

        public int a(View view) {
            return 0;
        }

        public abstract int a(View view, int i, int i2);

        public void a(int i, int i2) {
        }

        public abstract void a(View view, float f, float f2);

        public void a(View view, int i) {
        }

        public abstract void a(View view, int i, int i2, int i3, int i4);

        public int b(View view) {
            return 0;
        }

        public abstract int b(View view, int i, int i2);

        public void b(int i, int i2) {
        }

        public boolean b(int i) {
            return false;
        }

        public abstract boolean b(View view, int i);

        public abstract void c(int i);
    }

    private g(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar != null) {
            this.v = viewGroup;
            this.s = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.p = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.c = viewConfiguration.getScaledTouchSlop();
            this.n = viewConfiguration.getScaledMaximumFlingVelocity();
            this.o = viewConfiguration.getScaledMinimumFlingVelocity();
            this.r = new OverScroller(context, f574a);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public static g a(ViewGroup viewGroup, a aVar) {
        return new g(viewGroup.getContext(), viewGroup, aVar);
    }

    private void g() {
        float[] fArr = this.e;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0.0f);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        Arrays.fill(this.k, 0);
        this.l = 0;
    }

    private void h() {
        this.m.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND, this.n);
        a(a(this.m.getXVelocity(this.d), this.o, this.n), a(this.m.getYVelocity(this.d), this.o, this.n));
    }

    public void b() {
        this.d = -1;
        g();
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public View c() {
        return this.t;
    }

    public void d(int i) {
        this.q = i;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.f575b;
    }

    public static g a(ViewGroup viewGroup, float f, a aVar) {
        g a2 = a(viewGroup, aVar);
        a2.c = (int) (a2.c * (1.0f / f));
        return a2;
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (g(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.g[pointerId] = x;
                this.h[pointerId] = y;
            }
        }
    }

    private void e(int i) {
        if (this.e == null || !b(i)) {
            return;
        }
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0.0f;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k[i] = 0;
        this.l = ((1 << i) ^ (-1)) & this.l;
    }

    private void f(int i) {
        float[] fArr = this.e;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.e;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.h;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.i;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.j;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.k;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.e = fArr2;
            this.f = fArr3;
            this.g = fArr4;
            this.h = fArr5;
            this.i = iArr;
            this.j = iArr2;
            this.k = iArr3;
        }
    }

    public int d() {
        return this.p;
    }

    public boolean d(int i, int i2) {
        if (this.u) {
            return b(i, i2, (int) this.m.getXVelocity(this.d), (int) this.m.getYVelocity(this.d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public void a(float f) {
        this.o = f;
    }

    public void a(View view, int i) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.d = i;
            this.s.a(view, i);
            c(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public boolean b(View view, int i, int i2) {
        this.t = view;
        this.d = -1;
        boolean b2 = b(i, i2, 0, 0);
        if (!b2 && this.f575b == 0 && this.t != null) {
            this.t = null;
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.v.removeCallbacks(this.w);
        if (this.f575b != i) {
            this.f575b = i;
            this.s.c(i);
            if (this.f575b == 0) {
                this.t = null;
            }
        }
    }

    private boolean g(int i) {
        if (b(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private boolean b(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.r.abortAnimation();
            c(0);
            return false;
        }
        this.r.startScroll(left, top, i5, i6, a(this.t, i5, i6, i3, i4));
        c(2);
        return true;
    }

    private int e(int i, int i2) {
        int i3 = i < this.v.getLeft() + this.p ? 1 : 0;
        if (i2 < this.v.getTop() + this.p) {
            i3 |= 4;
        }
        if (i > this.v.getRight() - this.p) {
            i3 |= 2;
        }
        return i2 > this.v.getBottom() - this.p ? i3 | 8 : i3;
    }

    public void a() {
        b();
        if (this.f575b == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.a(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        c(0);
    }

    public boolean c(int i, int i2) {
        return a(this.t, i, i2);
    }

    private int b(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f = width / 2;
        float b2 = f + (b(Math.min(1.0f, Math.abs(i) / width)) * f);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(b2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int a2 = a(i3, (int) this.o, (int) this.n);
        int a3 = a(i4, (int) this.o, (int) this.n);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(a2);
        int abs4 = Math.abs(a3);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (a2 != 0) {
            f = abs3;
            f2 = i5;
        } else {
            f = abs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (a3 != 0) {
            f3 = abs4;
            f4 = i5;
        } else {
            f3 = abs2;
            f4 = i6;
        }
        return (int) ((b(i, a2, this.s.a(view)) * f5) + (b(i2, a3, this.s.b(view)) * (f3 / f4)));
    }

    private float b(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void b(float f, float f2, int i) {
        f(i);
        float[] fArr = this.e;
        this.g[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f;
        this.h[i] = f2;
        fArr2[i] = f2;
        this.i[i] = e((int) f, (int) f2);
        this.l |= 1 << i;
    }

    private int a(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    public boolean a(boolean z) {
        if (this.f575b == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                t.a(this.t, left);
            }
            if (top != 0) {
                t.b(this.t, top);
            }
            if (left != 0 || top != 0) {
                this.s.a(this.t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.v.post(this.w);
                } else {
                    c(0);
                }
            }
        }
        return this.f575b == 2;
    }

    public boolean b(int i) {
        return ((1 << i) & this.l) != 0;
    }

    boolean b(View view, int i) {
        if (view == this.t && this.d == i) {
            return true;
        }
        if (view == null || !this.s.b(view, i)) {
            return false;
        }
        this.d = i;
        a(view, i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.a.g.b(android.view.MotionEvent):boolean");
    }

    private void a(float f, float f2) {
        this.u = true;
        this.s.a(this.t, f, f2);
        this.u = false;
        if (this.f575b == 1) {
            c(0);
        }
    }

    public void a(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View b2 = b((int) x, (int) y);
            b(x, y, pointerId);
            b(b2, pointerId);
            int i3 = this.i[pointerId];
            int i4 = this.q;
            if ((i3 & i4) != 0) {
                this.s.b(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f575b == 1) {
                h();
            }
            b();
        } else if (actionMasked == 2) {
            if (this.f575b == 1) {
                if (g(this.d)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.d);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.g;
                    int i5 = this.d;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.h[i5]);
                    a(this.t.getLeft() + i6, this.t.getTop() + i7, i6, i7);
                    c(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (g(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.e[pointerId2];
                    float f2 = y3 - this.f[pointerId2];
                    a(f, f2, pointerId2);
                    if (this.f575b != 1) {
                        View b3 = b((int) x3, (int) y3);
                        if (a(b3, f, f2) && b(b3, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            c(motionEvent);
        } else if (actionMasked == 3) {
            if (this.f575b == 1) {
                a(0.0f, 0.0f);
            }
            b();
        } else if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            b(x4, y4, pointerId3);
            if (this.f575b == 0) {
                b(b((int) x4, (int) y4), pointerId3);
                int i8 = this.i[pointerId3];
                int i9 = this.q;
                if ((i8 & i9) != 0) {
                    this.s.b(i8 & i9, pointerId3);
                }
            } else if (c((int) x4, (int) y4)) {
                b(this.t, pointerId3);
            }
        } else if (actionMasked != 6) {
        } else {
            int pointerId4 = motionEvent.getPointerId(actionIndex);
            if (this.f575b == 1 && pointerId4 == this.d) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId5 = motionEvent.getPointerId(i2);
                    if (pointerId5 != this.d) {
                        View b4 = b((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view = this.t;
                        if (b4 == view && b(view, pointerId5)) {
                            i = this.d;
                            break;
                        }
                    }
                    i2++;
                }
                if (i == -1) {
                    h();
                }
            }
            e(pointerId4);
        }
    }

    public View b(int i, int i2) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.v;
            this.s.a(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private void a(float f, float f2, int i) {
        int i2 = a(f, f2, i, 1) ? 1 : 0;
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.j;
            iArr[i] = iArr[i] | i2;
            this.s.a(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.i[i] & i2) != i2 || (this.q & i2) == 0 || (this.k[i] & i2) == i2 || (this.j[i] & i2) == i2) {
            return false;
        }
        int i3 = this.c;
        if (abs > i3 || abs2 > i3) {
            if (abs >= abs2 * 0.5f || !this.s.b(i2)) {
                return (this.j[i] & i2) == 0 && abs > ((float) this.c);
            }
            int[] iArr = this.k;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        return false;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.a(view) > 0;
        boolean z2 = this.s.b(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.c) : z2 && Math.abs(f2) > ((float) this.c);
        }
        int i = this.c;
        return (f * f) + (f2 * f2) > ((float) (i * i));
    }

    public boolean a(int i) {
        int length = this.e.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (a(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i, int i2) {
        if (b(i2)) {
            boolean z = (i & 1) == 1;
            boolean z2 = (i & 2) == 2;
            float f = this.g[i2] - this.e[i2];
            float f2 = this.h[i2] - this.f[i2];
            if (!z || !z2) {
                return z ? Math.abs(f) > ((float) this.c) : z2 && Math.abs(f2) > ((float) this.c);
            }
            int i3 = this.c;
            return (f * f) + (f2 * f2) > ((float) (i3 * i3));
        }
        return false;
    }

    private void a(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i3 != 0) {
            i = this.s.a(this.t, i, i3);
            t.a(this.t, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.s.b(this.t, i2, i4);
            t.b(this.t, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.s.a(this.t, i5, i6, i5 - left, i6 - top);
    }

    public boolean a(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }
}
