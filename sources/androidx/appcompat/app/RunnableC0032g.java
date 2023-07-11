package androidx.appcompat.app;

import android.view.View;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.g  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0032g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f99a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f100b;
    final /* synthetic */ AlertController c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0032g(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f99a = view;
        this.f100b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.a(this.c.g, this.f99a, this.f100b);
    }
}
