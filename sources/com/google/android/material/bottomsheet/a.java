package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.h.t;
import androidx.customview.a.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
/* compiled from: BottomSheetBehavior.java */
/* loaded from: classes.dex */
class a extends g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f1301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f1301a = bottomSheetBehavior;
    }

    @Override // androidx.customview.a.g.a
    public void a(View view, int i, int i2, int i3, int i4) {
        this.f1301a.a(i2);
    }

    @Override // androidx.customview.a.g.a
    public boolean b(View view, int i) {
        WeakReference<V> weakReference;
        View view2;
        BottomSheetBehavior bottomSheetBehavior = this.f1301a;
        int i2 = bottomSheetBehavior.l;
        if (i2 == 1 || bottomSheetBehavior.x) {
            return false;
        }
        return ((i2 == 3 && bottomSheetBehavior.v == i && (view2 = bottomSheetBehavior.s.get()) != null && view2.canScrollVertically(-1)) || (weakReference = this.f1301a.r) == 0 || weakReference.get() != view) ? false : true;
    }

    @Override // androidx.customview.a.g.a
    public void c(int i) {
        if (i == 1) {
            this.f1301a.c(1);
        }
    }

    @Override // androidx.customview.a.g.a
    public void a(View view, float f, float f2) {
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4 = 4;
        if (f2 < 0.0f) {
            z2 = this.f1301a.f1297a;
            if (z2) {
                i3 = this.f1301a.g;
                i4 = 3;
            } else {
                int top = view.getTop();
                int i5 = this.f1301a.h;
                if (top > i5) {
                    i3 = i5;
                    i4 = 6;
                }
                i3 = 0;
                i4 = 3;
            }
        } else {
            BottomSheetBehavior bottomSheetBehavior = this.f1301a;
            if (bottomSheetBehavior.j && bottomSheetBehavior.a(view, f2) && (view.getTop() > this.f1301a.i || Math.abs(f) < Math.abs(f2))) {
                i3 = this.f1301a.q;
                i4 = 5;
            } else if (f2 != 0.0f && Math.abs(f) <= Math.abs(f2)) {
                i3 = this.f1301a.i;
            } else {
                int top2 = view.getTop();
                z = this.f1301a.f1297a;
                if (z) {
                    if (Math.abs(top2 - this.f1301a.g) < Math.abs(top2 - this.f1301a.i)) {
                        i3 = this.f1301a.g;
                        i4 = 3;
                    } else {
                        i = this.f1301a.i;
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior2 = this.f1301a;
                    int i6 = bottomSheetBehavior2.h;
                    if (top2 < i6) {
                        if (top2 >= Math.abs(top2 - bottomSheetBehavior2.i)) {
                            i2 = this.f1301a.h;
                        }
                        i3 = 0;
                        i4 = 3;
                    } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.f1301a.i)) {
                        i2 = this.f1301a.h;
                    } else {
                        i = this.f1301a.i;
                    }
                    i3 = i2;
                    i4 = 6;
                }
                i3 = i;
            }
        }
        if (this.f1301a.m.d(view.getLeft(), i3)) {
            this.f1301a.c(2);
            t.a(view, new BottomSheetBehavior.b(view, i4));
            return;
        }
        this.f1301a.c(i4);
    }

    @Override // androidx.customview.a.g.a
    public int b(View view, int i, int i2) {
        int c;
        c = this.f1301a.c();
        BottomSheetBehavior bottomSheetBehavior = this.f1301a;
        return androidx.core.c.a.a(i, c, bottomSheetBehavior.j ? bottomSheetBehavior.q : bottomSheetBehavior.i);
    }

    @Override // androidx.customview.a.g.a
    public int b(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f1301a;
        if (bottomSheetBehavior.j) {
            return bottomSheetBehavior.q;
        }
        return bottomSheetBehavior.i;
    }

    @Override // androidx.customview.a.g.a
    public int a(View view, int i, int i2) {
        return view.getLeft();
    }
}
