package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MediaBrowserServiceCompatApi21.java */
/* loaded from: classes.dex */
class v {

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final String f749a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f750b;
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* loaded from: classes.dex */
    static class b extends MediaBrowserService {

        /* renamed from: a  reason: collision with root package name */
        final d f751a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Context context, d dVar) {
            attachBaseContext(context);
            this.f751a = dVar;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            a a2 = this.f751a.a(str, i, bundle == null ? null : new Bundle(bundle));
            if (a2 == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(a2.f749a, a2.f750b);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f751a.b(str, new c<>(result));
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* loaded from: classes.dex */
    public interface d {
        a a(String str, int i, Bundle bundle);

        void b(String str, c<List<Parcel>> cVar);
    }

    public static Object a(Context context, d dVar) {
        return new b(context, dVar);
    }

    public static void a(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static IBinder a(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* loaded from: classes.dex */
    static class c<T> {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f752a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(MediaBrowserService.Result result) {
            this.f752a = result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(T t) {
            if (t instanceof List) {
                this.f752a.sendResult(a((List) t));
            } else if (t instanceof Parcel) {
                Parcel parcel = (Parcel) t;
                parcel.setDataPosition(0);
                this.f752a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f752a.sendResult(null);
            }
        }

        List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }
}
