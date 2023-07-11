package com.gigaset.update.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.gigaset.update.bean.ReportBean;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.i;
import com.gigaset.update.utils.l;
import com.gigaset.update.utils.o;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: ReportManager.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f1132a;

    private e() {
    }

    private void b(Context context) {
        List<ReportBean> b2 = com.gigaset.update.manager.c.c().b();
        if (b2 == null || b2.isEmpty()) {
            return;
        }
        LogUtil.a("record items size = " + b2.size());
        ArrayList arrayList = new ArrayList();
        for (ReportBean reportBean : b2) {
            if (reportBean.getAction().equalsIgnoreCase("fcm")) {
                a(context, (Map) i.a(reportBean.getResult()));
            }
            arrayList.add(reportBean.getResult());
        }
        String str = o.a(context, "check_url", "https://mobileupdate.gigaset.com") + "/gigaset-ota-inter/gigfota/gigSubmitReport.do";
        Request build = new Request.Builder().url(str).post(com.gigaset.update.g.d.a(context, arrayList, true)).build();
        LogUtil.a("http URL = " + str);
        l.a(build, new b(this));
    }

    private void c(Context context) {
        b(context);
    }

    public static e a() {
        if (f1132a == null) {
            synchronized (e.class) {
                if (f1132a == null) {
                    f1132a = new e();
                }
            }
        }
        return f1132a;
    }

    public void a(Context context) {
        if (!a(context, "scheduleReportData", 7200000L)) {
            LogUtil.a("not arrive report data schedule!");
        } else {
            c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        LogUtil.a("insert data to db, type = " + str + "; result = " + str2);
        com.gigaset.update.manager.c.c().a(str, str2);
    }

    public void a(Context context, String str, String str2, boolean z) {
        LogUtil.a("type = " + str + "; result = " + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        String str3 = o.a(context, "check_url", "https://mobileupdate.gigaset.com") + "/gigaset-ota-inter/gigfota/gigSubmitReport.do";
        Request build = new Request.Builder().url(str3).post(com.gigaset.update.g.d.a(context, arrayList, z)).build();
        LogUtil.a("http URL = " + str3);
        l.a(build, new c(this, str, str2));
    }

    public void a(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        com.gigaset.update.g.d.a(context, map);
        a(o.a(context, "check_url", "https://mobileupdate.gigaset.com") + com.gigaset.update.b.b.f1102b, map);
    }

    private void a(String str, Map<String, String> map) {
        if (map == null) {
            return;
        }
        MultipartBuilder multipartBuilder = new MultipartBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase("log")) {
                multipartBuilder.addFormDataPart(key, "log.txt", RequestBody.create(MediaType.parse("text/plain"), new File(entry.getValue())));
            } else {
                multipartBuilder.addFormDataPart(key, entry.getValue());
            }
        }
        Request build = new Request.Builder().url(str).post(multipartBuilder.build()).build();
        LogUtil.a("http URL = " + str);
        l.a(build, new d(this, map));
    }

    public synchronized boolean a(Context context, String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("runstats", 0);
        long j2 = currentTimeMillis - sharedPreferences.getLong(str + "CHECKTIME", 0L);
        if (j2 < 0) {
            a(context, str);
            return true;
        }
        boolean z = j2 > j;
        if (z) {
            a(context, str);
        }
        return z;
    }

    private synchronized void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = context.getSharedPreferences("runstats", 0).edit();
        edit.putLong(str + "CHECKTIME", currentTimeMillis);
        edit.apply();
    }
}
