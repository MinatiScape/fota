package androidx.media;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f741a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f742b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar) {
        this.f742b = jVar;
        this.f741a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        IBinder asBinder = this.f741a.asBinder();
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.c.remove(asBinder);
        if (remove != null) {
            asBinder.unlinkToDeath(remove, 0);
        }
    }
}
