package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;
/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes.dex */
class E implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f598a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f599b;
    final /* synthetic */ Object c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ Object e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ G g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(G g, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = g;
        this.f598a = obj;
        this.f599b = arrayList;
        this.c = obj2;
        this.d = arrayList2;
        this.e = obj3;
        this.f = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Object obj = this.f598a;
        if (obj != null) {
            this.g.a(obj, this.f599b, (ArrayList<View>) null);
        }
        Object obj2 = this.c;
        if (obj2 != null) {
            this.g.a(obj2, this.d, (ArrayList<View>) null);
        }
        Object obj3 = this.e;
        if (obj3 != null) {
            this.g.a(obj3, this.f, (ArrayList<View>) null);
        }
    }
}
