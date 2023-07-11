package com.gigaset.update;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.gigaset.update.receiver.MyReceiver;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.n;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
/* loaded from: classes.dex */
public class MyApplication extends Application {

    /* renamed from: a  reason: collision with root package name */
    protected static Context f1070a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1071b = false;
    private static com.gigaset.update.a.b c;
    private PhoneStateListener d = new l(this);

    public static Context c() {
        return f1070a;
    }

    public static boolean d() {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = f1070a.getPackageManager().getApplicationInfo(com.gigaset.update.b.a.c, 0);
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null;
    }

    public static boolean e() {
        return f1071b;
    }

    public static void f() {
        c = null;
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        registerReceiver(new MyReceiver(), intentFilter);
    }

    private void h() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(this.d, 32);
        }
    }

    private void i() {
        new com.gigaset.update.h.e().a(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f1070a = getApplicationContext();
        LogUtil.a("appVersion = " + n.b(this) + ".0.222208.006_2023-02-15 11:29");
        try {
            androidx.appcompat.app.n.d(-1);
            i();
            g();
            com.gigaset.update.utils.l.b();
            h();
            t.f(this);
            com.gigaset.update.utils.b.a().a(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String d = o.d(this, "check_url");
        if (!TextUtils.isEmpty(d) && !d.equals("https://mobileupdate.gigaset.com")) {
            o.b(f1070a, "check_url", "https://mobileupdate.gigaset.com");
        }
        com.gigaset.update.manager.i.t();
    }

    public static void a(com.gigaset.update.a.b bVar) {
        c = bVar;
    }
}
