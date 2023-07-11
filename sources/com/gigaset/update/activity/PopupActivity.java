package com.gigaset.update.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.view.TitleView;
/* loaded from: classes.dex */
public class PopupActivity extends BaseActivity {
    private void a(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        LogUtil.a("status : " + intExtra);
        if (intExtra == 1) {
            com.gigaset.update.utils.d.a(this, getString(R.string.sdCard_upgrade_hint), com.gigaset.update.e.c.a().a((Context) this, false), getString(R.string.btn_download), new g(this), getString(R.string.btn_ignore), new h(this), (DialogInterface.OnDismissListener) null);
        } else if (intExtra != 4) {
            if (intExtra != 8) {
                finish();
                return;
            }
            com.gigaset.update.utils.d.a(this, getString(R.string.dialog_title), getString(R.string.dialog_auto_install), getString(17039370), new m(this), null);
            new Handler(MyApplication.c().getMainLooper()).postDelayed(new n(this), 5000L);
        } else if (com.gigaset.update.manager.i.n()) {
            com.gigaset.update.utils.d.a(this, getString(R.string.new_to_upgrade), (String) null, getString(R.string.update_now), new i(this), getString(R.string.update_later), new j(this));
        } else {
            com.gigaset.update.manager.i.c(true);
            com.gigaset.update.utils.d.a(this, getString(R.string.new_to_upgrade), getString(R.string.update_now), new k(this), getString(R.string.update_later), new l(this), (DialogInterface.OnDismissListener) null, (View) null);
        }
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void initWidget() {
        setContentView(R.layout.activity_fota_pop_window);
        a(getIntent());
        com.gigaset.update.manager.i.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        closeDialog();
        a(intent);
        com.gigaset.update.manager.i.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.gigaset.update.manager.a.b().a();
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void setTitleView(TitleView titleView) {
        titleView.setVisibility(8);
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void widgetClick(View view) {
    }
}
