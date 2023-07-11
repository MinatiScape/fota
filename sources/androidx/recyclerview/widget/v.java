package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public class v extends w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public v(RecyclerView.i iVar) {
        super(iVar, null);
    }

    @Override // androidx.recyclerview.widget.w
    public int a() {
        return this.f862a.h();
    }

    @Override // androidx.recyclerview.widget.w
    public int b() {
        return this.f862a.h() - this.f862a.m();
    }

    @Override // androidx.recyclerview.widget.w
    public int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f862a.h(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int d(View view) {
        return this.f862a.j(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int e(View view) {
        this.f862a.a(view, true, this.c);
        return this.c.bottom;
    }

    @Override // androidx.recyclerview.widget.w
    public int f() {
        return this.f862a.p();
    }

    @Override // androidx.recyclerview.widget.w
    public int g() {
        return (this.f862a.h() - this.f862a.p()) - this.f862a.m();
    }

    @Override // androidx.recyclerview.widget.w
    public void a(int i) {
        this.f862a.e(i);
    }

    @Override // androidx.recyclerview.widget.w
    public int b(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f862a.g(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int f(View view) {
        this.f862a.a(view, true, this.c);
        return this.c.top;
    }

    @Override // androidx.recyclerview.widget.w
    public int a(View view) {
        return this.f862a.e(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.w
    public int c() {
        return this.f862a.m();
    }

    @Override // androidx.recyclerview.widget.w
    public int d() {
        return this.f862a.i();
    }

    @Override // androidx.recyclerview.widget.w
    public int e() {
        return this.f862a.r();
    }
}
