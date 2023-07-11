package com.gigaset.update.f;

import android.text.TextUtils;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.t;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportManager.java */
/* loaded from: classes.dex */
public class c implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1128a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1129b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar, String str, String str2) {
        this.c = eVar;
        this.f1128a = str;
        this.f1129b = str2;
    }

    @Override // com.squareup.okhttp.Callback
    public void onFailure(Request request, IOException iOException) {
        LogUtil.a(iOException.getMessage());
        this.c.a(this.f1128a, this.f1129b);
    }

    @Override // com.squareup.okhttp.Callback
    public void onResponse(Response response) throws IOException {
        String string = response.body().string();
        LogUtil.a("response status_code = " + response.code() + "; isSuccessful = " + response.isSuccessful() + "; body() = " + string);
        if (!response.isSuccessful() && (TextUtils.isEmpty(string) || !string.contains("ok"))) {
            this.c.a(this.f1128a, this.f1129b);
            return;
        }
        t.a();
        LogUtil.a("reportData success!!!");
    }
}
