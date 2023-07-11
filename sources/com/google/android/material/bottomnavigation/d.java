package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.l;
import com.google.android.material.bottomnavigation.BottomNavigationView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BottomNavigationView.java */
/* loaded from: classes.dex */
public class d implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomNavigationView f1296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BottomNavigationView bottomNavigationView) {
        this.f1296a = bottomNavigationView;
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void a(l lVar) {
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean a(l lVar, MenuItem menuItem) {
        BottomNavigationView.a aVar;
        BottomNavigationView.b bVar;
        BottomNavigationView.b bVar2;
        BottomNavigationView.a aVar2;
        aVar = this.f1296a.f;
        if (aVar == null || menuItem.getItemId() != this.f1296a.getSelectedItemId()) {
            bVar = this.f1296a.e;
            if (bVar != null) {
                bVar2 = this.f1296a.e;
                if (!bVar2.a(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        aVar2 = this.f1296a.f;
        aVar2.a(menuItem);
        return true;
    }
}
