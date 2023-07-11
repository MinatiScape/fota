package com.gigaset.update.manager;

import android.os.Build;
import com.gigaset.update.MyApplication;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.view.FloatingView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NoticeManager.java */
/* loaded from: classes.dex */
public class e implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            LogUtil.a("popupwindow");
            FloatingView.a(MyApplication.c());
            if (Build.VERSION.SDK_INT >= 26) {
                FloatingView.b();
            }
        } catch (IllegalStateException unused) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
