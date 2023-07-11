package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0097k;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.d  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0090d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f828a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0097k f829b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0090d(C0097k c0097k, ArrayList arrayList) {
        this.f829b = c0097k;
        this.f828a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f828a.iterator();
        while (it.hasNext()) {
            this.f829b.a((C0097k.a) it.next());
        }
        this.f828a.clear();
        this.f829b.o.remove(this.f828a);
    }
}
