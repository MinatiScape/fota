package com.gigaset.update.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.app.JobIntentService;
import com.gigaset.update.activity.BaseActivity;
import com.gigaset.update.b.a;
import com.gigaset.update.b.d;
import com.gigaset.update.e.b;
import com.gigaset.update.e.g;
import com.gigaset.update.f.e;
import com.gigaset.update.manager.h;
import com.gigaset.update.manager.i;
import com.gigaset.update.receiver.BatteryReceiver;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
import java.util.HashMap;
/* loaded from: classes.dex */
public class CustomActionService extends JobIntentService {
    public static void a(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction(a.j);
        intent.putExtra("task", i);
        JobIntentService.a(context, CustomActionService.class, 101, intent);
    }

    @Override // androidx.core.app.JobIntentService
    protected void a(Intent intent) {
        String action = intent.getAction();
        LogUtil.a("action = " + action);
        if (TextUtils.isEmpty(action) || !action.equalsIgnoreCase(a.j)) {
            return;
        }
        int intExtra = intent.getIntExtra("task", Integer.MAX_VALUE);
        LogUtil.a("task id = " + intExtra);
        switch (intExtra) {
            case 1:
                g.a().a((Context) this, false);
                d.a(this);
                return;
            case 2:
                b.a(this);
                return;
            case 3:
            case 5:
            case 8:
            case 10:
            default:
                return;
            case 4:
            case 14:
                com.gigaset.update.d.d.c(this);
                return;
            case 6:
                com.gigaset.update.d.d.d(this);
                return;
            case 7:
                com.gigaset.update.manager.g.a(this, 0);
                return;
            case 9:
                com.gigaset.update.c.d.b().b(this);
                return;
            case 11:
                g.a().b(this);
                return;
            case 12:
                com.gigaset.update.d.d.b(this);
                return;
            case 13:
                LogUtil.b(false);
                HashMap hashMap = new HashMap();
                hashMap.put("task_id", i.k());
                hashMap.put("action_type", BaseActivity.FCM_REPORT_TYPE_LOG);
                hashMap.put("log", o.d(this, "debug_log_path"));
                e.a().a(this, hashMap);
                i.s();
                return;
            case 15:
                h.a().a(this, 105);
                registerReceiver(new BatteryReceiver(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                return;
            case 16:
                com.gigaset.update.c.d.b().e(this);
                return;
        }
    }
}
