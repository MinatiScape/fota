package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f729a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f730b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ Bundle e;
    final /* synthetic */ MediaBrowserServiceCompat.j f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, int i, int i2, Bundle bundle) {
        this.f = jVar;
        this.f729a = kVar;
        this.f730b = str;
        this.c = i;
        this.d = i2;
        this.e = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder asBinder = this.f729a.asBinder();
        MediaBrowserServiceCompat.this.c.remove(asBinder);
        MediaBrowserServiceCompat.b bVar = new MediaBrowserServiceCompat.b(this.f730b, this.c, this.d, this.e, this.f729a);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.d = bVar;
        bVar.h = mediaBrowserServiceCompat.a(this.f730b, this.d, this.e);
        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat2.d = null;
        if (bVar.h == null) {
            Log.i("MBServiceCompat", "No root for client " + this.f730b + " from service " + m.class.getName());
            try {
                this.f729a.a();
                return;
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f730b);
                return;
            }
        }
        try {
            mediaBrowserServiceCompat2.c.put(asBinder, bVar);
            asBinder.linkToDeath(bVar, 0);
            if (MediaBrowserServiceCompat.this.f == null) {
                return;
            }
            MediaBrowserServiceCompat.k kVar = this.f729a;
            bVar.h.b();
            throw null;
        } catch (RemoteException unused2) {
            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.f730b);
            MediaBrowserServiceCompat.this.c.remove(asBinder);
        }
    }
}
