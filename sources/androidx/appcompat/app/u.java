package androidx.appcompat.app;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f118a = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f118a;
        appCompatDelegateImpl.r.showAtLocation(appCompatDelegateImpl.q, 55, 0, 0);
        this.f118a.m();
        if (this.f118a.t()) {
            this.f118a.q.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl2 = this.f118a;
            androidx.core.h.z a2 = androidx.core.h.t.a(appCompatDelegateImpl2.q);
            a2.a(1.0f);
            appCompatDelegateImpl2.t = a2;
            this.f118a.t.a(new t(this));
            return;
        }
        this.f118a.q.setAlpha(1.0f);
        this.f118a.q.setVisibility(0);
    }
}
