package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
public class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BottomAppBar bottomAppBar) {
        this.f1283a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        boolean z;
        int i;
        boolean z2;
        BottomAppBar bottomAppBar = this.f1283a;
        z = bottomAppBar.aa;
        bottomAppBar.b(z);
        BottomAppBar bottomAppBar2 = this.f1283a;
        i = bottomAppBar2.V;
        z2 = this.f1283a.aa;
        bottomAppBar2.a(i, z2);
    }
}
