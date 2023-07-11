package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.B;
import java.util.ArrayList;
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f586a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a.b.b f587b;
    final /* synthetic */ Object c;
    final /* synthetic */ B.a d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ View f;
    final /* synthetic */ Fragment g;
    final /* synthetic */ Fragment h;
    final /* synthetic */ boolean i;
    final /* synthetic */ ArrayList j;
    final /* synthetic */ Object k;
    final /* synthetic */ Rect l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(K k, a.b.b bVar, Object obj, B.a aVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f586a = k;
        this.f587b = bVar;
        this.c = obj;
        this.d = aVar;
        this.e = arrayList;
        this.f = view;
        this.g = fragment;
        this.h = fragment2;
        this.i = z;
        this.j = arrayList2;
        this.k = obj2;
        this.l = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b.b<String, View> a2 = B.a(this.f586a, this.f587b, this.c, this.d);
        if (a2 != null) {
            this.e.addAll(a2.values());
            this.e.add(this.f);
        }
        B.a(this.g, this.h, this.i, a2, false);
        Object obj = this.c;
        if (obj != null) {
            this.f586a.b(obj, this.j, this.e);
            View a3 = B.a(a2, this.d, this.k, this.i);
            if (a3 != null) {
                this.f586a.a(a3, this.l);
            }
        }
    }
}
