package com.gigaset.update.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import com.gigaset.update.GoogleOtaClient;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
/* compiled from: NotificationManager.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f1160a;

    public static h a() {
        if (f1160a == null) {
            synchronized (h.class) {
                if (f1160a == null) {
                    f1160a = new h();
                }
            }
        }
        return f1160a;
    }

    public void b(Context context, boolean z) {
        if (com.gigaset.update.d.d.a() && !com.gigaset.update.d.d.a(MyApplication.c(), 30)) {
            CustomActionService.a(context, 15);
            return;
        }
        Intent intent = new Intent(context, GoogleOtaClient.class);
        intent.addFlags(67108864);
        intent.putExtra("notify_id", 105);
        PendingIntent activity = PendingIntent.getActivity(context, 4, intent, 301989888);
        Intent intent2 = new Intent(context, GoogleOtaClient.class);
        intent2.addFlags(67108864);
        intent2.putExtra("notify_id", 105);
        intent2.putExtra("flag", "install");
        intent2.putExtra("AB_GET_PARAMS_FAIL", "0");
        if (Build.VERSION.SDK_INT > 30) {
            a(context, 105, null, context.getString(R.string.download_completed_text), activity, PendingIntent.getActivity(context, 7, intent2, 301989888), z);
            return;
        }
        a(context, 105, null, context.getString(R.string.download_completed_text), activity, PendingIntent.getActivity(context, 7, intent2, 268435456), z);
    }

    public void c(Context context, boolean z) {
        if (b()) {
            Intent intent = new Intent(context, GoogleOtaClient.class);
            intent.addFlags(67108864);
            if (Build.VERSION.SDK_INT > 30) {
                a(context, R.string.appbar_scrolling_view_behavior, null, context.getString(R.string.ota_notify_download_pause_content), PendingIntent.getActivity(context, 3, intent, 301989888), z);
                return;
            }
            a(context, R.string.appbar_scrolling_view_behavior, null, context.getString(R.string.ota_notify_download_pause_content), PendingIntent.getActivity(context, 3, intent, 268435456), z);
        }
    }

    public void d(Context context, boolean z) {
        LogUtil.a("showNewVersion");
        Intent intent = new Intent(context, GoogleOtaClient.class);
        intent.addFlags(67108864);
        if (Build.VERSION.SDK_INT > 30) {
            a(context, R.string.appbar_scrolling_view_behavior, null, context.getString(R.string.notification_content_newversion), PendingIntent.getActivity(context, 1, intent, 301989888), z);
            return;
        }
        a(context, R.string.appbar_scrolling_view_behavior, null, context.getString(R.string.notification_content_newversion), PendingIntent.getActivity(context, 1, intent, 268435456), z);
    }

    public void a(Context context, String str, String str2) {
        if (b()) {
            Intent intent = new Intent(context, GoogleOtaClient.class);
            intent.addFlags(67108864);
            if (Build.VERSION.SDK_INT > 30) {
                a(context, R.string.appbar_scrolling_view_behavior, null, str2, PendingIntent.getActivity(context, 2, intent, 301989888), false);
            } else {
                a(context, R.string.appbar_scrolling_view_behavior, null, str2, PendingIntent.getActivity(context, 2, intent, 268435456), false);
            }
        }
    }

    public void a(Context context, boolean z) {
        int c = com.gigaset.update.b.d.c(context);
        if (c != 6) {
            LogUtil.a("status: " + c + "; do not need Reboot");
            return;
        }
        Intent intent = new Intent(context, GoogleOtaClient.class);
        intent.addFlags(67108864);
        if (Build.VERSION.SDK_INT > 30) {
            a(context, R.string.appbar_scrolling_view_behavior, null, context.getString(R.string.updated_need_reboot), PendingIntent.getActivity(context, 6, intent, 301989888), z);
            return;
        }
        a(context, R.string.appbar_scrolling_view_behavior, null, context.getString(R.string.updated_need_reboot), PendingIntent.getActivity(context, 6, intent, 268435456), z);
    }

    private boolean b() {
        int intValue = ((Integer) com.gigaset.update.e.c.a().a("query_notice_type", Integer.class)).intValue();
        LogUtil.a("isShowProgressNotify = " + intValue);
        return intValue == 0;
    }

    public void a(Context context, int i, String str, String str2, PendingIntent pendingIntent, boolean z) {
        a(context, i, str, str2, pendingIntent, null, z);
    }

    public void a(Context context, int i, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2, boolean z) {
        String string = context.getString(R.string.app_name);
        Notification.Builder contentIntent = new Notification.Builder(context).setSmallIcon(R.mipmap.status_bar_icon).setTicker(string).setContentTitle(TextUtils.isEmpty(str) ? string : str).setContentText(str2).setStyle(new Notification.BigTextStyle().bigText(str2)).setContentIntent(pendingIntent);
        if (i != 105) {
            contentIntent.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.notification_bar_icon));
        } else if (Build.VERSION.SDK_INT >= 23) {
            String string2 = context.getString(R.string.update_now);
            if (pendingIntent2 != null) {
                pendingIntent = pendingIntent2;
            }
            contentIntent.addAction(new Notification.Action.Builder((Icon) null, string2, pendingIntent).build());
        } else {
            String string3 = context.getString(R.string.update_now);
            if (pendingIntent2 != null) {
                pendingIntent = pendingIntent2;
            }
            contentIntent.addAction(0, string3, pendingIntent);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                contentIntent.setColor(androidx.core.content.a.a(context, (int) R.color.notification_text_color));
            }
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("channel_fota", string, 2);
                notificationChannel.enableVibration(false);
                notificationChannel.enableLights(false);
                notificationChannel.setShowBadge(true);
                notificationManager.createNotificationChannel(notificationChannel);
                contentIntent.setChannelId("channel_fota");
                contentIntent.setBadgeIconType(1);
            }
            Notification build = contentIntent.build();
            if (z) {
                build.flags = 34;
            } else {
                build.flags = 16;
            }
            notificationManager.notify(i, build);
            LogUtil.a("notification : title = " + str + ",content = " + str2 + ",notifyId = " + i + ", is resident : " + z);
        }
    }

    public void a(Context context, int i) {
        LogUtil.a("cancel : id = " + i);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.deleteNotificationChannel(String.valueOf(i));
            }
            notificationManager.cancel(i);
        }
    }
}
