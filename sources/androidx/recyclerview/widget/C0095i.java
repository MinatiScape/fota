package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0097k;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.i  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0095i extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0097k.a f838a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f839b;
    final /* synthetic */ View c;
    final /* synthetic */ C0097k d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0095i(C0097k c0097k, C0097k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = c0097k;
        this.f838a = aVar;
        this.f839b = viewPropertyAnimator;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f839b.setListener(null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.d.a(this.f838a.f842a, true);
        this.d.s.remove(this.f838a.f842a);
        this.d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.b(this.f838a.f842a, true);
    }
}
