package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransitionImpl.java */
/* loaded from: classes.dex */
public class J implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f622a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f623b;
    final /* synthetic */ K c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(K k, ArrayList arrayList, Map map) {
        this.c = k;
        this.f622a = arrayList;
        this.f623b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f622a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f622a.get(i);
            androidx.core.h.t.a(view, (String) this.f623b.get(androidx.core.h.t.q(view)));
        }
    }
}
