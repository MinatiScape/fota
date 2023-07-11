package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import androidx.swiperefreshlayout.widget.d;
/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f879a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f880b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, d.a aVar) {
        this.f880b = dVar;
        this.f879a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f880b.a(floatValue, this.f879a);
        this.f880b.a(floatValue, this.f879a, false);
        this.f880b.invalidateSelf();
    }
}
