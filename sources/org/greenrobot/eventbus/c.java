package org.greenrobot.eventbus;

import org.greenrobot.eventbus.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventBus.java */
/* loaded from: classes.dex */
public class c extends ThreadLocal<e.a> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar) {
        this.f1495a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public e.a initialValue() {
        return new e.a();
    }
}
