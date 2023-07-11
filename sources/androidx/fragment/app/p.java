package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f642a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f643b;
    final /* synthetic */ Fragment c;
    final /* synthetic */ r d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(r rVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.d = rVar;
        this.f642a = viewGroup;
        this.f643b = view;
        this.c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f642a.endViewTransition(this.f643b);
        animator.removeListener(this);
        View view = this.c.K;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
