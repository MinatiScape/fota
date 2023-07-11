package com.gigaset.update;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleOtaClient.java */
/* loaded from: classes.dex */
public class g implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GoogleOtaClient googleOtaClient) {
        this.f1133a = googleOtaClient;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        this.f1133a.queryFullRom();
    }
}
