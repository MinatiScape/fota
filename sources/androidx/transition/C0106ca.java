package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TransitionManager.java */
/* renamed from: androidx.transition.ca  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0106ca {

    /* renamed from: a  reason: collision with root package name */
    private static Transition f949a = new AutoTransition();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<a.b.b<ViewGroup, ArrayList<Transition>>>> f950b = new ThreadLocal<>();
    static ArrayList<ViewGroup> c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransitionManager.java */
    /* renamed from: androidx.transition.ca$a */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f951a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f952b;

        a(Transition transition, ViewGroup viewGroup) {
            this.f951a = transition;
            this.f952b = viewGroup;
        }

        private void a() {
            this.f952b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f952b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (C0106ca.c.remove(this.f952b)) {
                a.b.b<ViewGroup, ArrayList<Transition>> a2 = C0106ca.a();
                ArrayList<Transition> arrayList = a2.get(this.f952b);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    a2.put(this.f952b, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f951a);
                this.f951a.a(new C0104ba(this, a2));
                this.f951a.a(this.f952b, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).e(this.f952b);
                    }
                }
                this.f951a.a(this.f952b);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            C0106ca.c.remove(this.f952b);
            ArrayList<Transition> arrayList = C0106ca.a().get(this.f952b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f952b);
                }
            }
            this.f951a.a(true);
        }
    }

    static a.b.b<ViewGroup, ArrayList<Transition>> a() {
        a.b.b<ViewGroup, ArrayList<Transition>> bVar;
        WeakReference<a.b.b<ViewGroup, ArrayList<Transition>>> weakReference = f950b.get();
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            a.b.b<ViewGroup, ArrayList<Transition>> bVar2 = new a.b.b<>();
            f950b.set(new WeakReference<>(bVar2));
            return bVar2;
        }
        return bVar;
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c(viewGroup);
            }
        }
        if (transition != null) {
            transition.a(viewGroup, true);
        }
        N a2 = N.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (c.contains(viewGroup) || !androidx.core.h.t.z(viewGroup)) {
            return;
        }
        c.add(viewGroup);
        if (transition == null) {
            transition = f949a;
        }
        Transition mo2clone = transition.mo2clone();
        c(viewGroup, mo2clone);
        N.a(viewGroup, null);
        b(viewGroup, mo2clone);
    }
}
