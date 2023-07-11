package androidx.core.e;
/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f466a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f467b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, Object obj) {
        this.f467b = iVar;
        this.f466a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f467b.c.a(this.f466a);
    }
}
