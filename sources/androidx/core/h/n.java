package androidx.core.h;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f532a;

    /* renamed from: b  reason: collision with root package name */
    private int f533b;

    public n(ViewGroup viewGroup) {
        this.f532a = viewGroup;
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        this.f533b = i;
    }

    public int a() {
        return this.f533b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i) {
        this.f533b = 0;
    }
}
