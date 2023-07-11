package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements androidx.core.h.r, androidx.core.widget.n {

    /* renamed from: a  reason: collision with root package name */
    private final C0056o f225a;

    /* renamed from: b  reason: collision with root package name */
    private final C0059s f226b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0056o c0056o = this.f225a;
        if (c0056o != null) {
            c0056o.a();
        }
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            c0059s.a();
        }
    }

    @Override // androidx.core.h.r
    public ColorStateList getSupportBackgroundTintList() {
        C0056o c0056o = this.f225a;
        if (c0056o != null) {
            return c0056o.b();
        }
        return null;
    }

    @Override // androidx.core.h.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0056o c0056o = this.f225a;
        if (c0056o != null) {
            return c0056o.c();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public ColorStateList getSupportImageTintList() {
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            return c0059s.b();
        }
        return null;
    }

    @Override // androidx.core.widget.n
    public PorterDuff.Mode getSupportImageTintMode() {
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            return c0059s.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f226b.d() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0056o c0056o = this.f225a;
        if (c0056o != null) {
            c0056o.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0056o c0056o = this.f225a;
        if (c0056o != null) {
            c0056o.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            c0059s.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            c0059s.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            c0059s.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            c0059s.a();
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0056o c0056o = this.f225a;
        if (c0056o != null) {
            c0056o.b(colorStateList);
        }
    }

    @Override // androidx.core.h.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0056o c0056o = this.f225a;
        if (c0056o != null) {
            c0056o.a(mode);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            c0059s.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0059s c0059s = this.f226b;
        if (c0059s != null) {
            c0059s.a(mode);
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f225a = new C0056o(this);
        this.f225a.a(attributeSet, i);
        this.f226b = new C0059s(this);
        this.f226b.a(attributeSet, i);
    }
}
