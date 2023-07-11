package com.gigaset.update.e;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.j;
import com.gigaset.update.utils.k;
import com.gigaset.update.utils.l;
import com.gigaset.update.utils.n;
import com.gigaset.update.utils.o;
/* compiled from: QueryVersion.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f1123a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1124b;
    private boolean c;
    private int d;
    private int e = 1;

    private g() {
    }

    private boolean c(Context context) {
        return o.a(context, "check_last_time", 0L) + com.gigaset.update.manager.b.b(context) <= System.currentTimeMillis();
    }

    private boolean d(Context context) {
        int b2 = o.b(context, "check_fail_counts");
        if (b2 >= 3) {
            o.b(context, "check_fail_counts", -1);
            return true;
        }
        o.b(context, "check_fail_counts", b2 + 1);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        try {
            try {
                LogUtil.a("onQueryTask:start");
                org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1009, 0L, 0L, null));
                j.a(context);
                if (com.gigaset.update.b.d.c(context) == 0) {
                    c.a().a(context);
                }
                g(context);
                if (this.d == 2) {
                    SystemClock.sleep(500L);
                }
                String str = "";
                String a2 = o.a(context, "check_url", "https://mobileupdate.gigaset.com");
                if (this.e == 1) {
                    str = a2 + "/gigaset-ota-inter/gigfota/gigDetectSchedule.do";
                } else if (this.e == 2) {
                    str = a2 + "/gigaset-ota-inter/gigfota/gigFullDetectSchedule.do";
                }
                com.gigaset.update.g.e a3 = com.gigaset.update.g.c.a(context, str, this.d);
                LogUtil.a("query result : http status code = " + a3.d() + " error_code = " + a3.a() + " error_message = " + a3.b());
                com.gigaset.update.f.a.a(context, this.d, this.e, a3);
                new a().a(context, a3);
                a(context, a3, a2);
            } catch (Exception e) {
                LogUtil.a(e.toString());
                e.printStackTrace();
                if (context.getFilesDir() == null) {
                    com.gigaset.update.f.a.a(context, "cause_not_enough", 0L);
                    org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3005, 0L, 0L, null));
                } else {
                    org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3010, 0L, 0L, null));
                }
            }
        } finally {
            this.c = false;
        }
    }

    private void f(Context context) {
        new Thread(new e(this, context)).start();
    }

    private void g(Context context) {
        if (!o.a(context, "rom_damaged", false) || o.a(context, "rom_damaged_version", "FOTA").equals(com.gigaset.update.utils.c.k().l())) {
            return;
        }
        o.b(context, "rom_damaged", false);
        o.a(context, "rom_damaged_version", "FOTA");
    }

    private void h(Context context) {
        new Thread(new f(this, context)).start();
    }

    public int b() {
        return this.e;
    }

    public static g a() {
        if (f1123a == null) {
            synchronized (g.class) {
                if (f1123a == null) {
                    f1123a = new g();
                }
            }
        }
        return f1123a;
    }

    public void b(Context context) {
        LogUtil.a("onQueryScheduleTask");
        this.e = 1;
        a(context, 1, this.e);
    }

    private boolean b(Context context, VersionBean versionBean) {
        if (versionBean == null) {
            LogUtil.a("version == null");
            return false;
        }
        try {
            String a2 = o.a(context, "deltaurl", "");
            String deltaUrl = versionBean.getDeltaUrl();
            if (TextUtils.isEmpty(deltaUrl) || a2.equals(deltaUrl)) {
                return false;
            }
            LogUtil.a("isChangeDeltaUrl = true");
            o.b(context, "deltaurl", deltaUrl);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(Context context, boolean z) {
        if (z) {
            com.gigaset.update.manager.b.d(context);
        }
        boolean a2 = k.a(context);
        boolean c = c(context);
        boolean b2 = b.b(context);
        if (n.a(Process.myUid()) != 0) {
            LogUtil.a("onQuerySchedule,not system user,return");
            return;
        }
        LogUtil.a("isOverSchedule = " + c + "; isConnected = " + a2 + "; isOverActivateTime = " + b2);
        if (b2 && a2 && c) {
            o.b(context, "query_to_download", true);
            b(context);
            h(context);
        }
    }

    public void a(Context context, int i, int i2) {
        LogUtil.a("query_type = " + i + "; isQuerying = " + this.c);
        synchronized (this) {
            if (this.c) {
                return;
            }
            this.c = true;
            this.d = i;
            this.e = i2;
            f(context);
        }
    }

    public void a(Context context, int i) {
        a(context, i, 1);
    }

    private void a(Context context, com.gigaset.update.g.e eVar, String str) {
        if (eVar == null) {
            return;
        }
        if (eVar.e()) {
            o.b(context, "check_last_time", System.currentTimeMillis());
            return;
        }
        f1124b++;
        if (f1124b >= 3) {
            f1124b = 0;
            o.b(context, "check_last_time", System.currentTimeMillis());
        }
        l.b();
        a(context, str);
    }

    private void a(Context context, String str) {
        if (d(context)) {
            if (TextUtils.isEmpty(str)) {
                o.b(context, "check_url", "https://mobileupdate.gigaset.com");
            } else if ("https://mobileupdate.gigaset.com".equals(str)) {
                o.b(context, "check_url", "https://mobileupdate.gigaset.com");
            } else {
                o.b(context, "check_url", "https://mobileupdate.gigaset.com");
            }
        }
    }

    public boolean a(Context context, VersionBean versionBean) {
        if (this.e == 1) {
            boolean a2 = o.a(context, "rom_damaged", false);
            boolean b2 = b(context, versionBean);
            boolean z = o.a(context, "isupgrade", 0) == 1;
            LogUtil.a("isDamaged = " + a2 + "; urlChanged = " + b2);
            if (b2) {
                o.b(context, "rom_damaged", false);
                return false;
            } else if (z) {
                return a2;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean a(Context context) {
        boolean z = o.a(context, "ota_update_type", 1) == 2;
        LogUtil.a("isFullUpdate = " + z);
        return z;
    }
}
