package androidx.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class wa extends za {

    /* renamed from: b  reason: collision with root package name */
    private static Method f995b;
    private static boolean c;
    private static Method d;
    private static boolean e;

    @Override // androidx.transition.za
    public void a(View view) {
    }

    @Override // androidx.transition.za
    public void a(View view, float f) {
        b();
        Method method = f995b;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        view.setAlpha(f);
    }

    @Override // androidx.transition.za
    public float b(View view) {
        a();
        Method method = d;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.b(view);
    }

    @Override // androidx.transition.za
    public void c(View view) {
    }

    private void a() {
        if (e) {
            return;
        }
        try {
            d = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            d.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
        }
        e = true;
    }

    private void b() {
        if (c) {
            return;
        }
        try {
            f995b = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f995b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
        }
        c = true;
    }
}
