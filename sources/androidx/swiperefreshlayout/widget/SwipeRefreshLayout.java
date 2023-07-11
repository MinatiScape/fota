package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.h.m;
import androidx.core.h.n;
import androidx.core.h.t;
/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements m, androidx.core.h.j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f873a = "SwipeRefreshLayout";

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f874b = {16842766};
    int A;
    int B;
    d C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    boolean I;
    private int J;
    boolean K;
    private a L;
    private Animation.AnimationListener M;
    private final Animation N;
    private final Animation O;
    private View c;
    b d;
    boolean e;
    private float f;
    private float g;
    private final n h;
    private final androidx.core.h.k i;
    private final int[] j;
    private final int[] k;
    private boolean l;
    private int m;
    private int mTouchSlop;
    int n;
    private float o;
    private float p;
    private boolean q;
    private int r;
    boolean s;
    private boolean t;
    private final DecelerateInterpolator u;
    androidx.swiperefreshlayout.widget.a v;
    private int w;
    protected int x;
    float y;
    protected int z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void a(boolean z, boolean z2) {
        if (this.e != z) {
            this.I = z2;
            d();
            this.e = z;
            if (this.e) {
                a(this.n, this.M);
            } else {
                a(this.M);
            }
        }
    }

    private void c() {
        this.v = new androidx.swiperefreshlayout.widget.a(getContext(), -328966);
        this.C = new d(getContext());
        this.C.a(1);
        this.v.setImageDrawable(this.C);
        this.v.setVisibility(8);
        addView(this.v);
    }

    private void d() {
        if (this.c == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.v)) {
                    this.c = childAt;
                    return;
                }
            }
        }
    }

    private void e() {
        this.G = a(this.C.getAlpha(), 255);
    }

    private void f() {
        this.F = a(this.C.getAlpha(), 76);
    }

    private void setColorViewAlpha(int i) {
        this.v.getBackground().setAlpha(i);
        this.C.setAlpha(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.v.clearAnimation();
        this.C.stop();
        this.v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.z - this.n);
        }
        this.n = this.v.getTop();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.i.a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.i.a(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.i.a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.i.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.w;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.h.a();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.z;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.i.a();
    }

    @Override // android.view.View, androidx.core.h.j
    public boolean isNestedScrollingEnabled() {
        return this.i.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.e || this.l) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.r;
                    if (i == -1) {
                        Log.e(f873a, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.q = false;
            this.r = -1;
        } else {
            setTargetOffsetTopAndBottom(this.z - this.v.getTop());
            this.r = motionEvent.getPointerId(0);
            this.q = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.p = motionEvent.getY(findPointerIndex2);
        }
        return this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.c == null) {
            d();
        }
        View view = this.c;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.v.getMeasuredWidth();
        int measuredHeight2 = this.v.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.n;
        this.v.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c == null) {
            d();
        }
        View view = this.c;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.v.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
        this.w = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.v) {
                this.w = i3;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.g;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.g = 0.0f;
                } else {
                    this.g = f - f2;
                    iArr[1] = i2;
                }
                c(this.g);
            }
        }
        if (this.K && i2 > 0 && this.g == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.v.setVisibility(8);
        }
        int[] iArr2 = this.j;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5;
        dispatchNestedScroll(i, i2, i3, i4, this.k);
        if (i4 + this.k[1] >= 0 || a()) {
            return;
        }
        this.g += Math.abs(i5);
        c(this.g);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.h.a(view, view2, i);
        startNestedScroll(i & 2);
        this.g = 0.0f;
        this.l = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.t || this.e || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onStopNestedScroll(View view) {
        this.h.a(view);
        this.l = false;
        float f = this.g;
        if (f > 0.0f) {
            b(f);
            this.g = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.e || this.l) {
            return false;
        }
        if (actionMasked == 0) {
            this.r = motionEvent.getPointerId(0);
            this.q = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex < 0) {
                Log.e(f873a, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.q) {
                this.q = false;
                b((motionEvent.getY(findPointerIndex) - this.o) * 0.5f);
            }
            this.r = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex2 < 0) {
                Log.e(f873a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            d(y);
            if (this.q) {
                float f = (y - this.o) * 0.5f;
                if (f <= 0.0f) {
                    return false;
                }
                c(f);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f873a, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.c instanceof AbsListView)) {
            View view = this.c;
            if (view == null || t.A(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimationProgress(float f) {
        this.v.setScaleX(f);
        this.v.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        this.C.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = androidx.core.content.a.a(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        b();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.i.a(z);
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.L = aVar;
    }

    public void setOnRefreshListener(b bVar) {
        this.d = bVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.v.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.a(getContext(), i));
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.e != z) {
            this.e = z;
            if (!this.K) {
                i = this.A + this.z;
            } else {
                i = this.A;
            }
            setTargetOffsetTopAndBottom(i - this.n);
            this.I = false;
            b(this.M);
            return;
        }
        a(z, false);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.v.setImageDrawable(null);
            this.C.a(i);
            this.v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(int i) {
        this.B = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i) {
        this.v.bringToFront();
        t.b((View) this.v, i);
        this.n = this.v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.i.b(i);
    }

    @Override // android.view.View, androidx.core.h.j
    public void stopNestedScroll() {
        this.i.c();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.f = -1.0f;
        this.j = new int[2];
        this.k = new int[2];
        this.r = -1;
        this.w = -1;
        this.M = new e(this);
        this.N = new j(this);
        this.O = new k(this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.m = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.J = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        this.A = (int) (displayMetrics.density * 64.0f);
        this.f = this.A;
        this.h = new n(this);
        this.i = new androidx.core.h.k(this);
        setNestedScrollingEnabled(true);
        int i = -this.J;
        this.n = i;
        this.z = i;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f874b);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void d(float f) {
        float f2 = this.p;
        int i = this.mTouchSlop;
        if (f - f2 <= i || this.q) {
            return;
        }
        this.o = f2 + i;
        this.q = true;
        this.C.setAlpha(76);
    }

    private void c(float f) {
        this.C.a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f));
        double d = min;
        Double.isNaN(d);
        float max = (((float) Math.max(d - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f;
        int i = this.B;
        if (i <= 0) {
            i = this.K ? this.A - this.z : this.A;
        }
        float f2 = i;
        double max2 = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f;
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f3 = ((float) (max2 - pow)) * 2.0f;
        int i2 = this.z + ((int) ((f2 * min) + (f2 * f3 * 2.0f)));
        if (this.v.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        if (!this.s) {
            this.v.setScaleX(1.0f);
            this.v.setScaleY(1.0f);
        }
        if (this.s) {
            setAnimationProgress(Math.min(1.0f, f / this.f));
        }
        if (f < this.f) {
            if (this.C.getAlpha() > 76 && !a(this.F)) {
                f();
            }
        } else if (this.C.getAlpha() < 255 && !a(this.G)) {
            e();
        }
        this.C.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.C.a(Math.min(1.0f, max));
        this.C.b((((max * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i2 - this.n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Animation.AnimationListener animationListener) {
        this.E = new g(this);
        this.E.setDuration(150L);
        this.v.a(animationListener);
        this.v.clearAnimation();
        this.v.startAnimation(this.E);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.v.setVisibility(0);
        this.C.setAlpha(255);
        this.D = new f(this);
        this.D.setDuration(this.m);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.D);
    }

    private Animation a(int i, int i2) {
        h hVar = new h(this, i, i2);
        hVar.setDuration(300L);
        this.v.a(null);
        this.v.clearAnimation();
        this.v.startAnimation(hVar);
        return hVar;
    }

    private void b(float f) {
        if (f > this.f) {
            a(true, true);
            return;
        }
        this.e = false;
        this.C.a(0.0f, 0.0f);
        b(this.n, this.s ? null : new i(this));
        this.C.a(false);
    }

    public boolean a() {
        a aVar = this.L;
        if (aVar != null) {
            return aVar.a(this, this.c);
        }
        View view = this.c;
        if (view instanceof ListView) {
            return androidx.core.widget.i.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void a(int i, Animation.AnimationListener animationListener) {
        this.x = i;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.N);
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        if (this.s) {
            c(i, animationListener);
            return;
        }
        this.x = i;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.O);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        int i = this.x;
        setTargetOffsetTopAndBottom((i + ((int) ((this.z - i) * f))) - this.v.getTop());
    }

    private void c(int i, Animation.AnimationListener animationListener) {
        this.x = i;
        this.y = this.v.getScaleX();
        this.H = new l(this);
        this.H.setDuration(150L);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.H);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
