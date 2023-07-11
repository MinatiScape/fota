package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
/* compiled from: BaseMenuWrapper.java */
/* renamed from: androidx.appcompat.view.menu.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0039c<T> extends C0040d<T> {

    /* renamed from: b  reason: collision with root package name */
    final Context f166b;
    private Map<androidx.core.b.a.b, MenuItem> c;
    private Map<androidx.core.b.a.c, SubMenu> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0039c(Context context, T t) {
        super(t);
        this.f166b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (menuItem instanceof androidx.core.b.a.b) {
            androidx.core.b.a.b bVar = (androidx.core.b.a.b) menuItem;
            if (this.c == null) {
                this.c = new a.b.b();
            }
            MenuItem menuItem2 = this.c.get(menuItem);
            if (menuItem2 == null) {
                MenuItem a2 = x.a(this.f166b, bVar);
                this.c.put(bVar, a2);
                return a2;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        Map<androidx.core.b.a.b, MenuItem> map = this.c;
        if (map != null) {
            map.clear();
        }
        Map<androidx.core.b.a.c, SubMenu> map2 = this.d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        Map<androidx.core.b.a.b, MenuItem> map = this.c;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof androidx.core.b.a.c) {
            androidx.core.b.a.c cVar = (androidx.core.b.a.c) subMenu;
            if (this.d == null) {
                this.d = new a.b.b();
            }
            SubMenu subMenu2 = this.d.get(cVar);
            if (subMenu2 == null) {
                SubMenu a2 = x.a(this.f166b, cVar);
                this.d.put(cVar, a2);
                return a2;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        Map<androidx.core.b.a.b, MenuItem> map = this.c;
        if (map == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }
}
