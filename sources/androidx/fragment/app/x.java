package androidx.fragment.app;

import java.util.ArrayList;
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ArrayList arrayList) {
        this.f661a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        B.a(this.f661a, 4);
    }
}
