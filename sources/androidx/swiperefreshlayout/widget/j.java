package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class j extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SwipeRefreshLayout swipeRefreshLayout) {
        this.f893a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        int i;
        SwipeRefreshLayout swipeRefreshLayout = this.f893a;
        if (!swipeRefreshLayout.K) {
            i = swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.z);
        } else {
            i = swipeRefreshLayout.A;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.f893a;
        int i2 = swipeRefreshLayout2.x;
        this.f893a.setTargetOffsetTopAndBottom((i2 + ((int) ((i - i2) * f))) - swipeRefreshLayout2.v.getTop());
        this.f893a.C.a(1.0f - f);
    }
}
