package com.gigaset.update.activity;

import android.content.Context;
import android.os.Handler;
import com.gigaset.update.utils.LogUtil;
/* compiled from: SdcardUpdateActivity.java */
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f1093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(r rVar) {
        this.f1093a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str2 = com.gigaset.update.utils.t.b((Context) this.f1093a.f1095a, true) + com.gigaset.update.b.a.f;
        LogUtil.a("LocalSdUpdate : path = " + str2);
        SdcardUpdateActivity sdcardUpdateActivity = this.f1093a.f1095a;
        str = sdcardUpdateActivity.e;
        if (!sdcardUpdateActivity.a(str, str2, false)) {
            handler = this.f1093a.f1095a.f;
            handler2 = this.f1093a.f1095a.f;
            handler.sendMessage(handler2.obtainMessage(-2));
            return;
        }
        this.f1093a.f1095a.e = str2;
        handler3 = this.f1093a.f1095a.f;
        handler4 = this.f1093a.f1095a.f;
        handler3.sendMessage(handler4.obtainMessage(15));
    }
}
