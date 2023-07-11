package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.customview.a.g;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    g f1269a;

    /* renamed from: b  reason: collision with root package name */
    a f1270b;
    private boolean c;
    private boolean e;
    private float d = 0.0f;
    int f = 2;
    float g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final g.a j = new com.google.android.material.behavior.b(this);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);

        void a(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f1271a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1272b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(View view, boolean z) {
            this.f1271a = view;
            this.f1272b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            g gVar = SwipeDismissBehavior.this.f1269a;
            if (gVar != null && gVar.a(true)) {
                t.a(this.f1271a, this);
            } else if (!this.f1272b || (aVar = SwipeDismissBehavior.this.f1270b) == null) {
            } else {
                aVar.a(this.f1271a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public void a(int i) {
        this.f = i;
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f) {
        this.h = a(0.0f, f, 1.0f);
    }

    public void setListener(a aVar) {
        this.f1270b = aVar;
    }

    public void a(float f) {
        this.i = a(0.0f, f, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        g gVar = this.f1269a;
        if (gVar != null) {
            gVar.a(motionEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c = coordinatorLayout.a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
        }
        if (z) {
            a((ViewGroup) coordinatorLayout);
            return this.f1269a.b(motionEvent);
        }
        return false;
    }

    private void a(ViewGroup viewGroup) {
        g a2;
        if (this.f1269a == null) {
            if (this.e) {
                a2 = g.a(viewGroup, this.d, this.j);
            } else {
                a2 = g.a(viewGroup, this.j);
            }
            this.f1269a = a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
