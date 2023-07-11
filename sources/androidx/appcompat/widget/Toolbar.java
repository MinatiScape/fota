package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.h.C0069c;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private boolean B;
    private boolean C;
    private final ArrayList<View> D;
    private final ArrayList<View> E;
    private final int[] F;
    b G;
    private final ActionMenuView.d H;
    private pa I;
    private ActionMenuPresenter J;
    private a K;
    private v.a L;
    private l.a M;
    private boolean N;
    private final Runnable O;

    /* renamed from: a  reason: collision with root package name */
    private ActionMenuView f295a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f296b;
    private TextView c;
    private ImageButton d;
    private ImageView e;
    private Drawable f;
    private CharSequence g;
    ImageButton h;
    View i;
    private Context j;
    private int k;
    private int l;
    private int m;
    int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private M t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private int z;

    /* loaded from: classes.dex */
    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.d.g(getContext());
    }

    private void l() {
        if (this.t == null) {
            this.t = new M();
        }
    }

    private void m() {
        if (this.e == null) {
            this.e = new AppCompatImageView(getContext());
        }
    }

    private void n() {
        o();
        if (this.f295a.g() == null) {
            androidx.appcompat.view.menu.l lVar = (androidx.appcompat.view.menu.l) this.f295a.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.f295a.setExpandedActionViewsExclusive(true);
            lVar.a(this.K, this.j);
        }
    }

    private void o() {
        if (this.f295a == null) {
            this.f295a = new ActionMenuView(getContext());
            this.f295a.setPopupTheme(this.k);
            this.f295a.setOnMenuItemClickListener(this.H);
            this.f295a.a(this.L, this.M);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f48a = 8388613 | (this.n & 112);
            this.f295a.setLayoutParams(generateDefaultLayoutParams);
            a((View) this.f295a, false);
        }
    }

    private void p() {
        if (this.d == null) {
            this.d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f48a = 8388611 | (this.n & 112);
            this.d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (this.N) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (d(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void a(androidx.appcompat.view.menu.l lVar, ActionMenuPresenter actionMenuPresenter) {
        if (lVar == null && this.f295a == null) {
            return;
        }
        o();
        androidx.appcompat.view.menu.l g = this.f295a.g();
        if (g == lVar) {
            return;
        }
        if (g != null) {
            g.b(this.J);
            g.b(this.K);
        }
        if (this.K == null) {
            this.K = new a();
        }
        actionMenuPresenter.a(true);
        if (lVar != null) {
            lVar.a(actionMenuPresenter, this.j);
            lVar.a(this.K, this.j);
        } else {
            actionMenuPresenter.a(this.j, (androidx.appcompat.view.menu.l) null);
            this.K.a(this.j, (androidx.appcompat.view.menu.l) null);
            actionMenuPresenter.updateMenuView(true);
            this.K.updateMenuView(true);
        }
        this.f295a.setPopupTheme(this.k);
        this.f295a.setPresenter(actionMenuPresenter);
        this.J = actionMenuPresenter;
    }

    public boolean b() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f295a) != null && actionMenuView.f();
    }

    public void c() {
        a aVar = this.K;
        androidx.appcompat.view.menu.p pVar = aVar == null ? null : aVar.f299b;
        if (pVar != null) {
            pVar.collapseActionView();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void d() {
        ActionMenuView actionMenuView = this.f295a;
        if (actionMenuView != null) {
            actionMenuView.a();
        }
    }

    void e() {
        if (this.h == null) {
            this.h = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.h.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f48a = 8388611 | (this.n & 112);
            generateDefaultLayoutParams.f297b = 2;
            this.h.setLayoutParams(generateDefaultLayoutParams);
            this.h.setOnClickListener(new la(this));
        }
    }

    public boolean f() {
        a aVar = this.K;
        return (aVar == null || aVar.f299b == null) ? false : true;
    }

    public boolean g() {
        ActionMenuView actionMenuView = this.f295a;
        return actionMenuView != null && actionMenuView.c();
    }

    public int getContentInsetEnd() {
        M m = this.t;
        if (m != null) {
            return m.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        M m = this.t;
        if (m != null) {
            return m.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        M m = this.t;
        if (m != null) {
            return m.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        M m = this.t;
        if (m != null) {
            return m.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.l g;
        ActionMenuView actionMenuView = this.f295a;
        if ((actionMenuView == null || (g = actionMenuView.g()) == null || !g.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.v, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (androidx.core.h.t.k(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (androidx.core.h.t.k(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.u, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        n();
        return this.f295a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        n();
        return this.f295a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public D getWrapper() {
        if (this.I == null) {
            this.I = new pa(this, true);
        }
        return this.I;
    }

    public boolean h() {
        ActionMenuView actionMenuView = this.f295a;
        return actionMenuView != null && actionMenuView.d();
    }

    public boolean i() {
        ActionMenuView actionMenuView = this.f295a;
        return actionMenuView != null && actionMenuView.e();
    }

    void j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).f297b != 2 && childAt != this.f295a) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    public boolean k() {
        ActionMenuView actionMenuView = this.f295a;
        return actionMenuView != null && actionMenuView.h();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02a6 A[LOOP:0: B:104:0x02a4->B:105:0x02a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c8 A[LOOP:1: B:107:0x02c6->B:108:0x02c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0302 A[LOOP:2: B:116:0x0300->B:117:0x0302, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.F;
        if (wa.a(this)) {
            c = 1;
            c2 = 0;
        } else {
            c = 0;
            c2 = 1;
        }
        if (d(this.d)) {
            a(this.d, i, 0, i2, 0, this.o);
            i3 = this.d.getMeasuredWidth() + a(this.d);
            i4 = Math.max(0, this.d.getMeasuredHeight() + b(this.d));
            i5 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (d(this.h)) {
            a(this.h, i, 0, i2, 0, this.o);
            i3 = this.h.getMeasuredWidth() + a(this.h);
            i4 = Math.max(i4, this.h.getMeasuredHeight() + b(this.h));
            i5 = View.combineMeasuredStates(i5, this.h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i3);
        iArr[c] = Math.max(0, currentContentInsetStart - i3);
        if (d(this.f295a)) {
            a(this.f295a, i, max, i2, 0, this.o);
            i6 = this.f295a.getMeasuredWidth() + a(this.f295a);
            i4 = Math.max(i4, this.f295a.getMeasuredHeight() + b(this.f295a));
            i5 = View.combineMeasuredStates(i5, this.f295a.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i6);
        if (d(this.i)) {
            max2 += a(this.i, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.i.getMeasuredHeight() + b(this.i));
            i5 = View.combineMeasuredStates(i5, this.i.getMeasuredState());
        }
        if (d(this.e)) {
            max2 += a(this.e, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.e.getMeasuredHeight() + b(this.e));
            i5 = View.combineMeasuredStates(i5, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((LayoutParams) childAt.getLayoutParams()).f297b == 0 && d(childAt)) {
                i11 += a(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + b(childAt));
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i13 = this.r + this.s;
        int i14 = this.p + this.q;
        if (d(this.f296b)) {
            a(this.f296b, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.f296b.getMeasuredWidth() + a(this.f296b);
            i9 = this.f296b.getMeasuredHeight() + b(this.f296b);
            i7 = View.combineMeasuredStates(i5, this.f296b.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i7 = i5;
            i8 = 0;
            i9 = 0;
        }
        if (d(this.c)) {
            i8 = Math.max(i8, a(this.c, i, i11 + i14, i2, i9 + i13, iArr));
            i9 += this.c.getMeasuredHeight() + b(this.c);
            i7 = View.combineMeasuredStates(i7, this.c.getMeasuredState());
        }
        int max3 = Math.max(i10, i9);
        int paddingLeft = i11 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i7);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (r()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f295a;
        androidx.appcompat.view.menu.l g = actionMenuView != null ? actionMenuView.g() : null;
        int i = savedState.c;
        if (i != 0 && this.K != null && g != null && (findItem = g.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (savedState.d) {
            q();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        l();
        this.t.a(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.p pVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        a aVar = this.K;
        if (aVar != null && (pVar = aVar.f299b) != null) {
            savedState.c = pVar.getItemId();
        }
        savedState.d = i();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        p();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(b bVar) {
        this.G = bVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.f295a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        this.A = i;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.z = i;
        TextView textView = this.f296b;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        int f297b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f297b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f297b = 0;
            this.f48a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f297b = 0;
            this.f297b = layoutParams.f297b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f297b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f297b = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f297b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public void b(Context context, int i) {
        this.l = i;
        TextView textView = this.f296b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!c(this.e)) {
                a((View) this.e, true);
            }
        } else {
            ImageView imageView = this.e;
            if (imageView != null && c(imageView)) {
                removeView(this.e);
                this.E.remove(this.e);
            }
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!c(this.d)) {
                a((View) this.d, true);
            }
        } else {
            ImageButton imageButton = this.d;
            if (imageButton != null && c(imageButton)) {
                removeView(this.d);
                this.E.remove(this.d);
            }
        }
        ImageButton imageButton2 = this.d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                this.c = new AppCompatTextView(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                int i2 = this.A;
                if (i2 != 0) {
                    this.c.setTextColor(i2);
                }
            }
            if (!c(this.c)) {
                a((View) this.c, true);
            }
        } else {
            TextView textView = this.c;
            if (textView != null && c(textView)) {
                removeView(this.c);
                this.E.remove(this.c);
            }
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f296b == null) {
                Context context = getContext();
                this.f296b = new AppCompatTextView(context);
                this.f296b.setSingleLine();
                this.f296b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.l;
                if (i != 0) {
                    this.f296b.setTextAppearance(context, i);
                }
                int i2 = this.z;
                if (i2 != 0) {
                    this.f296b.setTextColor(i2);
                }
            }
            if (!c(this.f296b)) {
                a((View) this.f296b, true);
            }
        } else {
            TextView textView = this.f296b;
            if (textView != null && c(textView)) {
                removeView(this.f296b);
                this.E.remove(this.f296b);
            }
        }
        TextView textView2 = this.f296b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.x = charSequence;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new ma();
        int c;
        boolean d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.appcompat.view.menu.v {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.view.menu.l f298a;

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.view.menu.p f299b;

        a() {
        }

        @Override // androidx.appcompat.view.menu.v
        public void a(Context context, androidx.appcompat.view.menu.l lVar) {
            androidx.appcompat.view.menu.p pVar;
            androidx.appcompat.view.menu.l lVar2 = this.f298a;
            if (lVar2 != null && (pVar = this.f299b) != null) {
                lVar2.a(pVar);
            }
            this.f298a = lVar;
        }

        @Override // androidx.appcompat.view.menu.v
        public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.v
        public boolean a(androidx.appcompat.view.menu.D d) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.v
        public boolean b(androidx.appcompat.view.menu.l lVar, androidx.appcompat.view.menu.p pVar) {
            View view = Toolbar.this.i;
            if (view instanceof androidx.appcompat.d.c) {
                ((androidx.appcompat.d.c) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.i = null;
            toolbar3.a();
            this.f299b = null;
            Toolbar.this.requestLayout();
            pVar.a(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.v
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.v
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.v
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.v
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.v
        public void updateMenuView(boolean z) {
            if (this.f299b != null) {
                androidx.appcompat.view.menu.l lVar = this.f298a;
                boolean z2 = false;
                if (lVar != null) {
                    int size = lVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f298a.getItem(i) == this.f299b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                b(this.f298a, this.f299b);
            }
        }

        @Override // androidx.appcompat.view.menu.v
        public boolean a(androidx.appcompat.view.menu.l lVar, androidx.appcompat.view.menu.p pVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.h);
            }
            Toolbar.this.i = pVar.getActionView();
            this.f299b = pVar;
            ViewParent parent2 = Toolbar.this.i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.i);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f48a = 8388611 | (toolbar4.n & 112);
                generateDefaultLayoutParams.f297b = 2;
                toolbar4.i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.i);
            }
            Toolbar.this.j();
            Toolbar.this.requestLayout();
            pVar.a(true);
            View view = Toolbar.this.i;
            if (view instanceof androidx.appcompat.d.c) {
                ((androidx.appcompat.d.c) view).onActionViewExpanded();
            }
            return true;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 8388627;
        this.D = new ArrayList<>();
        this.E = new ArrayList<>();
        this.F = new int[2];
        this.H = new ja(this);
        this.O = new ka(this);
        ia a2 = ia.a(getContext(), attributeSet, R$styleable.Toolbar, i, 0);
        this.l = a2.g(R$styleable.Toolbar_titleTextAppearance, 0);
        this.m = a2.g(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.w = a2.e(R$styleable.Toolbar_android_gravity, this.w);
        this.n = a2.e(R$styleable.Toolbar_buttonGravity, 48);
        int b2 = a2.b(R$styleable.Toolbar_titleMargin, 0);
        b2 = a2.g(R$styleable.Toolbar_titleMargins) ? a2.b(R$styleable.Toolbar_titleMargins, b2) : b2;
        this.s = b2;
        this.r = b2;
        this.q = b2;
        this.p = b2;
        int b3 = a2.b(R$styleable.Toolbar_titleMarginStart, -1);
        if (b3 >= 0) {
            this.p = b3;
        }
        int b4 = a2.b(R$styleable.Toolbar_titleMarginEnd, -1);
        if (b4 >= 0) {
            this.q = b4;
        }
        int b5 = a2.b(R$styleable.Toolbar_titleMarginTop, -1);
        if (b5 >= 0) {
            this.r = b5;
        }
        int b6 = a2.b(R$styleable.Toolbar_titleMarginBottom, -1);
        if (b6 >= 0) {
            this.s = b6;
        }
        this.o = a2.c(R$styleable.Toolbar_maxButtonHeight, -1);
        int b7 = a2.b(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b8 = a2.b(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int c = a2.c(R$styleable.Toolbar_contentInsetLeft, 0);
        int c2 = a2.c(R$styleable.Toolbar_contentInsetRight, 0);
        l();
        this.t.a(c, c2);
        if (b7 != Integer.MIN_VALUE || b8 != Integer.MIN_VALUE) {
            this.t.b(b7, b8);
        }
        this.u = a2.b(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.v = a2.b(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f = a2.b(R$styleable.Toolbar_collapseIcon);
        this.g = a2.e(R$styleable.Toolbar_collapseContentDescription);
        CharSequence e = a2.e(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(e)) {
            setTitle(e);
        }
        CharSequence e2 = a2.e(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(e2)) {
            setSubtitle(e2);
        }
        this.j = getContext();
        setPopupTheme(a2.g(R$styleable.Toolbar_popupTheme, 0));
        Drawable b9 = a2.b(R$styleable.Toolbar_navigationIcon);
        if (b9 != null) {
            setNavigationIcon(b9);
        }
        CharSequence e3 = a2.e(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(e3)) {
            setNavigationContentDescription(e3);
        }
        Drawable b10 = a2.b(R$styleable.Toolbar_logo);
        if (b10 != null) {
            setLogo(b10);
        }
        CharSequence e4 = a2.e(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(e4)) {
            setLogoDescription(e4);
        }
        if (a2.g(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.a(R$styleable.Toolbar_titleTextColor, -1));
        }
        if (a2.g(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.a(R$styleable.Toolbar_subtitleTextColor, -1));
        }
        a2.a();
    }

    private boolean c(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    private boolean d(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int b(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.w & 112;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public void a(Context context, int i) {
        this.m = i;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void a(int i, int i2) {
        l();
        this.t.b(i, i2);
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f297b = 1;
        if (z && this.i != null) {
            view.setLayoutParams(layoutParams);
            this.E.add(view);
            return;
        }
        addView(view, layoutParams);
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i4;
            int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i3;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i3 = max4;
            i4 = max3;
        }
        return i6;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int b2 = b(layoutParams.f48a);
        if (b2 != 48) {
            if (b2 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i3 < i4) {
                    i3 = i4;
                } else {
                    int i5 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (i5 < i6) {
                        i3 = Math.max(0, i3 - (i6 - i5));
                    }
                }
                return paddingTop + i3;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
        }
        return getPaddingTop() - i2;
    }

    private void a(List<View> list, int i) {
        boolean z = androidx.core.h.t.k(this) == 1;
        int childCount = getChildCount();
        int a2 = C0069c.a(i, androidx.core.h.t.k(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f297b == 0 && d(childAt) && a(layoutParams.f48a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f297b == 0 && d(childAt2) && a(layoutParams2.f48a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private int a(int i) {
        int k = androidx.core.h.t.k(this);
        int a2 = C0069c.a(i, k) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : k == 1 ? 5 : 3;
    }

    private int a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.h.f.b(marginLayoutParams) + androidx.core.h.f.a(marginLayoutParams);
    }

    void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView(this.E.get(size));
        }
        this.E.clear();
    }

    public void a(v.a aVar, l.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        ActionMenuView actionMenuView = this.f295a;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }
}
