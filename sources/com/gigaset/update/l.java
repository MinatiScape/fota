package com.gigaset.update;

import android.telephony.PhoneStateListener;
import com.gigaset.update.utils.LogUtil;
/* compiled from: MyApplication.java */
/* loaded from: classes.dex */
class l extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyApplication f1150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MyApplication myApplication) {
        this.f1150a = myApplication;
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        com.gigaset.update.a.b bVar;
        com.gigaset.update.a.b bVar2;
        boolean z;
        com.gigaset.update.a.b bVar3;
        com.gigaset.update.a.b bVar4;
        super.onCallStateChanged(i, str);
        if (com.gigaset.update.utils.k.c(MyApplication.f1070a)) {
            LogUtil.a("onCallStateChanged but WiFiConnected ,ignored");
            return;
        }
        if (i == 1 || i == 2) {
            boolean unused = MyApplication.f1071b = true;
            bVar = MyApplication.c;
            if (bVar != null) {
                bVar2 = MyApplication.c;
                bVar2.onPhoneCalling();
            }
        } else {
            boolean unused2 = MyApplication.f1071b = false;
            bVar3 = MyApplication.c;
            if (bVar3 != null) {
                bVar4 = MyApplication.c;
                bVar4.onPhoneOff();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("phone state : ");
        sb.append(i);
        sb.append(" , isCalling : ");
        z = MyApplication.f1071b;
        sb.append(z);
        LogUtil.a(sb.toString());
    }
}
