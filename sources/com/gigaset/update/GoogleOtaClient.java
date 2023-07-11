package com.gigaset.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Process;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.gigaset.update.activity.BaseActivity;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.n;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.q;
import com.gigaset.update.utils.t;
import com.gigaset.update.utils.v;
import com.gigaset.update.view.DeviceFunctionView;
import com.gigaset.update.view.FooterLayout;
import com.gigaset.update.view.InstallDelayView;
import com.gigaset.update.view.NetworkWarnView;
import com.gigaset.update.view.ProgressLayout;
import com.gigaset.update.view.ProgressTextLayout;
import com.gigaset.update.view.ShakeView;
import com.gigaset.update.view.TitleView;
import com.gigaset.update.view.m;
import com.google.android.material.appbar.AppBarLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class GoogleOtaClient extends BaseActivity implements com.gigaset.update.a.f, com.gigaset.update.a.d, com.gigaset.update.a.c, com.gigaset.update.a.b {
    private static final String ERROR_REASON_PAUSE = "PAUSE";
    private static final String ERROR_REASON_RESPONSE_UNDONE = "UNDONE";
    private static final int MSG_ADDITIONAL = 22;
    private static final int MSG_AUTO_CHECK = 33;
    private static final int MSG_DELAY_TIME = 11;
    private static final int MSG_FULL_CHECK = 34;
    private static final int REQUEST_CODE = 200;
    private static final long[] schedule_array = {3600000, 14400000, 28800000};
    private TextView ab_notice;
    private LinearLayout ab_view;
    private AppBarLayout appBarLayout;
    private TextView battery_tip;
    private k dialog;
    private int mClickCount;
    private FooterLayout mFooterLayout;
    private ProgressLayout mProgress;
    private TextView mReleaseView;
    private TextView mUpdateTip;
    private LinearLayout pre_view;
    private LinearLayout pro_view;
    private ProgressTextLayout progressTextLayout;
    private ProgressBar progress_update_id;
    private ImageView setting;
    private ShakeView shakeView;
    private TextView update_txt;
    private int delayTimeCounts = 15;
    private boolean isActiveSafe = false;
    private int userPause = 0;
    private long lastClickTime = 0;
    private Handler mHandler = new a(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int access$010(GoogleOtaClient googleOtaClient) {
        int i = googleOtaClient.delayTimeCounts;
        googleOtaClient.delayTimeCounts = i - 1;
        return i;
    }

    private void closeDebug() {
        LogUtil.b(false);
        o.b((Context) this, "debug_status", false);
        v.a((int) R.string.stop_catch_log);
    }

    private void deviceRooted() {
        LogUtil.a("enter");
        com.gigaset.update.b.d.d(this);
        initIdleView();
        com.gigaset.update.utils.d.a(this, (int) R.mipmap.ota_root, getString(R.string.ota_device_rooted_content), 17, getString(R.string.ota_full_rom_check), new g(this), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doConfirmCancel() {
        LogUtil.a("enter");
        this.mProgress.setProgress(0);
        com.gigaset.update.c.d.b().d(this);
        com.gigaset.update.b.d.a(this, 0);
        this.userPause = 1;
        initIdleView();
    }

    private void downloadCallback(EventMessage eventMessage) {
        int arg1 = eventMessage.getArg1();
        if (arg1 == 1000) {
            closeDialog();
            initDownloadStartView();
        } else if (arg1 == 1001) {
            if (isFront()) {
                initInstallView();
            }
        } else if (arg1 == 2000) {
            notifyDownloading(Long.valueOf(eventMessage.getArg2()).intValue());
        } else if (arg1 == 2001) {
            com.gigaset.update.b.d.a(this, 3);
            if (!com.gigaset.update.utils.c.k().v()) {
                this.shakeView.setVisibility(0);
                this.shakeView.setContent(R.string.shake_to_download);
            }
            this.mFooterLayout.a(3);
        } else if (arg1 != 3000) {
            if (arg1 != 5001) {
                return;
            }
            initPauseView(false);
            downloadWifiToMobile();
        } else {
            int c = com.gigaset.update.b.d.c(this);
            if (c != 2 && c != 3) {
                com.gigaset.update.b.d.d(this);
                initIdleView();
                return;
            }
            downloadFail(eventMessage.getObject().toString());
        }
    }

    private void downloadFail(String str) {
        LogUtil.a("enter");
        if (this.userPause == 1) {
            com.gigaset.update.b.d.d(this);
            LogUtil.a("user cancel cause download fail");
            this.userPause = 0;
            return;
        }
        initPauseView(false);
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase(getString(R.string.package_unzip_error))) {
                initIdleView();
                showToastOrDialog(str);
                com.gigaset.update.b.d.d(this);
            } else if (str.equalsIgnoreCase(ERROR_REASON_RESPONSE_UNDONE) || str.equalsIgnoreCase(ERROR_REASON_PAUSE)) {
            } else {
                showToastOrDialog(str);
            }
        } else if (!com.gigaset.update.utils.k.a(this)) {
            showToastOrDialog(getString(R.string.ota_toast_no_network));
        } else {
            VersionBean c = com.gigaset.update.e.c.a().c();
            if (c != null) {
                int b2 = t.b(this, c.getFileSize());
                if (b2 == 1) {
                    showToastOrDialog(getString(R.string.unmount_sdcard));
                } else if (b2 != 2) {
                } else {
                    showToastOrDialog(getString(R.string.sdcard_crash_or_unmount));
                }
            }
        }
    }

    private void downloadWifiToMobile() {
        LogUtil.a("enter");
        boolean a2 = o.a(this, "download_only_wifi", com.gigaset.update.utils.c.k().y());
        boolean b2 = com.gigaset.update.utils.k.b(this);
        if (a2 && b2) {
            LogUtil.a(" ota network  wifi  to mobile  dialog");
            com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.setting_network_tip), this);
        } else if (com.gigaset.update.utils.k.b(this)) {
            showDownloadNoticeDialog();
        }
    }

    private void exportData() {
        String str = getFilesDir().getParent() + "/shared_prefs/gigasetfota.xml";
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            v.a((int) R.string.sdcard_crash_or_unmount);
            return;
        }
        File file = new File(t.b(this) + "/fota");
        if (!file.exists()) {
            file.mkdirs();
        }
        new Thread(new f(this, str, file.getAbsolutePath() + "/gigasetfota.txt", getFilesDir().getAbsolutePath() + "/" + com.gigaset.update.b.a.f1100b, file.getAbsolutePath() + "/" + com.gigaset.update.b.a.f1100b)).start();
        v.a(getString(R.string.export_data) + " to " + file.getAbsolutePath());
    }

    private void initDownloadStartView() {
        LogUtil.a("enter");
        com.gigaset.update.b.d.a(this, 2);
        this.mUpdateTip.setVisibility(0);
        this.shakeView.setVisibility(8);
        loadReleaseNotes();
        this.mFooterLayout.a(2);
        setDownloadProgress(getPercent());
        LogUtil.a("exit");
    }

    private void initDownloadView() {
        LogUtil.a("enter");
        if (!com.gigaset.update.c.d.b().c(this)) {
            com.gigaset.update.b.d.a(this, 3);
            initPauseView(true);
        } else {
            this.shakeView.setVisibility(8);
            com.gigaset.update.b.d.a(this, 2);
            this.mUpdateTip.setVisibility(0);
            loadReleaseNotes();
            int percent = getPercent();
            this.mFooterLayout.a(2);
            setDownloadProgress(percent);
        }
        LogUtil.a("exit");
    }

    private void initIdleView() {
        LogUtil.a("enter");
        com.gigaset.update.b.d.a(this, 0);
        showAbView(false, false);
        this.mUpdateTip.setVisibility(8);
        this.progressTextLayout.setVisibility(8);
        if (!com.gigaset.update.utils.c.k().v()) {
            this.shakeView.setContent(R.string.shake_to_check);
        }
        String g = com.gigaset.update.utils.c.k().g();
        if (TextUtils.isEmpty(g)) {
            g = com.gigaset.update.utils.c.k().l();
        }
        this.mReleaseView.setText(Html.fromHtml(getResources().getString(R.string.htmlstring_version) + getString(R.string.current_version_text) + getResources().getString(R.string.htmlstring_version_end) + getResources().getString(R.string.htmlstring_code_head) + g + getResources().getString(R.string.htmlstring_code_end)));
        this.mFooterLayout.a(0);
        this.mProgress.a();
        LogUtil.a("exit");
    }

    private void initInstallView() {
        LogUtil.a("enter");
        if (com.gigaset.update.e.c.a().c() == null) {
            initIdleView();
            return;
        }
        com.gigaset.update.b.d.a(this, 4);
        this.mUpdateTip.setVisibility(0);
        if (!com.gigaset.update.utils.c.k().v()) {
            this.shakeView.setContent(R.string.shake_to_update);
        }
        loadReleaseNotes();
        this.mFooterLayout.a(4);
        if (com.gigaset.update.d.d.a()) {
            showAbView(true, false);
            if (com.gigaset.update.d.d.a(this, com.gigaset.update.utils.c.k().b())) {
                com.gigaset.update.f.a.a(this, "update");
                com.gigaset.update.d.d.e(this);
            } else {
                LogUtil.a("no update reason : battery not enough");
                CustomActionService.a(this, 15);
                org.greenrobot.eventbus.e.a().b(new EventMessage(300, 100, 0L, 617L, "ab"));
            }
        } else {
            LogUtil.a("no update reason : not support ab update");
        }
        if (com.gigaset.update.utils.c.k().x()) {
            this.progressTextLayout.setProgress(100);
        }
        this.mProgress.setDownLoadProgress(100);
        LogUtil.a("exit");
    }

    private void initInstallingView() {
        showAbView(true, true);
        this.mProgress.a();
        this.update_txt.setText(R.string.ab_installing);
        this.mFooterLayout.a(5);
        if (com.gigaset.update.b.d.c(this) == 5) {
            new Thread(new b(this)).start();
        }
    }

    private void initNewVersionView() {
        LogUtil.a("enter");
        com.gigaset.update.b.d.a(this, 1);
        this.mUpdateTip.setVisibility(0);
        this.progressTextLayout.setVisibility(8);
        if (!com.gigaset.update.utils.c.k().v()) {
            this.shakeView.setContent(R.string.shake_to_download);
        }
        loadReleaseNotes();
        this.mFooterLayout.a(1);
        this.mProgress.a();
        this.mProgress.setVersionTip(getString(R.string.new_version_text));
        LogUtil.a("exit");
    }

    private void initPauseView(boolean z) {
        LogUtil.a("enter");
        com.gigaset.update.b.d.a(this, 3);
        this.mUpdateTip.setVisibility(0);
        if (!com.gigaset.update.utils.c.k().v()) {
            this.shakeView.setVisibility(0);
            this.shakeView.setContent(R.string.shake_to_download);
        }
        if (z) {
            loadReleaseNotes();
        }
        int percent = getPercent();
        this.mFooterLayout.a(3);
        setDownloadProgress(percent);
        LogUtil.a("exit");
    }

    private void initRebootView() {
        showAbView(true, false);
        this.battery_tip.setText(R.string.updated_need_reboot);
        this.mFooterLayout.a(6);
    }

    private void initStatus() {
        int c = com.gigaset.update.b.d.c(this);
        LogUtil.a("version_status = " + c);
        showAbView(false, false);
        closeDialog();
        switch (c) {
            case 0:
                initIdleView();
                return;
            case 1:
                if (com.gigaset.update.e.c.a().c() != null) {
                    this.userPause = 0;
                    initNewVersionView();
                    return;
                }
                initIdleView();
                return;
            case 2:
                initDownloadView();
                return;
            case 3:
                if (com.gigaset.update.e.c.a().c() == null) {
                    initIdleView();
                    return;
                } else {
                    initPauseView(true);
                    return;
                }
            case 4:
                initInstallView();
                return;
            case 5:
                initInstallingView();
                return;
            case 6:
                initRebootView();
                return;
            default:
                initIdleView();
                return;
        }
    }

    private void initView() {
        LogUtil.a("enter");
        this.mFooterLayout = (FooterLayout) findViewById(R.id.footer_layout);
        this.mFooterLayout.setOnClickListener(this);
        this.mProgress = (ProgressLayout) findViewById(R.id.progress_layout);
        this.mUpdateTip = (TextView) findViewById(R.id.ota_update_tip);
        this.mReleaseView = (TextView) findViewById(R.id.relese_view);
        this.pre_view = (LinearLayout) findViewById(R.id.pre_view);
        this.ab_view = (LinearLayout) findViewById(R.id.ab_view);
        this.pro_view = (LinearLayout) findViewById(R.id.pro_view);
        this.battery_tip = (TextView) findViewById(R.id.battery_tip);
        this.update_txt = (TextView) findViewById(R.id.update_txt);
        this.progress_update_id = (ProgressBar) findViewById(R.id.progress_update_id);
        this.appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        this.progressTextLayout = (ProgressTextLayout) findViewById(R.id.progressLayout);
        this.shakeView = (ShakeView) findViewById(R.id.shakeView);
        this.ab_notice = (TextView) findViewById(R.id.ab_notice);
        LogUtil.a("[initView] finish");
    }

    private void installCallback(EventMessage eventMessage) {
        closeDialog();
        int b2 = com.gigaset.update.utils.c.k().b();
        if (eventMessage.getObject() != null && !TextUtils.isEmpty(eventMessage.getObject().toString()) && eventMessage.getObject().toString().equals("ab")) {
            LogUtil.a("ab installCallback enter");
            if (eventMessage.getArg3() == 601) {
                if (eventMessage.getArg1() == 0) {
                    com.gigaset.update.utils.d.a(this, getString(R.string.ab_install_success), getString(R.string.updated_need_reboot), new h(this), this);
                    showAbView(true, false);
                    this.battery_tip.setText(R.string.updated_need_reboot);
                    this.mFooterLayout.a(6);
                    return;
                }
                LogUtil.a("installCallback,install fail");
                com.gigaset.update.b.d.d(this);
                initIdleView();
                String string = getString(R.string.ab_install_fail);
                com.gigaset.update.utils.d.a(this, string, getString(R.string.ab_isnatll_fail_reason) + eventMessage.getArg1(), this);
                return;
            } else if (eventMessage.getArg3() == 600) {
                LogUtil.a("installCallback,installing");
                this.mProgress.a();
                this.mFooterLayout.a(5);
                showAbView(true, true);
                this.update_txt.setText(R.string.ab_installing);
                return;
            } else if (eventMessage.getArg3() == 617) {
                showAbView(true, false);
                this.mFooterLayout.a(4);
                this.battery_tip.setText(getString(R.string.ab_battery_low, new Object[]{Integer.valueOf(b2)}));
                return;
            } else if (eventMessage.getArg3() == 618) {
                com.gigaset.update.b.d.d(this);
                initIdleView();
                com.gigaset.update.utils.d.a(this, getString(R.string.ab_install_fail), getString(R.string.ab_parms_illegal), this);
                return;
            } else if (eventMessage.getArg3() == 619) {
                com.gigaset.update.b.d.d(this);
                initIdleView();
                com.gigaset.update.utils.d.a(this, getString(R.string.ab_install_fail), getString(R.string.ab_connect_fail), this);
                return;
            } else if (eventMessage.getArg3() == 602) {
                return;
            } else {
                if (eventMessage.getArg3() == 620) {
                    com.gigaset.update.b.d.d(this);
                    initIdleView();
                    com.gigaset.update.utils.d.a(this, getString(R.string.ab_install_fail), getString(R.string.sdCard_upgrade_find_update_file_fail), this);
                    return;
                } else if (eventMessage.getArg3() == 621) {
                    showAbView(true, false);
                    this.mFooterLayout.a(4);
                    this.battery_tip.setText(String.format("ab-%s", getString(R.string.not_support_version)));
                    String string2 = getString(R.string.not_support_fota_title);
                    com.gigaset.update.utils.d.a(this, string2, "ab-" + getString(R.string.not_support_version), this);
                    return;
                } else {
                    return;
                }
            }
        }
        switch (eventMessage.getArg1()) {
            case 401:
            case 403:
            case 408:
            case 410:
                com.gigaset.update.b.d.d(this);
                initIdleView();
                com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.package_unzip_error), this);
                return;
            case 402:
            case 409:
            case 411:
                com.gigaset.update.b.d.d(this);
                initIdleView();
                com.gigaset.update.utils.d.a(this, getString(R.string.package_error_title), getString(R.string.package_error_message_invalid), this);
                return;
            case 404:
                deviceRooted();
                return;
            case 405:
                LogUtil.a("UPDATE_STATUS_OK");
                if (com.gigaset.update.d.d.a()) {
                    return;
                }
                com.gigaset.update.utils.d.a(this, (int) R.layout.dialog_update_reboot, this);
                return;
            case 406:
            case 407:
            default:
                com.gigaset.update.b.d.d(this);
                initIdleView();
                com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.not_support_version), this);
                return;
        }
    }

    private boolean isClick2Fast() {
        long currentTimeMillis = System.currentTimeMillis() - this.lastClickTime;
        this.lastClickTime = System.currentTimeMillis();
        return 0 < currentTimeMillis && currentTimeMillis < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOverRemindDate() {
        String a2 = o.a(this, "ota_check_once_day", "");
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
        if (a2.equals(format)) {
            return false;
        }
        o.b(this, "ota_check_once_day", format);
        return true;
    }

    private void loadReleaseNotes() {
        LogUtil.a("enter");
        VersionBean c = com.gigaset.update.e.c.a().c();
        if (c != null) {
            this.mReleaseView.setText(Html.fromHtml(com.gigaset.update.e.c.a().a((Context) this, true)));
            LogUtil.a("loadReleaseNotes:" + com.gigaset.update.e.c.a().b());
            if (com.gigaset.update.e.c.a().b().equals("zh_CN")) {
                this.mReleaseView.setTypeface(Typeface.createFromAsset(MyApplication.c().getAssets(), "fonts/wen_quan.ttf"));
            } else {
                this.mReleaseView.setTypeface(null);
            }
            if (c.getIsSilent() == 0) {
                this.mHandler.sendEmptyMessageDelayed(22, 1000L);
            }
        }
        LogUtil.a("exit");
    }

    private void noFindVersion() {
        LogUtil.a("enter");
        int c = com.gigaset.update.b.d.c(this);
        if (c == 0) {
            this.mProgress.setVersionTip(getString(R.string.no_new_version));
        }
        if (c == 0 && isFront()) {
            v.a((int) R.string.no_new_version);
        }
    }

    private void notifyDownloading(int i) {
        if (com.gigaset.update.b.d.c(this) != 2) {
            com.gigaset.update.b.d.a(this, 2);
            this.mUpdateTip.setVisibility(0);
            loadReleaseNotes();
            this.mFooterLayout.a(2);
        }
        setDownloadProgress(i);
    }

    private void onClickCancel() {
        LogUtil.a("enter");
        if (com.gigaset.update.b.d.c(this) == 2) {
            com.gigaset.update.c.d.b().f(this);
            initPauseView(false);
        }
        com.gigaset.update.utils.d.a(this, getString(R.string.cancel_download_title), getString(R.string.cancel_download_content), getString(R.string.cancel_download_positive_btn), new c(this), getString(R.string.cancel_download_negative_btn), (com.gigaset.update.a.a) null, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onClickDownload() {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.GoogleOtaClient.onClickDownload():void");
    }

    private void onClickInstallLater() {
        LogUtil.a("enter");
        int a2 = o.a((Context) this, "install_later_count", 0) + 1;
        LogUtil.a("installLaterCount=" + a2);
        o.b((Context) this, "install_later_count", a2);
        long c = o.c(this, "ota_install_delay_schedule");
        LogUtil.a("schedule_time = " + c);
        if (c <= 0) {
            showInstallDelayDialog();
        } else {
            finish();
        }
    }

    private void onClickPause() {
        LogUtil.a("enter");
        com.gigaset.update.c.d.b().f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickQuery() {
        boolean a2 = com.gigaset.update.utils.k.a(this);
        LogUtil.a("isConnected = " + a2);
        if (a2) {
            com.gigaset.update.e.g.a().a(this, 2);
        } else {
            showNoNetWorkDialog();
        }
    }

    private void onClickResume(boolean z) {
        LogUtil.a("enter");
        if (MyApplication.e() && !com.gigaset.update.utils.k.c(this)) {
            com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.call_warn), this);
        } else if (com.gigaset.update.utils.k.a(this)) {
            boolean a2 = o.a(this, "download_only_wifi", com.gigaset.update.utils.c.k().y());
            boolean b2 = com.gigaset.update.utils.k.b(this);
            if (a2 && b2) {
                com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.setting_network_tip), this);
                LogUtil.a("no download reason : only support wifi update but mobile wifi off");
                com.gigaset.update.f.a.a((Context) this, false, 417, (String) null);
                return;
            }
            VersionBean c = com.gigaset.update.e.c.a().c();
            if (c != null) {
                int b3 = t.b(this, c.getFileSize());
                if (b3 == 1) {
                    LogUtil.a("no download reason : no sd card mounted");
                    com.gigaset.update.f.a.a((Context) this, false, 418, (String) null);
                    com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.unmount_sdcard), this);
                    return;
                } else if (b3 == 2) {
                    LogUtil.a("no download reason : sd card status not illegal");
                    com.gigaset.update.f.a.a((Context) this, false, 419, (String) null);
                    com.gigaset.update.utils.d.a(this, getString(R.string.sdCard_upgrade_memory_space_not_enough), getString(R.string.sdcard_crash_or_unmount), this);
                    return;
                }
            }
            if (!com.gigaset.update.utils.k.b(this)) {
                com.gigaset.update.c.d.b().a(this, 0);
                com.gigaset.update.b.d.a(this, 2);
                this.mFooterLayout.a(2);
            } else if (z) {
                showDownloadNoticeDialog();
            } else {
                int intValue = ((Integer) com.gigaset.update.e.c.a().a("download_auto", Integer.class)).intValue();
                int intValue2 = ((Integer) com.gigaset.update.e.c.a().a("download_wifi", Integer.class)).intValue();
                if (intValue == 1 && intValue2 == 0) {
                    return;
                }
                showDownloadNoticeDialog();
            }
        } else {
            LogUtil.a("no download reason : no net connect");
            showNoNetWorkDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickSchedule(int i) {
        LogUtil.a("delay time: " + schedule_array[i]);
        o.b(this, "ota_install_delay_schedule", schedule_array[i]);
        com.gigaset.update.manager.b.a(this, schedule_array[i] + System.currentTimeMillis());
        saveDelayInstallData();
        com.gigaset.update.manager.h.a().a(this, 105);
        closeDialog();
        finish();
    }

    private void onClickTitle() {
        String str;
        DeviceFunctionView deviceFunctionView = new DeviceFunctionView(this);
        String a2 = com.gigaset.update.utils.c.k().a();
        String str2 = "APK Release Date:2023-02-15 11:29\nFCM ID: " + com.gigaset.update.manager.i.h() + "\n";
        if (a2.equals("sn")) {
            str = str2 + "SN: " + com.gigaset.update.utils.c.k().a(this) + "\n";
        } else if (a2.equals("mac")) {
            str = str2 + "MAC: " + com.gigaset.update.utils.c.k().a(this) + "\n";
        } else {
            str = str2 + "IMEI: " + com.gigaset.update.utils.c.k().a(this) + "\n";
        }
        String str3 = str + "MID: " + com.gigaset.update.utils.j.b(this) + "\nSPN: " + com.gigaset.update.utils.c.k().c(this) + "\nAppVersionName: " + n.b(this) + ".0.222208.006_2023-02-15 11:29\nAppVersionCode: " + n.a(this) + "\nversion: " + com.gigaset.update.utils.c.k().l() + "\nproject: " + com.gigaset.update.utils.c.k().p();
        if (!TextUtils.isEmpty(com.gigaset.update.utils.c.k().a(this)) && !com.gigaset.update.utils.c.k().a(this).matches("^[A-Za-z0-9:]+$")) {
            v.a((int) R.string.match_imei);
        }
        deviceFunctionView.setInfo(str3);
        deviceFunctionView.setOnFunctionClickListener(this);
        com.gigaset.update.utils.d.a(this, getString(R.string.app_name), this, deviceFunctionView);
    }

    private void queryCallback(EventMessage eventMessage) {
        closeDialog();
        int c = com.gigaset.update.b.d.c(this);
        int arg1 = eventMessage.getArg1();
        if (arg1 == 404) {
            deviceRooted();
        } else if (arg1 == 1009) {
            if (c == 0 && isFront()) {
                com.gigaset.update.utils.d.b(this, null, this, LayoutInflater.from(this).inflate(R.layout.dialog_loading, (ViewGroup) null));
            }
        } else if (arg1 == 1111) {
            updateSafeFlag();
        } else if (arg1 == 3005) {
            v.a((int) R.string.sdcard_crash_or_unmount);
        } else if (arg1 == 3008) {
            tipsMessage(eventMessage);
        } else if (arg1 != 3010) {
            switch (arg1) {
                case TarArchiveEntry.MILLIS_PER_SECOND /* 1000 */:
                default:
                    return;
                case 1001:
                case 1004:
                    this.userPause = 0;
                    initNewVersionView();
                    return;
                case 1002:
                case 1003:
                    noFindVersion();
                    return;
                case 1005:
                    if (c < 2) {
                        initNewVersionView();
                        return;
                    }
                    return;
                case 1006:
                    initIdleView();
                    return;
                case 1007:
                    com.gigaset.update.c.c.b().a(this);
                    com.gigaset.update.b.d.d(this);
                    initIdleView();
                    this.mHandler.sendEmptyMessageDelayed(34, 1200L);
                    return;
            }
        } else {
            tipsMessage(eventMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryFullRom() {
        LogUtil.a("enter");
        if (com.gigaset.update.utils.k.a(this)) {
            com.gigaset.update.e.g.a().a(this, 2, 2);
        } else {
            showNoNetWorkDialog();
        }
    }

    private void resetAlarm() {
        long c = o.c(this, "ota_install_delay_schedule");
        LogUtil.a("schedule_time = " + c);
        if (c > 0) {
            com.gigaset.update.manager.b.a(this, c + System.currentTimeMillis());
        }
    }

    private void saveDelayInstallData() {
        com.gigaset.update.f.a.a(this, "delay");
    }

    private void setDownloadProgress(int i) {
        if (com.gigaset.update.utils.c.k().w()) {
            this.progressTextLayout.setProgress(i);
        } else {
            this.mProgress.setDownLoadProgress(i);
        }
    }

    private void showAbView(boolean z, boolean z2) {
        if (z) {
            this.pre_view.setVisibility(8);
            this.ab_view.setVisibility(0);
            if (z2) {
                this.pro_view.setVisibility(0);
                this.battery_tip.setVisibility(8);
                this.ab_notice.setVisibility(0);
                return;
            }
            this.pro_view.setVisibility(8);
            this.battery_tip.setVisibility(0);
            this.ab_notice.setVisibility(8);
            return;
        }
        this.pre_view.setVisibility(0);
        this.ab_view.setVisibility(8);
    }

    private void showDownloadNoticeDialog() {
        NetworkWarnView networkWarnView = new NetworkWarnView(this);
        networkWarnView.setTitle(getString(R.string.ota_no_wifi_tip));
        com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(17039360), new d(this), getString(R.string.btn_download), new e(this), this, networkWarnView);
    }

    private void showInstallDelayDialog() {
        this.delayTimeCounts = 15;
        InstallDelayView installDelayView = new InstallDelayView(this);
        installDelayView.setOnItemClickListener(this);
        this.dialog = com.gigaset.update.utils.d.a(this, getString(R.string.remind_last_time) + "(" + this.delayTimeCounts + ")", 17, this, installDelayView);
        this.delayTimeCounts--;
        this.mHandler.sendEmptyMessageDelayed(11, 1000L);
    }

    private void showNoNetWorkDialog() {
        com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), this, new NetworkWarnView(this));
    }

    private void showToastOrDialog(String str) {
        LogUtil.a("showToastOrDialog,message=" + str);
        if (isFront()) {
            v.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statusAction(int i) {
        if (i == 1) {
            onClickDownload();
        } else if (i != 4) {
        } else {
            onClickInstallNow();
        }
    }

    private void updateSafeFlag() {
        if (this.isActiveSafe) {
            return;
        }
        this.isActiveSafe = true;
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void closeDialog() {
        if (isFront()) {
            super.closeDialog();
        }
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void dealWithIntent(Intent intent) {
        super.dealWithIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("flag");
            if (TextUtils.isEmpty(stringExtra) || !stringExtra.equalsIgnoreCase("install")) {
                return;
            }
            onClickInstallNow();
            resetAlarm();
        }
    }

    public int getPercent() {
        if (com.gigaset.update.e.c.a().c() == null) {
            return 0;
        }
        return com.gigaset.update.manager.i.e();
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void initWidget() {
        LogUtil.a("enter");
        if (n.a(Process.myUid()) != 0) {
            v.a((int) R.string.guest_hint);
            finish();
        }
        setContentView(R.layout.activity_ota_client);
        initView();
        if (com.gigaset.update.utils.c.k().w()) {
            this.appBarLayout.setVisibility(8);
        }
        if (!org.greenrobot.eventbus.e.a().a(this)) {
            org.greenrobot.eventbus.e.a().c(this);
        }
        this.mHandler.sendEmptyMessageDelayed(33, 1000L);
        LogUtil.a("exit");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout != null && drawerLayout.f(3)) {
            this.mDrawerLayout.a(3);
        } else if (com.gigaset.update.b.d.c(this) != 2 && com.gigaset.update.b.d.c(this) != 1 && com.gigaset.update.b.d.c(this) != 5) {
            finish();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // com.gigaset.update.a.d
    public void onClick(int i) {
        onClickSchedule(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MyApplication.f();
        this.mHandler.removeCallbacksAndMessages(null);
        org.greenrobot.eventbus.e.a().d(this);
    }

    @Override // com.gigaset.update.activity.BaseActivity, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.mFooterLayout.a();
    }

    @Override // com.gigaset.update.a.c
    public void onItemClick(int i) {
        if (i == 0) {
            exportData();
        } else if (i != 1) {
            if (i != 2) {
                return;
            }
            closeDebug();
        } else if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, REQUEST_CODE);
        } else {
            openDebug();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && com.gigaset.update.utils.c.k().C()) {
            new m().a(this, this.setting);
            return true;
        }
        LogUtil.a("keyCode : " + i);
        if (com.gigaset.update.utils.c.k().x() && i == 20) {
            this.mFooterLayout.a();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @org.greenrobot.eventbus.o(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage eventMessage) {
        LogUtil.a(" what  = " + eventMessage.getWhat() + "; param1= " + eventMessage.getArg1() + "; param2= " + eventMessage.getArg2() + "; param3= " + eventMessage.getArg3() + "");
        int what = eventMessage.getWhat();
        if (what == 100) {
            queryCallback(eventMessage);
        } else if (what == REQUEST_CODE) {
            downloadCallback(eventMessage);
        } else if (what != 300) {
        } else {
            installCallback(eventMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.gigaset.update.manager.a.b().a(false);
        q.a().b();
    }

    @Override // com.gigaset.update.a.b
    public void onPhoneCalling() {
        LogUtil.a("");
        if (com.gigaset.update.b.d.c(this) == 2) {
            onClickPause();
        }
    }

    @Override // com.gigaset.update.a.b
    public void onPhoneOff() {
        LogUtil.a("");
        if (com.gigaset.update.b.d.c(this) == 3) {
            onClickResume(false);
        }
    }

    @Override // com.gigaset.update.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.b.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == REQUEST_CODE && Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            openDebug();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initStatus();
        MyApplication.a(this);
        com.gigaset.update.manager.a.b().a(true);
        if (com.gigaset.update.utils.c.k().v()) {
            return;
        }
        q.a().a((com.gigaset.update.a.f) this);
    }

    @Override // com.gigaset.update.a.f
    public void onShaking() {
        if (com.gigaset.update.utils.c.k().v()) {
            LogUtil.a("onShaking isHideShake and return ");
            return;
        }
        closeDialog();
        int c = com.gigaset.update.b.d.c(this);
        LogUtil.a("status : " + c);
        if (c == 0) {
            onClickQuery();
        } else if (c == 1) {
            onClickDownload();
        } else if (c == 3) {
            onClickResume(true);
        } else if (c != 4) {
        } else {
            onClickInstallNow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void onTitleClick(View view) {
        int i = this.mClickCount + 1;
        this.mClickCount = i;
        if (i > 4) {
            this.mClickCount = 0;
            onClickTitle();
            LogUtil.a(true);
        }
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void setTitleView(TitleView titleView) {
        if (com.gigaset.update.utils.c.k().C()) {
            titleView.setSettingVisible(true);
            titleView.setSettingClickListener(this);
        }
        this.setting = titleView.getSetting();
    }

    public void tipsMessage(EventMessage eventMessage) {
        try {
            if (com.gigaset.update.b.d.c(this) == 0 && isFront()) {
                if (com.gigaset.update.utils.k.a(this)) {
                    if (eventMessage.getArg2() == 0 && eventMessage.getObject() != null) {
                        String replaceAll = "https://mobileupdate.gigaset.com".replaceAll("https://", "");
                        String replaceAll2 = "https://mobileupdate.gigaset.com".replaceAll("https://", "");
                        v.a(getString(R.string.network_error) + "(" + eventMessage.getObject().toString().replaceAll(replaceAll, "fota server ").replaceAll(replaceAll2, "fota server ") + ")");
                    }
                    v.a(getString(R.string.network_error) + "(" + eventMessage.getArg2() + ")");
                } else {
                    v.a((int) R.string.ota_toast_no_network);
                }
            }
        } catch (Exception unused) {
            v.a((int) R.string.ota_toast_no_network);
        }
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void widgetClick(View view) {
        if (view.getTag() == null) {
            return;
        }
        if (isClick2Fast()) {
            v.a((int) R.string.button_click_toast);
            return;
        }
        switch (((Integer) view.getTag()).intValue()) {
            case 0:
                onClickQuery();
                return;
            case 1:
                onClickDownload();
                return;
            case 2:
                onClickPause();
                return;
            case 3:
            case 4:
                onClickResume(true);
                return;
            case 5:
                onClickCancel();
                return;
            case 6:
            case 11:
            default:
                return;
            case 7:
                onClickInstallNow();
                return;
            case 8:
                onClickInstallLater();
                return;
            case 9:
                openMenu();
                return;
            case 10:
                new m().a(this, view);
                return;
            case 12:
                com.gigaset.update.h.d.a().a(this);
                return;
        }
    }
}
