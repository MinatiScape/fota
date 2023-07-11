package com.google.android.material.internal;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavigationMenuPresenter.java */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1377a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar) {
        this.f1377a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1377a.a(true);
        androidx.appcompat.view.menu.p itemData = ((NavigationMenuItemView) view).getItemData();
        k kVar = this.f1377a;
        boolean a2 = kVar.d.a(itemData, kVar, 0);
        if (itemData != null && itemData.isCheckable() && a2) {
            this.f1377a.f.a(itemData);
        }
        this.f1377a.a(false);
        this.f1377a.updateMenuView(false);
    }
}
