package androidx.media;

import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f735a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f736b;
    final /* synthetic */ IBinder c;
    final /* synthetic */ MediaBrowserServiceCompat.j d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, IBinder iBinder) {
        this.d = jVar;
        this.f735a = kVar;
        this.f736b = str;
        this.c = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.c.get(this.f735a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f736b);
        } else if (MediaBrowserServiceCompat.this.a(this.f736b, bVar, this.c)) {
        } else {
            Log.w("MBServiceCompat", "removeSubscription called for " + this.f736b + " which is not subscribed");
        }
    }
}
