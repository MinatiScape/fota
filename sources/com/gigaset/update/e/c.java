package com.gigaset.update.e;

import android.content.Context;
import android.text.TextUtils;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.bean.PolicyBean;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.manager.h;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.i;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
import java.util.HashMap;
import java.util.List;
/* compiled from: QueryInfo.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1117a;

    /* renamed from: b  reason: collision with root package name */
    private String f1118b = "";
    private HashMap<String, PolicyBean> c = new HashMap<>();
    private VersionBean d;

    private c(Context context) {
        this.d = (VersionBean) i.a(com.gigaset.update.utils.g.a(context, com.gigaset.update.b.a.f1100b), VersionBean.class);
        VersionBean versionBean = this.d;
        if (versionBean != null) {
            a(versionBean.getPolicy());
        }
    }

    public static c a() {
        if (f1117a == null) {
            synchronized (c.class) {
                if (f1117a == null) {
                    f1117a = new c(MyApplication.c());
                }
            }
        }
        return f1117a;
    }

    private void b(Context context) {
        String str = (String) a("download_path", String.class);
        if (TextUtils.isEmpty(str) || !str.contains("#")) {
            return;
        }
        o.b(context, "ota_download_path", str);
        String[] split = str.split("#");
        if (split.length == 3) {
            t.a(split[0], split[1], split[2]);
        }
    }

    public VersionBean c() {
        LogUtil.a("getVersionInfo,version=" + this.d);
        try {
            if (this.d == null) {
                this.d = (VersionBean) i.a(com.gigaset.update.utils.g.a(MyApplication.c(), com.gigaset.update.b.a.f1100b), VersionBean.class);
                if (this.d != null) {
                    a(this.d.getPolicy());
                }
            }
        } catch (Exception e) {
            LogUtil.a("getVersionInfo,Exception e=" + e.getMessage());
            e.printStackTrace();
        }
        return this.d;
    }

    public void a(Context context, VersionBean versionBean) {
        synchronized (this) {
            if (versionBean != null) {
                this.d = versionBean;
                a(this.d.getPolicy());
                b(context);
            }
        }
    }

    public String b() {
        return this.f1118b;
    }

    public void a(Context context) {
        synchronized (this) {
            try {
                LogUtil.a("clear version txt");
                t.a(context, t.e(context));
                o.b(context, "update_package_path", "");
                h.a().a(context, R.string.appbar_scrolling_view_behavior);
                h.a().a(context, 105);
                this.d = null;
                this.c.clear();
                com.gigaset.update.utils.g.b(context.getFilesDir().getPath() + "/" + com.gigaset.update.b.a.f1100b);
            } catch (Exception e) {
                e.printStackTrace();
                com.gigaset.update.utils.g.b(context.getFilesDir().getPath() + "/" + com.gigaset.update.b.a.f1100b);
            }
            com.gigaset.update.b.d.a(context, 0);
        }
    }

    public <T> T a(String str, Class<T> cls) {
        T t;
        try {
        } catch (NumberFormatException unused) {
            return (T) 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (this) {
            PolicyBean policyBean = this.c.get(str);
            if (cls.equals(String.class)) {
                return policyBean != null ? (T) policyBean.getValue() : null;
            } else if (cls.equals(Integer.class)) {
                return policyBean != null ? (T) Integer.valueOf(policyBean.getValue()) : (T) 0;
            } else if (cls.equals(Boolean.class)) {
                if (policyBean != null) {
                    boolean z = true;
                    if (1 != Integer.valueOf(policyBean.getValue()).intValue()) {
                        z = false;
                    }
                    t = (T) Boolean.valueOf(z);
                } else {
                    t = (T) false;
                }
                return t;
            } else {
                return null;
            }
        }
    }

    public String[] a(String str) {
        String[] split;
        synchronized (this) {
            PolicyBean policyBean = this.c.get(str);
            split = (policyBean == null || policyBean.getValue() == null) ? null : policyBean.getValue().split("#");
        }
        return split;
    }

    private void a(List<PolicyBean> list) {
        if (list != null) {
            this.c.clear();
            for (PolicyBean policyBean : list) {
                this.c.put(policyBean.getKey(), policyBean);
            }
            o.b(MyApplication.c(), "ota_install_result_pop", ((Boolean) a("install_result_pop", Boolean.class)).booleanValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(android.content.Context r9, boolean r10) {
        /*
            r8 = this;
            com.gigaset.update.bean.VersionBean r0 = r8.c()
            r1 = 0
            if (r0 == 0) goto La7
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.util.Locale r0 = r0.locale
            java.lang.String r0 = r0.getLanguage()
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            java.util.Locale r9 = r9.locale
            java.lang.String r9 = r9.getCountry()
            java.lang.String r2 = "zh"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L3f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "_"
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
        L3f:
            com.gigaset.update.bean.VersionBean r9 = r8.d
            java.util.List r9 = r9.getReleaseNotes()
            if (r9 == 0) goto La7
            int r2 = r9.size()
            if (r2 <= 0) goto La7
            int r2 = r9.size()
            java.lang.String r3 = "#434343"
            java.lang.String r4 = "#FFFFFF"
            r5 = 1
            r6 = 0
            if (r2 != r5) goto L74
            java.lang.Object r0 = r9.get(r6)
            com.gigaset.update.bean.LanguageBean r0 = (com.gigaset.update.bean.LanguageBean) r0
            java.lang.String r0 = r0.getCountry()
            r8.f1118b = r0
            java.lang.Object r9 = r9.get(r6)
            com.gigaset.update.bean.LanguageBean r9 = (com.gigaset.update.bean.LanguageBean) r9
            java.lang.String r9 = r9.getContent()
            java.lang.String r9 = r9.replaceAll(r4, r3)
            goto La8
        L74:
            r5 = 0
        L75:
            if (r5 >= r2) goto L8b
            java.lang.Object r7 = r9.get(r5)
            com.gigaset.update.bean.LanguageBean r7 = (com.gigaset.update.bean.LanguageBean) r7
            java.lang.String r7 = r7.getCountry()
            boolean r7 = r0.contains(r7)
            if (r7 == 0) goto L88
            goto L8c
        L88:
            int r5 = r5 + 1
            goto L75
        L8b:
            r5 = 0
        L8c:
            java.lang.Object r0 = r9.get(r5)
            com.gigaset.update.bean.LanguageBean r0 = (com.gigaset.update.bean.LanguageBean) r0
            java.lang.String r0 = r0.getCountry()
            r8.f1118b = r0
            java.lang.Object r9 = r9.get(r5)
            com.gigaset.update.bean.LanguageBean r9 = (com.gigaset.update.bean.LanguageBean) r9
            java.lang.String r9 = r9.getContent()
            java.lang.String r9 = r9.replaceAll(r4, r3)
            goto La8
        La7:
            r9 = r1
        La8:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto Lba
            if (r10 == 0) goto Lb1
            return r9
        Lb1:
            android.text.Spanned r9 = android.text.Html.fromHtml(r9)
            java.lang.String r9 = r9.toString()
            return r9
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.e.c.a(android.content.Context, boolean):java.lang.String");
    }
}
