package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildHelper.java */
/* renamed from: androidx.recyclerview.widget.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0088b {

    /* renamed from: a  reason: collision with root package name */
    final InterfaceC0022b f822a;

    /* renamed from: b  reason: collision with root package name */
    final a f823b = new a();
    final List<View> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0022b {
        int a();

        View a(int i);

        void a(View view);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        RecyclerView.v b(View view);

        void b();

        void b(int i);

        int c(View view);

        void c(int i);

        void d(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0088b(InterfaceC0022b interfaceC0022b) {
        this.f822a = interfaceC0022b;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f822a.a();
        int i2 = i;
        while (i2 < a2) {
            int b2 = i - (i2 - this.f823b.b(i2));
            if (b2 == 0) {
                while (this.f823b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    private void g(View view) {
        this.c.add(view);
        this.f822a.a(view);
    }

    private boolean h(View view) {
        if (this.c.remove(view)) {
            this.f822a.d(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.v b2 = this.f822a.b(view);
            if (b2.i() == i && !b2.n() && !b2.p()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i) {
        return this.f822a.a(f(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        int c = this.f822a.c(view);
        if (c < 0) {
            return;
        }
        if (this.f823b.d(c)) {
            h(view);
        }
        this.f822a.c(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        View a2 = this.f822a.a(f);
        if (a2 == null) {
            return;
        }
        if (this.f823b.d(f)) {
            h(a2);
        }
        this.f822a.c(f);
    }

    public String toString() {
        return this.f823b.toString() + ", hidden list:" + this.c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* renamed from: androidx.recyclerview.widget.b$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f824a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f825b;

        a() {
        }

        private void b() {
            if (this.f825b == null) {
                this.f825b = new a();
            }
        }

        void a(int i) {
            if (i >= 64) {
                a aVar = this.f825b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.f824a &= (1 << i) ^ (-1);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f824a & (1 << i)) != 0;
            }
            b();
            return this.f825b.c(i - 64);
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f825b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f824a & j) != 0;
            this.f824a &= j ^ (-1);
            long j2 = j - 1;
            long j3 = this.f824a;
            this.f824a = Long.rotateRight(j3 & (j2 ^ (-1)), 1) | (j3 & j2);
            a aVar = this.f825b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f825b.d(0);
            }
            return z;
        }

        void e(int i) {
            if (i >= 64) {
                b();
                this.f825b.e(i - 64);
                return;
            }
            this.f824a |= 1 << i;
        }

        public String toString() {
            if (this.f825b == null) {
                return Long.toBinaryString(this.f824a);
            }
            return this.f825b.toString() + "xx" + Long.toBinaryString(this.f824a);
        }

        int b(int i) {
            a aVar = this.f825b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f824a);
                }
                return Long.bitCount(this.f824a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f824a & ((1 << i) - 1));
            } else {
                return aVar.b(i - 64) + Long.bitCount(this.f824a);
            }
        }

        void a() {
            this.f824a = 0L;
            a aVar = this.f825b;
            if (aVar != null) {
                aVar.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f825b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f824a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f824a;
            this.f824a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.f825b != null) {
                b();
                this.f825b.a(0, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int f;
        if (i < 0) {
            f = this.f822a.a();
        } else {
            f = f(i);
        }
        this.f823b.a(f, z);
        if (z) {
            g(view);
        }
        this.f822a.a(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f823b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.f822a.d(this.c.get(size));
            this.c.remove(size);
        }
        this.f822a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(View view) {
        int c = this.f822a.c(view);
        if (c >= 0) {
            if (this.f823b.c(c)) {
                this.f823b.a(c);
                h(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d(int i) {
        return this.f822a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(View view) {
        int c = this.f822a.c(view);
        if (c == -1) {
            h(view);
            return true;
        } else if (this.f823b.c(c)) {
            this.f823b.d(c);
            h(view);
            this.f822a.c(c);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int f;
        if (i < 0) {
            f = this.f822a.a();
        } else {
            f = f(i);
        }
        this.f823b.a(f, z);
        if (z) {
            g(view);
        }
        this.f822a.a(view, f, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f822a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        int c = this.f822a.c(view);
        if (c == -1 || this.f823b.c(c)) {
            return -1;
        }
        return c - this.f823b.b(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f822a.a() - this.c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        this.f823b.d(f);
        this.f822a.b(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        int c = this.f822a.c(view);
        if (c >= 0) {
            this.f823b.e(c);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }
}
