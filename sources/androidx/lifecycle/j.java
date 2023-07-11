package androidx.lifecycle;

import android.util.Log;
import androidx.lifecycle.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class j extends f {
    private final WeakReference<h> c;

    /* renamed from: a  reason: collision with root package name */
    private a.a.a.b.a<g, a> f688a = new a.a.a.b.a<>();
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<f.b> g = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private f.b f689b = f.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        f.b f690a;

        /* renamed from: b  reason: collision with root package name */
        e f691b;

        a(g gVar, f.b bVar) {
            this.f691b = l.a(gVar);
            this.f690a = bVar;
        }

        void a(h hVar, f.a aVar) {
            f.b a2 = j.a(aVar);
            this.f690a = j.a(this.f690a, a2);
            this.f691b.a(hVar, aVar);
            this.f690a = a2;
        }
    }

    public j(h hVar) {
        this.c = new WeakReference<>(hVar);
    }

    private void c(f.b bVar) {
        if (this.f689b == bVar) {
            return;
        }
        this.f689b = bVar;
        if (!this.e && this.d == 0) {
            this.e = true;
            d();
            this.e = false;
            return;
        }
        this.f = true;
    }

    private void d(f.b bVar) {
        this.g.add(bVar);
    }

    private static f.a e(f.b bVar) {
        int i = i.f687b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return f.a.ON_START;
            }
            if (i == 3) {
                return f.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return f.a.ON_CREATE;
    }

    public void a(f.b bVar) {
        c(bVar);
    }

    public void b(f.a aVar) {
        c(a(aVar));
    }

    private void d() {
        h hVar = this.c.get();
        if (hVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.f689b.compareTo(this.f688a.a().getValue().f690a) < 0) {
                a(hVar);
            }
            Map.Entry<g, a> c = this.f688a.c();
            if (!this.f && c != null && this.f689b.compareTo(c.getValue().f690a) > 0) {
                b(hVar);
            }
        }
        this.f = false;
    }

    @Override // androidx.lifecycle.f
    public void a(g gVar) {
        h hVar;
        f.b bVar = this.f689b;
        f.b bVar2 = f.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = f.b.INITIALIZED;
        }
        a aVar = new a(gVar, bVar2);
        if (this.f688a.b(gVar, aVar) == null && (hVar = this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            f.b c = c(gVar);
            this.d++;
            while (aVar.f690a.compareTo(c) < 0 && this.f688a.contains(gVar)) {
                d(aVar.f690a);
                aVar.a(hVar, e(aVar.f690a));
                c();
                c = c(gVar);
            }
            if (!z) {
                d();
            }
            this.d--;
        }
    }

    private boolean b() {
        if (this.f688a.size() == 0) {
            return true;
        }
        f.b bVar = this.f688a.a().getValue().f690a;
        f.b bVar2 = this.f688a.c().getValue().f690a;
        return bVar == bVar2 && this.f689b == bVar2;
    }

    @Override // androidx.lifecycle.f
    public void b(g gVar) {
        this.f688a.remove(gVar);
    }

    private static f.a b(f.b bVar) {
        int i = i.f687b[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + bVar);
                        }
                        throw new IllegalArgumentException();
                    }
                    return f.a.ON_PAUSE;
                }
                return f.a.ON_STOP;
            }
            return f.a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    private f.b c(g gVar) {
        Map.Entry<g, a> b2 = this.f688a.b(gVar);
        f.b bVar = null;
        f.b bVar2 = b2 != null ? b2.getValue().f690a : null;
        if (!this.g.isEmpty()) {
            ArrayList<f.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f689b, bVar2), bVar);
    }

    private void c() {
        ArrayList<f.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(h hVar) {
        a.a.a.b.b<g, a>.d b2 = this.f688a.b();
        while (b2.hasNext() && !this.f) {
            Map.Entry next = b2.next();
            a aVar = (a) next.getValue();
            while (aVar.f690a.compareTo(this.f689b) < 0 && !this.f && this.f688a.contains(next.getKey())) {
                d(aVar.f690a);
                aVar.a(hVar, e(aVar.f690a));
                c();
            }
        }
    }

    @Override // androidx.lifecycle.f
    public f.b a() {
        return this.f689b;
    }

    static f.b a(f.a aVar) {
        switch (i.f686a[aVar.ordinal()]) {
            case 1:
            case 2:
                return f.b.CREATED;
            case 3:
            case 4:
                return f.b.STARTED;
            case 5:
                return f.b.RESUMED;
            case 6:
                return f.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void a(h hVar) {
        Iterator<Map.Entry<g, a>> descendingIterator = this.f688a.descendingIterator();
        while (descendingIterator.hasNext() && !this.f) {
            Map.Entry<g, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.f690a.compareTo(this.f689b) > 0 && !this.f && this.f688a.contains(next.getKey())) {
                f.a b2 = b(value.f690a);
                d(a(b2));
                value.a(hVar, b2);
                c();
            }
        }
    }

    static f.b a(f.b bVar, f.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
