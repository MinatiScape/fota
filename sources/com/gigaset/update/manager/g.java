package com.gigaset.update.manager;

import android.content.Context;
import android.content.Intent;
import com.gigaset.update.GoogleOtaClient;
import com.gigaset.update.R;
import com.gigaset.update.activity.PopupActivity;
import com.gigaset.update.utils.LogUtil;
/* compiled from: NoticeManager.java */
/* loaded from: classes.dex */
public class g {
    public static void a(Context context) {
        boolean booleanValue = ((Boolean) com.gigaset.update.e.c.a().a("install_forced", Boolean.class)).booleanValue();
        LogUtil.a("force_install = " + booleanValue);
        if (booleanValue) {
            Intent intent = new Intent(context, PopupActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("status", 8);
            context.startActivity(intent);
        }
    }

    public static void b(Context context) {
    }

    public static void b(Context context, int i) {
        if (i.p()) {
            LogUtil.a("already remind over two times");
            com.gigaset.update.d.d.c(context.getApplicationContext());
        } else if (!a.b().c()) {
            LogUtil.a("forward PopupActivity");
            a.b().a();
            if (a.b().a(GoogleOtaClient.class)) {
                return;
            }
            new f(new e()).start();
        } else {
            LogUtil.a("GoogleOtaClient on the top");
        }
    }

    public static void c(Context context) {
    }

    public static void c(Context context, int i) {
        LogUtil.a("updateShortcut,flag=" + i);
        if (i == 1) {
            c(context);
        } else if (i != 2) {
        } else {
            b(context);
        }
    }

    public static void d(Context context) {
        int intValue = ((Integer) com.gigaset.update.e.c.a().a("install_notice_type", Integer.class)).intValue();
        boolean booleanValue = ((Boolean) com.gigaset.update.e.c.a().a("install_notice_resident", Boolean.class)).booleanValue();
        LogUtil.a("download notice : notice_type = " + intValue + "||notice_resident = " + booleanValue + "||isSupportAbUpdate = " + com.gigaset.update.utils.c.k().F());
        if (com.gigaset.update.b.d.c(context) == 4 && !com.gigaset.update.utils.c.k().F()) {
            if (intValue == 0) {
                h.a().b(context, booleanValue);
            }
            b(context, 4);
        } else if (com.gigaset.update.b.d.c(context) != 6 || intValue == 3) {
        } else {
            h.a().a(context, 105);
            h.a().a(context, booleanValue);
        }
    }

    public static void e(Context context) {
        h.a().a(context, R.string.appbar_scrolling_view_behavior);
    }

    public static void f(Context context) {
        h.a().c(context, false);
    }

    public static void g(Context context) {
        int intValue = ((Integer) com.gigaset.update.e.c.a().a("query_notice_type", Integer.class)).intValue();
        boolean booleanValue = ((Boolean) com.gigaset.update.e.c.a().a("query_notice_resident", Boolean.class)).booleanValue();
        int c = com.gigaset.update.b.d.c(context);
        LogUtil.a("query notice : notice_type = " + intValue + "; notice_resident = " + booleanValue);
        if (intValue == 0) {
            if (c == 4) {
                h.a().b(context, booleanValue);
            } else {
                h.a().d(context, booleanValue);
            }
        } else if (intValue == 1) {
            c(context, 2);
        } else if (intValue != 2) {
        } else {
            if (c == 4) {
                b(context, 4);
            } else {
                b(context, 1);
            }
        }
    }

    public static void a(Context context, int i) {
        if (i == 1) {
            Intent intent = new Intent(context, GoogleOtaClient.class);
            intent.addFlags(335544320);
            context.startActivity(intent);
        }
    }
}
