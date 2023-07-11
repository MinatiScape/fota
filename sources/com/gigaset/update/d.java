package com.gigaset.update;

import com.gigaset.update.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleOtaClient.java */
/* loaded from: classes.dex */
public class d implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GoogleOtaClient googleOtaClient) {
        this.f1110a = googleOtaClient;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        LogUtil.a("no download reason : user cancel");
        com.gigaset.update.f.a.a(this.f1110a, "cancel", 0L);
    }
}
