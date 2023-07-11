package com.gigaset.update;

import android.view.View;
/* compiled from: MaterialDialog.java */
/* loaded from: classes.dex */
class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.gigaset.update.a.a f1144a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f1145b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(k kVar, com.gigaset.update.a.a aVar) {
        this.f1145b = kVar;
        this.f1144a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.gigaset.update.a.a aVar = this.f1144a;
        if (aVar != null) {
            aVar.a();
        }
        this.f1145b.dismiss();
    }
}
