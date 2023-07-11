package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0058q;
import java.util.WeakHashMap;
/* compiled from: AppCompatResources.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f42a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0002a>> f43b = new WeakHashMap<>(0);
    private static final Object c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatResources.java */
    /* renamed from: androidx.appcompat.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f44a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f45b;

        C0002a(ColorStateList colorStateList, Configuration configuration) {
            this.f44a = colorStateList;
            this.f45b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList c2 = c(context, i);
        if (c2 != null) {
            return c2;
        }
        ColorStateList d = d(context, i);
        if (d != null) {
            a(context, i, d);
            return d;
        }
        return androidx.core.content.a.b(context, i);
    }

    public static Drawable b(Context context, int i) {
        return C0058q.a().a(context, i);
    }

    private static ColorStateList c(Context context, int i) {
        C0002a c0002a;
        synchronized (c) {
            SparseArray<C0002a> sparseArray = f43b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0002a = sparseArray.get(i)) != null) {
                if (c0002a.f45b.equals(context.getResources().getConfiguration())) {
                    return c0002a.f44a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static ColorStateList d(Context context, int i) {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.a.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static boolean e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        int i2 = a2.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (c) {
            SparseArray<C0002a> sparseArray = f43b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f43b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0002a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static TypedValue a() {
        TypedValue typedValue = f42a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f42a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
