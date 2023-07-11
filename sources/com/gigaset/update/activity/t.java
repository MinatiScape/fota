package com.gigaset.update.activity;

import android.os.Build;
import android.os.Handler;
import com.gigaset.update.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SdcardUpdateActivity.java */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SdcardUpdateActivity f1097a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SdcardUpdateActivity sdcardUpdateActivity) {
        this.f1097a = sdcardUpdateActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        String str;
        String a2;
        String str2;
        LogUtil.a("sdCardUpdate, copy to ota_root file");
        if (Build.VERSION.SDK_INT < 23) {
            StringBuilder sb = new StringBuilder();
            SdcardUpdateActivity sdcardUpdateActivity = this.f1097a;
            str = sdcardUpdateActivity.e;
            a2 = sdcardUpdateActivity.a(str);
            sb.append(a2);
            sb.append("/LocalSdUpdate.zip");
            String sb2 = sb.toString();
            SdcardUpdateActivity sdcardUpdateActivity2 = this.f1097a;
            str2 = sdcardUpdateActivity2.e;
            if (sdcardUpdateActivity2.a(str2, sb2, true)) {
                this.f1097a.e = sb2;
            }
        }
        handler = this.f1097a.f;
        handler.sendEmptyMessage(2);
    }
}
