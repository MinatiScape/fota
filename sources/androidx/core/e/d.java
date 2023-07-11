package androidx.core.e;

import androidx.core.e.f;
import androidx.core.e.k;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class d implements k.a<f.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.f456a = str;
    }

    @Override // androidx.core.e.k.a
    public void a(f.c cVar) {
        synchronized (f.c) {
            ArrayList<k.a<f.c>> arrayList = f.d.get(this.f456a);
            if (arrayList == null) {
                return;
            }
            f.d.remove(this.f456a);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).a(cVar);
            }
        }
    }
}
