package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transition.java */
/* loaded from: classes.dex */
public class Y extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.b.b f941a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Transition f942b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(Transition transition, a.b.b bVar) {
        this.f942b = transition;
        this.f941a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f941a.remove(animator);
        this.f942b.A.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f942b.A.add(animator);
    }
}
