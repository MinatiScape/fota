package androidx.core.e;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f473b;
    private Handler c;
    private final int f;
    private final int g;
    private final String h;

    /* renamed from: a  reason: collision with root package name */
    private final Object f472a = new Object();
    private Handler.Callback e = new g(this);
    private int d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(T t);
    }

    public k(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.f472a) {
            if (this.f473b == null) {
                this.f473b = new HandlerThread(this.h, this.g);
                this.f473b.start();
                this.c = new Handler(this.f473b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, runnable));
        }
    }

    public <T> void a(Callable<T> callable, a<T> aVar) {
        b(new i(this, callable, new Handler(), aVar));
    }

    public <T> T a(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new j(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f472a) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f472a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.f473b.quit();
            this.f473b = null;
            this.c = null;
        }
    }
}
