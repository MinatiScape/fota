package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
/* compiled from: VersionedParcel.java */
/* loaded from: classes.dex */
public abstract class b {
    private void c(d dVar) {
        try {
            a(a((Class<? extends d>) dVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(dVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public int a(int i, int i2) {
        return !a(i2) ? i : e();
    }

    protected abstract void a();

    protected abstract void a(Parcelable parcelable);

    protected abstract void a(String str);

    public void a(boolean z, boolean z2) {
    }

    protected abstract void a(byte[] bArr);

    protected abstract boolean a(int i);

    protected abstract b b();

    protected abstract void b(int i);

    public void b(byte[] bArr, int i) {
        b(i);
        a(bArr);
    }

    protected abstract void c(int i);

    public boolean c() {
        return false;
    }

    protected abstract byte[] d();

    protected abstract int e();

    protected abstract <T extends Parcelable> T f();

    protected abstract String g();

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends d> T h() {
        String g = g();
        if (g == null) {
            return null;
        }
        return (T) a(g, b());
    }

    public String a(String str, int i) {
        return !a(i) ? str : g();
    }

    public void b(int i, int i2) {
        b(i2);
        c(i);
    }

    public byte[] a(byte[] bArr, int i) {
        return !a(i) ? bArr : d();
    }

    public void b(String str, int i) {
        b(i);
        a(str);
    }

    public <T extends Parcelable> T a(T t, int i) {
        return !a(i) ? t : (T) f();
    }

    public void b(Parcelable parcelable, int i) {
        b(i);
        a(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        if (dVar == null) {
            a((String) null);
            return;
        }
        c(dVar);
        b b2 = b();
        a(dVar, b2);
        b2.a();
    }

    public void b(d dVar, int i) {
        b(i);
        a(dVar);
    }

    private static <T extends d> Class b(T t) throws ClassNotFoundException {
        return a((Class<? extends d>) t.getClass());
    }

    public <T extends d> T a(T t, int i) {
        return !a(i) ? t : (T) h();
    }

    protected static <T extends d> T a(String str, b bVar) {
        try {
            return (T) Class.forName(str, true, b.class.getClassLoader()).getDeclaredMethod("read", b.class).invoke(null, bVar);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    protected static <T extends d> void a(T t, b bVar) {
        try {
            b(t).getDeclaredMethod("write", t.getClass(), b.class).invoke(null, t, bVar);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    private static Class a(Class<? extends d> cls) throws ClassNotFoundException {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }
}
