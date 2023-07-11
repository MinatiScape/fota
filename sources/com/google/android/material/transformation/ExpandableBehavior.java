package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: a  reason: collision with root package name */
    private int f1438a;

    public ExpandableBehavior() {
        this.f1438a = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        com.google.android.material.d.b bVar = (com.google.android.material.d.b) view2;
        if (a(bVar.a())) {
            this.f1438a = bVar.a() ? 1 : 2;
            return a((View) bVar, view, bVar.a(), true);
        }
        return false;
    }

    protected com.google.android.material.d.b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> b2 = coordinatorLayout.b(view);
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            View view2 = b2.get(i);
            if (a(coordinatorLayout, (CoordinatorLayout) view, view2)) {
                return (com.google.android.material.d.b) view2;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        com.google.android.material.d.b e;
        if (t.z(view) || (e = e(coordinatorLayout, view)) == null || !a(e.a())) {
            return false;
        }
        this.f1438a = e.a() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(this, view, this.f1438a, e));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1438a = 0;
    }

    private boolean a(boolean z) {
        if (!z) {
            return this.f1438a == 1;
        }
        int i = this.f1438a;
        return i == 0 || i == 2;
    }
}
