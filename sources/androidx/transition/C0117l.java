package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
/* compiled from: ChangeClipBounds.java */
/* renamed from: androidx.transition.l  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0117l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f972a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ChangeClipBounds f973b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0117l(ChangeClipBounds changeClipBounds, View view) {
        this.f973b = changeClipBounds;
        this.f972a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        androidx.core.h.t.a(this.f972a, (Rect) null);
    }
}
