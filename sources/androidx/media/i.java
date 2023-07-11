package androidx.media;

import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.b f728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MediaBrowserServiceCompat.b bVar) {
        this.f728a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.b bVar = this.f728a;
        MediaBrowserServiceCompat.this.c.remove(bVar.f.asBinder());
    }
}
