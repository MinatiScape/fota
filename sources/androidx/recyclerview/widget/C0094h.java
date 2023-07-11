package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.h  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0094h extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.v f836a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f837b;
    final /* synthetic */ View c;
    final /* synthetic */ int d;
    final /* synthetic */ ViewPropertyAnimator e;
    final /* synthetic */ C0097k f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0094h(C0097k c0097k, RecyclerView.v vVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = c0097k;
        this.f836a = vVar;
        this.f837b = i;
        this.c = view;
        this.d = i2;
        this.e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (this.f837b != 0) {
            this.c.setTranslationX(0.0f);
        }
        if (this.d != 0) {
            this.c.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.e.setListener(null);
        this.f.j(this.f836a);
        this.f.q.remove(this.f836a);
        this.f.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f.k(this.f836a);
    }
}
