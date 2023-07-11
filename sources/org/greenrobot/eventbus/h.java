package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* compiled from: HandlerPoster.java */
/* loaded from: classes.dex */
public class h extends Handler implements n {

    /* renamed from: a  reason: collision with root package name */
    private final m f1503a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1504b;
    private final e c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(e eVar, Looper looper, int i) {
        super(looper);
        this.c = eVar;
        this.f1504b = i;
        this.f1503a = new m();
    }

    @Override // org.greenrobot.eventbus.n
    public void a(s sVar, Object obj) {
        l a2 = l.a(sVar, obj);
        synchronized (this) {
            this.f1503a.a(a2);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new g("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                l a2 = this.f1503a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f1503a.a();
                        if (a2 == null) {
                            this.d = false;
                            return;
                        }
                    }
                }
                this.c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f1504b);
            if (sendMessage(obtainMessage())) {
                this.d = true;
                return;
            }
            throw new g("Could not send handler message");
        } finally {
            this.d = false;
        }
    }
}
