package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.c;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.r.a {
    private BitSet B;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private int[] O;
    b[] t;
    w u;
    w v;
    private int w;
    private int x;
    private final r y;
    private int s = -1;
    boolean z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private final Rect K = new Rect();
    private final a L = new a();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new J(this);

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        b e;
        boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            b bVar = this.e;
            if (bVar == null) {
                return -1;
            }
            return bVar.e;
        }

        public boolean f() {
            return this.f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new L();

        /* renamed from: a  reason: collision with root package name */
        int f812a;

        /* renamed from: b  reason: collision with root package name */
        int f813b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        public SavedState() {
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f812a);
            parcel.writeInt(this.f813b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel) {
            this.f812a = parcel.readInt();
            this.f813b = parcel.readInt();
            this.c = parcel.readInt();
            int i = this.c;
            if (i > 0) {
                this.d = new int[i];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            int i2 = this.e;
            if (i2 > 0) {
                this.f = new int[i2];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.f812a = savedState.f812a;
            this.f813b = savedState.f813b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f816a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f817b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        b(int i) {
            this.e = i;
        }

        int a(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f816a.size() == 0) {
                return i;
            }
            a();
            return this.c;
        }

        int b(int i) {
            int i2 = this.f817b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f816a.size() == 0) {
                return i;
            }
            b();
            return this.f817b;
        }

        void c(View view) {
            LayoutParams b2 = b(view);
            b2.e = this;
            this.f816a.add(0, view);
            this.f817b = Integer.MIN_VALUE;
            if (this.f816a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        void d(int i) {
            this.f817b = i;
            this.c = i;
        }

        public int e() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(0, this.f816a.size(), true);
            }
            return a(this.f816a.size() - 1, -1, true);
        }

        public int f() {
            return this.d;
        }

        int g() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.c;
        }

        int h() {
            int i = this.f817b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            b();
            return this.f817b;
        }

        void i() {
            this.f817b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void j() {
            int size = this.f816a.size();
            View remove = this.f816a.remove(size - 1);
            LayoutParams b2 = b(remove);
            b2.e = null;
            if (b2.c() || b2.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            if (size == 1) {
                this.f817b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void k() {
            View remove = this.f816a.remove(0);
            LayoutParams b2 = b(remove);
            b2.e = null;
            if (this.f816a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            this.f817b = Integer.MIN_VALUE;
        }

        public int d() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(this.f816a.size() - 1, -1, true);
            }
            return a(0, this.f816a.size(), true);
        }

        void a() {
            LazySpanLookup.FullSpanItem c;
            ArrayList<View> arrayList = this.f816a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams b2 = b(view);
            this.c = StaggeredGridLayoutManager.this.u.a(view);
            if (b2.f && (c = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c.f811b == 1) {
                this.c += c.a(this.e);
            }
        }

        void b() {
            LazySpanLookup.FullSpanItem c;
            View view = this.f816a.get(0);
            LayoutParams b2 = b(view);
            this.f817b = StaggeredGridLayoutManager.this.u.d(view);
            if (b2.f && (c = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c.f811b == -1) {
                this.f817b -= c.a(this.e);
            }
        }

        void c() {
            this.f816a.clear();
            i();
            this.d = 0;
        }

        void c(int i) {
            int i2 = this.f817b;
            if (i2 != Integer.MIN_VALUE) {
                this.f817b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        void a(View view) {
            LayoutParams b2 = b(view);
            b2.e = this;
            this.f816a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.f816a.size() == 1) {
                this.f817b = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        LayoutParams b(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void a(boolean z, int i) {
            int b2;
            if (z) {
                b2 = a(Integer.MIN_VALUE);
            } else {
                b2 = b(Integer.MIN_VALUE);
            }
            c();
            if (b2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || b2 >= StaggeredGridLayoutManager.this.u.b()) {
                if (z || b2 <= StaggeredGridLayoutManager.this.u.f()) {
                    if (i != Integer.MIN_VALUE) {
                        b2 += i;
                    }
                    this.c = b2;
                    this.f817b = b2;
                }
            }
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int f = StaggeredGridLayoutManager.this.u.f();
            int b2 = StaggeredGridLayoutManager.this.u.b();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f816a.get(i);
                int d = StaggeredGridLayoutManager.this.u.d(view);
                int a2 = StaggeredGridLayoutManager.this.u.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d >= b2 : d > b2;
                if (!z3 ? a2 > f : a2 >= f) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (d >= f && a2 <= b2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                    } else if (z2) {
                        return StaggeredGridLayoutManager.this.l(view);
                    } else {
                        if (d < f || a2 > b2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f816a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f816a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.l(view2) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.l(view2) >= i) || !view2.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f816a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f816a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.l(view3) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.l(view3) <= i) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = RecyclerView.i.a(context, attributeSet, i, i2);
        h(a2.f793a);
        i(a2.f794b);
        c(a2.c);
        this.y = new r();
        M();
    }

    private void M() {
        this.u = w.a(this, this.w);
        this.v = w.a(this, 1 - this.w);
    }

    private void N() {
        if (this.v.d() == 1073741824) {
            return;
        }
        int e = e();
        float f = 0.0f;
        for (int i = 0; i < e; i++) {
            View c = c(i);
            float b2 = this.v.b(c);
            if (b2 >= f) {
                if (((LayoutParams) c.getLayoutParams()).f()) {
                    b2 = (b2 * 1.0f) / this.s;
                }
                f = Math.max(f, b2);
            }
        }
        int i2 = this.x;
        int round = Math.round(f * this.s);
        if (this.v.d() == Integer.MIN_VALUE) {
            round = Math.min(round, this.v.g());
        }
        j(round);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < e; i3++) {
            View c2 = c(i3);
            LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
            if (!layoutParams.f) {
                if (L() && this.w == 1) {
                    int i4 = this.s;
                    int i5 = layoutParams.e.e;
                    c2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.e.e;
                    int i7 = this.x * i6;
                    int i8 = i6 * i2;
                    if (this.w == 1) {
                        c2.offsetLeftAndRight(i7 - i8);
                    } else {
                        c2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    private void O() {
        if (this.w != 1 && L()) {
            this.A = !this.z;
        } else {
            this.A = this.z;
        }
    }

    private boolean a(b bVar) {
        if (this.A) {
            if (bVar.g() < this.u.b()) {
                ArrayList<View> arrayList = bVar.f816a;
                return !bVar.b(arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (bVar.h() > this.u.f()) {
            return !bVar.b(bVar.f816a.get(0)).f;
        }
        return false;
    }

    private int k(int i) {
        if (e() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < H()) != this.A ? -1 : 1;
    }

    private int l(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && L()) ? -1 : 1 : (this.w != 1 && L()) ? 1 : -1;
    }

    private LazySpanLookup.FullSpanItem m(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.c[i2] = i - this.t[i2].a(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.c[i2] = this.t[i2].b(i) - i;
        }
        return fullSpanItem;
    }

    private int o(int i) {
        int e = e();
        for (int i2 = 0; i2 < e; i2++) {
            int l = l(c(i2));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private void p(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private void q(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].c(view);
        }
    }

    private int r(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int s(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int t(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void v(int i) {
        r rVar = this.y;
        rVar.e = i;
        rVar.d = this.A != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean C() {
        return this.I == null;
    }

    boolean D() {
        int a2 = this.t[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    boolean E() {
        int b2 = this.t[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F() {
        int H;
        int I;
        if (e() == 0 || this.F == 0 || !t()) {
            return false;
        }
        if (this.A) {
            H = I();
            I = H();
        } else {
            H = H();
            I = I();
        }
        if (H == 0 && J() != null) {
            this.E.a();
            z();
            y();
            return true;
        } else if (this.M) {
            int i = this.A ? -1 : 1;
            int i2 = I + 1;
            LazySpanLookup.FullSpanItem a2 = this.E.a(H, i2, i, true);
            if (a2 == null) {
                this.M = false;
                this.E.b(i2);
                return false;
            }
            LazySpanLookup.FullSpanItem a3 = this.E.a(H, a2.f810a, i * (-1), true);
            if (a3 == null) {
                this.E.b(a2.f810a);
            } else {
                this.E.b(a3.f810a + 1);
            }
            z();
            y();
            return true;
        } else {
            return false;
        }
    }

    int G() {
        View a2 = this.A ? a(true) : b(true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    int H() {
        if (e() == 0) {
            return 0;
        }
        return l(c(0));
    }

    int I() {
        int e = e();
        if (e == 0) {
            return 0;
        }
        return l(c(e - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View J() {
        /*
            r12 = this;
            int r0 = r12.e()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.L()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.A
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.c(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.e
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.e
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.e
            int r9 = r9.e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.c(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.w r10 = r12.u
            int r10 = r10.a(r7)
            androidx.recyclerview.widget.w r11 = r12.u
            int r11 = r11.a(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.w r10 = r12.u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.w r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = r8.e
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r9.e
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.J():android.view.View");
    }

    public void K() {
        this.E.a();
        y();
    }

    boolean L() {
        return j() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.b(recyclerView, oVar);
        a(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].c();
        }
        recyclerView.requestLayout();
    }

    public void c(boolean z) {
        a((String) null);
        SavedState savedState = this.I;
        if (savedState != null && savedState.h != z) {
            savedState.h = z;
        }
        this.z = z;
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.s sVar) {
        return h(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(RecyclerView.o oVar, RecyclerView.s sVar) {
        c(oVar, sVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void f(int i) {
        if (i == 0) {
            F();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void g(RecyclerView.s sVar) {
        super.g(sVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    public void h(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a((String) null);
        if (i == this.w) {
            return;
        }
        this.w = i;
        w wVar = this.u;
        this.u = this.v;
        this.v = wVar;
        y();
    }

    public void i(int i) {
        a((String) null);
        if (i != this.s) {
            K();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new b[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new b(i2);
            }
            y();
        }
    }

    void j(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean u() {
        return this.F != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable x() {
        int b2;
        int f;
        int[] iArr;
        SavedState savedState = this.I;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.h = this.z;
        savedState2.i = this.G;
        savedState2.j = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup != null && (iArr = lazySpanLookup.f808a) != null) {
            savedState2.f = iArr;
            savedState2.e = savedState2.f.length;
            savedState2.g = lazySpanLookup.f809b;
        } else {
            savedState2.e = 0;
        }
        if (e() > 0) {
            savedState2.f812a = this.G ? I() : H();
            savedState2.f813b = G();
            int i = this.s;
            savedState2.c = i;
            savedState2.d = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    b2 = this.t[i2].a(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        f = this.u.b();
                        b2 -= f;
                        savedState2.d[i2] = b2;
                    } else {
                        savedState2.d[i2] = b2;
                    }
                } else {
                    b2 = this.t[i2].b(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        f = this.u.f();
                        b2 -= f;
                        savedState2.d[i2] = b2;
                    } else {
                        savedState2.d[i2] = b2;
                    }
                }
            }
        } else {
            savedState2.f812a = -1;
            savedState2.f813b = -1;
            savedState2.c = 0;
        }
        return savedState2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f808a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f809b;

        LazySpanLookup() {
        }

        private void c(int i, int i2) {
            List<FullSpanItem> list = this.f809b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f809b.get(size);
                int i3 = fullSpanItem.f810a;
                if (i3 >= i) {
                    fullSpanItem.f810a = i3 + i2;
                }
            }
        }

        private int g(int i) {
            if (this.f809b == null) {
                return -1;
            }
            FullSpanItem c = c(i);
            if (c != null) {
                this.f809b.remove(c);
            }
            int size = this.f809b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f809b.get(i2).f810a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.f809b.remove(i2);
                return this.f809b.get(i2).f810a;
            }
            return -1;
        }

        void a(int i, b bVar) {
            a(i);
            this.f808a[i] = bVar.e;
        }

        int b(int i) {
            List<FullSpanItem> list = this.f809b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f809b.get(size).f810a >= i) {
                        this.f809b.remove(size);
                    }
                }
            }
            return e(i);
        }

        int d(int i) {
            int[] iArr = this.f808a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int e(int i) {
            int[] iArr = this.f808a;
            if (iArr != null && i < iArr.length) {
                int g = g(i);
                if (g == -1) {
                    int[] iArr2 = this.f808a;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.f808a.length;
                }
                int i2 = g + 1;
                Arrays.fill(this.f808a, i, i2, -1);
                return i2;
            }
            return -1;
        }

        int f(int i) {
            int length = this.f808a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        private void d(int i, int i2) {
            List<FullSpanItem> list = this.f809b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f809b.get(size);
                int i4 = fullSpanItem.f810a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f809b.remove(size);
                    } else {
                        fullSpanItem.f810a = i4 - i2;
                    }
                }
            }
        }

        void a(int i) {
            int[] iArr = this.f808a;
            if (iArr == null) {
                this.f808a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f808a, -1);
            } else if (i >= iArr.length) {
                this.f808a = new int[f(i)];
                System.arraycopy(iArr, 0, this.f808a, 0, iArr.length);
                int[] iArr2 = this.f808a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        public FullSpanItem c(int i) {
            List<FullSpanItem> list = this.f809b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f809b.get(size);
                if (fullSpanItem.f810a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new K();

            /* renamed from: a  reason: collision with root package name */
            int f810a;

            /* renamed from: b  reason: collision with root package name */
            int f811b;
            int[] c;
            boolean d;

            /* JADX INFO: Access modifiers changed from: package-private */
            public FullSpanItem(Parcel parcel) {
                this.f810a = parcel.readInt();
                this.f811b = parcel.readInt();
                this.d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int i) {
                int[] iArr = this.c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f810a + ", mGapDir=" + this.f811b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f810a);
                parcel.writeInt(this.f811b);
                parcel.writeInt(this.d ? 1 : 0);
                int[] iArr = this.c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.c);
                    return;
                }
                parcel.writeInt(0);
            }

            FullSpanItem() {
            }
        }

        void b(int i, int i2) {
            int[] iArr = this.f808a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.f808a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f808a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            d(i, i2);
        }

        void a() {
            int[] iArr = this.f808a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f809b = null;
        }

        void a(int i, int i2) {
            int[] iArr = this.f808a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.f808a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f808a, i, i3, -1);
            c(i, i2);
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f809b == null) {
                this.f809b = new ArrayList();
            }
            int size = this.f809b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f809b.get(i);
                if (fullSpanItem2.f810a == fullSpanItem.f810a) {
                    this.f809b.remove(i);
                }
                if (fullSpanItem2.f810a >= fullSpanItem.f810a) {
                    this.f809b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f809b.add(fullSpanItem);
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f809b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f809b.get(i4);
                int i5 = fullSpanItem.f810a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.f811b == i3 || (z && fullSpanItem.d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    private int d(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private boolean u(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == L();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.s sVar) {
        return i(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int f(RecyclerView.s sVar) {
        return j(sVar);
    }

    private int p(int i) {
        for (int e = e() - 1; e >= 0; e--) {
            int l = l(c(e));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private int q(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        super.e(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f814a;

        /* renamed from: b  reason: collision with root package name */
        int f815b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            b();
        }

        void a(b[] bVarArr) {
            int length = bVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = bVarArr[i].b(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.f814a = -1;
            this.f815b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void a() {
            this.f815b = this.c ? StaggeredGridLayoutManager.this.u.b() : StaggeredGridLayoutManager.this.u.f();
        }

        void a(int i) {
            if (this.c) {
                this.f815b = StaggeredGridLayoutManager.this.u.b() - i;
            } else {
                this.f815b = StaggeredGridLayoutManager.this.u.f() + i;
            }
        }
    }

    private int j(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        return H.b(sVar, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void d(int i) {
        super.d(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0157, code lost:
        if (F() != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(androidx.recyclerview.widget.RecyclerView.o r9, androidx.recyclerview.widget.RecyclerView.s r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, boolean):void");
    }

    private void e(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f816a.isEmpty()) {
                a(this.t[i3], i, i2);
            }
        }
    }

    void b(RecyclerView.s sVar, a aVar) {
        if (a(sVar, aVar) || c(sVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f814a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void d(RecyclerView recyclerView) {
        this.E.a();
        y();
    }

    private int h(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        return H.a(sVar, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    private int i(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        return H.a(sVar, this.u, b(!this.N), a(!this.N), this, this.N, this.A);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.I == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.s sVar) {
        return i(sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.w == 0) {
            return this.s;
        }
        return super.b(oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int a2;
        int a3;
        int n = n() + o();
        int p = p() + m();
        if (this.w == 1) {
            a3 = RecyclerView.i.a(i2, rect.height() + p, k());
            a2 = RecyclerView.i.a(i, (this.x * this.s) + n, l());
        } else {
            a2 = RecyclerView.i.a(i, rect.width() + n, l());
            a3 = RecyclerView.i.a(i2, (this.x * this.s) + p, k());
        }
        c(a2, a3);
    }

    View b(boolean z) {
        int f = this.u.f();
        int b2 = this.u.b();
        int e = e();
        View view = null;
        for (int i = 0; i < e; i++) {
            View c = c(i);
            int d = this.u.d(c);
            if (this.u.a(c) > f && d < b2) {
                if (d >= f || !z) {
                    return c;
                }
                if (view == null) {
                    view = c;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int f;
        int t = t(Integer.MAX_VALUE);
        if (t != Integer.MAX_VALUE && (f = t - this.u.f()) > 0) {
            int c = f - c(f, oVar, sVar);
            if (!z || c <= 0) {
                return;
            }
            this.u.a(-c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.s r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.r r0 = r4.y
            r1 = 0
            r0.f860b = r1
            r0.c = r5
            boolean r0 = r4.w()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.b()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.w r5 = r4.u
            int r5 = r5.g()
            goto L2f
        L25:
            androidx.recyclerview.widget.w r5 = r4.u
            int r5 = r5.g()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.f()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.r r0 = r4.y
            androidx.recyclerview.widget.w r3 = r4.u
            int r3 = r3.f()
            int r3 = r3 - r6
            r0.f = r3
            androidx.recyclerview.widget.r r6 = r4.y
            androidx.recyclerview.widget.w r0 = r4.u
            int r0 = r0.b()
            int r0 = r0 + r5
            r6.g = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.r r0 = r4.y
            androidx.recyclerview.widget.w r3 = r4.u
            int r3 = r3.a()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.r r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L5d:
            androidx.recyclerview.widget.r r5 = r4.y
            r5.h = r1
            r5.f859a = r2
            androidx.recyclerview.widget.w r6 = r4.u
            int r6 = r6.d()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.w r6 = r4.u
            int r6 = r6.a()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$s):void");
    }

    private void a(a aVar) {
        int f;
        SavedState savedState = this.I;
        int i = savedState.c;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].c();
                    SavedState savedState2 = this.I;
                    int i3 = savedState2.d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        if (savedState2.i) {
                            f = this.u.b();
                        } else {
                            f = this.u.f();
                        }
                        i3 += f;
                    }
                    this.t[i2].d(i3);
                }
            } else {
                savedState.a();
                SavedState savedState3 = this.I;
                savedState3.f812a = savedState3.f813b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.j;
        c(savedState4.h);
        O();
        SavedState savedState5 = this.I;
        int i4 = savedState5.f812a;
        if (i4 != -1) {
            this.C = i4;
            aVar.c = savedState5.i;
        } else {
            aVar.c = this.A;
        }
        SavedState savedState6 = this.I;
        if (savedState6.e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f808a = savedState6.f;
            lazySpanLookup.f809b = savedState6.g;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    private void b(RecyclerView.o oVar, int i) {
        while (e() > 0) {
            View c = c(0);
            if (this.u.a(c) > i || this.u.e(c) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
            if (layoutParams.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f816a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].k();
                }
            } else if (layoutParams.e.f816a.size() == 1) {
                return;
            } else {
                layoutParams.e.k();
            }
            a(c, oVar);
        }
    }

    boolean a(RecyclerView.s sVar, a aVar) {
        int i;
        int f;
        if (!sVar.d() && (i = this.C) != -1) {
            if (i >= 0 && i < sVar.a()) {
                SavedState savedState = this.I;
                if (savedState != null && savedState.f812a != -1 && savedState.c >= 1) {
                    aVar.f815b = Integer.MIN_VALUE;
                    aVar.f814a = this.C;
                } else {
                    View b2 = b(this.C);
                    if (b2 != null) {
                        aVar.f814a = this.A ? I() : H();
                        if (this.D != Integer.MIN_VALUE) {
                            if (aVar.c) {
                                aVar.f815b = (this.u.b() - this.D) - this.u.a(b2);
                            } else {
                                aVar.f815b = (this.u.f() + this.D) - this.u.d(b2);
                            }
                            return true;
                        } else if (this.u.b(b2) > this.u.g()) {
                            if (aVar.c) {
                                f = this.u.b();
                            } else {
                                f = this.u.f();
                            }
                            aVar.f815b = f;
                            return true;
                        } else {
                            int d = this.u.d(b2) - this.u.f();
                            if (d < 0) {
                                aVar.f815b = -d;
                                return true;
                            }
                            int b3 = this.u.b() - this.u.a(b2);
                            if (b3 < 0) {
                                aVar.f815b = b3;
                                return true;
                            }
                            aVar.f815b = Integer.MIN_VALUE;
                        }
                    } else {
                        aVar.f814a = this.C;
                        int i2 = this.D;
                        if (i2 == Integer.MIN_VALUE) {
                            aVar.c = k(aVar.f814a) == 1;
                            aVar.a();
                        } else {
                            aVar.a(i2);
                        }
                        aVar.d = true;
                    }
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean b() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    private boolean c(RecyclerView.s sVar, a aVar) {
        int o;
        if (this.G) {
            o = p(sVar.a());
        } else {
            o = o(sVar.a());
        }
        aVar.f814a = o;
        aVar.f815b = Integer.MIN_VALUE;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.s sVar) {
        return j(sVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.I()
            goto Ld
        L9:
            int r0 = r6.H()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.e(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.a(r8, r4)
            goto L43
        L38:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.b(r7, r8)
            goto L43
        L3e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.a(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.A
            if (r7 == 0) goto L4f
            int r7 = r6.H()
            goto L53
        L4f:
            int r7 = r6.I()
        L53:
            if (r2 > r7) goto L58
            r6.y()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.s sVar) {
        return h(sVar);
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f) {
            if (this.w == 1) {
                a(view, this.J, RecyclerView.i.a(h(), i(), p() + m(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
            } else {
                a(view, RecyclerView.i.a(q(), r(), n() + o(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.J, z);
            }
        } else if (this.w == 1) {
            a(view, RecyclerView.i.a(this.x, r(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.i.a(h(), i(), p() + m(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
        } else {
            a(view, RecyclerView.i.a(q(), r(), n() + o(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.i.a(this.x, i(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z);
        }
    }

    int c(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        a(i, sVar);
        int a2 = a(oVar, this.y, sVar);
        if (this.y.f860b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.u.a(-i);
        this.G = this.A;
        r rVar = this.y;
        rVar.f860b = 0;
        a(oVar, rVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams c() {
        if (this.w == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean a2;
        a(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.K;
        int d = d(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.K;
        int d2 = d(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z) {
            a2 = b(view, d, d2, layoutParams);
        } else {
            a2 = a(view, d, d2, layoutParams);
        }
        if (a2) {
            view.measure(d, d2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.I = (SavedState) parcelable;
            y();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, View view, androidx.core.h.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.w == 0) {
            cVar.b(c.C0014c.a(layoutParams2.e(), layoutParams2.f ? this.s : 1, -1, -1, layoutParams2.f, false));
        } else {
            cVar.b(c.C0014c.a(-1, -1, layoutParams2.e(), layoutParams2.f ? this.s : 1, layoutParams2.f, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            View b2 = b(false);
            View a2 = a(false);
            if (b2 == null || a2 == null) {
                return;
            }
            int l = l(b2);
            int l2 = l(a2);
            if (l < l2) {
                accessibilityEvent.setFromIndex(l);
                accessibilityEvent.setToIndex(l2);
                return;
            }
            accessibilityEvent.setFromIndex(l2);
            accessibilityEvent.setToIndex(l);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.w == 1) {
            return this.s;
        }
        return super.a(oVar, sVar);
    }

    View a(boolean z) {
        int f = this.u.f();
        int b2 = this.u.b();
        View view = null;
        for (int e = e() - 1; e >= 0; e--) {
            View c = c(e);
            int d = this.u.d(c);
            int a2 = this.u.a(c);
            if (a2 > f && d < b2) {
                if (a2 <= b2 || !z) {
                    return c;
                }
                if (view == null) {
                    view = c;
                }
            }
        }
        return view;
    }

    private void a(RecyclerView.o oVar, RecyclerView.s sVar, boolean z) {
        int b2;
        int q = q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE && (b2 = this.u.b() - q) > 0) {
            int i = b2 - (-c(-b2, oVar, sVar));
            if (!z || i <= 0) {
                return;
            }
            this.u.a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a(RecyclerView.o oVar, r rVar, RecyclerView.s sVar) {
        int i;
        int i2;
        int f;
        int q;
        b bVar;
        int b2;
        int i3;
        int i4;
        int b3;
        boolean E;
        ?? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            i2 = rVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (rVar.e == 1) {
                i = rVar.g + rVar.f860b;
            } else {
                i = rVar.f - rVar.f860b;
            }
            i2 = i;
        }
        e(rVar.e, i2);
        if (this.A) {
            f = this.u.b();
        } else {
            f = this.u.f();
        }
        int i5 = f;
        boolean z = false;
        while (rVar.a(sVar) && (this.y.i || !this.B.isEmpty())) {
            View a2 = rVar.a(oVar);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int a3 = layoutParams.a();
            int d = this.E.d(a3);
            boolean z2 = d == -1;
            if (z2) {
                bVar = layoutParams.f ? this.t[r9] : a(rVar);
                this.E.a(a3, bVar);
            } else {
                bVar = this.t[d];
            }
            b bVar2 = bVar;
            layoutParams.e = bVar2;
            if (rVar.e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, layoutParams, (boolean) r9);
            if (rVar.e == 1) {
                int q2 = layoutParams.f ? q(i5) : bVar2.a(i5);
                int b4 = this.u.b(a2) + q2;
                if (z2 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem m = m(q2);
                    m.f811b = -1;
                    m.f810a = a3;
                    this.E.a(m);
                }
                i3 = b4;
                b2 = q2;
            } else {
                int t = layoutParams.f ? t(i5) : bVar2.b(i5);
                b2 = t - this.u.b(a2);
                if (z2 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem n = n(t);
                    n.f811b = 1;
                    n.f810a = a3;
                    this.E.a(n);
                }
                i3 = t;
            }
            if (layoutParams.f && rVar.d == -1) {
                if (z2) {
                    this.M = true;
                } else {
                    if (rVar.e == 1) {
                        E = D();
                    } else {
                        E = E();
                    }
                    if (!E) {
                        LazySpanLookup.FullSpanItem c = this.E.c(a3);
                        if (c != null) {
                            c.d = true;
                        }
                        this.M = true;
                    }
                }
            }
            a(a2, layoutParams, rVar);
            if (L() && this.w == 1) {
                int b5 = layoutParams.f ? this.v.b() : this.v.b() - (((this.s - 1) - bVar2.e) * this.x);
                b3 = b5;
                i4 = b5 - this.v.b(a2);
            } else {
                int f2 = layoutParams.f ? this.v.f() : (bVar2.e * this.x) + this.v.f();
                i4 = f2;
                b3 = this.v.b(a2) + f2;
            }
            if (this.w == 1) {
                a(a2, i4, b2, b3, i3);
            } else {
                a(a2, b2, i4, i3, b3);
            }
            if (layoutParams.f) {
                e(this.y.e, i2);
            } else {
                a(bVar2, this.y.e, i2);
            }
            a(oVar, this.y);
            if (this.y.h && a2.hasFocusable()) {
                if (layoutParams.f) {
                    this.B.clear();
                } else {
                    this.B.set(bVar2.e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(oVar, this.y);
        }
        if (this.y.e == -1) {
            q = this.u.f() - t(this.u.f());
        } else {
            q = q(this.u.b()) - this.u.b();
        }
        if (q > 0) {
            return Math.min(rVar.f860b, q);
        }
        return 0;
    }

    private void a(View view, LayoutParams layoutParams, r rVar) {
        if (rVar.e == 1) {
            if (layoutParams.f) {
                p(view);
            } else {
                layoutParams.e.a(view);
            }
        } else if (layoutParams.f) {
            q(view);
        } else {
            layoutParams.e.c(view);
        }
    }

    private void a(RecyclerView.o oVar, r rVar) {
        int min;
        int min2;
        if (!rVar.f859a || rVar.i) {
            return;
        }
        if (rVar.f860b == 0) {
            if (rVar.e == -1) {
                a(oVar, rVar.g);
            } else {
                b(oVar, rVar.f);
            }
        } else if (rVar.e == -1) {
            int i = rVar.f;
            int r = i - r(i);
            if (r < 0) {
                min2 = rVar.g;
            } else {
                min2 = rVar.g - Math.min(r, rVar.f860b);
            }
            a(oVar, min2);
        } else {
            int s = s(rVar.g) - rVar.g;
            if (s < 0) {
                min = rVar.f;
            } else {
                min = Math.min(s, rVar.f860b) + rVar.f;
            }
            b(oVar, min);
        }
    }

    private void a(b bVar, int i, int i2) {
        int f = bVar.f();
        if (i == -1) {
            if (bVar.h() + f <= i2) {
                this.B.set(bVar.e, false);
            }
        } else if (bVar.g() - f >= i2) {
            this.B.set(bVar.e, false);
        }
    }

    private void a(RecyclerView.o oVar, int i) {
        for (int e = e() - 1; e >= 0; e--) {
            View c = c(e);
            if (this.u.d(c) < i || this.u.f(c) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
            if (layoutParams.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f816a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].j();
                }
            } else if (layoutParams.e.f816a.size() == 1) {
                return;
            } else {
                layoutParams.e.j();
            }
            a(c, oVar);
        }
    }

    private b a(r rVar) {
        int i;
        int i2;
        int i3 = -1;
        if (u(rVar.e)) {
            i = this.s - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.s;
            i2 = 1;
        }
        b bVar = null;
        if (rVar.e == 1) {
            int i4 = Integer.MAX_VALUE;
            int f = this.u.f();
            while (i != i3) {
                b bVar2 = this.t[i];
                int a2 = bVar2.a(f);
                if (a2 < i4) {
                    bVar = bVar2;
                    i4 = a2;
                }
                i += i2;
            }
            return bVar;
        }
        int i5 = Integer.MIN_VALUE;
        int b2 = this.u.b();
        while (i != i3) {
            b bVar3 = this.t[i];
            int b3 = bVar3.b(b2);
            if (b3 > i5) {
                bVar = bVar3;
                i5 = b3;
            }
            i += i2;
        }
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.s sVar, RecyclerView.i.a aVar) {
        int a2;
        int i3;
        if (this.w != 0) {
            i = i2;
        }
        if (e() == 0 || i == 0) {
            return;
        }
        a(i, sVar);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.s; i5++) {
            r rVar = this.y;
            if (rVar.d == -1) {
                a2 = rVar.f;
                i3 = this.t[i5].b(a2);
            } else {
                a2 = this.t[i5].a(rVar.g);
                i3 = this.y.g;
            }
            int i6 = a2 - i3;
            if (i6 >= 0) {
                this.O[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.O, 0, i4);
        for (int i7 = 0; i7 < i4 && this.y.a(sVar); i7++) {
            aVar.a(this.y.c, this.O[i7]);
            r rVar2 = this.y;
            rVar2.c += rVar2.d;
        }
    }

    void a(int i, RecyclerView.s sVar) {
        int H;
        int i2;
        if (i > 0) {
            H = I();
            i2 = 1;
        } else {
            H = H();
            i2 = -1;
        }
        this.y.f859a = true;
        b(H, sVar);
        v(i2);
        r rVar = this.y;
        rVar.c = H + rVar.d;
        rVar.f860b = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        View c;
        int H;
        int e;
        int e2;
        int e3;
        View a2;
        if (e() == 0 || (c = c(view)) == null) {
            return null;
        }
        O();
        int l = l(i);
        if (l == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) c.getLayoutParams();
        boolean z = layoutParams.f;
        b bVar = layoutParams.e;
        if (l == 1) {
            H = I();
        } else {
            H = H();
        }
        b(H, sVar);
        v(l);
        r rVar = this.y;
        rVar.c = rVar.d + H;
        rVar.f860b = (int) (this.u.g() * 0.33333334f);
        r rVar2 = this.y;
        rVar2.h = true;
        rVar2.f859a = false;
        a(oVar, rVar2, sVar);
        this.G = this.A;
        if (z || (a2 = bVar.a(H, l)) == null || a2 == c) {
            if (u(l)) {
                for (int i2 = this.s - 1; i2 >= 0; i2--) {
                    View a3 = this.t[i2].a(H, l);
                    if (a3 != null && a3 != c) {
                        return a3;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.s; i3++) {
                    View a4 = this.t[i3].a(H, l);
                    if (a4 != null && a4 != c) {
                        return a4;
                    }
                }
            }
            boolean z2 = (this.z ^ true) == (l == -1);
            if (!z) {
                if (z2) {
                    e3 = bVar.d();
                } else {
                    e3 = bVar.e();
                }
                View b2 = b(e3);
                if (b2 != null && b2 != c) {
                    return b2;
                }
            }
            if (u(l)) {
                for (int i4 = this.s - 1; i4 >= 0; i4--) {
                    if (i4 != bVar.e) {
                        if (z2) {
                            e2 = this.t[i4].d();
                        } else {
                            e2 = this.t[i4].e();
                        }
                        View b3 = b(e2);
                        if (b3 != null && b3 != c) {
                            return b3;
                        }
                    }
                }
            } else {
                for (int i5 = 0; i5 < this.s; i5++) {
                    if (z2) {
                        e = this.t[i5].d();
                    } else {
                        e = this.t[i5].e();
                    }
                    View b4 = b(e);
                    if (b4 != null && b4 != c) {
                        return b4;
                    }
                }
            }
            return null;
        }
        return a2;
    }
}
