package androidx.appcompat.app;

import android.view.View;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class q implements androidx.core.h.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f114a = appCompatDelegateImpl;
    }

    @Override // androidx.core.h.o
    public androidx.core.h.D a(View view, androidx.core.h.D d) {
        int e = d.e();
        int j = this.f114a.j(e);
        if (e != j) {
            d = d.a(d.c(), j, d.d(), d.b());
        }
        return androidx.core.h.t.b(view, d);
    }
}
