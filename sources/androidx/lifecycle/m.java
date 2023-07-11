package androidx.lifecycle;
/* compiled from: LiveData.java */
/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveData f694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LiveData liveData) {
        this.f694a = liveData;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        synchronized (this.f694a.f671b) {
            obj = this.f694a.f;
            this.f694a.f = LiveData.f670a;
        }
        this.f694a.a((LiveData) obj);
    }
}
