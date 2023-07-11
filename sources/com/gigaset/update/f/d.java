package com.gigaset.update.f;

import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.i;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportManager.java */
/* loaded from: classes.dex */
public class d implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f1130a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f1131b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar, Map map) {
        this.f1131b = eVar;
        this.f1130a = map;
    }

    @Override // com.squareup.okhttp.Callback
    public void onFailure(Request request, IOException iOException) {
        LogUtil.a("http request fail,message:" + iOException.getMessage());
        this.f1131b.a("fcm", i.a(this.f1130a));
    }

    @Override // com.squareup.okhttp.Callback
    public void onResponse(Response response) throws IOException {
        LogUtil.a("response status_code = " + response.code() + "; isSuccessful = " + response.isSuccessful() + "; body() = " + response.body().string());
    }
}
