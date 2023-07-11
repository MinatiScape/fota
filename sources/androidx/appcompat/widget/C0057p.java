package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
/* compiled from: AppCompatCompoundButtonHelper.java */
/* renamed from: androidx.appcompat.widget.p  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0057p {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f349a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f350b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0057p(CompoundButton compoundButton) {
        this.f349a = compoundButton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f349a.getContext().obtainStyledAttributes(attributeSet, R$styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R$styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R$styleable.CompoundButton_android_button, 0)) != 0) {
                this.f349a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f349a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.CompoundButton_buttonTint)) {
                androidx.core.widget.c.a(this.f349a, obtainStyledAttributes.getColorStateList(R$styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.CompoundButton_buttonTintMode)) {
                androidx.core.widget.c.a(this.f349a, E.a(obtainStyledAttributes.getInt(R$styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f350b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.f350b = colorStateList;
        this.d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }

    void a() {
        Drawable a2 = androidx.core.widget.c.a(this.f349a);
        if (a2 != null) {
            if (this.d || this.e) {
                Drawable mutate = androidx.core.graphics.drawable.a.i(a2).mutate();
                if (this.d) {
                    androidx.core.graphics.drawable.a.a(mutate, this.f350b);
                }
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(mutate, this.c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f349a.getDrawableState());
                }
                this.f349a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || (a2 = androidx.core.widget.c.a(this.f349a)) == null) ? i : i + a2.getIntrinsicWidth();
    }
}
