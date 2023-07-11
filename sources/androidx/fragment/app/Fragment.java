package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.h, androidx.lifecycle.u {

    /* renamed from: a  reason: collision with root package name */
    private static final a.b.i<String, Class<?>> f602a = new a.b.i<>();

    /* renamed from: b  reason: collision with root package name */
    static final Object f603b = new Object();
    int A;
    String B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean I;
    ViewGroup J;
    View K;
    View L;
    boolean M;
    a O;
    boolean P;
    boolean Q;
    float R;
    LayoutInflater S;
    boolean T;
    androidx.lifecycle.j V;
    androidx.lifecycle.h W;
    Bundle d;
    SparseArray<Parcelable> e;
    Boolean f;
    String h;
    Bundle i;
    Fragment j;
    int l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    int s;
    r t;
    AbstractC0080j u;
    r v;
    s w;
    androidx.lifecycle.t x;
    Fragment y;
    int z;
    int c = 0;
    int g = -1;
    int k = -1;
    boolean H = true;
    boolean N = true;
    androidx.lifecycle.j U = new androidx.lifecycle.j(this);
    androidx.lifecycle.o<androidx.lifecycle.h> X = new androidx.lifecycle.o<>();

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0076f();

        /* renamed from: a  reason: collision with root package name */
        final Bundle f604a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.f604a = parcel.readBundle();
            if (classLoader == null || (bundle = this.f604a) == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f604a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        View f605a;

        /* renamed from: b  reason: collision with root package name */
        Animator f606b;
        int c;
        int d;
        int e;
        int f;
        Object g = null;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Boolean m;
        Boolean n;
        androidx.core.app.g o;
        androidx.core.app.g p;
        boolean q;
        c r;
        boolean s;

        a() {
            Object obj = Fragment.f603b;
            this.h = obj;
            this.i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.o = null;
            this.p = null;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    private a Y() {
        if (this.O == null) {
            this.O = new a();
        }
        return this.O;
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = f602a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f602a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.m(bundle);
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        a aVar = this.O;
        if (aVar == null) {
            return false;
        }
        return aVar.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean B() {
        return this.s > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        a aVar = this.O;
        if (aVar == null) {
            return false;
        }
        return aVar.q;
    }

    public final boolean D() {
        r rVar = this.t;
        if (rVar == null) {
            return false;
        }
        return rVar.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        r rVar = this.v;
        if (rVar != null) {
            rVar.s();
        }
    }

    public void F() {
        boolean z = true;
        this.I = true;
        FragmentActivity b2 = b();
        z = (b2 == null || !b2.isChangingConfigurations()) ? false : false;
        androidx.lifecycle.t tVar = this.x;
        if (tVar == null || z) {
            return;
        }
        tVar.a();
    }

    public void G() {
    }

    public void H() {
        this.I = true;
    }

    public void I() {
        this.I = true;
    }

    public void J() {
        this.I = true;
    }

    public void K() {
        this.I = true;
    }

    public void L() {
        this.I = true;
    }

    public void M() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0081k N() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        this.U.b(f.a.ON_DESTROY);
        r rVar = this.v;
        if (rVar != null) {
            rVar.h();
        }
        this.c = 0;
        this.I = false;
        this.T = false;
        F();
        if (this.I) {
            this.v = null;
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        if (this.K != null) {
            this.V.b(f.a.ON_DESTROY);
        }
        r rVar = this.v;
        if (rVar != null) {
            rVar.i();
        }
        this.c = 1;
        this.I = false;
        H();
        if (this.I) {
            androidx.loader.a.a.a(this).a();
            this.r = false;
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        this.I = false;
        I();
        this.S = null;
        if (this.I) {
            r rVar = this.v;
            if (rVar != null) {
                if (this.F) {
                    rVar.h();
                    this.v = null;
                    return;
                }
                throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
            }
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        onLowMemory();
        r rVar = this.v;
        if (rVar != null) {
            rVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        if (this.K != null) {
            this.V.b(f.a.ON_PAUSE);
        }
        this.U.b(f.a.ON_PAUSE);
        r rVar = this.v;
        if (rVar != null) {
            rVar.k();
        }
        this.c = 3;
        this.I = false;
        J();
        if (this.I) {
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T() {
        r rVar = this.v;
        if (rVar != null) {
            rVar.s();
            this.v.p();
        }
        this.c = 4;
        this.I = false;
        K();
        if (this.I) {
            r rVar2 = this.v;
            if (rVar2 != null) {
                rVar2.l();
                this.v.p();
            }
            this.U.b(f.a.ON_RESUME);
            if (this.K != null) {
                this.V.b(f.a.ON_RESUME);
                return;
            }
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onResume()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        r rVar = this.v;
        if (rVar != null) {
            rVar.s();
            this.v.p();
        }
        this.c = 3;
        this.I = false;
        L();
        if (this.I) {
            r rVar2 = this.v;
            if (rVar2 != null) {
                rVar2.m();
            }
            this.U.b(f.a.ON_START);
            if (this.K != null) {
                this.V.b(f.a.ON_START);
                return;
            }
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onStart()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        if (this.K != null) {
            this.V.b(f.a.ON_STOP);
        }
        this.U.b(f.a.ON_STOP);
        r rVar = this.v;
        if (rVar != null) {
            rVar.n();
        }
        this.c = 2;
        this.I = false;
        M();
        if (this.I) {
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onStop()");
    }

    public final Context W() {
        Context h = h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void X() {
        r rVar = this.t;
        if (rVar != null && rVar.s != null) {
            if (Looper.myLooper() != this.t.s.e().getLooper()) {
                this.t.s.e().postAtFrontOfQueue(new RunnableC0073c(this));
                return;
            } else {
                a();
                return;
            }
        }
        Y().q = false;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(Fragment fragment) {
    }

    public void a(boolean z) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    public final FragmentActivity b() {
        AbstractC0080j abstractC0080j = this.u;
        if (abstractC0080j == null) {
            return null;
        }
        return (FragmentActivity) abstractC0080j.b();
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void c(Bundle bundle) {
        this.I = true;
        k(bundle);
        r rVar = this.v;
        if (rVar == null || rVar.c(1)) {
            return;
        }
        this.v.g();
    }

    public void c(boolean z) {
    }

    public LayoutInflater d(Bundle bundle) {
        return a(bundle);
    }

    public void e(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z) {
        c(z);
        r rVar = this.v;
        if (rVar != null) {
            rVar.b(z);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(Bundle bundle) {
        this.I = true;
    }

    public final AbstractC0081k g() {
        if (this.v == null) {
            y();
            int i = this.c;
            if (i >= 4) {
                this.v.l();
            } else if (i >= 3) {
                this.v.m();
            } else if (i >= 2) {
                this.v.f();
            } else if (i >= 1) {
                this.v.g();
            }
        }
        return this.v;
    }

    @Override // androidx.lifecycle.h
    public androidx.lifecycle.f getLifecycle() {
        return this.U;
    }

    @Override // androidx.lifecycle.u
    public androidx.lifecycle.t getViewModelStore() {
        if (h() != null) {
            if (this.x == null) {
                this.x = new androidx.lifecycle.t();
            }
            return this.x;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public Context h() {
        AbstractC0080j abstractC0080j = this.u;
        if (abstractC0080j == null) {
            return null;
        }
        return abstractC0080j.c();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater i(Bundle bundle) {
        this.S = d(bundle);
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Bundle bundle) {
        Parcelable v;
        e(bundle);
        r rVar = this.v;
        if (rVar == null || (v = rVar.v()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        if (this.v == null) {
            y();
        }
        this.v.a(parcelable, this.w);
        this.w = null;
        this.v.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.e;
        if (sparseArray != null) {
            this.L.restoreHierarchyState(sparseArray);
            this.e = null;
        }
        this.I = false;
        f(bundle);
        if (this.I) {
            if (this.K != null) {
                this.V.b(f.a.ON_CREATE);
                return;
            }
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void m(Bundle bundle) {
        if (this.g >= 0 && D()) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }
        this.i = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.e;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.I = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.f;
    }

    public Object q() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.j;
        return obj == f603b ? k() : obj;
    }

    public final Resources r() {
        return W().getResources();
    }

    public Object s() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.h;
        return obj == f603b ? i() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(c cVar) {
        Y();
        c cVar2 = this.O.r;
        if (cVar == cVar2) {
            return;
        }
        if (cVar != null && cVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        a aVar = this.O;
        if (aVar.q) {
            aVar.r = cVar;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    public Object t() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) CpioConstants.C_IWUSR);
        androidx.core.g.a.a(this, sb);
        if (this.g >= 0) {
            sb.append(" #");
            sb.append(this.g);
        }
        if (this.z != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.z));
        }
        if (this.B != null) {
            sb.append(" ");
            sb.append(this.B);
        }
        sb.append('}');
        return sb.toString();
    }

    public Object u() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.l;
        return obj == f603b ? t() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.c;
    }

    public View w() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        this.g = -1;
        this.h = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = 0;
        this.t = null;
        this.v = null;
        this.u = null;
        this.z = 0;
        this.A = 0;
        this.B = null;
        this.C = false;
        this.D = false;
        this.F = false;
    }

    void y() {
        if (this.u != null) {
            this.v = new r();
            this.v.a(this.u, new C0074d(this), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    public final boolean z() {
        return this.D;
    }

    public void b(Bundle bundle) {
        this.I = true;
    }

    public boolean d() {
        Boolean bool;
        a aVar = this.O;
        if (aVar == null || (bool = aVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator f() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.f606b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        r rVar = this.v;
        if (rVar != null) {
            rVar.s();
        }
        this.c = 1;
        this.I = false;
        c(bundle);
        this.T = true;
        if (this.I) {
            this.U.b(f.a.ON_CREATE);
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        r rVar = this.v;
        if (rVar != null) {
            rVar.s();
        }
        this.r = true;
        this.W = new C0075e(this);
        this.V = null;
        this.K = a(layoutInflater, viewGroup, bundle);
        if (this.K != null) {
            this.W.getLifecycle();
            this.X.a((androidx.lifecycle.o<androidx.lifecycle.h>) this.W);
        } else if (this.V == null) {
            this.W = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z) {
        b(z);
        r rVar = this.v;
        if (rVar != null) {
            rVar.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.f605a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z) {
        Y().s = z;
    }

    public Object i() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.g;
    }

    public final AbstractC0081k m() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.g j() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.o;
    }

    public boolean c() {
        Boolean bool;
        a aVar = this.O;
        if (aVar == null || (bool = aVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Menu menu) {
        boolean z = false;
        if (this.C) {
            return false;
        }
        if (this.G && this.H) {
            b(menu);
            z = true;
        }
        r rVar = this.v;
        return rVar != null ? z | rVar.b(menu) : z;
    }

    public Object k() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(MenuItem menuItem) {
        if (this.C) {
            return false;
        }
        if (a(menuItem)) {
            return true;
        }
        r rVar = this.v;
        return rVar != null && rVar.a(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        r rVar = this.v;
        if (rVar != null) {
            rVar.s();
        }
        this.c = 2;
        this.I = false;
        b(bundle);
        if (this.I) {
            r rVar2 = this.v;
            if (rVar2 != null) {
                rVar2.f();
                return;
            }
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.g l() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        try {
            Class<?> cls = f602a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f602a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Menu menu) {
        if (this.C) {
            return;
        }
        if (this.G && this.H) {
            a(menu);
        }
        r rVar = this.v;
        if (rVar != null) {
            rVar.a(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(MenuItem menuItem) {
        if (this.C) {
            return false;
        }
        if (this.G && this.H && b(menuItem)) {
            return true;
        }
        r rVar = this.v;
        return rVar != null && rVar.b(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.C) {
            return false;
        }
        if (this.G && this.H) {
            a(menu, menuInflater);
            z = true;
        }
        r rVar = this.v;
        return rVar != null ? z | rVar.a(menu, menuInflater) : z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, Fragment fragment) {
        this.g = i;
        if (fragment != null) {
            this.h = fragment.h + ":" + this.g;
            return;
        }
        this.h = "android:fragment:" + this.g;
    }

    @Deprecated
    public LayoutInflater a(Bundle bundle) {
        AbstractC0080j abstractC0080j = this.u;
        if (abstractC0080j != null) {
            LayoutInflater f = abstractC0080j.f();
            g();
            androidx.core.h.e.a(f, this.v.q());
            return f;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        Y().c = i;
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.I = true;
        AbstractC0080j abstractC0080j = this.u;
        Activity b2 = abstractC0080j == null ? null : abstractC0080j.b();
        if (b2 != null) {
            this.I = false;
            a(b2, attributeSet, bundle);
        }
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.I = true;
    }

    public void a(Context context) {
        this.I = true;
        AbstractC0080j abstractC0080j = this.u;
        Activity b2 = abstractC0080j == null ? null : abstractC0080j.b();
        if (b2 != null) {
            this.I = false;
            a(b2);
        }
    }

    @Deprecated
    public void a(Activity activity) {
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        a aVar = this.O;
        c cVar = null;
        if (aVar != null) {
            aVar.q = false;
            c cVar2 = aVar.r;
            aVar.r = null;
            cVar = cVar2;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mTag=");
        printWriter.println(this.B);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.c);
        printWriter.print(" mIndex=");
        printWriter.print(this.g);
        printWriter.print(" mWho=");
        printWriter.print(this.h);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.m);
        printWriter.print(" mRemoving=");
        printWriter.print(this.n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.C);
        printWriter.print(" mDetached=");
        printWriter.print(this.D);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.H);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.G);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.E);
        printWriter.print(" mRetaining=");
        printWriter.print(this.F);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.N);
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.t);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.u);
        }
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.y);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.i);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.d);
        }
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.e);
        }
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.j);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.l);
        }
        if (n() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(n());
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.K);
        }
        if (this.L != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.K);
        }
        if (e() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(e());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(v());
        }
        if (h() != null) {
            androidx.loader.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.v + ":");
            r rVar = this.v;
            rVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(String str) {
        if (str.equals(this.h)) {
            return this;
        }
        r rVar = this.v;
        if (rVar != null) {
            return rVar.b(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        r rVar = this.v;
        if (rVar != null) {
            rVar.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.O == null && i == 0) {
            return;
        }
        Y().d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (this.O == null && i == 0 && i2 == 0) {
            return;
        }
        Y();
        a aVar = this.O;
        aVar.e = i;
        aVar.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        Y().f605a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Animator animator) {
        Y().f606b = animator;
    }
}
