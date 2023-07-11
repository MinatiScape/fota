package com.gigaset.update.activity;

import android.os.Handler;
import java.io.File;
/* compiled from: SdcardUpdateActivity.java */
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f1092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(r rVar) {
        this.f1092a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        try {
            new File(this.f1092a.f1095a.getFilesDir() + "/gigasetfota").mkdirs();
        } catch (Exception unused) {
        }
        SdcardUpdateActivity sdcardUpdateActivity = this.f1092a.f1095a;
        str = sdcardUpdateActivity.e;
        if (!sdcardUpdateActivity.a(str, com.gigaset.update.b.a.e, false)) {
            handler = this.f1092a.f1095a.f;
            handler2 = this.f1092a.f1095a.f;
            handler.sendMessage(handler2.obtainMessage(-2));
            return;
        }
        this.f1092a.f1095a.e = com.gigaset.update.b.a.e;
        handler3 = this.f1092a.f1095a.f;
        handler4 = this.f1092a.f1095a.f;
        handler3.sendMessage(handler4.obtainMessage(15));
    }
}
