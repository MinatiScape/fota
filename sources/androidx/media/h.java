package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
/* compiled from: MediaBrowserServiceCompat.java */
/* loaded from: classes.dex */
class h extends MediaBrowserServiceCompat.i<Bundle> {
    final /* synthetic */ ResultReceiver f;
    final /* synthetic */ MediaBrowserServiceCompat g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.g = mediaBrowserServiceCompat;
        this.f = resultReceiver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    /* renamed from: c */
    public void a(Bundle bundle) {
        this.f.send(0, bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media.MediaBrowserServiceCompat.i
    void a(Bundle bundle) {
        this.f.send(-1, bundle);
    }
}
