package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class s implements ContentFrameLayout.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f116a = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void a() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void onDetachedFromWindow() {
        this.f116a.l();
    }
}
