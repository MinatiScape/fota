package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;
/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class b extends androidx.core.content.a {
    private static InterfaceC0007b c;

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: androidx.core.app.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0007b {
        boolean a(Activity activity, int i, int i2, Intent intent);

        boolean a(Activity activity, String[] strArr, int i);
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public static class d extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        private final g f424a;

        d(g gVar) {
            this.f424a = gVar;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f424a.a(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f424a.a(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f424a.a(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f424a.a(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f424a.a(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f424a.b(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f424a.a(list, list2, new androidx.core.app.c(this, onSharedElementsReadyListener));
        }
    }

    public static InterfaceC0007b a() {
        return c;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void b(Activity activity, g gVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(gVar != null ? new d(gVar) : null);
        }
    }

    public static void a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(Activity activity, g gVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(gVar != null ? new d(gVar) : null);
        }
    }

    public static void a(Activity activity, String[] strArr, int i) {
        InterfaceC0007b interfaceC0007b = c;
        if (interfaceC0007b == null || !interfaceC0007b.a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof c) {
                    ((c) activity).validateRequestPermissionsRequestCode(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof a) {
                new Handler(Looper.getMainLooper()).post(new androidx.core.app.a(strArr, activity, i));
            }
        }
    }
}
