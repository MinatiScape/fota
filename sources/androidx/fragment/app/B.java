package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class B {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f588a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final K f589b;
    private static final K c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f590a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f591b;
        public C0071a c;
        public Fragment d;
        public boolean e;
        public C0071a f;

        a() {
        }
    }

    static {
        f589b = Build.VERSION.SDK_INT >= 21 ? new G() : null;
        c = a();
    }

    private static K a() {
        try {
            return (K) Class.forName("androidx.transition.z").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void b(r rVar, int i, a aVar, View view, a.b.b<String, String> bVar) {
        Fragment fragment;
        Fragment fragment2;
        K a2;
        Object obj;
        ViewGroup viewGroup = rVar.t.a() ? (ViewGroup) rVar.t.a(i) : null;
        if (viewGroup == null || (a2 = a((fragment2 = aVar.d), (fragment = aVar.f590a))) == null) {
            return;
        }
        boolean z = aVar.f591b;
        boolean z2 = aVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        Object b3 = b(a2, viewGroup, view, bVar, aVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a4 = a(a2, obj, fragment2, arrayList2, view);
        ArrayList<View> a5 = a(a2, a3, fragment, arrayList, view);
        a(a5, 4);
        Object a6 = a(a2, a3, obj, b3, fragment, z);
        if (a6 != null) {
            a(a2, obj, fragment2, a4);
            ArrayList<String> a7 = a2.a(arrayList);
            a2.a(a6, a3, a5, obj, a4, b3, arrayList);
            a2.a(viewGroup, a6);
            a2.a(viewGroup, arrayList2, arrayList, a7, bVar);
            a(a5, 0);
            a2.b(b3, arrayList2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(r rVar, ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (rVar.r < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            C0071a c0071a = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(c0071a, sparseArray, z);
            } else {
                a(c0071a, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(rVar.s.c());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                a.b.b<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                a aVar = (a) sparseArray.valueAt(i4);
                if (z) {
                    b(rVar, keyAt, aVar, view, a2);
                } else {
                    a(rVar, keyAt, aVar, view, a2);
                }
            }
        }
    }

    private static a.b.b<String, String> a(int i, ArrayList<C0071a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        a.b.b<String, String> bVar = new a.b.b<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0071a c0071a = arrayList.get(i4);
            if (c0071a.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = c0071a.r;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = c0071a.r;
                        arrayList4 = c0071a.s;
                    } else {
                        ArrayList<String> arrayList6 = c0071a.r;
                        arrayList3 = c0071a.s;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = bVar.remove(str2);
                        if (remove != null) {
                            bVar.put(str, remove);
                        } else {
                            bVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return bVar;
    }

    private static Object b(K k, Fragment fragment, boolean z) {
        Object k2;
        if (fragment == null) {
            return null;
        }
        if (z) {
            k2 = fragment.s();
        } else {
            k2 = fragment.k();
        }
        return k.b(k2);
    }

    private static Object b(K k, ViewGroup viewGroup, View view, a.b.b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = aVar.f590a;
        Fragment fragment2 = aVar.d;
        if (fragment != null) {
            fragment.w().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar.f591b;
        Object a2 = bVar.isEmpty() ? null : a(k, fragment, fragment2, z);
        a.b.b<String, View> b2 = b(k, bVar, a2, aVar);
        a.b.b<String, View> a3 = a(k, bVar, a2, aVar);
        if (bVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, bVar.keySet());
            a(arrayList2, a3, bVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            k.b(obj3, view, arrayList);
            a(k, obj3, obj2, b2, aVar.e, aVar.f);
            Rect rect2 = new Rect();
            View a4 = a(a3, aVar, obj, z);
            if (a4 != null) {
                k.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        L.a(viewGroup, new z(fragment, fragment2, z, a3, view2, k, rect));
        return obj3;
    }

    private static void a(K k, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.m && fragment.C && fragment.Q) {
            fragment.f(true);
            k.a(obj, fragment.w(), arrayList);
            L.a(fragment.J, new x(arrayList));
        }
    }

    private static void a(r rVar, int i, a aVar, View view, a.b.b<String, String> bVar) {
        Fragment fragment;
        Fragment fragment2;
        K a2;
        Object obj;
        ViewGroup viewGroup = rVar.t.a() ? (ViewGroup) rVar.t.a(i) : null;
        if (viewGroup == null || (a2 = a((fragment2 = aVar.d), (fragment = aVar.f590a))) == null) {
            return;
        }
        boolean z = aVar.f591b;
        boolean z2 = aVar.e;
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a4 = a(a2, viewGroup, view, bVar, aVar, arrayList, arrayList2, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a5 = a(a2, obj, fragment2, arrayList, view);
        Object obj2 = (a5 == null || a5.isEmpty()) ? null : obj;
        a2.a(a3, view);
        Object a6 = a(a2, a3, obj2, a4, fragment, aVar.f591b);
        if (a6 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.a(a6, a3, arrayList3, obj2, a5, a4, arrayList2);
            a(a2, viewGroup, fragment, view, arrayList2, a3, arrayList3, obj2, a5);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) bVar);
            a2.a(viewGroup, a6);
            a2.a(viewGroup, arrayList2, (Map<String, String>) bVar);
        }
    }

    private static a.b.b<String, View> b(K k, a.b.b<String, String> bVar, Object obj, a aVar) {
        androidx.core.app.g l;
        ArrayList<String> arrayList;
        if (!bVar.isEmpty() && obj != null) {
            Fragment fragment = aVar.d;
            a.b.b<String, View> bVar2 = new a.b.b<>();
            k.a((Map<String, View>) bVar2, fragment.w());
            C0071a c0071a = aVar.f;
            if (aVar.e) {
                l = fragment.j();
                arrayList = c0071a.s;
            } else {
                l = fragment.l();
                arrayList = c0071a.r;
            }
            bVar2.a((Collection<?>) arrayList);
            if (l != null) {
                l.a(arrayList, bVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = bVar2.get(str);
                    if (view == null) {
                        bVar.remove(str);
                    } else if (!str.equals(androidx.core.h.t.q(view))) {
                        bVar.put(androidx.core.h.t.q(view), bVar.remove(str));
                    }
                }
            } else {
                bVar.a((Collection<?>) bVar2.keySet());
            }
            return bVar2;
        }
        bVar.clear();
        return null;
    }

    private static void a(K k, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        L.a(viewGroup, new y(obj, k, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static K a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object k = fragment.k();
            if (k != null) {
                arrayList.add(k);
            }
            Object s = fragment.s();
            if (s != null) {
                arrayList.add(s);
            }
            Object u = fragment.u();
            if (u != null) {
                arrayList.add(u);
            }
        }
        if (fragment2 != null) {
            Object i = fragment2.i();
            if (i != null) {
                arrayList.add(i);
            }
            Object q = fragment2.q();
            if (q != null) {
                arrayList.add(q);
            }
            Object t = fragment2.t();
            if (t != null) {
                arrayList.add(t);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        K k2 = f589b;
        if (k2 != null && a(k2, arrayList)) {
            return f589b;
        }
        K k3 = c;
        if (k3 != null && a(k3, arrayList)) {
            return c;
        }
        if (f589b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static void b(C0071a c0071a, SparseArray<a> sparseArray, boolean z) {
        if (c0071a.f626a.t.a()) {
            for (int size = c0071a.f627b.size() - 1; size >= 0; size--) {
                a(c0071a, c0071a.f627b.get(size), sparseArray, true, z);
            }
        }
    }

    private static boolean a(K k, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!k.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(K k, Fragment fragment, Fragment fragment2, boolean z) {
        Object t;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            t = fragment2.u();
        } else {
            t = fragment.t();
        }
        return k.c(k.b(t));
    }

    private static Object a(K k, Fragment fragment, boolean z) {
        Object i;
        if (fragment == null) {
            return null;
        }
        if (z) {
            i = fragment.q();
        } else {
            i = fragment.i();
        }
        return k.b(i);
    }

    private static void a(ArrayList<View> arrayList, a.b.b<String, View> bVar, Collection<String> collection) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View d = bVar.d(size);
            if (collection.contains(androidx.core.h.t.q(d))) {
                arrayList.add(d);
            }
        }
    }

    private static Object a(K k, ViewGroup viewGroup, View view, a.b.b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object a2;
        a.b.b<String, String> bVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = aVar.f590a;
        Fragment fragment2 = aVar.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar.f591b;
        if (bVar.isEmpty()) {
            bVar2 = bVar;
            a2 = null;
        } else {
            a2 = a(k, fragment, fragment2, z);
            bVar2 = bVar;
        }
        a.b.b<String, View> b2 = b(k, bVar2, a2, aVar);
        if (bVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            k.b(obj3, view, arrayList);
            a(k, obj3, obj2, b2, aVar.e, aVar.f);
            if (obj != null) {
                k.a(obj, rect);
            }
        } else {
            rect = null;
        }
        L.a(viewGroup, new A(k, bVar, obj3, aVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a.b.b<String, View> a(K k, a.b.b<String, String> bVar, Object obj, a aVar) {
        androidx.core.app.g j;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = aVar.f590a;
        View w = fragment.w();
        if (!bVar.isEmpty() && obj != null && w != null) {
            a.b.b<String, View> bVar2 = new a.b.b<>();
            k.a((Map<String, View>) bVar2, w);
            C0071a c0071a = aVar.c;
            if (aVar.f591b) {
                j = fragment.l();
                arrayList = c0071a.r;
            } else {
                j = fragment.j();
                arrayList = c0071a.s;
            }
            if (arrayList != null) {
                bVar2.a((Collection<?>) arrayList);
                bVar2.a((Collection<?>) bVar.values());
            }
            if (j != null) {
                j.a(arrayList, bVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = bVar2.get(str);
                    if (view == null) {
                        String a3 = a(bVar, str);
                        if (a3 != null) {
                            bVar.remove(a3);
                        }
                    } else if (!str.equals(androidx.core.h.t.q(view)) && (a2 = a(bVar, str)) != null) {
                        bVar.put(a2, androidx.core.h.t.q(view));
                    }
                }
            } else {
                a(bVar, bVar2);
            }
            return bVar2;
        }
        bVar.clear();
        return null;
    }

    private static String a(a.b.b<String, String> bVar, String str) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(bVar.d(i))) {
                return bVar.b(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(a.b.b<String, View> bVar, a aVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        C0071a c0071a = aVar.c;
        if (obj == null || bVar == null || (arrayList = c0071a.r) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = c0071a.r.get(0);
        } else {
            str = c0071a.s.get(0);
        }
        return bVar.get(str);
    }

    private static void a(K k, Object obj, Object obj2, a.b.b<String, View> bVar, boolean z, C0071a c0071a) {
        String str;
        ArrayList<String> arrayList = c0071a.r;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = c0071a.s.get(0);
        } else {
            str = c0071a.r.get(0);
        }
        View view = bVar.get(str);
        k.c(obj, view);
        if (obj2 != null) {
            k.c(obj2, view);
        }
    }

    private static void a(a.b.b<String, String> bVar, a.b.b<String, View> bVar2) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            if (!bVar2.containsKey(bVar.d(size))) {
                bVar.c(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, Fragment fragment2, boolean z, a.b.b<String, View> bVar, boolean z2) {
        androidx.core.app.g j;
        if (z) {
            j = fragment2.j();
        } else {
            j = fragment.j();
        }
        if (j != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = bVar == null ? 0 : bVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(bVar.b(i));
                arrayList.add(bVar.d(i));
            }
            if (z2) {
                j.b(arrayList2, arrayList, null);
            } else {
                j.a(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<View> a(K k, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View w = fragment.w();
            if (w != null) {
                k.a(arrayList2, w);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            k.a(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static Object a(K k, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.d();
        } else {
            z2 = fragment.c();
        }
        if (z2) {
            return k.b(obj2, obj, obj3);
        }
        return k.a(obj2, obj, obj3);
    }

    public static void a(C0071a c0071a, SparseArray<a> sparseArray, boolean z) {
        int size = c0071a.f627b.size();
        for (int i = 0; i < size; i++) {
            a(c0071a, c0071a.f627b.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
        if (r10.m != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0092, code lost:
        if (r10.C == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0094, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e7 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(androidx.fragment.app.C0071a r16, androidx.fragment.app.C0071a.C0017a r17, android.util.SparseArray<androidx.fragment.app.B.a> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.B.a(androidx.fragment.app.a, androidx.fragment.app.a$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar == null) {
            a aVar2 = new a();
            sparseArray.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }
}
