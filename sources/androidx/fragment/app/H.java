package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransitionImpl.java */
/* loaded from: classes.dex */
public class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f618a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f619b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ K f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(K k, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f = k;
        this.f618a = i;
        this.f619b = arrayList;
        this.c = arrayList2;
        this.d = arrayList3;
        this.e = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f618a; i++) {
            androidx.core.h.t.a((View) this.f619b.get(i), (String) this.c.get(i));
            androidx.core.h.t.a((View) this.d.get(i), (String) this.e.get(i));
        }
    }
}
