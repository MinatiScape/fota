package androidx.core.widget;
/* compiled from: ContentLoadingProgressBar.java */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContentLoadingProgressBar f563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f563a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f563a;
        contentLoadingProgressBar.c = false;
        if (contentLoadingProgressBar.d) {
            return;
        }
        contentLoadingProgressBar.f549a = System.currentTimeMillis();
        this.f563a.setVisibility(0);
    }
}
