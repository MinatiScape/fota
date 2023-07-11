package com.gigaset.update.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gigaset.update.activity.InstallResultActivity;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
/* compiled from: InstallResult.java */
/* loaded from: classes.dex */
public class e {
    private static boolean a(Context context, boolean z) {
        if (z) {
            return o.a(context, "ota_install_result_pop", false);
        }
        return o.a(context, "noPopWinFlag", 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        o.b(context, "ota_install_fail_count", o.a(context, "ota_install_fail_count", 0) + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:11:0x0019, B:30:0x00b2, B:15:0x003e, B:17:0x0047, B:18:0x0055, B:20:0x006e, B:21:0x0071, B:23:0x008e, B:25:0x00a4, B:26:0x00a7, B:27:0x00aa, B:29:0x00af), top: B:35:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:11:0x0019, B:30:0x00b2, B:15:0x003e, B:17:0x0047, B:18:0x0055, B:20:0x006e, B:21:0x0071, B:23:0x008e, B:25:0x00a4, B:26:0x00a7, B:27:0x00aa, B:29:0x00af), top: B:35:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:11:0x0019, B:30:0x00b2, B:15:0x003e, B:17:0x0047, B:18:0x0055, B:20:0x006e, B:21:0x0071, B:23:0x008e, B:25:0x00a4, B:26:0x00a7, B:27:0x00aa, B:29:0x00af), top: B:35:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:11:0x0019, B:30:0x00b2, B:15:0x003e, B:17:0x0047, B:18:0x0055, B:20:0x006e, B:21:0x0071, B:23:0x008e, B:25:0x00a4, B:26:0x00a7, B:27:0x00aa, B:29:0x00af), top: B:35:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(android.content.Context r7) {
        /*
            java.lang.Class<com.gigaset.update.d.e> r0 = com.gigaset.update.d.e.class
            monitor-enter(r0)
            java.lang.String r1 = "ota_enter_recovery"
            boolean r1 = com.gigaset.update.utils.o.a(r7, r1)     // Catch: java.lang.Throwable -> Lb4
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L18
            java.lang.String r1 = "ota_enter_recovery"
            int r1 = com.gigaset.update.utils.u.a(r1, r3)     // Catch: java.lang.Throwable -> Lb4
            if (r1 != r2) goto L16
            goto L18
        L16:
            r1 = 0
            goto L19
        L18:
            r1 = 1
        L19:
            int r4 = com.gigaset.update.b.d.c(r7)     // Catch: java.lang.Throwable -> Lb4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb4
            r5.<init>()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "install verify,rebootRecovery : "
            r5.append(r6)     // Catch: java.lang.Throwable -> Lb4
            r5.append(r1)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = " ,status : "
            r5.append(r6)     // Catch: java.lang.Throwable -> Lb4
            r5.append(r4)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb4
            com.gigaset.update.utils.LogUtil.a(r5)     // Catch: java.lang.Throwable -> Lb4
            if (r1 != 0) goto L3e
            r5 = 6
            if (r4 != r5) goto Lb2
        L3e:
            boolean r4 = a(r7)     // Catch: java.lang.Throwable -> Lb4
            b(r7, r4)     // Catch: java.lang.Throwable -> Lb4
            if (r1 != 0) goto L55
            java.lang.String r5 = "ota_original_version"
            java.lang.String r6 = ""
            com.gigaset.update.utils.o.b(r7, r5, r6)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r5 = "ota_update_version"
            java.lang.String r6 = ""
            com.gigaset.update.utils.o.b(r7, r5, r6)     // Catch: java.lang.Throwable -> Lb4
        L55:
            java.lang.String r5 = "ota_enter_recovery"
            com.gigaset.update.utils.o.b(r7, r5, r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r5 = "ota_enter_recovery"
            com.gigaset.update.utils.u.b(r5, r3)     // Catch: java.lang.Throwable -> Lb4
            com.gigaset.update.e.c r5 = com.gigaset.update.e.c.a()     // Catch: java.lang.Throwable -> Lb4
            r5.a(r7)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r5 = "notifyFlag"
            int r5 = com.gigaset.update.utils.o.a(r7, r5, r3)     // Catch: java.lang.Throwable -> Lb4
            if (r2 != r5) goto L71
            com.gigaset.update.manager.g.c(r7, r2)     // Catch: java.lang.Throwable -> Lb4
        L71:
            java.lang.String r2 = "ota_update_type"
            r5 = -1
            int r2 = com.gigaset.update.utils.o.a(r7, r2, r5)     // Catch: java.lang.Throwable -> Lb4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb4
            r5.<init>()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "FOTA_UPDATE_TYPE = "
            r5.append(r6)     // Catch: java.lang.Throwable -> Lb4
            r5.append(r2)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> Lb4
            com.gigaset.update.utils.LogUtil.a(r2)     // Catch: java.lang.Throwable -> Lb4
            if (r4 == 0) goto Laa
            com.gigaset.update.b.d.a(r7, r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r2 = "ota_original_version"
            com.gigaset.update.utils.c r3 = com.gigaset.update.utils.c.k()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r3 = r3.l()     // Catch: java.lang.Throwable -> Lb4
            com.gigaset.update.utils.o.b(r7, r2, r3)     // Catch: java.lang.Throwable -> Lb4
            boolean r2 = a(r7, r1)     // Catch: java.lang.Throwable -> Lb4
            if (r2 == 0) goto La7
            d(r7)     // Catch: java.lang.Throwable -> Lb4
        La7:
            com.gigaset.update.manager.i.r()     // Catch: java.lang.Throwable -> Lb4
        Laa:
            c(r7, r4)     // Catch: java.lang.Throwable -> Lb4
            if (r4 == 0) goto Lb2
            e(r7)     // Catch: java.lang.Throwable -> Lb4
        Lb2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            return r1
        Lb4:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb4
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.d.e.c(android.content.Context):boolean");
    }

    private static void d(Context context) {
        LogUtil.a("forward InstallResultActivity");
        String l = com.gigaset.update.utils.c.k().l();
        Intent intent = new Intent(context, InstallResultActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("version", l);
        context.startActivity(intent);
    }

    private static void e(Context context) {
        if (com.gigaset.update.utils.c.k().B()) {
            LogUtil.a("sendUpdateSuccessBroadcast");
            Intent intent = new Intent();
            intent.setAction(com.gigaset.update.b.a.g);
            intent.addFlags(268435456);
            context.sendBroadcast(intent, com.gigaset.update.b.a.i);
        }
    }

    public static boolean a(Context context) {
        String l = com.gigaset.update.utils.c.k().l();
        String a2 = o.a(context, "ota_original_version", "");
        LogUtil.a("oldVersion = " + a2 + ";deviceVersion = " + l);
        return (TextUtils.isEmpty(a2) || a2.equalsIgnoreCase(l)) ? false : true;
    }

    private static void b(Context context, boolean z) {
        LogUtil.a("install report,install success:" + z);
        com.gigaset.update.f.a.a(context, z, z ? 413 : 414, (String) null);
    }

    private static void c(Context context, boolean z) {
        int a2 = o.a(context, "ota_install_fail_count", 0);
        if (z) {
            return;
        }
        o.b(context, "ota_install_fail_count", a2 + 1);
    }
}
