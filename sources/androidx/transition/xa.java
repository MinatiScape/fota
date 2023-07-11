package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class xa extends wa {
    private static Method f;
    private static boolean g;
    private static Method h;
    private static boolean i;
    private static Method j;
    private static boolean k;

    private void d() {
        if (g) {
            return;
        }
        try {
            f = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
        }
        g = true;
    }

    private void e() {
        if (i) {
            return;
        }
        try {
            h = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            h.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
        }
        i = true;
    }

    @Override // androidx.transition.za
    public void a(View view, Matrix matrix) {
        c();
        Method method = j;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getCause());
            } catch (InvocationTargetException unused) {
            }
        }
    }

    @Override // androidx.transition.za
    public void b(View view, Matrix matrix) {
        d();
        Method method = f;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // androidx.transition.za
    public void c(View view, Matrix matrix) {
        e();
        Method method = h;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private void c() {
        if (k) {
            return;
        }
        try {
            j = View.class.getDeclaredMethod("setAnimationMatrix", Matrix.class);
            j.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", e);
        }
        k = true;
    }
}
