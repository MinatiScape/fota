package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0097k;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0089c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f826a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0097k f827b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0089c(C0097k c0097k, ArrayList arrayList) {
        this.f827b = c0097k;
        this.f826a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f826a.iterator();
        while (it.hasNext()) {
            C0097k.b bVar = (C0097k.b) it.next();
            this.f827b.b(bVar.f844a, bVar.f845b, bVar.c, bVar.d, bVar.e);
        }
        this.f826a.clear();
        this.f827b.n.remove(this.f826a);
    }
}
