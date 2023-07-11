package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.fragment.app.AbstractC0081k;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public final class r extends AbstractC0081k implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    static boolean f645a = false;

    /* renamed from: b  reason: collision with root package name */
    static Field f646b;
    static final Interpolator c = new DecelerateInterpolator(2.5f);
    static final Interpolator d = new DecelerateInterpolator(1.5f);
    static final Interpolator e = new AccelerateInterpolator(2.5f);
    static final Interpolator f = new AccelerateInterpolator(1.5f);
    String A;
    boolean B;
    ArrayList<C0071a> C;
    ArrayList<Boolean> D;
    ArrayList<Fragment> E;
    ArrayList<i> H;
    s I;
    ArrayList<h> g;
    boolean h;
    SparseArray<Fragment> k;
    ArrayList<C0071a> l;
    ArrayList<Fragment> m;
    ArrayList<C0071a> n;
    ArrayList<Integer> o;
    ArrayList<AbstractC0081k.c> p;
    AbstractC0080j s;
    AbstractC0078h t;
    Fragment u;
    Fragment v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;
    int i = 0;
    final ArrayList<Fragment> j = new ArrayList<>();
    private final CopyOnWriteArrayList<f> q = new CopyOnWriteArrayList<>();
    int r = 0;
    Bundle F = null;
    SparseArray<Parcelable> G = null;
    Runnable J = new RunnableC0082l(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: b  reason: collision with root package name */
        View f647b;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f647b = view;
        }

        @Override // androidx.fragment.app.r.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (!androidx.core.h.t.y(this.f647b) && Build.VERSION.SDK_INT < 24) {
                this.f647b.setLayerType(0, null);
            } else {
                this.f647b.post(new q(this));
            }
            super.onAnimationEnd(animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final Animation.AnimationListener f648a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Animation.AnimationListener animationListener) {
            this.f648a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f648a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f648a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f648a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        View f651a;

        d(View view) {
            this.f651a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f651a.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f651a.setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        final AbstractC0081k.b f654a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f655b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f656a = {16842755, 16842960, 16842961};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public interface h {
        boolean a(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class i implements Fragment.c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f657a;

        /* renamed from: b  reason: collision with root package name */
        final C0071a f658b;
        private int c;

        i(C0071a c0071a, boolean z) {
            this.f657a = z;
            this.f658b = c0071a;
        }

        @Override // androidx.fragment.app.Fragment.c
        public void a() {
            this.c++;
        }

        @Override // androidx.fragment.app.Fragment.c
        public void b() {
            this.c--;
            if (this.c != 0) {
                return;
            }
            this.f658b.f626a.x();
        }

        public void c() {
            C0071a c0071a = this.f658b;
            c0071a.f626a.a(c0071a, this.f657a, false, false);
        }

        public void d() {
            boolean z = this.c > 0;
            r rVar = this.f658b.f626a;
            int size = rVar.j.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = rVar.j.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.C()) {
                    fragment.X();
                }
            }
            C0071a c0071a = this.f658b;
            c0071a.f626a.a(c0071a, this.f657a, !z, true);
        }

        public boolean e() {
            return this.c == 0;
        }
    }

    private void A() {
        if (!d()) {
            if (this.A == null) {
                return;
            }
            throw new IllegalStateException("Can not perform this action inside of " + this.A);
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void B() {
        this.h = false;
        this.D.clear();
        this.C.clear();
    }

    private void C() {
        SparseArray<Fragment> sparseArray = this.k;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment valueAt = this.k.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.e() != null) {
                    int v = valueAt.v();
                    View e2 = valueAt.e();
                    Animation animation = e2.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        e2.clearAnimation();
                    }
                    valueAt.a((View) null);
                    a(valueAt, v, 0, 0, false);
                } else if (valueAt.f() != null) {
                    valueAt.f().end();
                }
            }
        }
    }

    private void D() {
        if (this.H != null) {
            while (!this.H.isEmpty()) {
                this.H.remove(0).d();
            }
        }
    }

    static boolean a(c cVar) {
        Animation animation = cVar.f649a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i2 = 0; i2 < animations.size(); i2++) {
                if (animations.get(i2) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return a(cVar.f650b);
    }

    public static int b(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? 1 : 2;
        } else if (i2 == 4099) {
            return z ? 5 : 6;
        } else if (i2 != 8194) {
            return -1;
        } else {
            return z ? 3 : 4;
        }
    }

    public static int d(int i2) {
        if (i2 != 4097) {
            if (i2 != 4099) {
                return i2 != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    private void z() {
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.k.valueAt(size) == null) {
                    SparseArray<Fragment> sparseArray2 = this.k;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public void addOnBackStackChangedListener(AbstractC0081k.c cVar) {
        if (this.p == null) {
            this.p = new ArrayList<>();
        }
        this.p.add(cVar);
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public boolean b() {
        boolean p = p();
        D();
        return p;
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public List<Fragment> c() {
        List<Fragment> list;
        if (this.j.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.j) {
            list = (List) this.j.clone();
        }
        return list;
    }

    void d(Fragment fragment) {
        if (!fragment.o || fragment.r) {
            return;
        }
        fragment.b(fragment.i(fragment.d), (ViewGroup) null, fragment.d);
        View view = fragment.K;
        if (view != null) {
            fragment.L = view;
            view.setSaveFromParentEnabled(false);
            if (fragment.C) {
                fragment.K.setVisibility(8);
            }
            fragment.a(fragment.K, fragment.d);
            a(fragment, fragment.K, fragment.d, false);
            return;
        }
        fragment.L = null;
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public boolean e() {
        A();
        return a((String) null, -1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (fragment.g >= 0) {
            return;
        }
        int i2 = this.i;
        this.i = i2 + 1;
        fragment.a(i2, this.u);
        if (this.k == null) {
            this.k = new SparseArray<>();
        }
        this.k.put(fragment.g, fragment);
        if (f645a) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    void g(Fragment fragment) {
        if (fragment.g < 0) {
            return;
        }
        if (f645a) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.k.put(fragment.g, null);
        fragment.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        int i2 = this.r;
        if (fragment.n) {
            if (fragment.B()) {
                i2 = Math.min(i2, 1);
            } else {
                i2 = Math.min(i2, 0);
            }
        }
        a(fragment, i2, fragment.o(), fragment.p(), false);
        if (fragment.K != null) {
            Fragment p = p(fragment);
            if (p != null) {
                View view = p.K;
                ViewGroup viewGroup = fragment.J;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.K);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.K, indexOfChild);
                }
            }
            if (fragment.P && fragment.J != null) {
                float f2 = fragment.R;
                if (f2 > 0.0f) {
                    fragment.K.setAlpha(f2);
                }
                fragment.R = 0.0f;
                fragment.P = false;
                c a2 = a(fragment, fragment.o(), true, fragment.p());
                if (a2 != null) {
                    b(fragment.K, a2);
                    Animation animation = a2.f649a;
                    if (animation != null) {
                        fragment.K.startAnimation(animation);
                    } else {
                        a2.f650b.setTarget(fragment.K);
                        a2.f650b.start();
                    }
                }
            }
        }
        if (fragment.Q) {
            b(fragment);
        }
    }

    void i(Fragment fragment) {
        a(fragment, this.r, 0, 0, false);
    }

    public void j(Fragment fragment) {
        if (fragment.M) {
            if (this.h) {
                this.B = true;
                return;
            }
            fragment.M = false;
            a(fragment, this.r, 0, 0, false);
        }
    }

    public void k(Fragment fragment) {
        if (f645a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.s);
        }
        boolean z = !fragment.B();
        if (!fragment.D || z) {
            synchronized (this.j) {
                this.j.remove(fragment);
            }
            if (fragment.G && fragment.H) {
                this.w = true;
            }
            fragment.m = false;
            fragment.n = true;
        }
    }

    Bundle l(Fragment fragment) {
        Bundle bundle;
        if (this.F == null) {
            this.F = new Bundle();
        }
        fragment.j(this.F);
        d(fragment, this.F, false);
        if (this.F.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.F;
            this.F = null;
        }
        if (fragment.K != null) {
            m(fragment);
        }
        if (fragment.e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.e);
        }
        if (!fragment.N) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.N);
        }
        return bundle;
    }

    void m(Fragment fragment) {
        if (fragment.L == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.G;
        if (sparseArray == null) {
            this.G = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.L.saveHierarchyState(this.G);
        if (this.G.size() > 0) {
            fragment.e = this.G;
            this.G = null;
        }
    }

    public void n() {
        this.y = true;
        e(2);
    }

    public void o(Fragment fragment) {
        if (f645a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.C) {
            fragment.C = false;
            fragment.Q = !fragment.Q;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f656a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.a(this.s.c(), str2)) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                }
                Fragment a2 = resourceId != -1 ? a(resourceId) : null;
                if (a2 == null && string != null) {
                    a2 = a(string);
                }
                if (a2 == null && id != -1) {
                    a2 = a(id);
                }
                if (f645a) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + a2);
                }
                if (a2 == null) {
                    Fragment a3 = this.t.a(context, str2, null);
                    a3.o = true;
                    a3.z = resourceId != 0 ? resourceId : id;
                    a3.A = id;
                    a3.B = string;
                    a3.p = true;
                    a3.t = this;
                    AbstractC0080j abstractC0080j = this.s;
                    a3.u = abstractC0080j;
                    a3.a(abstractC0080j.c(), attributeSet, a3.d);
                    a(a3, true);
                    fragment = a3;
                } else if (!a2.p) {
                    a2.p = true;
                    AbstractC0080j abstractC0080j2 = this.s;
                    a2.u = abstractC0080j2;
                    if (!a2.F) {
                        a2.a(abstractC0080j2.c(), attributeSet, a2.d);
                    }
                    fragment = a2;
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                }
                if (this.r < 1 && fragment.o) {
                    a(fragment, 1, 0, 0, false);
                } else {
                    i(fragment);
                }
                View view2 = fragment.K;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.K.getTag() == null) {
                        fragment.K.setTag(string);
                    }
                    return fragment.K;
                }
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            return null;
        }
        return null;
    }

    public boolean p() {
        c(true);
        boolean z = false;
        while (b(this.C, this.D)) {
            this.h = true;
            try {
                c(this.C, this.D);
                B();
                z = true;
            } catch (Throwable th) {
                B();
                throw th;
            }
        }
        o();
        z();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 q() {
        return this;
    }

    public Fragment r() {
        return this.v;
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public void removeOnBackStackChangedListener(AbstractC0081k.c cVar) {
        ArrayList<AbstractC0081k.c> arrayList = this.p;
        if (arrayList != null) {
            arrayList.remove(cVar);
        }
    }

    public void s() {
        this.I = null;
        this.x = false;
        this.y = false;
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.E();
            }
        }
    }

    void t() {
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                this.p.get(i2).onBackStackChanged();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) CpioConstants.C_IWUSR);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.u;
        if (fragment != null) {
            androidx.core.g.a.a(fragment, sb);
        } else {
            androidx.core.g.a.a(this.s, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s u() {
        a(this.I);
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable v() {
        int[] iArr;
        int size;
        D();
        C();
        p();
        this.x = true;
        BackStackState[] backStackStateArr = null;
        this.I = null;
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.k.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        boolean z = false;
        for (int i2 = 0; i2 < size2; i2++) {
            Fragment valueAt = this.k.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.g >= 0) {
                    FragmentState fragmentState = new FragmentState(valueAt);
                    fragmentStateArr[i2] = fragmentState;
                    if (valueAt.c > 0 && fragmentState.k == null) {
                        fragmentState.k = l(valueAt);
                        Fragment fragment = valueAt.j;
                        if (fragment != null) {
                            if (fragment.g >= 0) {
                                if (fragmentState.k == null) {
                                    fragmentState.k = new Bundle();
                                }
                                a(fragmentState.k, "android:target_state", valueAt.j);
                                int i3 = valueAt.l;
                                if (i3 != 0) {
                                    fragmentState.k.putInt("android:target_req_state", i3);
                                }
                            } else {
                                a(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.j));
                                throw null;
                            }
                        }
                    } else {
                        fragmentState.k = valueAt.d;
                    }
                    if (f645a) {
                        Log.v("FragmentManager", "Saved state of " + valueAt + ": " + fragmentState.k);
                    }
                    z = true;
                } else {
                    a(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.g));
                    throw null;
                }
            }
        }
        if (!z) {
            if (f645a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.j.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i4 = 0; i4 < size3; i4++) {
                iArr[i4] = this.j.get(i4).g;
                if (iArr[i4] >= 0) {
                    if (f645a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i4 + ": " + this.j.get(i4));
                    }
                } else {
                    a(new IllegalStateException("Failure saving state: active " + this.j.get(i4) + " has cleared index: " + iArr[i4]));
                    throw null;
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<C0071a> arrayList = this.l;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i5 = 0; i5 < size; i5++) {
                backStackStateArr[i5] = new BackStackState(this.l.get(i5));
                if (f645a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.l.get(i5));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f609a = fragmentStateArr;
        fragmentManagerState.f610b = iArr;
        fragmentManagerState.c = backStackStateArr;
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            fragmentManagerState.d = fragment2.g;
        }
        fragmentManagerState.e = this.i;
        w();
        return fragmentManagerState;
    }

    void w() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        s sVar;
        if (this.k != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                Fragment valueAt = this.k.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.E) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAt);
                        Fragment fragment = valueAt.j;
                        valueAt.k = fragment != null ? fragment.g : -1;
                        if (f645a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    r rVar = valueAt.v;
                    if (rVar != null) {
                        rVar.w();
                        sVar = valueAt.v.I;
                    } else {
                        sVar = valueAt.w;
                    }
                    if (arrayList2 == null && sVar != null) {
                        arrayList2 = new ArrayList(this.k.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(sVar);
                    }
                    if (arrayList3 == null && valueAt.x != null) {
                        arrayList3 = new ArrayList(this.k.size());
                        for (int i4 = 0; i4 < i2; i4++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(valueAt.x);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.I = null;
        } else {
            this.I = new s(arrayList, arrayList2, arrayList3);
        }
    }

    void x() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.H == null || this.H.isEmpty()) ? false : true;
            if (this.g != null && this.g.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.s.e().removeCallbacks(this.J);
                this.s.e().post(this.J);
            }
        }
    }

    void y() {
        if (this.k == null) {
            return;
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            Fragment valueAt = this.k.valueAt(i2);
            if (valueAt != null) {
                j(valueAt);
            }
        }
    }

    public void i() {
        e(1);
    }

    private static void b(View view, c cVar) {
        if (view == null || cVar == null || !a(view, cVar)) {
            return;
        }
        Animator animator = cVar.f650b;
        if (animator != null) {
            animator.addListener(new d(view));
            return;
        }
        Animation.AnimationListener a2 = a(cVar.f649a);
        view.setLayerType(2, null);
        cVar.f649a.setAnimationListener(new a(view, a2));
    }

    public void e(Fragment fragment) {
        if (f645a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.C) {
            return;
        }
        fragment.C = true;
        fragment.Q = true ^ fragment.Q;
    }

    public void n(Fragment fragment) {
        if (fragment != null && (this.k.get(fragment.g) != fragment || (fragment.u != null && fragment.m() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        this.v = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f649a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f650b;

        c(Animation animation) {
            this.f649a = animation;
            this.f650b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        c(Animator animator) {
            this.f649a = null;
            this.f650b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public void g() {
        this.x = false;
        this.y = false;
        e(1);
    }

    void o() {
        if (this.B) {
            this.B = false;
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class e extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f652a;

        /* renamed from: b  reason: collision with root package name */
        private final View f653b;
        private boolean c;
        private boolean d;
        private boolean mEnded;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.d = true;
            this.f652a = viewGroup;
            this.f653b = view;
            addAnimation(animation);
            this.f652a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.d = true;
            if (this.mEnded) {
                return !this.c;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                L.a(this.f652a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mEnded && this.d) {
                this.d = false;
                this.f652a.post(this);
                return;
            }
            this.f652a.endViewTransition(this.f653b);
            this.c = true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.d = true;
            if (this.mEnded) {
                return !this.c;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                L.a(this.f652a, this);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i2) {
        return this.r >= i2;
    }

    public void j() {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.R();
            }
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (a(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void e(int i2) {
        try {
            this.h = true;
            a(i2, false);
            this.h = false;
            p();
        } catch (Throwable th) {
            this.h = false;
            throw th;
        }
    }

    public void c(Fragment fragment) {
        if (f645a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.D) {
            return;
        }
        fragment.D = true;
        if (fragment.m) {
            if (f645a) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.j) {
                this.j.remove(fragment);
            }
            if (fragment.G && fragment.H) {
                this.w = true;
            }
            fragment.m = false;
        }
    }

    public void f() {
        this.x = false;
        this.y = false;
        e(2);
    }

    private Fragment p(Fragment fragment) {
        ViewGroup viewGroup = fragment.J;
        View view = fragment.K;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.j.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.j.get(indexOf);
                if (fragment2.J == viewGroup && fragment2.K != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    void g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).g(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.f(this, fragment);
            }
        }
    }

    void b(Fragment fragment) {
        Animator animator;
        if (fragment.K != null) {
            c a2 = a(fragment, fragment.o(), !fragment.C, fragment.p());
            if (a2 != null && (animator = a2.f650b) != null) {
                animator.setTarget(fragment.K);
                if (fragment.C) {
                    if (fragment.A()) {
                        fragment.f(false);
                    } else {
                        ViewGroup viewGroup = fragment.J;
                        View view = fragment.K;
                        viewGroup.startViewTransition(view);
                        a2.f650b.addListener(new p(this, viewGroup, view, fragment));
                    }
                } else {
                    fragment.K.setVisibility(0);
                }
                b(fragment.K, a2);
                a2.f650b.start();
            } else {
                if (a2 != null) {
                    b(fragment.K, a2);
                    fragment.K.startAnimation(a2.f649a);
                    a2.f649a.start();
                }
                fragment.K.setVisibility((!fragment.C || fragment.A()) ? 0 : 8);
                if (fragment.A()) {
                    fragment.f(false);
                }
            }
        }
        if (fragment.m && fragment.G && fragment.H) {
            this.w = true;
        }
        fragment.Q = false;
        fragment.a(fragment.C);
    }

    public void m() {
        this.x = false;
        this.y = false;
        e(3);
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public boolean d() {
        return this.x || this.y;
    }

    void f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).f(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.e(this, fragment);
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).d(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.c(this, fragment);
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).e(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.d(this, fragment);
            }
        }
    }

    public void k() {
        e(3);
    }

    static boolean a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && androidx.core.h.t.w(view) && a(cVar);
    }

    public void l() {
        this.x = false;
        this.y = false;
        e(4);
    }

    private void c(boolean z) {
        if (!this.h) {
            if (this.s != null) {
                if (Looper.myLooper() == this.s.e().getLooper()) {
                    if (!z) {
                        A();
                    }
                    if (this.C == null) {
                        this.C = new ArrayList<>();
                        this.D = new ArrayList<>();
                    }
                    this.h = true;
                    try {
                        a((ArrayList<C0071a>) null, (ArrayList<Boolean>) null);
                        return;
                    } finally {
                        this.h = false;
                    }
                }
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).d(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.d(this, fragment, bundle);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
        AbstractC0080j abstractC0080j = this.s;
        if (abstractC0080j != null) {
            try {
                abstractC0080j.a("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public w a() {
        return new C0071a(this);
    }

    public void h() {
        this.z = true;
        p();
        e(0);
        this.s = null;
        this.t = null;
        this.u = null;
    }

    private boolean a(String str, int i2, int i3) {
        AbstractC0081k N;
        p();
        c(true);
        Fragment fragment = this.v;
        if (fragment == null || i2 >= 0 || str != null || (N = fragment.N()) == null || !N.e()) {
            boolean a2 = a(this.C, this.D, str, i2, i3);
            if (a2) {
                this.h = true;
                try {
                    c(this.C, this.D);
                } finally {
                    B();
                }
            }
            o();
            z();
            return a2;
        }
        return true;
    }

    private void c(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 != null && arrayList.size() == arrayList2.size()) {
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).t) {
                    if (i3 != i2) {
                        b(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).t) {
                            i3++;
                        }
                    }
                    b(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                b(arrayList, arrayList2, i3, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public Fragment b(String str) {
        Fragment a2;
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            Fragment valueAt = this.k.valueAt(size);
            if (valueAt != null && (a2 = valueAt.a(str)) != null) {
                return a2;
            }
        }
        return null;
    }

    void h(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).h(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.g(this, fragment);
            }
        }
    }

    public int b(C0071a c0071a) {
        synchronized (this) {
            if (this.o != null && this.o.size() > 0) {
                int intValue = this.o.remove(this.o.size() - 1).intValue();
                if (f645a) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + c0071a);
                }
                this.n.set(intValue, c0071a);
                return intValue;
            }
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (f645a) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0071a);
            }
            this.n.add(c0071a);
            return size;
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        int i2 = fragment.g;
        if (i2 >= 0) {
            bundle.putInt(str, i2);
            return;
        }
        a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).c(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.c(this, fragment, bundle);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public Fragment a(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        Fragment fragment = this.k.get(i2);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        throw null;
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment valueAt = this.k.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.j.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.j.get(i3).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.m;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.m.get(i4).toString());
            }
        }
        ArrayList<C0071a> arrayList2 = this.l;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                C0071a c0071a = this.l.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(c0071a.toString());
                c0071a.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.n != null && (size2 = this.n.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println((C0071a) this.n.get(i6));
                }
            }
            if (this.o != null && this.o.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.o.toArray()));
            }
        }
        ArrayList<h> arrayList3 = this.g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println((h) this.g.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.t);
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.u);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.r);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.x);
        printWriter.print(" mStopped=");
        printWriter.print(this.y);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.z);
        if (this.w) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.w);
        }
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.A);
        }
    }

    void c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).c(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.b(this, fragment);
            }
        }
    }

    public void b(int i2) {
        synchronized (this) {
            this.n.set(i2, null);
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            if (f645a) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.o.add(Integer.valueOf(i2));
        }
    }

    private void b(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2;
        boolean z = arrayList.get(i6).t;
        ArrayList<Fragment> arrayList3 = this.E;
        if (arrayList3 == null) {
            this.E = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.E.addAll(this.j);
        Fragment r = r();
        boolean z2 = false;
        for (int i7 = i6; i7 < i3; i7++) {
            C0071a c0071a = arrayList.get(i7);
            if (!arrayList2.get(i7).booleanValue()) {
                r = c0071a.a(this.E, r);
            } else {
                r = c0071a.b(this.E, r);
            }
            z2 = z2 || c0071a.i;
        }
        this.E.clear();
        if (!z) {
            B.a(this, arrayList, arrayList2, i2, i3, false);
        }
        a(arrayList, arrayList2, i2, i3);
        if (z) {
            a.b.d<Fragment> dVar = new a.b.d<>();
            a(dVar);
            int a2 = a(arrayList, arrayList2, i2, i3, dVar);
            b(dVar);
            i4 = a2;
        } else {
            i4 = i3;
        }
        if (i4 != i6 && z) {
            B.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.r, true);
        }
        while (i6 < i3) {
            C0071a c0071a2 = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue() && (i5 = c0071a2.m) >= 0) {
                b(i5);
                c0071a2.m = -1;
            }
            c0071a2.e();
            i6++;
        }
        if (z2) {
            t();
        }
    }

    private void b(a.b.d<Fragment> dVar) {
        int size = dVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment c2 = dVar.c(i2);
            if (!c2.m) {
                View w = c2.w();
                c2.R = w.getAlpha();
                w.setAlpha(0.0f);
            }
        }
    }

    private boolean b(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.g != null && this.g.size() != 0) {
                int size = this.g.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z |= this.g.get(i2).a(arrayList, arrayList2);
                }
                this.g.clear();
                this.s.e().removeCallbacks(this.J);
                return z;
            }
            return false;
        }
    }

    public void b(boolean z) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.e(z);
            }
        }
    }

    public boolean b(Menu menu) {
        if (this.r < 1) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.d(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(c);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(d);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    void b(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).b(fragment, context, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.b(this, fragment, context);
            }
        }
    }

    void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).b(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.b(this, fragment, bundle);
            }
        }
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(d);
        alphaAnimation.setDuration(220L);
        return new c(alphaAnimation);
    }

    c a(Fragment fragment, int i2, boolean z, int i3) {
        int b2;
        int n = fragment.n();
        Animation a2 = fragment.a(i2, z, n);
        if (a2 != null) {
            return new c(a2);
        }
        Animator b3 = fragment.b(i2, z, n);
        if (b3 != null) {
            return new c(b3);
        }
        if (n != 0) {
            boolean equals = "anim".equals(this.s.c().getResources().getResourceTypeName(n));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.s.c(), n);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.s.c(), n);
                    if (loadAnimator != null) {
                        return new c(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.s.c(), n);
                        if (loadAnimation2 != null) {
                            return new c(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 != 0 && (b2 = b(i2, z)) >= 0) {
            switch (b2) {
                case 1:
                    return a(this.s.c(), 1.125f, 1.0f, 0.0f, 1.0f);
                case 2:
                    return a(this.s.c(), 1.0f, 0.975f, 1.0f, 0.0f);
                case 3:
                    return a(this.s.c(), 0.975f, 1.0f, 0.0f, 1.0f);
                case 4:
                    return a(this.s.c(), 1.0f, 1.075f, 1.0f, 0.0f);
                case 5:
                    return a(this.s.c(), 0.0f, 1.0f);
                case 6:
                    return a(this.s.c(), 1.0f, 0.0f);
                default:
                    if (i3 == 0 && this.s.h()) {
                        i3 = this.s.g();
                    }
                    if (i3 == 0) {
                    }
                    return null;
            }
        }
        return null;
    }

    void b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).b(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.a(this, fragment);
            }
        }
    }

    private static Animation.AnimationListener a(Animation animation) {
        try {
            if (f646b == null) {
                f646b = Animation.class.getDeclaredField("mListener");
                f646b.setAccessible(true);
            }
            return (Animation.AnimationListener) f646b.get(animation);
        } catch (IllegalAccessException e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0072, code lost:
        if (r0 != 3) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.fragment.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1101
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r.a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    private void a(Fragment fragment, c cVar, int i2) {
        View view = fragment.K;
        ViewGroup viewGroup = fragment.J;
        viewGroup.startViewTransition(view);
        fragment.b(i2);
        Animation animation = cVar.f649a;
        if (animation != null) {
            e eVar = new e(animation, viewGroup, view);
            fragment.a(fragment.K);
            eVar.setAnimationListener(new n(this, a(eVar), viewGroup, fragment));
            b(view, cVar);
            fragment.K.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.f650b;
        fragment.a(animator);
        animator.addListener(new o(this, viewGroup, view, fragment));
        animator.setTarget(fragment.K);
        b(fragment.K, cVar);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2, boolean z) {
        AbstractC0080j abstractC0080j;
        if (this.s == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.r) {
            this.r = i2;
            if (this.k != null) {
                int size = this.j.size();
                for (int i3 = 0; i3 < size; i3++) {
                    h(this.j.get(i3));
                }
                int size2 = this.k.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Fragment valueAt = this.k.valueAt(i4);
                    if (valueAt != null && ((valueAt.n || valueAt.D) && !valueAt.P)) {
                        h(valueAt);
                    }
                }
                y();
                if (this.w && (abstractC0080j = this.s) != null && this.r == 4) {
                    abstractC0080j.i();
                    this.w = false;
                }
            }
        }
    }

    public void a(Fragment fragment, boolean z) {
        if (f645a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        f(fragment);
        if (fragment.D) {
            return;
        }
        if (!this.j.contains(fragment)) {
            synchronized (this.j) {
                this.j.add(fragment);
            }
            fragment.m = true;
            fragment.n = false;
            if (fragment.K == null) {
                fragment.Q = false;
            }
            if (fragment.G && fragment.H) {
                this.w = true;
            }
            if (z) {
                i(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void a(Fragment fragment) {
        if (f645a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            if (fragment.m) {
                return;
            }
            if (!this.j.contains(fragment)) {
                if (f645a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.j) {
                    this.j.add(fragment);
                }
                fragment.m = true;
                if (fragment.G && fragment.H) {
                    this.w = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public Fragment a(int i2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null && fragment.z == i2) {
                return fragment;
            }
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null) {
            for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
                Fragment valueAt = this.k.valueAt(size2);
                if (valueAt != null && valueAt.z == i2) {
                    return valueAt;
                }
            }
            return null;
        }
        return null;
    }

    @Override // androidx.fragment.app.AbstractC0081k
    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                Fragment fragment = this.j.get(size);
                if (fragment != null && str.equals(fragment.B)) {
                    return fragment;
                }
            }
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment valueAt = this.k.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.B)) {
                return valueAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.fragment.app.r.h r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.A()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.z     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            androidx.fragment.app.j r0 = r1.s     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<androidx.fragment.app.r$h> r3 = r1.g     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.g = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<androidx.fragment.app.r$h> r3 = r1.g     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.x()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r.a(androidx.fragment.app.r$h, boolean):void");
    }

    public void a(int i2, C0071a c0071a) {
        synchronized (this) {
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (i2 < size) {
                if (f645a) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + c0071a);
                }
                this.n.set(i2, c0071a);
            } else {
                while (size < i2) {
                    this.n.add(null);
                    if (this.o == null) {
                        this.o = new ArrayList<>();
                    }
                    if (f645a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.o.add(Integer.valueOf(size));
                    size++;
                }
                if (f645a) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + c0071a);
                }
                this.n.add(c0071a);
            }
        }
    }

    private void a(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<i> arrayList3 = this.H;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            i iVar = this.H.get(i2);
            if (arrayList != null && !iVar.f657a && (indexOf2 = arrayList.indexOf(iVar.f658b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                iVar.c();
            } else if (iVar.e() || (arrayList != null && iVar.f658b.a(arrayList, 0, arrayList.size()))) {
                this.H.remove(i2);
                i2--;
                size--;
                if (arrayList != null && !iVar.f657a && (indexOf = arrayList.indexOf(iVar.f658b)) != -1 && arrayList2.get(indexOf).booleanValue()) {
                    iVar.c();
                } else {
                    iVar.d();
                }
            }
            i2++;
        }
    }

    private int a(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, a.b.d<Fragment> dVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            C0071a c0071a = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (c0071a.d() && !c0071a.a(arrayList, i5 + 1, i3)) {
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
                i iVar = new i(c0071a, booleanValue);
                this.H.add(iVar);
                c0071a.setOnStartPostponedListener(iVar);
                if (booleanValue) {
                    c0071a.b();
                } else {
                    c0071a.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, c0071a);
                }
                a(dVar);
            }
        }
        return i4;
    }

    void a(C0071a c0071a, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0071a.b(z3);
        } else {
            c0071a.b();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0071a);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            B.a(this, (ArrayList<C0071a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.r, true);
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment valueAt = this.k.valueAt(i2);
                if (valueAt != null && valueAt.K != null && valueAt.P && c0071a.b(valueAt.A)) {
                    float f2 = valueAt.R;
                    if (f2 > 0.0f) {
                        valueAt.K.setAlpha(f2);
                    }
                    if (z3) {
                        valueAt.R = 0.0f;
                    } else {
                        valueAt.R = -1.0f;
                        valueAt.P = false;
                    }
                }
            }
        }
    }

    private static void a(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            C0071a c0071a = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                c0071a.a(-1);
                c0071a.b(i2 == i3 + (-1));
            } else {
                c0071a.a(1);
                c0071a.b();
            }
            i2++;
        }
    }

    private void a(a.b.d<Fragment> dVar) {
        int i2 = this.r;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 3);
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.j.get(i3);
            if (fragment.c < min) {
                a(fragment, min, fragment.n(), fragment.o(), false);
                if (fragment.K != null && !fragment.C && fragment.P) {
                    dVar.add(fragment);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C0071a c0071a) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(c0071a);
    }

    boolean a(ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int size;
        ArrayList<C0071a> arrayList3 = this.l;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.l.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                size = this.l.size() - 1;
                while (size >= 0) {
                    C0071a c0071a = this.l.get(size);
                    if ((str != null && str.equals(c0071a.c())) || (i2 >= 0 && i2 == c0071a.m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        C0071a c0071a2 = this.l.get(size);
                        if (str == null || !str.equals(c0071a2.c())) {
                            if (i2 < 0 || i2 != c0071a2.m) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.l.size() - 1) {
                return false;
            }
            for (int size3 = this.l.size() - 1; size3 > size; size3--) {
                arrayList.add(this.l.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    private static void a(s sVar) {
        if (sVar == null) {
            return;
        }
        List<Fragment> b2 = sVar.b();
        if (b2 != null) {
            for (Fragment fragment : b2) {
                fragment.F = true;
            }
        }
        List<s> a2 = sVar.a();
        if (a2 != null) {
            for (s sVar2 : a2) {
                a(sVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, s sVar) {
        List<s> list;
        List<androidx.lifecycle.t> list2;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f609a == null) {
            return;
        }
        if (sVar != null) {
            List<Fragment> b2 = sVar.b();
            list = sVar.a();
            list2 = sVar.c();
            int size = b2 != null ? b2.size() : 0;
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = b2.get(i2);
                if (f645a) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                int i3 = 0;
                while (true) {
                    FragmentState[] fragmentStateArr = fragmentManagerState.f609a;
                    if (i3 >= fragmentStateArr.length || fragmentStateArr[i3].f612b == fragment.g) {
                        break;
                    }
                    i3++;
                }
                FragmentState[] fragmentStateArr2 = fragmentManagerState.f609a;
                if (i3 != fragmentStateArr2.length) {
                    FragmentState fragmentState = fragmentStateArr2[i3];
                    fragmentState.l = fragment;
                    fragment.e = null;
                    fragment.s = 0;
                    fragment.p = false;
                    fragment.m = false;
                    fragment.j = null;
                    Bundle bundle = fragmentState.k;
                    if (bundle != null) {
                        bundle.setClassLoader(this.s.c().getClassLoader());
                        fragment.e = fragmentState.k.getSparseParcelableArray("android:view_state");
                        fragment.d = fragmentState.k;
                    }
                } else {
                    a(new IllegalStateException("Could not find active fragment with index " + fragment.g));
                    throw null;
                }
            }
        } else {
            list = null;
            list2 = null;
        }
        this.k = new SparseArray<>(fragmentManagerState.f609a.length);
        int i4 = 0;
        while (true) {
            FragmentState[] fragmentStateArr3 = fragmentManagerState.f609a;
            if (i4 >= fragmentStateArr3.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr3[i4];
            if (fragmentState2 != null) {
                Fragment a2 = fragmentState2.a(this.s, this.t, this.u, (list == null || i4 >= list.size()) ? null : list.get(i4), (list2 == null || i4 >= list2.size()) ? null : list2.get(i4));
                if (f645a) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i4 + ": " + a2);
                }
                this.k.put(a2.g, a2);
                fragmentState2.l = null;
            }
            i4++;
        }
        if (sVar != null) {
            List<Fragment> b3 = sVar.b();
            int size2 = b3 != null ? b3.size() : 0;
            for (int i5 = 0; i5 < size2; i5++) {
                Fragment fragment2 = b3.get(i5);
                int i6 = fragment2.k;
                if (i6 >= 0) {
                    fragment2.j = this.k.get(i6);
                    if (fragment2.j == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.k);
                    }
                }
            }
        }
        this.j.clear();
        if (fragmentManagerState.f610b != null) {
            int i7 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.f610b;
                if (i7 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.k.get(iArr[i7]);
                if (fragment3 != null) {
                    fragment3.m = true;
                    if (f645a) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i7 + ": " + fragment3);
                    }
                    if (!this.j.contains(fragment3)) {
                        synchronized (this.j) {
                            this.j.add(fragment3);
                        }
                        i7++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f610b[i7]));
                    throw null;
                }
            }
        }
        BackStackState[] backStackStateArr = fragmentManagerState.c;
        if (backStackStateArr != null) {
            this.l = new ArrayList<>(backStackStateArr.length);
            int i8 = 0;
            while (true) {
                BackStackState[] backStackStateArr2 = fragmentManagerState.c;
                if (i8 >= backStackStateArr2.length) {
                    break;
                }
                C0071a a3 = backStackStateArr2[i8].a(this);
                if (f645a) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i8 + " (index " + a3.m + "): " + a3);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
                    a3.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.l.add(a3);
                int i9 = a3.m;
                if (i9 >= 0) {
                    a(i9, a3);
                }
                i8++;
            }
        } else {
            this.l = null;
        }
        int i10 = fragmentManagerState.d;
        if (i10 >= 0) {
            this.v = this.k.get(i10);
        }
        this.i = fragmentManagerState.e;
    }

    public void a(AbstractC0080j abstractC0080j, AbstractC0078h abstractC0078h, Fragment fragment) {
        if (this.s == null) {
            this.s = abstractC0080j;
            this.t = abstractC0078h;
            this.u = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void a(boolean z) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.d(z);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.a(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.r < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.m != null) {
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                Fragment fragment2 = this.m.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.G();
                }
            }
        }
        this.m = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.r < 1) {
            return;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.c(menu);
            }
        }
    }

    void a(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).a(fragment, context, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.a(this, fragment, context);
            }
        }
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).a(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.a(this, fragment, bundle);
            }
        }
    }

    void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            AbstractC0081k m = fragment2.m();
            if (m instanceof r) {
                ((r) m).a(fragment, view, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.f655b) {
                next.f654a.a(this, fragment, view, bundle);
            }
        }
    }
}
