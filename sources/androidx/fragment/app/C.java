package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes.dex */
class C extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f594a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ G f595b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(G g, Rect rect) {
        this.f595b = g;
        this.f594a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        return this.f594a;
    }
}
