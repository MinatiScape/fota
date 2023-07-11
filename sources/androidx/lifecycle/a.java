package androidx.lifecycle;

import androidx.lifecycle.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    static a f678a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, C0018a> f679b = new HashMap();
    private final Map<Class, Boolean> c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f682a;

        /* renamed from: b  reason: collision with root package name */
        final Method f683b;

        b(int i, Method method) {
            this.f682a = i;
            this.f683b = method;
            this.f683b.setAccessible(true);
        }

        void a(h hVar, f.a aVar, Object obj) {
            try {
                int i = this.f682a;
                if (i == 0) {
                    this.f683b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f683b.invoke(obj, hVar);
                } else if (i != 2) {
                } else {
                    this.f683b.invoke(obj, hVar, aVar);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f682a == bVar.f682a && this.f683b.getName().equals(bVar.f683b.getName());
        }

        public int hashCode() {
            return (this.f682a * 31) + this.f683b.getName().hashCode();
        }
    }

    a() {
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0018a a(Class cls) {
        C0018a c0018a = this.f679b.get(cls);
        return c0018a != null ? c0018a : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Class cls) {
        if (this.c.containsKey(cls)) {
            return this.c.get(cls).booleanValue();
        }
        Method[] c = c(cls);
        for (Method method : c) {
            if (((q) method.getAnnotation(q.class)) != null) {
                a(cls, c);
                return true;
            }
        }
        this.c.put(cls, false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a {

        /* renamed from: a  reason: collision with root package name */
        final Map<f.a, List<b>> f680a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, f.a> f681b;

        C0018a(Map<b, f.a> map) {
            this.f681b = map;
            for (Map.Entry<b, f.a> entry : map.entrySet()) {
                f.a value = entry.getValue();
                List<b> list = this.f680a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f680a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(h hVar, f.a aVar, Object obj) {
            a(this.f680a.get(aVar), hVar, aVar, obj);
            a(this.f680a.get(f.a.ON_ANY), hVar, aVar, obj);
        }

        private static void a(List<b> list, h hVar, f.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(hVar, aVar, obj);
                }
            }
        }
    }

    private void a(Map<b, f.a> map, b bVar, f.a aVar, Class cls) {
        f.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f683b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    private C0018a a(Class cls, Method[] methodArr) {
        int i;
        C0018a a2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (a2 = a(superclass)) != null) {
            hashMap.putAll(a2.f681b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, f.a> entry : a(cls2).f681b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            q qVar = (q) method.getAnnotation(q.class);
            if (qVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(h.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                f.a value = qVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(f.a.class)) {
                        if (value != f.a.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0018a c0018a = new C0018a(hashMap);
        this.f679b.put(cls, c0018a);
        this.c.put(cls, Boolean.valueOf(z));
        return c0018a;
    }
}
