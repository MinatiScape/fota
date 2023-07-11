package com.gigaset.update.view;

import android.view.View;
import android.widget.PopupWindow;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.utils.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PopWindowsLayout.java */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(m mVar) {
        this.f1226a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        popupWindow = this.f1226a.f1231a;
        popupWindow.dismiss();
        this.f1226a.f1231a = null;
        if (com.gigaset.update.b.d.c(MyApplication.c()) == 5) {
            v.a((int) R.string.tips_abInstall);
        } else {
            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1007, 0L, 0L, null));
        }
    }
}
