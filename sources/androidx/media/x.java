package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.w;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MediaBrowserServiceCompatApi26.java */
/* loaded from: classes.dex */
class x {

    /* renamed from: a  reason: collision with root package name */
    static Field f753a;

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* loaded from: classes.dex */
    static class a extends w.a {
        a(Context context, c cVar) {
            super(context, cVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((c) this.f751a).a(str, new b(result), bundle);
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* loaded from: classes.dex */
    public interface c extends w.b {
        void a(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            f753a = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f753a.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.w("MBSCompatApi26", e);
        }
    }

    public static Object a(Context context, c cVar) {
        return new a(context, cVar);
    }

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f754a;

        b(MediaBrowserService.Result result) {
            this.f754a = result;
        }

        public void a(List<Parcel> list, int i) {
            try {
                x.f753a.setInt(this.f754a, i);
            } catch (IllegalAccessException e) {
                Log.w("MBSCompatApi26", e);
            }
            this.f754a.sendResult(a(list));
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
