package androidx.fragment.app;

import androidx.fragment.app.r;
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r.a f644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(r.a aVar) {
        this.f644a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f644a.f647b.setLayerType(0, null);
    }
}
