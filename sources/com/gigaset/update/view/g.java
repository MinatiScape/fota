package com.gigaset.update.view;

import android.content.Context;
import android.view.View;
/* compiled from: FloatingView.java */
/* loaded from: classes.dex */
class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1221a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FloatingView f1222b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FloatingView floatingView, Context context) {
        this.f1222b = floatingView;
        this.f1221a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1222b.a();
        com.gigaset.update.h.d.a().a(this.f1221a);
    }
}
