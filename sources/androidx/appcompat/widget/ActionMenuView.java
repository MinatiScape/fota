package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.LinearLayoutCompat;
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements l.b, androidx.appcompat.view.menu.w {
    d A;
    private androidx.appcompat.view.menu.l p;
    private Context q;
    private int r;
    private boolean s;
    private ActionMenuPresenter t;
    private v.a u;
    l.a v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public boolean c;
        @ViewDebug.ExportedProperty
        public int d;
        @ViewDebug.ExportedProperty
        public int e;
        @ViewDebug.ExportedProperty
        public boolean f;
        @ViewDebug.ExportedProperty
        public boolean g;
        boolean h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.c = layoutParams.c;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.c = false;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements v.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.v.a
        public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.v.a
        public boolean a(androidx.appcompat.view.menu.l lVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.a();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        layoutParams.f = (layoutParams.c || !z2) ? false : false;
        layoutParams.d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x023b A[LOOP:5: B:138:0x023b->B:143:0x025a, LOOP_START, PHI: r13 
      PHI: (r13v4 int) = (r13v3 int), (r13v5 int) binds: [B:137:0x0239, B:143:0x025a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0262  */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e(int r30, int r31) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.e(int, int):void");
    }

    public LayoutParams b() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.c = true;
        return generateDefaultLayoutParams;
    }

    public boolean c() {
        ActionMenuPresenter actionMenuPresenter = this.t;
        return actionMenuPresenter != null && actionMenuPresenter.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public boolean d() {
        ActionMenuPresenter actionMenuPresenter = this.t;
        return actionMenuPresenter != null && actionMenuPresenter.f();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean f() {
        return this.s;
    }

    public androidx.appcompat.view.menu.l g() {
        return this.p;
    }

    public Menu getMenu() {
        if (this.p == null) {
            Context context = getContext();
            this.p = new androidx.appcompat.view.menu.l(context);
            this.p.a(new c());
            this.t = new ActionMenuPresenter(context);
            this.t.b(true);
            ActionMenuPresenter actionMenuPresenter = this.t;
            v.a aVar = this.u;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter.a(aVar);
            this.p.a(this.t, this.q);
            this.t.a(this);
        }
        return this.p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.t.c();
    }

    public int getPopupTheme() {
        return this.r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.t;
        return actionMenuPresenter != null && actionMenuPresenter.h();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.t.g()) {
                this.t.d();
                this.t.h();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int i7;
        if (!this.w) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = wa.a(this);
        int i10 = paddingRight;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (d(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i7 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i14 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i14, width, measuredHeight + i14);
                    i10 -= measuredWidth;
                    i11 = 1;
                } else {
                    i10 -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    d(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i9 / 2) - (measuredWidth2 / 2);
            int i16 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        if (i17 > 0) {
            i6 = i10 / i17;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int max = Math.max(i5, i6);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.c) {
                    int i18 = width2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) + max);
                }
                i5++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.c) {
                int i20 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + max;
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.l lVar;
        boolean z = this.w;
        this.w = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.w) {
            this.x = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.w && (lVar = this.p) != null && size != this.x) {
            this.x = size;
            lVar.b(true);
        }
        int childCount = getChildCount();
        if (this.w && childCount > 0) {
            e(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.t.a(z);
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.A = dVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.t.a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.s = z;
    }

    public void setPopupTheme(int i) {
        if (this.r != i) {
            this.r = i;
            if (i == 0) {
                this.q = getContext();
            } else {
                this.q = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.t = actionMenuPresenter;
        this.t.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements l.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean a(androidx.appcompat.view.menu.l lVar, MenuItem menuItem) {
            d dVar = ActionMenuView.this.A;
            return dVar != null && dVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.l lVar) {
            l.a aVar = ActionMenuView.this.v;
            if (aVar != null) {
                aVar.a(lVar);
            }
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.y = (int) (56.0f * f);
        this.z = (int) (f * 4.0f);
        this.q = context;
        this.r = 0;
    }

    protected boolean d(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).needsDividerBefore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f264b = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
            if (layoutParams2.f264b <= 0) {
                layoutParams2.f264b = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.view.menu.l.b
    public boolean a(androidx.appcompat.view.menu.p pVar) {
        return this.p.a(pVar, 0);
    }

    @Override // androidx.appcompat.view.menu.w
    public void a(androidx.appcompat.view.menu.l lVar) {
        this.p = lVar;
    }

    public void a(v.a aVar, l.a aVar2) {
        this.u = aVar;
        this.v = aVar2;
    }

    public void a() {
        ActionMenuPresenter actionMenuPresenter = this.t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
        }
    }

    public boolean e() {
        ActionMenuPresenter actionMenuPresenter = this.t;
        return actionMenuPresenter != null && actionMenuPresenter.g();
    }
}
