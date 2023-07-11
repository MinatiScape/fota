package com.gigaset.update.h;

import android.os.UpdateEngine;
import android.os.UpdateEngineCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Recovery.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1138a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar) {
        this.f1138a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateEngine updateEngine;
        UpdateEngineCallback updateEngineCallback;
        updateEngine = this.f1138a.c;
        updateEngineCallback = this.f1138a.f;
        updateEngine.bind(updateEngineCallback);
    }
}
