package com.gigaset.update.activity;

import android.view.View;
import com.gigaset.update.R;
import com.gigaset.update.view.TitleView;
/* loaded from: classes.dex */
public class ShortCutActivity extends BaseActivity {
    @Override // com.gigaset.update.activity.BaseActivity
    protected void initWidget() {
        setContentView(R.layout.activity_short_cut);
        com.gigaset.update.manager.g.b(this);
        finish();
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void setTitleView(TitleView titleView) {
        titleView.setVisibility(8);
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void widgetClick(View view) {
    }
}
