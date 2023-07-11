package com.gigaset.update.manager;

import android.content.Context;
import android.net.Uri;
import com.gigaset.update.MyApplication;
import com.gigaset.update.utils.o;
/* compiled from: SpManager.java */
/* loaded from: classes.dex */
public class i {
    public static void a() {
        o.b(u(), "upgrade_later_times", o.a(u(), "upgrade_later_times", 0) + 1);
    }

    public static void b(long j) {
        o.b(u(), "download_use_time", j + g());
    }

    public static void c(String str) {
        o.b(u(), "task_id", str);
    }

    public static void d() {
        o.b(u(), "download_use_time", 0L);
    }

    public static int e() {
        return o.a(u(), "download_percent", 0);
    }

    public static long f() {
        return o.a(u(), "download_start_time", 0L);
    }

    public static long g() {
        return o.a(u(), "download_use_time", 0L);
    }

    public static String h() {
        return o.d(u(), "fcmId");
    }

    public static String[] i() {
        return o.a(u(), "job_schedule_downloading_time", "60#1440").split("#");
    }

    public static String[] j() {
        return o.a(u(), "job_schedule_time", "5#1440").split("#");
    }

    public static String k() {
        return o.d(u(), "task_id");
    }

    public static boolean l() {
        return o.a(u(), "reject_status", false);
    }

    public static long m() {
        return o.a(u(), "stop_log_out_time", 0L);
    }

    public static boolean n() {
        return o.a(u(), "upgrade_check_status", false);
    }

    public static boolean o() {
        return o.a(u(), "no_report", false);
    }

    public static boolean p() {
        return o.a(u(), "upgrade_later_times", 0) > 1;
    }

    public static boolean q() {
        return MyApplication.d() && l();
    }

    public static void r() {
        o.b(u(), "upgrade_later_times", 0);
    }

    public static void s() {
        c(0L);
    }

    public static void t() {
        if (MyApplication.d()) {
            b(Boolean.valueOf(u().getContentResolver().getType(Uri.parse("content://com.gigaset.privacypolicy.MyContentProvider/reject_status"))).booleanValue());
        }
        o.b(u(), "connect_net", (MyApplication.d() && l()) ? false : true);
    }

    private static Context u() {
        return MyApplication.c();
    }

    public static void b() {
        c();
        d();
    }

    public static void c(long j) {
        o.b(u(), "stop_log_out_time", j);
    }

    public static void c(boolean z) {
        o.b(u(), "upgrade_check_status", z);
    }

    public static void a(long j) {
        o.b(u(), "download_start_time", j);
    }

    public static void b(String str) {
        o.b(u(), "job_schedule_time", str);
    }

    public static void c() {
        a(0L);
    }

    public static void a(String str) {
        o.b(u(), "job_schedule_downloading_time", str);
    }

    public static void b(boolean z) {
        o.b(u(), "reject_status", z);
    }

    public static void a(boolean z) {
        o.b(u(), "no_report", z);
    }

    public static void a(int i) {
        o.b(u(), "download_percent", i);
    }
}
