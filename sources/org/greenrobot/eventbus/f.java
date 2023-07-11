package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.i;
import org.greenrobot.eventbus.j;
/* compiled from: EventBusBuilder.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f1501a = Executors.newCachedThreadPool();
    boolean f;
    boolean h;
    boolean i;
    List<org.greenrobot.eventbus.a.b> k;
    i l;
    j m;

    /* renamed from: b  reason: collision with root package name */
    boolean f1502b = true;
    boolean c = true;
    boolean d = true;
    boolean e = true;
    boolean g = true;
    ExecutorService j = f1501a;

    Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i b() {
        i iVar = this.l;
        return iVar != null ? iVar : (!i.a.a() || a() == null) ? new i.b() : new i.a("EventBus");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j c() {
        Object a2;
        j jVar = this.m;
        if (jVar != null) {
            return jVar;
        }
        if (!i.a.a() || (a2 = a()) == null) {
            return null;
        }
        return new j.a((Looper) a2);
    }
}
