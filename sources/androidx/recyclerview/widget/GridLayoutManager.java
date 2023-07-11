package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.a.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean H;
    int I;
    int[] J;
    View[] K;
    final SparseIntArray L;
    final SparseIntArray M;
    b N;
    final Rect O;

    /* loaded from: classes.dex */
    public static final class a extends b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int a(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int c(int i, int i2) {
            return i % i2;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f761a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        private boolean f762b = false;

        public abstract int a(int i);

        public void a() {
            this.f761a.clear();
        }

        public int b(int i, int i2) {
            int a2 = a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a3 = a(i5);
                i3 += a3;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a3;
                }
            }
            return i3 + a2 > i2 ? i4 + 1 : i4;
        }

        public abstract int c(int i, int i2);

        int a(int i, int i2) {
            if (!this.f762b) {
                return c(i, i2);
            }
            int i3 = this.f761a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int c = c(i, i2);
            this.f761a.put(i, c);
            return c;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        j(RecyclerView.i.a(context, attributeSet, i, i2).f794b);
    }

    private void N() {
        int e = e();
        for (int i = 0; i < e; i++) {
            LayoutParams layoutParams = (LayoutParams) c(i).getLayoutParams();
            int a2 = layoutParams.a();
            this.L.put(a2, layoutParams.f());
            this.M.put(a2, layoutParams.e());
        }
    }

    private void O() {
        this.L.clear();
        this.M.clear();
    }

    private void P() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    private void Q() {
        int h;
        int p;
        if (H() == 1) {
            h = q() - o();
            p = n();
        } else {
            h = h() - m();
            p = p();
        }
        k(h - p);
    }

    private void k(int i) {
        this.J = a(this.J, this.I, i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public boolean C() {
        return this.D == null && !this.H;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 1) {
            return this.I;
        }
        if (sVar.a() < 1) {
            return 0;
        }
        return a(oVar, sVar, sVar.a() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void b(boolean z) {
        if (!z) {
            super.b(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.LayoutParams c() {
        if (this.s == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void d(RecyclerView recyclerView) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void e(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (sVar.d()) {
            N();
        }
        super.e(oVar, sVar);
        O();
    }

    int f(int i, int i2) {
        if (this.s == 1 && I()) {
            int[] iArr = this.J;
            int i3 = this.I;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.J;
        return iArr2[i2 + i] - iArr2[i];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void g(RecyclerView.s sVar) {
        super.g(sVar);
        this.H = false;
    }

    public void j(int i) {
        if (i == this.I) {
            return;
        }
        this.H = true;
        if (i >= 1) {
            this.I = i;
            this.N.a();
            y();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        int e;
        int f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
            this.f = 0;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.e = -1;
            this.f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = -1;
            this.f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = -1;
            this.f = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 0) {
            return this.I;
        }
        if (sVar.a() < 1) {
            return 0;
        }
        return a(oVar, sVar, sVar.a() - 1) + 1;
    }

    private int c(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.d()) {
            return this.N.a(i);
        }
        int i2 = this.L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = oVar.a(i);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.N.a(a2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, View view, androidx.core.h.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a2 = a(oVar, sVar, layoutParams2.a());
        if (this.s == 0) {
            cVar.b(c.C0014c.a(layoutParams2.e(), layoutParams2.f(), a2, 1, this.I > 1 && layoutParams2.f() == this.I, false));
        } else {
            cVar.b(c.C0014c.a(a2, 1, layoutParams2.e(), layoutParams2.f(), this.I > 1 && layoutParams2.f() == this.I, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        Q();
        P();
        return super.b(i, oVar, sVar);
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(oVar, sVar, aVar.f767b);
        if (z) {
            while (b2 > 0) {
                int i2 = aVar.f767b;
                if (i2 <= 0) {
                    return;
                }
                aVar.f767b = i2 - 1;
                b2 = b(oVar, sVar, aVar.f767b);
            }
            return;
        }
        int a2 = sVar.a() - 1;
        int i3 = aVar.f767b;
        while (i3 < a2) {
            int i4 = i3 + 1;
            int b3 = b(oVar, sVar, i4);
            if (b3 <= b2) {
                break;
            }
            i3 = i4;
            b2 = b3;
        }
        aVar.f767b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.N.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.N.a();
    }

    private int b(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.d()) {
            return this.N.a(i, this.I);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = oVar.a(i);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.N.a(a2, this.I);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.N.a();
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

    private void b(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f783b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int f = f(layoutParams.e, layoutParams.f);
        if (this.s == 1) {
            i3 = RecyclerView.i.a(f, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i2 = RecyclerView.i.a(this.u.g(), i(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int a2 = RecyclerView.i.a(f, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int a3 = RecyclerView.i.a(this.u.g(), r(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i2 = a2;
            i3 = a3;
        }
        a(view, i3, i2, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int a2;
        int a3;
        if (this.J == null) {
            super.a(rect, i, i2);
        }
        int n = n() + o();
        int p = p() + m();
        if (this.s == 1) {
            a3 = RecyclerView.i.a(i2, rect.height() + p, k());
            int[] iArr = this.J;
            a2 = RecyclerView.i.a(i, iArr[iArr.length - 1] + n, l());
        } else {
            a2 = RecyclerView.i.a(i, rect.width() + n, l());
            int[] iArr2 = this.J;
            a3 = RecyclerView.i.a(i2, iArr2[iArr2.length - 1] + p, k());
        }
        c(a2, a3);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i) {
        super.a(oVar, sVar, aVar, i);
        Q();
        if (sVar.a() > 0 && !sVar.d()) {
            b(oVar, sVar, aVar, i);
        }
        P();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        Q();
        P();
        return super.a(i, oVar, sVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, int i3) {
        E();
        int f = this.u.f();
        int b2 = this.u.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View c = c(i);
            int l = l(c);
            if (l >= 0 && l < i3 && b(oVar, sVar, l) == 0) {
                if (((RecyclerView.LayoutParams) c.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = c;
                    }
                } else if (this.u.d(c) < b2 && this.u.a(c) >= f) {
                    return c;
                } else {
                    if (view == null) {
                        view = c;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int a(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.d()) {
            return this.N.b(i, this.I);
        }
        int a2 = oVar.a(i);
        if (a2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.N.b(a2, this.I);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.s sVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i = this.I;
        for (int i2 = 0; i2 < this.I && cVar.a(sVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.a(i3, Math.max(0, cVar.g));
            i -= this.N.a(i3);
            cVar.d += cVar.e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
        r22.f769b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a3, code lost:
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(androidx.recyclerview.widget.RecyclerView.o r19, androidx.recyclerview.widget.RecyclerView.s r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    private void a(float f, int i) {
        k(Math.max(Math.round(f * this.I), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean a2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            a2 = b(view, i, i2, layoutParams);
        } else {
            a2 = a(view, i, i2, layoutParams);
        }
        if (a2) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = i - 1;
            i4 = -1;
        }
        while (i3 != i6) {
            View view = this.K[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f = c(oVar, sVar, l(view));
            layoutParams.e = i5;
            i5 += layoutParams.f;
            i3 += i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f7, code lost:
        if (r13 == (r2 > r10)) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View a(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.o r26, androidx.recyclerview.widget.RecyclerView.s r27) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s):android.view.View");
    }
}
