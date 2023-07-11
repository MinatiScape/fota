package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0097k;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.j  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0096j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0097k.a f840a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f841b;
    final /* synthetic */ View c;
    final /* synthetic */ C0097k d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0096j(C0097k c0097k, C0097k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = c0097k;
        this.f840a = aVar;
        this.f841b = viewPropertyAnimator;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f841b.setListener(null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.d.a(this.f840a.f843b, false);
        this.d.s.remove(this.f840a.f843b);
        this.d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.b(this.f840a.f843b, false);
    }
}
