package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.qa;
import androidx.core.h.t;
import androidx.core.widget.l;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
/* loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements w.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1286a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private final int f1287b;
    private float c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private ImageView h;
    private final TextView i;
    private final TextView j;
    private int k;
    private p l;
    private ColorStateList m;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.view.menu.w.a
    public void a(p pVar, int i) {
        this.l = pVar;
        setCheckable(pVar.isCheckable());
        setChecked(pVar.isChecked());
        setEnabled(pVar.isEnabled());
        setIcon(pVar.getIcon());
        setTitle(pVar.getTitle());
        setId(pVar.getItemId());
        if (!TextUtils.isEmpty(pVar.d())) {
            setContentDescription(pVar.d());
        }
        qa.a(this, pVar.i());
        setVisibility(pVar.isVisible() ? 0 : 8);
    }

    @Override // androidx.appcompat.view.menu.w.a
    public p getItemData() {
        return this.l;
    }

    public int getItemPosition() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        p pVar = this.l;
        if (pVar != null && pVar.isCheckable() && this.l.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f1286a);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.w.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.j;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.j;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.i;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.i;
        textView4.setPivotY(textView4.getBaseline());
        int i = this.f;
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    a(this.h, this.f1287b, 49);
                    a(this.j, 1.0f, 1.0f, 0);
                } else {
                    a(this.h, this.f1287b, 17);
                    a(this.j, 0.5f, 0.5f, 4);
                }
                this.i.setVisibility(4);
            } else if (i != 1) {
                if (i == 2) {
                    a(this.h, this.f1287b, 17);
                    this.j.setVisibility(8);
                    this.i.setVisibility(8);
                }
            } else if (z) {
                a(this.h, (int) (this.f1287b + this.c), 49);
                a(this.j, 1.0f, 1.0f, 0);
                TextView textView5 = this.i;
                float f = this.d;
                a(textView5, f, f, 4);
            } else {
                a(this.h, this.f1287b, 49);
                TextView textView6 = this.j;
                float f2 = this.e;
                a(textView6, f2, f2, 4);
                a(this.i, 1.0f, 1.0f, 0);
            }
        } else if (this.g) {
            if (z) {
                a(this.h, this.f1287b, 49);
                a(this.j, 1.0f, 1.0f, 0);
            } else {
                a(this.h, this.f1287b, 17);
                a(this.j, 0.5f, 0.5f, 4);
            }
            this.i.setVisibility(4);
        } else if (z) {
            a(this.h, (int) (this.f1287b + this.c), 49);
            a(this.j, 1.0f, 1.0f, 0);
            TextView textView7 = this.i;
            float f3 = this.d;
            a(textView7, f3, f3, 4);
        } else {
            a(this.h, this.f1287b, 49);
            TextView textView8 = this.j;
            float f4 = this.e;
            a(textView8, f4, f4, 4);
            a(this.i, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.i.setEnabled(z);
        this.j.setEnabled(z);
        this.h.setEnabled(z);
        if (z) {
            t.a(this, androidx.core.h.p.a(getContext(), 1002));
        } else {
            t.a(this, (androidx.core.h.p) null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, this.m);
        }
        this.h.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.h.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.m = colorStateList;
        p pVar = this.l;
        if (pVar != null) {
            setIcon(pVar.getIcon());
        }
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : androidx.core.content.a.c(getContext(), i));
    }

    public void setItemPosition(int i) {
        this.k = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f != i) {
            this.f = i;
            if (this.l != null) {
                setChecked(this.l.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.g != z) {
            this.g = z;
            if (this.l != null) {
                setChecked(this.l.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i) {
        l.d(this.j, i);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextAppearanceInactive(int i) {
        l.d(this.i, i);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.i.setTextColor(colorStateList);
            this.j.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.i.setText(charSequence);
        this.j.setText(charSequence);
        p pVar = this.l;
        if (pVar == null || TextUtils.isEmpty(pVar.d())) {
            setContentDescription(charSequence);
        }
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R$layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(R$drawable.design_bottom_navigation_item_background);
        this.f1287b = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_margin);
        this.h = (ImageView) findViewById(R$id.icon);
        this.i = (TextView) findViewById(R$id.smallLabel);
        this.j = (TextView) findViewById(R$id.largeLabel);
        t.d(this.i, 2);
        t.d(this.j, 2);
        setFocusable(true);
        a(this.i.getTextSize(), this.j.getTextSize());
    }

    public void setItemBackground(Drawable drawable) {
        t.a(this, drawable);
    }

    private void a(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void a(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private void a(float f, float f2) {
        this.c = f - f2;
        this.d = (f2 * 1.0f) / f;
        this.e = (f * 1.0f) / f2;
    }
}
