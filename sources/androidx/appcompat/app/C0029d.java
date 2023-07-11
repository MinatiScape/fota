package androidx.appcompat.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.d  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0029d implements NestedScrollView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f93a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f94b;
    final /* synthetic */ AlertController c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0029d(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f93a = view;
        this.f94b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        AlertController.a(nestedScrollView, this.f93a, this.f94b);
    }
}
