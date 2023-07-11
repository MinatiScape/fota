package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
/* compiled from: AppCompatSeekBarHelper.java */
/* renamed from: androidx.appcompat.widget.u  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0061u extends C0060t {
    private final SeekBar d;
    private Drawable e;
    private ColorStateList f;
    private PorterDuff.Mode g;
    private boolean h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0061u(SeekBar seekBar) {
        super(seekBar);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = seekBar;
    }

    private void d() {
        if (this.e != null) {
            if (this.h || this.i) {
                this.e = androidx.core.graphics.drawable.a.i(this.e.mutate());
                if (this.h) {
                    androidx.core.graphics.drawable.a.a(this.e, this.f);
                }
                if (this.i) {
                    androidx.core.graphics.drawable.a.a(this.e, this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.C0060t
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ia a2 = ia.a(this.d.getContext(), attributeSet, R$styleable.AppCompatSeekBar, i, 0);
        Drawable c = a2.c(R$styleable.AppCompatSeekBar_android_thumb);
        if (c != null) {
            this.d.setThumb(c);
        }
        a(a2.b(R$styleable.AppCompatSeekBar_tickMark));
        if (a2.g(R$styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = E.a(a2.d(R$styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (a2.g(R$styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f = a2.a(R$styleable.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        a2.a();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void a(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.d);
            androidx.core.graphics.drawable.a.a(drawable, androidx.core.h.t.k(this.d));
            if (drawable.isStateful()) {
                drawable.setState(this.d.getDrawableState());
            }
            d();
        }
        this.d.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.e != null) {
            int max = this.d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i, -i2, i, i2);
                float width = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
