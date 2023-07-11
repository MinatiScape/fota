package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, c, androidx.core.graphics.drawable.b {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    private int f507a;

    /* renamed from: b  reason: collision with root package name */
    private PorterDuff.Mode f508b;
    private boolean c;
    a d;
    private boolean e;
    Drawable f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: WrappedDrawableApi14.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f509a;

        /* renamed from: b  reason: collision with root package name */
        Drawable.ConstantState f510b;
        ColorStateList c;
        PorterDuff.Mode d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, Resources resources) {
            this.c = null;
            this.d = d.DEFAULT_TINT_MODE;
            if (aVar != null) {
                this.f509a = aVar.f509a;
                this.f510b = aVar.f510b;
                this.c = aVar.c;
                this.d = aVar.d;
            }
        }

        boolean a() {
            return this.f510b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.f509a;
            Drawable.ConstantState constantState = this.f510b;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WrappedDrawableApi14.java */
    /* loaded from: classes.dex */
    public static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // androidx.core.graphics.drawable.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Resources resources) {
        this.d = aVar;
        a(resources);
    }

    private void a(Resources resources) {
        Drawable.ConstantState constantState;
        a aVar = this.d;
        if (aVar == null || (constantState = aVar.f510b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    protected boolean b() {
        return true;
    }

    a c() {
        return new b(this.d, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        a aVar = this.d;
        return changingConfigurations | (aVar != null ? aVar.getChangingConfigurations() : 0) | this.f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        a aVar = this.d;
        if (aVar == null || !aVar.a()) {
            return null;
        }
        this.d.f509a = getChangingConfigurations();
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        a aVar;
        ColorStateList colorStateList = (!b() || (aVar = this.d) == null) ? null : aVar.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.d = c();
            Drawable drawable = this.f;
            if (drawable != null) {
                drawable.mutate();
            }
            a aVar = this.d;
            if (aVar != null) {
                Drawable drawable2 = this.f;
                aVar.f510b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.d.c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.d.d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    private boolean a(int[] iArr) {
        if (b()) {
            a aVar = this.d;
            ColorStateList colorStateList = aVar.c;
            PorterDuff.Mode mode = aVar.d;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.c || colorForState != this.f507a || mode != this.f508b) {
                    setColorFilter(colorForState, mode);
                    this.f507a = colorForState;
                    this.f508b = mode;
                    this.c = true;
                    return true;
                }
            } else {
                this.c = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Drawable drawable) {
        this.d = c();
        a(drawable);
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable a() {
        return this.f;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            a aVar = this.d;
            if (aVar != null) {
                aVar.f510b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
