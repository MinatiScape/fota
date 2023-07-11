package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public class Aa extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ la f897a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f898b;
    final /* synthetic */ Visibility c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa(Visibility visibility, la laVar, View view) {
        this.c = visibility;
        this.f897a = laVar;
        this.f898b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f897a.b(this.f898b);
    }
}
