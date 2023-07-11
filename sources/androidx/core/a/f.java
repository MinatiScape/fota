package androidx.core.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.a.c;
import androidx.core.e.f;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: a  reason: collision with root package name */
    protected final Class f406a;

    /* renamed from: b  reason: collision with root package name */
    protected final Constructor f407b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public f() {
        Method method;
        Constructor constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class cls = null;
        try {
            Class a2 = a();
            constructor = e(a2);
            method2 = b(a2);
            method3 = c(a2);
            method4 = f(a2);
            method5 = a(a2);
            method = d(a2);
            cls = a2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f406a = cls;
        this.f407b = constructor;
        this.c = method2;
        this.d = method3;
        this.e = method4;
        this.f = method5;
        this.g = method;
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean b() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    private Object c() {
        try {
            return this.f407b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Method d(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Constructor e(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method f(Class cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    private boolean c(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void b(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Method b(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method c(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f406a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.core.a.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0008c[] a2;
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object c = c();
        for (c.C0008c c0008c : bVar.a()) {
            if (!a(context, c, c0008c.a(), c0008c.c(), c0008c.e(), c0008c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0008c.d()))) {
                b(c);
                return null;
            }
        }
        if (c(c)) {
            return a(c);
        }
        return null;
    }

    @Override // androidx.core.a.d, androidx.core.a.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        if (bVarArr.length < 1) {
            return null;
        }
        if (!b()) {
            f.b a2 = a(bVarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.c(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.d()).setItalic(a2.e()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a3 = androidx.core.e.f.a(context, bVarArr, cancellationSignal);
        Object c = c();
        boolean z = false;
        for (f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = a3.get(bVar.c());
            if (byteBuffer != null) {
                if (!a(c, byteBuffer, bVar.b(), bVar.d(), bVar.e() ? 1 : 0)) {
                    b(c);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            b(c);
            return null;
        } else if (c(c)) {
            return Typeface.create(a(c), i);
        } else {
            return null;
        }
    }

    @Override // androidx.core.a.j
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c = c();
        if (!a(context, c, str, 0, -1, -1, null)) {
            b(c);
            return null;
        } else if (c(c)) {
            return a(c);
        } else {
            return null;
        }
    }

    protected Class a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Method a(Class cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
