package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FragmentTransitionSupport.java */
/* renamed from: androidx.transition.z  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0130z extends androidx.fragment.app.K {
    @Override // androidx.fragment.app.K
    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.K
    public Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo2clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.K
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.a((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.K
    public void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int q = transitionSet.q();
            while (i < q) {
                a(transitionSet.a(i), arrayList);
                i++;
            }
        } else if (a(transition) || !androidx.fragment.app.K.a((List) transition.m())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                transition.a(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // androidx.fragment.app.K
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> m = transitionSet.m();
        m.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.K.a(m, arrayList.get(i));
        }
        m.add(view);
        arrayList.add(view);
        a(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.K
    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).a(new C0126v(this, rect));
        }
    }

    @Override // androidx.fragment.app.K
    public Object b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.a((Transition) obj3);
        }
        return transitionSet;
    }

    private static boolean a(Transition transition) {
        return (androidx.fragment.app.K.a((List) transition.j()) && androidx.fragment.app.K.a((List) transition.k()) && androidx.fragment.app.K.a((List) transition.l())) ? false : true;
    }

    @Override // androidx.fragment.app.K
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.m().clear();
            transitionSet.m().addAll(arrayList2);
            a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.K
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).a(new C0127w(this, view, arrayList));
    }

    @Override // androidx.fragment.app.K
    public Object a(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().a(transition).a(transition2).b(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.a(transition);
            }
            transitionSet.a(transition3);
            return transitionSet;
        }
        return transition;
    }

    @Override // androidx.fragment.app.K
    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).d(view);
        }
    }

    @Override // androidx.fragment.app.K
    public void a(ViewGroup viewGroup, Object obj) {
        C0106ca.a(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.K
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).a(new C0128x(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.K
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int q = transitionSet.q();
            while (i < q) {
                a((Object) transitionSet.a(i), arrayList, arrayList2);
                i++;
            }
        } else if (!a(transition)) {
            List<View> m = transition.m();
            if (m.size() == arrayList.size() && m.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    transition.a(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.d(arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.K
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).a(view);
        }
    }

    @Override // androidx.fragment.app.K
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).a(new C0129y(this, rect));
        }
    }
}
