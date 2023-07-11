package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0031f implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f97a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f98b;
    final /* synthetic */ AlertController c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0031f(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f97a = view;
        this.f98b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.a(absListView, this.f97a, this.f98b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
