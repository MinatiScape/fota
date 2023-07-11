package androidx.lifecycle;

import java.util.HashMap;
/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, r> f698a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, r rVar) {
        r put = this.f698a.put(str, rVar);
        if (put != null) {
            put.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final r a(String str) {
        return this.f698a.get(str);
    }

    public final void a() {
        for (r rVar : this.f698a.values()) {
            rVar.a();
        }
        this.f698a.clear();
    }
}
