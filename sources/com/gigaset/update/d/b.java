package com.gigaset.update.d;

import android.content.Context;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Install.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1112a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1113b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str) {
        this.f1112a = context;
        this.f1113b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (d.a()) {
                com.gigaset.update.h.d.a().b(this.f1112a, this.f1113b);
            } else if (com.gigaset.update.h.d.a().a(this.f1112a, this.f1113b) <= 0) {
                LogUtil.a("install execute error!");
                org.greenrobot.eventbus.e.a().b(new EventMessage(300, 414, 0L, 0L, null));
                com.gigaset.update.f.a.a(this.f1112a, false, 415, (String) null);
            }
        } catch (Exception e) {
            LogUtil.a("install exception : " + e.getMessage());
        }
    }
}
