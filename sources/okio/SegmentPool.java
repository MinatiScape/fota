package okio;

import android.support.v4.media.session.PlaybackStateCompat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SegmentPool {

    /* renamed from: a  reason: collision with root package name */
    static Segment f1488a;

    /* renamed from: b  reason: collision with root package name */
    static long f1489b;

    private SegmentPool() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Segment a() {
        synchronized (SegmentPool.class) {
            if (f1488a != null) {
                Segment segment = f1488a;
                f1488a = segment.f;
                segment.f = null;
                f1489b -= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                return segment;
            }
            return new Segment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Segment segment) {
        if (segment.f == null && segment.g == null) {
            if (segment.d) {
                return;
            }
            synchronized (SegmentPool.class) {
                if (f1489b + PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                f1489b += PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                segment.f = f1488a;
                segment.c = 0;
                segment.f1487b = 0;
                f1488a = segment;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
