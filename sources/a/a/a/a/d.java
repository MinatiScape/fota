package a.a.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f2a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f3b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f3b = eVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f2a.getAndIncrement())));
        return thread;
    }
}
