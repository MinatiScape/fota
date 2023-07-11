package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerView.java */
/* loaded from: classes.dex */
public class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(RecyclerView recyclerView) {
        this.f865a = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView.f fVar = this.f865a.W;
        if (fVar != null) {
            fVar.i();
        }
        this.f865a.wa = false;
    }
}
