package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
/* compiled from: CardViewBaseImpl.java */
/* loaded from: classes.dex */
class f implements h {

    /* renamed from: a  reason: collision with root package name */
    final RectF f381a = new RectF();

    private j j(g gVar) {
        return (j) gVar.b();
    }

    @Override // androidx.cardview.widget.h
    public void a() {
        j.f385b = new e(this);
    }

    @Override // androidx.cardview.widget.h
    public void b(g gVar, float f) {
        j(gVar).c(f);
    }

    @Override // androidx.cardview.widget.h
    public ColorStateList c(g gVar) {
        return j(gVar).a();
    }

    @Override // androidx.cardview.widget.h
    public float d(g gVar) {
        return j(gVar).d();
    }

    @Override // androidx.cardview.widget.h
    public void e(g gVar) {
        j(gVar).a(gVar.c());
        h(gVar);
    }

    @Override // androidx.cardview.widget.h
    public float f(g gVar) {
        return j(gVar).f();
    }

    @Override // androidx.cardview.widget.h
    public void g(g gVar) {
    }

    @Override // androidx.cardview.widget.h
    public void h(g gVar) {
        Rect rect = new Rect();
        j(gVar).a(rect);
        gVar.a((int) Math.ceil(i(gVar)), (int) Math.ceil(d(gVar)));
        gVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.h
    public float i(g gVar) {
        return j(gVar).e();
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        j a2 = a(context, colorStateList, f, f2, f3);
        a2.a(gVar.c());
        gVar.a(a2);
        h(gVar);
    }

    @Override // androidx.cardview.widget.h
    public float b(g gVar) {
        return j(gVar).c();
    }

    @Override // androidx.cardview.widget.h
    public void c(g gVar, float f) {
        j(gVar).b(f);
        h(gVar);
    }

    private j a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new j(context.getResources(), colorStateList, f, f2, f3);
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, ColorStateList colorStateList) {
        j(gVar).a(colorStateList);
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, float f) {
        j(gVar).a(f);
        h(gVar);
    }

    @Override // androidx.cardview.widget.h
    public float a(g gVar) {
        return j(gVar).b();
    }
}
