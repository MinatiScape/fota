package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class g extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SwipeRefreshLayout swipeRefreshLayout) {
        this.f889a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        this.f889a.setAnimationProgress(1.0f - f);
    }
}
