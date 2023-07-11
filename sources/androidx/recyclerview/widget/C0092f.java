package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0092f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.v f832a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f833b;
    final /* synthetic */ View c;
    final /* synthetic */ C0097k d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0092f(C0097k c0097k, RecyclerView.v vVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = c0097k;
        this.f832a = vVar;
        this.f833b = viewPropertyAnimator;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f833b.setListener(null);
        this.c.setAlpha(1.0f);
        this.d.l(this.f832a);
        this.d.r.remove(this.f832a);
        this.d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.m(this.f832a);
    }
}
