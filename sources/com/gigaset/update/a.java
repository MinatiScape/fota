package com.gigaset.update;

import android.os.Handler;
import android.os.Message;
import com.gigaset.update.view.InstallDelayView;
/* compiled from: GoogleOtaClient.java */
/* loaded from: classes.dex */
class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoogleOtaClient googleOtaClient) {
        this.f1073a = googleOtaClient;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        k kVar;
        k kVar2;
        Handler handler;
        boolean isOverRemindDate;
        int i3 = message.what;
        if (i3 != 11) {
            if (i3 == 100) {
                this.f1073a.statusAction(message.arg1);
                return;
            } else if (i3 != 33) {
                if (i3 != 34) {
                    return;
                }
                this.f1073a.queryFullRom();
                return;
            } else if (com.gigaset.update.b.d.c(this.f1073a) == 0) {
                isOverRemindDate = this.f1073a.isOverRemindDate();
                if (isOverRemindDate && com.gigaset.update.utils.k.a(this.f1073a)) {
                    this.f1073a.onClickQuery();
                    return;
                }
                return;
            } else {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1073a.getString(R.string.remind_last_time));
        sb.append("(");
        i = this.f1073a.delayTimeCounts;
        sb.append(i);
        sb.append(")");
        String sb2 = sb.toString();
        i2 = this.f1073a.delayTimeCounts;
        if (i2 > 0) {
            kVar = this.f1073a.dialog;
            if (kVar != null) {
                kVar2 = this.f1073a.dialog;
                kVar2.b(sb2);
            } else {
                InstallDelayView installDelayView = new InstallDelayView(this.f1073a);
                installDelayView.setOnItemClickListener(this.f1073a);
                GoogleOtaClient googleOtaClient = this.f1073a;
                googleOtaClient.dialog = com.gigaset.update.utils.d.a(googleOtaClient, sb2, 17, googleOtaClient, installDelayView);
            }
            GoogleOtaClient.access$010(this.f1073a);
            handler = this.f1073a.mHandler;
            handler.sendEmptyMessageDelayed(11, 1000L);
            return;
        }
        this.f1073a.onClickSchedule(1);
    }
}
