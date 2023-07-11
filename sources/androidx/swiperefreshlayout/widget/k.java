package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class k extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SwipeRefreshLayout swipeRefreshLayout) {
        this.f894a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        this.f894a.a(f);
    }
}
