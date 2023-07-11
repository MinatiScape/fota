package androidx.appcompat.widget;
/* compiled from: ActionBarOverlayLayout.java */
/* renamed from: androidx.appcompat.widget.e  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0046e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f320a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0046e(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f320a = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f320a.a();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f320a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY(0.0f).setListener(this.f320a.y);
    }
}
