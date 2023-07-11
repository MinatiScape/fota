package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.g.g;
import androidx.core.h.C0069c;
import androidx.core.h.D;
import androidx.core.h.l;
import androidx.core.h.n;
import androidx.core.h.o;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements l {

    /* renamed from: a  reason: collision with root package name */
    static final String f386a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f387b;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> c;
    static final Comparator<View> d;
    private static final androidx.core.g.e<Rect> e;
    private final List<View> f;
    private final androidx.coordinatorlayout.widget.c<View> g;
    private final List<View> h;
    private final List<View> i;
    private final int[] j;
    private Paint k;
    private boolean l;
    private boolean m;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private int[] n;
    private View o;
    private View p;
    private e q;
    private boolean r;
    private D s;
    private boolean t;
    private Drawable u;
    private o v;
    private final n w;

    /* loaded from: classes.dex */
    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public D a(CoordinatorLayout coordinatorLayout, V v, D d) {
            return d;
        }

        public void a() {
        }

        public void a(d dVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return c(coordinatorLayout, v) > 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public int b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return b(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public float c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, view2, i);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, i3, i4);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, iArr);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface b {
        Class<? extends Behavior> value();
    }

    /* loaded from: classes.dex */
    private class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class f implements Comparator<View> {
        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float t = t.t(view);
            float t2 = t.t(view2);
            if (t > t2) {
                return -1;
            }
            return t < t2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f386a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            d = new f();
        } else {
            d = null;
        }
        f387b = new Class[]{Context.class, AttributeSet.class};
        c = new ThreadLocal<>();
        e = new g(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        e.release(rect);
    }

    private int b(int i) {
        int[] iArr = this.n;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    private static int c(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int d(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int e(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private void e(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        int i2 = dVar.i;
        if (i2 != i) {
            t.a(view, i - i2);
            dVar.i = i;
        }
    }

    private void f(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        int i2 = dVar.j;
        if (i2 != i) {
            t.b(view, i - i2);
            dVar.j = i;
        }
    }

    private static Rect g() {
        Rect acquire = e.acquire();
        return acquire == null ? new Rect() : acquire;
    }

    private void h() {
        this.f.clear();
        this.g.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d d2 = d(childAt);
            d2.a(this, childAt);
            this.g.a((androidx.coordinatorlayout.widget.c<View>) childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (d2.a(this, childAt, childAt2)) {
                        if (!this.g.b(childAt2)) {
                            this.g.a((androidx.coordinatorlayout.widget.c<View>) childAt2);
                        }
                        this.g.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f.addAll(this.g.b());
        Collections.reverse(this.f);
    }

    private void i() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (t.h(this)) {
            if (this.v == null) {
                this.v = new androidx.coordinatorlayout.widget.a(this);
            }
            t.a(this, this.v);
            setSystemUiVisibility(1280);
            return;
        }
        t.a(this, (o) null);
    }

    public void c(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.a()) {
            View view2 = dVar.k;
            if (view2 != null) {
                a(view, view2, i);
                return;
            }
            int i2 = dVar.e;
            if (i2 >= 0) {
                b(view, i2, i);
                return;
            } else {
                d(view, i);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    d d(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.f390b) {
            if (view instanceof a) {
                Behavior behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                dVar.a(behavior);
                dVar.f390b = true;
            } else {
                b bVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    bVar = (b) cls.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                if (bVar != null) {
                    try {
                        dVar.a(bVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + bVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                dVar.f390b = true;
            }
        }
        return dVar;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        d dVar = (d) view.getLayoutParams();
        Behavior behavior = dVar.f389a;
        if (behavior != null) {
            float c2 = behavior.c(this, view);
            if (c2 > 0.0f) {
                if (this.k == null) {
                    this.k = new Paint();
                }
                this.k.setColor(dVar.f389a.b(this, view));
                this.k.setAlpha(a(Math.round(c2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.k);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.u;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    final List<View> getDependencySortedChildren() {
        h();
        return Collections.unmodifiableList(this.f);
    }

    public final D getLastWindowInsets() {
        return this.s;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.w.a();
    }

    public Drawable getStatusBarBackground() {
        return this.u;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.r) {
            if (this.q == null) {
                this.q = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        if (this.s == null && t.h(this)) {
            t.D(this);
        }
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.r && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        View view = this.p;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.m = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.t || this.u == null) {
            return;
        }
        D d2 = this.s;
        int e2 = d2 != null ? d2.e() : 0;
        if (e2 > 0) {
            this.u.setBounds(0, 0, getWidth(), e2);
            this.u.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior d2;
        int k = t.k(this);
        int size = this.f.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f.get(i5);
            if (view.getVisibility() != 8 && ((d2 = ((d) view.getLayoutParams()).d()) == null || !d2.a(this, (CoordinatorLayout) view, k))) {
                c(view, k);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0117, code lost:
        if (r0.a(r30, (androidx.coordinatorlayout.widget.CoordinatorLayout) r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        Behavior d2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (d2 = dVar.d()) != null) {
                    z2 |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (d2 = dVar.d()) != null) {
                    z |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedScrollAccepted(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior d2 = d(childAt).d();
            if (id != -1 && d2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                d2.a(this, (CoordinatorLayout) childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable d2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior d3 = ((d) childAt.getLayoutParams()).d();
            if (id != -1 && d3 != null && (d2 = d3.d(this, childAt)) != null) {
                sparseArray.append(id, d2);
            }
        }
        savedState.c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return b(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.o
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.a(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.o
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.d()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.o
            boolean r6 = r6.b(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.o
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.a(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior d2 = ((d) view.getLayoutParams()).d();
        if (d2 == null || !d2.a(this, (CoordinatorLayout) view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.l) {
            return;
        }
        a(false);
        this.l = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        i();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.u = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.u;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.u.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a(this.u, t.k(this));
                this.u.setVisible(getVisibility() == 0, false);
                this.u.setCallback(this);
            }
            t.C(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? androidx.core.content.a.c(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.u;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.u.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.u;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public d generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    /* loaded from: classes.dex */
    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        Behavior f389a;

        /* renamed from: b  reason: collision with root package name */
        boolean f390b;
        public int c;
        public int d;
        public int e;
        int f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;

        public d(int i, int i2) {
            super(i, i2);
            this.f390b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public void a(Behavior behavior) {
            Behavior behavior2 = this.f389a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.a();
                }
                this.f389a = behavior;
                this.r = null;
                this.f390b = true;
                if (behavior != null) {
                    behavior.a(this);
                }
            }
        }

        boolean b() {
            if (this.f389a == null) {
                this.m = false;
            }
            return this.m;
        }

        public int c() {
            return this.f;
        }

        public Behavior d() {
            return this.f389a;
        }

        boolean e() {
            return this.p;
        }

        Rect f() {
            return this.q;
        }

        void g() {
            this.p = false;
        }

        void h() {
            this.m = false;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            Behavior behavior = this.f389a;
            boolean a2 = (behavior != null ? behavior.a(coordinatorLayout, view) : false) | z;
            this.m = a2;
            return a2;
        }

        void a(Rect rect) {
            this.q.set(rect);
        }

        void b(int i) {
            a(i, false);
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                } else {
                    this.l = null;
                    this.k = null;
                    return false;
                }
            }
            this.l = view2;
            return true;
        }

        boolean a() {
            return this.k == null && this.f != -1;
        }

        void a(int i, boolean z) {
            if (i == 0) {
                this.n = z;
            } else if (i != 1) {
            } else {
                this.o = z;
            }
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f390b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f390b = obtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f390b) {
                this.f389a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f389a;
            if (behavior != null) {
                behavior.a(this);
            }
        }

        boolean a(int i) {
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                return this.o;
            }
            return this.n;
        }

        void a(boolean z) {
            this.p = z;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            return view2 == this.l || a(view2, t.k(coordinatorLayout)) || ((behavior = this.f389a) != null && behavior.a(coordinatorLayout, (CoordinatorLayout) view, view2));
        }

        View a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f);
            View view2 = this.k;
            if (view2 == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            } else if (view2 == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            } else {
                for (ViewParent parent = view2.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                this.l = view2;
            }
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.f390b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        private boolean a(View view, int i) {
            int a2 = C0069c.a(((d) view.getLayoutParams()).g, i);
            return a2 != 0 && (C0069c.a(this.h, i) & a2) == a2;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f390b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f390b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.f = new ArrayList();
        this.g = new androidx.coordinatorlayout.widget.c<>();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new int[2];
        this.w = new n(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.n = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.n.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.n;
                iArr[i2] = (int) (iArr[i2] * f2);
            }
        }
        this.u = obtainStyledAttributes.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        i();
        super.setOnHierarchyChangeListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final D a(D d2) {
        if (androidx.core.g.c.a(this.s, d2)) {
            return d2;
        }
        this.s = d2;
        boolean z = true;
        this.t = d2 != null && d2.e() > 0;
        setWillNotDraw((this.t || getBackground() != null) ? false : false);
        D b2 = b(d2);
        requestLayout();
        return b2;
    }

    @Override // android.view.ViewGroup
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    void e() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (e(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z != this.r) {
            if (z) {
                d();
            } else {
                f();
            }
        }
    }

    void f() {
        if (this.m && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        this.r = false;
    }

    private D b(D d2) {
        Behavior d3;
        if (d2.g()) {
            return d2;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (t.h(childAt) && (d3 = ((d) childAt.getLayoutParams()).d()) != null) {
                d2 = d3.a(this, (CoordinatorLayout) childAt, d2);
                if (d2.g()) {
                    break;
                }
            }
        }
        return d2;
    }

    /* loaded from: classes.dex */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new androidx.coordinatorlayout.widget.b();
        SparseArray<Parcelable> c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.c = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.c.append(iArr[i], readParcelableArray[i]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.c.keyAt(i2);
                parcelableArr[i2] = this.c.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior d2 = ((d) childAt.getLayoutParams()).d();
            if (d2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    d2.a(this, (CoordinatorLayout) childAt, obtain);
                } else {
                    d2.b(this, (CoordinatorLayout) childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((d) getChildAt(i2).getLayoutParams()).h();
        }
        this.o = null;
        this.l = false;
    }

    void c(View view, Rect rect) {
        ((d) view.getLayoutParams()).a(rect);
    }

    private boolean e(View view) {
        return this.g.e(view);
    }

    public List<View> c(View view) {
        List c2 = this.g.c(view);
        this.i.clear();
        if (c2 != null) {
            this.i.addAll(c2);
        }
        return this.i;
    }

    void b(View view, Rect rect) {
        rect.set(((d) view.getLayoutParams()).f());
    }

    private void b(View view, int i, int i2) {
        d dVar = (d) view.getLayoutParams();
        int a2 = C0069c.a(e(dVar.c), i2);
        int i3 = a2 & 7;
        int i4 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b2 = b(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            b2 += measuredWidth / 2;
        } else if (i3 == 5) {
            b2 += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void d(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        Rect g = g();
        g.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin);
        if (this.s != null && t.h(this) && !t.h(view)) {
            g.left += this.s.c();
            g.top += this.s.e();
            g.right -= this.s.d();
            g.bottom -= this.s.b();
        }
        Rect g2 = g();
        C0069c.a(d(dVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), g, g2, i);
        view.layout(g2.left, g2.top, g2.right, g2.bottom);
        a(g);
        a(g2);
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean a(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.h;
        a(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            d dVar = (d) view.getLayoutParams();
            Behavior d2 = dVar.d();
            boolean z3 = true;
            if (!(z || z2) || actionMasked == 0) {
                if (!z && d2 != null) {
                    if (i == 0) {
                        z = d2.a(this, (CoordinatorLayout) view, motionEvent);
                    } else if (i == 1) {
                        z = d2.b(this, (CoordinatorLayout) view, motionEvent);
                    }
                    if (z) {
                        this.o = view;
                    }
                }
                boolean b2 = dVar.b();
                boolean b3 = dVar.b(this, view);
                z3 = (!b3 || b2) ? false : false;
                if (b3 && !z3) {
                    break;
                }
                z2 = z3;
            } else if (d2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    d2.a(this, (CoordinatorLayout) view, motionEvent2);
                } else if (i == 1) {
                    d2.b(this, (CoordinatorLayout) view, motionEvent2);
                }
            }
        }
        list.clear();
        return z;
    }

    public List<View> b(View view) {
        List<View> d2 = this.g.d(view);
        this.i.clear();
        if (d2 != null) {
            this.i.addAll(d2);
        }
        return this.i;
    }

    void d() {
        if (this.m) {
            if (this.q == null) {
                this.q = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        this.r = true;
    }

    void b(View view, int i) {
        Behavior d2;
        d dVar = (d) view.getLayoutParams();
        if (dVar.k != null) {
            Rect g = g();
            Rect g2 = g();
            Rect g3 = g();
            a(dVar.k, g);
            boolean z = false;
            a(view, false, g2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i, g, g3, dVar, measuredWidth, measuredHeight);
            z = (g3.left == g2.left && g3.top == g2.top) ? true : true;
            a(dVar, g3, measuredWidth, measuredHeight);
            int i2 = g3.left - g2.left;
            int i3 = g3.top - g2.top;
            if (i2 != 0) {
                t.a(view, i2);
            }
            if (i3 != 0) {
                t.b(view, i3);
            }
            if (z && (d2 = dVar.d()) != null) {
                d2.b(this, (CoordinatorLayout) view, dVar.k);
            }
            a(g);
            a(g2);
            a(g3);
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f386a)) {
            str = f386a + '.' + str;
        }
        try {
            Map<String, Constructor<Behavior>> map = c.get();
            if (map == null) {
                map = new HashMap<>();
                c.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f387b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    @Override // androidx.core.h.l
    public boolean b(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior d2 = dVar.d();
                if (d2 != null) {
                    boolean b2 = d2.b(this, childAt, view, view2, i, i2);
                    dVar.a(i2, b2);
                    z |= b2;
                } else {
                    dVar.a(i2, false);
                }
            }
        }
        return z;
    }

    void a(View view, Rect rect) {
        androidx.coordinatorlayout.widget.d.a(this, view, rect);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2, d dVar, int i2, int i3) {
        int width;
        int height;
        int a2 = C0069c.a(c(dVar.c), i);
        int a3 = C0069c.a(d(dVar.d), i);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int i6 = a3 & 7;
        int i7 = a3 & 112;
        if (i6 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i7 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private void a(d dVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, dVar, measuredWidth, measuredHeight);
        a(dVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i) {
        Rect g = g();
        Rect g2 = g();
        try {
            a(view2, g);
            a(view, i, g, g2);
            view.layout(g2.left, g2.top, g2.right, g2.bottom);
        } finally {
            a(g);
            a(g2);
        }
    }

    final void a(int i) {
        boolean z;
        int k = t.k(this);
        int size = this.f.size();
        Rect g = g();
        Rect g2 = g();
        Rect g3 = g();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f.get(i2);
            d dVar = (d) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (dVar.l == this.f.get(i3)) {
                        b(view, k);
                    }
                }
                a(view, true, g2);
                if (dVar.g != 0 && !g2.isEmpty()) {
                    int a2 = C0069c.a(dVar.g, k);
                    int i4 = a2 & 112;
                    if (i4 == 48) {
                        g.top = Math.max(g.top, g2.bottom);
                    } else if (i4 == 80) {
                        g.bottom = Math.max(g.bottom, getHeight() - g2.top);
                    }
                    int i5 = a2 & 7;
                    if (i5 == 3) {
                        g.left = Math.max(g.left, g2.right);
                    } else if (i5 == 5) {
                        g.right = Math.max(g.right, getWidth() - g2.left);
                    }
                }
                if (dVar.h != 0 && view.getVisibility() == 0) {
                    a(view, g, k);
                }
                if (i != 2) {
                    b(view, g3);
                    if (!g3.equals(g2)) {
                        c(view, g2);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view2 = this.f.get(i6);
                    d dVar2 = (d) view2.getLayoutParams();
                    Behavior d2 = dVar2.d();
                    if (d2 != null && d2.a(this, (CoordinatorLayout) view2, view)) {
                        if (i == 0 && dVar2.e()) {
                            dVar2.g();
                        } else {
                            if (i != 2) {
                                z = d2.b(this, (CoordinatorLayout) view2, view);
                            } else {
                                d2.c(this, view2, view);
                                z = true;
                            }
                            if (i == 1) {
                                dVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        a(g);
        a(g2);
        a(g3);
    }

    private void a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (t.z(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            d dVar = (d) view.getLayoutParams();
            Behavior d2 = dVar.d();
            Rect g = g();
            Rect g2 = g();
            g2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (d2 != null && d2.a(this, (CoordinatorLayout) view, g)) {
                if (!g2.contains(g)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + g.toShortString() + " | Bounds:" + g2.toShortString());
                }
            } else {
                g.set(g2);
            }
            a(g2);
            if (g.isEmpty()) {
                a(g);
                return;
            }
            int a2 = C0069c.a(dVar.h, i);
            if ((a2 & 48) != 48 || (i6 = (g.top - ((ViewGroup.MarginLayoutParams) dVar).topMargin) - dVar.j) >= (i7 = rect.top)) {
                z = false;
            } else {
                f(view, i7 - i6);
                z = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - g.bottom) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin) + dVar.j) < (i5 = rect.bottom)) {
                f(view, height - i5);
                z = true;
            }
            if (!z) {
                f(view, 0);
            }
            if ((a2 & 3) != 3 || (i3 = (g.left - ((ViewGroup.MarginLayoutParams) dVar).leftMargin) - dVar.i) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                e(view, i4 - i3);
                z2 = true;
            }
            if ((a2 & 5) == 5 && (width = ((getWidth() - g.right) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + dVar.i) < (i2 = rect.right)) {
                e(view, width - i2);
                z2 = true;
            }
            if (!z2) {
                e(view, 0);
            }
            a(g);
        }
    }

    public void a(View view) {
        List c2 = this.g.c(view);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        for (int i = 0; i < c2.size(); i++) {
            View view2 = (View) c2.get(i);
            Behavior d2 = ((d) view2.getLayoutParams()).d();
            if (d2 != null) {
                d2.b(this, (CoordinatorLayout) view2, view);
            }
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect g = g();
        a(view, g);
        try {
            return g.contains(i, i2);
        } finally {
            a(g);
        }
    }

    @Override // androidx.core.h.l
    public void a(View view, View view2, int i, int i2) {
        Behavior d2;
        this.w.a(view, view2, i, i2);
        this.p = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i2) && (d2 = dVar.d()) != null) {
                d2.a(this, (CoordinatorLayout) childAt, view, view2, i, i2);
            }
        }
    }

    @Override // androidx.core.h.l
    public void a(View view, int i) {
        this.w.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i)) {
                Behavior d2 = dVar.d();
                if (d2 != null) {
                    d2.a(this, (CoordinatorLayout) childAt, view, i);
                }
                dVar.b(i);
                dVar.g();
            }
        }
        this.p = null;
    }

    @Override // androidx.core.h.l
    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        Behavior d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i5) && (d2 = dVar.d()) != null) {
                    d2.a(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            a(1);
        }
    }

    @Override // androidx.core.h.l
    public void a(View view, int i, int i2, int[] iArr, int i3) {
        Behavior d2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i3) && (d2 = dVar.d()) != null) {
                    int[] iArr2 = this.j;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    d2.a(this, (CoordinatorLayout) childAt, view, i, i2, iArr2, i3);
                    if (i > 0) {
                        min = Math.max(i4, this.j[0]);
                    } else {
                        min = Math.min(i4, this.j[0]);
                    }
                    if (i2 > 0) {
                        min2 = Math.max(i5, this.j[1]);
                    } else {
                        min2 = Math.min(i5, this.j[1]);
                    }
                    i4 = min;
                    i5 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            a(1);
        }
    }
}
