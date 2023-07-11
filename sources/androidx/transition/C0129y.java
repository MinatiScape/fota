package androidx.transition;

import android.graphics.Rect;
import androidx.transition.Transition;
/* compiled from: FragmentTransitionSupport.java */
/* renamed from: androidx.transition.y  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0129y extends Transition.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f998a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0130z f999b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0129y(C0130z c0130z, Rect rect) {
        this.f999b = c0130z;
        this.f998a = rect;
    }

    @Override // androidx.transition.Transition.b
    public Rect a(Transition transition) {
        Rect rect = this.f998a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f998a;
    }
}
