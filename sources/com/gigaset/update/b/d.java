package com.gigaset.update.b;

import android.content.Context;
import android.text.TextUtils;
import com.gigaset.update.R;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.e.g;
import com.gigaset.update.manager.h;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
import com.gigaset.update.utils.u;
import java.io.File;
import org.greenrobot.eventbus.e;
/* compiled from: Status.java */
/* loaded from: classes.dex */
public class d {
    public static void a(Context context, VersionBean versionBean) {
        if (com.gigaset.update.e.c.a().c() == null) {
            LogUtil.a("version empty");
            return;
        }
        LogUtil.a("version exist");
        a(context, 1);
        o.b(context, "ota_original_version", com.gigaset.update.utils.c.k().l());
        o.b(context, "ota_update_version", versionBean.getVersionName());
        o.b(context, "ota_update_type", g.a().b());
        h.a().a(context, R.string.appbar_scrolling_view_behavior);
        a((String) com.gigaset.update.e.c.a().a("download_path", String.class));
        com.gigaset.update.manager.g.g(context);
        CustomActionService.a(context, 9);
    }

    public static void b(Context context) {
        boolean booleanValue = ((Boolean) com.gigaset.update.e.c.a().a("install_forced", Boolean.class)).booleanValue();
        LogUtil.a("download_completed_instal,force_install = " + booleanValue);
        if (!com.gigaset.update.d.d.a()) {
            if (booleanValue) {
                com.gigaset.update.d.d.c(context);
                return;
            }
            LogUtil.a("no update reason : not support ab update and no force install");
            com.gigaset.update.f.a.a(context, "cause_not_force_upgrade");
        } else if (com.gigaset.update.d.d.a(context, com.gigaset.update.utils.c.k().b())) {
            com.gigaset.update.f.a.a(context, "auto");
            com.gigaset.update.d.d.e(context.getApplicationContext());
        } else {
            LogUtil.a("no update reason : battery not enough");
            CustomActionService.a(context, 15);
            com.gigaset.update.f.a.a(context, "cause_not_right_time");
            e.a().b(new EventMessage(300, 100, 0L, 617L, "ab"));
        }
    }

    public static int c(Context context) {
        return o.a(context, "ota_update_status", 0);
    }

    public static void d(Context context) {
        com.gigaset.update.f.a.a(context, "cancel", 0L);
        com.gigaset.update.e.c.a().a(context);
    }

    public static void e(Context context) {
        com.gigaset.update.utils.g.a(context.getFilesDir().getPath() + "/shared_prefs");
        d(context);
    }

    public static void f(Context context) {
        LogUtil.a(" ");
        e.a().b(new EventMessage(200, 1001, 0L, 0L, null));
        o.b(context, "ota_install_delay_schedule", 0L);
        a(context, 4);
        h.a().a(context, R.string.appbar_scrolling_view_behavior);
        com.gigaset.update.manager.g.d(context);
        com.gigaset.update.manager.g.a(context);
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("#")) {
            return;
        }
        String[] split = str.split("#");
        if (split.length == 3) {
            t.a(split[0], split[1], split[2]);
            LogUtil.a("ota download path :path[0]=" + split[0] + ",path[1]=" + split[1] + ",path[2]=" + split[2]);
        }
    }

    public static void a(Context context) {
        int c = c(context);
        LogUtil.a("downloadCompleteTask,status=" + c);
        if (c == 4) {
            b(context);
        } else if (c != 5) {
            if (c == 6) {
                com.gigaset.update.d.d.b(context);
            }
        } else if (o.a(context, "ota_update_local", false)) {
            String a2 = o.a(context, "ota_update_local_path", "");
            if (!TextUtils.isEmpty(a2) && new File(a2).exists()) {
                com.gigaset.update.h.d.a().b(context, a2);
            } else {
                d(context);
            }
        } else {
            com.gigaset.update.h.d.a().b(context, t.d(context));
        }
    }

    public static void a(Context context, int i) {
        o.b(context, "ota_update_status", i);
        u.b("ota_update_status", i);
    }
}
