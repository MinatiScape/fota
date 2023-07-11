package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
/* compiled from: ExpandableBehavior.java */
/* loaded from: classes.dex */
class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1442a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1443b;
    final /* synthetic */ com.google.android.material.d.b c;
    final /* synthetic */ ExpandableBehavior d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ExpandableBehavior expandableBehavior, View view, int i, com.google.android.material.d.b bVar) {
        this.d = expandableBehavior;
        this.f1442a = view;
        this.f1443b = i;
        this.c = bVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        int i;
        this.f1442a.getViewTreeObserver().removeOnPreDrawListener(this);
        i = this.d.f1438a;
        if (i == this.f1443b) {
            ExpandableBehavior expandableBehavior = this.d;
            com.google.android.material.d.b bVar = this.c;
            expandableBehavior.a((View) bVar, this.f1442a, bVar.a(), false);
        }
        return false;
    }
}
