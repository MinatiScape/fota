package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<p> f853a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static Comparator<b> f854b = new o();
    long d;
    long e;
    ArrayList<RecyclerView> c = new ArrayList<>();
    private ArrayList<b> f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f857a;

        /* renamed from: b  reason: collision with root package name */
        public int f858b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f857a = false;
            this.f858b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.c.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.c.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.d.a.a("RV Prefetch");
            if (!this.c.isEmpty()) {
                int size = this.c.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.c.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.e);
                }
            }
        } finally {
            this.d = 0L;
            androidx.core.d.a.a();
        }
    }

    private void b(long j) {
        for (int i = 0; i < this.f.size(); i++) {
            b bVar = this.f.get(i);
            if (bVar.d == null) {
                return;
            }
            a(bVar, j);
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.d == 0) {
            this.d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.pa.b(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.c.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.pa.a(recyclerView, false);
                i += recyclerView.pa.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.c.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.pa;
                int abs = Math.abs(aVar.f855a) + Math.abs(aVar.f856b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i5);
                    }
                    int i7 = aVar.c[i6 + 1];
                    bVar.f857a = i7 <= abs;
                    bVar.f858b = abs;
                    bVar.c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, f854b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class a implements RecyclerView.i.a {

        /* renamed from: a  reason: collision with root package name */
        int f855a;

        /* renamed from: b  reason: collision with root package name */
        int f856b;
        int[] c;
        int d;

        void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.w;
            if (recyclerView.v == null || iVar == null || !iVar.v()) {
                return;
            }
            if (z) {
                if (!recyclerView.n.c()) {
                    iVar.a(recyclerView.v.a(), this);
                }
            } else if (!recyclerView.j()) {
                iVar.a(this.f855a, this.f856b, recyclerView.qa, this);
            }
            int i = this.d;
            if (i > iVar.m) {
                iVar.m = i;
                iVar.n = z;
                recyclerView.l.j();
            }
        }

        void b(int i, int i2) {
            this.f855a = i;
            this.f856b = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i.a
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 >= 0) {
                int i3 = this.d * 2;
                int[] iArr = this.c;
                if (iArr == null) {
                    this.c = new int[4];
                    Arrays.fill(this.c, -1);
                } else if (i3 >= iArr.length) {
                    this.c = new int[i3 * 2];
                    System.arraycopy(iArr, 0, this.c, 0, iArr.length);
                }
                int[] iArr2 = this.c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int b2 = recyclerView.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            RecyclerView.v g = RecyclerView.g(recyclerView.o.d(i2));
            if (g.d == i && !g.n()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.v a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.o oVar = recyclerView.l;
        try {
            recyclerView.q();
            RecyclerView.v a2 = oVar.a(i, false, j);
            if (a2 != null) {
                if (a2.m() && !a2.n()) {
                    oVar.b(a2.f807b);
                } else {
                    oVar.a(a2, false);
                }
            }
            return a2;
        } finally {
            recyclerView.a(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.N && recyclerView.o.b() != 0) {
            recyclerView.t();
        }
        a aVar = recyclerView.pa;
        aVar.a(recyclerView, true);
        if (aVar.d != 0) {
            try {
                androidx.core.d.a.a("RV Nested Prefetch");
                recyclerView.qa.a(recyclerView.v);
                for (int i = 0; i < aVar.d * 2; i += 2) {
                    a(recyclerView, aVar.c[i], j);
                }
            } finally {
                androidx.core.d.a.a();
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.v a2 = a(bVar.d, bVar.e, bVar.f857a ? Long.MAX_VALUE : j);
        if (a2 == null || a2.c == null || !a2.m() || a2.n()) {
            return;
        }
        a(a2.c.get(), j);
    }

    void a(long j) {
        a();
        b(j);
    }
}
