package com.gigaset.update.view;

import android.content.Intent;
import android.view.View;
import com.gigaset.update.GoogleOtaClient;
import com.gigaset.update.MyApplication;
/* compiled from: FloatingView.java */
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FloatingView f1218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FloatingView floatingView) {
        this.f1218a = floatingView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1218a.a();
        Intent intent = new Intent(MyApplication.c(), GoogleOtaClient.class);
        intent.addFlags(268435456);
        MyApplication.c().startActivity(intent);
    }
}
