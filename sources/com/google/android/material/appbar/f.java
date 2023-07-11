package com.google.android.material.appbar;

import android.view.View;
import androidx.core.h.t;
/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private final View f1264a;

    /* renamed from: b  reason: collision with root package name */
    private int f1265b;
    private int c;
    private int d;
    private int e;

    public f(View view) {
        this.f1264a = view;
    }

    private void d() {
        View view = this.f1264a;
        t.b(view, this.d - (view.getTop() - this.f1265b));
        View view2 = this.f1264a;
        t.a(view2, this.e - (view2.getLeft() - this.c));
    }

    public boolean a(int i) {
        if (this.e != i) {
            this.e = i;
            d();
            return true;
        }
        return false;
    }

    public boolean b(int i) {
        if (this.d != i) {
            this.d = i;
            d();
            return true;
        }
        return false;
    }

    public void c() {
        this.f1265b = this.f1264a.getTop();
        this.c = this.f1264a.getLeft();
        d();
    }

    public int a() {
        return this.f1265b;
    }

    public int b() {
        return this.d;
    }
}
