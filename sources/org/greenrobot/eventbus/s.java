package org.greenrobot.eventbus;
/* compiled from: Subscription.java */
/* loaded from: classes.dex */
final class s {

    /* renamed from: a  reason: collision with root package name */
    final Object f1522a;

    /* renamed from: b  reason: collision with root package name */
    final q f1523b;
    volatile boolean c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Object obj, q qVar) {
        this.f1522a = obj;
        this.f1523b = qVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f1522a == sVar.f1522a && this.f1523b.equals(sVar.f1523b);
        }
        return false;
    }

    public int hashCode() {
        return this.f1522a.hashCode() + this.f1523b.f.hashCode();
    }
}
