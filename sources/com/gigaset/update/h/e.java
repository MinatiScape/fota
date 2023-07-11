package com.gigaset.update.h;

import android.content.Context;
import com.gigaset.update.manager.h;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
/* compiled from: UpdateVerify.java */
/* loaded from: classes.dex */
public class e {
    private void b(Context context) {
        LogUtil.b(o.a(context, "debug_status"));
        LogUtil.c(o.a(context, "debug_log_path", ""));
    }

    public void a(Context context) {
        b(context);
        int c = com.gigaset.update.b.d.c(context);
        if (c == 5 && com.gigaset.update.d.e.a(context)) {
            com.gigaset.update.b.d.a(context, 6);
            c = 6;
        }
        LogUtil.a("startVerify status = " + c);
        a(context, com.gigaset.update.d.e.c(context), c);
        com.gigaset.update.e.b.c(context);
        if (c == 2) {
            com.gigaset.update.b.d.a(context, 3);
        } else if (c >= 4) {
            com.gigaset.update.b.d.a(context);
        }
    }

    private void a(Context context, boolean z, int i) {
        LogUtil.a("isNotifyMessage,isRebootRecovery = " + z + " status = " + i);
        int intValue = ((Integer) com.gigaset.update.e.c.a().a("query_notice_type", Integer.class)).intValue();
        boolean booleanValue = ((Boolean) com.gigaset.update.e.c.a().a("query_notice_resident", Boolean.class)).booleanValue();
        int intValue2 = ((Integer) com.gigaset.update.e.c.a().a("install_notice_type", Integer.class)).intValue();
        boolean booleanValue2 = ((Boolean) com.gigaset.update.e.c.a().a("install_notice_resident", Boolean.class)).booleanValue();
        LogUtil.a("noticeType = " + intValue + "||noticeResident = " + booleanValue + "||installNoticeType = " + intValue2 + "||installNoticeResident = " + booleanValue2);
        if (z || i == 0) {
            return;
        }
        if ((intValue == 0 && booleanValue) || (intValue2 == 0 && booleanValue2)) {
            if (i == 4) {
                LogUtil.a("showDownloadCompleted");
                h.a().b(context, true);
                return;
            }
            LogUtil.a("showNewVersion");
            h.a().d(context, true);
        }
    }
}
