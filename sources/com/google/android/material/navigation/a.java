package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.l;
import com.google.android.material.navigation.NavigationView;
/* compiled from: NavigationView.java */
/* loaded from: classes.dex */
class a implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationView f1394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NavigationView navigationView) {
        this.f1394a = navigationView;
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void a(l lVar) {
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean a(l lVar, MenuItem menuItem) {
        NavigationView.a aVar = this.f1394a.h;
        return aVar != null && aVar.a(menuItem);
    }
}
