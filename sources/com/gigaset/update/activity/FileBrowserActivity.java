package com.gigaset.update.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.view.View;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.view.TitleView;
/* loaded from: classes.dex */
public class FileBrowserActivity extends BaseActivity {
    public static String a(Context context, Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri) && "com.android.externalstorage.documents".equals(uri.getAuthority())) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] split = documentId.split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                if (split.length > 1) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1] + "/";
                }
                return Environment.getExternalStorageDirectory() + "/";
            }
            return "storage/" + documentId.replace(":", "/");
        }
        return null;
    }

    private void b() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        Uri parse = Uri.parse("content://com.android.externalstorage.documents/document/primary%3ADownload%2F");
        intent.setType("application/zip");
        intent.putExtra("android.provider.extra.INITIAL_URI", parse);
        startActivityForResult(intent, 100);
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void initWidget() {
        setContentView(R.layout.activity_file_browser);
        if (Build.VERSION.SDK_INT >= 26) {
            b();
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || i2 != -1) {
            finish();
        } else if (i == 100) {
            String a2 = a(MyApplication.c(), intent.getData());
            Intent intent2 = new Intent();
            intent2.putExtra("selected_file", a2);
            intent2.setClass(this, SdcardUpdateActivity.class);
            startActivityForResult(intent2, 1);
            finish();
        }
    }

    @Override // com.gigaset.update.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.b.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1 || Build.VERSION.SDK_INT < 26) {
            return;
        }
        b();
    }

    @Override // com.gigaset.update.activity.BaseActivity
    protected void setTitleView(TitleView titleView) {
        titleView.setContent(getString(R.string.option_file_select));
    }

    @Override // com.gigaset.update.activity.BaseActivity
    public void widgetClick(View view) {
    }

    private void a() {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return;
        }
        requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }
}
