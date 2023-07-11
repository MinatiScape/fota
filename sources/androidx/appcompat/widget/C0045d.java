package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* compiled from: ActionBarOverlayLayout.java */
/* renamed from: androidx.appcompat.widget.d  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0045d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0045d(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f317a = actionBarOverlayLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f317a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.l = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f317a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.l = false;
    }
}
