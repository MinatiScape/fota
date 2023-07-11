package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.h.C0067a;
import androidx.core.h.a.c;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.M;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.h.q, androidx.core.h.i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f780a = {16843830};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f781b = {16842987};
    static final boolean c;
    static final boolean d;
    static final boolean e;
    static final boolean f;
    private static final boolean g;
    private static final boolean h;
    private static final Class<?>[] i;
    static final Interpolator j;
    private l A;
    private final int[] Aa;
    boolean B;
    final int[] Ba;
    boolean C;
    private final int[] Ca;
    boolean D;
    final int[] Da;
    boolean E;
    final List<v> Ea;
    private int F;
    private Runnable Fa;
    boolean G;
    private final N.b Ga;
    boolean H;
    private boolean I;
    private int J;
    boolean K;
    private final AccessibilityManager L;
    private List<j> M;
    boolean N;
    boolean O;
    private int P;
    private int Q;
    private e R;
    private EdgeEffect S;
    private EdgeEffect T;
    private EdgeEffect U;
    private EdgeEffect V;
    f W;
    private int aa;
    private int ba;
    private VelocityTracker ca;
    private int da;
    private int ea;
    private int fa;
    private int ga;
    private k ha;
    private final int ia;
    private final int ja;
    private final q k;
    private float ka;
    final o l;
    private float la;
    private SavedState m;
    G mAccessibilityDelegate;
    private int mTouchSlop;
    private boolean ma;
    C0087a n;
    final u na;
    C0088b o;
    androidx.recyclerview.widget.p oa;
    final N p;
    p.a pa;
    boolean q;
    final s qa;
    final Runnable r;
    private m ra;
    final Rect s;
    private List<m> sa;
    private final Rect t;
    boolean ta;
    final RectF u;
    boolean ua;
    a v;
    private f.b va;
    i w;
    boolean wa;
    p x;
    private d xa;
    final ArrayList<h> y;
    private final int[] ya;
    private final ArrayList<l> z;
    private androidx.core.h.k za;

    /* loaded from: classes.dex */
    public static abstract class a<VH extends v> {

        /* renamed from: a  reason: collision with root package name */
        private final b f784a = new b();

        /* renamed from: b  reason: collision with root package name */
        private boolean f785b = false;

        public abstract int a();

        public abstract long a(int i);

        public void a(VH vh, int i, List<Object> list) {
            b((a<VH>) vh, i);
        }

        public void a(RecyclerView recyclerView) {
        }

        public boolean a(VH vh) {
            return false;
        }

        public abstract int b(int i);

        public abstract VH b(ViewGroup viewGroup, int i);

        public void b(VH vh) {
        }

        public abstract void b(VH vh, int i);

        public void b(RecyclerView recyclerView) {
        }

        public final boolean b() {
            return this.f785b;
        }

        public final void c() {
            this.f784a.a();
        }

        public void c(VH vh) {
        }

        public abstract void d(VH vh);

        public final VH a(ViewGroup viewGroup, int i) {
            try {
                androidx.core.d.a.a("RV CreateView");
                VH b2 = b(viewGroup, i);
                if (b2.f807b.getParent() == null) {
                    b2.g = i;
                    return b2;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.d.a.a();
            }
        }

        public void b(c cVar) {
            this.f784a.unregisterObserver(cVar);
        }

        public final void a(VH vh, int i) {
            vh.d = i;
            if (b()) {
                vh.f = a(i);
            }
            vh.a(1, 519);
            androidx.core.d.a.a("RV OnBindView");
            a(vh, i, vh.k());
            vh.b();
            ViewGroup.LayoutParams layoutParams = vh.f807b.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).c = true;
            }
            androidx.core.d.a.a();
        }

        public void a(c cVar) {
            this.f784a.registerObserver(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends Observable<c> {
        b() {
        }

        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((c) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class e {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private b f786a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f787b = new ArrayList<>();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(v vVar);
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f788a;

            /* renamed from: b  reason: collision with root package name */
            public int f789b;
            public int c;
            public int d;

            public c a(v vVar) {
                a(vVar, 0);
                return this;
            }

            public c a(v vVar, int i) {
                View view = vVar.f807b;
                this.f788a = view.getLeft();
                this.f789b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        void a(b bVar) {
            this.f786a = bVar;
        }

        public abstract boolean a(v vVar, c cVar, c cVar2);

        public abstract boolean a(v vVar, v vVar2, c cVar, c cVar2);

        public abstract void b();

        public abstract boolean b(v vVar);

        public abstract boolean b(v vVar, c cVar, c cVar2);

        public long c() {
            return this.c;
        }

        public abstract boolean c(v vVar, c cVar, c cVar2);

        public long d() {
            return this.f;
        }

        public abstract void d(v vVar);

        public long e() {
            return this.e;
        }

        public void e(v vVar) {
        }

        public long f() {
            return this.d;
        }

        public abstract boolean g();

        public c h() {
            return new c();
        }

        public abstract void i();

        public c a(s sVar, v vVar, int i, List<Object> list) {
            c h = h();
            h.a(vVar);
            return h;
        }

        public final void c(v vVar) {
            e(vVar);
            b bVar = this.f786a;
            if (bVar != null) {
                bVar.a(vVar);
            }
        }

        public c a(s sVar, v vVar) {
            c h = h();
            h.a(vVar);
            return h;
        }

        static int a(v vVar) {
            int i = vVar.k & 14;
            if (vVar.n()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int j = vVar.j();
                int f = vVar.f();
                return (j == -1 || f == -1 || j == f) ? i : i | 2048;
            }
            return i;
        }

        public boolean a(v vVar, List<Object> list) {
            return b(vVar);
        }

        public final void a() {
            int size = this.f787b.size();
            for (int i = 0; i < size; i++) {
                this.f787b.get(i).a();
            }
            this.f787b.clear();
        }
    }

    /* loaded from: classes.dex */
    private class g implements f.b {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f.b
        public void a(v vVar) {
            vVar.a(true);
            if (vVar.i != null && vVar.j == null) {
                vVar.i = null;
            }
            vVar.j = null;
            if (vVar.w() || RecyclerView.this.k(vVar.f807b) || !vVar.r()) {
                return;
            }
            RecyclerView.this.removeDetachedView(vVar.f807b, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
            a(canvas, recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, s sVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            a(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        C0088b f791a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f792b;
        r g;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;
        private final M.b c = new D(this);
        private final M.b d = new E(this);
        M e = new M(this.c);
        M f = new M(this.d);
        boolean h = false;
        boolean i = false;
        boolean j = false;
        private boolean k = true;
        private boolean l = true;

        /* loaded from: classes.dex */
        public interface a {
            void a(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f793a;

            /* renamed from: b  reason: collision with root package name */
            public int f794b;
            public boolean c;
            public boolean d;
        }

        boolean A() {
            return false;
        }

        void B() {
            r rVar = this.g;
            if (rVar != null) {
                rVar.d();
            }
        }

        public boolean C() {
            return false;
        }

        public int a(int i, o oVar, s sVar) {
            return 0;
        }

        public int a(s sVar) {
            return 0;
        }

        public View a(View view, int i, o oVar, s sVar) {
            return null;
        }

        public void a(int i, int i2, s sVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(Rect rect, int i, int i2) {
            c(a(i, rect.width() + n() + o(), l()), a(i2, rect.height() + p() + m(), k()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public boolean a(o oVar, s sVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int b(int i, o oVar, s sVar) {
            return 0;
        }

        public int b(s sVar) {
            return 0;
        }

        void b(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            this.o = View.MeasureSpec.getMode(i);
            if (this.o == 0 && !RecyclerView.d) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            this.p = View.MeasureSpec.getMode(i2);
            if (this.p != 0 || RecyclerView.d) {
                return;
            }
            this.r = 0;
        }

        public void b(RecyclerView recyclerView) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public boolean b() {
            return false;
        }

        public int c(o oVar, s sVar) {
            return 0;
        }

        public int c(s sVar) {
            return 0;
        }

        public View c(View view) {
            View c;
            RecyclerView recyclerView = this.f792b;
            if (recyclerView == null || (c = recyclerView.c(view)) == null || this.f791a.c(c)) {
                return null;
            }
            return c;
        }

        public abstract LayoutParams c();

        @Deprecated
        public void c(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public int d() {
            return -1;
        }

        public int d(s sVar) {
            return 0;
        }

        public View d(View view, int i) {
            return null;
        }

        void d(int i, int i2) {
            int e = e();
            if (e == 0) {
                this.f792b.c(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < e; i7++) {
                View c = c(i7);
                Rect rect = this.f792b.s;
                b(c, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i5) {
                    i5 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.f792b.s.set(i3, i4, i5, i6);
            a(this.f792b.s, i, i2);
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d(o oVar, s sVar) {
            return false;
        }

        public int e(s sVar) {
            return 0;
        }

        public void e(o oVar, s sVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int f(s sVar) {
            return 0;
        }

        public void f(int i) {
        }

        void f(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f792b = null;
                this.f791a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f792b = recyclerView;
                this.f791a = recyclerView.o;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public void g(int i) {
            if (c(i) != null) {
                this.f791a.e(i);
            }
        }

        public void g(s sVar) {
        }

        public int h() {
            return this.r;
        }

        public int i() {
            return this.p;
        }

        public int j() {
            return androidx.core.h.t.k(this.f792b);
        }

        public int k(View view) {
            return ((LayoutParams) view.getLayoutParams()).f783b.left;
        }

        public int l(View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        public int m() {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int n() {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void o(View view) {
            this.f791a.d(view);
        }

        public int p() {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int q() {
            return this.q;
        }

        public int r() {
            return this.o;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            int e = e();
            for (int i = 0; i < e; i++) {
                ViewGroup.LayoutParams layoutParams = c(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean t() {
            return this.i;
        }

        public boolean u() {
            return this.j;
        }

        public final boolean v() {
            return this.l;
        }

        public boolean w() {
            r rVar = this.g;
            return rVar != null && rVar.c();
        }

        public Parcelable x() {
            return null;
        }

        public void y() {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void z() {
            this.h = true;
        }

        public int e() {
            C0088b c0088b = this.f791a;
            if (c0088b != null) {
                return c0088b.a();
            }
            return 0;
        }

        public int h(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f783b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int i(View view) {
            return view.getRight() + m(view);
        }

        public int j(View view) {
            return view.getTop() - n(view);
        }

        public int k() {
            return androidx.core.h.t.l(this.f792b);
        }

        public int l() {
            return androidx.core.h.t.m(this.f792b);
        }

        public int m(View view) {
            return ((LayoutParams) view.getLayoutParams()).f783b.right;
        }

        public int n(View view) {
            return ((LayoutParams) view.getLayoutParams()).f783b.top;
        }

        public int o() {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void e(int i) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                recyclerView.f(i);
            }
        }

        public View g() {
            View focusedChild;
            RecyclerView recyclerView = this.f792b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f791a.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void c(View view, int i) {
            a(view, i, (LayoutParams) view.getLayoutParams());
        }

        public View c(int i) {
            C0088b c0088b = this.f791a;
            if (c0088b != null) {
                return c0088b.c(i);
            }
            return null;
        }

        public int e(View view) {
            return view.getBottom() + d(view);
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        void c(o oVar) {
            int e = oVar.e();
            for (int i = e - 1; i >= 0; i--) {
                View c = oVar.c(i);
                v g = RecyclerView.g(c);
                if (!g.x()) {
                    g.a(false);
                    if (g.r()) {
                        this.f792b.removeDetachedView(c, false);
                    }
                    f fVar = this.f792b.W;
                    if (fVar != null) {
                        fVar.d(g);
                    }
                    g.a(true);
                    oVar.a(c);
                }
            }
            oVar.c();
            if (e > 0) {
                this.f792b.invalidate();
            }
        }

        void e(RecyclerView recyclerView) {
            b(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f783b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void b(RecyclerView recyclerView, o oVar) {
            c(recyclerView);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        public boolean f() {
            RecyclerView recyclerView = this.f792b;
            return recyclerView != null && recyclerView.q;
        }

        void a(RecyclerView recyclerView) {
            this.i = true;
            b(recyclerView);
        }

        public View b(int i) {
            int e = e();
            for (int i2 = 0; i2 < e; i2++) {
                View c = c(i2);
                v g = RecyclerView.g(c);
                if (g != null && g.i() == i && !g.x() && (this.f792b.qa.d() || !g.p())) {
                    return c;
                }
            }
            return null;
        }

        public void d(int i) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                recyclerView.e(i);
            }
        }

        public int f(View view) {
            return view.getLeft() - k(view);
        }

        void a(RecyclerView recyclerView, o oVar) {
            this.i = false;
            b(recyclerView, oVar);
        }

        public int d(View view) {
            return ((LayoutParams) view.getLayoutParams()).f783b.bottom;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int n = n();
            int p = p();
            int q = q() - o();
            int h = h() - m();
            Rect rect = this.f792b.s;
            b(focusedChild, rect);
            return rect.left - i < q && rect.right - i > n && rect.top - i2 < h && rect.bottom - i2 > p;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.k && b(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && b(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public LayoutParams a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public void c(int i, int i2) {
            this.f792b.setMeasuredDimension(i, i2);
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i;
                } else {
                    return true;
                }
            }
            return false;
        }

        public void b(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int n = n();
            int p = p();
            int q = q() - o();
            int h = h() - m();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - n;
            int min = Math.min(0, i);
            int i2 = top - p;
            int min2 = Math.min(0, i2);
            int i3 = width - q;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - h);
            if (j() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        private void a(View view, int i, boolean z) {
            v g = RecyclerView.g(view);
            if (!z && !g.p()) {
                this.f792b.p.g(g);
            } else {
                this.f792b.p.a(g);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!g.z() && !g.q()) {
                if (view.getParent() == this.f792b) {
                    int b2 = this.f791a.b(view);
                    if (i == -1) {
                        i = this.f791a.a();
                    }
                    if (b2 == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f792b.indexOfChild(view) + this.f792b.i());
                    } else if (b2 != i) {
                        this.f792b.w.a(b2, i);
                    }
                } else {
                    this.f791a.a(view, i, false);
                    layoutParams.c = true;
                    r rVar = this.g;
                    if (rVar != null && rVar.c()) {
                        this.g.a(view);
                    }
                }
            } else {
                if (g.q()) {
                    g.y();
                } else {
                    g.c();
                }
                this.f791a.a(view, i, view.getLayoutParams(), false);
            }
            if (layoutParams.d) {
                g.f807b.invalidate();
                layoutParams.d = false;
            }
        }

        public void b(o oVar) {
            for (int e = e() - 1; e >= 0; e--) {
                if (!RecyclerView.g(c(e)).x()) {
                    a(e, oVar);
                }
            }
        }

        public int b(o oVar, s sVar) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView == null || recyclerView.v == null || !b()) {
                return 1;
            }
            return this.f792b.v.a();
        }

        public void a(int i) {
            a(i, c(i));
        }

        private void a(int i, View view) {
            this.f791a.a(i);
        }

        public void a(View view, int i, LayoutParams layoutParams) {
            v g = RecyclerView.g(view);
            if (g.p()) {
                this.f792b.p.a(g);
            } else {
                this.f792b.p.g(g);
            }
            this.f791a.a(view, i, layoutParams, g.p());
        }

        public void a(int i, int i2) {
            View c = c(i);
            if (c != null) {
                a(i);
                c(c, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f792b.toString());
        }

        public void a(View view, o oVar) {
            o(view);
            oVar.b(view);
        }

        public void a(int i, o oVar) {
            View c = c(i);
            g(i);
            oVar.b(c);
        }

        public void a(o oVar) {
            for (int e = e() - 1; e >= 0; e--) {
                a(oVar, e, c(e));
            }
        }

        private void a(o oVar, int i, View view) {
            v g = RecyclerView.g(view);
            if (g.x()) {
                return;
            }
            if (g.n() && !g.p() && !this.f792b.v.b()) {
                g(i);
                oVar.b(g);
                return;
            }
            a(i);
            oVar.c(view);
            this.f792b.p.d(g);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.k && b(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && b(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect h = this.f792b.h(view);
            int i3 = i + h.left + h.right;
            int i4 = i2 + h.top + h.bottom;
            int a2 = a(q(), r(), n() + o() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, a());
            int a3 = a(h(), i(), p() + m() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, b());
            if (a(view, a2, a3, layoutParams)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                    }
                    max = 0;
                }
                max = i4;
                i7 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 == -1) {
                        i7 = i2;
                    } else {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i7 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i4;
                i7 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f783b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f783b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f792b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f792b.u;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.h(view));
            }
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i = b2[0];
            int i2 = b2[1];
            if ((!z2 || d(recyclerView, i, i2)) && !(i == 0 && i2 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i, i2);
                } else {
                    recyclerView.i(i, i2);
                }
                return true;
            }
            return false;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.e.a(view, 24579) && this.f.a(view, 24579);
            return z ? z3 : !z3;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return w() || recyclerView.n();
        }

        public boolean a(RecyclerView recyclerView, s sVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(o oVar, s sVar, int i, int i2) {
            this.f792b.c(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(androidx.core.h.a.c cVar) {
            RecyclerView recyclerView = this.f792b;
            a(recyclerView.l, recyclerView.qa, cVar);
        }

        public void a(o oVar, s sVar, androidx.core.h.a.c cVar) {
            if (this.f792b.canScrollVertically(-1) || this.f792b.canScrollHorizontally(-1)) {
                cVar.a(CpioConstants.C_ISCHR);
                cVar.k(true);
            }
            if (this.f792b.canScrollVertically(1) || this.f792b.canScrollHorizontally(1)) {
                cVar.a(CpioConstants.C_ISFIFO);
                cVar.k(true);
            }
            cVar.a(c.b.a(b(oVar, sVar), a(oVar, sVar), d(oVar, sVar), c(oVar, sVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f792b;
            a(recyclerView.l, recyclerView.qa, accessibilityEvent);
        }

        public void a(o oVar, s sVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f792b.canScrollVertically(-1) && !this.f792b.canScrollHorizontally(-1) && !this.f792b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            a aVar = this.f792b.v;
            if (aVar != null) {
                accessibilityEvent.setItemCount(aVar.a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view, androidx.core.h.a.c cVar) {
            v g = RecyclerView.g(view);
            if (g == null || g.p() || this.f791a.c(g.f807b)) {
                return;
            }
            RecyclerView recyclerView = this.f792b;
            a(recyclerView.l, recyclerView.qa, view, cVar);
        }

        public void a(o oVar, s sVar, View view, androidx.core.h.a.c cVar) {
            cVar.b(c.C0014c.a(b() ? l(view) : 0, 1, a() ? l(view) : 0, 1, false, false));
        }

        public int a(o oVar, s sVar) {
            RecyclerView recyclerView = this.f792b;
            if (recyclerView == null || recyclerView.v == null || !a()) {
                return 1;
            }
            return this.f792b.v.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f792b;
            return a(recyclerView.l, recyclerView.qa, i, bundle);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0070 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(androidx.recyclerview.widget.RecyclerView.o r2, androidx.recyclerview.widget.RecyclerView.s r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f792b
                r3 = 0
                if (r2 != 0) goto L6
                return r3
            L6:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L42
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L12
                r2 = 0
            L10:
                r4 = 0
                goto L6e
            L12:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L29
                int r2 = r1.h()
                int r5 = r1.p()
                int r2 = r2 - r5
                int r5 = r1.m()
                int r2 = r2 - r5
                int r2 = -r2
                goto L2a
            L29:
                r2 = 0
            L2a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.f792b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L10
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
                int r4 = -r4
                goto L6e
            L42:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L57
                int r2 = r1.h()
                int r4 = r1.p()
                int r2 = r2 - r4
                int r4 = r1.m()
                int r2 = r2 - r4
                goto L58
            L57:
                r2 = 0
            L58:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f792b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L10
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
            L6e:
                if (r2 != 0) goto L73
                if (r4 != 0) goto L73
                return r3
            L73:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f792b
                r3.i(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.a(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, int, android.os.Bundle):boolean");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f792b;
            return a(recyclerView.l, recyclerView.qa, view, i, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, i2);
            bVar.f793a = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
            bVar.f794b = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
            bVar.c = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        public abstract boolean a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface l {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class m {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public final class o {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<v> f799a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<v> f800b = null;
        final ArrayList<v> c = new ArrayList<>();
        private final List<v> d = Collections.unmodifiableList(this.f799a);
        private int e = 2;
        int f = 2;
        n g;
        private t h;

        public o() {
        }

        private void e(v vVar) {
            if (RecyclerView.this.m()) {
                View view = vVar.f807b;
                if (androidx.core.h.t.i(view) == 0) {
                    androidx.core.h.t.d(view, 1);
                }
                if (androidx.core.h.t.u(view)) {
                    return;
                }
                vVar.a(16384);
                androidx.core.h.t.a(view, RecyclerView.this.mAccessibilityDelegate.b());
            }
        }

        public void a() {
            this.f799a.clear();
            i();
        }

        View b(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).f807b;
        }

        void c(View view) {
            v g = RecyclerView.g(view);
            if (!g.b(12) && g.s() && !RecyclerView.this.a(g)) {
                if (this.f800b == null) {
                    this.f800b = new ArrayList<>();
                }
                g.a(this, true);
                this.f800b.add(g);
            } else if (g.n() && !g.p() && !RecyclerView.this.v.b()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.i());
            } else {
                g.a(this, false);
                this.f799a.add(g);
            }
        }

        boolean d(v vVar) {
            if (vVar.p()) {
                return RecyclerView.this.qa.d();
            }
            int i = vVar.d;
            if (i >= 0 && i < RecyclerView.this.v.a()) {
                if (RecyclerView.this.qa.d() || RecyclerView.this.v.b(vVar.d) == vVar.h()) {
                    return !RecyclerView.this.v.b() || vVar.g() == RecyclerView.this.v.a(vVar.d);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.i());
        }

        public void f(int i) {
            this.e = i;
            j();
        }

        void g() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.c.get(i).f807b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.c = true;
                }
            }
        }

        void h() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                v vVar = this.c.get(i);
                if (vVar != null) {
                    vVar.a(6);
                    vVar.a((Object) null);
                }
            }
            a aVar = RecyclerView.this.v;
            if (aVar == null || !aVar.b()) {
                i();
            }
        }

        void i() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                e(size);
            }
            this.c.clear();
            if (RecyclerView.f) {
                RecyclerView.this.pa.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void j() {
            i iVar = RecyclerView.this.w;
            this.f = this.e + (iVar != null ? iVar.m : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                e(size);
            }
        }

        public void b(View view) {
            v g = RecyclerView.g(view);
            if (g.r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (g.q()) {
                g.y();
            } else if (g.z()) {
                g.c();
            }
            b(g);
        }

        private boolean a(v vVar, int i, int i2, long j) {
            vVar.s = RecyclerView.this;
            int h = vVar.h();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j == Long.MAX_VALUE || this.g.a(h, nanoTime, j)) {
                RecyclerView.this.v.a((a) vVar, i);
                this.g.a(vVar.h(), RecyclerView.this.getNanoTime() - nanoTime);
                e(vVar);
                if (RecyclerView.this.qa.d()) {
                    vVar.h = i2;
                    return true;
                }
                return true;
            }
            return false;
        }

        public List<v> f() {
            return this.d;
        }

        private void f(v vVar) {
            View view = vVar.f807b;
            if (view instanceof ViewGroup) {
                a((ViewGroup) view, false);
            }
        }

        void b(v vVar) {
            boolean z;
            if (!vVar.q() && vVar.f807b.getParent() == null) {
                if (!vVar.r()) {
                    if (!vVar.x()) {
                        boolean e = vVar.e();
                        a aVar = RecyclerView.this.v;
                        if ((aVar != null && e && aVar.a((a) vVar)) || vVar.o()) {
                            if (this.f <= 0 || vVar.b(526)) {
                                z = false;
                            } else {
                                int size = this.c.size();
                                if (size >= this.f && size > 0) {
                                    e(0);
                                    size--;
                                }
                                if (RecyclerView.f && size > 0 && !RecyclerView.this.pa.a(vVar.d)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.pa.a(this.c.get(i).d)) {
                                            break;
                                        }
                                        i--;
                                    }
                                    size = i + 1;
                                }
                                this.c.add(size, vVar);
                                z = true;
                            }
                            if (!z) {
                                a(vVar, true);
                                r1 = true;
                            }
                        } else {
                            z = false;
                        }
                        RecyclerView.this.p.h(vVar);
                        if (z || r1 || !e) {
                            return;
                        }
                        vVar.s = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.i());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.i());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(vVar.q());
            sb.append(" isAttached:");
            sb.append(vVar.f807b.getParent() != null);
            sb.append(RecyclerView.this.i());
            throw new IllegalArgumentException(sb.toString());
        }

        void e(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        public View d(int i) {
            return b(i, false);
        }

        n d() {
            if (this.g == null) {
                this.g = new n();
            }
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(v vVar) {
            if (vVar.p) {
                this.f800b.remove(vVar);
            } else {
                this.f799a.remove(vVar);
            }
            vVar.o = null;
            vVar.p = false;
            vVar.c();
        }

        int e() {
            return this.f799a.size();
        }

        public int a(int i) {
            if (i >= 0 && i < RecyclerView.this.qa.a()) {
                return !RecyclerView.this.qa.d() ? i : RecyclerView.this.n.b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.qa.a() + RecyclerView.this.i());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:105:0x022c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0210  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.v a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 619
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$v");
        }

        View c(int i) {
            return this.f799a.get(i).f807b;
        }

        void c() {
            this.f799a.clear();
            ArrayList<v> arrayList = this.f800b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                v vVar = this.c.get(size);
                if (vVar != null && (i3 = vVar.d) >= i && i3 < i4) {
                    vVar.a(2);
                    e(size);
                }
            }
        }

        v b(int i) {
            int size;
            int b2;
            ArrayList<v> arrayList = this.f800b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    v vVar = this.f800b.get(i2);
                    if (!vVar.z() && vVar.i() == i) {
                        vVar.a(32);
                        return vVar;
                    }
                }
                if (RecyclerView.this.v.b() && (b2 = RecyclerView.this.n.b(i)) > 0 && b2 < RecyclerView.this.v.a()) {
                    long a2 = RecyclerView.this.v.a(b2);
                    for (int i3 = 0; i3 < size; i3++) {
                        v vVar2 = this.f800b.get(i3);
                        if (!vVar2.z() && vVar2.g() == a2) {
                            vVar2.a(32);
                            return vVar2;
                        }
                    }
                }
            }
            return null;
        }

        void b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.c.size();
            for (int i7 = 0; i7 < size; i7++) {
                v vVar = this.c.get(i7);
                if (vVar != null && (i6 = vVar.d) >= i4 && i6 <= i3) {
                    if (i6 == i) {
                        vVar.a(i2 - i, false);
                    } else {
                        vVar.a(i5, false);
                    }
                }
            }
        }

        void b() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).a();
            }
            int size2 = this.f799a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f799a.get(i2).a();
            }
            ArrayList<v> arrayList = this.f800b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f800b.get(i3).a();
                }
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(v vVar, boolean z) {
            RecyclerView.b(vVar);
            if (vVar.b(16384)) {
                vVar.a(0, 16384);
                androidx.core.h.t.a(vVar.f807b, (C0067a) null);
            }
            if (z) {
                a(vVar);
            }
            vVar.s = null;
            d().a(vVar);
        }

        void a(View view) {
            v g = RecyclerView.g(view);
            g.o = null;
            g.p = false;
            g.c();
            b(g);
        }

        v a(int i, boolean z) {
            View b2;
            int size = this.f799a.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.f799a.get(i2);
                if (!vVar.z() && vVar.i() == i && !vVar.n() && (RecyclerView.this.qa.h || !vVar.p())) {
                    vVar.a(32);
                    return vVar;
                }
            }
            if (!z && (b2 = RecyclerView.this.o.b(i)) != null) {
                v g = RecyclerView.g(b2);
                RecyclerView.this.o.f(b2);
                int b3 = RecyclerView.this.o.b(b2);
                if (b3 != -1) {
                    RecyclerView.this.o.a(b3);
                    c(b2);
                    g.a(8224);
                    return g;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + g + RecyclerView.this.i());
            }
            int size2 = this.c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                v vVar2 = this.c.get(i3);
                if (!vVar2.n() && vVar2.i() == i) {
                    if (!z) {
                        this.c.remove(i3);
                    }
                    return vVar2;
                }
            }
            return null;
        }

        v a(long j, int i, boolean z) {
            for (int size = this.f799a.size() - 1; size >= 0; size--) {
                v vVar = this.f799a.get(size);
                if (vVar.g() == j && !vVar.z()) {
                    if (i == vVar.h()) {
                        vVar.a(32);
                        if (vVar.p() && !RecyclerView.this.qa.d()) {
                            vVar.a(2, 14);
                        }
                        return vVar;
                    } else if (!z) {
                        this.f799a.remove(size);
                        RecyclerView.this.removeDetachedView(vVar.f807b, false);
                        a(vVar.f807b);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                v vVar2 = this.c.get(size2);
                if (vVar2.g() == j) {
                    if (i == vVar2.h()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return vVar2;
                    } else if (!z) {
                        e(size2);
                        return null;
                    }
                }
            }
        }

        void a(v vVar) {
            p pVar = RecyclerView.this.x;
            if (pVar != null) {
                pVar.a(vVar);
            }
            a aVar = RecyclerView.this.v;
            if (aVar != null) {
                aVar.d(vVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.qa != null) {
                recyclerView.p.h(vVar);
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            d().a(aVar, aVar2, z);
        }

        void a(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                v vVar = this.c.get(i3);
                if (vVar != null && vVar.d >= i) {
                    vVar.a(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                v vVar = this.c.get(size);
                if (vVar != null) {
                    int i4 = vVar.d;
                    if (i4 >= i3) {
                        vVar.a(-i2, z);
                    } else if (i4 >= i) {
                        vVar.a(8);
                        e(size);
                    }
                }
            }
        }

        void a(t tVar) {
            this.h = tVar;
        }

        void a(n nVar) {
            n nVar2 = this.g;
            if (nVar2 != null) {
                nVar2.c();
            }
            this.g = nVar;
            if (this.g == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.g.a();
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void a(v vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class q extends c {
        q() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.qa.g = true;
            recyclerView.b(true);
            if (RecyclerView.this.n.c()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class r {

        /* loaded from: classes.dex */
        public interface a {
        }

        public abstract int a();

        public abstract void a(int i);

        abstract void a(int i, int i2);

        protected abstract void a(View view);

        public abstract boolean b();

        public abstract boolean c();

        protected final void d() {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class t {
        public abstract View a(o oVar, int i, int i2);
    }

    /* loaded from: classes.dex */
    public static abstract class v {

        /* renamed from: a  reason: collision with root package name */
        private static final List<Object> f806a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public final View f807b;
        WeakReference<RecyclerView> c;
        int k;
        RecyclerView s;
        int d = -1;
        int e = -1;
        long f = -1;
        int g = -1;
        int h = -1;
        v i = null;
        v j = null;
        List<Object> l = null;
        List<Object> m = null;
        private int n = 0;
        o o = null;
        boolean p = false;
        private int q = 0;
        int r = -1;

        public v(View view) {
            if (view != null) {
                this.f807b = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void A() {
            if (this.l == null) {
                this.l = new ArrayList();
                this.m = Collections.unmodifiableList(this.l);
            }
        }

        void a(int i, int i2, boolean z) {
            a(8);
            a(i2, z);
            this.d = i;
        }

        boolean b(int i) {
            return (i & this.k) != 0;
        }

        void c() {
            this.k &= -33;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            this.k &= -257;
        }

        boolean e() {
            return (this.k & 16) == 0 && androidx.core.h.t.x(this.f807b);
        }

        public final int f() {
            RecyclerView recyclerView = this.s;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c(this);
        }

        public final long g() {
            return this.f;
        }

        public final int h() {
            return this.g;
        }

        public final int i() {
            int i = this.h;
            return i == -1 ? this.d : i;
        }

        public final int j() {
            return this.e;
        }

        List<Object> k() {
            if ((this.k & 1024) == 0) {
                List<Object> list = this.l;
                if (list != null && list.size() != 0) {
                    return this.m;
                }
                return f806a;
            }
            return f806a;
        }

        boolean l() {
            return (this.k & 512) != 0 || n();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean m() {
            return (this.k & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean n() {
            return (this.k & 4) != 0;
        }

        public final boolean o() {
            return (this.k & 16) == 0 && !androidx.core.h.t.x(this.f807b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean p() {
            return (this.k & 8) != 0;
        }

        boolean q() {
            return this.o != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean r() {
            return (this.k & CpioConstants.C_IRUSR) != 0;
        }

        boolean s() {
            return (this.k & 2) != 0;
        }

        boolean t() {
            return (this.k & 2) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.d + " id=" + this.f + ", oldPos=" + this.e + ", pLpos:" + this.h);
            if (q()) {
                sb.append(" scrap ");
                sb.append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                sb.append(" invalid");
            }
            if (!m()) {
                sb.append(" unbound");
            }
            if (t()) {
                sb.append(" update");
            }
            if (p()) {
                sb.append(" removed");
            }
            if (x()) {
                sb.append(" ignored");
            }
            if (r()) {
                sb.append(" tmpDetached");
            }
            if (!o()) {
                sb.append(" not recyclable(" + this.n + ")");
            }
            if (l()) {
                sb.append(" undefined adapter position");
            }
            if (this.f807b.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void u() {
            this.k = 0;
            this.d = -1;
            this.e = -1;
            this.f = -1L;
            this.h = -1;
            this.n = 0;
            this.i = null;
            this.j = null;
            b();
            this.q = 0;
            this.r = -1;
            RecyclerView.b(this);
        }

        void v() {
            if (this.e == -1) {
                this.e = this.d;
            }
        }

        boolean w() {
            return (this.k & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean x() {
            return (this.k & CpioConstants.C_IWUSR) != 0;
        }

        void y() {
            this.o.c(this);
        }

        boolean z() {
            return (this.k & 32) != 0;
        }

        void b() {
            List<Object> list = this.l;
            if (list != null) {
                list.clear();
            }
            this.k &= -1025;
        }

        void a(int i, boolean z) {
            if (this.e == -1) {
                this.e = this.d;
            }
            if (this.h == -1) {
                this.h = this.d;
            }
            if (z) {
                this.h += i;
            }
            this.d += i;
            if (this.f807b.getLayoutParams() != null) {
                ((LayoutParams) this.f807b.getLayoutParams()).c = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.q);
            this.q = 0;
        }

        void a() {
            this.e = -1;
            this.h = -1;
        }

        void a(o oVar, boolean z) {
            this.o = oVar;
            this.p = z;
        }

        void a(int i, int i2) {
            this.k = (i & i2) | (this.k & (i2 ^ (-1)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.k = i | this.k;
        }

        void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.k) == 0) {
                A();
                this.l.add(obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView) {
            int i = this.r;
            if (i != -1) {
                this.q = i;
            } else {
                this.q = androidx.core.h.t.i(this.f807b);
            }
            recyclerView.a(this, 4);
        }

        public final void a(boolean z) {
            this.n = z ? this.n - 1 : this.n + 1;
            int i = this.n;
            if (i < 0) {
                this.n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i == 1) {
                this.k |= 16;
            } else if (z && this.n == 0) {
                this.k &= -17;
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        c = i2 == 18 || i2 == 19 || i2 == 20;
        d = Build.VERSION.SDK_INT >= 23;
        e = Build.VERSION.SDK_INT >= 16;
        f = Build.VERSION.SDK_INT >= 21;
        g = Build.VERSION.SDK_INT <= 15;
        h = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        i = new Class[]{Context.class, AttributeSet.class, cls, cls};
        j = new z();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void A() {
        boolean z = true;
        this.qa.a(1);
        a(this.qa);
        this.qa.j = false;
        w();
        this.p.a();
        q();
        I();
        N();
        s sVar = this.qa;
        sVar.i = (sVar.k && this.ua) ? false : false;
        this.ua = false;
        this.ta = false;
        s sVar2 = this.qa;
        sVar2.h = sVar2.l;
        sVar2.f = this.v.a();
        a(this.ya);
        if (this.qa.k) {
            int a2 = this.o.a();
            for (int i2 = 0; i2 < a2; i2++) {
                v g2 = g(this.o.c(i2));
                if (!g2.x() && (!g2.n() || this.v.b())) {
                    this.p.c(g2, this.W.a(this.qa, g2, f.a(g2), g2.k()));
                    if (this.qa.i && g2.s() && !g2.p() && !g2.x() && !g2.n()) {
                        this.p.a(d(g2), g2);
                    }
                }
            }
        }
        if (this.qa.l) {
            v();
            s sVar3 = this.qa;
            boolean z2 = sVar3.g;
            sVar3.g = false;
            this.w.e(this.l, sVar3);
            this.qa.g = z2;
            for (int i3 = 0; i3 < this.o.a(); i3++) {
                v g3 = g(this.o.c(i3));
                if (!g3.x() && !this.p.c(g3)) {
                    int a3 = f.a(g3);
                    boolean b2 = g3.b(CpioConstants.C_ISCHR);
                    if (!b2) {
                        a3 |= CpioConstants.C_ISFIFO;
                    }
                    f.c a4 = this.W.a(this.qa, g3, a3, g3.k());
                    if (b2) {
                        a(g3, a4);
                    } else {
                        this.p.a(g3, a4);
                    }
                }
            }
            a();
        } else {
            a();
        }
        r();
        c(false);
        this.qa.e = 2;
    }

    private void B() {
        w();
        q();
        this.qa.a(6);
        this.n.b();
        this.qa.f = this.v.a();
        s sVar = this.qa;
        sVar.d = 0;
        sVar.h = false;
        this.w.e(this.l, sVar);
        s sVar2 = this.qa;
        sVar2.g = false;
        this.m = null;
        sVar2.k = sVar2.k && this.W != null;
        this.qa.e = 4;
        r();
        c(false);
    }

    private void C() {
        this.qa.a(4);
        w();
        q();
        s sVar = this.qa;
        sVar.e = 1;
        if (sVar.k) {
            for (int a2 = this.o.a() - 1; a2 >= 0; a2--) {
                v g2 = g(this.o.c(a2));
                if (!g2.x()) {
                    long d2 = d(g2);
                    f.c a3 = this.W.a(this.qa, g2);
                    v a4 = this.p.a(d2);
                    if (a4 != null && !a4.x()) {
                        boolean b2 = this.p.b(a4);
                        boolean b3 = this.p.b(g2);
                        if (b2 && a4 == g2) {
                            this.p.b(g2, a3);
                        } else {
                            f.c f2 = this.p.f(a4);
                            this.p.b(g2, a3);
                            f.c e2 = this.p.e(g2);
                            if (f2 == null) {
                                a(d2, g2, a4);
                            } else {
                                a(a4, g2, f2, e2, b2, b3);
                            }
                        }
                    } else {
                        this.p.b(g2, a3);
                    }
                }
            }
            this.p.a(this.Ga);
        }
        this.w.c(this.l);
        s sVar2 = this.qa;
        sVar2.c = sVar2.f;
        this.N = false;
        this.O = false;
        sVar2.k = false;
        sVar2.l = false;
        this.w.h = false;
        ArrayList<v> arrayList = this.l.f800b;
        if (arrayList != null) {
            arrayList.clear();
        }
        i iVar = this.w;
        if (iVar.n) {
            iVar.m = 0;
            iVar.n = false;
            this.l.j();
        }
        this.w.g(this.qa);
        r();
        c(false);
        this.p.a();
        int[] iArr = this.ya;
        if (k(iArr[0], iArr[1])) {
            d(0, 0);
        }
        J();
        L();
    }

    private View D() {
        v c2;
        int i2 = this.qa.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int a2 = this.qa.a();
        for (int i3 = i2; i3 < a2; i3++) {
            v c3 = c(i3);
            if (c3 == null) {
                break;
            } else if (c3.f807b.hasFocusable()) {
                return c3.f807b;
            }
        }
        int min = Math.min(a2, i2);
        while (true) {
            min--;
            if (min < 0 || (c2 = c(min)) == null) {
                return null;
            }
            if (c2.f807b.hasFocusable()) {
                return c2.f807b;
            }
        }
    }

    private boolean E() {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            v g2 = g(this.o.c(i2));
            if (g2 != null && !g2.x() && g2.s()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void F() {
        if (androidx.core.h.t.j(this) == 0) {
            androidx.core.h.t.e(this, 8);
        }
    }

    private void G() {
        this.o = new C0088b(new B(this));
    }

    private boolean H() {
        return this.W != null && this.w.C();
    }

    private void I() {
        if (this.N) {
            this.n.f();
            if (this.O) {
                this.w.d(this);
            }
        }
        if (H()) {
            this.n.e();
        } else {
            this.n.b();
        }
        boolean z = false;
        boolean z2 = this.ta || this.ua;
        this.qa.k = this.E && this.W != null && (this.N || z2 || this.w.h) && (!this.N || this.v.b());
        s sVar = this.qa;
        if (sVar.k && z2 && !this.N && H()) {
            z = true;
        }
        sVar.l = z;
    }

    private void J() {
        View view;
        if (!this.ma || this.v == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (h && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.o.a() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.o.c(focusedChild)) {
                return;
            }
        }
        View view2 = null;
        v a2 = (this.qa.n == -1 || !this.v.b()) ? null : a(this.qa.n);
        if (a2 != null && !this.o.c(a2.f807b) && a2.f807b.hasFocusable()) {
            view2 = a2.f807b;
        } else if (this.o.a() > 0) {
            view2 = D();
        }
        if (view2 != null) {
            int i2 = this.qa.o;
            if (i2 == -1 || (view = view2.findViewById(i2)) == null || !view.isFocusable()) {
                view = view2;
            }
            view.requestFocus();
        }
    }

    private void K() {
        boolean z;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.S.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.V.isFinished();
        }
        if (z) {
            androidx.core.h.t.C(this);
        }
    }

    private void L() {
        s sVar = this.qa;
        sVar.n = -1L;
        sVar.m = -1;
        sVar.o = -1;
    }

    private void M() {
        VelocityTracker velocityTracker = this.ca;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        a(0);
        K();
    }

    private void N() {
        int f2;
        View focusedChild = (this.ma && hasFocus() && this.v != null) ? getFocusedChild() : null;
        v d2 = focusedChild != null ? d(focusedChild) : null;
        if (d2 == null) {
            L();
            return;
        }
        this.qa.n = this.v.b() ? d2.g() : -1L;
        s sVar = this.qa;
        if (this.N) {
            f2 = -1;
        } else {
            f2 = d2.p() ? d2.e : d2.f();
        }
        sVar.m = f2;
        this.qa.o = l(d2.f807b);
    }

    private void O() {
        this.na.b();
        i iVar = this.w;
        if (iVar != null) {
            iVar.B();
        }
    }

    private void e(v vVar) {
        View view = vVar.f807b;
        boolean z = view.getParent() == this;
        this.l.c(f(view));
        if (vVar.r()) {
            this.o.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.o.a(view, true);
        } else {
            this.o.a(view);
        }
    }

    private androidx.core.h.k getScrollingChildHelper() {
        if (this.za == null) {
            this.za = new androidx.core.h.k(this);
        }
        return this.za;
    }

    private void y() {
        M();
        setScrollState(0);
    }

    private void z() {
        int i2 = this.J;
        this.J = 0;
        if (i2 == 0 || !m()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        androidx.core.h.a.a.a(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.w;
        if (iVar == null || !iVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addOnChildAttachStateChangeListener(j jVar) {
        if (this.M == null) {
            this.M = new ArrayList();
        }
        this.M.add(jVar);
    }

    public void addOnItemTouchListener(l lVar) {
        this.z.add(lVar);
    }

    public void addOnScrollListener(m mVar) {
        if (this.sa == null) {
            this.sa = new ArrayList();
        }
        this.sa.add(mVar);
    }

    public void b(h hVar) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.y.remove(hVar);
        if (this.y.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        o();
        requestLayout();
    }

    void c(boolean z) {
        if (this.F < 1) {
            this.F = 1;
        }
        if (!z && !this.H) {
            this.G = false;
        }
        if (this.F == 1) {
            if (z && this.G && !this.H && this.w != null && this.v != null) {
                c();
            }
            if (!this.H) {
                this.G = false;
            }
        }
        this.F--;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.w.a((LayoutParams) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.a(this.qa);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.b(this.qa);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.c(this.qa);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.d(this.qa);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.e(this.qa);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.f(this.qa);
        }
        return 0;
    }

    long d(v vVar) {
        return this.v.b() ? vVar.g() : vVar.d;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.y.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).b(canvas, this, this.qa);
        }
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.q ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.S;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.q) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.T;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.q ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.U;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.V;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.q) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.W != null && this.y.size() > 0 && this.W.g()) {
            z2 = true;
        }
        if (z2) {
            androidx.core.h.t.C(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    void f() {
        if (this.S != null) {
            return;
        }
        this.S = this.R.a(this, 0);
        if (this.q) {
            this.S.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.S.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z;
        View d2 = this.w.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z2 = (this.v == null || this.w == null || n() || this.H) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.w.b()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (g) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.w.a()) {
                int i4 = (this.w.j() == 1) ^ (i2 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (g) {
                    i2 = i4;
                }
            }
            if (z) {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                this.w.a(view, i2, this.l, this.qa);
                c(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z2) {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                view2 = this.w.a(view, i2, this.l, this.qa);
                c(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            a(view2, (View) null);
            return view;
        }
    }

    void g() {
        if (this.U != null) {
            return;
        }
        this.U = this.R.a(this, 2);
        if (this.q) {
            this.U.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.U.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void g(int i2) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    public a getAdapter() {
        return this.v;
    }

    @Override // android.view.View
    public int getBaseline() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.d();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.xa;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.q;
    }

    public G getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public e getEdgeEffectFactory() {
        return this.R;
    }

    public f getItemAnimator() {
        return this.W;
    }

    public int getItemDecorationCount() {
        return this.y.size();
    }

    public i getLayoutManager() {
        return this.w;
    }

    public int getMaxFlingVelocity() {
        return this.ja;
    }

    public int getMinFlingVelocity() {
        return this.ia;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f) {
            return System.nanoTime();
        }
        return 0L;
    }

    public k getOnFlingListener() {
        return this.ha;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ma;
    }

    public n getRecycledViewPool() {
        return this.l.d();
    }

    public int getScrollState() {
        return this.aa;
    }

    void h() {
        if (this.T != null) {
            return;
        }
        this.T = this.R.a(this, 1);
        if (this.q) {
            this.T.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.T.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void h(int i2, int i3) {
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return " " + super.toString() + ", adapter:" + this.v + ", layout:" + this.w + ", context:" + getContext();
    }

    public void i(View view) {
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.B;
    }

    @Override // android.view.View, androidx.core.h.j
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().b();
    }

    public void j(View view) {
    }

    public boolean j() {
        return !this.E || this.N || this.n.c();
    }

    void k() {
        this.n = new C0087a(new C(this));
    }

    void l() {
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    boolean m() {
        AccessibilityManager accessibilityManager = this.L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean n() {
        return this.P > 0;
    }

    void o() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((LayoutParams) this.o.d(i2).getLayoutParams()).c = true;
        }
        this.l.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r0 >= 30.0f) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.P = r0
            r1 = 1
            r4.B = r1
            boolean r2 = r4.E
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.E = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.w
            if (r1 == 0) goto L1e
            r1.a(r4)
        L1e:
            r4.wa = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f
            if (r0 == 0) goto L67
            java.lang.ThreadLocal<androidx.recyclerview.widget.p> r0 = androidx.recyclerview.widget.p.f853a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.p r0 = (androidx.recyclerview.widget.p) r0
            r4.oa = r0
            androidx.recyclerview.widget.p r0 = r4.oa
            if (r0 != 0) goto L62
            androidx.recyclerview.widget.p r0 = new androidx.recyclerview.widget.p
            r0.<init>()
            r4.oa = r0
            android.view.Display r0 = androidx.core.h.t.f(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            androidx.recyclerview.widget.p r1 = r4.oa
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.e = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.p> r0 = androidx.recyclerview.widget.p.f853a
            r0.set(r1)
        L62:
            androidx.recyclerview.widget.p r0 = r4.oa
            r0.a(r4)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.p pVar;
        super.onDetachedFromWindow();
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        x();
        this.B = false;
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(this, this.l);
        }
        this.Ea.clear();
        removeCallbacks(this.Fa);
        this.p.b();
        if (!f || (pVar = this.oa) == null) {
            return;
        }
        pVar.b(this);
        this.oa = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).a(canvas, this, this.qa);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.w
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.H
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.w
            boolean r0 = r0.b()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.w
            boolean r3 = r3.a()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.w
            boolean r3 = r3.b()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.w
            boolean r3 = r3.a()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.ka
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.la
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.H) {
            return false;
        }
        if (b(motionEvent)) {
            y();
            return true;
        }
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        boolean a2 = iVar.a();
        boolean b2 = this.w.b();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        this.ca.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.I) {
                this.I = false;
            }
            this.ba = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.fa = x;
            this.da = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.ga = y;
            this.ea = y;
            if (this.aa == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.Ca;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = a2 ? 1 : 0;
            if (b2) {
                i2 |= 2;
            }
            j(i2, 0);
        } else if (actionMasked == 1) {
            this.ca.clear();
            a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ba + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.aa != 1) {
                int i3 = x2 - this.da;
                int i4 = y2 - this.ea;
                if (!a2 || Math.abs(i3) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.fa = x2;
                    z = true;
                }
                if (b2 && Math.abs(i4) > this.mTouchSlop) {
                    this.ga = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x3;
            this.da = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y3;
            this.ea = y3;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        return this.aa == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        androidx.core.d.a.a("RV OnLayout");
        c();
        androidx.core.d.a.a();
        this.E = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            c(i2, i3);
            return;
        }
        boolean z = false;
        if (iVar.u()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.w.a(this.l, this.qa, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.v == null) {
                return;
            }
            if (this.qa.e == 1) {
                A();
            }
            this.w.b(i2, i3);
            this.qa.j = true;
            B();
            this.w.d(i2, i3);
            if (this.w.A()) {
                this.w.b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.qa.j = true;
                B();
                this.w.d(i2, i3);
            }
        } else if (this.C) {
            this.w.a(this.l, this.qa, i2, i3);
        } else {
            if (this.K) {
                w();
                q();
                I();
                r();
                s sVar = this.qa;
                if (sVar.l) {
                    sVar.h = true;
                } else {
                    this.n.b();
                    this.qa.h = false;
                }
                this.K = false;
                c(false);
            } else if (this.qa.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            a aVar = this.v;
            if (aVar != null) {
                this.qa.f = aVar.a();
            } else {
                this.qa.f = 0;
            }
            w();
            this.w.a(this.l, this.qa, i2, i3);
            c(false);
            this.qa.h = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (n()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.m = (SavedState) parcelable;
        super.onRestoreInstanceState(this.m.a());
        i iVar = this.w;
        if (iVar == null || (parcelable2 = this.m.c) == null) {
            return;
        }
        iVar.a(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.m;
        if (savedState2 != null) {
            savedState.a(savedState2);
        } else {
            i iVar = this.w;
            if (iVar != null) {
                savedState.c = iVar.x();
            } else {
                savedState.c = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v g2 = g(this.o.d(i2));
            if (g2 != null && !g2.x()) {
                g2.a(6);
            }
        }
        o();
        this.l.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.P++;
    }

    void r() {
        a(true);
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        v g2 = g(view);
        if (g2 != null) {
            if (g2.r()) {
                g2.d();
            } else if (!g2.x()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + g2 + i());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z);
    }

    public void removeOnChildAttachStateChangeListener(j jVar) {
        List<j> list = this.M;
        if (list == null) {
            return;
        }
        list.remove(jVar);
    }

    public void removeOnItemTouchListener(l lVar) {
        this.z.remove(lVar);
        if (this.A == lVar) {
            this.A = null;
        }
    }

    public void removeOnScrollListener(m mVar) {
        List<m> list = this.sa;
        if (list != null) {
            list.remove(mVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.w.a(this, this.qa, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.w.a(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.z.get(i2).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.F == 0 && !this.H) {
            super.requestLayout();
        } else {
            this.G = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        if (this.wa || !this.B) {
            return;
        }
        androidx.core.h.t.a(this, this.Fa);
        this.wa = true;
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.H) {
        } else {
            boolean a2 = iVar.a();
            boolean b2 = this.w.b();
            if (a2 || b2) {
                if (!a2) {
                    i2 = 0;
                }
                if (!b2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(G g2) {
        this.mAccessibilityDelegate = g2;
        androidx.core.h.t.a(this, this.mAccessibilityDelegate);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.xa) {
            return;
        }
        this.xa = dVar;
        setChildrenDrawingOrderEnabled(this.xa != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.q) {
            l();
        }
        this.q = z;
        super.setClipToPadding(z);
        if (this.E) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.g.h.a(eVar);
        this.R = eVar;
        l();
    }

    public void setHasFixedSize(boolean z) {
        this.C = z;
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.W;
        if (fVar2 != null) {
            fVar2.b();
            this.W.a((f.b) null);
        }
        this.W = fVar;
        f fVar3 = this.W;
        if (fVar3 != null) {
            fVar3.a(this.va);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.l.f(i2);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.H) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.H = false;
                if (this.G && this.w != null && this.v != null) {
                    requestLayout();
                }
                this.G = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.H = true;
            this.I = true;
            x();
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar == this.w) {
            return;
        }
        x();
        if (this.w != null) {
            f fVar = this.W;
            if (fVar != null) {
                fVar.b();
            }
            this.w.b(this.l);
            this.w.c(this.l);
            this.l.a();
            if (this.B) {
                this.w.a(this, this.l);
            }
            this.w.f((RecyclerView) null);
            this.w = null;
        } else {
            this.l.a();
        }
        this.o.c();
        this.w = iVar;
        if (iVar != null) {
            if (iVar.f792b == null) {
                this.w.f(this);
                if (this.B) {
                    this.w.a(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.f792b.i());
            }
        }
        this.l.j();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public void setOnFlingListener(k kVar) {
        this.ha = kVar;
    }

    @Deprecated
    public void setOnScrollListener(m mVar) {
        this.ra = mVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.ma = z;
    }

    public void setRecycledViewPool(n nVar) {
        this.l.a(nVar);
    }

    public void setRecyclerListener(p pVar) {
        this.x = pVar;
    }

    void setScrollState(int i2) {
        if (i2 == this.aa) {
            return;
        }
        this.aa = i2;
        if (i2 != 2) {
            O();
        }
        b(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(t tVar) {
        this.l.a(tVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    @Override // android.view.View, androidx.core.h.j
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.b(this.l);
            this.w.c(this.l);
        }
        this.l.a();
    }

    void u() {
        v vVar;
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View c2 = this.o.c(i2);
            v f2 = f(c2);
            if (f2 != null && (vVar = f2.j) != null) {
                View view = vVar.f807b;
                int left = c2.getLeft();
                int top = c2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void v() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v g2 = g(this.o.d(i2));
            if (!g2.x()) {
                g2.v();
            }
        }
    }

    void w() {
        this.F++;
        if (this.F != 1 || this.H) {
            return;
        }
        this.G = false;
    }

    public void x() {
        setScrollState(0);
        O();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int l(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public v d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return f(c2);
    }

    boolean k(View view) {
        w();
        boolean e2 = this.o.e(view);
        if (e2) {
            v g2 = g(view);
            this.l.c(g2);
            this.l.b(g2);
        }
        c(!e2);
        return e2;
    }

    /* loaded from: classes.dex */
    public static class n {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f795a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f796b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<v> f797a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f798b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        public v a(int i) {
            a aVar = this.f795a.get(i);
            if (aVar == null || aVar.f797a.isEmpty()) {
                return null;
            }
            ArrayList<v> arrayList = aVar.f797a;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void b() {
            for (int i = 0; i < this.f795a.size(); i++) {
                this.f795a.valueAt(i).f797a.clear();
            }
        }

        void c() {
            this.f796b--;
        }

        void b(int i, long j) {
            a b2 = b(i);
            b2.c = a(b2.c, j);
        }

        public void a(v vVar) {
            int h = vVar.h();
            ArrayList<v> arrayList = b(h).f797a;
            if (this.f795a.get(h).f798b <= arrayList.size()) {
                return;
            }
            vVar.u();
            arrayList.add(vVar);
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        private a b(int i) {
            a aVar = this.f795a.get(i);
            if (aVar == null) {
                a aVar2 = new a();
                this.f795a.put(i, aVar2);
                return aVar2;
            }
            return aVar;
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void a(int i, long j) {
            a b2 = b(i);
            b2.d = a(b2.d, j);
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        void a() {
            this.f796b++;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f796b == 0) {
                b();
            }
            if (aVar2 != null) {
                a();
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new q();
        this.l = new o();
        this.p = new N();
        this.r = new x(this);
        this.s = new Rect();
        this.t = new Rect();
        this.u = new RectF();
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = new e();
        this.W = new C0097k();
        this.aa = 0;
        this.ba = -1;
        this.ka = Float.MIN_VALUE;
        this.la = Float.MIN_VALUE;
        boolean z = true;
        this.ma = true;
        this.na = new u();
        this.pa = f ? new p.a() : null;
        this.qa = new s();
        this.ta = false;
        this.ua = false;
        this.va = new g();
        this.wa = false;
        this.ya = new int[2];
        this.Aa = new int[2];
        this.Ba = new int[2];
        this.Ca = new int[2];
        this.Da = new int[2];
        this.Ea = new ArrayList();
        this.Fa = new y(this);
        this.Ga = new A(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f781b, i2, 0);
            this.q = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.q = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.ka = androidx.core.h.u.a(viewConfiguration, context);
        this.la = androidx.core.h.u.b(viewConfiguration, context);
        this.ia = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ja = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.W.a(this.va);
        k();
        G();
        F();
        if (androidx.core.h.t.i(this) == 0) {
            androidx.core.h.t.d(this, 1);
        }
        this.L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new G(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(R$styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.D = obtainStyledAttributes2.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
            if (this.D) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f780a, i2, 0);
                boolean z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    public void i(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        v f782a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f783b;
        boolean c;
        boolean d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f783b = new Rect();
            this.c = true;
            this.d = false;
        }

        public int a() {
            return this.f782a.i();
        }

        public boolean b() {
            return this.f782a.s();
        }

        public boolean c() {
            return this.f782a.p();
        }

        public boolean d() {
            return this.f782a.n();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f783b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f783b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f783b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f783b = new Rect();
            this.c = true;
            this.d = false;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new F();
        Parcelable c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        void a(SavedState savedState) {
            this.c = savedState.c;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public static class s {

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f803b;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* renamed from: a  reason: collision with root package name */
        int f802a = -1;
        int c = 0;
        int d = 0;
        int e = 1;
        int f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;

        void a(int i) {
            if ((this.e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.e));
        }

        public int b() {
            return this.f802a;
        }

        public boolean c() {
            return this.f802a != -1;
        }

        public boolean d() {
            return this.h;
        }

        public boolean e() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f802a + ", mData=" + this.f803b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(a aVar) {
            this.e = 1;
            this.f = aVar.a();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public int a() {
            return this.h ? this.c - this.d : this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f804a;

        /* renamed from: b  reason: collision with root package name */
        private int f805b;
        OverScroller c;
        Interpolator d = RecyclerView.j;
        private boolean e = false;
        private boolean f = false;

        u() {
            this.c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.j);
        }

        private void c() {
            this.f = false;
            this.e = true;
        }

        private void d() {
            this.e = false;
            if (this.f) {
                a();
            }
        }

        void a() {
            if (this.e) {
                this.f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            androidx.core.h.t.a(RecyclerView.this, this);
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.c.abortAnimation();
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
            if (r8 > 0) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00fe A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 418
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u.run():void");
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f805b = 0;
            this.f804a = 0;
            this.c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        private float a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float a2 = f2 + (a(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int a2 = a(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.j;
            }
            a(i, i2, a2, interpolator);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.d != interpolator) {
                this.d = interpolator;
                this.c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f805b = 0;
            this.f804a = 0;
            this.c.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.c.computeScrollOffset();
            }
            a();
        }
    }

    void d(int i2, int i3) {
        this.Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        m mVar = this.ra;
        if (mVar != null) {
            mVar.a(this, i2, i3);
        }
        List<m> list = this.sa;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sa.get(size).a(this, i2, i3);
            }
        }
        this.Q--;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String a2 = a(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(i.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(i);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((i) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e8);
            }
        }
    }

    private boolean k(int i2, int i3) {
        a(this.ya);
        int[] iArr = this.ya;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.E && !this.N) {
            if (this.n.c()) {
                if (this.n.c(4) && !this.n.c(11)) {
                    androidx.core.d.a.a("RV PartialInvalidate");
                    w();
                    q();
                    this.n.e();
                    if (!this.G) {
                        if (E()) {
                            c();
                        } else {
                            this.n.a();
                        }
                    }
                    c(true);
                    r();
                    androidx.core.d.a.a();
                    return;
                } else if (this.n.c()) {
                    androidx.core.d.a.a("RV FullInvalidate");
                    c();
                    androidx.core.d.a.a();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        androidx.core.d.a.a("RV FullInvalidate");
        c();
        androidx.core.d.a.a();
    }

    public boolean e(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.H) {
            return false;
        } else {
            boolean a2 = iVar.a();
            boolean b2 = this.w.b();
            i2 = (!a2 || Math.abs(i2) < this.ia) ? 0 : 0;
            i3 = (!b2 || Math.abs(i3) < this.ia) ? 0 : 0;
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = i2;
            float f3 = i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z = a2 || b2;
                dispatchNestedFling(f2, f3, z);
                k kVar = this.ha;
                if (kVar != null && kVar.a(i2, i3)) {
                    return true;
                }
                if (z) {
                    int i4 = a2 ? 1 : 0;
                    if (b2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    int i5 = this.ja;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.ja;
                    this.na.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i2, int i3) {
        int b2 = this.o.b();
        for (int i4 = 0; i4 < b2; i4++) {
            v g2 = g(this.o.d(i4));
            if (g2 != null && !g2.x() && g2.d >= i2) {
                g2.a(i3, false);
                this.qa.g = true;
            }
        }
        this.l.a(i2, i3);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int b2 = this.o.b();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < b2; i8++) {
            v g2 = g(this.o.d(i8));
            if (g2 != null && (i7 = g2.d) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    g2.a(i3 - i2, false);
                } else {
                    g2.a(i6, false);
                }
                this.qa.g = true;
            }
        }
        this.l.b(i2, i3);
        requestLayout();
    }

    Rect h(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.c) {
            return layoutParams.f783b;
        }
        if (this.qa.d() && (layoutParams.b() || layoutParams.d())) {
            return layoutParams.f783b;
        }
        Rect rect = layoutParams.f783b;
        rect.set(0, 0, 0, 0);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.set(0, 0, 0, 0);
            this.y.get(i2).a(this.s, view, this, this.qa);
            int i3 = rect.left;
            Rect rect2 = this.s;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.c = false;
        return rect;
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ba) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.ba = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.fa = x;
            this.da = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.ga = y;
            this.ea = y;
        }
    }

    void d() {
        int i2;
        for (int size = this.Ea.size() - 1; size >= 0; size--) {
            v vVar = this.Ea.get(size);
            if (vVar.f807b.getParent() == this && !vVar.x() && (i2 = vVar.r) != -1) {
                androidx.core.h.t.d(vVar.f807b, i2);
                vVar.r = -1;
            }
        }
        this.Ea.clear();
    }

    public v f(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return g(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v g(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f782a;
    }

    void c(int i2, int i3) {
        setMeasuredDimension(i.a(i2, getPaddingLeft() + getPaddingRight(), androidx.core.h.t.m(this)), i.a(i3, getPaddingTop() + getPaddingBottom(), androidx.core.h.t.l(this)));
    }

    public void f(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetTopAndBottom(i2);
        }
    }

    public boolean d(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    void e() {
        if (this.V != null) {
            return;
        }
        this.V = this.R.a(this, 3);
        if (this.q) {
            this.V.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.V.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void c() {
        if (this.v == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.w == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            s sVar = this.qa;
            sVar.j = false;
            if (sVar.e == 1) {
                A();
                this.w.e(this);
                B();
            } else if (!this.n.d() && this.w.q() == getWidth() && this.w.h() == getHeight()) {
                this.w.e(this);
            } else {
                this.w.e(this);
                B();
            }
            C();
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void a(a aVar, boolean z, boolean z2) {
        a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.b(this.k);
            this.v.b(this);
        }
        if (!z || z2) {
            t();
        }
        this.n.f();
        a aVar3 = this.v;
        this.v = aVar;
        if (aVar != null) {
            aVar.a(this.k);
            aVar.a(this);
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(aVar3, this.v);
        }
        this.l.a(aVar3, this.v, z);
        this.qa.g = true;
    }

    public void e(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetLeftAndRight(i2);
        }
    }

    void b(int i2, int i3) {
        boolean z;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z = false;
        } else {
            this.S.onRelease();
            z = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.U.onRelease();
            z |= this.U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.T.onRelease();
            z |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.V.onRelease();
            z |= this.V.isFinished();
        }
        if (z) {
            androidx.core.h.t.C(this);
        }
    }

    static RecyclerView e(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RecyclerView e2 = e(viewGroup.getChildAt(i2));
                if (e2 != null) {
                    return e2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View c(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c(android.view.View):android.view.View");
    }

    public void a(h hVar, int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.y.add(hVar);
        } else {
            this.y.add(i2, hVar);
        }
        o();
        requestLayout();
    }

    public v c(int i2) {
        v vVar = null;
        if (this.N) {
            return null;
        }
        int b2 = this.o.b();
        for (int i3 = 0; i3 < b2; i3++) {
            v g2 = g(this.o.d(i3));
            if (g2 != null && !g2.p() && c(g2) == i2) {
                if (!this.o.c(g2.f807b)) {
                    return g2;
                }
                vVar = g2;
            }
        }
        return vVar;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.A = null;
        }
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.z.get(i2);
            if (lVar.b(this, motionEvent) && action != 3) {
                this.A = lVar;
                return true;
            }
        }
        return false;
    }

    int c(v vVar) {
        if (vVar.b(524) || !vVar.m()) {
            return -1;
        }
        return this.n.a(vVar.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(v vVar, f.c cVar, f.c cVar2) {
        e(vVar);
        vVar.a(false);
        if (this.W.b(vVar, cVar, cVar2)) {
            s();
        }
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    void a(int i2, int i3, int[] iArr) {
        w();
        q();
        androidx.core.d.a.a("RV Scroll");
        a(this.qa);
        int a2 = i2 != 0 ? this.w.a(i2, this.l, this.qa) : 0;
        int b2 = i3 != 0 ? this.w.b(i3, this.l, this.qa) : 0;
        androidx.core.d.a.a();
        u();
        r();
        c(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    void b(boolean z) {
        this.O = z | this.O;
        this.N = true;
        p();
    }

    void b(int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.f(i2);
        }
        g(i2);
        m mVar = this.ra;
        if (mVar != null) {
            mVar.a(this, i2);
        }
        List<m> list = this.sa;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sa.get(size).a(this, i2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009b, code lost:
        if (r0 != 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean a(int r19, int r20, android.view.MotionEvent r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r18.b()
            androidx.recyclerview.widget.RecyclerView$a r0 = r7.v
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L25
            int[] r0 = r7.Da
            r7.a(r8, r9, r0)
            int[] r0 = r7.Da
            r1 = r0[r12]
            r0 = r0[r11]
            int r2 = r8 - r1
            int r3 = r9 - r0
            r6 = r0
            r15 = r1
            r13 = r2
            r14 = r3
            goto L29
        L25:
            r6 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L29:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r0 = r7.y
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            r18.invalidate()
        L34:
            int[] r5 = r7.Aa
            r16 = 0
            r0 = r18
            r1 = r15
            r2 = r6
            r3 = r13
            r4 = r14
            r17 = r6
            r6 = r16
            boolean r0 = r0.a(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L76
            int r0 = r7.fa
            int[] r1 = r7.Aa
            r2 = r1[r12]
            int r0 = r0 - r2
            r7.fa = r0
            int r0 = r7.ga
            r2 = r1[r11]
            int r0 = r0 - r2
            r7.ga = r0
            if (r10 == 0) goto L63
            r0 = r1[r12]
            float r0 = (float) r0
            r1 = r1[r11]
            float r1 = (float) r1
            r10.offsetLocation(r0, r1)
        L63:
            int[] r0 = r7.Ca
            r1 = r0[r12]
            int[] r2 = r7.Aa
            r3 = r2[r12]
            int r1 = r1 + r3
            r0[r12] = r1
            r1 = r0[r11]
            r2 = r2[r11]
            int r1 = r1 + r2
            r0[r11] = r1
            goto L97
        L76:
            int r0 = r18.getOverScrollMode()
            r1 = 2
            if (r0 == r1) goto L97
            if (r10 == 0) goto L94
            r0 = 8194(0x2002, float:1.1482E-41)
            boolean r0 = androidx.core.h.h.a(r10, r0)
            if (r0 != 0) goto L94
            float r0 = r21.getX()
            float r1 = (float) r13
            float r2 = r21.getY()
            float r3 = (float) r14
            r7.a(r0, r1, r2, r3)
        L94:
            r18.b(r19, r20)
        L97:
            if (r15 != 0) goto L9e
            r0 = r17
            if (r0 == 0) goto La3
            goto La0
        L9e:
            r0 = r17
        La0:
            r7.d(r15, r0)
        La3:
            boolean r1 = r18.awakenScrollBars()
            if (r1 != 0) goto Lac
            r18.invalidate()
        Lac:
            if (r15 != 0) goto Lb0
            if (r0 == 0) goto Lb1
        Lb0:
            r12 = 1
        Lb1:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, int, android.view.MotionEvent):boolean");
    }

    static void b(v vVar) {
        WeakReference<RecyclerView> weakReference = vVar.c;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == vVar.f807b) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            vVar.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view) {
        v g2 = g(view);
        j(view);
        a aVar = this.v;
        if (aVar != null && g2 != null) {
            aVar.c(g2);
        }
        List<j> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).a(view);
            }
        }
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.H) {
        } else {
            if (!iVar.a()) {
                i2 = 0;
            }
            if (!this.w.b()) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            this.na.a(i2, i3, interpolator);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.f()
            android.widget.EdgeEffect r3 = r6.S
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.f.a(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.g()
            android.widget.EdgeEffect r3 = r6.U
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.f.a(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.h()
            android.widget.EdgeEffect r9 = r6.T
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.f.a(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.e()
            android.widget.EdgeEffect r9 = r6.V
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.f.a(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.h.t.C(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    void a(int i2, int i3) {
        if (i2 < 0) {
            f();
            this.S.onAbsorb(-i2);
        } else if (i2 > 0) {
            g();
            this.U.onAbsorb(i2);
        }
        if (i3 < 0) {
            h();
            this.T.onAbsorb(-i3);
        } else if (i3 > 0) {
            e();
            this.V.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        androidx.core.h.t.C(this);
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.s.set(0, 0, view.getWidth(), view.getHeight());
        this.t.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.s);
        offsetDescendantRectToMyCoords(view2, this.t);
        char c2 = 65535;
        int i4 = this.w.j() == 1 ? -1 : 1;
        Rect rect = this.s;
        int i5 = rect.left;
        int i6 = this.t.left;
        if ((i5 < i6 || rect.right <= i6) && this.s.right < this.t.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.s;
            int i7 = rect2.right;
            int i8 = this.t.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.s.left > this.t.left) ? -1 : 0;
        }
        Rect rect3 = this.s;
        int i9 = rect3.top;
        int i10 = this.t.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.s.bottom < this.t.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.s;
            int i11 = rect4.bottom;
            int i12 = this.t.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.s.top <= this.t.top) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        } else if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        } else if (i2 == 17) {
            return i3 < 0;
        } else if (i2 == 33) {
            return c2 < 0;
        } else if (i2 == 66) {
            return i3 > 0;
        } else if (i2 == 130) {
            return c2 > 0;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + i2 + i());
        }
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.s.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.c) {
                Rect rect = layoutParams2.f783b;
                Rect rect2 = this.s;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.s);
            offsetRectIntoDescendantCoords(view, this.s);
        }
        this.w.a(this, view, this.s, !this.E, view2 == null);
    }

    void a(String str) {
        if (n()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + i());
            }
            throw new IllegalStateException(str);
        } else if (this.Q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + i()));
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        l lVar = this.A;
        if (lVar != null) {
            if (action == 0) {
                this.A = null;
            } else {
                lVar.a(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.A = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.z.size();
            for (int i2 = 0; i2 < size; i2++) {
                l lVar2 = this.z.get(i2);
                if (lVar2.b(this, motionEvent)) {
                    this.A = lVar2;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.P--;
        if (this.P < 1) {
            this.P = 0;
            if (z) {
                z();
                d();
            }
        }
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (n()) {
            int a2 = accessibilityEvent != null ? androidx.core.h.a.a.a(accessibilityEvent) : 0;
            if (a2 == 0) {
                a2 = 0;
            }
            this.J = a2 | this.J;
            return true;
        }
        return false;
    }

    final void a(s sVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.na.c;
            sVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            sVar.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        sVar.p = 0;
        sVar.q = 0;
    }

    private void a(long j2, v vVar, v vVar2) {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            v g2 = g(this.o.c(i2));
            if (g2 != vVar && d(g2) == j2) {
                a aVar = this.v;
                if (aVar != null && aVar.b()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + g2 + " \n View Holder 2:" + vVar + i());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + g2 + " \n View Holder 2:" + vVar + i());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + vVar2 + " cannot be found but it is necessary for " + vVar + i());
    }

    void a(v vVar, f.c cVar) {
        vVar.a(0, CpioConstants.C_ISCHR);
        if (this.qa.i && vVar.s() && !vVar.p() && !vVar.x()) {
            this.p.a(d(vVar), vVar);
        }
        this.p.c(vVar, cVar);
    }

    private void a(int[] iArr) {
        int a2 = this.o.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            v g2 = g(this.o.c(i4));
            if (!g2.x()) {
                int i5 = g2.i();
                if (i5 < i2) {
                    i2 = i5;
                }
                if (i5 > i3) {
                    i3 = i5;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar, f.c cVar, f.c cVar2) {
        vVar.a(false);
        if (this.W.a(vVar, cVar, cVar2)) {
            s();
        }
    }

    private void a(v vVar, v vVar2, f.c cVar, f.c cVar2, boolean z, boolean z2) {
        vVar.a(false);
        if (z) {
            e(vVar);
        }
        if (vVar != vVar2) {
            if (z2) {
                e(vVar2);
            }
            vVar.i = vVar2;
            e(vVar);
            this.l.c(vVar);
            vVar2.a(false);
            vVar2.j = vVar;
        }
        if (this.W.a(vVar, vVar2, cVar, cVar2)) {
            s();
        }
    }

    void a() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v g2 = g(this.o.d(i2));
            if (!g2.x()) {
                g2.a();
            }
        }
        this.l.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int b2 = this.o.b();
        for (int i5 = 0; i5 < b2; i5++) {
            v g2 = g(this.o.d(i5));
            if (g2 != null && !g2.x()) {
                int i6 = g2.d;
                if (i6 >= i4) {
                    g2.a(-i3, z);
                    this.qa.g = true;
                } else if (i6 >= i2) {
                    g2.a(i2 - 1, -i3, z);
                    this.qa.g = true;
                }
            }
        }
        this.l.a(i2, i3, z);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, int i3, Object obj) {
        int i4;
        int b2 = this.o.b();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < b2; i6++) {
            View d2 = this.o.d(i6);
            v g2 = g(d2);
            if (g2 != null && !g2.x() && (i4 = g2.d) >= i2 && i4 < i5) {
                g2.a(2);
                g2.a(obj);
                ((LayoutParams) d2.getLayoutParams()).c = true;
            }
        }
        this.l.c(i2, i3);
    }

    boolean a(v vVar) {
        f fVar = this.W;
        return fVar == null || fVar.a(vVar, vVar.k());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.v a(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.o
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.o
            android.view.View r3 = r3.d(r2)
            androidx.recyclerview.widget.RecyclerView$v r3 = g(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.p()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.d
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.i()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.o
            android.view.View r4 = r3.f807b
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, boolean):androidx.recyclerview.widget.RecyclerView$v");
    }

    public v a(long j2) {
        a aVar = this.v;
        v vVar = null;
        if (aVar != null && aVar.b()) {
            int b2 = this.o.b();
            for (int i2 = 0; i2 < b2; i2++) {
                v g2 = g(this.o.d(i2));
                if (g2 != null && !g2.p() && g2.g() == j2) {
                    if (!this.o.c(g2.f807b)) {
                        return g2;
                    }
                    vVar = g2;
                }
            }
        }
        return vVar;
    }

    static void a(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f783b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        v g2 = g(view);
        i(view);
        a aVar = this.v;
        if (aVar != null && g2 != null) {
            aVar.b((a) g2);
        }
        List<j> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).b(view);
            }
        }
    }

    boolean a(v vVar, int i2) {
        if (n()) {
            vVar.r = i2;
            this.Ea.add(vVar);
            return false;
        }
        androidx.core.h.t.d(vVar.f807b, i2);
        return true;
    }

    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new C0100n(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + i());
    }

    @Override // androidx.core.h.i
    public void a(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }
}
