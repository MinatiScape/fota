package androidx.appcompat.widget;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class Q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(SearchView searchView) {
        this.f278a = searchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c.a.a aVar = this.f278a.R;
        if (aVar == null || !(aVar instanceof ba)) {
            return;
        }
        aVar.changeCursor(null);
    }
}
