package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.C0067a;
import androidx.core.h.t;
import androidx.customview.a.g;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f866a;

    /* renamed from: b  reason: collision with root package name */
    private int f867b;
    private Drawable c;
    private Drawable d;
    private final int e;
    private boolean f;
    View g;
    float h;
    private float i;
    int j;
    boolean k;
    private int l;
    private float m;
    private Field mRecreateDisplayList;
    private float n;
    private d o;
    final g p;
    boolean q;
    private boolean r;
    private final Rect s;
    final ArrayList<b> t;
    private Method u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new androidx.slidingpanelayout.widget.a();
        boolean c;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final View f870a;

        b(View view) {
            this.f870a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f870a.getParent() == SlidingPaneLayout.this) {
                this.f870a.setLayerType(0, null);
                SlidingPaneLayout.this.d(this.f870a);
            }
            SlidingPaneLayout.this.t.remove(this);
        }
    }

    /* loaded from: classes.dex */
    private class c extends g.a {
        c() {
        }

        @Override // androidx.customview.a.g.a
        public void a(View view, int i) {
            SlidingPaneLayout.this.f();
        }

        @Override // androidx.customview.a.g.a
        public boolean b(View view, int i) {
            if (SlidingPaneLayout.this.k) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).c;
        }

        @Override // androidx.customview.a.g.a
        public void c(int i) {
            if (SlidingPaneLayout.this.p.f() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.h == 0.0f) {
                    slidingPaneLayout.f(slidingPaneLayout.g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.a(slidingPaneLayout2.g);
                    SlidingPaneLayout.this.q = false;
                    return;
                }
                slidingPaneLayout.b(slidingPaneLayout.g);
                SlidingPaneLayout.this.q = true;
            }
        }

        @Override // androidx.customview.a.g.a
        public void a(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.a(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.a.g.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.a.g.a
        public void a(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.b()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.j;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.g.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.h > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.j;
                }
            }
            SlidingPaneLayout.this.p.d(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.a.g.a
        public int a(View view) {
            return SlidingPaneLayout.this.j;
        }

        @Override // androidx.customview.a.g.a
        public int a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.g.getLayoutParams();
            if (SlidingPaneLayout.this.b()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + SlidingPaneLayout.this.g.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.j + paddingLeft);
        }

        @Override // androidx.customview.a.g.a
        public void a(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.p.a(slidingPaneLayout.g, i2);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view);

        void a(View view, float f);

        void b(View view);
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    private static boolean g(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    void a(View view) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    void b(View view) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.a(view);
        }
        sendAccessibilityEvent(32);
    }

    void c(View view) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.a(view, this.h);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.p.a(true)) {
            if (!this.f) {
                this.p.a();
            } else {
                t.C(this);
            }
        }
    }

    public boolean d() {
        return this.f;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        super.draw(canvas);
        if (b()) {
            drawable = this.d;
        } else {
            drawable = this.c;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (b()) {
            i2 = childAt.getRight();
            i = intrinsicWidth + i2;
        } else {
            int left = childAt.getLeft();
            int i3 = left - intrinsicWidth;
            i = left;
            i2 = i3;
        }
        drawable.setBounds(i2, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f && !layoutParams.c && this.g != null) {
            canvas.getClipBounds(this.s);
            if (b()) {
                Rect rect = this.s;
                rect.left = Math.max(rect.left, this.g.getRight());
            } else {
                Rect rect2 = this.s;
                rect2.right = Math.min(rect2.right, this.g.getLeft());
            }
            canvas.clipRect(this.s);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public boolean e() {
        return b(this.g, 0);
    }

    void f(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        View view2 = view;
        boolean b2 = b();
        int width = b2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = b2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !g(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z = b2;
            } else {
                int max = Math.max(b2 ? paddingLeft : width, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (b2) {
                    z = b2;
                    i5 = width;
                } else {
                    z = b2;
                    i5 = paddingLeft;
                }
                childAt.setVisibility((max < i || max2 < i3 || Math.min(i5, childAt.getRight()) > i2 || Math.min(height, childAt.getBottom()) > i4) ? 0 : 4);
            }
            i6++;
            view2 = view;
            b2 = z;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f867b;
    }

    public int getParallaxDistance() {
        return this.l;
    }

    public int getSliderFadeColor() {
        return this.f866a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
        int size = this.t.size();
        for (int i = 0; i < size; i++) {
            this.t.get(i).run();
        }
        this.t.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.q = !this.p.a(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f || (this.k && actionMasked != 0)) {
            this.p.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.p.b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.k = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.m = x;
                this.n = y;
                if (this.p.a(this.g, (int) x, (int) y) && e(this.g)) {
                    z = true;
                    return this.p.b(motionEvent) || z;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.m);
                float abs2 = Math.abs(y2 - this.n);
                if (abs > this.p.e() && abs2 > abs) {
                    this.p.b();
                    this.k = true;
                    return false;
                }
            }
            z = false;
            if (this.p.b(motionEvent)) {
                return true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean b2 = b();
        if (b2) {
            this.p.d(2);
        } else {
            this.p.d(1);
        }
        int i10 = i3 - i;
        int paddingRight = b2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = b2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.r) {
            this.h = (this.f && this.q) ? 1.0f : 0.0f;
        }
        int i11 = paddingRight;
        int i12 = i11;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.c) {
                    int i14 = i10 - paddingLeft;
                    int min = (Math.min(i11, i14 - this.e) - i12) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.j = min;
                    int i15 = b2 ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layoutParams.d = ((i12 + i15) + min) + (measuredWidth / 2) > i14;
                    int i16 = (int) (min * this.h);
                    i5 = i15 + i16 + i12;
                    this.h = i16 / this.j;
                    i6 = 0;
                } else if (!this.f || (i7 = this.l) == 0) {
                    i5 = i11;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.h) * i7);
                    i5 = i11;
                }
                if (b2) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i11 += childAt.getWidth();
                i12 = i5;
            }
        }
        if (this.r) {
            if (this.f) {
                if (this.l != 0) {
                    a(this.h);
                }
                if (((LayoutParams) this.g.getLayoutParams()).d) {
                    a(this.g, this.h, this.f866a);
                }
            } else {
                for (int i17 = 0; i17 < childCount; i17++) {
                    a(getChildAt(i17), 0.0f, this.f866a);
                }
            }
            f(this.g);
        }
        this.r = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        int makeMeasureSpec;
        int i5;
        int i6;
        int makeMeasureSpec2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = 0;
        } else if (mode2 != 1073741824) {
            i3 = 0;
            paddingTop = 0;
        } else {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = i3;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.g = null;
        int i7 = i3;
        int i8 = paddingLeft;
        int i9 = 0;
        boolean z2 = false;
        float f = 0.0f;
        while (true) {
            i4 = 8;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.d = z;
            } else {
                float f2 = layoutParams.f869b;
                if (f2 > 0.0f) {
                    f += f2;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i10, Integer.MIN_VALUE);
                } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i10, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams).width, 1073741824);
                }
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams).height, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i7) {
                    i7 = Math.min(measuredHeight, paddingTop);
                }
                i8 -= measuredWidth;
                boolean z3 = i8 < 0;
                layoutParams.c = z3;
                boolean z4 = z3 | z2;
                if (layoutParams.c) {
                    this.g = childAt;
                }
                z2 = z4;
            }
            i9++;
            z = false;
        }
        if (z2 || f > 0.0f) {
            int i11 = paddingLeft - this.e;
            int i12 = 0;
            while (i12 < childCount) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() != i4) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i4) {
                        boolean z5 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.f869b > 0.0f;
                        int measuredWidth2 = z5 ? 0 : childAt2.getMeasuredWidth();
                        if (z2 && childAt2 != this.g) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i11 || layoutParams2.f869b > 0.0f)) {
                                if (z5) {
                                    if (((ViewGroup.MarginLayoutParams) layoutParams2).height == -2) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i6 = 1073741824;
                                    } else if (((ViewGroup.MarginLayoutParams) layoutParams2).height == -1) {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i6 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).height, 1073741824);
                                    }
                                } else {
                                    i6 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(i11, i6), makeMeasureSpec2);
                            }
                        } else if (layoutParams2.f869b > 0.0f) {
                            if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).height == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else if (((ViewGroup.MarginLayoutParams) layoutParams2).height == -1) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) layoutParams2).height, 1073741824);
                                }
                            } else {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            if (z2) {
                                int i13 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                i5 = i11;
                                int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                                if (measuredWidth2 != i13) {
                                    childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                }
                                i12++;
                                i11 = i5;
                                i4 = 8;
                            } else {
                                i5 = i11;
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.f869b * Math.max(0, i8)) / f)), 1073741824), makeMeasureSpec);
                                i12++;
                                i11 = i5;
                                i4 = 8;
                            }
                        }
                    }
                }
                i5 = i11;
                i12++;
                i11 = i5;
                i4 = 8;
            }
        }
        setMeasuredDimension(size, i7 + getPaddingTop() + getPaddingBottom());
        this.f = z2;
        if (this.p.f() == 0 || z2) {
            return;
        }
        this.p.a();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.c) {
            e();
        } else {
            a();
        }
        this.q = savedState.c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = d() ? c() : this.q;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.r = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f) {
            return super.onTouchEvent(motionEvent);
        }
        this.p.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && e(this.g)) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.m;
                float f2 = y - this.n;
                int e = this.p.e();
                if ((f * f) + (f2 * f2) < e * e && this.p.a(this.g, (int) x, (int) y)) {
                    a(this.g, 0);
                }
            }
        } else {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.m = x2;
            this.n = y2;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f) {
            return;
        }
        this.q = view == this.g;
    }

    public void setCoveredFadeColor(int i) {
        this.f867b = i;
    }

    public void setPanelSlideListener(d dVar) {
        this.o = dVar;
    }

    public void setParallaxDistance(int i) {
        this.l = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(androidx.core.content.a.c(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(androidx.core.content.a.c(getContext(), i));
    }

    public void setSliderFadeColor(int i) {
        this.f866a = i;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f868a = {16843137};

        /* renamed from: b  reason: collision with root package name */
        public float f869b;
        boolean c;
        boolean d;
        Paint e;

        public LayoutParams() {
            super(-1, -1);
            this.f869b = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f869b = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f869b = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f869b = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f868a);
            this.f869b = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    class a extends C0067a {
        private final Rect c = new Rect();

        a() {
        }

        @Override // androidx.core.h.C0067a
        public void a(View view, androidx.core.h.a.c cVar) {
            androidx.core.h.a.c a2 = androidx.core.h.a.c.a(cVar);
            super.a(view, a2);
            a(cVar, a2);
            a2.w();
            cVar.a((CharSequence) SlidingPaneLayout.class.getName());
            cVar.d(view);
            ViewParent p = t.p(view);
            if (p instanceof View) {
                cVar.c((View) p);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    t.d(childAt, 1);
                    cVar.a(childAt);
                }
            }
        }

        @Override // androidx.core.h.C0067a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.e(view);
        }

        @Override // androidx.core.h.C0067a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (b(view)) {
                return false;
            }
            return super.a(viewGroup, view, accessibilityEvent);
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
            cVar.b(cVar2.f());
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    void d(View view) {
        Field field;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            t.a(view, ((LayoutParams) view.getLayoutParams()).e);
            return;
        }
        if (i >= 16) {
            if (!this.v) {
                try {
                    this.u = View.class.getDeclaredMethod("getDisplayList", null);
                } catch (NoSuchMethodException e) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
                }
                try {
                    this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    this.mRecreateDisplayList.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.v = true;
            }
            if (this.u != null && (field = this.mRecreateDisplayList) != null) {
                try {
                    field.setBoolean(view, true);
                    this.u.invoke(view, null);
                } catch (Exception e3) {
                    Log.e("SlidingPaneLayout", "Error refreshing display list state", e3);
                }
            } else {
                view.invalidate();
                return;
            }
        }
        t.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    boolean e(View view) {
        if (view == null) {
            return false;
        }
        return this.f && ((LayoutParams) view.getLayoutParams()).d && this.h > 0.0f;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f866a = -858993460;
        this.r = true;
        this.s = new Rect();
        this.t = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.e = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        t.a(this, new a());
        t.d(this, 1);
        this.p = g.a(this, 0.5f, new c());
        this.p.a(f * 400.0f);
    }

    public boolean c() {
        return !this.f || this.h == 1.0f;
    }

    private boolean a(View view, int i) {
        if (this.r || a(0.0f, i)) {
            this.q = false;
            return true;
        }
        return false;
    }

    private boolean b(View view, int i) {
        if (this.r || a(1.0f, i)) {
            this.q = true;
            return true;
        }
        return false;
    }

    public boolean a() {
        return a(this.g, 0);
    }

    boolean b() {
        return t.k(this) == 1;
    }

    void a(int i) {
        if (this.g == null) {
            this.h = 0.0f;
            return;
        }
        boolean b2 = b();
        LayoutParams layoutParams = (LayoutParams) this.g.getLayoutParams();
        int width = this.g.getWidth();
        if (b2) {
            i = (getWidth() - i) - width;
        }
        this.h = (i - ((b2 ? getPaddingRight() : getPaddingLeft()) + (b2 ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.j;
        if (this.l != 0) {
            a(this.h);
        }
        if (layoutParams.d) {
            a(this.g, this.h, this.f866a);
        }
        c(this.g);
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & 16777215);
            if (layoutParams.e == null) {
                layoutParams.e = new Paint();
            }
            layoutParams.e.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.e);
            }
            d(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.e;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            b bVar = new b(view);
            this.t.add(bVar);
            t.a(this, bVar);
        }
    }

    void f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    boolean a(float f, int i) {
        int paddingLeft;
        if (this.f) {
            boolean b2 = b();
            LayoutParams layoutParams = (LayoutParams) this.g.getLayoutParams();
            if (b2) {
                paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f * this.j)) + this.g.getWidth()));
            } else {
                paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f * this.j));
            }
            g gVar = this.p;
            View view = this.g;
            if (gVar.b(view, paddingLeft, view.getTop())) {
                f();
                t.C(this);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.b()
            android.view.View r1 = r9.g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.d
            r3 = 0
            if (r2 == 0) goto L1c
            if (r0 == 0) goto L16
            int r1 = r1.rightMargin
            goto L18
        L16:
            int r1 = r1.leftMargin
        L18:
            if (r1 > 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = 0
        L1d:
            int r2 = r9.getChildCount()
        L21:
            if (r3 >= r2) goto L5b
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.g
            if (r4 != r5) goto L2c
            goto L58
        L2c:
            float r5 = r9.i
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.l
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.i = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L44
            int r5 = -r5
        L44:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L58
            if (r0 == 0) goto L4f
            float r5 = r9.i
            float r5 = r5 - r6
            goto L53
        L4f:
            float r5 = r9.i
            float r5 = r6 - r5
        L53:
            int r6 = r9.f867b
            r9.a(r4, r5, r6)
        L58:
            int r3 = r3 + 1
            goto L21
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(float):void");
    }
}
