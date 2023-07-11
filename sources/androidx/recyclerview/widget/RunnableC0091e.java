package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.e  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0091e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f830a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0097k f831b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0091e(C0097k c0097k, ArrayList arrayList) {
        this.f831b = c0097k;
        this.f830a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f830a.iterator();
        while (it.hasNext()) {
            this.f831b.t((RecyclerView.v) it.next());
        }
        this.f830a.clear();
        this.f831b.m.remove(this.f830a);
    }
}
