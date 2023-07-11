package androidx.appcompat.widget;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class P implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(SearchView searchView) {
        this.f277a = searchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f277a.i();
    }
}
