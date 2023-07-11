package a.b;
/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f33a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f34b;
    private int[] c;
    private Object[] d;
    private int e;

    public j() {
        this(10);
    }

    private void c() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f33a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f34b = false;
        this.e = i2;
    }

    public void a(int i) {
        int a2 = e.a(this.c, this.e, i);
        if (a2 >= 0) {
            Object[] objArr = this.d;
            Object obj = objArr[a2];
            Object obj2 = f33a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f34b = true;
            }
        }
    }

    public E b(int i) {
        return b(i, null);
    }

    public int d(int i) {
        if (this.f34b) {
            c();
        }
        return this.c[i];
    }

    public void e(int i) {
        a(i);
    }

    public E f(int i) {
        if (this.f34b) {
            c();
        }
        return (E) this.d[i];
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
            sb.append(d(i));
            sb.append('=');
            E f = f(i);
            if (f != this) {
                sb.append(f);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public j(int i) {
        this.f34b = false;
        if (i == 0) {
            this.c = e.f16a;
            this.d = e.c;
        } else {
            int b2 = e.b(i);
            this.c = new int[b2];
            this.d = new Object[b2];
        }
        this.e = 0;
    }

    public E b(int i, E e) {
        int a2 = e.a(this.c, this.e, i);
        if (a2 >= 0) {
            Object[] objArr = this.d;
            if (objArr[a2] != f33a) {
                return (E) objArr[a2];
            }
        }
        return e;
    }

    /* renamed from: clone */
    public j<E> m1clone() {
        try {
            j<E> jVar = (j) super.clone();
            jVar.c = (int[]) this.c.clone();
            jVar.d = (Object[]) this.d.clone();
            return jVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public int a(E e) {
        if (this.f34b) {
            c();
        }
        for (int i = 0; i < this.e; i++) {
            if (this.d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int b() {
        if (this.f34b) {
            c();
        }
        return this.e;
    }

    public void a() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f34b = false;
    }

    public void c(int i, E e) {
        int a2 = e.a(this.c, this.e, i);
        if (a2 >= 0) {
            this.d[a2] = e;
            return;
        }
        int i2 = a2 ^ (-1);
        if (i2 < this.e) {
            Object[] objArr = this.d;
            if (objArr[i2] == f33a) {
                this.c[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f34b && this.e >= this.c.length) {
            c();
            i2 = e.a(this.c, this.e, i) ^ (-1);
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int b2 = e.b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr2 = new Object[b2];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = iArr;
            this.d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = e;
        this.e++;
    }

    public void a(int i, E e) {
        int i2 = this.e;
        if (i2 != 0 && i <= this.c[i2 - 1]) {
            c(i, e);
            return;
        }
        if (this.f34b && this.e >= this.c.length) {
            c();
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int b2 = e.b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr = new Object[b2];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = iArr;
            this.d = objArr;
        }
        this.c[i3] = i;
        this.d[i3] = e;
        this.e = i3 + 1;
    }

    public int c(int i) {
        if (this.f34b) {
            c();
        }
        return e.a(this.c, this.e, i);
    }
}
