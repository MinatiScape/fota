package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.M;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public class E implements M.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f760a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(RecyclerView.i iVar) {
        this.f760a = iVar;
    }

    @Override // androidx.recyclerview.widget.M.b
    public View a(int i) {
        return this.f760a.c(i);
    }

    @Override // androidx.recyclerview.widget.M.b
    public int b() {
        return this.f760a.h() - this.f760a.m();
    }

    @Override // androidx.recyclerview.widget.M.b
    public int a() {
        return this.f760a.p();
    }

    @Override // androidx.recyclerview.widget.M.b
    public int a(View view) {
        return this.f760a.j(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.M.b
    public int b(View view) {
        return this.f760a.e(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }
}
