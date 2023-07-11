package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class va {

    /* renamed from: a  reason: collision with root package name */
    private static final za f991a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f992b;
    private static boolean c;
    static final Property<View, Float> d;
    static final Property<View, Rect> e;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            f991a = new ya();
        } else if (i >= 21) {
            f991a = new xa();
        } else if (i >= 19) {
            f991a = new wa();
        } else {
            f991a = new za();
        }
        d = new ta(Float.class, "translationAlpha");
        e = new ua(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, float f) {
        f991a.a(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static sa b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ra(view);
        }
        return qa.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return f991a.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Ea d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new Da(view);
        }
        return new Ca(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        f991a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        f991a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, Matrix matrix) {
        f991a.c(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i) {
        a();
        Field field = f992b;
        if (field != null) {
            try {
                f992b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view, Matrix matrix) {
        f991a.b(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, Matrix matrix) {
        f991a.a(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i, int i2, int i3, int i4) {
        f991a.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (c) {
            return;
        }
        try {
            f992b = View.class.getDeclaredField("mViewFlags");
            f992b.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        c = true;
    }
}
