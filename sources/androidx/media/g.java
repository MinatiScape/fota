package androidx.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class g extends MediaBrowserServiceCompat.i<List<MediaBrowserCompat.MediaItem>> {
    final /* synthetic */ ResultReceiver f;
    final /* synthetic */ MediaBrowserServiceCompat g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.g = mediaBrowserServiceCompat;
        this.f = resultReceiver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    public void a(List<MediaBrowserCompat.MediaItem> list) {
        if ((a() & 4) == 0 && list != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f.send(0, bundle);
            return;
        }
        this.f.send(-1, null);
    }
}
