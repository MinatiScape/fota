package androidx.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewGroupUtilsApi18.java */
/* loaded from: classes.dex */
class pa {

    /* renamed from: a  reason: collision with root package name */
    private static Method f977a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f978b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, boolean z) {
        a();
        Method method = f977a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    private static void a() {
        if (f978b) {
            return;
        }
        try {
            f977a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f977a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
        }
        f978b = true;
    }
}
