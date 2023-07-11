package com.gigaset.update.utils;

import android.content.ContentResolver;
import android.provider.Settings;
import com.gigaset.update.MyApplication;
/* compiled from: SystemSettingUtil.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static ContentResolver f1189a;

    private static ContentResolver a() {
        if (f1189a == null) {
            f1189a = MyApplication.c().getContentResolver();
        }
        return f1189a;
    }

    public static void b(String str, int i) {
        Settings.Global.putInt(a(), str, i);
    }

    public static int a(String str, int i) {
        return Settings.Global.getInt(a(), str, i);
    }
}
