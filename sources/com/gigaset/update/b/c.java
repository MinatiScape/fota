package com.gigaset.update.b;

import com.gigaset.update.activity.BaseActivity;
/* compiled from: Setting.java */
/* loaded from: classes.dex */
public final class c {
    public static int a() {
        String c = com.gigaset.update.utils.c.k().c();
        if ("0".equals(c) || "1".equals(c)) {
            return 1440;
        }
        if (BaseActivity.FCM_REPORT_TYPE_LOG.equals(c)) {
            return 4320;
        }
        return "7".equals(c) ? 10080 : 1440;
    }
}
