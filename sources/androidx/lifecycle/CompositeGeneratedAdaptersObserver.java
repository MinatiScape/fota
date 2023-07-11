package androidx.lifecycle;

import androidx.lifecycle.f;
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final d[] f668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f668a = dVarArr;
    }

    @Override // androidx.lifecycle.e
    public void a(h hVar, f.a aVar) {
        n nVar = new n();
        for (d dVar : this.f668a) {
            dVar.a(hVar, aVar, false, nVar);
        }
        for (d dVar2 : this.f668a) {
            dVar2.a(hVar, aVar, true, nVar);
        }
    }
}
