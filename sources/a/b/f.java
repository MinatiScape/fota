package a.b;
/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class f<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f18a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f19b;
    private long[] c;
    private Object[] d;
    private int e;

    public f() {
        this(10);
    }

    private void c() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f18a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f19b = false;
        this.e = i2;
    }

    public void a(long j) {
        int a2 = e.a(this.c, this.e, j);
        if (a2 >= 0) {
            Object[] objArr = this.d;
            Object obj = objArr[a2];
            Object obj2 = f18a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f19b = true;
            }
        }
    }

    public E b(long j) {
        return b(j, null);
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            E c = c(i);
            if (c != this) {
                sb.append(c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public f(int i) {
        this.f19b = false;
        if (i == 0) {
            this.c = e.f17b;
            this.d = e.c;
        } else {
            int c = e.c(i);
            this.c = new long[c];
            this.d = new Object[c];
        }
        this.e = 0;
    }

    public E b(long j, E e) {
        int a2 = e.a(this.c, this.e, j);
        if (a2 >= 0) {
            Object[] objArr = this.d;
            if (objArr[a2] != f18a) {
                return (E) objArr[a2];
            }
        }
        return e;
    }

    /* renamed from: clone */
    public f<E> m0clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.c = (long[]) this.c.clone();
            fVar.d = (Object[]) this.d.clone();
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public long a(int i) {
        if (this.f19b) {
            c();
        }
        return this.c[i];
    }

    public void b(int i) {
        Object[] objArr = this.d;
        Object obj = objArr[i];
        Object obj2 = f18a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f19b = true;
        }
    }

    public void a() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f19b = false;
    }

    public int b() {
        if (this.f19b) {
            c();
        }
        return this.e;
    }

    public void c(long j, E e) {
        int a2 = e.a(this.c, this.e, j);
        if (a2 >= 0) {
            this.d[a2] = e;
            return;
        }
        int i = a2 ^ (-1);
        if (i < this.e) {
            Object[] objArr = this.d;
            if (objArr[i] == f18a) {
                this.c[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f19b && this.e >= this.c.length) {
            c();
            i = e.a(this.c, this.e, j) ^ (-1);
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int c = e.c(i2 + 1);
            long[] jArr = new long[c];
            Object[] objArr2 = new Object[c];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = jArr;
            this.d = objArr2;
        }
        int i3 = this.e;
        if (i3 - i != 0) {
            long[] jArr3 = this.c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i4, this.e - i);
        }
        this.c[i] = j;
        this.d[i] = e;
        this.e++;
    }

    public void a(long j, E e) {
        int i = this.e;
        if (i != 0 && j <= this.c[i - 1]) {
            c(j, e);
            return;
        }
        if (this.f19b && this.e >= this.c.length) {
            c();
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int c = e.c(i2 + 1);
            long[] jArr = new long[c];
            Object[] objArr = new Object[c];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = jArr;
            this.d = objArr;
        }
        this.c[i2] = j;
        this.d[i2] = e;
        this.e = i2 + 1;
    }

    public E c(int i) {
        if (this.f19b) {
            c();
        }
        return (E) this.d[i];
    }

    public int c(long j) {
        if (this.f19b) {
            c();
        }
        return e.a(this.c, this.e, j);
    }
}
