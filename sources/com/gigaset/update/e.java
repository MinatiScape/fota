package com.gigaset.update;

import com.gigaset.update.view.FooterLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleOtaClient.java */
/* loaded from: classes.dex */
public class e implements com.gigaset.update.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GoogleOtaClient googleOtaClient) {
        this.f1116a = googleOtaClient;
    }

    @Override // com.gigaset.update.a.a
    public void a() {
        FooterLayout footerLayout;
        com.gigaset.update.c.d.b().a(this.f1116a, 0);
        com.gigaset.update.b.d.a(this.f1116a, 2);
        footerLayout = this.f1116a.mFooterLayout;
        footerLayout.a(2);
    }
}
