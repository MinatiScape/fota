package com.gigaset.update.c;

import android.content.Context;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.f.e;
import com.gigaset.update.manager.g;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.k;
import com.gigaset.update.utils.o;
/* compiled from: DownVersion.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f1108a;

    /* renamed from: b  reason: collision with root package name */
    private int f1109b = 0;

    private d() {
    }

    public static d b() {
        if (f1108a == null) {
            synchronized (d.class) {
                if (f1108a == null) {
                    f1108a = new d();
                }
            }
        }
        return f1108a;
    }

    private boolean g(Context context) {
        boolean c = k.c(context);
        int c2 = com.gigaset.update.b.d.c(context);
        if (h(context)) {
            return false;
        }
        boolean b2 = b(context, c, false);
        LogUtil.a("isAutoDown= " + b2 + "; version_status= " + c2);
        return (c2 == 1 || c2 == 3) && b2;
    }

    private boolean h(Context context) {
        try {
            int b2 = o.b(context, "ota_install_fail_count");
            if (b2 >= 5) {
                if (e.a().a(context, "cause_install_fail_5", 21600000L)) {
                    com.gigaset.update.f.a.a(context, "cause_install_fail_5", 0L);
                }
                LogUtil.a("updatefailcount = " + b2 + ", return true!!!");
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(Context context, int i) {
        synchronized (d.class) {
            if (c.b().e()) {
                int c = com.gigaset.update.b.d.c(context);
                LogUtil.a("version_status = " + c);
                if (c != 3) {
                    LogUtil.a("downloading package ");
                    com.gigaset.update.f.a.a(context, "cause_downloading", 0L);
                    return;
                }
            } else {
                LogUtil.a("mDown == null; flag = " + i);
            }
            com.gigaset.update.b.d.a(context, 2);
            if (i == 1) {
                LogUtil.a("download AUTO");
            }
            this.f1109b = i;
            c.b().a();
        }
    }

    public boolean c(Context context) {
        return c.b().e() && com.gigaset.update.b.d.c(context) == 2;
    }

    public void d(Context context) {
        a(context);
        com.gigaset.update.b.d.d(context);
    }

    public void e(Context context) {
        if (com.gigaset.update.e.c.a().c() == null) {
            return;
        }
        if (c(context)) {
            boolean c = k.c(context);
            boolean b2 = b(context, c, true);
            LogUtil.a("isAutoDown= " + b2);
            if (b2 || c) {
                return;
            }
            com.gigaset.update.f.a.a(context, "cause_net_change_downloading", 0L);
            f(context);
            org.greenrobot.eventbus.e.a().b(new EventMessage(200, 5001, 0L, 0L, null));
            return;
        }
        CustomActionService.a(context, 9);
    }

    public void f(Context context) {
        synchronized (this) {
            LogUtil.a("pause");
            c.b().b(context);
            g.f(context);
        }
    }

    private boolean b(Context context, boolean z, boolean z2) {
        int intValue;
        try {
            intValue = ((Integer) com.gigaset.update.e.c.a().a("download_auto", Integer.class)).intValue();
            LogUtil.a("autoDownload = " + intValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intValue == 2) {
            return false;
        }
        if (intValue == 1) {
            return a(z);
        }
        if (intValue == 0) {
            return a(context, z, z2);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.c.d.b(android.content.Context):void");
    }

    public int a() {
        return this.f1109b;
    }

    public void a(Context context) {
        synchronized (this) {
            LogUtil.a("");
            c.b().a(context);
            g.e(context);
        }
    }

    private boolean a(boolean z) {
        boolean booleanValue = ((Boolean) com.gigaset.update.e.c.a().a("install_forced", Boolean.class)).booleanValue();
        boolean booleanValue2 = ((Boolean) com.gigaset.update.e.c.a().a("download_wifi", Boolean.class)).booleanValue();
        boolean booleanValue3 = ((Boolean) com.gigaset.update.e.c.a().a("download_auto", Boolean.class)).booleanValue();
        LogUtil.a("isForced = " + booleanValue + "; isForcedWifi = " + booleanValue2 + "; autoDownload = " + booleanValue3);
        if ((booleanValue || booleanValue3) && !booleanValue2) {
            return true;
        }
        return (booleanValue || booleanValue3) && z;
    }

    private boolean a(Context context, boolean z, boolean z2) {
        boolean a2 = o.a(context, "download_wifi_auto", com.gigaset.update.utils.c.k().u());
        boolean a3 = o.a(context, "download_only_wifi", com.gigaset.update.utils.c.k().y());
        int c = com.gigaset.update.b.d.c(context);
        LogUtil.a("isWifi = " + z + "; isWifiAuto = " + a2 + "; isOnlyWifi = " + a3);
        if (z2 || c == 2) {
            if (!z) {
                return false;
            }
        } else if (!a2 || !z) {
            return false;
        }
        return true;
    }
}
