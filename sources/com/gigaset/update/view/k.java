package com.gigaset.update.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;
import com.gigaset.update.activity.SettingActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PopWindowsLayout.java */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1227a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f1228b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(m mVar, Activity activity) {
        this.f1228b = mVar;
        this.f1227a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        popupWindow = this.f1228b.f1231a;
        popupWindow.dismiss();
        this.f1228b.f1231a = null;
        Activity activity = this.f1227a;
        activity.startActivity(new Intent(activity.getBaseContext(), SettingActivity.class));
    }
}
