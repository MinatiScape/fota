package com.google.android.material.floatingactionbutton;

import android.view.ViewTreeObserver;
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
class d implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1345a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f1345a = eVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f1345a.p();
        return true;
    }
}
