package androidx.appcompat.app;

import android.view.View;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.e  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0030e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f95a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f96b;
    final /* synthetic */ AlertController c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0030e(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f95a = view;
        this.f96b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.a(this.c.A, this.f95a, this.f96b);
    }
}
