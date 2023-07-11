package a.b;

import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
class c<E> extends h<E, E> {
    final /* synthetic */ d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.d = dVar;
    }

    @Override // a.b.h
    protected Object a(int i, int i2) {
        return this.d.h[i];
    }

    @Override // a.b.h
    protected int b(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // a.b.h
    protected int c() {
        return this.d.i;
    }

    @Override // a.b.h
    protected int a(Object obj) {
        return this.d.indexOf(obj);
    }

    @Override // a.b.h
    protected Map<E, E> b() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // a.b.h
    protected void a(E e, E e2) {
        this.d.add(e);
    }

    @Override // a.b.h
    protected E a(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // a.b.h
    protected void a(int i) {
        this.d.b(i);
    }

    @Override // a.b.h
    protected void a() {
        this.d.clear();
    }
}
