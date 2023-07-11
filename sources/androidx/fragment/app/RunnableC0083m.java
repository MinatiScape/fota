package androidx.fragment.app;

import android.view.View;
/* compiled from: FragmentManager.java */
/* renamed from: androidx.fragment.app.m  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0083m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f638a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0083m(n nVar) {
        this.f638a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f638a.c.e() != null) {
            this.f638a.c.a((View) null);
            n nVar = this.f638a;
            r rVar = nVar.d;
            Fragment fragment = nVar.c;
            rVar.a(fragment, fragment.v(), 0, 0, false);
        }
    }
}
