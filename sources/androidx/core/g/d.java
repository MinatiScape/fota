package androidx.core.g;
/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f499a;

    /* renamed from: b  reason: collision with root package name */
    public final S f500b;

    public d(F f, S s) {
        this.f499a = f;
        this.f500b = s;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return c.a(dVar.f499a, this.f499a) && c.a(dVar.f500b, this.f500b);
        }
        return false;
    }

    public int hashCode() {
        F f = this.f499a;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f500b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f499a) + " " + String.valueOf(this.f500b) + "}";
    }
}
