package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.h.t;
import androidx.core.widget.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton {
    private final b c;
    private int d;
    private PorterDuff.Mode e;
    private ColorStateList f;
    private Drawable g;
    private int h;
    private int i;
    private int j;

    public MaterialButton(Context context) {
        this(context, null);
    }

    private boolean a() {
        return t.k(this) == 1;
    }

    private boolean b() {
        b bVar = this.c;
        return (bVar == null || bVar.g()) ? false : true;
    }

    private void c() {
        Drawable drawable = this.g;
        if (drawable != null) {
            this.g = drawable.mutate();
            androidx.core.graphics.drawable.a.a(this.g, this.f);
            PorterDuff.Mode mode = this.e;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.g, mode);
            }
            int i = this.h;
            if (i == 0) {
                i = this.g.getIntrinsicWidth();
            }
            int i2 = this.h;
            if (i2 == 0) {
                i2 = this.g.getIntrinsicHeight();
            }
            Drawable drawable2 = this.g;
            int i3 = this.i;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        l.a(this, this.g, null, null, null);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.c.a();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.g;
    }

    public int getIconGravity() {
        return this.j;
    }

    public int getIconPadding() {
        return this.d;
    }

    public int getIconSize() {
        return this.h;
    }

    public ColorStateList getIconTint() {
        return this.f;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.e;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.c.b();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.c.c();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.c.d();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.r
    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.c.e();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.c.f();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !b()) {
            return;
        }
        this.c.a(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (bVar = this.c) == null) {
            return;
        }
        bVar.a(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g == null || this.j != 2) {
            return;
        }
        int measureText = (int) getPaint().measureText(getText().toString());
        int i3 = this.h;
        if (i3 == 0) {
            i3 = this.g.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - measureText) - t.n(this)) - i3) - this.d) - t.o(this)) / 2;
        if (a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.i != measuredWidth) {
            this.i = measuredWidth;
            c();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (b()) {
            this.c.a(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (b()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.c.h();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i) {
        if (b()) {
            this.c.b(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.g != drawable) {
            this.g = drawable;
            c();
        }
    }

    public void setIconGravity(int i) {
        this.j = i;
    }

    public void setIconPadding(int i) {
        if (this.d != i) {
            this.d = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            if (this.h != i) {
                this.h = i;
                c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f != colorStateList) {
            this.f = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            c();
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(androidx.appcompat.a.a.a.a(getContext(), i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.c.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (b()) {
            setRippleColor(androidx.appcompat.a.a.a.a(getContext(), i));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.c.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (b()) {
            setStrokeColor(androidx.appcompat.a.a.a.a(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (b()) {
            this.c.c(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.c.c(colorStateList);
        } else if (this.c != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.h.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.c.a(mode);
        } else if (this.c != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray a2 = s.a(context, attributeSet, R$styleable.MaterialButton, i, R$style.Widget_MaterialComponents_Button, new int[0]);
        this.d = a2.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.e = com.google.android.material.internal.t.a(a2.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f = com.google.android.material.f.a.a(getContext(), a2, R$styleable.MaterialButton_iconTint);
        this.g = com.google.android.material.f.a.b(getContext(), a2, R$styleable.MaterialButton_icon);
        this.j = a2.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.h = a2.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        this.c = new b(this);
        this.c.a(a2);
        a2.recycle();
        setCompoundDrawablePadding(this.d);
        c();
    }
}
