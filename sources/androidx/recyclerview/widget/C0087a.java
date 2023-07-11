package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdapterHelper.java */
/* renamed from: androidx.recyclerview.widget.a  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0087a implements t.a {

    /* renamed from: a  reason: collision with root package name */
    private androidx.core.g.e<b> f818a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f819b;
    final ArrayList<b> c;
    final InterfaceC0021a d;
    Runnable e;
    final boolean f;
    final t g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0021a {
        RecyclerView.v a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$b */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f820a;

        /* renamed from: b  reason: collision with root package name */
        int f821b;
        Object c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.f820a = i;
            this.f821b = i2;
            this.d = i3;
            this.c = obj;
        }

        String a() {
            int i = this.f820a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f820a;
            if (i != bVar.f820a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.f821b) == 1 && this.d == bVar.f821b && this.f821b == bVar.d) {
                return true;
            }
            if (this.d == bVar.d && this.f821b == bVar.f821b) {
                Object obj2 = this.c;
                if (obj2 != null) {
                    if (!obj2.equals(bVar.c)) {
                        return false;
                    }
                } else if (bVar.c != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f820a * 31) + this.f821b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f821b + "c:" + this.d + ",p:" + this.c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0087a(InterfaceC0021a interfaceC0021a) {
        this(interfaceC0021a, false);
    }

    private int b(int i, int i2) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            b bVar = this.c.get(size);
            int i3 = bVar.f820a;
            if (i3 == 8) {
                int i4 = bVar.f821b;
                int i5 = bVar.d;
                if (i4 >= i5) {
                    i5 = i4;
                    i4 = i5;
                }
                if (i >= i4 && i <= i5) {
                    int i6 = bVar.f821b;
                    if (i4 == i6) {
                        if (i2 == 1) {
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.f821b = i6 + 1;
                        } else if (i2 == 2) {
                            bVar.f821b = i6 - 1;
                        }
                        i--;
                    }
                } else {
                    int i7 = bVar.f821b;
                    if (i < i7) {
                        if (i2 == 1) {
                            bVar.f821b = i7 + 1;
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.f821b = i7 - 1;
                            bVar.d--;
                        }
                    }
                }
            } else {
                int i8 = bVar.f821b;
                if (i8 <= i) {
                    if (i3 == 1) {
                        i -= bVar.d;
                    } else if (i3 == 2) {
                        i += bVar.d;
                    }
                } else if (i2 == 1) {
                    bVar.f821b = i8 + 1;
                } else if (i2 == 2) {
                    bVar.f821b = i8 - 1;
                }
            }
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.c.get(size2);
            if (bVar2.f820a == 8) {
                int i9 = bVar2.d;
                if (i9 == bVar2.f821b || i9 < 0) {
                    this.c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.c.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private void c(b bVar) {
        g(bVar);
    }

    private void d(b bVar) {
        boolean z;
        char c;
        int i = bVar.f821b;
        int i2 = bVar.d + i;
        int i3 = 0;
        char c2 = 65535;
        int i4 = i;
        while (i4 < i2) {
            if (this.d.a(i4) != null || d(i4)) {
                if (c2 == 0) {
                    f(a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    g(a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i4 -= i3;
                i2 -= i3;
                i3 = 1;
            } else {
                i3++;
            }
            i4++;
            c2 = c;
        }
        if (i3 != bVar.d) {
            a(bVar);
            bVar = a(2, i, i3, null);
        }
        if (c2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private void g(b bVar) {
        this.c.add(bVar);
        int i = bVar.f820a;
        if (i == 1) {
            this.d.c(bVar.f821b, bVar.d);
        } else if (i == 2) {
            this.d.b(bVar.f821b, bVar.d);
        } else if (i == 4) {
            this.d.a(bVar.f821b, bVar.d, bVar.c);
        } else if (i == 8) {
            this.d.a(bVar.f821b, bVar.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.d.b(this.c.get(i));
        }
        a(this.c);
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.g.a(this.f819b);
        int size = this.f819b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f819b.get(i);
            int i2 = bVar.f820a;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar);
            } else if (i2 == 4) {
                e(bVar);
            } else if (i2 == 8) {
                c(bVar);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f819b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        a(this.f819b);
        a(this.c);
        this.h = 0;
    }

    C0087a(InterfaceC0021a interfaceC0021a, boolean z) {
        this.f818a = new androidx.core.g.f(30);
        this.f819b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.h = 0;
        this.d = interfaceC0021a;
        this.f = z;
        this.g = new t(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f819b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i) {
        return (i & this.h) != 0;
    }

    private void f(b bVar) {
        int i;
        int i2 = bVar.f820a;
        if (i2 != 1 && i2 != 8) {
            int b2 = b(bVar.f821b, i2);
            int i3 = bVar.f821b;
            int i4 = bVar.f820a;
            if (i4 == 2) {
                i = 0;
            } else if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            } else {
                i = 1;
            }
            int i5 = b2;
            int i6 = i3;
            int i7 = 1;
            for (int i8 = 1; i8 < bVar.d; i8++) {
                int b3 = b(bVar.f821b + (i * i8), bVar.f820a);
                int i9 = bVar.f820a;
                if (i9 == 2 ? b3 == i5 : i9 == 4 && b3 == i5 + 1) {
                    i7++;
                } else {
                    b a2 = a(bVar.f820a, i5, i7, bVar.c);
                    a(a2, i6);
                    a(a2);
                    if (bVar.f820a == 4) {
                        i6 += i7;
                    }
                    i5 = b3;
                    i7 = 1;
                }
            }
            Object obj = bVar.c;
            a(bVar);
            if (i7 > 0) {
                b a3 = a(bVar.f820a, i5, i7, obj);
                a(a3, i6);
                a(a3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    void a(b bVar, int i) {
        this.d.a(bVar);
        int i2 = bVar.f820a;
        if (i2 == 2) {
            this.d.d(i, bVar.d);
        } else if (i2 == 4) {
            this.d.a(i, bVar.d, bVar.c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    int a(int i, int i2) {
        int size = this.c.size();
        while (i2 < size) {
            b bVar = this.c.get(i2);
            int i3 = bVar.f820a;
            if (i3 == 8) {
                int i4 = bVar.f821b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f821b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    private void e(b bVar) {
        int i = bVar.f821b;
        int i2 = bVar.d + i;
        int i3 = i;
        int i4 = 0;
        char c = 65535;
        while (i < i2) {
            if (this.d.a(i) != null || d(i)) {
                if (c == 0) {
                    f(a(4, i3, i4, bVar.c));
                    i3 = i;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    g(a(4, i3, i4, bVar.c));
                    i3 = i;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private boolean d(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            int i3 = bVar.f820a;
            if (i3 == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f821b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public int a(int i) {
        int size = this.f819b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f819b.get(i2);
            int i3 = bVar.f820a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.f821b;
                    if (i4 <= i) {
                        int i5 = bVar.d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.f821b;
                    if (i6 == i) {
                        i = bVar.d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.f821b <= i) {
                i += bVar.d;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return (this.c.isEmpty() || this.f819b.isEmpty()) ? false : true;
    }

    private void b(b bVar) {
        g(bVar);
    }

    @Override // androidx.recyclerview.widget.t.a
    public b a(int i, int i2, int i3, Object obj) {
        b acquire = this.f818a.acquire();
        if (acquire == null) {
            return new b(i, i2, i3, obj);
        }
        acquire.f820a = i;
        acquire.f821b = i2;
        acquire.d = i3;
        acquire.c = obj;
        return acquire;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a();
        int size = this.f819b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f819b.get(i);
            int i2 = bVar.f820a;
            if (i2 == 1) {
                this.d.b(bVar);
                this.d.c(bVar.f821b, bVar.d);
            } else if (i2 == 2) {
                this.d.b(bVar);
                this.d.d(bVar.f821b, bVar.d);
            } else if (i2 == 4) {
                this.d.b(bVar);
                this.d.a(bVar.f821b, bVar.d, bVar.c);
            } else if (i2 == 8) {
                this.d.b(bVar);
                this.d.a(bVar.f821b, bVar.d);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f819b);
        this.h = 0;
    }

    @Override // androidx.recyclerview.widget.t.a
    public void a(b bVar) {
        if (this.f) {
            return;
        }
        bVar.c = null;
        this.f818a.release(bVar);
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}
