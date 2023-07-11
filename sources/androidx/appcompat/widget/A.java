package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;
/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
class A {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f196a;

    /* renamed from: b  reason: collision with root package name */
    private ga f197b;
    private ga c;
    private ga d;
    private ga e;
    private ga f;
    private ga g;
    private final B h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(TextView textView) {
        this.f196a = textView;
        this.h = new B(this.f196a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.f196a.getContext();
        C0058q a2 = C0058q.a();
        ia a3 = ia.a(context, attributeSet, R$styleable.AppCompatTextHelper, i, 0);
        int g = a3.g(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f197b = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a3.g(R$styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a3.g(R$styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a3.a();
        boolean z3 = this.f196a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (g != -1) {
            ia a4 = ia.a(context, g, R$styleable.TextAppearance);
            if (z3 || !a4.g(R$styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a4.a(R$styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a4);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList a5 = a4.g(R$styleable.TextAppearance_android_textColor) ? a4.a(R$styleable.TextAppearance_android_textColor) : null;
                colorStateList2 = a4.g(R$styleable.TextAppearance_android_textColorHint) ? a4.a(R$styleable.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList3 = a5;
                colorStateList = a4.g(R$styleable.TextAppearance_android_textColorLink) ? a4.a(R$styleable.TextAppearance_android_textColorLink) : null;
                r10 = colorStateList3;
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            a4.a();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        ia a6 = ia.a(context, attributeSet, R$styleable.TextAppearance, i, 0);
        if (z3 || !a6.g(R$styleable.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = a6.a(R$styleable.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a6.g(R$styleable.TextAppearance_android_textColor)) {
                r10 = a6.a(R$styleable.TextAppearance_android_textColor);
            }
            if (a6.g(R$styleable.TextAppearance_android_textColorHint)) {
                colorStateList2 = a6.a(R$styleable.TextAppearance_android_textColorHint);
            }
            if (a6.g(R$styleable.TextAppearance_android_textColorLink)) {
                colorStateList = a6.a(R$styleable.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && a6.g(R$styleable.TextAppearance_android_textSize) && a6.c(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f196a.setTextSize(0, 0.0f);
        }
        a(context, a6);
        a6.a();
        if (r10 != null) {
            this.f196a.setTextColor(r10);
        }
        if (colorStateList2 != null) {
            this.f196a.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.f196a.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            a(z2);
        }
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f196a.setTypeface(typeface, this.i);
        }
        this.h.a(attributeSet, i);
        if (androidx.core.widget.b.f559a && this.h.f() != 0) {
            int[] e = this.h.e();
            if (e.length > 0) {
                if (this.f196a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f196a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.b(), this.h.d(), 0);
                } else {
                    this.f196a.setAutoSizeTextTypeUniformWithPresetSizes(e, 0);
                }
            }
        }
        ia a7 = ia.a(context, attributeSet, R$styleable.AppCompatTextView);
        int c = a7.c(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int c2 = a7.c(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int c3 = a7.c(R$styleable.AppCompatTextView_lineHeight, -1);
        a7.a();
        if (c != -1) {
            androidx.core.widget.l.a(this.f196a, c);
        }
        if (c2 != -1) {
            androidx.core.widget.l.b(this.f196a, c2);
        }
        if (c3 != -1) {
            androidx.core.widget.l.c(this.f196a, c3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.h.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.h.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] f() {
        return this.h.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.h.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.h.g();
    }

    private void b(int i, float f) {
        this.h.a(i, f);
    }

    private void a(Context context, ia iaVar) {
        String d;
        this.i = iaVar.d(R$styleable.TextAppearance_android_textStyle, this.i);
        if (!iaVar.g(R$styleable.TextAppearance_android_fontFamily) && !iaVar.g(R$styleable.TextAppearance_fontFamily)) {
            if (iaVar.g(R$styleable.TextAppearance_android_typeface)) {
                this.k = false;
                int d2 = iaVar.d(R$styleable.TextAppearance_android_typeface, 1);
                if (d2 == 1) {
                    this.j = Typeface.SANS_SERIF;
                    return;
                } else if (d2 == 2) {
                    this.j = Typeface.SERIF;
                    return;
                } else if (d2 != 3) {
                    return;
                } else {
                    this.j = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.j = null;
        int i = iaVar.g(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
        if (!context.isRestricted()) {
            try {
                this.j = iaVar.a(i, this.i, new C0066z(this, new WeakReference(this.f196a)));
                this.k = this.j == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.j != null || (d = iaVar.d(i)) == null) {
            return;
        }
        this.j = Typeface.create(d, this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        ColorStateList a2;
        ia a3 = ia.a(context, i, R$styleable.TextAppearance);
        if (a3.g(R$styleable.TextAppearance_textAllCaps)) {
            a(a3.a(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a3.g(R$styleable.TextAppearance_android_textColor) && (a2 = a3.a(R$styleable.TextAppearance_android_textColor)) != null) {
            this.f196a.setTextColor(a2);
        }
        if (a3.g(R$styleable.TextAppearance_android_textSize) && a3.c(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f196a.setTextSize(0, 0.0f);
        }
        a(context, a3);
        a3.a();
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f196a.setTypeface(typeface, this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f196a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f197b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.f196a.getCompoundDrawables();
            a(compoundDrawables[0], this.f197b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f196a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, ga gaVar) {
        if (drawable == null || gaVar == null) {
            return;
        }
        C0058q.a(drawable, gaVar, this.f196a.getDrawableState());
    }

    private static ga a(Context context, C0058q c0058q, int i) {
        ColorStateList b2 = c0058q.b(context, i);
        if (b2 != null) {
            ga gaVar = new ga();
            gaVar.d = true;
            gaVar.f324a = b2;
            return gaVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.f559a) {
            return;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        if (androidx.core.widget.b.f559a || h()) {
            return;
        }
        b(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h.a(i);
    }
}
