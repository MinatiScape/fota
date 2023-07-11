package androidx.core.h;

import android.animation.ValueAnimator;
import android.view.View;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f543a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f544b;
    final /* synthetic */ z c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(z zVar, C c, View view) {
        this.c = zVar;
        this.f543a = c;
        this.f544b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f543a.a(this.f544b);
    }
}
