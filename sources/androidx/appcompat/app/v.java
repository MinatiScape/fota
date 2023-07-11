package androidx.appcompat.app;

import android.view.View;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class v extends androidx.core.h.B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f119a = appCompatDelegateImpl;
    }

    @Override // androidx.core.h.A
    public void b(View view) {
        this.f119a.q.setAlpha(1.0f);
        this.f119a.t.a((androidx.core.h.A) null);
        this.f119a.t = null;
    }

    @Override // androidx.core.h.B, androidx.core.h.A
    public void c(View view) {
        this.f119a.q.setVisibility(0);
        this.f119a.q.sendAccessibilityEvent(32);
        if (this.f119a.q.getParent() instanceof View) {
            androidx.core.h.t.D((View) this.f119a.q.getParent());
        }
    }
}
