package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f739a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f740b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ Bundle e;
    final /* synthetic */ MediaBrowserServiceCompat.j f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, int i, int i2, Bundle bundle) {
        this.f = jVar;
        this.f739a = kVar;
        this.f740b = str;
        this.c = i;
        this.d = i2;
        this.e = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder asBinder = this.f739a.asBinder();
        MediaBrowserServiceCompat.this.c.remove(asBinder);
        MediaBrowserServiceCompat.b bVar = new MediaBrowserServiceCompat.b(this.f740b, this.c, this.d, this.e, this.f739a);
        MediaBrowserServiceCompat.this.c.put(asBinder, bVar);
        try {
            asBinder.linkToDeath(bVar, 0);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "IBinder is already dead.");
        }
    }
}
