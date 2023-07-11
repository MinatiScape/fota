package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.h.t;
import androidx.core.widget.l;
import androidx.legacy.widget.Space;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndicatorViewController.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1433a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f1434b;
    private LinearLayout c;
    private int d;
    private FrameLayout e;
    private int f;
    private Animator g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private CharSequence o;
    private boolean p;
    private TextView q;
    private int r;
    private Typeface s;

    public c(TextInputLayout textInputLayout) {
        this.f1433a = textInputLayout.getContext();
        this.f1434b = textInputLayout;
        this.h = this.f1433a.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    private TextView d(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return this.q;
        }
        return this.m;
    }

    private boolean e(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    private boolean m() {
        return (this.c == null || this.f1434b.getEditText() == null) ? false : true;
    }

    boolean a(int i) {
        return i == 0 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        b();
        this.o = charSequence;
        this.q.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        a(this.i, this.j, a(this.q, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return e(this.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence g() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        TextView textView = this.q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.k = null;
        b();
        if (this.i == 1) {
            if (this.p && !TextUtils.isEmpty(this.o)) {
                this.j = 2;
            } else {
                this.j = 0;
            }
        }
        a(this.i, this.j, a(this.m, (CharSequence) null));
    }

    void j() {
        b();
        if (this.i == 2) {
            this.j = 0;
        }
        a(this.i, this.j, a(this.q, (CharSequence) null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.r = i;
        TextView textView = this.q;
        if (textView != null) {
            l.d(textView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        b();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        a(this.i, this.j, a(this.m, charSequence));
    }

    void b() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.c == null) {
            return;
        }
        if (a(i) && (frameLayout = this.e) != null) {
            this.f--;
            a(frameLayout, this.f);
            this.e.removeView(textView);
        } else {
            this.c.removeView(textView);
        }
        this.d--;
        a(this.c, this.d);
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return t.z(this.f1434b) && this.f1434b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(int i, int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.p, this.q, 2, i, i2);
            a(arrayList, this.l, this.m, 1, i, i2);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            animatorSet.addListener(new b(this, i2, d(i), i, d(i2)));
            animatorSet.start();
        } else {
            a(i, i2);
        }
        this.f1434b.c();
        this.f1434b.b(z);
        this.f1434b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        if (this.p == z) {
            return;
        }
        b();
        if (z) {
            this.q = new AppCompatTextView(this.f1433a);
            this.q.setId(R$id.textinput_helper_text);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.q.setTypeface(typeface);
            }
            this.q.setVisibility(4);
            t.c(this.q, 1);
            c(this.r);
            a(this.q, 1);
        } else {
            j();
            b(this.q, 1);
            this.q = null;
            this.f1434b.c();
            this.f1434b.d();
        }
        this.p = z;
    }

    private void a(int i, int i2) {
        TextView d;
        TextView d2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (d2 = d(i2)) != null) {
            d2.setVisibility(0);
            d2.setAlpha(1.0f);
        }
        if (i != 0 && (d = d(i)) != null) {
            d.setVisibility(4);
            if (i == 1) {
                d.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.n = i;
        TextView textView = this.m;
        if (textView != null) {
            this.f1434b.a(textView, i);
        }
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(a(textView, i3 == i));
            if (i3 == i) {
                list.add(a(textView));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(com.google.android.material.a.a.f1232a);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(com.google.android.material.a.a.d);
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (m()) {
            t.b(this.c, t.o(this.f1434b.getEditText()), 0, t.n(this.f1434b.getEditText()), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TextView textView, int i) {
        if (this.c == null && this.e == null) {
            this.c = new LinearLayout(this.f1433a);
            this.c.setOrientation(0);
            this.f1434b.addView(this.c, -1, -2);
            this.e = new FrameLayout(this.f1433a);
            this.c.addView(this.e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.c.addView(new Space(this.f1433a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f1434b.getEditText() != null) {
                a();
            }
        }
        if (a(i)) {
            this.e.setVisibility(0);
            this.e.addView(textView);
            this.f++;
        } else {
            this.c.addView(textView, i);
        }
        this.c.setVisibility(0);
        this.d++;
    }

    private void a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.l == z) {
            return;
        }
        b();
        if (z) {
            this.m = new AppCompatTextView(this.f1433a);
            this.m.setId(R$id.textinput_error);
            Typeface typeface = this.s;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            b(this.n);
            this.m.setVisibility(4);
            t.c(this.m, 1);
            a(this.m, 0);
        } else {
            i();
            b(this.m, 0);
            this.m = null;
            this.f1434b.c();
            this.f1434b.d();
        }
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            a(this.m, typeface);
            a(this.q, typeface);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
