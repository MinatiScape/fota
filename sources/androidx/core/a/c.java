package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.a.c;
import androidx.core.content.a.h;
import androidx.core.e.f;
/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final j f402a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.b.g<String, Typeface> f403b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            f402a = new g();
        } else if (i >= 26) {
            f402a = new f();
        } else if (i >= 24 && e.a()) {
            f402a = new e();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f402a = new d();
        } else {
            f402a = new j();
        }
        f403b = new a.b.g<>(16);
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return f403b.b(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, h.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            a2 = androidx.core.e.f.a(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = f402a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            f403b.a(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = f402a.a(context, resources, i, str, i2);
        if (a2 != null) {
            f403b.a(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        return f402a.a(context, cancellationSignal, bVarArr, i);
    }
}
