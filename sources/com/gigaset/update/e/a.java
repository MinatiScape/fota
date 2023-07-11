package com.gigaset.update.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.gigaset.update.bean.CheckBean;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.bean.FlagBean;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.manager.JobScheduleManager;
import com.gigaset.update.service.CustomActionService;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.i;
import com.gigaset.update.utils.j;
import com.gigaset.update.utils.o;
import org.json.JSONObject;
/* compiled from: ParserVersion.java */
/* loaded from: classes.dex */
public class a {
    private boolean b(Context context, VersionBean versionBean) {
        com.gigaset.update.c.d.b().a(context);
        com.gigaset.update.b.d.a(context, versionBean);
        return true;
    }

    private void c(Context context, String str) {
        LogUtil.a("content = " + str);
        CheckBean checkBean = (CheckBean) i.a(str, CheckBean.class);
        if (checkBean != null) {
            LogUtil.a("status = " + checkBean.getStatus());
            com.gigaset.update.manager.b.d(context);
            FlagBean flag = checkBean.getFlag();
            if (flag != null) {
                String mid = flag.getMid();
                if (!TextUtils.isEmpty(mid)) {
                    o.b(context, "mid", mid);
                }
                long checkFreq = flag.getCheckFreq();
                if (checkFreq != 0) {
                    o.b(context, "check_freq", checkFreq);
                }
                String jobScheduleTime = flag.getJobScheduleTime();
                if (!TextUtils.isEmpty(jobScheduleTime)) {
                    com.gigaset.update.manager.i.b(jobScheduleTime);
                }
                String jobScheduleDownloadingTime = flag.getJobScheduleDownloadingTime();
                if (!TextUtils.isEmpty(jobScheduleDownloadingTime)) {
                    com.gigaset.update.manager.i.a(jobScheduleDownloadingTime);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    JobScheduleManager.a(context, 100);
                }
                o.b(context, "isFull", flag.getIsFull());
                o.b(context, "isupgrade", flag.getIsUpgrade());
            }
            VersionBean version = checkBean.getVersion();
            if (version != null) {
                LogUtil.a("version exists");
                c(context, version);
                return;
            }
            a(context, 1003, (VersionBean) null);
        }
    }

    public void a(Context context, com.gigaset.update.g.e eVar) {
        if (eVar != null) {
            if (eVar.e()) {
                if (com.gigaset.update.b.d.c(context) >= 4) {
                    com.gigaset.update.manager.g.d(context);
                    LogUtil.a("query succeed,but a system has already been installed successfully");
                    return;
                }
                c(context, eVar.c());
                return;
            }
            j.d(context);
            LogUtil.a("query version error, mid reset");
            a(eVar);
        }
    }

