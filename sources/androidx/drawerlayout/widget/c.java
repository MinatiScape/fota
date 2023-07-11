package androidx.drawerlayout.widget;

import androidx.drawerlayout.widget.DrawerLayout;
/* compiled from: DrawerLayout.java */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DrawerLayout.d f585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DrawerLayout.d dVar) {
        this.f585a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f585a.a();
    }
}
