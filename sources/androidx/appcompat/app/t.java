package androidx.appcompat.app;

import android.view.View;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class t extends androidx.core.h.B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f117a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(u uVar) {
        this.f117a = uVar;
    }

    @Override // androidx.core.h.A
    public void b(View view) {
        this.f117a.f118a.q.setAlpha(1.0f);
        this.f117a.f118a.t.a((androidx.core.h.A) null);
        this.f117a.f118a.t = null;
    }

    @Override // androidx.core.h.B, androidx.core.h.A
    public void c(View view) {
        this.f117a.f118a.q.setVisibility(0);
    }
}
