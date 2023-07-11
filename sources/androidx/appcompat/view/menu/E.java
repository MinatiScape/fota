package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubMenuWrapperICS.java */
/* loaded from: classes.dex */
public class E extends y implements SubMenu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public E(Context context, androidx.core.b.a.c cVar) {
        super(context, cVar);
    }

    public androidx.core.b.a.c c() {
        return (androidx.core.b.a.c) this.f167a;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        c().clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return a(c().getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        c().setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        c().setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        c().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        c().setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        c().setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        c().setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        c().setIcon(drawable);
        return this;
    }
}
