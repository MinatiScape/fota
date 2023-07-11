package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.a.c;
import androidx.core.e.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class e extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f404a;

    /* renamed from: b  reason: collision with root package name */
    private static final Constructor f405b;
    private static final Method c;
    private static final Method d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f405b = constructor;
        f404a = cls;
        c = method2;
        d = method;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return f405b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f404a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.core.a.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        Object b2 = b();
        a.b.i iVar = new a.b.i();
        for (f.b bVar : bVarArr) {
            Uri c2 = bVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) iVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = k.a(context, cancellationSignal, c2);
                iVar.put(c2, byteBuffer);
            }
            if (!a(b2, byteBuffer, bVar.b(), bVar.d(), bVar.e())) {
                return null;
            }
        }
        return Typeface.create(a(b2), i);
    }

    @Override // androidx.core.a.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0008c[] a2;
        Object b2 = b();
        for (c.C0008c c0008c : bVar.a()) {
            ByteBuffer a3 = k.a(context, resources, c0008c.b());
            if (a3 == null || !a(b2, a3, c0008c.c(), c0008c.e(), c0008c.f())) {
                return null;
            }
        }
        return a(b2);
    }
}
