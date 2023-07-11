package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
/* compiled from: EventBus.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static volatile e f1497a;

    /* renamed from: b  reason: collision with root package name */
    private static final f f1498b = new f();
    private static final Map<Class<?>, List<Class<?>>> c = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<s>> d;
    private final Map<Object, List<Class<?>>> e;
    private final Map<Class<?>, Object> f;
    private final ThreadLocal<a> g;
    private final j h;
    private final n i;
    private final b j;
    private final org.greenrobot.eventbus.a k;
    private final r l;
    private final ExecutorService m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;
    private final i u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f1499a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f1500b;
        boolean c;
        s d;
        Object e;
        boolean f;
    }

    public e() {
        this(f1498b);
    }

    public static e a() {
        if (f1497a == null) {
            synchronized (e.class) {
                if (f1497a == null) {
                    f1497a = new e();
                }
            }
        }
        return f1497a;
    }

    private void b(s sVar, Object obj) {
        if (obj != null) {
            a(sVar, obj, d());
        }
    }

    private boolean d() {
        j jVar = this.h;
        if (jVar != null) {
            return jVar.a();
        }
        return true;
    }

    public void c(Object obj) {
        List<q> a2 = this.l.a(obj.getClass());
        synchronized (this) {
            for (q qVar : a2) {
                a(obj, qVar);
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
    }

    e(f fVar) {
        this.g = new c(this);
        this.u = fVar.b();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new ConcurrentHashMap();
        this.h = fVar.c();
        j jVar = this.h;
        this.i = jVar != null ? jVar.a(this) : null;
        this.j = new b(this);
        this.k = new org.greenrobot.eventbus.a(this);
        List<org.greenrobot.eventbus.a.b> list = fVar.k;
        this.t = list != null ? list.size() : 0;
        this.l = new r(fVar.k, fVar.i, fVar.h);
        this.o = fVar.f1502b;
        this.p = fVar.c;
        this.q = fVar.d;
        this.r = fVar.e;
        this.n = fVar.f;
        this.s = fVar.g;
        this.m = fVar.j;
    }

    public void b(Object obj) {
        a aVar = this.g.get();
        List<Object> list = aVar.f1499a;
        list.add(obj);
        if (aVar.f1500b) {
            return;
        }
        aVar.c = d();
        aVar.f1500b = true;
        if (aVar.f) {
            throw new g("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                a(list.remove(0), aVar);
            } finally {
                aVar.f1500b = false;
                aVar.c = false;
            }
        }
    }

    public synchronized void d(Object obj) {
        List<Class<?>> list = this.e.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                a(obj, cls);
            }
            this.e.remove(obj);
        } else {
            i iVar = this.u;
            Level level = Level.WARNING;
            iVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    private void a(Object obj, q qVar) {
        Class<?> cls = qVar.c;
        s sVar = new s(obj, qVar);
        CopyOnWriteArrayList<s> copyOnWriteArrayList = this.d.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.d.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(sVar)) {
            throw new g("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || qVar.d > copyOnWriteArrayList.get(i).f1523b.d) {
                copyOnWriteArrayList.add(i, sVar);
                break;
            }
        }
        List<Class<?>> list = this.e.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.e.put(obj, list);
        }
        list.add(cls);
        if (qVar.e) {
            if (this.s) {
                for (Map.Entry<Class<?>, Object> entry : this.f.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        b(sVar, entry.getValue());
                    }
                }
                return;
            }
            b(sVar, this.f.get(cls));
        }
    }

    public i c() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService b() {
        return this.m;
    }

    public synchronized boolean a(Object obj) {
        return this.e.containsKey(obj);
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<s> copyOnWriteArrayList = this.d.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                s sVar = copyOnWriteArrayList.get(i);
                if (sVar.f1522a == obj) {
                    sVar.c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    private void a(Object obj, a aVar) throws Error {
        boolean a2;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> a3 = a(cls);
            int size = a3.size();
            a2 = false;
            for (int i = 0; i < size; i++) {
                a2 |= a(obj, aVar, a3.get(i));
            }
        } else {
            a2 = a(obj, aVar, cls);
        }
        if (a2) {
            return;
        }
        if (this.p) {
            i iVar = this.u;
            Level level = Level.FINE;
            iVar.a(level, "No subscribers registered for event " + cls);
        }
        if (!this.r || cls == k.class || cls == p.class) {
            return;
        }
        b(new k(this, obj));
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList<s> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.d.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<s> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            s next = it.next();
            aVar.e = obj;
            aVar.d = next;
            try {
                a(next, obj, aVar.c);
                if (aVar.f) {
                    return true;
                }
            } finally {
                aVar.e = null;
                aVar.d = null;
                aVar.f = false;
            }
        }
        return true;
    }

    private void a(s sVar, Object obj, boolean z) {
        int i = d.f1496a[sVar.f1523b.f1517b.ordinal()];
        if (i == 1) {
            a(sVar, obj);
        } else if (i == 2) {
            if (z) {
                a(sVar, obj);
            } else {
                this.i.a(sVar, obj);
            }
        } else if (i == 3) {
            n nVar = this.i;
            if (nVar != null) {
                nVar.a(sVar, obj);
            } else {
                a(sVar, obj);
            }
        } else if (i == 4) {
            if (z) {
                this.j.a(sVar, obj);
            } else {
                a(sVar, obj);
            }
        } else if (i == 5) {
            this.k.a(sVar, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + sVar.f1523b.f1517b);
        }
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (c) {
            list = c.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                c.put(cls, list);
            }
        }
        return list;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        Object obj = lVar.f1511b;
        s sVar = lVar.c;
        l.a(lVar);
        if (sVar.c) {
            a(sVar, obj);
        }
    }

    void a(s sVar, Object obj) {
        try {
            sVar.f1523b.f1516a.invoke(sVar.f1522a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            a(sVar, obj, e2.getCause());
        }
    }

    private void a(s sVar, Object obj, Throwable th) {
        if (obj instanceof p) {
            if (this.o) {
                i iVar = this.u;
                Level level = Level.SEVERE;
                iVar.a(level, "SubscriberExceptionEvent subscriber " + sVar.f1522a.getClass() + " threw an exception", th);
                p pVar = (p) obj;
                i iVar2 = this.u;
                Level level2 = Level.SEVERE;
                iVar2.a(level2, "Initial event " + pVar.c + " caused exception in " + pVar.d, pVar.f1515b);
            }
        } else if (!this.n) {
            if (this.o) {
                i iVar3 = this.u;
                Level level3 = Level.SEVERE;
                iVar3.a(level3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + sVar.f1522a.getClass(), th);
            }
            if (this.q) {
                b(new p(this, th, obj, sVar.f1522a));
            }
        } else {
            throw new g("Invoking subscriber failed", th);
        }
    }
}
