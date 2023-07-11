package a.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class d<E> implements Collection<E>, Set<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Object[] f15b = new Object[0];
    private static Object[] c;
    private static int d;
    private static Object[] e;
    private static int f;
    private int[] g;
    Object[] h;
    int i;
    private h<E, E> j;

    public d() {
        this(0);
    }

    private int a(Object obj, int i) {
        int i2 = this.i;
        if (i2 == 0) {
            return -1;
        }
        int a2 = e.a(this.g, i2, i);
        if (a2 >= 0 && !obj.equals(this.h[a2])) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.g[i3] == i) {
                if (obj.equals(this.h[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.g[i4] == i; i4--) {
                if (obj.equals(this.h[i4])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return a2;
    }

    private int b() {
        int i = this.i;
        if (i == 0) {
            return -1;
        }
        int a2 = e.a(this.g, i, 0);
        if (a2 >= 0 && this.h[a2] != null) {
            int i2 = a2 + 1;
            while (i2 < i && this.g[i2] == 0) {
                if (this.h[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = a2 - 1; i3 >= 0 && this.g[i3] == 0; i3--) {
                if (this.h[i3] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return a2;
    }

    private void d(int i) {
        if (i == 8) {
            synchronized (d.class) {
                if (e != null) {
                    Object[] objArr = e;
                    this.h = objArr;
                    e = (Object[]) objArr[0];
                    this.g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (d.class) {
                if (c != null) {
                    Object[] objArr2 = c;
                    this.h = objArr2;
                    c = (Object[]) objArr2[0];
                    this.g = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    d--;
                    return;
                }
            }
        }
        this.g = new int[i];
        this.h = new Object[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i;
        int a2;
        if (e2 == null) {
            a2 = b();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            a2 = a(e2, hashCode);
        }
        if (a2 >= 0) {
            return false;
        }
        int i2 = a2 ^ (-1);
        int i3 = this.i;
        if (i3 >= this.g.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.g;
            Object[] objArr = this.h;
            d(i4);
            int[] iArr2 = this.g;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.h, 0, objArr.length);
            }
            a(iArr, objArr, this.i);
        }
        int i5 = this.i;
        if (i2 < i5) {
            int[] iArr3 = this.g;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.h;
            System.arraycopy(objArr2, i2, objArr2, i6, this.i - i2);
        }
        this.g[i2] = i;
        this.h[i2] = e2;
        this.i++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        a(this.i + collection.size());
        boolean z = false;
        for (E e2 : collection) {
            z |= add(e2);
        }
        return z;
    }

    public E c(int i) {
        return (E) this.h[i];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.i;
        if (i != 0) {
            a(this.g, this.h, i);
            this.g = f14a;
            this.h = f15b;
            this.i = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.i; i++) {
                try {
                    if (!set.contains(c(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.g;
        int i = this.i;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? b() : a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.i <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return a().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            b(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.i - 1; i >= 0; i--) {
            if (!collection.contains(this.h[i])) {
                b(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.i;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.i;
        Object[] objArr = new Object[i];
        System.arraycopy(this.h, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 14);
        sb.append('{');
        for (int i = 0; i < this.i; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i) {
        if (i == 0) {
            this.g = f14a;
            this.h = f15b;
        } else {
            d(i);
        }
        this.i = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.i) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.i));
        }
        System.arraycopy(this.h, 0, tArr, 0, this.i);
        int length = tArr.length;
        int i = this.i;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (d.class) {
                if (d < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    c = objArr;
                    d++;
                }
            }
        }
    }

    public E b(int i) {
        Object[] objArr = this.h;
        E e2 = (E) objArr[i];
        int i2 = this.i;
        if (i2 <= 1) {
            a(this.g, objArr, i2);
            this.g = f14a;
            this.h = f15b;
            this.i = 0;
        } else {
            int[] iArr = this.g;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                int i3 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr2 = this.g;
                Object[] objArr2 = this.h;
                d(i3);
                this.i--;
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.g, 0, i);
                    System.arraycopy(objArr2, 0, this.h, 0, i);
                }
                int i4 = this.i;
                if (i < i4) {
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, this.g, i, i4 - i);
                    System.arraycopy(objArr2, i5, this.h, i, this.i - i);
                }
            } else {
                this.i--;
                int i6 = this.i;
                if (i < i6) {
                    int[] iArr3 = this.g;
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, iArr3, i, i6 - i);
                    Object[] objArr3 = this.h;
                    System.arraycopy(objArr3, i7, objArr3, i, this.i - i);
                }
                this.h[this.i] = null;
            }
        }
        return e2;
    }

    public void a(int i) {
        int[] iArr = this.g;
        if (iArr.length < i) {
            Object[] objArr = this.h;
            d(i);
            int i2 = this.i;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.g, 0, i2);
                System.arraycopy(objArr, 0, this.h, 0, this.i);
            }
            a(iArr, objArr, this.i);
        }
    }

    private h<E, E> a() {
        if (this.j == null) {
            this.j = new c(this);
        }
        return this.j;
    }
}
