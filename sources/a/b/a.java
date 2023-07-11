package a.b;

import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
class a<K, V> extends h<K, V> {
    final /* synthetic */ b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.d = bVar;
    }

    @Override // a.b.h
    protected Object a(int i, int i2) {
        return this.d.f[(i << 1) + i2];
    }

    @Override // a.b.h
    protected int b(Object obj) {
        return this.d.b(obj);
    }

    @Override // a.b.h
    protected int c() {
        return this.d.g;
    }

    @Override // a.b.h
    protected int a(Object obj) {
        return this.d.a(obj);
    }

    @Override // a.b.h
    protected Map<K, V> b() {
        return this.d;
    }

    @Override // a.b.h
    protected void a(K k, V v) {
        this.d.put(k, v);
    }

    @Override // a.b.h
    protected V a(int i, V v) {
        return this.d.a(i, (int) v);
    }

    @Override // a.b.h
    protected void a(int i) {
        this.d.c(i);
    }

    @Override // a.b.h
    protected void a() {
        this.d.clear();
    }
}
