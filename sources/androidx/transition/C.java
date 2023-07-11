package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: GhostViewApi21.java */
/* loaded from: classes.dex */
class C implements D {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f904a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f905b;
    private static Method c;
    private static boolean d;
    private static Method e;
    private static boolean f;
    private final View g;

    private C(View view) {
        this.g = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static D a(View view, ViewGroup viewGroup, Matrix matrix) {
        a();
        Method method = c;
        if (method != null) {
            try {
                return new C((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void b() {
        if (f905b) {
            return;
        }
        try {
            f904a = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        f905b = true;
    }

    private static void c() {
        if (f) {
            return;
        }
        try {
            b();
            e = f904a.getDeclaredMethod("removeGhost", View.class);
            e.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        f = true;
    }

    @Override // androidx.transition.D
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.transition.D
    public void setVisibility(int i) {
        this.g.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        c();
        Method method = e;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private static void a() {
        if (d) {
            return;
        }
        try {
            b();
            c = f904a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            c.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        d = true;
    }
}
