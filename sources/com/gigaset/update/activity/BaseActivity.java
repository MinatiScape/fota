package com.gigaset.update.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.gigaset.update.GoogleOtaClient;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.v;
import com.gigaset.update.view.TitleView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnDismissListener {
    private static final String FCM_REPORT_TYPE_FILE_PATH = "1";
    public static final String FCM_REPORT_TYPE_LOG = "3";
    private static final String FCM_REPORT_TYPE_STORAGE_SPACE = "2";
    private static final int REQUEST_CODE = 300;
    private static final int REQUEST_READ_CODE = 100;
    protected static Context mContext;
    private LinearLayout layout;
    public DrawerLayout mDrawerLayout;
    private Map<String, String> param;
    private boolean mAllowFullScreen = true;
    private boolean isFront = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPopWindows() {
        if (getActivityName().equalsIgnoreCase(GoogleOtaClient.class.getSimpleName())) {
            return;
        }
        finish();
    }

    private String getActivityName() {
        return getClass().getSimpleName();
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static boolean getDarkModeStatus(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private String getStorageSpace() {
        File externalCacheDir = getExternalCacheDir();
        StringBuilder sb = new StringBuilder();
        if (externalCacheDir != null) {
            sb.append(Formatter.formatFileSize(this, externalCacheDir.getTotalSpace()));
            sb.append("/");
            sb.append(Formatter.formatFileSize(this, externalCacheDir.getUsableSpace()));
        }
        if (com.gigaset.update.utils.t.h(this)) {
            String b2 = com.gigaset.update.utils.t.b((Context) this, true);
            if (!TextUtils.isEmpty(b2)) {
                externalCacheDir = new File(b2);
            }
            if (externalCacheDir != null) {
                sb.append("&");
                sb.append(Formatter.formatFileSize(this, externalCacheDir.getTotalSpace()));
                sb.append("/");
                sb.append(Formatter.formatFileSize(this, externalCacheDir.getUsableSpace()));
            }
        }
        return sb.toString();
    }

    public void closeDialog() {
        com.gigaset.update.utils.d.a();
    }

    public void dealWithIntent(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("notify_id", 0);
            this.param = new HashMap();
            this.param.put("task_id", intent.getStringExtra("task_id"));
            com.gigaset.update.manager.h.a().a(this, intExtra);
        }
    }

    public void doUpdate() {
        LogUtil.a("enter");
        com.gigaset.update.utils.o.b((Context) this, "install_later_count", 0);
        if (!com.gigaset.update.utils.c.k().F()) {
            com.gigaset.update.utils.d.a(this, (int) R.layout.dialog_update_unzip, this);
        }
        com.gigaset.update.f.a.a(this, "update");
        com.gigaset.update.d.d.e(getApplicationContext());
    }

    protected abstract void initWidget();

    public boolean isFront() {
        return this.isFront;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        widgetClick(view);
    }

    @SuppressLint({"StringFormatInvalid"})
    public void onClickInstallNow() {
        LogUtil.a("enter");
        int c = com.gigaset.update.b.d.c(MyApplication.c());
        LogUtil.a("nowstutas =" + c);
        int b2 = com.gigaset.update.utils.c.k().b();
        if (!com.gigaset.update.d.d.a(this, b2)) {
            closeDialog();
            LogUtil.a("no update reason : battery not enough");
            CustomActionService.a(this, 15);
            com.gigaset.update.utils.d.a(this, (int) R.mipmap.ota_battery, getString(R.string.ota_battery_low, new Object[]{Integer.valueOf(b2)}), this);
        } else if (!com.gigaset.update.d.d.b(this, com.gigaset.update.utils.t.d(this))) {
            closeDialog();
            LogUtil.a("no update reason : sd card status not illegal");
            com.gigaset.update.utils.d.b(this, getString(R.string.battery_remove_title), getString(R.string.sdcard_crash_or_unmount), null, this);
        } else {
            closeDialog();
            com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.update_prompt), new c(this), new d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.a(getActivityName());
        mContext = getApplicationContext();
        com.gigaset.update.manager.a.b().a(this);
        getClass().getName();
        if (FCM_REPORT_TYPE_FILE_PATH.equals(com.gigaset.update.utils.c.k().f())) {
            setRequestedOrientation(0);
        } else if (FCM_REPORT_TYPE_STORAGE_SPACE.equals(com.gigaset.update.utils.c.k().f())) {
            setRequestedOrientation(4);
        } else {
            setRequestedOrientation(1);
        }
        if (this.mAllowFullScreen) {
            requestWindowFeature(1);
        }
        super.setContentView(R.layout.base_activity_layout);
        this.layout = (LinearLayout) findViewById(R.id.layout);
        setTitleView((TitleView) findViewById(R.id.titleView));
        initWidget();
        dealWithIntent(getIntent());
        showpopPermissions();
        requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 100);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LogUtil.a(getActivityName());
        com.gigaset.update.manager.a.b().b(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        finishPopWindows();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        dealWithIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogUtil.a(getActivityName());
        this.isFront = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.b.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2].equalsIgnoreCase("android.permission.READ_EXTERNAL_STORAGE") && iArr[i2] == 0) {
                    this.param.put("action_type", FCM_REPORT_TYPE_STORAGE_SPACE);
                    this.param.put("storage_space", getStorageSpace());
                    com.gigaset.update.f.e.a().a(this, this.param);
                }
            }
        } else if (i == REQUEST_CODE) {
            LogUtil.a("case REQUEST_CODE");
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                openDebug();
                com.gigaset.update.manager.i.c(this.param.get("task_id"));
                com.gigaset.update.manager.b.f(this);
                return;
            }
            LogUtil.a("no Permission");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        LogUtil.a(getActivityName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LogUtil.a(getActivityName());
        this.isFront = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        LogUtil.a(getActivityName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LogUtil.a(getActivityName());
        if (getActivityName().equalsIgnoreCase(SdcardUpdateActivity.class.getSimpleName()) || getActivityName().equalsIgnoreCase(InstallResultActivity.class.getSimpleName())) {
            return;
        }
        closeDialog();
    }

    public void onTitleClick(View view) {
        finish();
    }

    public void openDebug() {
        LogUtil.a("enter");
        String b2 = com.gigaset.update.utils.t.b(this);
        if (!com.gigaset.update.utils.t.a(b2, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
            v.a((int) R.string.sdcard_crash_or_unmount);
            return;
        }
        File file = new File(b2 + "/fota");
        if (!file.exists()) {
            file.mkdirs();
        }
        String replaceAll = SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(System.currentTimeMillis())).replaceAll(" ", "-").replaceAll(":", "-");
        File file2 = new File(file.getAbsolutePath() + "/" + replaceAll + ".txt");
        com.gigaset.update.utils.o.b((Context) this, "debug_status", true);
        com.gigaset.update.utils.o.b(this, "debug_log_path", file2.getAbsolutePath());
        LogUtil.b(true);
        LogUtil.c(file2.getAbsolutePath());
        LogUtil.a("log out path : " + file.getAbsolutePath());
        v.a(getString(R.string.start_catch_log) + " to " + file.getAbsolutePath());
    }

    public void openMenu() {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout != null) {
            drawerLayout.g(8388611);
        }
    }

    public void setAllowFullScreen(boolean z) {
        this.mAllowFullScreen = z;
    }

    public void setAndroidNativeLightStatusBar(Activity activity, boolean z) {
        LogUtil.a("setAndroidNativeLightStatusBar: " + z);
        View decorView = activity.getWindow().getDecorView();
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.setNavigationBarColor(androidx.core.content.a.a(MyApplication.c(), (int) R.color.white_color));
        }
        if (z) {
            decorView.setSystemUiVisibility(1280);
        } else {
            decorView.setSystemUiVisibility(9232);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        this.layout.removeAllViews();
        this.layout.addView(LayoutInflater.from(this).inflate(i, (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1));
    }

    protected abstract void setTitleView(TitleView titleView);

    public void showpopPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(this)) {
                return;
            }
            com.gigaset.update.utils.d.a(this, getString(R.string.PopPermissions_title), getString(R.string.PopPermissions), getString(R.string.agree), new a(this), getString(R.string.PopPermissions_negative), new b(this));
            return;
        }
        startService(new Intent(this, GoogleOtaClient.class));
    }

    protected abstract void widgetClick(View view);
}
