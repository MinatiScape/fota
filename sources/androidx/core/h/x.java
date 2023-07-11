package androidx.core.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
class x extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f541a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f542b;
    final /* synthetic */ z c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(z zVar, A a2, View view) {
        this.c = zVar;
        this.f541a = a2;
        this.f542b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f541a.a(this.f542b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f541a.b(this.f542b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f541a.c(this.f542b);
    }
}
