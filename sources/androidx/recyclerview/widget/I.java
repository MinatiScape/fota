package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class I extends RecyclerView.f {
    boolean g = true;

    public abstract boolean a(RecyclerView.v vVar, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar != null && (cVar.f788a != cVar2.f788a || cVar.f789b != cVar2.f789b)) {
            return a(vVar, cVar.f788a, cVar.f789b, cVar2.f788a, cVar2.f789b);
        }
        return f(vVar);
    }

    public abstract boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b(RecyclerView.v vVar) {
        return !this.g || vVar.n();
    }

    public void c(RecyclerView.v vVar, boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean c(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.f788a == cVar2.f788a && cVar.f789b == cVar2.f789b) {
            j(vVar);
            return false;
        }
        return a(vVar, cVar.f788a, cVar.f789b, cVar2.f788a, cVar2.f789b);
    }

    public void d(RecyclerView.v vVar, boolean z) {
    }

    public abstract boolean f(RecyclerView.v vVar);

    public abstract boolean g(RecyclerView.v vVar);

    public final void h(RecyclerView.v vVar) {
        n(vVar);
        c(vVar);
    }

    public final void i(RecyclerView.v vVar) {
        o(vVar);
    }

    public final void j(RecyclerView.v vVar) {
        p(vVar);
        c(vVar);
    }

    public final void k(RecyclerView.v vVar) {
        q(vVar);
    }

    public final void l(RecyclerView.v vVar) {
        r(vVar);
        c(vVar);
    }

    public final void m(RecyclerView.v vVar) {
        s(vVar);
    }

    public void n(RecyclerView.v vVar) {
    }

    public void o(RecyclerView.v vVar) {
    }

    public void p(RecyclerView.v vVar) {
    }

    public void q(RecyclerView.v vVar) {
    }

    public void r(RecyclerView.v vVar) {
    }

    public void s(RecyclerView.v vVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i = cVar.f788a;
        int i2 = cVar.f789b;
        View view = vVar.f807b;
        int left = cVar2 == null ? view.getLeft() : cVar2.f788a;
        int top = cVar2 == null ? view.getTop() : cVar2.f789b;
        if (!vVar.p() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a(vVar, i, i2, left, top);
        }
        return g(vVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f788a;
        int i4 = cVar.f789b;
        if (vVar2.x()) {
            int i5 = cVar.f788a;
            i2 = cVar.f789b;
            i = i5;
        } else {
            i = cVar2.f788a;
            i2 = cVar2.f789b;
        }
        return a(vVar, vVar2, i3, i4, i, i2);
    }

    public final void a(RecyclerView.v vVar, boolean z) {
        c(vVar, z);
        c(vVar);
    }

    public final void b(RecyclerView.v vVar, boolean z) {
        d(vVar, z);
    }
}
