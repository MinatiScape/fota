package androidx.lifecycle;

import androidx.lifecycle.f;
/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    static final Object f670a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Object f671b = new Object();
    private a.a.a.b.b<p<? super T>, LiveData<T>.a> c = new a.a.a.b.b<>();
    int d = 0;
    private volatile Object e;
    volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final p<? super T> f672a;

        /* renamed from: b  reason: collision with root package name */
        boolean f673b;
        int c = -1;

        a(p<? super T> pVar) {
            this.f672a = pVar;
        }

        void a() {
        }

        void a(boolean z) {
            if (z == this.f673b) {
                return;
            }
            this.f673b = z;
            boolean z2 = LiveData.this.d == 0;
            LiveData.this.d += this.f673b ? 1 : -1;
            if (z2 && this.f673b) {
                LiveData.this.c();
            }
            LiveData liveData = LiveData.this;
            if (liveData.d == 0 && !this.f673b) {
                liveData.d();
            }
            if (this.f673b) {
                LiveData.this.a(this);
            }
        }

        boolean a(h hVar) {
            return false;
        }

        abstract boolean b();
    }

    public LiveData() {
        Object obj = f670a;
        this.e = obj;
        this.f = obj;
        this.g = -1;
        this.j = new m(this);
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f673b) {
            if (!aVar.b()) {
                aVar.a(false);
                return;
            }
            int i = aVar.c;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            aVar.c = i2;
            aVar.f672a.a((Object) this.e);
        }
    }

    void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar != null) {
                b(aVar);
                aVar = null;
            } else {
                a.a.a.b.b<p<? super T>, LiveData<T>.a>.d b2 = this.c.b();
                while (b2.hasNext()) {
                    b((a) b2.next().getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    protected void c() {
    }

    protected void d() {
    }

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements e {
        final h e;

        LifecycleBoundObserver(h hVar, p<? super T> pVar) {
            super(pVar);
            this.e = hVar;
        }

        @Override // androidx.lifecycle.e
        public void a(h hVar, f.a aVar) {
            if (this.e.getLifecycle().a() == f.b.DESTROYED) {
                LiveData.this.a((p) this.f672a);
            } else {
                a(b());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean b() {
            return this.e.getLifecycle().a().isAtLeast(f.b.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a(h hVar) {
            return this.e == hVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        void a() {
            this.e.getLifecycle().b(this);
        }
    }

    public boolean b() {
        return this.d > 0;
    }

    public void a(h hVar, p<? super T> pVar) {
        a("observe");
        if (hVar.getLifecycle().a() == f.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(hVar, pVar);
        LiveData<T>.a b2 = this.c.b(pVar, lifecycleBoundObserver);
        if (b2 != null && !b2.a(hVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (b2 != null) {
            return;
        }
        hVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void a(p<? super T> pVar) {
        a("removeObserver");
        LiveData<T>.a remove = this.c.remove(pVar);
        if (remove == null) {
            return;
        }
        remove.a();
        remove.a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        a((a) null);
    }

    public T a() {
        T t = (T) this.e;
        if (t != f670a) {
            return t;
        }
        return null;
    }

    private static void a(String str) {
        if (a.a.a.a.c.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
