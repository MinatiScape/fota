package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public class n extends r.b {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewGroup f639b;
    final /* synthetic */ Fragment c;
    final /* synthetic */ r d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(r rVar, Animation.AnimationListener animationListener, ViewGroup viewGroup, Fragment fragment) {
        super(animationListener);
        this.d = rVar;
        this.f639b = viewGroup;
        this.c = fragment;
    }

    @Override // androidx.fragment.app.r.b, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        this.f639b.post(new RunnableC0083m(this));
    }
}
