package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
/* compiled from: TranslationAnimationCreator.java */
/* loaded from: classes.dex */
class ia {

    /* compiled from: TranslationAnimationCreator.java */
    /* loaded from: classes.dex */
    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f965a;

        /* renamed from: b  reason: collision with root package name */
        private final View f966b;
        private final int c;
        private final int d;
        private int[] e;
        private float f;
        private float g;
        private final float h;
        private final float i;

        a(View view, View view2, int i, int i2, float f, float f2) {
            this.f966b = view;
            this.f965a = view2;
            this.c = i - Math.round(this.f966b.getTranslationX());
            this.d = i2 - Math.round(this.f966b.getTranslationY());
            this.h = f;
            this.i = f2;
            this.e = (int[]) this.f965a.getTag(R$id.transition_position);
            if (this.e != null) {
                this.f965a.setTag(R$id.transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.e == null) {
                this.e = new int[2];
            }
            this.e[0] = Math.round(this.c + this.f966b.getTranslationX());
            this.e[1] = Math.round(this.d + this.f966b.getTranslationY());
            this.f965a.setTag(R$id.transition_position, this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f966b.setTranslationX(this.h);
            this.f966b.setTranslationY(this.i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f = this.f966b.getTranslationX();
            this.g = this.f966b.getTranslationY();
            this.f966b.setTranslationX(this.h);
            this.f966b.setTranslationY(this.i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f966b.setTranslationX(this.f);
            this.f966b.setTranslationY(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator a(View view, ga gaVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) gaVar.f960b.getTag(R$id.transition_position);
        if (iArr != null) {
            f5 = (iArr[0] - i) + translationX;
            f6 = (iArr[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int round = i + Math.round(f5 - translationX);
        int round2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f6, f4));
        a aVar = new a(view, gaVar.f960b, round, round2, translationX, translationY);
        ofPropertyValuesHolder.addListener(aVar);
        C0101a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
