package androidx.fragment.app;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Fragment.java */
/* renamed from: androidx.fragment.app.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0073c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0073c(Fragment fragment) {
        this.f630a = fragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f630a.a();
    }
}
