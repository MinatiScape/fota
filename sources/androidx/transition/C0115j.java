package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.j  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0115j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f967a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f968b;
    final /* synthetic */ Rect c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ ChangeBounds h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0115j(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.h = changeBounds;
        this.f968b = view;
        this.c = rect;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f967a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f967a) {
            return;
        }
        androidx.core.h.t.a(this.f968b, this.c);
        va.a(this.f968b, this.d, this.e, this.f, this.g);
    }
}
