package com.gigaset.update.utils;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StorageUtil.java */
/* loaded from: classes.dex */
public class r extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context) {
        this.f1182a = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        t.g(this.f1182a);
    }
}
