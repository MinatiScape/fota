package androidx.coordinatorlayout.widget;

import a.b.i;
import androidx.core.g.e;
import androidx.core.g.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<ArrayList<T>> f393a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    private final i<T, ArrayList<T>> f394b = new i<>();
    private final ArrayList<T> c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (this.f394b.containsKey(t)) {
            return;
        }
        this.f394b.put(t, null);
    }

    public boolean b(T t) {
        return this.f394b.containsKey(t);
    }

    public List c(T t) {
        return this.f394b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f394b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> d = this.f394b.d(i);
            if (d != null && d.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f394b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f394b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> d = this.f394b.d(i);
            if (d != null && d.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<T> c() {
        ArrayList<T> acquire = this.f393a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int size = this.f394b.size();
        for (int i = 0; i < size; i++) {
            a(this.f394b.b(i), this.c, this.d);
        }
        return this.c;
    }

    public void a(T t, T t2) {
        if (this.f394b.containsKey(t) && this.f394b.containsKey(t2)) {
            ArrayList<T> arrayList = this.f394b.get(t);
            if (arrayList == null) {
                arrayList = c();
                this.f394b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void a() {
        int size = this.f394b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> d = this.f394b.d(i);
            if (d != null) {
                a((ArrayList) d);
            }
        }
        this.f394b.clear();
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f394b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f393a.release(arrayList);
    }
}
