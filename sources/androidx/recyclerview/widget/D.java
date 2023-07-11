package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.M;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public class D implements M.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(RecyclerView.i iVar) {
        this.f759a = iVar;
    }

    @Override // androidx.recyclerview.widget.M.b
    public View a(int i) {
        return this.f759a.c(i);
    }

    @Override // androidx.recyclerview.widget.M.b
    public int b() {
        return this.f759a.q() - this.f759a.o();
    }

    @Override // androidx.recyclerview.widget.M.b
    public int a() {
        return this.f759a.n();
    }

    @Override // androidx.recyclerview.widget.M.b
    public int b(View view) {
        return this.f759a.i(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.M.b
    public int a(View view) {
        return this.f759a.f(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }
}
