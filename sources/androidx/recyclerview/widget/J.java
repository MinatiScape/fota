package androidx.recyclerview.widget;
/* compiled from: StaggeredGridLayoutManager.java */
/* loaded from: classes.dex */
class J implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StaggeredGridLayoutManager f763a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f763a = staggeredGridLayoutManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f763a.F();
    }
}
