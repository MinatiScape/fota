package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* compiled from: ExpandableWidgetHelper.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final View f1328a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1329b = false;
    private int c = 0;

    public c(b bVar) {
        this.f1328a = (View) bVar;
    }

    private void d() {
        ViewParent parent = this.f1328a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).a(this.f1328a);
        }
    }

    public void a(Bundle bundle) {
        this.f1329b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f1329b) {
            d();
        }
    }

    public boolean b() {
        return this.f1329b;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f1329b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void a(int i) {
        this.c = i;
    }

    public int a() {
        return this.c;
    }
}
