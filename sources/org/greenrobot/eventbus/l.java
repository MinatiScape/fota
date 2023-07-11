package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
/* compiled from: PendingPost.java */
/* loaded from: classes.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final List<l> f1510a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    Object f1511b;
    s c;
    l d;

    private l(Object obj, s sVar) {
        this.f1511b = obj;
        this.c = sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l a(s sVar, Object obj) {
        synchronized (f1510a) {
            int size = f1510a.size();
            if (size > 0) {
                l remove = f1510a.remove(size - 1);
                remove.f1511b = obj;
                remove.c = sVar;
                remove.d = null;
                return remove;
            }
            return new l(obj, sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(l lVar) {
        lVar.f1511b = null;
        lVar.c = null;
        lVar.d = null;
        synchronized (f1510a) {
            if (f1510a.size() < 10000) {
                f1510a.add(lVar);
            }
        }
    }
}
