package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
/* loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private Runnable d;
    OverScroller e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private VelocityTracker j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final CoordinatorLayout f1255a;

        /* renamed from: b  reason: collision with root package name */
        private final V f1256b;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.f1255a = coordinatorLayout;
            this.f1256b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f1256b == null || (overScroller = HeaderBehavior.this.e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = HeaderBehavior.this;
                headerBehavior.c(this.f1255a, (CoordinatorLayout) this.f1256b, headerBehavior.e.getCurrY());
                t.a(this.f1256b, this);
                return;
            }
            HeaderBehavior.this.e(this.f1255a, this.f1256b);
        }
    }

    public HeaderBehavior() {
        this.g = -1;
        this.i = -1;
    }

    private void d() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    boolean a(V v) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L83
        L2f:
            int r6 = r4.g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.i
            if (r6 <= r0) goto L83
            r4.f = r2
            r4.h = r5
            goto L83
        L51:
            r4.f = r3
            r4.g = r5
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.j = r5
            goto L83
        L60:
            r4.f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.a(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.a(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.h = r1
            int r5 = r7.getPointerId(r3)
            r4.g = r5
            r4.d()
        L83:
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.i = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8d
            r3 = -1
            if (r0 == r1) goto L5c
            r4 = 2
            if (r0 == r4) goto L25
            r12 = 3
            if (r0 == r12) goto L7e
            goto Lae
        L25:
            int r0 = r11.g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            return r2
        L2e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.h
            int r2 = r2 - r0
            boolean r3 = r11.f
            if (r3 != 0) goto L49
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.i
            if (r3 <= r4) goto L49
            r11.f = r1
            if (r2 <= 0) goto L48
            int r2 = r2 - r4
            goto L49
        L48:
            int r2 = r2 + r4
        L49:
            r6 = r2
            boolean r2 = r11.f
            if (r2 == 0) goto Lae
            r11.h = r0
            int r7 = r11.b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.a(r4, r5, r6, r7, r8)
            goto Lae
        L5c:
            android.view.VelocityTracker r0 = r11.j
            if (r0 == 0) goto L7e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.j
            int r4 = r11.g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.c(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a(r6, r7, r8, r9, r10)
        L7e:
            r11.f = r2
            r11.g = r3
            android.view.VelocityTracker r12 = r11.j
            if (r12 == 0) goto Lae
            r12.recycle()
            r12 = 0
            r11.j = r12
            goto Lae
        L8d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.a(r13, r0, r3)
            if (r12 == 0) goto Lb6
            boolean r12 = r11.a(r13)
            if (r12 == 0) goto Lb6
            r11.h = r3
            int r12 = r14.getPointerId(r2)
            r11.g = r12
            r11.d()
        Lae:
            android.view.VelocityTracker r12 = r11.j
            if (r12 == 0) goto Lb5
            r12.addMovement(r14)
        Lb5:
            return r1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return b(coordinatorLayout, (CoordinatorLayout) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    void e(CoordinatorLayout coordinatorLayout, V v) {
    }

    int c() {
        return b();
    }

    int c(V v) {
        return v.getHeight();
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return b(coordinatorLayout, (CoordinatorLayout) v, c() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.d = null;
        }
        if (this.e == null) {
            this.e = new OverScroller(v.getContext());
        }
        this.e.fling(0, b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.e.computeScrollOffset()) {
            this.d = new a(coordinatorLayout, v);
            t.a(v, this.d);
            return true;
        }
        e(coordinatorLayout, v);
        return false;
    }

    int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int a2;
        int b2 = b();
        if (i2 == 0 || b2 < i2 || b2 > i3 || b2 == (a2 = androidx.core.c.a.a(i, i2, i3))) {
            return 0;
        }
        a(a2);
        return b2 - a2;
    }

    int b(V v) {
        return -v.getHeight();
    }
}
