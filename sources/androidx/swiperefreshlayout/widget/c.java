package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import androidx.swiperefreshlayout.widget.d;
/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
class c implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f881a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f882b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, d.a aVar) {
        this.f882b = dVar;
        this.f881a = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.f882b.a(1.0f, this.f881a, true);
        this.f881a.l();
        this.f881a.j();
        d dVar = this.f882b;
        if (dVar.i) {
            dVar.i = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f881a.a(false);
            return;
        }
        dVar.h += 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f882b.h = 0.0f;
    }
}
