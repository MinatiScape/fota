package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class Fade extends Visibility {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f917a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f918b = false;

        a(View view) {
            this.f917a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            va.a(this.f917a, 1.0f);
            if (this.f918b) {
                this.f917a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (androidx.core.h.t.w(this.f917a) && this.f917a.getLayerType() == 0) {
                this.f918b = true;
                this.f917a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i) {
        a(i);
    }

    private Animator a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        va.a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, va.d, f2);
        ofFloat.addListener(new a(view));
        a(new C0124t(this, view));
        return ofFloat;
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        va.e(view);
        return a(view, a(gaVar, 1.0f), 0.0f);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void c(ga gaVar) {
        super.c(gaVar);
        gaVar.f959a.put("android:fade:transitionAlpha", Float.valueOf(va.c(gaVar.f960b)));
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.f);
        a(androidx.core.content.a.i.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, q()));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        float a2 = a(gaVar, 0.0f);
        return a(view, a2 != 1.0f ? a2 : 0.0f, 1.0f);
    }

    private static float a(ga gaVar, float f) {
        Float f2;
        return (gaVar == null || (f2 = (Float) gaVar.f959a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }
}
