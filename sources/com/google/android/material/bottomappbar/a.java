package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
public class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BottomAppBar bottomAppBar) {
        this.f1276a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1276a.T = null;
    }
}
