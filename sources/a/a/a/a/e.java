package a.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class e extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f5b = Executors.newFixedThreadPool(2, new d(this));
    private volatile Handler c;

    @Override // a.a.a.a.f
    public void a(Runnable runnable) {
        this.f5b.execute(runnable);
    }

    @Override // a.a.a.a.f
    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.f4a) {
                if (this.c == null) {
                    this.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // a.a.a.a.f
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
