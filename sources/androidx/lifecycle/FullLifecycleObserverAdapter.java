package androidx.lifecycle;

import androidx.lifecycle.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements e {

    /* renamed from: a  reason: collision with root package name */
    private final b f669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(b bVar) {
        this.f669a = bVar;
    }

    @Override // androidx.lifecycle.e
    public void a(h hVar, f.a aVar) {
        switch (c.f684a[aVar.ordinal()]) {
            case 1:
                this.f669a.a(hVar);
                return;
            case 2:
                this.f669a.f(hVar);
                return;
            case 3:
                this.f669a.b(hVar);
                return;
            case 4:
                this.f669a.c(hVar);
                return;
            case 5:
                this.f669a.d(hVar);
                return;
            case 6:
                this.f669a.e(hVar);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
