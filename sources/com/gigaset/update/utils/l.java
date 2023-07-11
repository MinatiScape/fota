package com.gigaset.update.utils;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* compiled from: OkHttpUtil.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static OkHttpClient f1175a;

    /* renamed from: b  reason: collision with root package name */
    private static List<Call> f1176b;
    private Call c = null;

    public static Response a(Request request) throws IOException {
        Response execute = b(request).execute();
        if (execute == null || !execute.isSuccessful()) {
            throw new IOException("Unexpected code " + execute);
        }
        return execute;
    }

    private static Call b(Request request) {
        Call newCall = c().newCall(request);
        if (f1176b == null) {
            f1176b = new ArrayList();
        }
        if (!f1176b.contains(newCall)) {
            f1176b.add(newCall);
        }
        return newCall;
    }

    private static synchronized OkHttpClient c() {
        OkHttpClient okHttpClient;
        synchronized (l.class) {
            if (f1175a == null) {
                f1175a = new OkHttpClient();
                f1175a.setConnectTimeout(15L, TimeUnit.SECONDS);
                f1175a.setReadTimeout(25L, TimeUnit.SECONDS);
                f1175a.setWriteTimeout(25L, TimeUnit.SECONDS);
                f1175a.setFollowRedirects(true);
                f1175a.setRetryOnConnectionFailure(true);
                f1175a.setFollowSslRedirects(true);
                f1175a.setHostnameVerifier(a.f1163a);
            }
            okHttpClient = f1175a;
        }
        return okHttpClient;
    }

    public static void a(Request request, Callback callback) {
        b(request).enqueue(callback);
    }

    public long a(String str) throws IOException {
        return c().newCall(new Request.Builder().url(str).build()).execute().body().contentLength();
    }

    public static void b() {
        Security.setProperty("networkaddress.cache.ttl", String.valueOf(0));
        Security.setProperty("networkaddress.cache.negative.ttl", String.valueOf(0));
    }

    public InputStream a(String str, long j, int i) throws IOException {
        String str2 = "bytes=";
        if (j >= 0) {
            str2 = "bytes=" + j + "-";
        }
        if (i > 0 && i > j) {
            str2 = str2 + i;
        }
        this.c = c().newCall(new Request.Builder().url(str).addHeader("Range", str2).build());
        Response execute = this.c.execute();
        if (execute.isSuccessful()) {
            return execute.body().byteStream();
        }
        LogUtil.a("downloadFile,http error code=" + execute.code());
        return null;
    }

    public void a() {
        Call call = this.c;
        if (call != null) {
            call.cancel();
        }
    }
}
