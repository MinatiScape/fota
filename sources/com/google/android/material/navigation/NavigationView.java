package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.d.g;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ia;
import androidx.core.h.D;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.h;
import com.google.android.material.internal.k;
import com.google.android.material.internal.s;
/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] d = {16842912};
    private static final int[] e = {-16842910};
    private final h f;
    private final k g;
    a h;
    private final int i;
    private MenuInflater j;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private ColorStateList c(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            ColorStateList a2 = androidx.appcompat.a.a.a.a(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
                int i2 = typedValue.data;
                int defaultColor = a2.getDefaultColor();
                return new ColorStateList(new int[][]{e, d, FrameLayout.EMPTY_STATE_SET}, new int[]{a2.getColorForState(e, defaultColor), i2, defaultColor});
            }
            return null;
        }
        return null;
    }

    private MenuInflater getMenuInflater() {
        if (this.j == null) {
            this.j = new g(getContext());
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void a(D d2) {
        this.g.a(d2);
    }

    public void b(int i) {
        this.g.a(true);
        getMenuInflater().inflate(i, this.f);
        this.g.a(false);
        this.g.updateMenuView(false);
    }

    public MenuItem getCheckedItem() {
        return this.g.a();
    }

    public int getHeaderCount() {
        return this.g.b();
    }

    public Drawable getItemBackground() {
        return this.g.c();
    }

    public int getItemHorizontalPadding() {
        return this.g.d();
    }

    public int getItemIconPadding() {
        return this.g.e();
    }

    public ColorStateList getItemIconTintList() {
        return this.g.g();
    }

    public ColorStateList getItemTextColor() {
        return this.g.f();
    }

    public Menu getMenu() {
        return this.f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.i), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f.b(savedState.c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = new Bundle();
        this.f.d(savedState.c);
        return savedState;
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f.findItem(i);
        if (findItem != null) {
            this.g.a((p) findItem);
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.g.a(drawable);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(androidx.core.content.a.c(getContext(), i));
    }

    public void setItemHorizontalPadding(int i) {
        this.g.c(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.g.c(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(int i) {
        this.g.d(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.g.d(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.a(colorStateList);
    }

    public void setItemTextAppearance(int i) {
        this.g.e(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.h = aVar;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new b();
        public Bundle c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R$attr.navigationViewStyle);
    }

    public View a(int i) {
        return this.g.a(i);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ColorStateList c;
        boolean z;
        int i2;
        this.g = new k();
        this.f = new h(context);
        ia b2 = s.b(context, attributeSet, R$styleable.NavigationView, i, R$style.Widget_Design_NavigationView, new int[0]);
        t.a(this, b2.b(R$styleable.NavigationView_android_background));
        if (b2.g(R$styleable.NavigationView_elevation)) {
            t.a(this, b2.c(R$styleable.NavigationView_elevation, 0));
        }
        t.a(this, b2.a(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.i = b2.c(R$styleable.NavigationView_android_maxWidth, 0);
        if (b2.g(R$styleable.NavigationView_itemIconTint)) {
            c = b2.a(R$styleable.NavigationView_itemIconTint);
        } else {
            c = c(16842808);
        }
        if (b2.g(R$styleable.NavigationView_itemTextAppearance)) {
            i2 = b2.g(R$styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            i2 = 0;
        }
        ColorStateList a2 = b2.g(R$styleable.NavigationView_itemTextColor) ? b2.a(R$styleable.NavigationView_itemTextColor) : null;
        if (!z && a2 == null) {
            a2 = c(16842806);
        }
        Drawable b3 = b2.b(R$styleable.NavigationView_itemBackground);
        if (b2.g(R$styleable.NavigationView_itemHorizontalPadding)) {
            this.g.c(b2.c(R$styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int c2 = b2.c(R$styleable.NavigationView_itemIconPadding, 0);
        this.f.a(new com.google.android.material.navigation.a(this));
        this.g.b(1);
        this.g.a(context, this.f);
        this.g.a(c);
        if (z) {
            this.g.e(i2);
        }
        this.g.b(a2);
        this.g.a(b3);
        this.g.d(c2);
        this.f.a(this.g);
        addView((View) this.g.a((ViewGroup) this));
        if (b2.g(R$styleable.NavigationView_menu)) {
            b(b2.g(R$styleable.NavigationView_menu, 0));
        }
        if (b2.g(R$styleable.NavigationView_headerLayout)) {
            a(b2.g(R$styleable.NavigationView_headerLayout, 0));
        }
        b2.a();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.g.a((p) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
