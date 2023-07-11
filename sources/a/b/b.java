package a.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class b<K, V> extends i<K, V> implements Map<K, V> {
    h<K, V> h;

    public b() {
    }

    private h<K, V> b() {
        if (this.h == null) {
            this.h = new a(this);
        }
        return this.h;
    }

    public boolean a(Collection<?> collection) {
        return h.c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.g + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }

    public b(int i) {
        super(i);
    }

    public b(i iVar) {
        super(iVar);
    }
}
