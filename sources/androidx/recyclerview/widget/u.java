package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public class u extends w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(RecyclerView.i iVar) {
        super(iVar, null);
    }

    @Override // androidx.recyclerview.widget.w
    public int a() {
        return this.f862a.q();
    }

    @Override // androidx.recyclerview.widget.w
    public int b() {
        return this.f862a.q() - this.f862a.o();
    }

    @Override // androidx.recyclerview.widget.w
    public int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f862a.g(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int d(View view) {
        return this.f862a.f(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int e(View view) {
        this.f862a.a(view, true, this.c);
        return this.c.right;
    }

    @Override // androidx.recyclerview.widget.w
    public int f() {
        return this.f862a.n();
    }

    @Override // androidx.recyclerview.widget.w
    public int g() {
        return (this.f862a.q() - this.f862a.n()) - this.f862a.o();
    }

    @Override // androidx.recyclerview.widget.w
    public void a(int i) {
        this.f862a.d(i);
    }

    @Override // androidx.recyclerview.widget.w
    public int b(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f862a.h(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int f(View view) {
        this.f862a.a(view, true, this.c);
        return this.c.left;
    }

    @Override // androidx.recyclerview.widget.w
    public int a(View view) {
        return this.f862a.i(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int c() {
        return this.f862a.o();
    }

    @Override // androidx.recyclerview.widget.w
    public int d() {
        return this.f862a.r();
    }

    @Override // androidx.recyclerview.widget.w
    public int e() {
        return this.f862a.i();
    }
}
