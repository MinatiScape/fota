package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes.dex */
class F extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f600a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ G f601b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(G g, Rect rect) {
        this.f601b = g;
        this.f600a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.f600a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f600a;
    }
}
