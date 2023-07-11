package com.gigaset.update.utils;

import android.content.Context;
import android.os.Process;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StorageUtil.java */
/* loaded from: classes.dex */
public class s extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1183a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f1184b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str, Context context) {
        this.f1183a = str;
        this.f1184b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        LogUtil.a("filePath = " + this.f1183a);
        t.a(t.a(this.f1184b, false));
        t.b(new File(this.f1183a));
        t.j(this.f1184b);
    }
}
