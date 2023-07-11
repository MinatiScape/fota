package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import androidx.core.h.t;
import androidx.customview.a.g;
import com.google.android.material.behavior.SwipeDismissBehavior;
/* compiled from: SwipeDismissBehavior.java */
/* loaded from: classes.dex */
class b extends g.a {

    /* renamed from: a  reason: collision with root package name */
    private int f1274a;

    /* renamed from: b  reason: collision with root package name */
    private int f1275b = -1;
    final /* synthetic */ SwipeDismissBehavior c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SwipeDismissBehavior swipeDismissBehavior) {
        this.c = swipeDismissBehavior;
    }

    @Override // androidx.customview.a.g.a
    public void a(View view, int i) {
        this.f1275b = i;
        this.f1274a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // androidx.customview.a.g.a
    public boolean b(View view, int i) {
        return this.f1275b == -1 && this.c.a(view);
    }

    @Override // androidx.customview.a.g.a
    public void c(int i) {
        SwipeDismissBehavior.a aVar = this.c.f1270b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // androidx.customview.a.g.a
    public int b(View view, int i, int i2) {
        return view.getTop();
    }

    @Override // androidx.customview.a.g.a
    public void a(View view, float f, float f2) {
        int i;
        boolean z;
        SwipeDismissBehavior.a aVar;
        this.f1275b = -1;
        int width = view.getWidth();
        if (a(view, f)) {
            int left = view.getLeft();
            int i2 = this.f1274a;
            i = left < i2 ? i2 - width : i2 + width;
            z = true;
        } else {
            i = this.f1274a;
            z = false;
        }
        if (this.c.f1269a.d(i, view.getTop())) {
            t.a(view, new SwipeDismissBehavior.b(view, z));
        } else if (!z || (aVar = this.c.f1270b) == null) {
        } else {
            aVar.a(view);
        }
    }

    private boolean a(View view, float f) {
        if (f == 0.0f) {
            return Math.abs(view.getLeft() - this.f1274a) >= Math.round(((float) view.getWidth()) * this.c.g);
        }
        boolean z = t.k(view) == 1;
        int i = this.c.f;
        if (i == 2) {
            return true;
        }
        if (i == 0) {
            if (z) {
                if (f >= 0.0f) {
                    return false;
                }
            } else if (f <= 0.0f) {
                return false;
            }
            return true;
        } else if (i == 1) {
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.customview.a.g.a
    public int a(View view) {
        return view.getWidth();
    }

    @Override // androidx.customview.a.g.a
    public int a(View view, int i, int i2) {
        int width;
        int width2;
        int width3;
        boolean z = t.k(view) == 1;
        int i3 = this.c.f;
        if (i3 == 0) {
            if (z) {
                width = this.f1274a - view.getWidth();
                width2 = this.f1274a;
            } else {
                width = this.f1274a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i3 != 1) {
            width = this.f1274a - view.getWidth();
            width2 = view.getWidth() + this.f1274a;
        } else if (z) {
            width = this.f1274a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f1274a - view.getWidth();
            width2 = this.f1274a;
        }
        return SwipeDismissBehavior.a(width, i, width2);
    }

    @Override // androidx.customview.a.g.a
    public void a(View view, int i, int i2, int i3, int i4) {
        float width = this.f1274a + (view.getWidth() * this.c.h);
        float width2 = this.f1274a + (view.getWidth() * this.c.i);
        float f = i;
        if (f <= width) {
            view.setAlpha(1.0f);
        } else if (f >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f), 1.0f));
        }
    }
}
