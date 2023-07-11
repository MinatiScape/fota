package androidx.core.e;

import android.os.Handler;
import androidx.core.e.k;
import java.util.concurrent.Callable;
/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callable f468a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Handler f469b;
    final /* synthetic */ k.a c;
    final /* synthetic */ k d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(k kVar, Callable callable, Handler handler, k.a aVar) {
        this.d = kVar;
        this.f468a = callable;
        this.f469b = handler;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        try {
            obj = this.f468a.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f469b.post(new h(this, obj));
    }
}
