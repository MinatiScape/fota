package com.gigaset.update.manager;

import android.app.Activity;
import com.gigaset.update.GoogleOtaClient;
import java.util.Iterator;
import java.util.Stack;
/* compiled from: ActivityManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1153a;

    /* renamed from: b  reason: collision with root package name */
    private static Stack<Activity> f1154b;
    private static boolean c;

    private a() {
        f1154b = new Stack<>();
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f1153a == null) {
                f1153a = new a();
            }
            aVar = f1153a;
        }
        return aVar;
    }

    public void a(Activity activity) {
        if (f1154b.contains(activity)) {
            return;
        }
        f1154b.push(activity);
    }

    public boolean c() {
        return c;
    }

    public void a() {
        Iterator<Activity> it = f1154b.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass().equals(GoogleOtaClient.class)) {
                next.finish();
                return;
            }
        }
    }

    public void b(Activity activity) {
        if (activity == null || !f1154b.contains(activity)) {
            return;
        }
        f1154b.remove(activity);
    }

    public boolean a(Class cls) {
        if (f1154b.isEmpty()) {
            return false;
        }
        return f1154b.peek().getClass().equals(cls);
    }

    public void a(boolean z) {
        c = z;
    }
}
