package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.D;
import androidx.core.h.t;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.s;
/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1250a;

    /* renamed from: b  reason: collision with root package name */
    private int f1251b;
    private Toolbar c;
    private View d;
    private View e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Rect j;
    final com.google.android.material.internal.e k;
    private boolean l;
    private boolean m;
    private Drawable n;
    Drawable o;
    private int p;
    private boolean q;
    private ValueAnimator r;
    private long s;
    private int t;
    private AppBarLayout.b u;
    int v;
    D w;

    /* loaded from: classes.dex */
    private class a implements AppBarLayout.b {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public void a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.v = i;
            D d = collapsingToolbarLayout.w;
            int e = d != null ? d.e() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                f b2 = CollapsingToolbarLayout.b(childAt);
                int i3 = layoutParams.f1252a;
                if (i3 == 1) {
                    b2.b(androidx.core.c.a.a(-i, 0, CollapsingToolbarLayout.this.a(childAt)));
                } else if (i3 == 2) {
                    b2.b(Math.round((-i) * layoutParams.f1253b));
                }
            }
            CollapsingToolbarLayout.this.a();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.o != null && e > 0) {
                t.C(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.k.b(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - t.l(CollapsingToolbarLayout.this)) - e));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    private void b() {
        if (this.f1250a) {
            Toolbar toolbar = null;
            this.c = null;
            this.d = null;
            int i = this.f1251b;
            if (i != -1) {
                this.c = (Toolbar) findViewById(i);
                Toolbar toolbar2 = this.c;
                if (toolbar2 != null) {
                    this.d = c(toolbar2);
                }
            }
            if (this.c == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i2);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i2++;
                }
                this.c = toolbar;
            }
            d();
            this.f1250a = false;
        }
    }

    private View c(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return view;
    }

    private void d() {
        View view;
        if (!this.l && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (!this.l || this.c == null) {
            return;
        }
        if (this.e == null) {
            this.e = new View(getContext());
        }
        if (this.e.getParent() == null) {
            this.c.addView(this.e, -1, -1);
        }
    }

    private boolean e(View view) {
        View view2 = this.d;
        if (view2 == null || view2 == this) {
            if (view == this.c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D a(D d) {
        D d2 = t.h(this) ? d : null;
        if (!androidx.core.g.c.a(this.w, d2)) {
            this.w = d2;
            requestLayout();
        }
        return d.a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.c == null && (drawable = this.n) != null && this.p > 0) {
            drawable.mutate().setAlpha(this.p);
            this.n.draw(canvas);
        }
        if (this.l && this.m) {
            this.k.a(canvas);
        }
        if (this.o == null || this.p <= 0) {
            return;
        }
        D d = this.w;
        int e = d != null ? d.e() : 0;
        if (e > 0) {
            this.o.setBounds(0, -this.v, getWidth(), e - this.v);
            this.o.mutate().setAlpha(this.p);
            this.o.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.n == null || this.p <= 0 || !e(view)) {
            z = false;
        } else {
            this.n.mutate().setAlpha(this.p);
            this.n.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.e eVar = this.k;
        if (eVar != null) {
            z |= eVar.a(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        return this.k.c();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.k.e();
    }

    public Drawable getContentScrim() {
        return this.n;
    }

    public int getExpandedTitleGravity() {
        return this.k.g();
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.k.h();
    }

    int getScrimAlpha() {
        return this.p;
    }

    public long getScrimAnimationDuration() {
        return this.s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.t;
        if (i >= 0) {
            return i;
        }
        D d = this.w;
        int e = d != null ? d.e() : 0;
        int l = t.l(this);
        if (l > 0) {
            return Math.min((l * 2) + e, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.o;
    }

    public CharSequence getTitle() {
        if (this.l) {
            return this.k.j();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            t.a(this, t.h((View) parent));
            if (this.u == null) {
                this.u = new a();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.u);
            t.D(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.b bVar = this.u;
        if (bVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(bVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        D d = this.w;
        if (d != null) {
            int e = d.e();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!t.h(childAt) && childAt.getTop() < e) {
                    t.b(childAt, e);
                }
            }
        }
        if (this.l && (view = this.e) != null) {
            this.m = t.y(view) && this.e.getVisibility() == 0;
            if (this.m) {
                boolean z2 = t.k(this) == 1;
                View view2 = this.d;
                if (view2 == null) {
                    view2 = this.c;
                }
                int a2 = a(view2);
                com.google.android.material.internal.f.a(this, this.e, this.j);
                this.k.a(this.j.left + (z2 ? this.c.getTitleMarginEnd() : this.c.getTitleMarginStart()), this.j.top + a2 + this.c.getTitleMarginTop(), this.j.right + (z2 ? this.c.getTitleMarginStart() : this.c.getTitleMarginEnd()), (this.j.bottom + a2) - this.c.getTitleMarginBottom());
                this.k.b(z2 ? this.h : this.f, this.j.top + this.g, (i3 - i) - (z2 ? this.f : this.h), (i4 - i2) - this.i);
                this.k.m();
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            b(getChildAt(i6)).c();
        }
        if (this.c != null) {
            if (this.l && TextUtils.isEmpty(this.k.j())) {
                setTitle(this.c.getTitle());
            }
            View view3 = this.d;
            if (view3 != null && view3 != this) {
                setMinimumHeight(d(view3));
            } else {
                setMinimumHeight(d(this.c));
            }
        }
        a();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        b();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        D d = this.w;
        int e = d != null ? d.e() : 0;
        if (mode != 0 || e <= 0) {
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + e, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.k.b(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.k.a(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.k.a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.n;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.n = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.n;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.n.setCallback(this);
                this.n.setAlpha(this.p);
            }
            t.C(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(androidx.core.content.a.c(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        this.k.d(i);
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.k.c(i);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.k.b(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.k.b(typeface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScrimAlpha(int i) {
        Toolbar toolbar;
        if (i != this.p) {
            if (this.n != null && (toolbar = this.c) != null) {
                t.C(toolbar);
            }
            this.p = i;
            t.C(this);
        }
    }

    public void setScrimAnimationDuration(long j) {
        this.s = j;
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.t != i) {
            this.t = i;
            a();
        }
    }

    public void setScrimsShown(boolean z) {
        a(z, t.z(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.o = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.o;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a(this.o, t.k(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
                this.o.setAlpha(this.p);
            }
            t.C(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(androidx.core.content.a.c(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.a(charSequence);
        c();
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            c();
            d();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.o;
        if (drawable != null && drawable.isVisible() != z) {
            this.o.setVisible(z, false);
        }
        Drawable drawable2 = this.n;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.n.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n || drawable == this.o;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.k.a(colorStateList);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1250a = true;
        this.j = new Rect();
        this.t = -1;
        this.k = new com.google.android.material.internal.e(this);
        this.k.b(com.google.android.material.a.a.e);
        TypedArray a2 = s.a(context, attributeSet, R$styleable.CollapsingToolbarLayout, i, R$style.Widget_Design_CollapsingToolbar, new int[0]);
        this.k.d(a2.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.k.b(a2.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.h = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.g = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.i = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.l = a2.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(a2.getText(R$styleable.CollapsingToolbarLayout_title));
        this.k.c(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.k.a(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.k.c(a2.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.k.a(a2.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.t = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.s = a2.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(a2.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(a2.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f1251b = a2.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        a2.recycle();
        setWillNotDraw(false);
        t.a(this, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private void c() {
        setContentDescription(getTitle());
    }

    public void a(boolean z, boolean z2) {
        if (this.q != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.q = z;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f1252a;

        /* renamed from: b  reason: collision with root package name */
        float f1253b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1252a = 0;
            this.f1253b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.f1252a = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f) {
            this.f1253b = f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1252a = 0;
            this.f1253b = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1252a = 0;
            this.f1253b = 0.5f;
        }
    }

    private void a(int i) {
        b();
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator == null) {
            this.r = new ValueAnimator();
            this.r.setDuration(this.s);
            this.r.setInterpolator(i > this.p ? com.google.android.material.a.a.c : com.google.android.material.a.a.d);
            this.r.addUpdateListener(new e(this));
        } else if (valueAnimator.isRunning()) {
            this.r.cancel();
        }
        this.r.setIntValues(this.p, i);
        this.r.start();
    }

    private static int d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    static f b(View view) {
        f fVar = (f) view.getTag(R$id.view_offset_helper);
        if (fVar == null) {
            f fVar2 = new f(view);
            view.setTag(R$id.view_offset_helper, fVar2);
            return fVar2;
        }
        return fVar;
    }

    final void a() {
        if (this.n == null && this.o == null) {
            return;
        }
        setScrimsShown(getHeight() + this.v < getScrimVisibleHeightTrigger());
    }

    final int a(View view) {
        return ((getHeight() - b(view).a()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }
}
