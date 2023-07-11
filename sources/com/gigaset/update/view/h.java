package com.gigaset.update.view;

import android.view.View;
/* compiled from: FloatingView.java */
/* loaded from: classes.dex */
class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FloatingView f1223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FloatingView floatingView) {
        this.f1223a = floatingView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1223a.a();
    }
}
