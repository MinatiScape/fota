package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import androidx.media.v;
/* compiled from: MediaBrowserServiceCompatApi23.java */
/* loaded from: classes.dex */
class w {

    /* compiled from: MediaBrowserServiceCompatApi23.java */
    /* loaded from: classes.dex */
    static class a extends v.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, b bVar) {
            super(context, bVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
            ((b) this.f751a).a(str, new v.c<>(result));
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi23.java */
    /* loaded from: classes.dex */
    public interface b extends v.d {
        void a(String str, v.c<Parcel> cVar);
    }

    public static Object a(Context context, b bVar) {
        return new a(context, bVar);
    }
}
