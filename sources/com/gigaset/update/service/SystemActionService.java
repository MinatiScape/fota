package com.gigaset.update.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.JobIntentService;
import com.gigaset.update.a.e;
import com.gigaset.update.b.d;
import com.gigaset.update.e.g;
import com.gigaset.update.g.c;
import com.gigaset.update.manager.JobScheduleManager;
import com.gigaset.update.manager.b;
import com.gigaset.update.manager.i;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.k;
/* loaded from: classes.dex */
public class SystemActionService extends JobIntentService implements e {
    private static boolean j = false;

    public static void a(Context context, Intent intent) {
        JobIntentService.a(context, SystemActionService.class, 100, intent);
    }

    private void b(boolean z) {
        boolean a2 = k.a(this);
        LogUtil.a("isConnected = " + a2);
        if (a2) {
            g.a().a((Context) this, true);
            if (!z || d.c(this) != 2) {
                com.gigaset.update.c.d.b().e(this);
            }
            if (i.o()) {
                c.a(this, this);
            }
            com.gigaset.update.f.e.a().a(this);
        }
    }

    @Override // androidx.core.app.JobIntentService
    protected void a(Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equalsIgnoreCase("android.intent.action.MEDIA_BAD_REMOVAL") || action.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED")) {
            LogUtil.b(false);
        }
        LogUtil.a("action = " + action);
        char c = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1886648615) {
            if (hashCode != -1172645946) {
                if (hashCode == 798292259 && action.equals("android.intent.action.BOOT_COMPLETED")) {
                    c = 0;
                }
            } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                c = 1;
            }
        } else if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            c = 2;
        }
        if (c == 0) {
            LogUtil.a("isReceivedBoot : " + j);
            if (j) {
                return;
            }
            j = true;
            b.d(this);
            if (Build.VERSION.SDK_INT > 20) {
                JobScheduleManager.a(this, 100);
            }
            if (i.m() != 0) {
                b.e(this);
            }
        } else if (c != 1) {
            if (c != 2) {
                return;
            }
            b(true);
            return;
        }
        b(false);
    }

    @Override // com.gigaset.update.a.e
    public void a(String str) throws Exception {
        LogUtil.a(str);
        i.a(false);
    }
}
