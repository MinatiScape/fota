package com.google.android.material.bottomnavigation;

import android.view.View;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomNavigationMenuView.java */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomNavigationMenuView f1295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f1295a = bottomNavigationMenuView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        BottomNavigationPresenter bottomNavigationPresenter;
        p itemData = ((BottomNavigationItemView) view).getItemData();
        lVar = this.f1295a.z;
        bottomNavigationPresenter = this.f1295a.y;
        if (lVar.a(itemData, bottomNavigationPresenter, 0)) {
            return;
        }
        itemData.setChecked(true);
    }
}
