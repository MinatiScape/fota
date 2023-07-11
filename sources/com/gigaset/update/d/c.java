package com.gigaset.update.d;

import android.content.Context;
import com.gigaset.update.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Install.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f1114a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (com.gigaset.update.e.c.a().c() != null) {
                LogUtil.a("ota install normal ");
                d.g(this.f1114a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.a("update exception : " + e.getMessage());
            com.gigaset.update.f.a.a(this.f1114a, "cause_exception");
        }
        boolean unused = d.f1115a = false;
    }
}
