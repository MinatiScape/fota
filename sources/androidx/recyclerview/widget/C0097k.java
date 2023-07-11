package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.k  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0097k extends I {
    private static TimeInterpolator h;
    private ArrayList<RecyclerView.v> i = new ArrayList<>();
    private ArrayList<RecyclerView.v> j = new ArrayList<>();
    private ArrayList<b> k = new ArrayList<>();
    private ArrayList<a> l = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> m = new ArrayList<>();
    ArrayList<ArrayList<b>> n = new ArrayList<>();
    ArrayList<ArrayList<a>> o = new ArrayList<>();
    ArrayList<RecyclerView.v> p = new ArrayList<>();
    ArrayList<RecyclerView.v> q = new ArrayList<>();
    ArrayList<RecyclerView.v> r = new ArrayList<>();
    ArrayList<RecyclerView.v> s = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.k$b */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f844a;

        /* renamed from: b  reason: collision with root package name */
        public int f845b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.v vVar, int i, int i2, int i3, int i4) {
            this.f844a = vVar;
            this.f845b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    private void u(RecyclerView.v vVar) {
        View view = vVar.f807b;
        ViewPropertyAnimator animate = view.animate();
        this.r.add(vVar);
        animate.setDuration(f()).alpha(0.0f).setListener(new C0092f(this, vVar, animate, view)).start();
    }

    private void v(RecyclerView.v vVar) {
        if (h == null) {
            h = new ValueAnimator().getInterpolator();
        }
        vVar.f807b.animate().setInterpolator(h);
        d(vVar);
    }

    @Override // androidx.recyclerview.widget.I
    public boolean a(RecyclerView.v vVar, int i, int i2, int i3, int i4) {
        View view = vVar.f807b;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) vVar.f807b.getTranslationY());
        v(vVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            j(vVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.k.add(new b(vVar, translationX, translationY, i3, i4));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.v vVar, int i, int i2, int i3, int i4) {
        View view = vVar.f807b;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.q.add(vVar);
        animate.setDuration(e()).setListener(new C0094h(this, vVar, i5, view, i6, animate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d(RecyclerView.v vVar) {
        View view = vVar.f807b;
        view.animate().cancel();
        int size = this.k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.k.get(size).f844a == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(vVar);
                this.k.remove(size);
            }
        }
        a(this.l, vVar);
        if (this.i.remove(vVar)) {
            view.setAlpha(1.0f);
            l(vVar);
        }
        if (this.j.remove(vVar)) {
            view.setAlpha(1.0f);
            h(vVar);
        }
        for (int size2 = this.o.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.o.get(size2);
            a(arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.o.remove(size2);
            }
        }
        for (int size3 = this.n.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.n.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f844a == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.n.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.v> arrayList3 = this.m.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                h(vVar);
                if (arrayList3.isEmpty()) {
                    this.m.remove(size5);
                }
            }
        }
        this.r.remove(vVar);
        this.p.remove(vVar);
        this.s.remove(vVar);
        this.q.remove(vVar);
        j();
    }

    @Override // androidx.recyclerview.widget.I
    public boolean f(RecyclerView.v vVar) {
        v(vVar);
        vVar.f807b.setAlpha(0.0f);
        this.j.add(vVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.I
    public boolean g(RecyclerView.v vVar) {
        v(vVar);
        this.i.add(vVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void i() {
        boolean z = !this.i.isEmpty();
        boolean z2 = !this.k.isEmpty();
        boolean z3 = !this.l.isEmpty();
        boolean z4 = !this.j.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.v> it = this.i.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.i.clear();
            if (z2) {
                ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.k);
                this.n.add(arrayList);
                this.k.clear();
                RunnableC0089c runnableC0089c = new RunnableC0089c(this, arrayList);
                if (z) {
                    androidx.core.h.t.a(arrayList.get(0).f844a.f807b, runnableC0089c, f());
                } else {
                    runnableC0089c.run();
                }
            }
            if (z3) {
                ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.l);
                this.o.add(arrayList2);
                this.l.clear();
                RunnableC0090d runnableC0090d = new RunnableC0090d(this, arrayList2);
                if (z) {
                    androidx.core.h.t.a(arrayList2.get(0).f842a.f807b, runnableC0090d, f());
                } else {
                    runnableC0090d.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.j);
                this.m.add(arrayList3);
                this.j.clear();
                RunnableC0091e runnableC0091e = new RunnableC0091e(this, arrayList3);
                if (!z && !z2 && !z3) {
                    runnableC0091e.run();
                } else {
                    androidx.core.h.t.a(arrayList3.get(0).f807b, runnableC0091e, (z ? f() : 0L) + Math.max(z2 ? e() : 0L, z3 ? d() : 0L));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (g()) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(RecyclerView.v vVar) {
        View view = vVar.f807b;
        ViewPropertyAnimator animate = view.animate();
        this.p.add(vVar);
        animate.alpha(1.0f).setDuration(c()).setListener(new C0093g(this, vVar, view, animate)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.k$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f842a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.v f843b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.f842a = vVar;
            this.f843b = vVar2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f842a + ", newHolder=" + this.f843b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }

        a(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4) {
            this(vVar, vVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean g() {
        return (this.j.isEmpty() && this.l.isEmpty() && this.k.isEmpty() && this.i.isEmpty() && this.q.isEmpty() && this.r.isEmpty() && this.p.isEmpty() && this.s.isEmpty() && this.n.isEmpty() && this.m.isEmpty() && this.o.isEmpty()) ? false : true;
    }

    private void b(a aVar) {
        RecyclerView.v vVar = aVar.f842a;
        if (vVar != null) {
            a(aVar, vVar);
        }
        RecyclerView.v vVar2 = aVar.f843b;
        if (vVar2 != null) {
            a(aVar, vVar2);
        }
    }

    @Override // androidx.recyclerview.widget.I
    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4) {
        if (vVar == vVar2) {
            return a(vVar, i, i2, i3, i4);
        }
        float translationX = vVar.f807b.getTranslationX();
        float translationY = vVar.f807b.getTranslationY();
        float alpha = vVar.f807b.getAlpha();
        v(vVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        vVar.f807b.setTranslationX(translationX);
        vVar.f807b.setTranslationY(translationY);
        vVar.f807b.setAlpha(alpha);
        if (vVar2 != null) {
            v(vVar2);
            vVar2.f807b.setTranslationX(-i5);
            vVar2.f807b.setTranslationY(-i6);
            vVar2.f807b.setAlpha(0.0f);
        }
        this.l.add(new a(vVar, vVar2, i, i2, i3, i4));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void b() {
        int size = this.k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.k.get(size);
            View view = bVar.f844a.f807b;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.f844a);
            this.k.remove(size);
        }
        for (int size2 = this.i.size() - 1; size2 >= 0; size2--) {
            l(this.i.get(size2));
            this.i.remove(size2);
        }
        int size3 = this.j.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.v vVar = this.j.get(size3);
            vVar.f807b.setAlpha(1.0f);
            h(vVar);
            this.j.remove(size3);
        }
        for (int size4 = this.l.size() - 1; size4 >= 0; size4--) {
            b(this.l.get(size4));
        }
        this.l.clear();
        if (g()) {
            for (int size5 = this.n.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.n.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f844a.f807b;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.f844a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.n.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.m.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.v> arrayList2 = this.m.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = arrayList2.get(size8);
                    vVar2.f807b.setAlpha(1.0f);
                    h(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.o.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.o.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.o.remove(arrayList3);
                    }
                }
            }
            a(this.r);
            a(this.q);
            a(this.p);
            a(this.s);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        RecyclerView.v vVar = aVar.f842a;
        View view = vVar == null ? null : vVar.f807b;
        RecyclerView.v vVar2 = aVar.f843b;
        View view2 = vVar2 != null ? vVar2.f807b : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(d());
            this.s.add(aVar.f842a);
            duration.translationX(aVar.e - aVar.c);
            duration.translationY(aVar.f - aVar.d);
            duration.alpha(0.0f).setListener(new C0095i(this, aVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.s.add(aVar.f843b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(d()).alpha(1.0f).setListener(new C0096j(this, aVar, animate, view2)).start();
        }
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.f842a == null && aVar.f843b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        boolean z = false;
        if (aVar.f843b == vVar) {
            aVar.f843b = null;
        } else if (aVar.f842a != vVar) {
            return false;
        } else {
            aVar.f842a = null;
            z = true;
        }
        vVar.f807b.setAlpha(1.0f);
        vVar.f807b.setTranslationX(0.0f);
        vVar.f807b.setTranslationY(0.0f);
        a(vVar, z);
        return true;
    }

    void a(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f807b.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }
}
