package org.greenrobot.eventbus;

import java.util.logging.Level;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundPoster.java */
/* loaded from: classes.dex */
public final class b implements Runnable, n {

    /* renamed from: a  reason: collision with root package name */
    private final m f1493a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final e f1494b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar) {
        this.f1494b = eVar;
    }

    @Override // org.greenrobot.eventbus.n
    public void a(s sVar, Object obj) {
        l a2 = l.a(sVar, obj);
        synchronized (this) {
            this.f1493a.a(a2);
            if (!this.c) {
                this.c = true;
                this.f1494b.b().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                l a2 = this.f1493a.a(TarArchiveEntry.MILLIS_PER_SECOND);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f1493a.a();
                        if (a2 == null) {
                            return;
                        }
                    }
                }
                this.f1494b.a(a2);
            } catch (InterruptedException e) {
                i c = this.f1494b.c();
                Level level = Level.WARNING;
                c.a(level, Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.c = false;
            }
        }
    }
}
