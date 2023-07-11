package androidx.core.e;

import android.os.Handler;
import android.os.Message;
/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
class g implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(k kVar) {
        this.f465a = kVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.f465a.a();
            return true;
        } else if (i != 1) {
            return true;
        } else {
            this.f465a.a((Runnable) message.obj);
            return true;
        }
    }
}
