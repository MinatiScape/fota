package com.gigaset.update.view;

import android.content.Context;
import android.view.View;
/* compiled from: FloatingView.java */
/* loaded from: classes.dex */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1216a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FloatingView f1217b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FloatingView floatingView, Context context) {
        this.f1217b = floatingView;
        this.f1216a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1217b.a();
        if (com.gigaset.update.manager.i.n()) {
            com.gigaset.update.manager.b.a(this.f1216a);
        }
    }
}
