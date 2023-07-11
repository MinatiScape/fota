package com.gigaset.update.activity;

import android.os.Handler;
import com.gigaset.update.utils.LogUtil;
/* compiled from: SdcardUpdateActivity.java */
/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f1094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(r rVar) {
        this.f1094a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        LogUtil.a("LocalSdUpdate : path = /data/ota_package/update.zip");
        SdcardUpdateActivity sdcardUpdateActivity = this.f1094a.f1095a;
        str = sdcardUpdateActivity.e;
        if (!sdcardUpdateActivity.a(str, "/data/ota_package/update.zip", false)) {
            handler = this.f1094a.f1095a.f;
            handler2 = this.f1094a.f1095a.f;
            handler.sendMessage(handler2.obtainMessage(-2));
            return;
        }
        this.f1094a.f1095a.e = "/data/ota_package/update.zip";
        handler3 = this.f1094a.f1095a.f;
        handler4 = this.f1094a.f1095a.f;
        handler3.sendMessage(handler4.obtainMessage(15));
    }
}
