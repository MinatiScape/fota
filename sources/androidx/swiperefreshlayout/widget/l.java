package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class l extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f895a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SwipeRefreshLayout swipeRefreshLayout) {
        this.f895a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f895a;
        float f2 = swipeRefreshLayout.y;
        swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
        this.f895a.a(f);
    }
}
