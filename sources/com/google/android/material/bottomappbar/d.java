package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
public class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1279a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ActionMenuView f1280b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ BottomAppBar e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.e = bottomAppBar;
        this.f1280b = actionMenuView;
        this.c = i;
        this.d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f1279a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f1279a) {
            return;
        }
        this.e.a(this.f1280b, this.c, this.d);
    }
}
