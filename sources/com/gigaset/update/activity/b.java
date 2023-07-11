package com.gigaset.update.activity;

import android.content.Intent;
import com.gigaset.update.GoogleOtaClient;
import com.gigaset.update.MyApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* loaded from: classes.dex */
public class b implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseActivity f1079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseActivity baseActivity) {
        this.f1079a = baseActivity;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        this.f1079a.startService(new Intent(MyApplication.c(), GoogleOtaClient.class));
    }
}
