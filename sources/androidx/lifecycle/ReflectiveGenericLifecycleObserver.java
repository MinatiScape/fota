package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f674a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0018a f675b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f674a = obj;
        this.f675b = a.f678a.a(this.f674a.getClass());
    }

    @Override // androidx.lifecycle.e
    public void a(h hVar, f.a aVar) {
        this.f675b.a(hVar, aVar, this.f674a);
    }
}
