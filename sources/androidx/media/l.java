package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.x;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class l extends MediaBrowserServiceCompat.i<List<MediaBrowserCompat.MediaItem>> {
    final /* synthetic */ x.b f;
    final /* synthetic */ MediaBrowserServiceCompat.f g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(MediaBrowserServiceCompat.f fVar, Object obj, x.b bVar) {
        super(obj);
        this.g = fVar;
        this.f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    public void a(List<MediaBrowserCompat.MediaItem> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            for (MediaBrowserCompat.MediaItem mediaItem : list) {
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                arrayList.add(obtain);
            }
        } else {
            arrayList = null;
        }
        this.f.a(arrayList, a());
    }
}
