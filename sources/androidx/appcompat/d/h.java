package androidx.appcompat.d;

import android.view.View;
import androidx.core.h.A;
import androidx.core.h.B;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
class h extends B {

    /* renamed from: a  reason: collision with root package name */
    private boolean f150a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f151b = 0;
    final /* synthetic */ i c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar) {
        this.c = iVar;
    }

    void a() {
        this.f151b = 0;
        this.f150a = false;
        this.c.b();
    }

    @Override // androidx.core.h.A
    public void b(View view) {
        int i = this.f151b + 1;
        this.f151b = i;
        if (i == this.c.f152a.size()) {
            A a2 = this.c.d;
            if (a2 != null) {
                a2.b(null);
            }
            a();
        }
    }

    @Override // androidx.core.h.B, androidx.core.h.A
    public void c(View view) {
        if (this.f150a) {
            return;
        }
        this.f150a = true;
        A a2 = this.c.d;
        if (a2 != null) {
            a2.c(null);
        }
    }
}
