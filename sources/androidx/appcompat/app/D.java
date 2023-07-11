package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
class D implements Toolbar.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E f74a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(E e) {
        this.f74a = e;
    }

    @Override // androidx.appcompat.widget.Toolbar.b
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f74a.c.onMenuItemSelected(0, menuItem);
    }
}
