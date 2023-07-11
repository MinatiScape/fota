package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MenuWrapperICS.java */
/* loaded from: classes.dex */
public class y extends AbstractC0039c<androidx.core.b.a.a> implements Menu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context, androidx.core.b.a.a aVar) {
        super(context, aVar);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(((androidx.core.b.a.a) this.f167a).add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = ((androidx.core.b.a.a) this.f167a).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((androidx.core.b.a.a) this.f167a).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        b();
        ((androidx.core.b.a.a) this.f167a).clear();
    }

    @Override // android.view.Menu
    public void close() {
        ((androidx.core.b.a.a) this.f167a).close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return a(((androidx.core.b.a.a) this.f167a).findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return a(((androidx.core.b.a.a) this.f167a).getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((androidx.core.b.a.a) this.f167a).hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((androidx.core.b.a.a) this.f167a).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return ((androidx.core.b.a.a) this.f167a).performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((androidx.core.b.a.a) this.f167a).performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        a(i);
        ((androidx.core.b.a.a) this.f167a).removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        b(i);
        ((androidx.core.b.a.a) this.f167a).removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((androidx.core.b.a.a) this.f167a).setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ((androidx.core.b.a.a) this.f167a).setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        ((androidx.core.b.a.a) this.f167a).setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        ((androidx.core.b.a.a) this.f167a).setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return ((androidx.core.b.a.a) this.f167a).size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(((androidx.core.b.a.a) this.f167a).add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return a(((androidx.core.b.a.a) this.f167a).addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(((androidx.core.b.a.a) this.f167a).add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((androidx.core.b.a.a) this.f167a).addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(((androidx.core.b.a.a) this.f167a).add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((androidx.core.b.a.a) this.f167a).addSubMenu(i, i2, i3, i4));
    }
}
