package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1343a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e.d f1344b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar, boolean z, e.d dVar) {
        this.c = eVar;
        this.f1343a = z;
        this.f1344b = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e eVar = this.c;
        eVar.h = 0;
        eVar.i = null;
        e.d dVar = this.f1344b;
        if (dVar != null) {
            dVar.onShown();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.c.B.a(0, this.f1343a);
        e eVar = this.c;
        eVar.h = 2;
        eVar.i = animator;
    }
}
