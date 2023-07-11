package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.g  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0093g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.v f834a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f835b;
    final /* synthetic */ ViewPropertyAnimator c;
    final /* synthetic */ C0097k d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0093g(C0097k c0097k, RecyclerView.v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.d = c0097k;
        this.f834a = vVar;
        this.f835b = view;
        this.c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f835b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.c.setListener(null);
        this.d.h(this.f834a);
        this.d.p.remove(this.f834a);
        this.d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.i(this.f834a);
    }
}
