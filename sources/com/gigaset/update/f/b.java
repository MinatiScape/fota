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
public class b implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar) {
        this.f1127a = eVar;
    }

    @Override // com.squareup.okhttp.Callback
    public void onFailure(Request request, IOException iOException) {
        LogUtil.a(iOException.getMessage());
    }

    @Override // com.squareup.okhttp.Callback
    public void onResponse(Response response) throws IOException {
        String string = response.body().string();
        LogUtil.a("response status_code = " + response.code() + "; isSuccessful = " + response.isSuccessful() + "; body() = " + string);
        if (response.isSuccessful() || (!TextUtils.isEmpty(string) && string.contains("ok"))) {
            com.gigaset.update.manager.c.c().a();
            t.a();
        }
    }
}
