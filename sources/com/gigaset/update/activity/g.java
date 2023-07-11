package com.gigaset.update.activity;

import android.content.Intent;
import com.gigaset.update.GoogleOtaClient;
/* compiled from: PopupActivity.java */
/* loaded from: classes.dex */
class g implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PopupActivity popupActivity) {
        this.f1084a = popupActivity;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        PopupActivity popupActivity = this.f1084a;
        popupActivity.startActivity(new Intent(popupActivity, GoogleOtaClient.class));
    }
}
