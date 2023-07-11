package org.greenrobot.eventbus;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncPoster.java */
/* loaded from: classes.dex */
public class a implements Runnable, n {

    /* renamed from: a  reason: collision with root package name */
    private final m f1491a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final e f1492b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e eVar) {
        this.f1492b = eVar;
    }

    @Override // org.greenrobot.eventbus.n
    public void a(s sVar, Object obj) {
        this.f1491a.a(l.a(sVar, obj));
        this.f1492b.b().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        l a2 = this.f1491a.a();
        if (a2 != null) {
            this.f1492b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
