package com.gigaset.update.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gigaset.update.b.a;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.service.SystemActionService;
import com.gigaset.update.utils.LogUtil;
/* loaded from: classes.dex */
public class MyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            LogUtil.a(intent.toString());
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && !action.equalsIgnoreCase(a.j)) {
                SystemActionService.a(context, intent);
            } else {
                CustomActionService.a(context, intent.getIntExtra("task", 1));
            }
        }
    }
}
