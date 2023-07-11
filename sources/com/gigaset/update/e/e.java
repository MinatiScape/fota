package com.gigaset.update.e;

import android.content.Context;
import android.os.Process;
import com.gigaset.update.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueryVersion.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1119a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f1120b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, Context context) {
        this.f1120b = gVar;
        this.f1119a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        LogUtil.a("thread start");
        this.f1120b.e(this.f1119a);
        com.gigaset.update.manager.b.d(this.f1119a);
        LogUtil.a("thread end");
    }
}
