package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0103b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f944a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BitmapDrawable f945b;
    final /* synthetic */ View c;
    final /* synthetic */ float d;
    final /* synthetic */ ChangeBounds e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0103b(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
        this.e = changeBounds;
        this.f944a = viewGroup;
        this.f945b = bitmapDrawable;
        this.c = view;
        this.d = f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        va.b(this.f944a).b(this.f945b);
        va.a(this.c, this.d);
    }
}
