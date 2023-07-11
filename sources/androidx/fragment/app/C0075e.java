package androidx.fragment.app;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Fragment.java */
/* renamed from: androidx.fragment.app.e  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0075e implements androidx.lifecycle.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0075e(Fragment fragment) {
        this.f632a = fragment;
    }

    @Override // androidx.lifecycle.h
    public androidx.lifecycle.f getLifecycle() {
        Fragment fragment = this.f632a;
        if (fragment.V == null) {
            fragment.V = new androidx.lifecycle.j(fragment.W);
        }
        return this.f632a.V;
    }
}
