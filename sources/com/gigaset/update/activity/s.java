package com.gigaset.update.activity;

import com.gigaset.update.bean.EventMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SdcardUpdateActivity.java */
/* loaded from: classes.dex */
public class s implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SdcardUpdateActivity f1096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SdcardUpdateActivity sdcardUpdateActivity) {
        this.f1096a = sdcardUpdateActivity;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        com.gigaset.update.b.d.d(this.f1096a);
        org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1006, 0L, 0L, null));
        if (com.gigaset.update.utils.c.k().F()) {
            com.gigaset.update.b.d.a(this.f1096a, 5);
        }
        this.f1096a.d();
    }
}
