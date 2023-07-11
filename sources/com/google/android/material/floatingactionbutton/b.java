package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1341a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f1342b;
    final /* synthetic */ e.d c;
    final /* synthetic */ e d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar, boolean z, e.d dVar) {
        this.d = eVar;
        this.f1342b = z;
        this.c = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f1341a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e eVar = this.d;
        eVar.h = 0;
        eVar.i = null;
        if (this.f1341a) {
            return;
        }
        eVar.B.a(this.f1342b ? 8 : 4, this.f1342b);
        e.d dVar = this.c;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.B.a(0, this.f1342b);
        e eVar = this.d;
        eVar.h = 1;
        eVar.i = animator;
        this.f1341a = false;
    }
}
