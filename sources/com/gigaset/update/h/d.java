package com.gigaset.update.h;

import android.content.Context;
import android.os.PowerManager;
import android.os.RecoverySystem;
import android.os.UpdateEngine;
import android.os.UpdateEngineCallback;
import android.text.TextUtils;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.manager.g;
import com.gigaset.update.manager.h;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
import java.io.File;
/* compiled from: Recovery.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f1142a;
    private Context d;
    private String e;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1143b = false;
    private UpdateEngine c = null;
    private UpdateEngineCallback f = new b(this);

    private d() {
    }

    public void b(Context context, String str) {
        LogUtil.a("recovery ab path : " + str);
        a(str);
        this.d = context;
        this.e = str;
        LogUtil.a("engine = " + this.c);
        if (this.c == null) {
            this.f1143b = false;
            this.c = new UpdateEngine();
            new Thread(new a(this)).start();
        } else if (com.gigaset.update.b.d.c(this.d) < 5) {
            this.f1143b = false;
            a(this.d, this.e, this.c);
        }
    }

    public static d a() {
        if (f1142a == null) {
            synchronized (d.class) {
                if (f1142a == null) {
                    f1142a = new d();
                }
            }
        }
        return f1142a;
    }

    public int a(Context context, String str) {
        try {
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            LogUtil.a("package path empty");
            return 0;
        }
        LogUtil.a("recovery path : " + str);
        File file = new File(str);
        if (file.exists()) {
            LogUtil.a("go to update system");
            RecoverySystem.installPackage(context, file);
            LogUtil.a("still running after update system");
        } else {
            LogUtil.a("package file not exist");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        LogUtil.a("abSuccess enter");
        com.gigaset.update.b.d.a(context, 6);
        org.greenrobot.eventbus.e.a().b(new EventMessage(300, 0, 0L, 601L, "ab"));
        o.b(context, "ota_enter_recovery", true);
        com.gigaset.update.d.d.b(context);
        if (o.a(context, "ota_update_local", false) || ((Integer) com.gigaset.update.e.c.a().a("install_notice_type", Integer.class)).intValue() != 3) {
            LogUtil.a("show reboot notify");
            h.a().a(context, 105);
            h.a().a(context, false);
        }
    }

    private void a(String str) {
        try {
            String str2 = "chmod 666 " + str;
            LogUtil.a("command = " + str2);
            if (Runtime.getRuntime().exec(str2).waitFor() == 0) {
                LogUtil.a("chmod success!");
            } else {
                LogUtil.a("chmod fail!");
            }
        } catch (Exception unused) {
            LogUtil.a("chmod fail!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, UpdateEngine updateEngine) {
        LogUtil.a("abUpdate enter");
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            new Thread(new c(this, str, context, updateEngine)).start();
            return;
        }
        LogUtil.a("executeAb,path is not valid");
        a(context, 620, false);
    }

    public void a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            LogUtil.a("reboot,update system");
            powerManager.reboot("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, boolean z) {
        LogUtil.a("abFail,errCode = " + i + ",isComplete = " + z);
        if (i == 20) {
            o.b(context, "rom_damaged", true);
        }
        com.gigaset.update.b.d.a(context, 0);
        com.gigaset.update.e.c.a().a(context);
        g.c(context, 1);
        com.gigaset.update.f.a.a(context, false, i, "ab");
        if (z) {
            org.greenrobot.eventbus.e.a().b(new EventMessage(300, i, 0L, 601L, "ab"));
        } else {
            org.greenrobot.eventbus.e.a().b(new EventMessage(300, 100, 0L, i, "ab"));
        }
        UpdateEngine updateEngine = this.c;
        if (updateEngine != null) {
            updateEngine.resetStatus();
        }
    }
}
