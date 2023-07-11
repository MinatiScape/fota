package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.C0067a;
import androidx.core.h.C0069c;
import androidx.core.h.a.c;
import androidx.core.h.t;
import androidx.customview.a.g;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f578a = {16843828};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f579b = {16842931};
    static final boolean c;
    private static final boolean d;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private CharSequence E;
    private CharSequence F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<View> M;
    private Rect N;
    private Matrix O;
    private final b e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final g k;
    private final g l;
    private final d m;
    private final d n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private c x;
    private List<c> y;
    private float z;

    /* loaded from: classes.dex */
    static final class b extends C0067a {
        b() {
        }

        @Override // androidx.core.h.C0067a
        public void a(View view, androidx.core.h.a.c cVar) {
            super.a(view, cVar);
            if (DrawerLayout.g(view)) {
                return;
            }
            cVar.c((View) null);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(int i);

        void a(View view);

        void a(View view, float f);

        void b(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends g.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f582a;

        /* renamed from: b  reason: collision with root package name */
        private g f583b;
        private final Runnable c = new androidx.drawerlayout.widget.c(this);

        d(int i) {
            this.f582a = i;
        }

        public void a(g gVar) {
            this.f583b = gVar;
        }

        public void b() {
            DrawerLayout.this.removeCallbacks(this.c);
        }

        @Override // androidx.customview.a.g.a
        public boolean b(int i) {
            return false;
        }

        @Override // androidx.customview.a.g.a
        public void c(int i) {
            DrawerLayout.this.a(this.f582a, i, this.f583b.c());
        }

        private void c() {
            View b2 = DrawerLayout.this.b(this.f582a == 3 ? 5 : 3);
            if (b2 != null) {
                DrawerLayout.this.a(b2);
            }
        }

        @Override // androidx.customview.a.g.a
        public void a(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.a(view, 3) ? i + width : DrawerLayout.this.getWidth() - i) / width;
            DrawerLayout.this.c(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.a.g.a
        public boolean b(View view, int i) {
            return DrawerLayout.this.j(view) && DrawerLayout.this.a(view, this.f582a) && DrawerLayout.this.d(view) == 0;
        }

        @Override // androidx.customview.a.g.a
        public void b(int i, int i2) {
            DrawerLayout.this.postDelayed(this.c, 160L);
        }

        @Override // androidx.customview.a.g.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.a.g.a
        public void a(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).c = false;
            c();
        }

        @Override // androidx.customview.a.g.a
        public void a(View view, float f, float f2) {
            int i;
            float f3 = DrawerLayout.this.f(view);
            int width = view.getWidth();
            if (DrawerLayout.this.a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && f3 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f583b.d(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            View b2;
            int width;
            int d = this.f583b.d();
            boolean z = this.f582a == 3;
            if (z) {
                b2 = DrawerLayout.this.b(3);
                width = (b2 != null ? -b2.getWidth() : 0) + d;
            } else {
                b2 = DrawerLayout.this.b(5);
                width = DrawerLayout.this.getWidth() - d;
            }
            if (b2 != null) {
                if (((!z || b2.getLeft() >= width) && (z || b2.getLeft() <= width)) || DrawerLayout.this.d(b2) != 0) {
                    return;
                }
                this.f583b.b(b2, width, b2.getTop());
                ((LayoutParams) b2.getLayoutParams()).c = true;
                DrawerLayout.this.invalidate();
                c();
                DrawerLayout.this.a();
            }
        }

        @Override // androidx.customview.a.g.a
        public void a(int i, int i2) {
            View b2;
            if ((i & 1) == 1) {
                b2 = DrawerLayout.this.b(3);
            } else {
                b2 = DrawerLayout.this.b(5);
            }
            if (b2 == null || DrawerLayout.this.d(b2) != 0) {
                return;
            }
            this.f583b.a(b2, i2);
        }

        @Override // androidx.customview.a.g.a
        public int a(View view) {
            if (DrawerLayout.this.j(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.a.g.a
        public int a(View view, int i, int i2) {
            if (DrawerLayout.this.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }
    }

    static {
        c = Build.VERSION.SDK_INT >= 19;
        d = Build.VERSION.SDK_INT >= 21;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private Drawable g() {
        int k = t.k(this);
        if (k == 0) {
            Drawable drawable = this.I;
            if (drawable != null) {
                a(drawable, k);
                return this.I;
            }
        } else {
            Drawable drawable2 = this.J;
            if (drawable2 != null) {
                a(drawable2, k);
                return this.J;
            }
        }
        return this.K;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(getScrollX() - view.getLeft(), getScrollY() - view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.O == null) {
                this.O = new Matrix();
            }
            matrix.invert(this.O);
            obtain.transform(this.O);
        }
        return obtain;
    }

    private Drawable h() {
        int k = t.k(this);
        if (k == 0) {
            Drawable drawable = this.J;
            if (drawable != null) {
                a(drawable, k);
                return this.J;
            }
        } else {
            Drawable drawable2 = this.I;
            if (drawable2 != null) {
                a(drawable2, k);
                return this.I;
            }
        }
        return this.L;
    }

    private void i() {
        if (d) {
            return;
        }
        this.C = g();
        this.D = h();
    }

    private static boolean m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void a(Object obj, boolean z) {
        this.G = obj;
        this.H = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (j(childAt)) {
                if (i(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            } else {
                this.M.add(childAt);
            }
        }
        if (!z) {
            int size = this.M.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.M.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.M.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (c() == null && !j(view)) {
            t.d(view, 1);
        } else {
            t.d(view, 4);
        }
        if (c) {
            return;
        }
        t.a(view, this.e);
    }

    public void b(c cVar) {
        List<c> list;
        if (cVar == null || (list = this.y) == null) {
            return;
        }
        list.remove(cVar);
    }

    public int c(int i) {
        int k = t.k(this);
        if (i == 3) {
            int i2 = this.r;
            if (i2 != 3) {
                return i2;
            }
            int i3 = k == 0 ? this.t : this.u;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i == 5) {
            int i4 = this.s;
            if (i4 != 3) {
                return i4;
            }
            int i5 = k == 0 ? this.u : this.t;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        } else if (i == 8388611) {
            int i6 = this.t;
            if (i6 != 3) {
                return i6;
            }
            int i7 = k == 0 ? this.r : this.s;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i != 8388613) {
            return 0;
        } else {
            int i8 = this.u;
            if (i8 != 3) {
                return i8;
            }
            int i9 = k == 0 ? this.s : this.r;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f581b);
        }
        this.i = f;
        boolean a2 = this.k.a(true);
        boolean a3 = this.l.a(true);
        if (a2 || a3) {
            t.C(this);
        }
    }

    public int d(View view) {
        if (j(view)) {
            return c(((LayoutParams) view.getLayoutParams()).f580a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.i > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                for (int i = childCount - 1; i >= 0; i--) {
                    View childAt = getChildAt(i);
                    if (a(x, y, childAt) && !h(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean h = h(view);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (h) {
            int childCount = getChildCount();
            i = width;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && m(childAt) && j(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i) {
                            i = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, i, getHeight());
            i2 = i3;
        } else {
            i = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.i;
        if (f > 0.0f && h) {
            int i5 = this.h;
            this.j.setColor((i5 & 16777215) | (((int) ((((-16777216) & i5) >>> 24) * f)) << 24));
            canvas.drawRect(i2, 0.0f, i, getHeight(), this.j);
        } else if (this.C != null && a(view, 3)) {
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.k.d(), 1.0f));
            this.C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.C.setAlpha((int) (max * 255.0f));
            this.C.draw(canvas);
        } else if (this.D != null && a(view, 5)) {
            int intrinsicWidth2 = this.D.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.l.d(), 1.0f));
            this.D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.D.setAlpha((int) (max2 * 255.0f));
            this.D.draw(canvas);
        }
        return drawChild;
    }

    int e(View view) {
        return C0069c.a(((LayoutParams) view.getLayoutParams()).f580a, t.k(this));
    }

    float f(View view) {
        return ((LayoutParams) view.getLayoutParams()).f581b;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (d) {
            return this.f;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    boolean j(View view) {
        int a2 = C0069c.a(((LayoutParams) view.getLayoutParams()).f580a, t.k(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0) ? false : true;
    }

    public boolean k(View view) {
        if (j(view)) {
            return ((LayoutParams) view.getLayoutParams()).f581b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void l(View view) {
        b(view, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.H || this.B == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.G) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.B.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.B.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.a.g r1 = r6.k
            boolean r1 = r1.b(r7)
            androidx.customview.a.g r2 = r6.l
            boolean r2 = r2.b(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L38
        L1e:
            androidx.customview.a.g r7 = r6.k
            boolean r7 = r7.a(r4)
            if (r7 == 0) goto L38
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.m
            r7.b()
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.n
            r7.b()
            goto L38
        L31:
            r6.a(r2)
            r6.v = r3
            r6.w = r3
        L38:
            r7 = 0
            goto L64
        L3a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.z = r0
            r6.A = r7
            float r4 = r6.i
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5f
            androidx.customview.a.g r4 = r6.k
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.b(r0, r7)
            if (r7 == 0) goto L5f
            boolean r7 = r6.h(r7)
            if (r7 == 0) goto L5f
            r7 = 1
            goto L60
        L5f:
            r7 = 0
        L60:
            r6.v = r3
            r6.w = r3
        L64:
            if (r1 != 0) goto L74
            if (r7 != 0) goto L74
            boolean r7 = r6.e()
            if (r7 != 0) goto L74
            boolean r7 = r6.w
            if (r7 == 0) goto L73
            goto L74
        L73:
            r2 = 0
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && f()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View d2 = d();
            if (d2 != null && d(d2) == 0) {
                b();
            }
            return d2 != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6;
        this.p = true;
        int i7 = i3 - i;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (h(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f2 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.f581b * f2));
                        f = (measuredWidth + i6) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i7 - i5) / f3;
                        i6 = i7 - ((int) (layoutParams.f581b * f3));
                    }
                    boolean z2 = f != layoutParams.f581b;
                    int i10 = layoutParams.f580a & 112;
                    if (i10 == 16) {
                        int i11 = i4 - i2;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i6, i16, measuredWidth + i6, measuredHeight + i16);
                    } else {
                        int i17 = i4 - i2;
                        childAt.layout(i6, (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z2) {
                        c(childAt, f);
                    }
                    int i18 = layoutParams.f581b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
        }
        this.p = false;
        this.q = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.G != null && t.h(this);
        int k = t.k(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int a2 = C0069c.a(layoutParams.f580a, k);
                    if (t.h(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.G;
                            if (a2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (a2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.G;
                        if (a2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (h(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else if (j(childAt)) {
                    if (d) {
                        float g = t.g(childAt);
                        float f = this.f;
                        if (g != f) {
                            t.a(childAt, f);
                        }
                    }
                    int e = e(childAt) & 7;
                    boolean z4 = e == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + e(e) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.g + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                    i4++;
                    i3 = 0;
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i4++;
            i3 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View b2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i = savedState.c;
        if (i != 0 && (b2 = b(i)) != null) {
            l(b2);
        }
        int i2 = savedState.d;
        if (i2 != 3) {
            a(i2, 3);
        }
        int i3 = savedState.e;
        if (i3 != 3) {
            a(i3, 5);
        }
        int i4 = savedState.f;
        if (i4 != 3) {
            a(i4, 8388611);
        }
        int i5 = savedState.g;
        if (i5 != 3) {
            a(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        i();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z = layoutParams.d == 1;
            boolean z2 = layoutParams.d == 2;
            if (z || z2) {
                savedState.c = layoutParams.f580a;
                break;
            }
        }
        savedState.d = this.r;
        savedState.e = this.s;
        savedState.f = this.t;
        savedState.g = this.u;
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View c2;
        this.k.a(motionEvent);
        this.l.a(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.z = x;
            this.A = y;
            this.v = false;
            this.w = false;
        } else if (action == 1) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            View b2 = this.k.b((int) x2, (int) y2);
            if (b2 != null && h(b2)) {
                float f = x2 - this.z;
                float f2 = y2 - this.A;
                int e = this.k.e();
                if ((f * f) + (f2 * f2) < e * e && (c2 = c()) != null && d(c2) != 2) {
                    z = false;
                    a(z);
                    this.v = false;
                }
            }
            z = true;
            a(z);
            this.v = false;
        } else if (action == 3) {
            a(true);
            this.v = false;
            this.w = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.v = z;
        if (z) {
            a(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.p) {
            return;
        }
        super.requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (j(childAt)) {
                t.a(childAt, this.f);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        c cVar2 = this.x;
        if (cVar2 != null) {
            b(cVar2);
        }
        if (cVar != null) {
            a(cVar);
        }
        this.x = cVar;
    }

    public void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    public void setScrimColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.B = new ColorDrawable(i);
        invalidate();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean f(int i) {
        View b2 = b(i);
        if (b2 != null) {
            return i(b2);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new b();
        this.h = -1728053248;
        this.j = new Paint();
        this.q = true;
        this.r = 3;
        this.s = 3;
        this.t = 3;
        this.u = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.m = new d(3);
        this.n = new d(5);
        this.k = g.a(this, 1.0f, this.m);
        this.k.d(1);
        this.k.a(f2);
        this.m.a(this.k);
        this.l = g.a(this, 1.0f, this.n);
        this.l.d(2);
        this.l.a(f2);
        this.n.a(this.l);
        setFocusableInTouchMode(true);
        t.d(this, 1);
        t.a(this, new a());
        setMotionEventSplittingEnabled(false);
        if (t.h(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new androidx.drawerlayout.widget.a(this));
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f578a);
                try {
                    this.B = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.B = null;
            }
        }
        this.f = f * 10.0f;
        this.M = new ArrayList<>();
    }

    static String e(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    void b(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 1) {
            layoutParams.d = 0;
            List<c> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).b(view);
                }
            }
            c(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    public void setStatusBarBackground(int i) {
        this.B = i != 0 ? androidx.core.content.a.c(getContext(), i) : null;
        invalidate();
    }

    private boolean e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    private boolean f() {
        return d() != null;
    }

    public boolean i(View view) {
        if (j(view)) {
            return (((LayoutParams) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f580a;

        /* renamed from: b  reason: collision with root package name */
        float f581b;
        boolean c;
        int d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f580a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f579b);
            this.f580a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f580a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f580a = 0;
            this.f580a = layoutParams.f580a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f580a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f580a = 0;
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.y == null) {
            this.y = new ArrayList();
        }
        this.y.add(cVar);
    }

    public CharSequence d(int i) {
        int a2 = C0069c.a(i, t.k(this));
        if (a2 == 3) {
            return this.E;
        }
        if (a2 == 5) {
            return this.F;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new androidx.drawerlayout.widget.b();
        int c;
        int d;
        int e;
        int f;
        int g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = 0;
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.c = 0;
        }
    }

    public void a(int i, int i2) {
        View b2;
        int a2 = C0069c.a(i2, t.k(this));
        if (i2 == 3) {
            this.r = i;
        } else if (i2 == 5) {
            this.s = i;
        } else if (i2 == 8388611) {
            this.t = i;
        } else if (i2 == 8388613) {
            this.u = i;
        }
        if (i != 0) {
            (a2 == 3 ? this.k : this.l).b();
        }
        if (i != 1) {
            if (i == 2 && (b2 = b(a2)) != null) {
                l(b2);
                return;
            }
            return;
        }
        View b3 = b(a2);
        if (b3 != null) {
            a(b3);
        }
    }

    View d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (j(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public void g(int i) {
        b(i, true);
    }

    boolean h(View view) {
        return ((LayoutParams) view.getLayoutParams()).f580a == 0;
    }

    static boolean g(View view) {
        return (t.i(view) == 4 || t.i(view) == 2) ? false : true;
    }

    void c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 0) {
            layoutParams.d = 1;
            List<c> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(view);
                }
            }
            c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void b(View view, float f) {
        float f2 = f(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (f2 * width));
        if (!a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        c(view, f);
    }

    /* loaded from: classes.dex */
    class a extends C0067a {
        private final Rect c = new Rect();

        a() {
        }

        @Override // androidx.core.h.C0067a
        public void a(View view, androidx.core.h.a.c cVar) {
            if (DrawerLayout.c) {
                super.a(view, cVar);
            } else {
                androidx.core.h.a.c a2 = androidx.core.h.a.c.a(cVar);
                super.a(view, a2);
                cVar.d(view);
                ViewParent p = t.p(view);
                if (p instanceof View) {
                    cVar.c((View) p);
                }
                a(cVar, a2);
                a2.w();
                a(cVar, (ViewGroup) view);
            }
            cVar.a((CharSequence) DrawerLayout.class.getName());
            cVar.h(false);
            cVar.i(false);
            cVar.b(c.a.f518a);
            cVar.b(c.a.f519b);
        }

        @Override // androidx.core.h.C0067a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // androidx.core.h.C0067a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View d = DrawerLayout.this.d();
                if (d != null) {
                    CharSequence d2 = DrawerLayout.this.d(DrawerLayout.this.e(d));
                    if (d2 != null) {
                        text.add(d2);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.h.C0067a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.c || DrawerLayout.g(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void a(androidx.core.h.a.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.g(childAt)) {
                    cVar.a(childAt);
                }
            }
        }

        private void a(androidx.core.h.a.c cVar, androidx.core.h.a.c cVar2) {
            Rect rect = this.c;
            cVar2.a(rect);
            cVar.c(rect);
            cVar2.b(rect);
            cVar.d(rect);
            cVar.n(cVar2.u());
            cVar.e(cVar2.g());
            cVar.a(cVar2.c());
            cVar.b(cVar2.d());
            cVar.g(cVar2.n());
            cVar.e(cVar2.m());
            cVar.h(cVar2.o());
            cVar.i(cVar2.p());
            cVar.a(cVar2.j());
            cVar.l(cVar2.t());
            cVar.j(cVar2.q());
            cVar.a(cVar2.a());
        }
    }

    View b(int i) {
        int a2 = C0069c.a(i, t.k(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == a2) {
                return childAt;
            }
        }
        return null;
    }

    private void c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !j(childAt)) || (z && childAt == view)) {
                t.d(childAt, 1);
            } else {
                t.d(childAt, 4);
            }
        }
    }

    private boolean a(float f, float f2, View view) {
        if (this.N == null) {
            this.N = new Rect();
        }
        view.getHitRect(this.N);
        return this.N.contains((int) f, (int) f2);
    }

    public void b() {
        a(false);
    }

    void a(int i, int i2, View view) {
        int f = this.k.f();
        int f2 = this.l.f();
        int i3 = 2;
        if (f == 1 || f2 == 1) {
            i3 = 1;
        } else if (f != 2 && f2 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f3 = ((LayoutParams) view.getLayoutParams()).f581b;
            if (f3 == 0.0f) {
                b(view);
            } else if (f3 == 1.0f) {
                c(view);
            }
        }
        if (i3 != this.o) {
            this.o = i3;
            List<c> list = this.y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y.get(size).a(i3);
                }
            }
        }
    }

    public void b(View view, boolean z) {
        if (j(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.q) {
                layoutParams.f581b = 1.0f;
                layoutParams.d = 1;
                c(view, true);
            } else if (z) {
                layoutParams.d |= 2;
                if (a(view, 3)) {
                    this.k.b(view, 0, view.getTop());
                } else {
                    this.l.b(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                b(view, 1.0f);
                a(layoutParams.f580a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    void c(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.f581b) {
            return;
        }
        layoutParams.f581b = f;
        a(view, f);
    }

    View c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void a(View view, float f) {
        List<c> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y.get(size).a(view, f);
            }
        }
    }

    boolean a(View view, int i) {
        return (e(view) & i) == i;
    }

    private boolean a(Drawable drawable, int i) {
        if (drawable == null || !androidx.core.graphics.drawable.a.f(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.a(drawable, i);
        return true;
    }

    void a(boolean z) {
        boolean b2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (j(childAt) && (!z || layoutParams.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    b2 = this.k.b(childAt, -width, childAt.getTop());
                } else {
                    b2 = this.l.b(childAt, getWidth(), childAt.getTop());
                }
                z2 |= b2;
                layoutParams.c = false;
            }
        }
        this.m.b();
        this.n.b();
        if (z2) {
            invalidate();
        }
    }

    public void b(int i, boolean z) {
        View b2 = b(i);
        if (b2 != null) {
            b(b2, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + e(i));
    }

    public void a(View view) {
        a(view, true);
    }

    public void a(View view, boolean z) {
        if (j(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.q) {
                layoutParams.f581b = 0.0f;
                layoutParams.d = 0;
            } else if (z) {
                layoutParams.d |= 4;
                if (a(view, 3)) {
                    this.k.b(view, -view.getWidth(), view.getTop());
                } else {
                    this.l.b(view, getWidth(), view.getTop());
                }
            } else {
                b(view, 0.0f);
                a(layoutParams.f580a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void a(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        View b2 = b(i);
        if (b2 != null) {
            a(b2, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + e(i));
    }

    void a() {
        if (this.w) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.w = true;
    }
}
