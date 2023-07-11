package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0087a;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public class C implements C0087a.InterfaceC0021a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f758a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(RecyclerView recyclerView) {
        this.f758a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public RecyclerView.v a(int i) {
        RecyclerView.v a2 = this.f758a.a(i, true);
        if (a2 == null || this.f758a.o.c(a2.f807b)) {
            return null;
        }
        return a2;
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public void b(int i, int i2) {
        this.f758a.a(i, i2, false);
        this.f758a.ta = true;
    }

    void c(C0087a.b bVar) {
        int i = bVar.f820a;
        if (i == 1) {
            RecyclerView recyclerView = this.f758a;
            recyclerView.w.a(recyclerView, bVar.f821b, bVar.d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.f758a;
            recyclerView2.w.b(recyclerView2, bVar.f821b, bVar.d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.f758a;
            recyclerView3.w.a(recyclerView3, bVar.f821b, bVar.d, bVar.c);
        } else if (i != 8) {
        } else {
            RecyclerView recyclerView4 = this.f758a;
            recyclerView4.w.a(recyclerView4, bVar.f821b, bVar.d, 1);
        }
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public void d(int i, int i2) {
        this.f758a.a(i, i2, true);
        RecyclerView recyclerView = this.f758a;
        recyclerView.ta = true;
        recyclerView.qa.d += i2;
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public void a(int i, int i2, Object obj) {
        this.f758a.a(i, i2, obj);
        this.f758a.ua = true;
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public void b(C0087a.b bVar) {
        c(bVar);
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public void a(C0087a.b bVar) {
        c(bVar);
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public void a(int i, int i2) {
        this.f758a.g(i, i2);
        this.f758a.ta = true;
    }

    @Override // androidx.recyclerview.widget.C0087a.InterfaceC0021a
    public void c(int i, int i2) {
        this.f758a.f(i, i2);
        this.f758a.ta = true;
    }
}
