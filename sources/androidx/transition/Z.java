package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transition.java */
/* loaded from: classes.dex */
public class Z extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Transition f943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(Transition transition) {
        this.f943a = transition;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f943a.a();
        animator.removeListener(this);
    }
}
