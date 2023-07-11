package androidx.core.e;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f470a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Callable f471b;
    final /* synthetic */ ReentrantLock c;
    final /* synthetic */ AtomicBoolean d;
    final /* synthetic */ Condition e;
    final /* synthetic */ k f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.f = kVar;
        this.f470a = atomicReference;
        this.f471b = callable;
        this.c = reentrantLock;
        this.d = atomicBoolean;
        this.e = condition;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f470a.set(this.f471b.call());
        } catch (Exception unused) {
        }
        this.c.lock();
        try {
            this.d.set(false);
            this.e.signal();
        } finally {
            this.c.unlock();
        }
    }
}
