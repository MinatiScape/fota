package com.gigaset.update.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* compiled from: CrashHandler.java */
/* loaded from: classes.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static b f1165a;

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f1166b;
    private Context c;
    private Map<String, String> d = new HashMap();
    private DateFormat e = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    private b() {
    }

    public static b a() {
        if (f1165a == null) {
            f1165a = new b();
        }
        return f1165a;
    }

    private void b(Context context) {
        Field[] declaredFields;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                this.d.put("versionName", packageInfo.versionName == null ? "null" : packageInfo.versionName);
                this.d.put("versionCode", packageInfo.versionCode + "");
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("CrashHandler", "an error occured when collect package info", e);
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.d.put(field.getName(), field.get(null).toString());
                Log.d("CrashHandler", field.getName() + " : " + field.get(null));
            } catch (Exception e2) {
                Log.e("CrashHandler", "an error occured when collect crash info", e2);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (!a(th) && (uncaughtExceptionHandler = this.f1166b) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            Log.e("CrashHandler", "error : ", e);
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public void a(Context context) {
        this.c = context;
        this.f1166b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        try {
            b(this.c);
            b(th);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void b(Throwable th) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.d.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String stringWriter2 = stringWriter.toString();
        LogUtil.a("result=" + stringWriter2);
        sb.append(stringWriter2);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String str = "crash-" + this.e.format(new Date()) + "-" + currentTimeMillis + ".txt";
            if (Environment.getExternalStorageState().equals("mounted")) {
                String str2 = this.c.getExternalFilesDir("").getAbsolutePath() + "/crash/";
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str2 + str);
                fileOutputStream.write(sb.toString().getBytes());
                fileOutputStream.close();
            }
        } catch (Exception e) {
            Log.e("CrashHandler", "an error occured while writing file...", e);
        }
    }
}
