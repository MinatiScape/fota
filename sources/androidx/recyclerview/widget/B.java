package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C0088b;
import androidx.recyclerview.widget.RecyclerView;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public class B implements C0088b.InterfaceC0022b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f757a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(RecyclerView recyclerView) {
        this.f757a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public int a() {
        return this.f757a.getChildCount();
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public void b() {
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            View a3 = a(i);
            this.f757a.b(a3);
            a3.clearAnimation();
        }
        this.f757a.removeAllViews();
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public int c(View view) {
        return this.f757a.indexOfChild(view);
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public void d(View view) {
        RecyclerView.v g = RecyclerView.g(view);
        if (g != null) {
            g.b(this.f757a);
        }
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public void a(View view, int i) {
        this.f757a.addView(view, i);
        this.f757a.a(view);
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public void c(int i) {
        View childAt = this.f757a.getChildAt(i);
        if (childAt != null) {
            this.f757a.b(childAt);
            childAt.clearAnimation();
        }
        this.f757a.removeViewAt(i);
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public View a(int i) {
        return this.f757a.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        RecyclerView.v g = RecyclerView.g(view);
        if (g != null) {
            if (!g.r() && !g.x()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + g + this.f757a.i());
            }
            g.d();
        }
        this.f757a.attachViewToParent(view, i, layoutParams);
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public RecyclerView.v b(View view) {
        return RecyclerView.g(view);
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public void b(int i) {
        RecyclerView.v g;
        View a2 = a(i);
        if (a2 != null && (g = RecyclerView.g(a2)) != null) {
            if (g.r() && !g.x()) {
                throw new IllegalArgumentException("called detach on an already detached child " + g + this.f757a.i());
            }
            g.a(CpioConstants.C_IRUSR);
        }
        this.f757a.detachViewFromParent(i);
    }

    @Override // androidx.recyclerview.widget.C0088b.InterfaceC0022b
    public void a(View view) {
        RecyclerView.v g = RecyclerView.g(view);
        if (g != null) {
            g.a(this.f757a);
        }
    }
}
