package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.core.h.D;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrimInsetsFrameLayout.java */
/* loaded from: classes.dex */
public class n implements androidx.core.h.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScrimInsetsFrameLayout f1384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.f1384a = scrimInsetsFrameLayout;
    }

    @Override // androidx.core.h.o
    public D a(View view, D d) {
        ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.f1384a;
        if (scrimInsetsFrameLayout.f1366b == null) {
            scrimInsetsFrameLayout.f1366b = new Rect();
        }
        this.f1384a.f1366b.set(d.c(), d.e(), d.d(), d.b());
        this.f1384a.a(d);
        this.f1384a.setWillNotDraw(!d.f() || this.f1384a.f1365a == null);
        androidx.core.h.t.C(this.f1384a);
        return d.a();
    }
}
