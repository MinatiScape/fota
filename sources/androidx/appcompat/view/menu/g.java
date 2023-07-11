package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.i;
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i.a f170a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MenuItem f171b;
    final /* synthetic */ l c;
    final /* synthetic */ h d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, i.a aVar, MenuItem menuItem, l lVar) {
        this.d = hVar;
        this.f170a = aVar;
        this.f171b = menuItem;
        this.c = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a aVar = this.f170a;
        if (aVar != null) {
            this.d.f172a.B = true;
            aVar.f175b.a(false);
            this.d.f172a.B = false;
        }
        if (this.f171b.isEnabled() && this.f171b.hasSubMenu()) {
            this.c.a(this.f171b, 4);
        }
    }
}
