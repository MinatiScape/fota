package org.greenrobot.eventbus;

import java.lang.reflect.Method;
/* compiled from: SubscriberMethod.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    final Method f1516a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f1517b;
    final Class<?> c;
    final int d;
    final boolean e;
    String f;

    public q(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f1516a = method;
        this.f1517b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f1516a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f1516a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            a();
            q qVar = (q) obj;
            qVar.a();
            return this.f.equals(qVar.f);
        }
        return false;
    }

    public int hashCode() {
        return this.f1516a.hashCode();
    }
}
