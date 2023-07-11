package androidx.recyclerview.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(RecyclerView recyclerView) {
        this.f864a = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.f864a;
        if (!recyclerView.E || recyclerView.isLayoutRequested()) {
            return;
        }
        RecyclerView recyclerView2 = this.f864a;
        if (!recyclerView2.B) {
            recyclerView2.requestLayout();
        } else if (recyclerView2.H) {
            recyclerView2.G = true;
        } else {
            recyclerView2.b();
        }
    }
}
