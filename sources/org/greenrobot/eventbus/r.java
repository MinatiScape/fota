package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriberMethodFinder.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, List<q>> f1518a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final a[] f1519b = new a[4];
    private List<org.greenrobot.eventbus.a.b> c;
    private final boolean d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(List<org.greenrobot.eventbus.a.b> list, boolean z, boolean z2) {
        this.c = list;
        this.d = z;
        this.e = z2;
    }

    private List<q> b(Class<?> cls) {
        q[] a2;
        a a3 = a();
        a3.a(cls);
        while (a3.f != null) {
            a3.h = c(a3);
            org.greenrobot.eventbus.a.a aVar = a3.h;
            if (aVar != null) {
                for (q qVar : aVar.a()) {
                    if (a3.a(qVar.f1516a, qVar.c)) {
                        a3.f1520a.add(qVar);
                    }
                }
            } else {
                a(a3);
            }
            a3.a();
        }
        return b(a3);
    }

    private org.greenrobot.eventbus.a.a c(a aVar) {
        org.greenrobot.eventbus.a.a aVar2 = aVar.h;
        if (aVar2 != null && aVar2.c() != null) {
            org.greenrobot.eventbus.a.a c = aVar.h.c();
            if (aVar.f == c.b()) {
                return c;
            }
        }
        List<org.greenrobot.eventbus.a.b> list = this.c;
        if (list != null) {
            for (org.greenrobot.eventbus.a.b bVar : list) {
                org.greenrobot.eventbus.a.a a2 = bVar.a(aVar.f);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<q> a(Class<?> cls) {
        List<q> b2;
        List<q> list = f1518a.get(cls);
        if (list != null) {
            return list;
        }
        if (this.e) {
            b2 = c(cls);
        } else {
            b2 = b(cls);
        }
        if (!b2.isEmpty()) {
            f1518a.put(cls, b2);
            return b2;
        }
        throw new g("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriberMethodFinder.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<q> f1520a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f1521b = new HashMap();
        final Map<String, Class> c = new HashMap();
        final StringBuilder d = new StringBuilder((int) CpioConstants.C_IWUSR);
        Class<?> e;
        Class<?> f;
        boolean g;
        org.greenrobot.eventbus.a.a h;

        a() {
        }

        void a(Class<?> cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        void b() {
            this.f1520a.clear();
            this.f1521b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }

        boolean a(Method method, Class<?> cls) {
            Object put = this.f1521b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f1521b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(sb2, put);
            return false;
        }

        void a() {
            if (this.g) {
                this.f = null;
                return;
            }
            this.f = this.f.getSuperclass();
            String name = this.f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f = null;
            }
        }
    }

    private List<q> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f != null) {
            a(a2);
            a2.a();
        }
        return b(a2);
    }

    private a a() {
        synchronized (f1519b) {
            for (int i = 0; i < 4; i++) {
                a aVar = f1519b[i];
                if (aVar != null) {
                    f1519b[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private List<q> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f1520a);
        aVar.b();
        synchronized (f1519b) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (f1519b[i] == null) {
                    f1519b[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private void a(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f.getMethods();
            aVar.g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    o oVar = (o) method.getAnnotation(o.class);
                    if (oVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f1520a.add(new q(method, cls, oVar.threadMode(), oVar.priority(), oVar.sticky()));
                        }
                    }
                } else if (this.d && method.isAnnotationPresent(o.class)) {
                    throw new g("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.d && method.isAnnotationPresent(o.class)) {
                throw new g((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }
}
