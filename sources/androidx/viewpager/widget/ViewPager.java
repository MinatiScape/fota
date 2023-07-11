package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.h.C0067a;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1031a = {16842931};

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<b> f1032b = new androidx.viewpager.widget.d();
    private static final Interpolator c = new androidx.viewpager.widget.e();
    private static final h d = new h();
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private List<e> aa;
    private e ba;
    private e ca;
    private List<d> da;
    private int e;
    private f ea;
    private final ArrayList<b> f;
    private int fa;
    private final b g;
    private int ga;
    private final Rect h;
    private ArrayList<View> ha;
    androidx.viewpager.widget.a i;
    private final Runnable ia;
    int j;
    private int ja;
    private int k;
    private Parcelable l;
    private ClassLoader m;
    private int mTouchSlop;
    private Scroller n;
    private boolean o;
    private g p;
    private int q;
    private Drawable r;
    private int s;
    private int t;
    private float u;
    private float v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new androidx.viewpager.widget.h();
        int c;
        Parcelable d;
        ClassLoader e;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.d, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.c = parcel.readInt();
            this.d = parcel.readParcelable(classLoader);
            this.e = classLoader;
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f1035a;

        /* renamed from: b  reason: collision with root package name */
        int f1036b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* loaded from: classes.dex */
    public interface f {
        void transformPage(View view, float f);
    }

    /* loaded from: classes.dex */
    private class g extends DataSetObserver {
        g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h implements Comparator<View> {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.f1033a;
            if (z != layoutParams2.f1033a) {
                return z ? 1 : -1;
            }
            return layoutParams.e - layoutParams2.e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f = new ArrayList<>();
        this.g = new b();
        this.h = new Rect();
        this.k = -1;
        this.l = null;
        this.m = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.B = 1;
        this.K = -1;
        this.T = true;
        this.U = false;
        this.ia = new androidx.viewpager.widget.f(this);
        this.ja = 0;
        b();
    }

    private void d(int i) {
        e eVar = this.ba;
        if (eVar != null) {
            eVar.onPageSelected(i);
        }
        List<e> list = this.aa;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar2 = this.aa.get(i2);
                if (eVar2 != null) {
                    eVar2.onPageSelected(i);
                }
            }
        }
        e eVar3 = this.ca;
        if (eVar3 != null) {
            eVar3.onPageSelected(i);
        }
    }

    private boolean f(int i) {
        if (this.f.size() == 0) {
            if (this.T) {
                return false;
            }
            this.V = false;
            a(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b g2 = g();
        int clientWidth = getClientWidth();
        int i2 = this.q;
        int i3 = clientWidth + i2;
        float f2 = clientWidth;
        int i4 = g2.f1036b;
        float f3 = ((i / f2) - g2.e) / (g2.d + (i2 / f2));
        this.V = false;
        a(i4, f3, (int) (i3 * f3));
        if (this.V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private b g() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.q / clientWidth : 0.0f;
        b bVar = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i2 < this.f.size()) {
            b bVar2 = this.f.get(i2);
            if (!z && bVar2.f1036b != (i = i3 + 1)) {
                bVar2 = this.g;
                bVar2.e = f3 + f4 + f2;
                bVar2.f1036b = i;
                bVar2.d = this.i.b(bVar2.f1036b);
                i2--;
            }
            f3 = bVar2.e;
            float f5 = bVar2.d + f3 + f2;
            if (!z && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i2 == this.f.size() - 1) {
                return bVar2;
            }
            i3 = bVar2.f1036b;
            f4 = bVar2.d;
            i2++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f1033a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private boolean i() {
        this.K = -1;
        f();
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
    }

    private void j() {
        if (this.ga != 0) {
            ArrayList<View> arrayList = this.ha;
            if (arrayList == null) {
                this.ha = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ha.add(getChildAt(i));
            }
            Collections.sort(this.ha, d);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
        }
    }

    public void a(int i, boolean z) {
        this.A = false;
        a(i, z, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        b b2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1036b == this.j) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addOnAdapterChangeListener(d dVar) {
        if (this.da == null) {
            this.da = new ArrayList();
        }
        this.da.add(dVar);
    }

    public void addOnPageChangeListener(e eVar) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b b2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1036b == this.j) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.f1033a |= c(view);
        if (this.y) {
            if (layoutParams2 != null && layoutParams2.f1033a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.d = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    void b() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.n = new Scroller(context, c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.M = (int) (400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context);
        this.S = new EdgeEffect(context);
        this.O = (int) (25.0f * f2);
        this.P = (int) (2.0f * f2);
        this.E = (int) (f2 * 16.0f);
        t.a(this, new c());
        if (t.i(this) == 0) {
            t.d(this, 1);
        }
        t.a(this, new androidx.viewpager.widget.g(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void c(int r18) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c(int):void");
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.u)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.v));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.o = true;
        if (!this.n.isFinished() && this.n.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.n.getCurrX();
            int currY = this.n.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!f(currX)) {
                    this.n.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            t.C(this);
            return;
        }
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b b2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1036b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (aVar = this.i) == null || aVar.a() <= 1)) {
            this.R.finish();
            this.S.finish();
        } else {
            if (!this.R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.u * width);
                this.R.setSize(height, width);
                z = false | this.R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.v + 1.0f)) * width2);
                this.S.setSize(height2, width2);
                z |= this.S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z) {
            t.C(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.r;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        c(this.j);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ga == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.ha.get(i2).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.j;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.ia);
        Scroller scroller = this.n;
        if (scroller != null && !scroller.isFinished()) {
            this.n.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.q <= 0 || this.r == null || this.f.size() <= 0 || this.i == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f4 = this.q / width2;
        int i = 0;
        b bVar = this.f.get(0);
        float f5 = bVar.e;
        int size = this.f.size();
        int i2 = bVar.f1036b;
        int i3 = this.f.get(size - 1).f1036b;
        while (i2 < i3) {
            while (i2 > bVar.f1036b && i < size) {
                i++;
                bVar = this.f.get(i);
            }
            if (i2 == bVar.f1036b) {
                float f6 = bVar.e;
                float f7 = bVar.d;
                f2 = (f6 + f7) * width2;
                f5 = f6 + f7 + f4;
            } else {
                float b2 = this.i.b(i2);
                f2 = (f5 + b2) * width2;
                f5 += b2 + f4;
            }
            if (this.q + f2 > scrollX) {
                f3 = f4;
                this.r.setBounds(Math.round(f2), this.s, Math.round(this.q + f2), this.t);
                this.r.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + width) {
                return;
            }
            i2++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.C) {
                    return true;
                }
                if (this.D) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.I = x;
                this.G = x;
                float y = motionEvent.getY();
                this.J = y;
                this.H = y;
                this.K = motionEvent.getPointerId(0);
                this.D = false;
                this.o = true;
                this.n.computeScrollOffset();
                if (this.ja == 2 && Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.P) {
                    this.n.abortAnimation();
                    this.A = false;
                    e();
                    this.C = true;
                    c(true);
                    setScrollState(1);
                } else {
                    a(false);
                    this.C = false;
                }
            } else if (action == 2) {
                int i = this.K;
                if (i != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.G;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.J);
                    if (f2 != 0.0f && !a(this.G, f2) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.G = x2;
                        this.H = y2;
                        this.D = true;
                        return false;
                    }
                    if (abs > this.mTouchSlop && abs * 0.5f > abs2) {
                        this.C = true;
                        c(true);
                        setScrollState(1);
                        this.G = f2 > 0.0f ? this.I + this.mTouchSlop : this.I - this.mTouchSlop;
                        this.H = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.mTouchSlop) {
                        this.D = true;
                    }
                    if (this.C && b(x2)) {
                        t.C(this);
                    }
                }
            } else if (action == 6) {
                a(motionEvent);
            }
            if (this.L == null) {
                this.L = VelocityTracker.obtain();
            }
            this.L.addMovement(motionEvent);
            return this.C;
        }
        i();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        b b2;
        int max;
        int max2;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        int i9 = paddingTop;
        int i10 = paddingLeft;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1033a) {
                    int i12 = layoutParams.f1034b;
                    int i13 = i12 & 7;
                    int i14 = i12 & 112;
                    if (i13 == 1) {
                        max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, i10);
                    } else if (i13 == 3) {
                        max = i10;
                        i10 = childAt.getMeasuredWidth() + i10;
                    } else if (i13 != 5) {
                        max = i10;
                    } else {
                        max = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i14 == 16) {
                        max2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, i9);
                    } else if (i14 == 48) {
                        max2 = i9;
                        i9 = childAt.getMeasuredHeight() + i9;
                    } else if (i14 != 80) {
                        max2 = i9;
                    } else {
                        max2 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    int i15 = max + scrollX;
                    childAt.layout(i15, max2, childAt.getMeasuredWidth() + i15, max2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i16 = (i5 - i10) - paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f1033a && (b2 = b(childAt2)) != null) {
                    float f2 = i16;
                    int i18 = ((int) (b2.e * f2)) + i10;
                    if (layoutParams2.d) {
                        layoutParams2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - i9) - i7, 1073741824));
                    }
                    childAt2.layout(i18, i9, childAt2.getMeasuredWidth() + i18, childAt2.getMeasuredHeight() + i9);
                }
            }
        }
        this.s = i9;
        this.t = i6 - i7;
        this.W = i8;
        if (this.T) {
            z2 = false;
            a(this.j, false, 0, false);
        } else {
            z2 = false;
        }
        this.T = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        b b2;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1036b == this.j && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        androidx.viewpager.widget.a aVar = this.i;
        if (aVar != null) {
            aVar.a(savedState.d, savedState.e);
            a(savedState.c, false, true);
            return;
        }
        this.k = savedState.c;
        this.l = savedState.d;
        this.m = savedState.e;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.j;
        androidx.viewpager.widget.a aVar = this.i;
        if (aVar != null) {
            savedState.d = aVar.b();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.q;
            a(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        if (this.Q) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.i) == null || aVar.a() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.n.abortAnimation();
            this.A = false;
            e();
            float x = motionEvent.getX();
            this.I = x;
            this.G = x;
            float y = motionEvent.getY();
            this.J = y;
            this.H = y;
            this.K = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.C) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.K);
                    if (findPointerIndex == -1) {
                        z = i();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.G);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.H);
                        if (abs > this.mTouchSlop && abs > abs2) {
                            this.C = true;
                            c(true);
                            float f2 = this.I;
                            this.G = x2 - f2 > 0.0f ? f2 + this.mTouchSlop : f2 - this.mTouchSlop;
                            this.H = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.C) {
                    z = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.K)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.G = motionEvent.getX(actionIndex);
                    this.K = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    a(motionEvent);
                    this.G = motionEvent.getX(motionEvent.findPointerIndex(this.K));
                }
            } else if (this.C) {
                a(this.j, true, 0, false);
                z = i();
            }
        } else if (this.C) {
            VelocityTracker velocityTracker = this.L;
            velocityTracker.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND, this.N);
            int xVelocity = (int) velocityTracker.getXVelocity(this.K);
            this.A = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b g2 = g();
            float f3 = clientWidth;
            a(a(g2.f1036b, ((scrollX / f3) - g2.e) / (g2.d + (this.q / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.K)) - this.I)), true, true, xVelocity);
            z = i();
        }
        if (z) {
            t.C(this);
        }
        return true;
    }

    public void removeOnAdapterChangeListener(d dVar) {
        List<d> list = this.da;
        if (list != null) {
            list.remove(dVar);
        }
    }

    public void removeOnPageChangeListener(e eVar) {
        List<e> list = this.aa;
        if (list != null) {
            list.remove(eVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.b((DataSetObserver) null);
            this.i.b((ViewGroup) this);
            for (int i = 0; i < this.f.size(); i++) {
                b bVar = this.f.get(i);
                this.i.a((ViewGroup) this, bVar.f1036b, bVar.f1035a);
            }
            this.i.a((ViewGroup) this);
            this.f.clear();
            h();
            this.j = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.i;
        this.i = aVar;
        this.e = 0;
        if (this.i != null) {
            if (this.p == null) {
                this.p = new g();
            }
            this.i.b(this.p);
            this.A = false;
            boolean z = this.T;
            this.T = true;
            this.e = this.i.a();
            if (this.k >= 0) {
                this.i.a(this.l, this.m);
                a(this.k, false, true);
                this.k = -1;
                this.l = null;
                this.m = null;
            } else if (!z) {
                e();
            } else {
                requestLayout();
            }
        }
        List<d> list = this.da;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.da.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.da.get(i2).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i) {
        this.A = false;
        a(i, !this.T, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.B) {
            this.B = i;
            e();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
        this.ba = eVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.q;
        this.q = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (this.ja == i) {
            return;
        }
        this.ja = i;
        if (this.ea != null) {
            b(i != 0);
        }
        e(i);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1033a;

        /* renamed from: b  reason: collision with root package name */
        public int f1034b;
        float c;
        boolean d;
        int e;
        int f;

        public LayoutParams() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1031a);
            this.f1034b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    private void e(int i) {
        e eVar = this.ba;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i);
        }
        List<e> list = this.aa;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar2 = this.aa.get(i2);
                if (eVar2 != null) {
                    eVar2.onPageScrollStateChanged(i);
                }
            }
        }
        e eVar3 = this.ca;
        if (eVar3 != null) {
            eVar3.onPageScrollStateChanged(i);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        androidx.viewpager.widget.a aVar = this.i;
        if (aVar != null && aVar.a() > 0) {
            if (!z2 && this.j == i && this.f.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.i.a()) {
                i = this.i.a() - 1;
            }
            int i3 = this.B;
            int i4 = this.j;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.f.size(); i5++) {
                    this.f.get(i5).c = true;
                }
            }
            boolean z3 = this.j != i;
            if (this.T) {
                this.j = i;
                if (z3) {
                    d(i);
                }
                requestLayout();
                return;
            }
            c(i);
            a(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(androidx.core.content.a.c(getContext(), i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends C0067a {
        c() {
        }

        @Override // androidx.core.h.C0067a
        public void a(View view, androidx.core.h.a.c cVar) {
            super.a(view, cVar);
            cVar.a((CharSequence) ViewPager.class.getName());
            cVar.k(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(CpioConstants.C_ISFIFO);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(CpioConstants.C_ISCHR);
            }
        }

        @Override // androidx.core.h.C0067a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.i) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.a());
            accessibilityEvent.setFromIndex(ViewPager.this.j);
            accessibilityEvent.setToIndex(ViewPager.this.j);
        }

        private boolean b() {
            androidx.viewpager.widget.a aVar = ViewPager.this.i;
            return aVar != null && aVar.a() > 1;
        }

        @Override // androidx.core.h.C0067a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i == 8192 && ViewPager.this.canScrollHorizontally(-1)) {
                    ViewPager viewPager = ViewPager.this;
                    viewPager.setCurrentItem(viewPager.j - 1);
                    return true;
                }
                return false;
            } else if (ViewPager.this.canScrollHorizontally(1)) {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.j + 1);
                return true;
            } else {
                return false;
            }
        }
    }

    boolean d() {
        androidx.viewpager.widget.a aVar = this.i;
        if (aVar == null || this.j >= aVar.a() - 1) {
            return false;
        }
        a(this.j + 1, true);
        return true;
    }

    private void f() {
        this.C = false;
        this.D = false;
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.L = null;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new ArrayList<>();
        this.g = new b();
        this.h = new Rect();
        this.k = -1;
        this.l = null;
        this.m = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.B = 1;
        this.K = -1;
        this.T = true;
        this.U = false;
        this.ia = new androidx.viewpager.widget.f(this);
        this.ja = 0;
        b();
    }

    b b(View view) {
        for (int i = 0; i < this.f.size(); i++) {
            b bVar = this.f.get(i);
            if (this.i.a(view, bVar.f1035a)) {
                return bVar;
            }
        }
        return null;
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        b b2 = b(i);
        int clientWidth = b2 != null ? (int) (getClientWidth() * Math.max(this.u, Math.min(b2.e, this.v))) : 0;
        if (z) {
            a(clientWidth, 0, i2);
            if (z2) {
                d(i);
                return;
            }
            return;
        }
        if (z2) {
            d(i);
        }
        a(false);
        scrollTo(clientWidth, 0);
        f(clientWidth);
    }

    b b(int i) {
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            b bVar = this.f.get(i2);
            if (bVar.f1036b == i) {
                return bVar;
            }
        }
        return null;
    }

    private void b(int i, float f2, int i2) {
        e eVar = this.ba;
        if (eVar != null) {
            eVar.onPageScrolled(i, f2, i2);
        }
        List<e> list = this.aa;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = this.aa.get(i3);
                if (eVar2 != null) {
                    eVar2.onPageScrolled(i, f2, i2);
                }
            }
        }
        e eVar3 = this.ca;
        if (eVar3 != null) {
            eVar3.onPageScrolled(i, f2, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(e eVar) {
        e eVar2 = this.ca;
        this.ca = eVar;
        return eVar2;
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.fa : 0, null);
        }
    }

    float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    void a(int i, int i2, int i3) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.n;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.o ? this.n.getCurrX() : this.n.getStartX();
            this.n.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            e();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i7;
        float a2 = f3 + (a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i5) / ((f2 * this.i.b(this.j)) + this.q)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.o = false;
        this.n.startScroll(i4, scrollY, i5, i6, min);
        t.C(this);
    }

    private boolean b(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.G - f2;
        this.G = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.u * clientWidth;
        float f5 = this.v * clientWidth;
        boolean z3 = false;
        b bVar = this.f.get(0);
        ArrayList<b> arrayList = this.f;
        b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f1036b != 0) {
            f4 = bVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f1036b != this.i.a() - 1) {
            f5 = bVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.R.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.S.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i = (int) scrollX;
        this.G += scrollX - i;
        scrollTo(i, getScrollY());
        f(i);
        return z3;
    }

    b a(int i, int i2) {
        b bVar = new b();
        bVar.f1036b = i;
        bVar.f1035a = this.i.a((ViewGroup) this, i);
        bVar.d = this.i.b(i);
        if (i2 >= 0 && i2 < this.f.size()) {
            this.f.add(i2, bVar);
        } else {
            this.f.add(bVar);
        }
        return bVar;
    }

    void a() {
        int a2 = this.i.a();
        this.e = a2;
        boolean z = this.f.size() < (this.B * 2) + 1 && this.f.size() < a2;
        int i = this.j;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f.size()) {
            b bVar = this.f.get(i2);
            int a3 = this.i.a(bVar.f1035a);
            if (a3 != -1) {
                if (a3 == -2) {
                    this.f.remove(i2);
                    i2--;
                    if (!z2) {
                        this.i.b((ViewGroup) this);
                        z2 = true;
                    }
                    this.i.a((ViewGroup) this, bVar.f1036b, bVar.f1035a);
                    int i3 = this.j;
                    if (i3 == bVar.f1036b) {
                        i = Math.max(0, Math.min(i3, a2 - 1));
                    }
                } else {
                    int i4 = bVar.f1036b;
                    if (i4 != a3) {
                        if (i4 == this.j) {
                            i = a3;
                        }
                        bVar.f1036b = a3;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.i.a((ViewGroup) this);
        }
        Collections.sort(this.f, f1032b);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.f1033a) {
                    layoutParams.c = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    boolean c() {
        int i = this.j;
        if (i > 0) {
            a(i - 1, true);
            return true;
        }
        return false;
    }

    private void a(b bVar, int i, b bVar2) {
        int i2;
        int i3;
        b bVar3;
        b bVar4;
        int a2 = this.i.a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.q / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i4 = bVar2.f1036b;
            int i5 = bVar.f1036b;
            if (i4 < i5) {
                float f3 = bVar2.e + bVar2.d + f2;
                int i6 = i4 + 1;
                int i7 = 0;
                while (i6 <= bVar.f1036b && i7 < this.f.size()) {
                    b bVar5 = this.f.get(i7);
                    while (true) {
                        bVar4 = bVar5;
                        if (i6 <= bVar4.f1036b || i7 >= this.f.size() - 1) {
                            break;
                        }
                        i7++;
                        bVar5 = this.f.get(i7);
                    }
                    while (i6 < bVar4.f1036b) {
                        f3 += this.i.b(i6) + f2;
                        i6++;
                    }
                    bVar4.e = f3;
                    f3 += bVar4.d + f2;
                    i6++;
                }
            } else if (i4 > i5) {
                int size = this.f.size() - 1;
                float f4 = bVar2.e;
                while (true) {
                    i4--;
                    if (i4 < bVar.f1036b || size < 0) {
                        break;
                    }
                    b bVar6 = this.f.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i4 >= bVar3.f1036b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.f.get(size);
                    }
                    while (i4 > bVar3.f1036b) {
                        f4 -= this.i.b(i4) + f2;
                        i4--;
                    }
                    f4 -= bVar3.d + f2;
                    bVar3.e = f4;
                }
            }
        }
        int size2 = this.f.size();
        float f5 = bVar.e;
        int i8 = bVar.f1036b;
        int i9 = i8 - 1;
        this.u = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = a2 - 1;
        this.v = bVar.f1036b == i10 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        int i11 = i - 1;
        while (i11 >= 0) {
            b bVar7 = this.f.get(i11);
            while (true) {
                i3 = bVar7.f1036b;
                if (i9 <= i3) {
                    break;
                }
                f5 -= this.i.b(i9) + f2;
                i9--;
            }
            f5 -= bVar7.d + f2;
            bVar7.e = f5;
            if (i3 == 0) {
                this.u = f5;
            }
            i11--;
            i9--;
        }
        float f6 = bVar.e + bVar.d + f2;
        int i12 = bVar.f1036b + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            b bVar8 = this.f.get(i13);
            while (true) {
                i2 = bVar8.f1036b;
                if (i12 >= i2) {
                    break;
                }
                f6 += this.i.b(i12) + f2;
                i12++;
            }
            if (i2 == i10) {
                this.v = (bVar8.d + f6) - 1.0f;
            }
            bVar8.e = f6;
            f6 += bVar8.d + f2;
            i13++;
            i12++;
        }
        this.U = false;
    }

    b a(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return b(view);
            }
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f.isEmpty()) {
            if (!this.n.isFinished()) {
                this.n.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        b b2 = b(this.j);
        int min = (int) ((b2 != null ? Math.min(b2.e, this.v) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            a(false);
            scrollTo(min, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.W
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f1033a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f1034b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$f r13 = r12.ea
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f1033a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$f r3 = r12.ea
            r3.transformPage(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.V = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int, float, int):void");
    }

    private void a(boolean z) {
        boolean z2 = this.ja == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.n.isFinished()) {
                this.n.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        f(currX);
                    }
                }
            }
        }
        this.A = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f.size(); i++) {
            b bVar = this.f.get(i);
            if (bVar.c) {
                bVar.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                t.a(this, this.ia);
            } else {
                this.ia.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.F) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.F)) && f3 < 0.0f);
    }

    private int a(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) <= this.O || Math.abs(i2) <= this.M) {
            i += (int) (f2 + (i >= this.j ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f.size() > 0) {
            ArrayList<b> arrayList = this.f;
            return Math.max(this.f.get(0).f1036b, Math.min(i, arrayList.get(arrayList.size() - 1).f1036b));
        }
        return i;
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K) {
            int i = actionIndex == 0 ? 1 : 0;
            this.G = motionEvent.getX(i);
            this.K = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.L;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && a(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return c();
                }
                return a(17);
            } else if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return d();
                }
                return a(66);
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return a(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return a(1);
                }
            }
        }
        return false;
    }

    public boolean a(int i) {
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = a(this.h, findNextFocus).left;
                int i3 = a(this.h, view).left;
                if (view != null && i2 >= i3) {
                    requestFocus = c();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            } else if (i == 66) {
                int i4 = a(this.h, findNextFocus).left;
                int i5 = a(this.h, view).left;
                if (view != null && i4 <= i5) {
                    requestFocus = d();
                } else {
                    requestFocus = findNextFocus.requestFocus();
                }
            }
            z2 = requestFocus;
        } else if (i == 17 || i == 1) {
            z2 = c();
        } else if (i == 66 || i == 2) {
            z2 = d();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
