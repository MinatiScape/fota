package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements androidx.core.widget.m {

    /* renamed from: a  reason: collision with root package name */
    private final C0057p f230a;

    /* renamed from: b  reason: collision with root package name */
    private final A f231b;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0057p c0057p = this.f230a;
        return c0057p != null ? c0057p.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        C0057p c0057p = this.f230a;
        if (c0057p != null) {
            return c0057p.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0057p c0057p = this.f230a;
        if (c0057p != null) {
            return c0057p.c();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0057p c0057p = this.f230a;
        if (c0057p != null) {
            c0057p.d();
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0057p c0057p = this.f230a;
        if (c0057p != null) {
            c0057p.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0057p c0057p = this.f230a;
        if (c0057p != null) {
            c0057p.a(mode);
        }
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f230a = new C0057p(this);
        this.f230a.a(attributeSet, i);
        this.f231b = new A(this);
        this.f231b.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }
}
