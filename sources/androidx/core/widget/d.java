package androidx.core.widget;
/* compiled from: ContentLoadingProgressBar.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ContentLoadingProgressBar f562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f562a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f562a;
        contentLoadingProgressBar.f550b = false;
        contentLoadingProgressBar.f549a = -1L;
        contentLoadingProgressBar.setVisibility(8);
    }
}
