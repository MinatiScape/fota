package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class ja implements ActionMenuView.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Toolbar f337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ja(Toolbar toolbar) {
        this.f337a = toolbar;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.d
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toolbar.b bVar = this.f337a.G;
        if (bVar != null) {
            return bVar.onMenuItemClick(menuItem);
        }
        return false;
    }
}
