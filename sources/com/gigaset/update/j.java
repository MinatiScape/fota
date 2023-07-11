package com.gigaset.update;

import android.view.View;
/* compiled from: MaterialDialog.java */
/* loaded from: classes.dex */
class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.gigaset.update.a.a f1146a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f1147b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar, com.gigaset.update.a.a aVar) {
        this.f1147b = kVar;
        this.f1146a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.gigaset.update.a.a aVar = this.f1146a;
        if (aVar != null) {
            aVar.a();
        }
        this.f1147b.dismiss();
    }
}
