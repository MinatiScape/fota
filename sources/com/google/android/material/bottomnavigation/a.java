package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
/* compiled from: BottomNavigationMenu.java */
/* loaded from: classes.dex */
public final class a extends l {
    public a(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.view.menu.l
    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 <= 5) {
            s();
            MenuItem a2 = super.a(i, i2, i3, charSequence);
            if (a2 instanceof p) {
                ((p) a2).c(true);
            }
            r();
            return a2;
        }
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.l, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
