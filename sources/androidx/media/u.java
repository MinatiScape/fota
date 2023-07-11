package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f747a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f748b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ ResultReceiver d;
    final /* synthetic */ MediaBrowserServiceCompat.j e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.e = jVar;
        this.f747a = kVar;
        this.f748b = str;
        this.c = bundle;
        this.d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.c.get(this.f747a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f748b + ", extras=" + this.c);
            return;
        }
        MediaBrowserServiceCompat.this.a(this.f748b, this.c, bVar, this.d);
    }
}
