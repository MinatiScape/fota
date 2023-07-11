package com.gigaset.update.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.activity.FileBrowserActivity;
import com.gigaset.update.utils.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PopWindowsLayout.java */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1224a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f1225b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(m mVar, Activity activity) {
        this.f1225b = mVar;
        this.f1224a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        popupWindow = this.f1225b.f1231a;
        popupWindow.dismiss();
        this.f1225b.f1231a = null;
        int c = com.gigaset.update.b.d.c(MyApplication.c());
        if (c != 5 && c != 2) {
            Activity activity = this.f1224a;
            activity.startActivity(new Intent(activity.getBaseContext(), FileBrowserActivity.class));
            return;
        }
        v.a((int) R.string.tips_abDownOrInstall);
    }
}
