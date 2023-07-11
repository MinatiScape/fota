package com.gigaset.update;

import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleOtaClient.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1125a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1126b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ GoogleOtaClient e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GoogleOtaClient googleOtaClient, String str, String str2, String str3, String str4) {
        this.e = googleOtaClient;
        this.f1125a = str;
        this.f1126b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        com.gigaset.update.utils.g.a(this.f1125a, this.f1126b, (Boolean) false);
        com.gigaset.update.utils.g.a(this.c, this.d, (Boolean) false);
    }
}
