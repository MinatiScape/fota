package com.gigaset.update.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.view.CheckScheduleView;
import com.gigaset.update.view.TitleContentView;
import com.gigaset.update.view.TitleView;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SettingActivity extends BaseActivity implements com.gigaset.update.a.c {

    /* renamed from: a  reason: collision with root package name */
    private TitleContentView f1076a;

    /* renamed from: b  reason: collision with root package name */
    private TitleContentView f1077b;
    private TitleContentView c;
    private int d;
    private int e = 0;

    private void a() {
        a(com.gigaset.update.utils.o.a((Context) this, "check_local_freq", com.gigaset.update.b.c.a()));
        boolean a2 = com.gigaset.update.utils.o.a(this, "download_only_wifi", com.gigaset.update.utils.c.k().y());
        LogUtil.a("isOnlyWifi = " + a2);
        this.f1077b.setChecked(a2);
        boolean a3 = com.gigaset.update.utils.o.a(this, "download_wifi_auto", com.gigaset.update.utils.c.k().u());
        LogUtil.a("isWifiAuto = " + a3);
        this.c.setChecked(a3);
    }

    private void b() {
        this.f1076a = (TitleContentView) findViewById(R.id.check_cycle);
        this.f1077b = (TitleContentView) findViewById(R.id.update_wifi_only);
        this.c = (TitleContentView) findViewById(R.id.wifi_auto_download);
        this.f1076a.setOnClickListener(this);
        this.f1077b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        TitleContentView titleContentView = (TitleContentView) findViewById(R.id.about);
        if (MyApplication.d()) {
            titleContentView.setVisibility(0);
            titleContentView.setOnClickListener(this);
        }
        if (com.gigaset.update.utils.c.k().x()) {
            this.f1076a.requestFocus();
        }
    }

    private void c() {
        CheckScheduleView checkScheduleView = new CheckScheduleView(this);
        checkScheduleView.setItemChecked(this.e);
        checkScheduleView.setOnItemClickListener(this);
        com.gigaset.update.utils.d.a(this, getString(R.string.setting_autocheck_title), checkScheduleView);
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void initWidget() {
        setContentView(R.layout.activity_setting);
        b();
        a();
    }

    @Override // com.gigaset.update.a.c
    public void onItemClick(int i) {
        closeDialog();
        b(i);
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void setTitleView(TitleView titleView) {
        titleView.setContent(getString(R.string.option_settings));
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.about /* 2131230731 */:
                ComponentName componentName = new ComponentName(com.gigaset.update.b.a.c, com.gigaset.update.b.a.d);
                Intent intent = new Intent();
                intent.setComponent(componentName);
                intent.putExtra("param", (Serializable) com.gigaset.update.g.d.a(this));
                startActivity(intent);
                return;
            case R.id.check_cycle /* 2131230776 */:
                c();
                return;
            case R.id.update_wifi_only /* 2131230959 */:
                com.gigaset.update.utils.o.b(this, "download_only_wifi", this.f1077b.a());
                return;
            case R.id.wifi_auto_download /* 2131230963 */:
                com.gigaset.update.utils.o.b(this, "download_wifi_auto", this.c.a());
                return;
            default:
                return;
        }
    }

    private void a(int i) {
        this.d = i;
        if (i == 1440) {
            this.e = 0;
            this.f1076a.setTip(R.string.setting_autocheck_schedule1);
        } else if (i == 4320) {
            this.e = 1;
            this.f1076a.setTip(R.string.setting_autocheck_schedule2);
        } else if (i == 10080) {
            this.e = 2;
            this.f1076a.setTip(R.string.setting_autocheck_schedule3);
        }
    }

    private void b(int i) {
        this.e = i;
        int i2 = R.string.setting_autocheck_schedule1;
        if (i == 0) {
            this.d = 1440;
        } else if (i == 1) {
            i2 = R.string.setting_autocheck_schedule2;
            this.d = 4320;
        } else if (i == 2) {
            i2 = R.string.setting_autocheck_schedule3;
            this.d = 10080;
        }
        this.f1076a.setTip(i2);
        com.gigaset.update.utils.o.b((Context) this, "check_local_freq", this.d);
        com.gigaset.update.manager.b.d(this);
    }
}
