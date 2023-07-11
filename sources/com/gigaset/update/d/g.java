package com.gigaset.update.d;

import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
import java.io.File;
/* compiled from: OldInstallVerify.java */
/* loaded from: classes.dex */
public class g extends a {
    @Override // com.gigaset.update.d.a
    public int a(Context context, String str, String str2) {
        LogUtil.a("start");
        String d = t.d(context);
        if (!com.gigaset.update.utils.g.a(d, t.e(context) + "/package.zip")) {
            LogUtil.a("rename fail");
            return 408;
        }
        LogUtil.a("rename success");
        File file = new File(t.e(context) + "/package.zip");
        String parent = file.getParent();
        if (parent == null) {
            LogUtil.a("deltaPath  null ");
            return 410;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager != null ? powerManager.newWakeLock(1, "fota:unzipwakeup") : null;
        if (newWakeLock != null) {
            newWakeLock.acquire(600000L);
        }
        boolean a2 = com.gigaset.update.utils.g.a(file, parent);
        if (newWakeLock != null) {
            newWakeLock.release();
        }
        if (!a2) {
            LogUtil.a("unzip  fail ");
            return 401;
        }
        LogUtil.a("unzip  success ");
        String c = com.gigaset.update.utils.g.c(parent + "/update.zip");
        String f = com.gigaset.update.utils.g.f(parent + "/md5sum");
        if (c == null) {
            return 411;
        }
        if (!c.equalsIgnoreCase(f)) {
            e.b(context);
            return 402;
        }
        LogUtil.a("md5Encode equal");
        com.gigaset.update.utils.g.b(context, parent);
        if (!com.gigaset.update.e.g.a().a(context)) {
            String a3 = com.gigaset.update.e.d.a(parent + "/update.zip");
            LogUtil.a("isRomDamaged  result = " + a3);
            if (!TextUtils.isEmpty(a3)) {
                a(a3);
                o.b(context, "rom_damaged", true);
                o.b(context, "rom_damaged_version", com.gigaset.update.utils.c.k().l());
                LogUtil.a("rom  are damaged  ");
                if (o.a(context, "isupgrade", 0) == 1) {
                    LogUtil.a("rom  are damaged, upgrade == 1  ");
                    return 404;
                }
            }
        }
        LogUtil.a("finish  success");
        return 405;
    }
}
