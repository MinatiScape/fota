package com.gigaset.update.activity;

import android.os.Handler;
import android.view.View;
import com.gigaset.update.R;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.view.TitleView;
/* loaded from: classes.dex */
public class InstallResultActivity extends BaseActivity {
    @Override // com.gigaset.update.activity.BaseActivity
    protected void initWidget() {
        setContentView(R.layout.activity_update_result);
        String stringExtra = getIntent().getStringExtra("version");
        LogUtil.a("[onCreate] version name = " + stringExtra);
        new Handler().post(new e(this));
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void setTitleView(TitleView titleView) {
        titleView.setVisibility(8);
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void widgetClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        LogUtil.a("[showResultDialog] ============");
        com.gigaset.update.utils.d.b(this, getString(R.string.updateSuccessTitle), getString(R.string.updateSuccess, new Object[]{""}), new f(this), null);
    }
}
