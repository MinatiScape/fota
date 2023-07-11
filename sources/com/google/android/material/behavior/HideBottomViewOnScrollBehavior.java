package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f1267a;

    /* renamed from: b  reason: collision with root package name */
    private int f1268b;
    private ViewPropertyAnimator c;

    public HideBottomViewOnScrollBehavior() {
        this.f1267a = 0;
        this.f1268b = 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1268b = 2;
        a((HideBottomViewOnScrollBehavior<V>) v, 0, 225L, com.google.android.material.a.a.d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f1267a = v.getMeasuredHeight();
        return super.a(coordinatorLayout, (CoordinatorLayout) v, i);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1267a = 0;
        this.f1268b = 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.f1268b != 1 && i2 > 0) {
            a((HideBottomViewOnScrollBehavior<V>) v);
        } else if (this.f1268b == 2 || i2 >= 0) {
        } else {
            b(v);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1268b = 1;
        a((HideBottomViewOnScrollBehavior<V>) v, this.f1267a, 175L, com.google.android.material.a.a.c);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.c = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a(this));
    }
}
