package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f640a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f641b;
    final /* synthetic */ Fragment c;
    final /* synthetic */ r d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(r rVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.d = rVar;
        this.f640a = viewGroup;
        this.f641b = view;
        this.c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f640a.endViewTransition(this.f641b);
        Animator f = this.c.f();
        this.c.a((Animator) null);
        if (f == null || this.f640a.indexOfChild(this.f641b) >= 0) {
            return;
        }
        r rVar = this.d;
        Fragment fragment = this.c;
        rVar.a(fragment, fragment.v(), 0, 0, false);
    }
}
