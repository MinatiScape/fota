package androidx.recyclerview.widget;

import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public class A implements N.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(RecyclerView recyclerView) {
        this.f756a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.N.b
    public void a(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f756a.a(vVar, cVar, cVar2);
    }

    @Override // androidx.recyclerview.widget.N.b
    public void b(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f756a.l.c(vVar);
        this.f756a.b(vVar, cVar, cVar2);
    }

    @Override // androidx.recyclerview.widget.N.b
    public void c(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        vVar.a(false);
        RecyclerView recyclerView = this.f756a;
        if (recyclerView.N) {
            if (recyclerView.W.a(vVar, vVar, cVar, cVar2)) {
                this.f756a.s();
            }
        } else if (recyclerView.W.c(vVar, cVar, cVar2)) {
            this.f756a.s();
        }
    }

    @Override // androidx.recyclerview.widget.N.b
    public void a(RecyclerView.v vVar) {
        RecyclerView recyclerView = this.f756a;
        recyclerView.w.a(vVar.f807b, recyclerView.l);
    }
}
