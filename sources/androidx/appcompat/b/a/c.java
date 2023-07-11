package androidx.appcompat.b.a;
/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f129a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f129a.a(true);
        this.f129a.invalidateSelf();
    }
}
