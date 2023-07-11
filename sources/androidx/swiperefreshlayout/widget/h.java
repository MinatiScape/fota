package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class h extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f890a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f891b;
    final /* synthetic */ SwipeRefreshLayout c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.c = swipeRefreshLayout;
        this.f890a = i;
        this.f891b = i2;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        d dVar = this.c.C;
        int i = this.f890a;
        dVar.setAlpha((int) (i + ((this.f891b - i) * f)));
    }
}
