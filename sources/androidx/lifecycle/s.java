package androidx.lifecycle;
/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f696a;

    /* renamed from: b  reason: collision with root package name */
    private final t f697b;

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public interface a {
        <T extends r> T a(Class<T> cls);
    }

    public s(t tVar, a aVar) {
        this.f696a = aVar;
        this.f697b = tVar;
    }

    public <T extends r> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends r> T a(String str, Class<T> cls) {
        T t = (T) this.f697b.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f696a.a(cls);
        this.f697b.a(str, t2);
        return t2;
    }
}
