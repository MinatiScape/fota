package com.gigaset.update.g;

import com.gigaset.update.utils.LogUtil;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
/* compiled from: HttpRequest.java */
/* loaded from: classes.dex */
class a implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.gigaset.update.a.e f1134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.gigaset.update.a.e eVar) {
        this.f1134a = eVar;
    }

    @Override // com.squareup.okhttp.Callback
    public void onFailure(Request request, IOException iOException) {
        LogUtil.a("http request fail,message:" + iOException.getMessage());
    }

    @Override // com.squareup.okhttp.Callback
    public void onResponse(Response response) {
        try {
            LogUtil.a("http request success,response code = " + response.code() + ",response content:" + response.body().string());
            if (response.isSuccessful()) {
                if (this.f1134a != null) {
                    this.f1134a.a(response.body().string());
                }
            } else {
                LogUtil.a("http request error,message:" + response.message());
            }
        } catch (Exception e) {
            LogUtil.a("http request exception,message:" + e.getMessage());
        }
    }
}
