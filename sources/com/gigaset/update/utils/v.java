package com.gigaset.update.utils;

import android.os.Build;
import android.widget.Toast;
import com.gigaset.update.MyApplication;
/* compiled from: ToastUtil.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f1190a;

    private static Toast a() {
        if (f1190a == null) {
            f1190a = Toast.makeText(MyApplication.c(), (CharSequence) null, 0);
        }
        return f1190a;
    }

    public static void a(String str) {
        try {
            if (Build.VERSION.SDK_INT > 30) {
                Toast.makeText(MyApplication.c(), str, 0).show();
            } else {
                Toast a2 = a();
                a2.setText(str);
                a2.show();
            }
        } catch (Exception e) {
            LogUtil.a("showToast,Exception e=" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void a(int i) {
        a(MyApplication.c().getString(i));
    }
}
