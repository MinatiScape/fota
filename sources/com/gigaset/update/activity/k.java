package com.gigaset.update.activity;

import android.content.Intent;
import com.gigaset.update.GoogleOtaClient;
/* compiled from: PopupActivity.java */
/* loaded from: classes.dex */
class k implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PopupActivity popupActivity) {
        this.f1088a = popupActivity;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        PopupActivity popupActivity = this.f1088a;
        popupActivity.startActivity(new Intent(popupActivity, GoogleOtaClient.class));
        this.f1088a.finish();
    }
}
