package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f930a = {2, 1, 3, 4};

    /* renamed from: b  reason: collision with root package name */
    private static final PathMotion f931b = new X();
    private static ThreadLocal<a.b.b<Animator, a>> c = new ThreadLocal<>();
    AbstractC0108da G;
    private b H;
    private a.b.b<String, String> I;
    private ArrayList<ga> w;
    private ArrayList<ga> x;
    private String d = getClass().getName();
    private long e = -1;
    long f = -1;
    private TimeInterpolator g = null;
    ArrayList<Integer> h = new ArrayList<>();
    ArrayList<View> i = new ArrayList<>();
    private ArrayList<String> j = null;
    private ArrayList<Class> k = null;
    private ArrayList<Integer> l = null;
    private ArrayList<View> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<String> o = null;
    private ArrayList<Integer> p = null;
    private ArrayList<View> q = null;
    private ArrayList<Class> r = null;
    private ha s = new ha();
    private ha t = new ha();
    TransitionSet u = null;
    private int[] v = f930a;
    private ViewGroup y = null;
    boolean z = false;
    ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<c> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    private PathMotion J = f931b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        View f932a;

        /* renamed from: b  reason: collision with root package name */
        String f933b;
        ga c;
        Ea d;
        Transition e;

        a(View view, String str, Transition transition, Ea ea, ga gaVar) {
            this.f932a = view;
            this.f933b = str;
            this.c = gaVar;
            this.d = ea;
            this.e = transition;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract Rect a(Transition transition);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);
    }

    public Transition() {
    }

    private static boolean a(int i) {
        return i >= 1 && i <= 4;
    }

    private static int[] b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return iArr;
    }

    private void c(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.l;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.m;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.n;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.n.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ga gaVar = new ga();
                    gaVar.f960b = view;
                    if (z) {
                        c(gaVar);
                    } else {
                        a(gaVar);
                    }
                    gaVar.c.add(this);
                    b(gaVar);
                    if (z) {
                        a(this.s, view, gaVar);
                    } else {
                        a(this.t, view, gaVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.p;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.q;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.r;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.r.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                c(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private static a.b.b<Animator, a> q() {
        a.b.b<Animator, a> bVar = c.get();
        if (bVar == null) {
            a.b.b<Animator, a> bVar2 = new a.b.b<>();
            c.set(bVar2);
            return bVar2;
        }
        return bVar;
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        return null;
    }

    public Transition a(long j) {
        this.f = j;
        return this;
    }

    public abstract void a(ga gaVar);

    public abstract void c(ga gaVar);

    public Transition d(View view) {
        this.i.remove(view);
        return this;
    }

    public TimeInterpolator e() {
        return this.g;
    }

    public String f() {
        return this.d;
    }

    public PathMotion g() {
        return this.J;
    }

    public AbstractC0108da h() {
        return this.G;
    }

    public long i() {
        return this.e;
    }

    public List<Integer> j() {
        return this.h;
    }

    public List<String> k() {
        return this.j;
    }

    public List<Class> l() {
        return this.k;
    }

    public List<View> m() {
        return this.i;
    }

    public String[] n() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        p();
        a.b.b<Animator, a> q = q();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (q.containsKey(next)) {
                p();
                a(next, q);
            }
        }
        this.F.clear();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList2.get(i)).b(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public String toString() {
        return a("");
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.g = timeInterpolator;
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public Transition mo2clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.F = new ArrayList<>();
            transition.s = new ha();
            transition.t = new ha();
            transition.w = null;
            transition.x = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public b d() {
        return this.H;
    }

    public void e(View view) {
        if (this.C) {
            if (!this.D) {
                a.b.b<Animator, a> q = q();
                int size = q.size();
                Ea d = va.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    a d2 = q.d(i);
                    if (d2.f932a != null && d.equals(d2.d)) {
                        C0101a.b(q.b(i));
                    }
                }
                ArrayList<c> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((c) arrayList2.get(i2)).a(this);
                    }
                }
            }
            this.C = false;
        }
    }

    public void a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i = 0; i < iArr.length; i++) {
                if (a(iArr[i])) {
                    if (a(iArr, i)) {
                        throw new IllegalArgumentException("matches contains a duplicate value");
                    }
                } else {
                    throw new IllegalArgumentException("matches contains invalid value");
                }
            }
            this.v = (int[]) iArr.clone();
            return;
        }
        this.v = f930a;
    }

    private static boolean a(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2, a.b.f<View> fVar, a.b.f<View> fVar2) {
        View b2;
        int b3 = fVar.b();
        for (int i = 0; i < b3; i++) {
            View c2 = fVar.c(i);
            if (c2 != null && b(c2) && (b2 = fVar2.b(fVar.a(i))) != null && b(b2)) {
                ga gaVar = bVar.get(c2);
                ga gaVar2 = bVar2.get(b2);
                if (gaVar != null && gaVar2 != null) {
                    this.w.add(gaVar);
                    this.x.add(gaVar2);
                    bVar.remove(c2);
                    bVar2.remove(b2);
                }
            }
        }
    }

    public long b() {
        return this.f;
    }

    public Transition b(long j) {
        this.e = j;
        return this;
    }

    private void b(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2) {
        ga remove;
        View view;
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View b2 = bVar.b(size);
            if (b2 != null && b(b2) && (remove = bVar2.remove(b2)) != null && (view = remove.f960b) != null && b(view)) {
                this.w.add(bVar.c(size));
                this.x.add(remove);
            }
        }
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && b(view)) {
                ga gaVar = bVar.get(valueAt);
                ga gaVar2 = bVar2.get(view);
                if (gaVar != null && gaVar2 != null) {
                    this.w.add(gaVar);
                    this.x.add(gaVar2);
                    bVar.remove(valueAt);
                    bVar2.remove(view);
                }
            }
        }
    }

    public void c(View view) {
        if (this.D) {
            return;
        }
        a.b.b<Animator, a> q = q();
        int size = q.size();
        Ea d = va.d(view);
        for (int i = size - 1; i >= 0; i--) {
            a d2 = q.d(i);
            if (d2.f932a != null && d.equals(d2.d)) {
                C0101a.a(q.b(i));
            }
        }
        ArrayList<c> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.E.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((c) arrayList2.get(i2)).c(this);
            }
        }
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.l;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.m;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class> arrayList5 = this.n;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i = 0; i < size; i++) {
                        if (this.n.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.o == null || androidx.core.h.t.q(view) == null || !this.o.contains(androidx.core.h.t.q(view))) {
                    if ((this.h.size() == 0 && this.i.size() == 0 && (((arrayList = this.k) == null || arrayList.isEmpty()) && ((arrayList2 = this.j) == null || arrayList2.isEmpty()))) || this.h.contains(Integer.valueOf(id)) || this.i.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.j;
                    if (arrayList6 == null || !arrayList6.contains(androidx.core.h.t.q(view))) {
                        if (this.k != null) {
                            for (int i2 = 0; i2 < this.k.size(); i2++) {
                                if (this.k.get(i2).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long b2 = androidx.core.content.a.i.b(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (b2 >= 0) {
            a(b2);
        }
        long b3 = androidx.core.content.a.i.b(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (b3 > 0) {
            b(b3);
        }
        int c2 = androidx.core.content.a.i.c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c2 > 0) {
            a(AnimationUtils.loadInterpolator(context, c2));
        }
        String a2 = androidx.core.content.a.i.a(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (a2 != null) {
            a(b(a2));
        }
        obtainStyledAttributes.recycle();
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2, a.b.b<String, View> bVar3, a.b.b<String, View> bVar4) {
        View view;
        int size = bVar3.size();
        for (int i = 0; i < size; i++) {
            View d = bVar3.d(i);
            if (d != null && b(d) && (view = bVar4.get(bVar3.b(i))) != null && b(view)) {
                ga gaVar = bVar.get(d);
                ga gaVar2 = bVar2.get(view);
                if (gaVar != null && gaVar2 != null) {
                    this.w.add(gaVar);
                    this.x.add(gaVar2);
                    bVar.remove(d);
                    bVar2.remove(view);
                }
            }
        }
    }

    public Rect c() {
        b bVar = this.H;
        if (bVar == null) {
            return null;
        }
        return bVar.a(this);
    }

    public ga b(View view, boolean z) {
        TransitionSet transitionSet = this.u;
        if (transitionSet != null) {
            return transitionSet.b(view, z);
        }
        return (z ? this.s : this.t).f961a.get(view);
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2) {
        for (int i = 0; i < bVar.size(); i++) {
            ga d = bVar.d(i);
            if (b(d.f960b)) {
                this.w.add(d);
                this.x.add(null);
            }
        }
        for (int i2 = 0; i2 < bVar2.size(); i2++) {
            ga d2 = bVar2.d(i2);
            if (b(d2.f960b)) {
                this.x.add(d2);
                this.w.add(null);
            }
        }
    }

    public Transition b(c cVar) {
        ArrayList<c> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ga gaVar) {
        String[] a2;
        if (this.G == null || gaVar.f959a.isEmpty() || (a2 = this.G.a()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= a2.length) {
                z = true;
                break;
            } else if (!gaVar.f959a.containsKey(a2[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.G.a(gaVar);
    }

    private void a(ha haVar, ha haVar2) {
        a.b.b<View, ga> bVar = new a.b.b<>(haVar.f961a);
        a.b.b<View, ga> bVar2 = new a.b.b<>(haVar2.f961a);
        int i = 0;
        while (true) {
            int[] iArr = this.v;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    b(bVar, bVar2);
                } else if (i2 == 2) {
                    a(bVar, bVar2, haVar.d, haVar2.d);
                } else if (i2 == 3) {
                    a(bVar, bVar2, haVar.f962b, haVar2.f962b);
                } else if (i2 == 4) {
                    a(bVar, bVar2, haVar.c, haVar2.c);
                }
                i++;
            } else {
                a(bVar, bVar2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, ha haVar, ha haVar2, ArrayList<ga> arrayList, ArrayList<ga> arrayList2) {
        Animator a2;
        int i;
        int i2;
        View view;
        Animator animator;
        ga gaVar;
        Animator animator2;
        ga gaVar2;
        a.b.b<Animator, a> q = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            ga gaVar3 = arrayList.get(i3);
            ga gaVar4 = arrayList2.get(i3);
            if (gaVar3 != null && !gaVar3.c.contains(this)) {
                gaVar3 = null;
            }
            if (gaVar4 != null && !gaVar4.c.contains(this)) {
                gaVar4 = null;
            }
            if (gaVar3 != null || gaVar4 != null) {
                if ((gaVar3 == null || gaVar4 == null || a(gaVar3, gaVar4)) && (a2 = a(viewGroup, gaVar3, gaVar4)) != null) {
                    if (gaVar4 != null) {
                        view = gaVar4.f960b;
                        String[] n = n();
                        if (view == null || n == null || n.length <= 0) {
                            i = size;
                            i2 = i3;
                            animator2 = a2;
                            gaVar2 = null;
                        } else {
                            gaVar2 = new ga();
                            gaVar2.f960b = view;
                            i = size;
                            ga gaVar5 = haVar2.f961a.get(view);
                            if (gaVar5 != null) {
                                int i4 = 0;
                                while (i4 < n.length) {
                                    gaVar2.f959a.put(n[i4], gaVar5.f959a.get(n[i4]));
                                    i4++;
                                    i3 = i3;
                                    gaVar5 = gaVar5;
                                }
                            }
                            i2 = i3;
                            int size2 = q.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = a2;
                                    break;
                                }
                                a aVar = q.get(q.b(i5));
                                if (aVar.c != null && aVar.f932a == view && aVar.f933b.equals(f()) && aVar.c.equals(gaVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        }
                        animator = animator2;
                        gaVar = gaVar2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = gaVar3.f960b;
                        animator = a2;
                        gaVar = null;
                    }
                    if (animator != null) {
                        AbstractC0108da abstractC0108da = this.G;
                        if (abstractC0108da != null) {
                            long a3 = abstractC0108da.a(viewGroup, this, gaVar3, gaVar4);
                            sparseIntArray.put(this.F.size(), (int) a3);
                            j = Math.min(a3, j);
                        }
                        q.put(animator, new a(view, f(), this, va.d(viewGroup), gaVar));
                        this.F.add(animator);
                        j = j;
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (j != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.F.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((sparseIntArray.valueAt(i6) - j) + animator3.getStartDelay());
            }
        }
    }

    private void a(Animator animator, a.b.b<Animator, a> bVar) {
        if (animator != null) {
            animator.addListener(new Y(this, bVar));
            a(animator);
        }
    }

    public Transition a(View view) {
        this.i.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        a.b.b<String, String> bVar;
        a(z);
        if ((this.h.size() <= 0 && this.i.size() <= 0) || (((arrayList = this.j) != null && !arrayList.isEmpty()) || ((arrayList2 = this.k) != null && !arrayList2.isEmpty()))) {
            c(viewGroup, z);
        } else {
            for (int i = 0; i < this.h.size(); i++) {
                View findViewById = viewGroup.findViewById(this.h.get(i).intValue());
                if (findViewById != null) {
                    ga gaVar = new ga();
                    gaVar.f960b = findViewById;
                    if (z) {
                        c(gaVar);
                    } else {
                        a(gaVar);
                    }
                    gaVar.c.add(this);
                    b(gaVar);
                    if (z) {
                        a(this.s, findViewById, gaVar);
                    } else {
                        a(this.t, findViewById, gaVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                View view = this.i.get(i2);
                ga gaVar2 = new ga();
                gaVar2.f960b = view;
                if (z) {
                    c(gaVar2);
                } else {
                    a(gaVar2);
                }
                gaVar2.c.add(this);
                b(gaVar2);
                if (z) {
                    a(this.s, view, gaVar2);
                } else {
                    a(this.t, view, gaVar2);
                }
            }
        }
        if (z || (bVar = this.I) == null) {
            return;
        }
        int size = bVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.s.d.remove(this.I.b(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.s.d.put(this.I.d(i4), view2);
            }
        }
    }

    private static void a(ha haVar, View view, ga gaVar) {
        haVar.f961a.put(view, gaVar);
        int id = view.getId();
        if (id >= 0) {
            if (haVar.f962b.indexOfKey(id) >= 0) {
                haVar.f962b.put(id, null);
            } else {
                haVar.f962b.put(id, view);
            }
        }
        String q = androidx.core.h.t.q(view);
        if (q != null) {
            if (haVar.d.containsKey(q)) {
                haVar.d.put(q, null);
            } else {
                haVar.d.put(q, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (haVar.c.c(itemIdAtPosition) >= 0) {
                    View b2 = haVar.c.b(itemIdAtPosition);
                    if (b2 != null) {
                        androidx.core.h.t.b(b2, false);
                        haVar.c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                androidx.core.h.t.b(view, true);
                haVar.c.c(itemIdAtPosition, view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (z) {
            this.s.f961a.clear();
            this.s.f962b.clear();
            this.s.c.a();
            return;
        }
        this.t.f961a.clear();
        this.t.f962b.clear();
        this.t.c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga a(View view, boolean z) {
        TransitionSet transitionSet = this.u;
        if (transitionSet != null) {
            return transitionSet.a(view, z);
        }
        ArrayList<ga> arrayList = z ? this.w : this.x;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            ga gaVar = arrayList.get(i2);
            if (gaVar == null) {
                return null;
            }
            if (gaVar.f960b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.x : this.w).get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        a aVar;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        a(this.s, this.t);
        a.b.b<Animator, a> q = q();
        int size = q.size();
        Ea d = va.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator b2 = q.b(i);
            if (b2 != null && (aVar = q.get(b2)) != null && aVar.f932a != null && d.equals(aVar.d)) {
                ga gaVar = aVar.c;
                View view = aVar.f932a;
                ga b3 = b(view, true);
                ga a2 = a(view, true);
                if (!(b3 == null && a2 == null) && aVar.e.a(gaVar, a2)) {
                    if (!b2.isRunning() && !b2.isStarted()) {
                        q.remove(b2);
                    } else {
                        b2.cancel();
                    }
                }
            }
        }
        a(viewGroup, this.s, this.t, this.w, this.x);
        o();
    }

    public boolean a(ga gaVar, ga gaVar2) {
        if (gaVar == null || gaVar2 == null) {
            return false;
        }
        String[] n = n();
        if (n != null) {
            for (String str : n) {
                if (!a(gaVar, gaVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : gaVar.f959a.keySet()) {
            if (a(gaVar, gaVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(ga gaVar, ga gaVar2, String str) {
        Object obj = gaVar.f959a.get(str);
        Object obj2 = gaVar2.f959a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (i() >= 0) {
            animator.setStartDelay(i());
        }
        if (e() != null) {
            animator.setInterpolator(e());
        }
        animator.addListener(new Z(this));
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.B--;
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList2.get(i)).d(this);
                }
            }
            for (int i2 = 0; i2 < this.s.c.b(); i2++) {
                View c2 = this.s.c.c(i2);
                if (c2 != null) {
                    androidx.core.h.t.b(c2, false);
                }
            }
            for (int i3 = 0; i3 < this.t.c.b(); i3++) {
                View c3 = this.t.c.c(i3);
                if (c3 != null) {
                    androidx.core.h.t.b(c3, false);
                }
            }
            this.D = true;
        }
    }

    public Transition a(c cVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(cVar);
        return this;
    }

    public void a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.J = f931b;
        } else {
            this.J = pathMotion;
        }
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public void a(AbstractC0108da abstractC0108da) {
        this.G = abstractC0108da;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f != -1) {
            str2 = str2 + "dur(" + this.f + ") ";
        }
        if (this.e != -1) {
            str2 = str2 + "dly(" + this.e + ") ";
        }
        if (this.g != null) {
            str2 = str2 + "interp(" + this.g + ") ";
        }
        if (this.h.size() > 0 || this.i.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.h.size() > 0) {
                String str4 = str3;
                for (int i = 0; i < this.h.size(); i++) {
                    if (i > 0) {
                        str4 = str4 + ", ";
                    }
                    str4 = str4 + this.h.get(i);
                }
                str3 = str4;
            }
            if (this.i.size() > 0) {
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    if (i2 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.i.get(i2);
                }
            }
            return str3 + ")";
        }
        return str2;
    }
}
