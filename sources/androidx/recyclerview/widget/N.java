package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class N {

    /* renamed from: a  reason: collision with root package name */
    final a.b.b<RecyclerView.v, a> f776a = new a.b.b<>();

    /* renamed from: b  reason: collision with root package name */
    final a.b.f<RecyclerView.v> f777b = new a.b.f<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.v vVar);

        void a(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f776a.clear();
        this.f777b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(RecyclerView.v vVar) {
        a aVar = this.f776a.get(vVar);
        return (aVar == null || (aVar.f779b & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.f776a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f776a.put(vVar, aVar);
        }
        aVar.c = cVar;
        aVar.f779b |= 4;
    }

    public void d(RecyclerView.v vVar) {
        g(vVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.c e(RecyclerView.v vVar) {
        return a(vVar, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.c f(RecyclerView.v vVar) {
        return a(vVar, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RecyclerView.v vVar) {
        a aVar = this.f776a.get(vVar);
        if (aVar == null) {
            return;
        }
        aVar.f779b &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(RecyclerView.v vVar) {
        int b2 = this.f777b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (vVar == this.f777b.c(b2)) {
                this.f777b.b(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f776a.remove(vVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    private RecyclerView.f.c a(RecyclerView.v vVar, int i) {
        a d;
        RecyclerView.f.c cVar;
        int a2 = this.f776a.a(vVar);
        if (a2 >= 0 && (d = this.f776a.d(a2)) != null) {
            int i2 = d.f779b;
            if ((i2 & i) != 0) {
                d.f779b = (i ^ (-1)) & i2;
                if (i == 4) {
                    cVar = d.c;
                } else if (i == 8) {
                    cVar = d.d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((d.f779b & 12) == 0) {
                    this.f776a.c(a2);
                    a.a(d);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.f776a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f776a.put(vVar, aVar);
        }
        aVar.d = cVar;
        aVar.f779b |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static androidx.core.g.e<a> f778a = new androidx.core.g.f(20);

        /* renamed from: b  reason: collision with root package name */
        int f779b;
        RecyclerView.f.c c;
        RecyclerView.f.c d;

        private a() {
        }

        static void a(a aVar) {
            aVar.f779b = 0;
            aVar.c = null;
            aVar.d = null;
            f778a.release(aVar);
        }

        static a b() {
            a acquire = f778a.acquire();
            return acquire == null ? new a() : acquire;
        }

        static void a() {
            do {
            } while (f778a.acquire() != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(RecyclerView.v vVar) {
        a aVar = this.f776a.get(vVar);
        return (aVar == null || (aVar.f779b & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.v vVar) {
        this.f777b.c(j, vVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.f776a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f776a.put(vVar, aVar);
        }
        aVar.f779b |= 2;
        aVar.c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.v a(long j) {
        return this.f777b.b(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar) {
        a aVar = this.f776a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f776a.put(vVar, aVar);
        }
        aVar.f779b |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f776a.size() - 1; size >= 0; size--) {
            RecyclerView.v b2 = this.f776a.b(size);
            a c = this.f776a.c(size);
            int i = c.f779b;
            if ((i & 3) == 3) {
                bVar.a(b2);
            } else if ((i & 1) != 0) {
                RecyclerView.f.c cVar = c.c;
                if (cVar == null) {
                    bVar.a(b2);
                } else {
                    bVar.b(b2, cVar, c.d);
                }
            } else if ((i & 14) == 14) {
                bVar.a(b2, c.c, c.d);
            } else if ((i & 12) == 12) {
                bVar.c(b2, c.c, c.d);
            } else if ((i & 4) != 0) {
                bVar.b(b2, c.c, null);
            } else if ((i & 8) != 0) {
                bVar.a(b2, c.c, c.d);
            }
            a.a(c);
        }
    }
}
