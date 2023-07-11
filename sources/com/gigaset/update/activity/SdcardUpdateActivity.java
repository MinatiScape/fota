package com.gigaset.update.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StatFs;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.gigaset.update.R;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.t;
import com.gigaset.update.view.TitleView;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class SdcardUpdateActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f1074a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1075b;
    Button c;
    TextView d;
    private String e;
    private Handler f = new r(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.gigaset.update.utils.d.a(this, (int) R.layout.dialog_loading_copy_file, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LogUtil.a("doUpdate : selected_file " + this.e);
        com.gigaset.update.b.d.a(this, 0);
        com.gigaset.update.utils.o.b((Context) this, "ota_update_local", true);
        com.gigaset.update.utils.o.b(this, "ota_update_local_path", this.e);
        com.gigaset.update.d.d.a(this, this.e);
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void initWidget() {
        setContentView(R.layout.activity_sdcard_update);
        if (f1074a == null) {
            f1074a = Executors.newFixedThreadPool(3);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.e = extras.getString("selected_file");
        }
        LogUtil.a("selected_file = " + this.e);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f1075b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (org.greenrobot.eventbus.e.a().a(this)) {
            org.greenrobot.eventbus.e.a().d(this);
        }
        super.onDestroy();
        this.f.removeCallbacksAndMessages(null);
        closeDialog();
    }

    @org.greenrobot.eventbus.o(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage eventMessage) {
        if (eventMessage.getWhat() != 300) {
            return;
        }
        a(eventMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.gigaset.update.activity.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (f1075b) {
            f();
        }
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void setTitleView(TitleView titleView) {
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void widgetClick(View view) {
        if (((Integer) view.getTag()).intValue() == R.id.sdcard_update_install) {
            LogUtil.a("onItemClick, install now");
            e();
        }
    }

    private void c() {
        TextView textView = (TextView) findViewById(R.id.sdcard_update_file_name);
        String str = this.e;
        if (str != null) {
            File file = new File(str);
            textView.setText(getString(R.string.selected_update_zip) + file.getName());
        }
        this.d = (TextView) findViewById(R.id.sdcard_update_webview);
        this.d.setText(Html.fromHtml(getString(R.string.sdCard_update_tips_content)));
        this.c = (Button) findViewById(R.id.sdcard_update_install);
        if (com.gigaset.update.utils.c.k().x()) {
            this.c.requestFocus();
        }
        this.c.setTag(Integer.valueOf((int) R.id.sdcard_update_install));
        this.c.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        File file = new File(this.e);
        if (!file.exists()) {
            com.gigaset.update.utils.d.a(this, getString(R.string.sdCard_upgrade_find_update_file_fail), getString(R.string.sdCard_upgrade_copy_file_fail_prompt));
        } else if (!b()) {
            com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.unmount_sdcard));
        } else if (b(this.e)) {
            File file2 = new File(file.getParent() + "/LocalSdUpdate.zip");
            if (Build.VERSION.SDK_INT < 23 && file.renameTo(file2)) {
                this.e = file2.getAbsolutePath();
            }
            this.f.sendEmptyMessage(2);
        } else if (a(file.length(), a(this.e))) {
            f1074a.execute(new t(this));
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    private void e() {
        if (!org.greenrobot.eventbus.e.a().a(this)) {
            org.greenrobot.eventbus.e.a().c(this);
        }
        int b2 = com.gigaset.update.utils.c.k().b();
        if (com.gigaset.update.d.d.a(this, b2)) {
            com.gigaset.update.utils.d.a(this, getString(R.string.not_support_fota_title), getString(R.string.sdcard_update_prompt), new s(this));
        } else {
            com.gigaset.update.utils.d.a(this, (int) R.mipmap.ota_battery, getString(R.string.ota_battery_low, new Object[]{Integer.valueOf(b2)}));
        }
    }

    private boolean b() {
        try {
            return com.gigaset.update.utils.t.b(a(this.e)).equals("mounted");
        } catch (Exception e) {
            LogUtil.b("getSdcardAvailable error " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x010d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r12, java.lang.String r13, java.lang.Boolean r14) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.activity.SdcardUpdateActivity.a(java.lang.String, java.lang.String, java.lang.Boolean):boolean");
    }

    private boolean b(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        String parent = new File(str).getParent();
        if (Build.VERSION.SDK_INT >= 21) {
            String b2 = com.gigaset.update.utils.t.b((Context) this, true);
            String b3 = com.gigaset.update.utils.t.b((Context) this, false);
            LogUtil.a("isSdcardRootZip,outSdcard=" + b2 + " ,innerSdcard=" + b3);
            if (!TextUtils.isEmpty(b2) && parent.equals(b2)) {
                z = true;
            }
            if (TextUtils.isEmpty(b3) || !parent.equals(b3)) {
                return z;
            }
        } else {
            List<t.a> d = com.gigaset.update.utils.t.d();
            if (d != null) {
                for (int i = 0; i < d.size(); i++) {
                    t.a aVar = d.get(i);
                    LogUtil.a("isSdcardRootZip, i = " + i + ",info path = " + aVar.f1187a + ",parentPath = " + parent);
                    if (!parent.equals(aVar.f1187a)) {
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    private boolean b(long j, String str) {
        try {
            StatFs statFs = new StatFs(str);
            long blockSize = statFs.getBlockSize() * statFs.getAvailableBlocks();
            LogUtil.a("checkSdcardSpaceNeeded totalSize = " + blockSize);
            if (blockSize > j) {
                LogUtil.b("checkSdcardSpaceNeeded true, totalSize = " + blockSize);
                return true;
            }
            return false;
        } catch (Exception unused) {
            LogUtil.b("checkSdcardSpaceNeeded false, card mount error");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (str != null) {
            String b2 = com.gigaset.update.utils.t.b(this, str);
            if (TextUtils.isEmpty(b2)) {
                List<t.a> d = com.gigaset.update.utils.t.d();
                if (d != null) {
                    for (int i = 0; i < d.size(); i++) {
                        t.a aVar = d.get(i);
                        if (aVar != null && str.startsWith(aVar.f1187a)) {
                            return aVar.f1187a;
                        }
                    }
                    return str;
                }
                return str;
            }
            return b2;
        }
        return str;
    }

    private void a(EventMessage eventMessage) {
        closeDialog();
        finish();
    }

    public boolean a(long j, String str) {
        if (b(j, str)) {
            return true;
        }
        com.gigaset.update.utils.d.a(this, getString(R.string.sdCard_upgrade_memory_space_not_enough), getString(R.string.sdcard_crash_or_unmount));
        LogUtil.a("isEnough false");
        return false;
    }
}
