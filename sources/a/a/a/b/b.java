package a.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f6a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f7b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // a.a.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }

        @Override // a.a.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f8a;

        /* renamed from: b  reason: collision with root package name */
        final V f9b;
        c<K, V> c;
        c<K, V> d;

        c(K k, V v) {
            this.f8a = k;
            this.f9b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f8a.equals(cVar.f8a) && this.f9b.equals(cVar.f9b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f8a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f8a.hashCode() ^ this.f9b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f8a + "=" + this.f9b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private c<K, V> f10a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11b = true;

        d() {
        }

        @Override // a.a.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f10a;
            if (cVar == cVar2) {
                this.f10a = cVar2.d;
                this.f11b = this.f10a == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11b) {
                return b.this.f6a != null;
            }
            c<K, V> cVar = this.f10a;
            return (cVar == null || cVar.c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f11b) {
                this.f11b = false;
                this.f10a = b.this.f6a;
            } else {
                c<K, V> cVar = this.f10a;
                this.f10a = cVar != null ? cVar.c : null;
            }
            return this.f10a;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f12a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f13b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f12a = cVar2;
            this.f13b = cVar;
        }

        @Override // a.a.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f12a == cVar && cVar == this.f13b) {
                this.f13b = null;
                this.f12a = null;
            }
            c<K, V> cVar2 = this.f12a;
            if (cVar2 == cVar) {
                this.f12a = b(cVar2);
            }
            if (this.f13b == cVar) {
                this.f13b = a();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f13b;
            this.f13b = a();
            return cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f13b;
            c<K, V> cVar2 = this.f12a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.f6a;
        while (cVar != null && !cVar.f8a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f9b;
        }
        a(k, v);
        return null;
    }

    public Map.Entry<K, V> c() {
        return this.f7b;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b c0000b = new C0000b(this.f7b, this.f6a);
        this.c.put(c0000b, false);
        return c0000b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f6a, this.f7b);
        this.c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            for (f<K, V> fVar : this.c.keySet()) {
                fVar.a(a2);
            }
        }
        c<K, V> cVar = a2.d;
        if (cVar != null) {
            cVar.c = a2.c;
        } else {
            this.f6a = a2.c;
        }
        c<K, V> cVar2 = a2.c;
        if (cVar2 != null) {
            cVar2.d = a2.d;
        } else {
            this.f7b = a2.d;
        }
        a2.c = null;
        a2.d = null;
        return a2.f9b;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.d++;
        c<K, V> cVar2 = this.f7b;
        if (cVar2 == null) {
            this.f6a = cVar;
            this.f7b = this.f6a;
            return cVar;
        }
        cVar2.c = cVar;
        cVar.d = cVar2;
        this.f7b = cVar;
        return cVar;
    }

    public b<K, V>.d b() {
        b<K, V>.d dVar = new d();
        this.c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> a() {
        return this.f6a;
    }
}
