package com.gigaset.update.utils;

import android.util.Log;
import com.gigaset.update.MyApplication;
/* loaded from: classes.dex */
public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1161a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1162b = false;
    private static String c = "";

    public static void a(String str) {
        e(str);
        a("FotaUpdate", str, null, 'd');
    }

    public static void b(String str) {
        e(str);
        a("FotaUpdate", str, null);
    }

    public static void c(String str) {
        c = str;
    }

    private static String d(String str) {
        e(str);
        String a2 = a();
        if (a2 == null) {
            return str;
        }
        return a2 + " -> " + str;
    }

    private static String e(String str) {
        return str;
    }

    public static void a(boolean z, String str) {
        e(str);
        if (z) {
            a("FotaUpdate", d(str), null, 'd');
        }
        if (f1162b) {
            String str2 = c;
            g.b(str2, "FotaUpdate: " + d(str));
        }
    }

    public static void b(boolean z) {
        f1162b = z;
    }

    public static void a(String str, String str2, Throwable th) {
        e(str2);
        a(str, str2, th, 'e');
    }

    private static void a(String str, String str2, Throwable th, char c2) {
        e(str2);
        if (f1162b || f1161a || g.c(MyApplication.c())) {
            if ('e' == c2) {
                Log.e(str, d(str2), th);
            } else if ('w' == c2) {
                Log.w(str, d(str2), th);
            } else if ('d' == c2) {
                Log.d(str, d(str2), th);
            } else if ('i' == c2) {
                Log.i(str, d(str2), th);
            } else {
                Log.v(str, d(str2), th);
            }
            if (f1162b) {
                String str3 = c;
                g.b(str3, str + ": " + d(str2));
            }
        }
    }

    private static String a() {
        StackTraceElement[] stackTrace;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getFileName().equals("LogUtil.java")) {
                return "[" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "] " + stackTraceElement.getMethodName();
            }
        }
        return null;
    }

    public static void a(boolean z) {
        f1161a = z;
    }
}
