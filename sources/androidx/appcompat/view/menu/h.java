package androidx.appcompat.view.menu;

import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.widget.K;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public class h implements K {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar) {
        this.f172a = iVar;
    }

    @Override // androidx.appcompat.widget.K
    public void a(l lVar, MenuItem menuItem) {
        this.f172a.h.removeCallbacksAndMessages(null);
        int size = this.f172a.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (lVar == this.f172a.j.get(i).f175b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        this.f172a.h.postAtTime(new g(this, i2 < this.f172a.j.size() ? this.f172a.j.get(i2) : null, menuItem, lVar), lVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.K
    public void b(l lVar, MenuItem menuItem) {
        this.f172a.h.removeCallbacksAndMessages(lVar);
    }
}
