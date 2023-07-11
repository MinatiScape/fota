package com.gigaset.update.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
/* compiled from: QueryActivate.java */
/* loaded from: classes.dex */
public class b {
    public static void a(Context context) {
        LogUtil.a("enter");
        if (SystemClock.elapsedRealtime() < com.gigaset.update.utils.c.k().q()) {
            com.gigaset.update.manager.b.c(context);
            return;
        }
        o.b(context, "activate_total_time", com.gigaset.update.utils.c.k().q());
        e(context);
        com.gigaset.update.manager.b.d(context);
        CustomActionService.a(context, 1);
    }

    public static boolean b(Context context) {
        if (SystemClock.elapsedRealtime() >= com.gigaset.update.utils.c.k().q()) {
            if (!d(context)) {
                e(context);
            }
            return true;
        }
        if (!d(context)) {
            com.gigaset.update.manager.b.c(context);
        }
        if (o.a(context, "activate_total_time", 0L) >= com.gigaset.update.utils.c.k().q()) {
            return true;
        }
        return d(context);
    }

    public static void c(Context context) {
        if (b(context)) {
            LogUtil.a("ota is activated");
        } else {
            com.gigaset.update.manager.b.c(context);
        }
    }

    private static boolean d(Context context) {
        boolean z = !TextUtils.isEmpty(com.gigaset.update.utils.g.i(t.c(context) + com.gigaset.update.b.a.f1099a));
        if (!z && com.gigaset.update.utils.g.a(context)) {
            z = !TextUtils.isEmpty(com.gigaset.update.utils.g.i(t.c() + com.gigaset.update.b.a.f1099a));
        }
        LogUtil.a("dogWatch exists : " + z);
        return z;
    }

    private static void e(Context context) {
        if (com.gigaset.update.utils.g.b(context)) {
            com.gigaset.update.utils.g.a(t.c() + com.gigaset.update.b.a.f1099a, "uu".getBytes());
        }
        com.gigaset.update.utils.g.a(t.c(context) + com.gigaset.update.b.a.f1099a, "uu".getBytes());
        LogUtil.a("put dogWatch");
    }
}
