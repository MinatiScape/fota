package com.gigaset.update;

import com.gigaset.update.utils.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleOtaClient.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GoogleOtaClient googleOtaClient) {
        this.f1098a = googleOtaClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.gigaset.update.h.d a2 = com.gigaset.update.h.d.a();
        GoogleOtaClient googleOtaClient = this.f1098a;
        a2.b(googleOtaClient, t.d(googleOtaClient));
    }
}
