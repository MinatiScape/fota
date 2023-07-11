package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
/* compiled from: AppCompatImageHelper.java */
/* renamed from: androidx.appcompat.widget.s  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0059s {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f356a;

    /* renamed from: b  reason: collision with root package name */
    private ga f357b;
    private ga c;
    private ga d;

    public C0059s(ImageView imageView) {
        this.f356a = imageView;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f357b != null : i == 21;
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        ia a2 = ia.a(this.f356a.getContext(), attributeSet, R$styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f356a.getDrawable();
            if (drawable == null && (g = a2.g(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.f356a.getContext(), g)) != null) {
                this.f356a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                E.b(drawable);
            }
            if (a2.g(R$styleable.AppCompatImageView_tint)) {
                androidx.core.widget.g.a(this.f356a, a2.a(R$styleable.AppCompatImageView_tint));
            }
            if (a2.g(R$styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.g.a(this.f356a, E.a(a2.d(R$styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        ga gaVar = this.c;
        if (gaVar != null) {
            return gaVar.f324a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ga gaVar = this.c;
        if (gaVar != null) {
            return gaVar.f325b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f356a.getBackground() instanceof RippleDrawable);
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f356a.getContext(), i);
            if (b2 != null) {
                E.b(b2);
            }
            this.f356a.setImageDrawable(b2);
        } else {
            this.f356a.setImageDrawable(null);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new ga();
        }
        ga gaVar = this.c;
        gaVar.f324a = colorStateList;
        gaVar.d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new ga();
        }
        ga gaVar = this.c;
        gaVar.f325b = mode;
        gaVar.c = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable drawable = this.f356a.getDrawable();
        if (drawable != null) {
            E.b(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            ga gaVar = this.c;
            if (gaVar != null) {
                C0058q.a(drawable, gaVar, this.f356a.getDrawableState());
                return;
            }
            ga gaVar2 = this.f357b;
            if (gaVar2 != null) {
                C0058q.a(drawable, gaVar2, this.f356a.getDrawableState());
            }
        }
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new ga();
        }
        ga gaVar = this.d;
        gaVar.a();
        ColorStateList a2 = androidx.core.widget.g.a(this.f356a);
        if (a2 != null) {
            gaVar.d = true;
            gaVar.f324a = a2;
        }
        PorterDuff.Mode b2 = androidx.core.widget.g.b(this.f356a);
        if (b2 != null) {
            gaVar.c = true;
            gaVar.f325b = b2;
        }
        if (gaVar.d || gaVar.c) {
            C0058q.a(drawable, gaVar, this.f356a.getDrawableState());
            return true;
        }
        return false;
    }
}
