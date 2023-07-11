package com.gigaset.update.view;

import android.app.Activity;
import android.view.View;
/* compiled from: PopWindowsLayout.java */
/* loaded from: classes.dex */
class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1229a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f1230b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar, Activity activity) {
        this.f1230b = mVar;
        this.f1229a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1229a.finish();
    }
}
