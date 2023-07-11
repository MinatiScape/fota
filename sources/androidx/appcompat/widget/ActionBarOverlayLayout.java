package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.v;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements C, androidx.core.h.m {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f200a = {R$attr.actionBarSize, 16842841};
    private final Runnable A;
    private final androidx.core.h.n B;

    /* renamed from: b  reason: collision with root package name */
    private int f201b;
    private int c;
    private ContentFrameLayout d;
    ActionBarContainer e;
    private D f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private a v;
    private OverScroller w;
    ViewPropertyAnimator x;
    final AnimatorListenerAdapter y;
    private final Runnable z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f200a);
        this.f201b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.g == null);
        obtainStyledAttributes.recycle();
        this.h = context.getApplicationInfo().targetSdkVersion < 19;
        this.w = new OverScroller(context);
    }

    private void d() {
        a();
        this.A.run();
    }

    private void e() {
        a();
        postDelayed(this.A, 600L);
    }

    private void f() {
        a();
        postDelayed(this.z, 600L);
    }

    private void g() {
        a();
        this.z.run();
    }

    public boolean b() {
        return this.i;
    }

    void c() {
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.e = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f = a(findViewById(R$id.action_bar));
        }
    }

    @Override // androidx.appcompat.widget.C
    public boolean canShowOverflowMenu() {
        c();
        return this.f.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.C
    public void dismissPopups() {
        c();
        this.f.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g == null || this.h) {
            return;
        }
        int bottom = this.e.getVisibility() == 0 ? (int) (this.e.getBottom() + this.e.getTranslationY() + 0.5f) : 0;
        this.g.setBounds(0, bottom, getWidth(), this.g.getIntrinsicHeight() + bottom);
        this.g.draw(canvas);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        c();
        int s = androidx.core.h.t.s(this) & CpioConstants.C_IRUSR;
        boolean a2 = a(this.e, rect, true, true, false, true);
        this.r.set(rect);
        wa.a(this, this.r, this.o);
        if (!this.s.equals(this.r)) {
            this.s.set(this.r);
            a2 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        c();
        return this.f.getTitle();
    }

    @Override // androidx.appcompat.widget.C
    public boolean hideOverflowMenu() {
        c();
        return this.f.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.C
    public void initFeature(int i) {
        c();
        if (i == 2) {
            this.f.initProgress();
        } else if (i == 5) {
            this.f.initIndeterminateProgress();
        } else if (i != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.C
    public boolean isOverflowMenuShowPending() {
        c();
        return this.f.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.C
    public boolean isOverflowMenuShowing() {
        c();
        return this.f.isOverflowMenuShowing();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        androidx.core.h.t.D(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        c();
        measureChildWithMargins(this.e, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.e.getLayoutParams();
        int max = Math.max(0, this.e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.e.getMeasuredState());
        boolean z = (androidx.core.h.t.s(this) & CpioConstants.C_IRUSR) != 0;
        if (z) {
            measuredHeight = this.f201b;
            if (this.j && this.e.getTabContainer() != null) {
                measuredHeight += this.f201b;
            }
        } else {
            measuredHeight = this.e.getVisibility() != 8 ? this.e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.t.set(this.r);
        if (!this.i && !z) {
            Rect rect = this.q;
            rect.top += measuredHeight;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.t;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        a(this.d, this.q, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.d.a(this.t);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.d.getLayoutParams();
        int max3 = Math.max(max, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.k && z) {
            if (a(f, f2)) {
                d();
            } else {
                g();
            }
            this.l = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.m += i2;
        setActionBarHideOffset(this.m);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.a(view, view2, i);
        this.m = getActionBarHideOffset();
        a();
        a aVar = this.v;
        if (aVar != null) {
            aVar.onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.m
    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.e.getHeight()) {
                f();
            } else {
                e();
            }
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.onContentScrollStopped();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & CpioConstants.C_IRUSR) != 0;
        a aVar = this.v;
        if (aVar != null) {
            aVar.enableContentAnimations(!z2);
            if (!z && z2) {
                this.v.hideForSystem();
            } else {
                this.v.showForSystem();
            }
        }
        if ((i2 & CpioConstants.C_IRUSR) == 0 || this.v == null) {
            return;
        }
        androidx.core.h.t.D(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        a aVar = this.v;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        a();
        this.e.setTranslationY(-Math.max(0, Math.min(i, this.e.getHeight())));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.v = aVar;
        if (getWindowToken() != null) {
            this.v.onWindowVisibilityChanged(this.c);
            int i = this.n;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                androidx.core.h.t.D(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (z) {
                return;
            }
            a();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        c();
        this.f.setIcon(i);
    }

    public void setLogo(int i) {
        c();
        this.f.setLogo(i);
    }

    @Override // androidx.appcompat.widget.C
    public void setMenuPrepared() {
        c();
        this.f.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.i = z;
        this.h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // androidx.appcompat.widget.C
    public void setWindowCallback(Window.Callback callback) {
        c();
        this.f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.C
    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.C
    public boolean showOverflowMenu() {
        c();
        return this.f.showOverflowMenu();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.y = new C0045d(this);
        this.z = new RunnableC0046e(this);
        this.A = new RunnableC0047f(this);
        a(context);
        this.B = new androidx.core.h.n(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.f.setIcon(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            r5 = 1
        L35:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.a(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private D a(View view) {
        if (view instanceof D) {
            return (D) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        ViewPropertyAnimator viewPropertyAnimator = this.x;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private boolean a(float f, float f2) {
        this.w.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.w.getFinalY() > this.e.getHeight();
    }

    @Override // androidx.appcompat.widget.C
    public void a(Menu menu, v.a aVar) {
        c();
        this.f.a(menu, aVar);
    }
}
