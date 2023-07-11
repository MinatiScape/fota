package com.gigaset.update.g;

import android.content.Context;
import android.provider.Settings;
import com.gigaset.update.MyApplication;
import com.gigaset.update.manager.i;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.f;
import com.gigaset.update.utils.g;
import com.gigaset.update.utils.j;
import com.gigaset.update.utils.n;
import com.gigaset.update.utils.t;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: RequestParam.java */
/* loaded from: classes.dex */
public class d {
    public static Map<String, String> a(Context context, int i) {
        Map<String, String> b2 = b(context);
        b2.put("appVersion", n.b(context) + ".0.222208.006_2023-02-15 11:29");
        b2.put("appCode", String.valueOf(n.a(context)));
        b2.put("local", com.gigaset.update.utils.c.k().i());
        b2.put("operator", com.gigaset.update.utils.c.k().e(context));
        b2.put("spn1", com.gigaset.update.utils.c.k().c(context));
        b2.put("spn2", "");
        b2.put("sendId", "1075259712158");
        b2.put("fotaSign", n.a(context, context.getPackageName()));
        b2.put("androidId", Settings.System.getString(context.getContentResolver(), "android_id"));
        b2.put("fcmId", i.h());
        b2.put("agreeType", String.valueOf(MyApplication.d()));
        b2.put("upgradeAgreement", String.valueOf(i.n()));
        b2.put("isActive", String.valueOf(i == 2));
        if (i.q()) {
            b2.put("imei1", f.c(com.gigaset.update.utils.c.k().a(context)));
            b2.put("imei2", f.c(com.gigaset.update.utils.c.k().m()));
            b2.put("mac", f.c(com.gigaset.update.utils.c.k().b(context)));
            b2.put("esn", f.c(com.gigaset.update.utils.c.k().h()));
        } else {
            b2.put("imei1", com.gigaset.update.utils.c.k().a(context));
            b2.put("imei2", com.gigaset.update.utils.c.k().m());
            b2.put("mac", com.gigaset.update.utils.c.k().b(context));
            b2.put("esn", com.gigaset.update.utils.c.k().h());
        }
        return b2;
    }

    private static Map<String, String> b(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("device_type", com.gigaset.update.utils.c.k().d());
        hashMap.put("connect_type", String.valueOf(com.gigaset.update.utils.c.k().d(context)));
        hashMap.put("platform", com.gigaset.update.utils.c.k().o());
        hashMap.put("project", com.gigaset.update.utils.c.k().p());
        hashMap.put("version", com.gigaset.update.utils.c.k().l());
        hashMap.put("devicesinfoExt", com.gigaset.update.utils.c.k().e());
        hashMap.put("swFingerprint", com.gigaset.update.utils.c.k().j());
        hashMap.put("sdk_level", com.gigaset.update.utils.c.k().r());
        hashMap.put("sdk_release", com.gigaset.update.utils.c.k().s());
        hashMap.put("resolution", com.gigaset.update.utils.c.k().g(context));
        hashMap.put("mid", j.b(context));
        hashMap.put("isNewMid", String.valueOf(j.c));
        return hashMap;
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("imei1", com.gigaset.update.utils.c.k().a(context));
        hashMap.put("imei2", com.gigaset.update.utils.c.k().m());
        hashMap.put("deviceType", com.gigaset.update.utils.c.k().d());
        hashMap.put("connectType", String.valueOf(com.gigaset.update.utils.c.k().d(context)));
        hashMap.put("platform", com.gigaset.update.utils.c.k().o());
        hashMap.put("project", com.gigaset.update.utils.c.k().p());
        hashMap.put("version", com.gigaset.update.utils.c.k().l());
        hashMap.put("sdkLevel", com.gigaset.update.utils.c.k().r());
        hashMap.put("sdkRelease", com.gigaset.update.utils.c.k().s());
        hashMap.put("resolution", com.gigaset.update.utils.c.k().g(context));
        hashMap.put("appVersion", n.b(context) + ".0.222208.006_2023-02-15 11:29");
        hashMap.put("appCode", String.valueOf(n.a(context)));
        hashMap.put("mac", com.gigaset.update.utils.c.k().b(context));
        if (i.o()) {
            hashMap.put("status", String.valueOf(true));
        }
        return hashMap;
    }

    public static Map<String, String> a(Context context, Map<String, String> map) {
        map.put("imei1", com.gigaset.update.utils.c.k().a(context));
        map.put("imei2", com.gigaset.update.utils.c.k().m());
        map.put("project", com.gigaset.update.utils.c.k().p());
        map.put("version", com.gigaset.update.utils.c.k().l());
        map.put("appVersion", n.b(context) + ".0.222208.006_2023-02-15 11:29");
        map.put("time", SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        sb.append("fcm : ");
        sb.append(map.toString());
        LogUtil.a(sb.toString());
        return map;
    }

    public static RequestBody a(Context context, List<String> list, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("mid", j.b(context));
        if (i.l()) {
            hashMap.put("imei", f.c(com.gigaset.update.utils.c.k().a(context)));
            hashMap.put("imei2", f.c(com.gigaset.update.utils.c.k().m()));
        } else {
            hashMap.put("imei", com.gigaset.update.utils.c.k().a(context));
            hashMap.put("imei2", com.gigaset.update.utils.c.k().m());
        }
        hashMap.put("connect_type", String.valueOf(com.gigaset.update.utils.c.k().d(context)));
        hashMap.put("appVersion", n.b(context) + ".0.222208.006_2023-02-15 11:29");
        hashMap.put("project", com.gigaset.update.utils.c.k().p());
        hashMap.put("version", com.gigaset.update.utils.c.k().l());
        hashMap.put("result", com.gigaset.update.utils.i.a((List) list));
        hashMap.put("time", SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(System.currentTimeMillis())));
        hashMap.put("battery", String.valueOf(com.gigaset.update.utils.c.k().f(context)));
        if (LogUtil.f1161a || g.c(context)) {
            LogUtil.a("reportParams : " + hashMap.toString());
        }
        MultipartBuilder multipartBuilder = new MultipartBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            multipartBuilder.addFormDataPart((String) entry.getKey(), (String) entry.getValue());
        }
        File b2 = t.b();
        MediaType parse = MediaType.parse("text/plain");
        if (z && b2 != null) {
            multipartBuilder.addFormDataPart("log", "error.log", RequestBody.create(parse, b2));
        } else {
            multipartBuilder.addFormDataPart("log", "error.log", RequestBody.create(parse, ""));
        }
        return multipartBuilder.build();
    }
}
