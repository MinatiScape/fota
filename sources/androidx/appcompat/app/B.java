package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;
/* compiled from: ResourcesFlusher.java */
/* loaded from: classes.dex */
class B {

    /* renamed from: a  reason: collision with root package name */
    private static Field f71a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f72b;
    private static Class c;
    private static boolean d;
    private static Field e;
    private static boolean f;
    private static Field g;
    private static boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            d(resources);
        } else if (i >= 23) {
            c(resources);
        } else if (i >= 21) {
            b(resources);
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f72b) {
            try {
                f71a = Resources.class.getDeclaredField("mDrawableCache");
                f71a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f72b = true;
        }
        Field field = f71a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f72b) {
            try {
                f71a = Resources.class.getDeclaredField("mDrawableCache");
                f71a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f72b = true;
        }
        Object obj = null;
        Field field = f71a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj == null) {
            return;
        }
        a(obj);
    }

    private static void d(Resources resources) {
        Object obj;
        if (!h) {
            try {
                g = Resources.class.getDeclaredField("mResourcesImpl");
                g.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            h = true;
        }
        Field field = g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f72b) {
            try {
                f71a = obj.getClass().getDeclaredField("mDrawableCache");
                f71a.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f72b = true;
        }
        Field field2 = f71a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (obj2 != null) {
            a(obj2);
        }
    }

    private static void a(Object obj) {
        LongSparseArray longSparseArray;
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            d = true;
        }
        Class cls = c;
        if (cls == null) {
            return;
        }
        if (!f) {
            try {
                e = cls.getDeclaredField("mUnthemedEntries");
                e.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f = true;
        }
        Field field = e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
