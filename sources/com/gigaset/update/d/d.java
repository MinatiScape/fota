package com.gigaset.update.d;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.manager.h;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.n;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
import com.gigaset.update.utils.u;
import java.io.File;
import java.util.Calendar;
/* compiled from: Install.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1115a = false;

    public static void b(Context context) {
        int i;
        if (!a()) {
            LogUtil.a("not support ab update,no need force_reboot");
            return;
        }
        String[] a2 = com.gigaset.update.e.c.a().a("install_time");
        if (com.gigaset.update.b.d.c(context) != 6) {
            com.gigaset.update.f.a.a(context, "reboot_cause_not_dlcomplete");
        } else if (((Boolean) com.gigaset.update.e.c.a().a("install_forced", Boolean.class)).booleanValue()) {
            int i2 = 0;
            try {
                int intValue = Integer.valueOf(a2[0]).intValue();
                i = Integer.valueOf(a2[1]).intValue();
                if (intValue > i) {
                    i += 24;
                }
                i2 = intValue;
            } catch (Exception unused) {
                i = 24;
            }
            int a3 = a(i2, i);
            if (!com.gigaset.update.utils.c.k().h(context) && a3 == 0) {
                LogUtil.a("[force_update] time arrive start force update");
                com.gigaset.update.f.a.a(context, "auto_reboot");
                com.gigaset.update.h.d.a().a(context);
                return;
            }
            com.gigaset.update.f.a.a(context, "reboot_cause_not_right_time");
            a(context, a3, i2, i);
        } else {
            com.gigaset.update.f.a.a(context, "cause_not_force_reboot");
        }
    }

    public static void c(Context context) {
        int i;
        String[] a2 = com.gigaset.update.e.c.a().a("install_time");
        if (com.gigaset.update.b.d.c(context) != 4) {
            LogUtil.a("no force update reason : status not correct");
            com.gigaset.update.f.a.a(context, "cause_not_dlcomplete");
            return;
        }
        int i2 = 0;
        try {
            int intValue = Integer.valueOf(a2[0]).intValue();
            i = Integer.valueOf(a2[1]).intValue();
            if (intValue > i) {
                i += 24;
            }
            i2 = intValue;
        } catch (Exception unused) {
            i = 24;
        }
        int a3 = a(i2, i);
        if (f(context) && a3 == 0) {
            LogUtil.a("time arrive start force update");
            com.gigaset.update.f.a.a(context, "auto");
            e(context);
            return;
        }
        LogUtil.a("no force update reason : ota battery low or no in hour range");
        com.gigaset.update.f.a.a(context, "cause_not_right_time");
        b(context, a3, i2, i);
    }

    public static void d(Context context) {
        if (com.gigaset.update.b.d.c(context) == 4) {
            int intValue = ((Integer) com.gigaset.update.e.c.a().a("install_notice_type", Integer.class)).intValue();
            boolean booleanValue = ((Boolean) com.gigaset.update.e.c.a().a("install_notice_resident", Boolean.class)).booleanValue();
            LogUtil.a("installDelay notice : notice_type = " + intValue + "; notice_resident = " + booleanValue);
            if (intValue == 0) {
                h.a().b(context, booleanValue);
            } else if (intValue == 2) {
                com.gigaset.update.manager.g.b(context, 4);
            }
            if (intValue != 3) {
                long c = o.c(context, "ota_install_delay_schedule");
                if (c > 0) {
                    com.gigaset.update.manager.b.a(context, c + System.currentTimeMillis());
                }
            }
        }
    }

    public static void e(Context context) {
        if (n.a(Process.myUid()) != 0) {
            LogUtil.a("no update reason : not system user");
        } else if (f1115a) {
            com.gigaset.update.f.a.a(context, "cause_installing");
        } else {
            if (a()) {
                org.greenrobot.eventbus.e.a().b(new EventMessage(300, 100, 0L, 5L, "ab"));
            }
            f1115a = true;
            LogUtil.a("ota install update start");
            new Thread(new c(context)).start();
        }
    }

    private static boolean f(Context context) {
        int f = com.gigaset.update.utils.c.k().f(context);
        boolean h = com.gigaset.update.utils.c.k().h(context);
        int b2 = com.gigaset.update.utils.c.k().b();
        LogUtil.a("realBattery = " + f + "; limitBattery = " + b2 + "; isScreenOn = " + h);
        return f >= b2 && (!h || com.gigaset.update.utils.c.k().z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context) {
        a fVar;
        int i;
        if (a()) {
            org.greenrobot.eventbus.e.a().b(new EventMessage(300, 100, 0L, 602L, "ab"));
        }
        VersionBean c = com.gigaset.update.e.c.a().c();
        String sha = c != null ? c.getSha() : null;
        if (TextUtils.isEmpty(sha)) {
            fVar = new g();
        } else {
            fVar = new f();
        }
        try {
            i = fVar.a(context, t.d(context), sha);
        } catch (Exception unused) {
            com.gigaset.update.f.a.a(context, "cause_verify_exception");
            i = 0;
        }
        LogUtil.a("verify package status = " + i);
        if (i == 405) {
            String d = t.d(context);
            File file = new File("/data/media/0/gigasetfota/update.zip");
            File file2 = new File("/data/media/gigasetfota/update.zip");
            File file3 = new File("/storage/emulated/0/gigasetfota/update.zip");
            t.a(t.a(context, false));
            if (Build.VERSION.SDK_INT >= 21) {
                if (file.exists()) {
                    LogUtil.a("update1File = " + file.getPath());
                    if (com.gigaset.update.utils.g.a("/data/media/0/gigasetfota/update.zip", com.gigaset.update.b.a.e, (Boolean) true)) {
                        d = com.gigaset.update.b.a.e;
                    }
                } else if (file2.exists()) {
                    LogUtil.a("update2File = " + file2.getPath());
                    if (com.gigaset.update.utils.g.a("/data/media/gigasetfota/update.zip", com.gigaset.update.b.a.e, (Boolean) true)) {
                        d = com.gigaset.update.b.a.e;
                    }
                } else if (file3.exists()) {
                    LogUtil.a("update4File = " + file3.getPath());
                    if (com.gigaset.update.utils.g.a("/storage/emulated/0/gigasetfota/update.zip", com.gigaset.update.b.a.e, (Boolean) true)) {
                        d = com.gigaset.update.b.a.e;
                    }
                } else {
                    d = t.d(context);
                }
            } else {
                d = t.d(context);
            }
            LogUtil.a("updatePath = " + d);
            if (c != null) {
                o.b(context, "ota_update_version", c.getVersionName());
                o.b(context, "ota_install_result_pop", ((Boolean) com.gigaset.update.e.c.a().a("install_result_pop", Boolean.class)).booleanValue());
                o.b(context, "notifyFlag", ((Integer) com.gigaset.update.e.c.a().a("query_notice_type", Integer.class)).intValue());
            }
            o.b(context, "ota_update_local", false);
            a(context, d);
        } else {
            LogUtil.a("no install reason : status not correct");
            com.gigaset.update.manager.g.c(context, 1);
            com.gigaset.update.e.c.a().a(context);
            com.gigaset.update.f.a.a(context, false, i, fVar.a());
        }
        org.greenrobot.eventbus.e.a().b(new EventMessage(300, i, 0L, 0L, null));
    }

    public static void a(Context context, String str) {
        if (!a()) {
            com.gigaset.update.b.d.a(context, 6);
            h.a().a(context, 105);
            int i = Build.VERSION.SDK_INT;
            if (i > 23 && i < 29) {
                u.b("recovery_from_third", 1);
            } else {
                o.b(context, "ota_enter_recovery", true);
            }
        }
        o.b(context, "ota_original_version", com.gigaset.update.utils.c.k().l());
        LogUtil.a("update file path = " + str);
        t.f(context);
        new Thread(new b(context, str)).start();
    }

    public static boolean a() {
        return com.gigaset.update.utils.c.k().F();
    }

    private static int a(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        int i3 = calendar.get(11);
        int i4 = calendar.get(1);
        int i5 = calendar.get(2) + 1;
        int i6 = calendar.get(5);
        String[] a2 = com.gigaset.update.e.c.a().a("install_date");
        LogUtil.a(a2[0] + "11111111111111111" + a2.length);
        if (a2[0].equals("0")) {
            LogUtil.a("startTime = " + i + "; endTime = " + i2 + "; hour = " + i3);
            if (i3 < i) {
                return -1;
            }
            return i3 >= i2 ? 1 : 0;
        }
        String[] split = a2[0].split("-");
        String[] split2 = a2[1].split("-");
        int intValue = Integer.valueOf(split[0]).intValue();
        int intValue2 = Integer.valueOf(split[1]).intValue();
        int intValue3 = Integer.valueOf(split[2]).intValue();
        int intValue4 = Integer.valueOf(split2[0]).intValue();
        int intValue5 = Integer.valueOf(split[1]).intValue();
        int intValue6 = Integer.valueOf(split[2]).intValue();
        if (intValue > i4 && intValue4 < i4) {
            LogUtil.a("autoupdate year =" + intValue + "now year = " + i4);
            return 0;
        } else if (intValue2 > i5 && intValue5 < i5) {
            LogUtil.a("autoupdate mounth =" + intValue2 + "now mounth = " + i5);
            return 0;
        } else if (intValue3 > i6 && intValue6 < i6) {
            LogUtil.a("autoupdate day =" + intValue3 + "now data = " + i6);
            return 0;
        } else {
            LogUtil.a("startTime = " + i + "; endTime = " + i2 + "; hour = " + i3);
            if (i3 < i) {
                return -1;
            }
            return i3 >= i2 ? 1 : 0;
        }
    }

    private static void b(Context context, int i, int i2, int i3) {
        LogUtil.a("isHourRange = " + i + "; startTime = " + i2 + "; endTime = " + i3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if (i == -1) {
            calendar.set(11, i2);
            calendar.set(12, 0);
        } else if (i == 1) {
            calendar.add(5, 1);
            calendar.set(11, i2);
            calendar.set(12, 0);
        } else {
            calendar.set(12, calendar.get(12) + 10);
        }
        LogUtil.a("force time " + calendar.getTimeInMillis());
        com.gigaset.update.manager.b.b(context, calendar.getTimeInMillis());
    }

    public static boolean b(Context context, String str) {
        VersionBean c = com.gigaset.update.e.c.a().c();
        if (c == null || c.getIsOldPkg() != 1) {
            double d = com.gigaset.update.utils.g.d(str);
            Double.isNaN(d);
            return 3 == t.d(context, (long) (d * 1.5d));
        }
        return true;
    }

    private static void a(Context context, int i, int i2, int i3) {
        LogUtil.a("[forceRebootAlarm] isHourRange,startTime,endTime ===" + i + "||" + i2 + "||" + i3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if (i == -1) {
            calendar.set(11, i2);
            calendar.set(12, 0);
        } else if (i == 1) {
            calendar.add(5, 1);
            calendar.set(11, i2);
            calendar.set(12, 0);
        } else {
            calendar.set(12, calendar.get(12) + 10);
        }
        LogUtil.a("[forceUpdateAlarm] force time " + calendar.getTimeInMillis());
        com.gigaset.update.manager.b.c(context, calendar.getTimeInMillis());
    }

    public static boolean a(Context context, int i) {
        return com.gigaset.update.utils.c.k().f(context) >= i;
    }
}
