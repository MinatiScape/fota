package org.greenrobot.eventbus;
/* compiled from: PendingPostQueue.java */
/* loaded from: classes.dex */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private l f1512a;

    /* renamed from: b  reason: collision with root package name */
    private l f1513b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(l lVar) {
        try {
            if (lVar != null) {
                if (this.f1513b != null) {
                    this.f1513b.d = lVar;
                    this.f1513b = lVar;
                } else if (this.f1512a == null) {
                    this.f1513b = lVar;
                    this.f1512a = lVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized l a() {
        l lVar;
        lVar = this.f1512a;
        if (this.f1512a != null) {
            this.f1512a = this.f1512a.d;
            if (this.f1512a == null) {
                this.f1513b = null;
            }
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized l a(int i) throws InterruptedException {
        if (this.f1512a == null) {
            wait(i);
        }
        return a();
    }
}
