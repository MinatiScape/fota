package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class i implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SwipeRefreshLayout swipeRefreshLayout) {
        this.f892a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f892a;
        if (swipeRefreshLayout.s) {
            return;
        }
        swipeRefreshLayout.a((Animation.AnimationListener) null);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
