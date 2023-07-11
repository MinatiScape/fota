package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* compiled from: SwipeRefreshLayout.java */
/* loaded from: classes.dex */
class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SwipeRefreshLayout swipeRefreshLayout) {
        this.f887a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout.b bVar;
        SwipeRefreshLayout swipeRefreshLayout = this.f887a;
        if (swipeRefreshLayout.e) {
            swipeRefreshLayout.C.setAlpha(255);
            this.f887a.C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = this.f887a;
            if (swipeRefreshLayout2.I && (bVar = swipeRefreshLayout2.d) != null) {
                bVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = this.f887a;
            swipeRefreshLayout3.n = swipeRefreshLayout3.v.getTop();
            return;
        }
        swipeRefreshLayout.b();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
