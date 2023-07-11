package androidx.core.f;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f480a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f481b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                f481b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f480a = cls.getMethod("getScript", String.class);
                f481b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e2) {
            f480a = null;
            f481b = null;
            Log.w("ICUCompat", e2);
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f481b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String b2 = b(locale);
        if (b2 != null) {
            return a(b2);
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f481b != null) {
                return (String) f481b.invoke(null, locale2);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return locale2;
    }

    private static String a(String str) {
        try {
            if (f480a != null) {
                return (String) f480a.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }
}
