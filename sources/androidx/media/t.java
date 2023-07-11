package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f745a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f746b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ ResultReceiver d;
    final /* synthetic */ MediaBrowserServiceCompat.j e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.e = jVar;
        this.f745a = kVar;
        this.f746b = str;
        this.c = bundle;
        this.d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.c.get(this.f745a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f746b);
            return;
        }
        MediaBrowserServiceCompat.this.b(this.f746b, this.c, bVar, this.d);
    }
}
