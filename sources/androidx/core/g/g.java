package androidx.core.g;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class g<T> extends f<T> {
    private final Object c;

    public g(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // androidx.core.g.f, androidx.core.g.e
    public T acquire() {
        T t;
        synchronized (this.c) {
            t = (T) super.acquire();
        }
        return t;
    }

    @Override // androidx.core.g.f, androidx.core.g.e
    public boolean release(T t) {
        boolean release;
        synchronized (this.c) {
            release = super.release(t);
        }
        return release;
    }
}
