package androidx.appcompat.widget;

import android.view.View;
/* compiled from: ActivityChooserView.java */
/* renamed from: androidx.appcompat.widget.m  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0054m extends H {
    final /* synthetic */ ActivityChooserView j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0054m(ActivityChooserView activityChooserView, View view) {
        super(view);
        this.j = activityChooserView;
    }

    @Override // androidx.appcompat.widget.H
    public androidx.appcompat.view.menu.z a() {
        return this.j.getListPopupWindow();
    }

    @Override // androidx.appcompat.widget.H
    protected boolean b() {
        this.j.c();
        return true;
    }

    @Override // androidx.appcompat.widget.H
    protected boolean c() {
        this.j.a();
        return true;
    }
}
