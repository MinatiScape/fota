package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
public class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BottomAppBar bottomAppBar) {
        this.f1281a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1281a.S = null;
    }
}
