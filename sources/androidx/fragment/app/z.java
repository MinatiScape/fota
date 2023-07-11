package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f664a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fragment f665b;
    final /* synthetic */ boolean c;
    final /* synthetic */ a.b.b d;
    final /* synthetic */ View e;
    final /* synthetic */ K f;
    final /* synthetic */ Rect g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Fragment fragment, Fragment fragment2, boolean z, a.b.b bVar, View view, K k, Rect rect) {
        this.f664a = fragment;
        this.f665b = fragment2;
        this.c = z;
        this.d = bVar;
        this.e = view;
        this.f = k;
        this.g = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        B.a(this.f664a, this.f665b, this.c, (a.b.b<String, View>) this.d, false);
        View view = this.e;
        if (view != null) {
            this.f.a(view, this.g);
        }
    }
}
