package com.gigaset.update.activity;

import android.content.Intent;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* loaded from: classes.dex */
public class a implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseActivity f1078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseActivity baseActivity) {
        this.f1078a = baseActivity;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + this.f1078a.getPackageName()));
        intent.addFlags(268435456);
        this.f1078a.startActivityForResult(intent, 1);
    }
}
