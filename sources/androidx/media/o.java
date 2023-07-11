package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f733a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f734b;
    final /* synthetic */ IBinder c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ MediaBrowserServiceCompat.j e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, IBinder iBinder, Bundle bundle) {
        this.e = jVar;
        this.f733a = kVar;
        this.f734b = str;
        this.c = iBinder;
        this.d = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.c.get(this.f733a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f734b);
            return;
        }
        MediaBrowserServiceCompat.this.a(this.f734b, bVar, this.c, this.d);
    }
}
