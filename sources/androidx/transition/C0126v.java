package androidx.transition;

import android.graphics.Rect;
import androidx.transition.Transition;
/* compiled from: FragmentTransitionSupport.java */
/* renamed from: androidx.transition.v  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0126v extends Transition.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f989a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0130z f990b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0126v(C0130z c0130z, Rect rect) {
        this.f990b = c0130z;
        this.f989a = rect;
    }

    @Override // androidx.transition.Transition.b
    public Rect a(Transition transition) {
        return this.f989a;
    }
}
