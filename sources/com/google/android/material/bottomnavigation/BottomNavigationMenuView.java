package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.w;
import androidx.core.g.g;
import androidx.core.h.t;
import androidx.transition.AutoTransition;
import androidx.transition.C0106ca;
import androidx.transition.TransitionSet;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.r;
/* loaded from: classes.dex */
public class BottomNavigationMenuView extends ViewGroup implements w {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1288a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1289b = {-16842910};
    private final TransitionSet c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final View.OnClickListener i;
    private final androidx.core.g.e<BottomNavigationItemView> j;
    private boolean k;
    private int l;
    private BottomNavigationItemView[] m;
    private int n;
    private int o;
    private ColorStateList p;
    private int q;
    private ColorStateList r;
    private final ColorStateList s;
    private int t;
    private int u;
    private Drawable v;
    private int w;
    private int[] x;
    private BottomNavigationPresenter y;
    private l z;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private boolean a(int i, int i2) {
        if (i == -1) {
            if (i2 > 3) {
                return true;
            }
        } else if (i == 0) {
            return true;
        }
        return false;
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.j.acquire();
        return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
    }

    public void c() {
        l lVar = this.z;
        if (lVar == null || this.m == null) {
            return;
        }
        int size = lVar.size();
        if (size != this.m.length) {
            a();
            return;
        }
        int i = this.n;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.z.getItem(i2);
            if (item.isChecked()) {
                this.n = item.getItemId();
                this.o = i2;
            }
        }
        if (i != this.n) {
            C0106ca.a(this, this.c);
        }
        boolean a2 = a(this.l, this.z.n().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.y.a(true);
            this.m[i3].setLabelVisibilityMode(this.l);
            this.m[i3].setShifting(a2);
            this.m[i3].a((p) this.z.getItem(i3), 0);
            this.y.a(false);
        }
    }

    public ColorStateList getIconTintList() {
        return this.p;
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null && bottomNavigationItemViewArr.length > 0) {
            return bottomNavigationItemViewArr[0].getBackground();
        }
        return this.v;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.w;
    }

    public int getItemIconSize() {
        return this.q;
    }

    public int getItemTextAppearanceActive() {
        return this.u;
    }

    public int getItemTextAppearanceInactive() {
        return this.t;
    }

    public ColorStateList getItemTextColor() {
        return this.r;
    }

    public int getLabelVisibilityMode() {
        return this.l;
    }

    public int getSelectedItemId() {
        return this.n;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (t.k(this) == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.z.n().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (a(this.l, size2) && this.k) {
            View childAt = getChildAt(this.o);
            int i3 = this.g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f, Integer.MIN_VALUE), makeMeasureSpec);
                i3 = Math.max(i3, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.e * i4), Math.min(i3, this.f));
            int i5 = size - min;
            int min2 = Math.min(i5 / (i4 == 0 ? 1 : i4), this.d);
            int i6 = i5 - (i4 * min2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    this.x[i7] = i7 == this.o ? min : min2;
                    if (i6 > 0) {
                        int[] iArr = this.x;
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.x[i7] = 0;
                }
                i7++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f);
            int i8 = size - (size2 * min3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    int[] iArr2 = this.x;
                    iArr2[i9] = min3;
                    if (i8 > 0) {
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.x[i9] = 0;
                }
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.x[i11], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i10 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), View.resolveSizeAndState(this.h, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.v = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.w = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.k = z;
    }

    public void setItemIconSize(int i) {
        this.q = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i);
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.u = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.t = i;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.r = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.l = i;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.y = bottomNavigationPresenter;
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new g(5);
        this.n = 0;
        this.o = 0;
        Resources resources = getResources();
        this.d = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.e = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.f = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.g = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.h = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_height);
        this.s = a(16842808);
        this.c = new AutoTransition();
        this.c.b(0);
        this.c.a(115L);
        this.c.a((TimeInterpolator) new a.d.a.a.b());
        this.c.a(new r());
        this.i = new b(this);
        this.x = new int[5];
    }

    @Override // androidx.appcompat.view.menu.w
    public void a(l lVar) {
        this.z = lVar;
    }

    public boolean b() {
        return this.k;
    }

    public ColorStateList a(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            ColorStateList a2 = androidx.appcompat.a.a.a.a(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
                int i2 = typedValue.data;
                int defaultColor = a2.getDefaultColor();
                return new ColorStateList(new int[][]{f1289b, f1288a, ViewGroup.EMPTY_STATE_SET}, new int[]{a2.getColorForState(f1289b, defaultColor), i2, defaultColor});
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.z.getItem(i2);
            if (i == item.getItemId()) {
                this.n = i;
                this.o = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    public void a() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.j.release(bottomNavigationItemView);
                }
            }
        }
        if (this.z.size() == 0) {
            this.n = 0;
            this.o = 0;
            this.m = null;
            return;
        }
        this.m = new BottomNavigationItemView[this.z.size()];
        boolean a2 = a(this.l, this.z.n().size());
        for (int i = 0; i < this.z.size(); i++) {
            this.y.a(true);
            this.z.getItem(i).setCheckable(true);
            this.y.a(false);
            BottomNavigationItemView newItem = getNewItem();
            this.m[i] = newItem;
            newItem.setIconTintList(this.p);
            newItem.setIconSize(this.q);
            newItem.setTextColor(this.s);
            newItem.setTextAppearanceInactive(this.t);
            newItem.setTextAppearanceActive(this.u);
            newItem.setTextColor(this.r);
            Drawable drawable = this.v;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.w);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.l);
            newItem.a((p) this.z.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.i);
            addView(newItem);
        }
        this.o = Math.min(this.z.size() - 1, this.o);
        this.z.getItem(this.o).setChecked(true);
    }
}
