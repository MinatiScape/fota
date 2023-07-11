package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.internal.VisibilityAwareImageButton;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImplLollipop.java */
/* loaded from: classes.dex */
public class f extends e {
    private InsetDrawable I;

    /* compiled from: FloatingActionButtonImplLollipop.java */
    /* loaded from: classes.dex */
    static class a extends GradientDrawable {
        a() {
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(VisibilityAwareImageButton visibilityAwareImageButton, com.google.android.material.h.b bVar) {
        super(visibilityAwareImageButton, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.e
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        this.q = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a(this.q, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.q, mode);
        }
        if (i > 0) {
            this.s = a(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.s, this.q});
        } else {
            this.s = null;
            drawable = this.q;
        }
        this.r = new RippleDrawable(com.google.android.material.g.a.a(colorStateList2), drawable, null);
        Drawable drawable2 = this.r;
        this.t = drawable2;
        this.C.setBackgroundDrawable(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.e
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(com.google.android.material.g.a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public float c() {
        return this.B.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.e
    public void j() {
    }

    @Override // com.google.android.material.floatingactionbutton.e
    com.google.android.material.internal.c k() {
        return new com.google.android.material.internal.d();
    }

    @Override // com.google.android.material.floatingactionbutton.e
    GradientDrawable l() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.e
    public void n() {
        s();
    }

    @Override // com.google.android.material.floatingactionbutton.e
    boolean q() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.e
    void b(Rect rect) {
        if (this.C.a()) {
            this.I = new InsetDrawable(this.r, rect.left, rect.top, rect.right, rect.bottom);
            this.C.setBackgroundDrawable(this.I);
            return;
        }
        this.C.setBackgroundDrawable(this.r);
    }

    @Override // com.google.android.material.floatingactionbutton.e
    void a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.B.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(e.f1347b, a(f, f3));
            stateListAnimator.addState(e.c, a(f, f2));
            stateListAnimator.addState(e.d, a(f, f2));
            stateListAnimator.addState(e.e, a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.B, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                VisibilityAwareImageButton visibilityAwareImageButton = this.B;
                arrayList.add(ObjectAnimator.ofFloat(visibilityAwareImageButton, View.TRANSLATION_Z, visibilityAwareImageButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(e.f1346a);
            stateListAnimator.addState(e.f, animatorSet);
            stateListAnimator.addState(e.g, a(0.0f, 0.0f));
            this.B.setStateListAnimator(stateListAnimator);
        }
        if (this.C.a()) {
            s();
        }
    }

    private Animator a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.B, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(e.f1346a);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.e
    public void a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.B.isEnabled()) {
                this.B.setElevation(this.u);
                if (this.B.isPressed()) {
                    this.B.setTranslationZ(this.w);
                    return;
                } else if (!this.B.isFocused() && !this.B.isHovered()) {
                    this.B.setTranslationZ(0.0f);
                    return;
                } else {
                    this.B.setTranslationZ(this.v);
                    return;
                }
            }
            this.B.setElevation(0.0f);
            this.B.setTranslationZ(0.0f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.e
    void a(Rect rect) {
        if (this.C.a()) {
            float b2 = this.C.b();
            float c = c() + this.w;
            int ceil = (int) Math.ceil(com.google.android.material.h.a.a(c, b2, false));
            int ceil2 = (int) Math.ceil(com.google.android.material.h.a.b(c, b2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
