package androidx.media;

import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f731a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f732b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar) {
        this.f732b = jVar;
        this.f731a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.c.remove(this.f731a.asBinder());
        if (remove != null) {
            remove.f.asBinder().unlinkToDeath(remove, 0);
        }
    }
}
