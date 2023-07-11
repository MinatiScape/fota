package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.tabs.TabLayout;
/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1425a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TabLayout.e f1426b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TabLayout.e eVar, int i) {
        this.f1426b = eVar;
        this.f1425a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        TabLayout.e eVar = this.f1426b;
        eVar.d = this.f1425a;
        eVar.e = 0.0f;
    }
}
