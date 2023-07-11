package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class f extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SwipeRefreshLayout swipeRefreshLayout) {
        this.f888a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        this.f888a.setAnimationProgress(f);
    }
}
