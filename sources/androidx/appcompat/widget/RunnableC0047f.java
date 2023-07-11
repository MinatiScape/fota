package androidx.appcompat.widget;
/* compiled from: ActionBarOverlayLayout.java */
/* renamed from: androidx.appcompat.widget.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0047f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f321a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0047f(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f321a = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f321a.a();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f321a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY(-this.f321a.e.getHeight()).setListener(this.f321a.y);
    }
}
