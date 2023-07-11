package com.gigaset.update.g;

import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.l;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Map;
/* compiled from: HttpRequest.java */
/* loaded from: classes.dex */
public class b {
    public static Response a(String str, Map<String, String> map) throws IOException {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                formEncodingBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        Request build = new Request.Builder().url(str).post(formEncodingBuilder.build()).build();
        LogUtil.a("http url = " + str);
        return l.a(build);
    }

    public static void a(String str, Map<String, String> map, com.gigaset.update.a.e eVar) {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                formEncodingBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        Request build = new Request.Builder().url(str).post(formEncodingBuilder.build()).build();
        LogUtil.a("http url = " + str);
        l.a(build, new a(eVar));
    }
}
