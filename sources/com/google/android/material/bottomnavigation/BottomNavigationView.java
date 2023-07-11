package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.d.g;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ia;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
/* loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final l f1293a;

    /* renamed from: b  reason: collision with root package name */
    private final BottomNavigationMenuView f1294b;
    private final BottomNavigationPresenter c;
    private MenuInflater d;
    private b e;
    private a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new e();
        Bundle c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(MenuItem menuItem);
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.d == null) {
            this.d = new g(getContext());
        }
        return this.d;
    }

    public Drawable getItemBackground() {
        return this.f1294b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f1294b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f1294b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f1294b.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.f1294b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f1294b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f1294b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f1294b.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.f1293a;
    }

    public int getSelectedItemId() {
        return this.f1294b.getSelectedItemId();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f1293a.b(savedState.c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = new Bundle();
        this.f1293a.d(savedState.c);
        return savedState;
    }

    public void setItemBackground(Drawable drawable) {
        this.f1294b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.f1294b.setItemBackgroundRes(i);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f1294b.b() != z) {
            this.f1294b.setItemHorizontalTranslationEnabled(z);
            this.c.updateMenuView(false);
        }
    }

    public void setItemIconSize(int i) {
        this.f1294b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f1294b.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.f1294b.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f1294b.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f1294b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f1294b.getLabelVisibilityMode() != i) {
            this.f1294b.setLabelVisibilityMode(i);
            this.c.updateMenuView(false);
        }
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.f = aVar;
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.e = bVar;
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.f1293a.findItem(i);
        if (findItem == null || this.f1293a.a(findItem, this.c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    public void a(int i) {
        this.c.a(true);
        getMenuInflater().inflate(i, this.f1293a);
        this.c.a(false);
        this.c.updateMenuView(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new BottomNavigationPresenter();
        this.f1293a = new com.google.android.material.bottomnavigation.a(context);
        this.f1294b = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f1294b.setLayoutParams(layoutParams);
        this.c.a(this.f1294b);
        this.c.a(1);
        this.f1294b.setPresenter(this.c);
        this.f1293a.a(this.c);
        this.c.a(getContext(), this.f1293a);
        ia b2 = s.b(context, attributeSet, R$styleable.BottomNavigationView, i, R$style.Widget_Design_BottomNavigationView, R$styleable.BottomNavigationView_itemTextAppearanceInactive, R$styleable.BottomNavigationView_itemTextAppearanceActive);
        if (b2.g(R$styleable.BottomNavigationView_itemIconTint)) {
            this.f1294b.setIconTintList(b2.a(R$styleable.BottomNavigationView_itemIconTint));
        } else {
            BottomNavigationMenuView bottomNavigationMenuView = this.f1294b;
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.a(16842808));
        }
        setItemIconSize(b2.c(R$styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_icon_size)));
        if (b2.g(R$styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(b2.g(R$styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (b2.g(R$styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(b2.g(R$styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (b2.g(R$styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(b2.a(R$styleable.BottomNavigationView_itemTextColor));
        }
        if (b2.g(R$styleable.BottomNavigationView_elevation)) {
            t.a(this, b2.c(R$styleable.BottomNavigationView_elevation, 0));
        }
        setLabelVisibilityMode(b2.e(R$styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(b2.a(R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        this.f1294b.setItemBackgroundRes(b2.g(R$styleable.BottomNavigationView_itemBackground, 0));
        if (b2.g(R$styleable.BottomNavigationView_menu)) {
            a(b2.g(R$styleable.BottomNavigationView_menu, 0));
        }
        b2.a();
        addView(this.f1294b, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            a(context);
        }
        this.f1293a.a(new d(this));
    }

    private void a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.a.a(context, R$color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }
}