    private boolean b(Context context, String str) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("policy") ? jSONObject.getString("policy") : "";
            if (!TextUtils.isEmpty(string)) {
                String a2 = o.a(context, "policy_content", "");
                LogUtil.a("newPolicy = " + string + " ; oldPolicy = " + a2);
                if (!string.equalsIgnoreCase(a2)) {
                    o.b(context, "policy_content", string);
                    z = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.a("isPolicyChange : " + z);
        return z;
    }

    private void a(com.gigaset.update.g.e eVar) {
        LogUtil.a("Status_code = " + eVar.d());
        if (eVar.a() != 3008) {
            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3010, eVar.d(), 0L, eVar.b()));
        } else {
            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3008, eVar.d(), 0L, eVar.b()));
        }
    }

    private void a(Context context, VersionBean versionBean, int i, boolean z) {
        LogUtil.a("version_status = " + i + "; isChange = " + z);
        if (i != 0 && !z) {
            a(context, 1002, versionBean);
            return;
        }
        a(context, versionBean.getVersionName());
        c.a().a(context, versionBean);
        a(context, 1001, versionBean);
    }

    private void b(Context context) {
        if (com.gigaset.update.utils.c.k().A()) {
            LogUtil.a("sendNewVersionBroadcast");
            Intent intent = new Intent();
            intent.setAction(com.gigaset.update.b.a.h);
            intent.addFlags(268435456);
            context.sendBroadcast(intent, com.gigaset.update.b.a.i);
        }
    }

    private void a(Context context, int i, VersionBean versionBean) {
        if (i != 3008) {
            switch (i) {
                case 1001:
                case 1004:
                    if (!a(context, versionBean)) {
                        if (!b(context, versionBean)) {
                            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1003, 0L, 0L, null));
                            return;
                        }
                        com.gigaset.update.g.e eVar = new com.gigaset.update.g.e();
                        eVar.a(true);
                        com.gigaset.update.f.a.a(context, 4, 1, eVar);
                        b(context);
                        a(context, o.a(context, "query_to_download", false), "QUERY_NEW_VERSION");
                        break;
                    } else {
                        return;
                    }
                case 1002:
                    if (!com.gigaset.update.manager.a.b().c()) {
                        com.gigaset.update.manager.g.g(context);
                    }
                    a(context);
                    break;
                case 1003:
                    if (g.a().a(context, versionBean)) {
                        org.greenrobot.eventbus.e.a().b(new EventMessage(100, 404, 0L, 0L, null));
                        return;
                    } else {
                        a(context, o.a(context, "query_to_download", false), "QUERY_NO_VERSION");
                        break;
                    }
                case 1005:
                    if (!a(context, versionBean)) {
                        a(context);
                        break;
                    } else {
                        return;
                    }
            }
        } else {
            com.gigaset.update.f.a.a(context, "cause_parser_error", 0L);
            a(context, o.a(context, "query_to_download", false), "ERROR_IO");
        }
        org.greenrobot.eventbus.e.a().b(new EventMessage(100, i, 0L, 0L, null));
    }

    private void c(Context context, VersionBean versionBean) {
        if (versionBean != null) {
            String l = com.gigaset.update.utils.c.k().l();
            LogUtil.a("deviceVersion = " + l);
            String versionName = versionBean.getVersionName();
            if (!TextUtils.isEmpty(versionName) && versionName.equals(l)) {
                org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1002, 0L, 0L, null));
                com.gigaset.update.f.a.a(context, "cause_same_version", 0L);
                return;
            }
            VersionBean c = c.a().c();
            String a2 = i.a(versionBean);
            if (!com.gigaset.update.utils.g.a(context, com.gigaset.update.b.a.f1100b, a2)) {
                LogUtil.a("version_process  writeInternalFile error ");
                org.greenrobot.eventbus.e.a().b(new EventMessage(100, 3005, 0L, 0L, null));
                com.gigaset.update.f.a.a(context, "cause_not_enough", 0L);
                return;
            }
            int c2 = com.gigaset.update.b.d.c(context);
            LogUtil.a("versionStatus = " + c2);
            boolean b2 = b(context, a2);
            if (c != null) {
                if (!TextUtils.isEmpty(versionName) && !versionName.equals(c.getVersionName())) {
                    LogUtil.a("new version version name different");
                    a(context, versionBean.getVersionName());
                    c.a().a(context, versionBean);
                    a(context, 1004, versionBean);
                } else if (!TextUtils.isEmpty(versionBean.getDeltaUrl()) && !versionBean.getDeltaUrl().equals(c.getDeltaUrl())) {
                    LogUtil.a("new version delta url different");
                    a(context, versionBean.getVersionName());
                    c.a().a(context, versionBean);
                    a(context, 1004, versionBean);
                } else if (b2) {
                    LogUtil.a("new version delta content different ");
                    c.a().a(context, versionBean);
                    a(context, 1005, versionBean);
                } else {
                    a(context, versionBean, c2, false);
                }
            } else {
                a(context, versionBean, c2, b2);
            }
        }
        LogUtil.a("download_path_server : " + c.a().a("download_path_server", Integer.class));
    }

    private void a(Context context, String str) {
        o.b(context, "ota_install_fail_count", 0);
        o.b(context, "ota_install_fail_version", str);
    }

    private void a(Context context) {
        int c = com.gigaset.update.b.d.c(context);
        LogUtil.a("version_status = " + c);
        if (c == 2) {
            com.gigaset.update.c.d.b().f(context);
            com.gigaset.update.f.a.a(context, "cause_downloading", 0L);
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.gigaset.update.c.d.b().a(context, 1);
        } else if (c == 4) {
            boolean booleanValue = ((Boolean) c.a().a("install_forced", Boolean.class)).booleanValue();
            if (booleanValue) {
                LogUtil.a("force_install = " + booleanValue);
                com.gigaset.update.d.d.c(context);
            }
        } else {
            CustomActionService.a(context, 9);
        }
        a(context, o.a(context, "query_to_download", false), "doSameVersion");
    }

    private void a(Context context, boolean z, String str) {
        if (z) {
            o.b(context, "query_to_download", false);
            LogUtil.a(str + "; QUERY_TO_DOWNLOAD = true");
            CustomActionService.a(context, 16);
            return;
        }
        LogUtil.a("query type is not auto");
    }

    private boolean a(Context context, VersionBean versionBean) {
        if (g.a().a(context, versionBean)) {
            if (com.gigaset.update.b.d.c(context) == 2) {
                com.gigaset.update.c.d.b().a(context);
            }
            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 404, 0L, 0L, null));
            com.gigaset.update.f.a.a(context, "cause_device_rooted", 0L);
            return true;
        }
        return false;
    }
}
