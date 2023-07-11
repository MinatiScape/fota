package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;
/* loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* loaded from: classes.dex */
    private static class a extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Context f743a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f744b;
        private final BroadcastReceiver.PendingResult c;
        private MediaBrowserCompat d;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f743a = context;
            this.f744b = intent;
            this.c = pendingResult;
        }

        void a(MediaBrowserCompat mediaBrowserCompat) {
            this.d = mediaBrowserCompat;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            try {
                new MediaControllerCompat(this.f743a, this.d.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f744b.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e);
            }
            a();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            a();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            a();
        }

        private void a() {
            this.d.disconnect();
            this.c.finish();
        }
    }

    public static ComponentName a(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        } else if (queryBroadcastReceivers.size() > 1) {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        } else {
            return null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName a2 = a(context, "android.intent.action.MEDIA_BUTTON");
            if (a2 != null) {
                intent.setComponent(a2);
                a(context, intent);
                return;
            }
            ComponentName a3 = a(context, "android.media.browse.MediaBrowserService");
            if (a3 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                a aVar = new a(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a3, aVar, null);
                aVar.a(mediaBrowserCompat);
                mediaBrowserCompat.connect();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
    }

    private static void a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    private static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }
}
