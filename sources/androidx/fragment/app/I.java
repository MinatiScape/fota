package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransitionImpl.java */
/* loaded from: classes.dex */
public class I implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f620a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f621b;
    final /* synthetic */ K c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(K k, ArrayList arrayList, Map map) {
        this.c = k;
        this.f620a = arrayList;
        this.f621b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f620a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f620a.get(i);
            String q = androidx.core.h.t.q(view);
            if (q != null) {
                androidx.core.h.t.a(view, K.a(this.f621b, q));
            }
        }
    }
}
