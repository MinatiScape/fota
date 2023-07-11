package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.v;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class k extends MediaBrowserServiceCompat.i<MediaBrowserCompat.MediaItem> {
    final /* synthetic */ v.c f;
    final /* synthetic */ MediaBrowserServiceCompat.e g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(MediaBrowserServiceCompat.e eVar, Object obj, v.c cVar) {
        super(obj);
        this.g = eVar;
        this.f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    public void a(MediaBrowserCompat.MediaItem mediaItem) {
        if (mediaItem == null) {
            this.f.a((v.c) null);
            return;
        }
        Parcel obtain = Parcel.obtain();
        mediaItem.writeToParcel(obtain, 0);
        this.f.a((v.c) obtain);
    }
}
