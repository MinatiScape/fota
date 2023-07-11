package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
/* compiled from: NavigationMenu.java */
/* loaded from: classes.dex */
public class h extends androidx.appcompat.view.menu.l {
    public h(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.l, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        androidx.appcompat.view.menu.p pVar = (androidx.appcompat.view.menu.p) a(i, i2, i3, charSequence);
        l lVar = new l(e(), this, pVar);
        pVar.a(lVar);
        return lVar;
    }
}
