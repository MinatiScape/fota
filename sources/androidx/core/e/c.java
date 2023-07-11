package androidx.core.e;

import android.os.Handler;
import androidx.core.content.a.h;
import androidx.core.e.f;
import androidx.core.e.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class c implements k.a<f.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h.a f454a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Handler f455b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(h.a aVar, Handler handler) {
        this.f454a = aVar;
        this.f455b = handler;
    }

    @Override // androidx.core.e.k.a
    public void a(f.c cVar) {
        if (cVar == null) {
            this.f454a.a(1, this.f455b);
            return;
        }
        int i = cVar.f464b;
        if (i == 0) {
            this.f454a.a(cVar.f463a, this.f455b);
        } else {
            this.f454a.a(i, this.f455b);
        }
    }
}
