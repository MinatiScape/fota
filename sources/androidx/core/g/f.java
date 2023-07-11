package androidx.core.g;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f501a;

    /* renamed from: b  reason: collision with root package name */
    private int f502b;

    public f(int i) {
        if (i > 0) {
            this.f501a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean a(T t) {
        for (int i = 0; i < this.f502b; i++) {
            if (this.f501a[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.g.e
    public T acquire() {
        int i = this.f502b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f501a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f502b = i - 1;
            return t;
        }
        return null;
    }

    @Override // androidx.core.g.e
    public boolean release(T t) {
        if (!a(t)) {
            int i = this.f502b;
            Object[] objArr = this.f501a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.f502b = i + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
