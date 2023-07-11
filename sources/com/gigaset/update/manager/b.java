package com.gigaset.update.manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.gigaset.update.receiver.MyReceiver;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
/* compiled from: AlarmManager.java */
/* loaded from: classes.dex */
public class b {
    private static void a(Context context, int i, long j) {
        Intent intent = new Intent(context, MyReceiver.class);
        intent.setAction(com.gigaset.update.b.a.j);
        intent.putExtra("task", i);
        if (Build.VERSION.SDK_INT > 30) {
            a(context, i, j, PendingIntent.getBroadcast(context, i, intent, 167772160));
        } else {
            a(context, i, j, PendingIntent.getBroadcast(context, i, intent, 134217728));
        }
    }

    public static void b(Context context, long j) {
        a(context, 4, j);
    }

    public static void c(Context context) {
        a(context, 2, (System.currentTimeMillis() + com.gigaset.update.utils.c.k().q()) - SystemClock.elapsedRealtime());
    }

    private static void d(Context context, long j) {
        a(context, 1, System.currentTimeMillis() + j);
    }

    public static void e(Context context) {
        a(context, 13, i.m());
    }

    public static void f(Context context) {
        long currentTimeMillis = System.currentTimeMillis() + 7200000;
        i.c(currentTimeMillis);
        a(context, 13, currentTimeMillis);
    }

    public static long b(Context context) {
        long a2 = o.a(context, "check_freq", 2940L);
        if (a2 == 2940) {
            a2 = o.a(context, "check_local_freq", com.gigaset.update.b.c.a());
        }
        return a2 * 1000 * 60;
    }

    public static void c(Context context, long j) {
        a(context, 12, j);
    }

    public static void d(Context context) {
        d(context, b(context));
    }

    private static void a(Context context, int i, long j, PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            LogUtil.a("alarm time = " + SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(j)) + " , requestCode = " + i);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 19) {
                alarmManager.set(0, j, pendingIntent);
            } else if (i2 < 23) {
                alarmManager.setExact(0, j, pendingIntent);
            } else {
                alarmManager.setExactAndAllowWhileIdle(0, j, pendingIntent);
            }
        }
    }

    public static void a(Context context, long j) {
        a(context, 6, j);
    }

    public static void a(Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, 1);
        calendar.set(11, new Random().nextInt(4));
        a(context, 14, calendar.getTimeInMillis());
    }
}
