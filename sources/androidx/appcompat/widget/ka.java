package androidx.appcompat.widget;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class ka implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Toolbar f339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ka(Toolbar toolbar) {
        this.f339a = toolbar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f339a.k();
    }
}
