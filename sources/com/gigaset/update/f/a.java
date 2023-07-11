package com.gigaset.update.f;

import android.content.Context;
import android.text.TextUtils;
import com.gigaset.update.activity.BaseActivity;
import com.gigaset.update.bean.ReportBaseBean;
import com.gigaset.update.bean.ReportDownloadBean;
import com.gigaset.update.bean.ReportInstallBean;
import com.gigaset.update.bean.ReportInstallResultBean;
import com.gigaset.update.bean.ReportQueryBean;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.e.g;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.i;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.compress.archivers.zip.UnixStat;
/* compiled from: ReportData.java */
/* loaded from: classes.dex */
public class a {
    public static <T> String a(T t) {
        if (t != null) {
            return i.a(t);
        }
        return null;
    }

    private static String b() {
        VersionBean c = com.gigaset.update.e.c.a().c();
        String versionName = c != null ? c.getVersionName() : null;
        return TextUtils.isEmpty(versionName) ? com.gigaset.update.utils.c.k().l() : versionName;
    }

    private static String a() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
    }

    public static void a(Context context, int i, int i2, com.gigaset.update.g.e eVar) {
        if (eVar != null) {
            ReportQueryBean reportQueryBean = new ReportQueryBean();
            reportQueryBean.setStatus(eVar.e() ? 1 : 2);
            reportQueryBean.setErrCode(String.valueOf(eVar.a()));
            reportQueryBean.setReason(eVar.b());
            reportQueryBean.setTime(a());
            reportQueryBean.setVersion(b());
            reportQueryBean.setCheckType(i);
            reportQueryBean.setApn(com.gigaset.update.utils.c.k().d(context));
            reportQueryBean.setType(i2);
            ReportBaseBean reportBaseBean = new ReportBaseBean();
            reportBaseBean.setAction("check");
            reportBaseBean.setData(reportQueryBean);
            e.a().a(context, "check", a(reportBaseBean), false);
        }
    }

    public static void a(Context context, String str, long j) {
        ReportDownloadBean reportDownloadBean = new ReportDownloadBean();
        reportDownloadBean.setTime(a());
        reportDownloadBean.setStatus(str);
        reportDownloadBean.setVersion(b());
        reportDownloadBean.setDuration(j / 1000);
        reportDownloadBean.setBackground(com.gigaset.update.c.d.b().a());
        reportDownloadBean.setType(g.a().b());
        reportDownloadBean.setApn(com.gigaset.update.utils.c.k().d(context));
        ReportBaseBean reportBaseBean = new ReportBaseBean();
        reportBaseBean.setAction("download");
        reportBaseBean.setData(reportDownloadBean);
        e.a().a(context, "download", a(reportBaseBean), false);
        if (str.equalsIgnoreCase("cancel") || str.equalsIgnoreCase("finish") || str.equalsIgnoreCase("cause_clean_cache")) {
            com.gigaset.update.manager.i.b();
        }
    }

    public static void a(Context context, String str) {
        ReportInstallBean reportInstallBean = new ReportInstallBean();
        reportInstallBean.setStatus(str);
        reportInstallBean.setTime(a());
        reportInstallBean.setNewVersion(b());
        reportInstallBean.setOldVersion(com.gigaset.update.utils.c.k().l());
        reportInstallBean.setType(g.a().b());
        reportInstallBean.setForced(((Boolean) com.gigaset.update.e.c.a().a("install_forced", Boolean.class)).booleanValue() ? 1 : 0);
        ReportBaseBean reportBaseBean = new ReportBaseBean();
        reportBaseBean.setAction("upgrade");
        reportBaseBean.setData(reportInstallBean);
        e.a().a(context, "upgrade", a(reportBaseBean), false);
    }

    public static void a(Context context, boolean z, int i, String str) {
        String a2;
        a(z);
        ReportInstallResultBean reportInstallResultBean = new ReportInstallResultBean();
        reportInstallResultBean.setTime(a());
        reportInstallResultBean.setOldVersion(a(o.a(context, "ota_original_version", "")));
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("ab")) {
            reportInstallResultBean.setNewVersion(b());
        } else {
            if (z) {
                a2 = com.gigaset.update.utils.c.k().l();
            } else {
                a2 = o.a(context, "ota_update_version", com.gigaset.update.utils.c.k().l());
            }
            reportInstallResultBean.setNewVersion(a2);
        }
        reportInstallResultBean.setType(o.a(context, "ota_update_type", 1));
        reportInstallResultBean.setStatus(z ? 1 : 0);
        reportInstallResultBean.setErrCode(a(i));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        reportInstallResultBean.setReason(str);
        ReportBaseBean reportBaseBean = new ReportBaseBean();
        reportBaseBean.setAction("upgradeResult");
        reportBaseBean.setData(reportInstallResultBean);
        e.a().a(context, "upgradeResult", a(reportBaseBean), !z ? 1 : 0);
    }

    private static void a(boolean z) {
        if (z) {
            t.a();
        }
    }

    private static String a(String str) {
        String p = com.gigaset.update.utils.c.k().p();
        LogUtil.a("local_version = " + str + "; project = " + p);
        return (TextUtils.isEmpty(str) || !str.contains("_other") || TextUtils.isEmpty(p) || !p.contains("_other")) ? str : str.substring(p.substring(0, p.lastIndexOf("_")).length() + 1, str.lastIndexOf("_"));
    }

    private static String a(int i) {
        switch (i) {
            case 401:
                return "4";
            case 402:
                return "6";
            case 403:
                return "8";
            case 404:
                return "9";
            case 405:
            case 406:
            case 407:
            case 410:
            default:
                return i + "";
            case 408:
                return "7";
            case 409:
                return BaseActivity.FCM_REPORT_TYPE_LOG;
            case 411:
                return "5";
            case 412:
                return "B";
            case 413:
                return "1";
            case 414:
                return "2";
            case 415:
                return "C";
            case 416:
                return "10";
            case 417:
                return "11";
            case 418:
                return "12";
            case 419:
                return "13";
            case UnixStat.DEFAULT_FILE_PERM /* 420 */:
                return "14";
        }
    }
}
