package com.gigaset.update.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.gigaset.update.b.d;
import com.gigaset.update.f.a;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.c;
/* loaded from: classes.dex */
public class BatteryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            int c = d.c(context);
            LogUtil.a("status = " + c + ",action = " + action);
            if (c == 4 && action.equalsIgnoreCase("android.intent.action.BATTERY_CHANGED")) {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager == null) {
                    z = false;
                } else if (Build.VERSION.SDK_INT > 19) {
                    z = powerManager.isInteractive();
                } else {
                    z = powerManager.isScreenOn();
                }
                int intExtra = intent.getIntExtra("level", 0);
                LogUtil.a("battery level = " + intExtra + ",isScreenOn = " + z);
                if (intExtra < c.k().b() || z) {
                    return;
                }
                a.a(context, "auto");
                com.gigaset.update.d.d.e(context);
            }
        }
    }
}
