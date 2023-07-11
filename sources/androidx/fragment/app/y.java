package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f662a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ K f663b;
    final /* synthetic */ View c;
    final /* synthetic */ Fragment d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ ArrayList g;
    final /* synthetic */ Object h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Object obj, K k, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f662a = obj;
        this.f663b = k;
        this.c = view;
        this.d = fragment;
        this.e = arrayList;
        this.f = arrayList2;
        this.g = arrayList3;
        this.h = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.f662a;
        if (obj != null) {
            this.f663b.b(obj, this.c);
            this.f.addAll(B.a(this.f663b, this.f662a, this.d, this.e, this.c));
        }
        if (this.g != null) {
            if (this.h != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.c);
                this.f663b.a(this.h, this.g, arrayList);
            }
            this.g.clear();
            this.g.add(this.c);
        }
    }
}
