package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;
/* compiled from: ChangeTransform.java */
/* loaded from: classes.dex */
class r extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f982a;

    /* renamed from: b  reason: collision with root package name */
    private Matrix f983b = new Matrix();
    final /* synthetic */ boolean c;
    final /* synthetic */ Matrix d;
    final /* synthetic */ View e;
    final /* synthetic */ ChangeTransform.c f;
    final /* synthetic */ ChangeTransform.b g;
    final /* synthetic */ ChangeTransform h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ChangeTransform changeTransform, boolean z, Matrix matrix, View view, ChangeTransform.c cVar, ChangeTransform.b bVar) {
        this.h = changeTransform;
        this.c = z;
        this.d = matrix;
        this.e = view;
        this.f = cVar;
        this.g = bVar;
    }

    private void a(Matrix matrix) {
        this.f983b.set(matrix);
        this.e.setTag(R$id.transition_transform, this.f983b);
        this.f.a(this.e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f982a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f982a) {
            if (this.c && this.h.O) {
                a(this.d);
            } else {
                this.e.setTag(R$id.transition_transform, null);
                this.e.setTag(R$id.parent_matrix, null);
            }
        }
        va.a(this.e, (Matrix) null);
        this.f.a(this.e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        a(this.g.a());
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        ChangeTransform.f(this.e);
    }
}
