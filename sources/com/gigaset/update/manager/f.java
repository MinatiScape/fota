package com.gigaset.update.manager;

import android.os.Handler;
import android.os.Looper;
/* compiled from: NoticeManager.java */
/* loaded from: classes.dex */
class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f1159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Runnable runnable) {
        this.f1159a = runnable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        new Handler(Looper.getMainLooper()).post(this.f1159a);
    }
}
