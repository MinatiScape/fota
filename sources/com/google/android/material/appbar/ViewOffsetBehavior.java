package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private f f1257a;

    /* renamed from: b  reason: collision with root package name */
    private int f1258b;
    private int c;

    public ViewOffsetBehavior() {
        this.f1258b = 0;
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, (CoordinatorLayout) v, i);
        if (this.f1257a == null) {
            this.f1257a = new f(v);
        }
        this.f1257a.c();
        int i2 = this.f1258b;
        if (i2 != 0) {
            this.f1257a.b(i2);
            this.f1258b = 0;
        }
        int i3 = this.c;
        if (i3 != 0) {
            this.f1257a.a(i3);
            this.c = 0;
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.c(v, i);
    }

    public int b() {
        f fVar = this.f1257a;
        if (fVar != null) {
            return fVar.b();
        }
        return 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1258b = 0;
        this.c = 0;
    }

    public boolean a(int i) {
        f fVar = this.f1257a;
        if (fVar != null) {
            return fVar.b(i);
        }
        this.f1258b = i;
        return false;
    }
}
