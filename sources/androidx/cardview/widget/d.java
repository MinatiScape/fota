package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
/* compiled from: CardViewApi21Impl.java */
/* loaded from: classes.dex */
class d implements h {
    private i j(g gVar) {
        return (i) gVar.b();
    }

    @Override // androidx.cardview.widget.h
    public void a() {
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        gVar.a(new i(colorStateList, f));
        View d = gVar.d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        c(gVar, f3);
    }

    @Override // androidx.cardview.widget.h
    public float b(g gVar) {
        return j(gVar).b();
    }

    @Override // androidx.cardview.widget.h
    public void c(g gVar, float f) {
        j(gVar).a(f, gVar.a(), gVar.c());
        h(gVar);
    }

    @Override // androidx.cardview.widget.h
    public float d(g gVar) {
        return a(gVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.h
    public void e(g gVar) {
        c(gVar, b(gVar));
    }

    @Override // androidx.cardview.widget.h
    public float f(g gVar) {
        return gVar.d().getElevation();
    }

    @Override // androidx.cardview.widget.h
    public void g(g gVar) {
        c(gVar, b(gVar));
    }

    @Override // androidx.cardview.widget.h
    public void h(g gVar) {
        if (!gVar.a()) {
            gVar.a(0, 0, 0, 0);
            return;
        }
        float b2 = b(gVar);
        float a2 = a(gVar);
        int ceil = (int) Math.ceil(j.a(b2, a2, gVar.c()));
        int ceil2 = (int) Math.ceil(j.b(b2, a2, gVar.c()));
        gVar.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.h
    public float i(g gVar) {
        return a(gVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.h
    public void b(g gVar, float f) {
        gVar.d().setElevation(f);
    }

    @Override // androidx.cardview.widget.h
    public ColorStateList c(g gVar) {
        return j(gVar).a();
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, float f) {
        j(gVar).a(f);
    }

    @Override // androidx.cardview.widget.h
    public float a(g gVar) {
        return j(gVar).c();
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, ColorStateList colorStateList) {
        j(gVar).a(colorStateList);
    }
}
