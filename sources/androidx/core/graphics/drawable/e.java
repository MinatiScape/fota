package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.d;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WrappedDrawableApi21.java */
/* loaded from: classes.dex */
public class e extends d {
    private static Method g;

    /* compiled from: WrappedDrawableApi21.java */
    /* loaded from: classes.dex */
    private static class a extends d.a {
        a(d.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // androidx.core.graphics.drawable.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Drawable drawable) {
        super(drawable);
        d();
    }

    private void d() {
        if (g == null) {
            try {
                g = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // androidx.core.graphics.drawable.d
    protected boolean b() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.f;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.d
    d.a c() {
        return new a(this.d, null);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f;
        if (drawable != null && (method = g) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.f.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        if (b()) {
            super.setTint(i);
        } else {
            this.f.setTint(i);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.f.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.f.setTintMode(mode);
        }
    }

    e(d.a aVar, Resources resources) {
        super(aVar, resources);
        d();
    }
}
