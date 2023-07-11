package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
/* compiled from: FastScroller.java */
/* renamed from: androidx.recyclerview.widget.m  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0099m extends RecyclerView.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0100n f847a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0099m(C0100n c0100n) {
        this.f847a = c0100n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.f847a.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
