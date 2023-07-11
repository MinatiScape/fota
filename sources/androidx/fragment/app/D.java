package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;
/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes.dex */
class D implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f596a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f597b;
    final /* synthetic */ G c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(G g, View view, ArrayList arrayList) {
        this.c = g;
        this.f596a = view;
        this.f597b = arrayList;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f596a.setVisibility(8);
        int size = this.f597b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f597b.get(i)).setVisibility(0);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
    }
}
