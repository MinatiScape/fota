package androidx.media;

import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f737a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f738b;
    final /* synthetic */ ResultReceiver c;
    final /* synthetic */ MediaBrowserServiceCompat.j d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, ResultReceiver resultReceiver) {
        this.d = jVar;
        this.f737a = kVar;
        this.f738b = str;
        this.c = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.c.get(this.f737a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f738b);
            return;
        }
        MediaBrowserServiceCompat.this.a(this.f738b, bVar, this.c);
    }
}
