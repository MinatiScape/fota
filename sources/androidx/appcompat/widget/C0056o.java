package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
/* compiled from: AppCompatBackgroundHelper.java */
/* renamed from: androidx.appcompat.widget.o  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0056o {

    /* renamed from: a  reason: collision with root package name */
    private final View f345a;
    private ga d;
    private ga e;
    private ga f;
    private int c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final C0058q f346b = C0058q.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0056o(View view) {
        this.f345a = view;
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        ia a2 = ia.a(this.f345a.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(R$styleable.ViewBackgroundHelper_android_background)) {
                this.c = a2.g(R$styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f346b.b(this.f345a.getContext(), this.c);
                if (b2 != null) {
                    a(b2);
                }
            }
            if (a2.g(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.h.t.a(this.f345a, a2.a(R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.h.t.a(this.f345a, E.a(a2.d(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new ga();
        }
        ga gaVar = this.e;
        gaVar.f324a = colorStateList;
        gaVar.d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ga gaVar = this.e;
        if (gaVar != null) {
            return gaVar.f325b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        ga gaVar = this.e;
        if (gaVar != null) {
            return gaVar.f324a;
        }
        return null;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new ga();
        }
        ga gaVar = this.f;
        gaVar.a();
        ColorStateList c = androidx.core.h.t.c(this.f345a);
        if (c != null) {
            gaVar.d = true;
            gaVar.f324a = c;
        }
        PorterDuff.Mode d = androidx.core.h.t.d(this.f345a);
        if (d != null) {
            gaVar.c = true;
            gaVar.f325b = d;
        }
        if (gaVar.d || gaVar.c) {
            C0058q.a(drawable, gaVar, this.f345a.getDrawableState());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
        C0058q c0058q = this.f346b;
        a(c0058q != null ? c0058q.b(this.f345a.getContext(), i) : null);
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.c = -1;
        a((ColorStateList) null);
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new ga();
        }
        ga gaVar = this.e;
        gaVar.f325b = mode;
        gaVar.c = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable background = this.f345a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            ga gaVar = this.e;
            if (gaVar != null) {
                C0058q.a(background, gaVar, this.f345a.getDrawableState());
                return;
            }
            ga gaVar2 = this.d;
            if (gaVar2 != null) {
                C0058q.a(background, gaVar2, this.f345a.getDrawableState());
            }
        }
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new ga();
            }
            ga gaVar = this.d;
            gaVar.f324a = colorStateList;
            gaVar.d = true;
        } else {
            this.d = null;
        }
        a();
    }
}
