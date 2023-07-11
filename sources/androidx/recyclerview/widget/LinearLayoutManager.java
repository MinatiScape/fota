package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.i implements q, RecyclerView.r.a {
    private boolean C;
    private c t;
    w u;
    private boolean v;
    int s = 1;
    private boolean w = false;
    boolean x = false;
    private boolean y = false;
    private boolean z = true;
    int A = -1;
    int B = Integer.MIN_VALUE;
    SavedState D = null;
    final a E = new a();
    private final b F = new b();
    private int G = 2;

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new s();

        /* renamed from: a  reason: collision with root package name */
        int f764a;

        /* renamed from: b  reason: collision with root package name */
        int f765b;
        boolean c;

        public SavedState() {
        }

        boolean a() {
            return this.f764a >= 0;
        }

        void b() {
            this.f764a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f764a);
            parcel.writeInt(this.f765b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel) {
            this.f764a = parcel.readInt();
            this.f765b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f764a = savedState.f764a;
            this.f765b = savedState.f765b;
            this.c = savedState.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f768a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f769b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.f768a = 0;
            this.f769b = false;
            this.c = false;
            this.d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        int f771b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int j;
        boolean l;

        /* renamed from: a  reason: collision with root package name */
        boolean f770a = true;
        int h = 0;
        boolean i = false;
        List<RecyclerView.v> k = null;

        c() {
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).f807b;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.d == layoutParams.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.s sVar) {
            int i = this.d;
            return i >= 0 && i < sVar.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.o oVar) {
            if (this.k != null) {
                return b();
            }
            View d = oVar.d(this.d);
            this.d += this.e;
            return d;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.LayoutParams) b2.getLayoutParams()).a();
            }
        }

        public View b(View view) {
            int a2;
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.k.get(i2).f807b;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (a2 = (layoutParams.a() - this.d) * this.e) >= 0 && a2 < i) {
                    if (a2 == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = a2;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        i(i);
        a(z);
    }

    private View K() {
        return c(this.x ? 0 : e() - 1);
    }

    private View L() {
        return c(this.x ? e() - 1 : 0);
    }

    private void M() {
        if (this.s != 1 && I()) {
            this.x = !this.w;
        } else {
            this.x = this.w;
        }
    }

    private void f(int i, int i2) {
        this.t.c = this.u.b() - i2;
        this.t.e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.d = i;
        cVar.f = 1;
        cVar.f771b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private int j(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        return H.a(sVar, this.u, b(!this.z, true), a(!this.z, true), this, this.z, this.x);
    }

    private int k(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        return H.b(sVar, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    private View l(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.x ? g(oVar, sVar) : i(oVar, sVar);
    }

    private View m(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.x ? i(oVar, sVar) : g(oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    boolean A() {
        return (i() == 1073741824 || r() == 1073741824 || !s()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean C() {
        return this.D == null && this.v == this.y;
    }

    c D() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        if (this.t == null) {
            this.t = D();
        }
    }

    public int F() {
        View a2 = a(0, e(), false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int G() {
        View a2 = a(e() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int H() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I() {
        return j() == 1;
    }

    boolean J() {
        return this.u.d() == 0 && this.u.a() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            accessibilityEvent.setFromIndex(F());
            accessibilityEvent.setToIndex(G());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.b(recyclerView, oVar);
        if (this.C) {
            b(oVar);
            oVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams c() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.s sVar) {
        return i(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(RecyclerView.o oVar, RecyclerView.s sVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int a2;
        int i6;
        View b2;
        int d;
        int i7;
        int i8 = -1;
        if ((this.D != null || this.A != -1) && sVar.a() == 0) {
            b(oVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f764a;
        }
        E();
        this.t.f770a = false;
        M();
        View g = g();
        if (this.E.e && this.A == -1 && this.D == null) {
            if (g != null && (this.u.d(g) >= this.u.b() || this.u.a(g) <= this.u.f())) {
                this.E.b(g, l(g));
            }
        } else {
            this.E.b();
            a aVar = this.E;
            aVar.d = this.x ^ this.y;
            b(oVar, sVar, aVar);
            this.E.e = true;
        }
        int h = h(sVar);
        if (this.t.j >= 0) {
            i = h;
            h = 0;
        } else {
            i = 0;
        }
        int f = h + this.u.f();
        int c2 = i + this.u.c();
        if (sVar.d() && (i6 = this.A) != -1 && this.B != Integer.MIN_VALUE && (b2 = b(i6)) != null) {
            if (this.x) {
                i7 = this.u.b() - this.u.a(b2);
                d = this.B;
            } else {
                d = this.u.d(b2) - this.u.f();
                i7 = this.B;
            }
            int i9 = i7 - d;
            if (i9 > 0) {
                f += i9;
            } else {
                c2 -= i9;
            }
        }
        if (!this.E.d ? !this.x : this.x) {
            i8 = 1;
        }
        a(oVar, sVar, this.E, i8);
        a(oVar);
        this.t.l = J();
        this.t.i = sVar.d();
        a aVar2 = this.E;
        if (aVar2.d) {
            b(aVar2);
            c cVar = this.t;
            cVar.h = f;
            a(oVar, cVar, sVar, false);
            c cVar2 = this.t;
            i3 = cVar2.f771b;
            int i10 = cVar2.d;
            int i11 = cVar2.c;
            if (i11 > 0) {
                c2 += i11;
            }
            a(this.E);
            c cVar3 = this.t;
            cVar3.h = c2;
            cVar3.d += cVar3.e;
            a(oVar, cVar3, sVar, false);
            c cVar4 = this.t;
            i2 = cVar4.f771b;
            int i12 = cVar4.c;
            if (i12 > 0) {
                g(i10, i3);
                c cVar5 = this.t;
                cVar5.h = i12;
                a(oVar, cVar5, sVar, false);
                i3 = this.t.f771b;
            }
        } else {
            a(aVar2);
            c cVar6 = this.t;
            cVar6.h = c2;
            a(oVar, cVar6, sVar, false);
            c cVar7 = this.t;
            i2 = cVar7.f771b;
            int i13 = cVar7.d;
            int i14 = cVar7.c;
            if (i14 > 0) {
                f += i14;
            }
            b(this.E);
            c cVar8 = this.t;
            cVar8.h = f;
            cVar8.d += cVar8.e;
            a(oVar, cVar8, sVar, false);
            c cVar9 = this.t;
            i3 = cVar9.f771b;
            int i15 = cVar9.c;
            if (i15 > 0) {
                f(i13, i2);
                c cVar10 = this.t;
                cVar10.h = i15;
                a(oVar, cVar10, sVar, false);
                i2 = this.t.f771b;
            }
        }
        if (e() > 0) {
            if (this.x ^ this.y) {
                int a3 = a(i2, oVar, sVar, true);
                i4 = i3 + a3;
                i5 = i2 + a3;
                a2 = b(i4, oVar, sVar, false);
            } else {
                int b3 = b(i3, oVar, sVar, true);
                i4 = i3 + b3;
                i5 = i2 + b3;
                a2 = a(i5, oVar, sVar, false);
            }
            i3 = i4 + a2;
            i2 = i5 + a2;
        }
        b(oVar, sVar, i3, i2);
        if (!sVar.d()) {
            this.u.i();
        } else {
            this.E.b();
        }
        this.v = this.y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void g(RecyclerView.s sVar) {
        super.g(sVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.b();
    }

    protected int h(RecyclerView.s sVar) {
        if (sVar.c()) {
            return this.u.g();
        }
        return 0;
    }

    public void i(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        a((String) null);
        if (i != this.s || this.u == null) {
            this.u = w.a(this, i);
            this.E.f766a = this.u;
            this.s = i;
            y();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean u() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable x() {
        SavedState savedState = this.D;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (e() > 0) {
            E();
            boolean z = this.v ^ this.x;
            savedState2.c = z;
            if (z) {
                View K = K();
                savedState2.f765b = this.u.b() - this.u.a(K);
                savedState2.f764a = l(K);
            } else {
                View L = L();
                savedState2.f764a = l(L);
                savedState2.f765b = this.u.d(L) - this.u.f();
            }
        } else {
            savedState2.b();
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.s sVar) {
        return k(sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        w f766a;

        /* renamed from: b  reason: collision with root package name */
        int f767b;
        int c;
        boolean d;
        boolean e;

        a() {
            b();
        }

        void a() {
            int f;
            if (this.d) {
                f = this.f766a.b();
            } else {
                f = this.f766a.f();
            }
            this.c = f;
        }

        void b() {
            this.f767b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f767b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        boolean a(View view, RecyclerView.s sVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < sVar.a();
        }

        public void b(View view, int i) {
            int h = this.f766a.h();
            if (h >= 0) {
                a(view, i);
                return;
            }
            this.f767b = i;
            if (this.d) {
                int b2 = (this.f766a.b() - h) - this.f766a.a(view);
                this.c = this.f766a.b() - b2;
                if (b2 > 0) {
                    int b3 = this.c - this.f766a.b(view);
                    int f = this.f766a.f();
                    int min = b3 - (f + Math.min(this.f766a.d(view) - f, 0));
                    if (min < 0) {
                        this.c += Math.min(b2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int d = this.f766a.d(view);
            int f2 = d - this.f766a.f();
            this.c = d;
            if (f2 > 0) {
                int b4 = (this.f766a.b() - Math.min(0, (this.f766a.b() - h) - this.f766a.a(view))) - (d + this.f766a.b(view));
                if (b4 < 0) {
                    this.c -= Math.min(f2, -b4);
                }
            }
        }

        public void a(View view, int i) {
            if (this.d) {
                this.c = this.f766a.a(view) + this.f766a.h();
            } else {
                this.c = this.f766a.d(view);
            }
            this.f767b = i;
        }
    }

    int c(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        this.t.f770a = true;
        E();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, sVar);
        c cVar = this.t;
        int a2 = cVar.g + a(oVar, cVar, sVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.u.a(-i);
        this.t.j = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && I()) ? -1 : 1 : (this.s != 1 && I()) ? 1 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.D = (SavedState) parcelable;
            y();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.s == 1;
    }

    private void g(int i, int i2) {
        this.t.c = i2 - this.u.f();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f771b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    public void b(boolean z) {
        a((String) null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        y();
    }

    private View j(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.x ? f(oVar, sVar) : h(oVar, sVar);
    }

    private View k(RecyclerView.o oVar, RecyclerView.s sVar) {
        return this.x ? h(oVar, sVar) : f(oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.s sVar) {
        return k(sVar);
    }

    private View f(RecyclerView.o oVar, RecyclerView.s sVar) {
        return e(0, e());
    }

    private int i(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        return H.a(sVar, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a() {
        return this.s == 0;
    }

    public void a(boolean z) {
        a((String) null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View b(int i) {
        int e = e();
        if (e == 0) {
            return null;
        }
        int l = i - l(c(0));
        if (l >= 0 && l < e) {
            View c2 = c(l);
            if (l(c2) == i) {
                return c2;
            }
        }
        return super.b(i);
    }

    private View h(RecyclerView.o oVar, RecyclerView.s sVar) {
        return e(e() - 1, -1);
    }

    private View g(RecyclerView.o oVar, RecyclerView.s sVar) {
        return a(oVar, sVar, 0, e(), sVar.a());
    }

    private boolean a(RecyclerView.o oVar, RecyclerView.s sVar, a aVar) {
        View m;
        int f;
        boolean z = false;
        if (e() == 0) {
            return false;
        }
        View g = g();
        if (g != null && aVar.a(g, sVar)) {
            aVar.b(g, l(g));
            return true;
        } else if (this.v != this.y) {
            return false;
        } else {
            if (aVar.d) {
                m = l(oVar, sVar);
            } else {
                m = m(oVar, sVar);
            }
            if (m != null) {
                aVar.a(m, l(m));
                if (!sVar.d() && C()) {
                    if ((this.u.d(m) >= this.u.b() || this.u.a(m) < this.u.f()) ? true : true) {
                        if (aVar.d) {
                            f = this.u.b();
                        } else {
                            f = this.u.f();
                        }
                        aVar.c = f;
                    }
                }
                return true;
            }
            return false;
        }
    }

    private View i(RecyclerView.o oVar, RecyclerView.s sVar) {
        return a(oVar, sVar, e() - 1, -1, sVar.a());
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = RecyclerView.i.a(context, attributeSet, i, i2);
        i(a2.f793a);
        a(a2.c);
        b(a2.d);
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2) {
        if (!sVar.e() || e() == 0 || sVar.d() || !C()) {
            return;
        }
        List<RecyclerView.v> f = oVar.f();
        int size = f.size();
        int l = l(c(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.v vVar = f.get(i5);
            if (!vVar.p()) {
                if (((vVar.i() < l) != this.x ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.u.b(vVar.f807b);
                } else {
                    i4 += this.u.b(vVar.f807b);
                }
            }
        }
        this.t.k = f;
        if (i3 > 0) {
            g(l(L()), i);
            c cVar = this.t;
            cVar.h = i3;
            cVar.c = 0;
            cVar.a();
            a(oVar, this.t, sVar, false);
        }
        if (i4 > 0) {
            f(l(K()), i2);
            c cVar2 = this.t;
            cVar2.h = i4;
            cVar2.c = 0;
            cVar2.a();
            a(oVar, this.t, sVar, false);
        }
        this.t.k = null;
    }

    private boolean a(RecyclerView.s sVar, a aVar) {
        int i;
        int d;
        if (!sVar.d() && (i = this.A) != -1) {
            if (i >= 0 && i < sVar.a()) {
                aVar.f767b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    aVar.d = this.D.c;
                    if (aVar.d) {
                        aVar.c = this.u.b() - this.D.f765b;
                    } else {
                        aVar.c = this.u.f() + this.D.f765b;
                    }
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View b2 = b(this.A);
                    if (b2 != null) {
                        if (this.u.b(b2) > this.u.g()) {
                            aVar.a();
                            return true;
                        } else if (this.u.d(b2) - this.u.f() < 0) {
                            aVar.c = this.u.f();
                            aVar.d = false;
                            return true;
                        } else if (this.u.b() - this.u.a(b2) < 0) {
                            aVar.c = this.u.b();
                            aVar.d = true;
                            return true;
                        } else {
                            if (aVar.d) {
                                d = this.u.a(b2) + this.u.h();
                            } else {
                                d = this.u.d(b2);
                            }
                            aVar.c = d;
                        }
                    } else {
                        if (e() > 0) {
                            aVar.d = (this.A < l(c(0))) == this.x;
                        }
                        aVar.a();
                    }
                    return true;
                } else {
                    boolean z = this.x;
                    aVar.d = z;
                    if (z) {
                        aVar.c = this.u.b() - this.B;
                    } else {
                        aVar.c = this.u.f() + this.B;
                    }
                    return true;
                }
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, a aVar) {
        if (a(sVar, aVar) || a(oVar, sVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f767b = this.y ? sVar.a() - 1 : 0;
    }

    private int b(int i, RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int f;
        int f2 = i - this.u.f();
        if (f2 > 0) {
            int i2 = -c(f2, oVar, sVar);
            int i3 = i + i2;
            if (!z || (f = i3 - this.u.f()) <= 0) {
                return i2;
            }
            this.u.a(-f);
            return i2 - f;
        }
        return 0;
    }

    private void b(a aVar) {
        g(aVar.f767b, aVar.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 0) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.s sVar) {
        return j(sVar);
    }

    private void b(RecyclerView.o oVar, int i) {
        if (i < 0) {
            return;
        }
        int e = e();
        if (!this.x) {
            for (int i2 = 0; i2 < e; i2++) {
                View c2 = c(i2);
                if (this.u.a(c2) > i || this.u.e(c2) > i) {
                    a(oVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = e - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View c3 = c(i4);
            if (this.u.a(c3) > i || this.u.e(c3) > i) {
                a(oVar, i3, i4);
                return;
            }
        }
    }

    private View b(boolean z, boolean z2) {
        if (this.x) {
            return a(e() - 1, -1, z, z2);
        }
        return a(0, e(), z, z2);
    }

    private int a(int i, RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int b2;
        int b3 = this.u.b() - i;
        if (b3 > 0) {
            int i2 = -c(-b3, oVar, sVar);
            int i3 = i + i2;
            if (!z || (b2 = this.u.b() - i3) <= 0) {
                return i2;
            }
            this.u.a(b2);
            return b2 + i2;
        }
        return 0;
    }

    private void a(a aVar) {
        f(aVar.f767b, aVar.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 1) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.s sVar) {
        return i(sVar);
    }

    private void a(int i, int i2, boolean z, RecyclerView.s sVar) {
        int f;
        this.t.l = J();
        this.t.h = h(sVar);
        c cVar = this.t;
        cVar.f = i;
        if (i == 1) {
            cVar.h += this.u.c();
            View K = K();
            this.t.e = this.x ? -1 : 1;
            c cVar2 = this.t;
            int l = l(K);
            c cVar3 = this.t;
            cVar2.d = l + cVar3.e;
            cVar3.f771b = this.u.a(K);
            f = this.u.a(K) - this.u.b();
        } else {
            View L = L();
            this.t.h += this.u.f();
            this.t.e = this.x ? 1 : -1;
            c cVar4 = this.t;
            int l2 = l(L);
            c cVar5 = this.t;
            cVar4.d = l2 + cVar5.e;
            cVar5.f771b = this.u.d(L);
            f = (-this.u.d(L)) + this.u.f();
        }
        c cVar6 = this.t;
        cVar6.c = i2;
        if (z) {
            cVar6.c -= f;
        }
        this.t.g = f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.s sVar) {
        return j(sVar);
    }

    View e(int i, int i2) {
        int i3;
        int i4;
        E();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return c(i);
        }
        if (this.u.d(c(i)) < this.u.f()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.s == 0) {
            return this.e.a(i, i2, i3, i4);
        }
        return this.f.a(i, i2, i3, i4);
    }

    void a(RecyclerView.s sVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.d;
        if (i < 0 || i >= sVar.a()) {
            return;
        }
        aVar.a(i, Math.max(0, cVar.g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            SavedState savedState2 = this.D;
            z = savedState2.c;
            i2 = savedState2.f764a;
        } else {
            M();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        int i4 = i2;
        for (int i5 = 0; i5 < this.G && i4 >= 0 && i4 < i; i5++) {
            aVar.a(i4, 0);
            i4 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.s sVar, RecyclerView.i.a aVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (e() == 0 || i == 0) {
            return;
        }
        E();
        a(i > 0 ? 1 : -1, Math.abs(i), true, sVar);
        a(sVar, this.t, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.D == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.o oVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                a(i, oVar);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            a(i3, oVar);
        }
    }

    private void a(RecyclerView.o oVar, int i) {
        int e = e();
        if (i < 0) {
            return;
        }
        int a2 = this.u.a() - i;
        if (this.x) {
            for (int i2 = 0; i2 < e; i2++) {
                View c2 = c(i2);
                if (this.u.d(c2) < a2 || this.u.f(c2) < a2) {
                    a(oVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = e - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View c3 = c(i4);
            if (this.u.d(c3) < a2 || this.u.f(c3) < a2) {
                a(oVar, i3, i4);
                return;
            }
        }
    }

    private void a(RecyclerView.o oVar, c cVar) {
        if (!cVar.f770a || cVar.l) {
            return;
        }
        if (cVar.f == -1) {
            a(oVar, cVar.g);
        } else {
            b(oVar, cVar.g);
        }
    }

    int a(RecyclerView.o oVar, c cVar, RecyclerView.s sVar, boolean z) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            a(oVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.a(sVar)) {
                break;
            }
            bVar.a();
            a(oVar, sVar, cVar, bVar);
            if (!bVar.f769b) {
                cVar.f771b += bVar.f768a * cVar.f;
                if (!bVar.c || this.t.k != null || !sVar.d()) {
                    int i4 = cVar.c;
                    int i5 = bVar.f768a;
                    cVar.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    cVar.g = i6 + bVar.f768a;
                    int i7 = cVar.c;
                    if (i7 < 0) {
                        cVar.g += i7;
                    }
                    a(oVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    void a(RecyclerView.o oVar, RecyclerView.s sVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int c2;
        View a2 = cVar.a(oVar);
        if (a2 == null) {
            bVar.f769b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.x == (cVar.f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f768a = this.u.b(a2);
        if (this.s == 1) {
            if (I()) {
                c2 = q() - o();
                i4 = c2 - this.u.c(a2);
            } else {
                i4 = n();
                c2 = this.u.c(a2) + i4;
            }
            if (cVar.f == -1) {
                int i5 = cVar.f771b;
                i3 = i5;
                i2 = c2;
                i = i5 - bVar.f768a;
            } else {
                int i6 = cVar.f771b;
                i = i6;
                i2 = c2;
                i3 = bVar.f768a + i6;
            }
        } else {
            int p = p();
            int c3 = this.u.c(a2) + p;
            if (cVar.f == -1) {
                int i7 = cVar.f771b;
                i2 = i7;
                i = p;
                i3 = c3;
                i4 = i7 - bVar.f768a;
            } else {
                int i8 = cVar.f771b;
                i = p;
                i2 = bVar.f768a + i8;
                i3 = c3;
                i4 = i8;
            }
        }
        a(a2, i4, i, i2, i3);
        if (layoutParams.c() || layoutParams.b()) {
            bVar.c = true;
        }
        bVar.d = a2.hasFocusable();
    }

    private View a(boolean z, boolean z2) {
        if (this.x) {
            return a(0, e(), z, z2);
        }
        return a(e() - 1, -1, z, z2);
    }

    View a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, int i3) {
        E();
        int f = this.u.f();
        int b2 = this.u.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View c2 = c(i);
            int l = l(c2);
            if (l >= 0 && l < i3) {
                if (((RecyclerView.LayoutParams) c2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = c2;
                    }
                } else if (this.u.d(c2) < b2 && this.u.a(c2) >= f) {
                    return c2;
                } else {
                    if (view == null) {
                        view = c2;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    View a(int i, int i2, boolean z, boolean z2) {
        E();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.s == 0) {
            return this.e.a(i, i2, i3, i4);
        }
        return this.f.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        int h;
        View j;
        View K;
        M();
        if (e() == 0 || (h = h(i)) == Integer.MIN_VALUE) {
            return null;
        }
        E();
        E();
        a(h, (int) (this.u.g() * 0.33333334f), false, sVar);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.f770a = false;
        a(oVar, cVar, sVar, true);
        if (h == -1) {
            j = k(oVar, sVar);
        } else {
            j = j(oVar, sVar);
        }
        if (h == -1) {
            K = L();
        } else {
            K = K();
        }
        if (K.hasFocusable()) {
            if (j == null) {
                return null;
            }
            return K;
        }
        return j;
    }
}
