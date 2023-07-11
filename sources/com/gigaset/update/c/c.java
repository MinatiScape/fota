package com.gigaset.update.c;

import android.content.Context;
import android.text.TextUtils;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.bean.DownloadBean;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.manager.g;
import com.gigaset.update.manager.h;
import com.gigaset.update.manager.i;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.l;
import com.gigaset.update.utils.o;
import com.gigaset.update.utils.t;
import java.io.File;
import java.lang.Thread;
import org.greenrobot.eventbus.e;
/* compiled from: DownPackage.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1106a;

    /* renamed from: b  reason: collision with root package name */
    private VersionBean f1107b;
    private Thread c;
    private boolean e;
    private l g;
    private int d = i.e();
    private DownloadBean f = new DownloadBean();

    private c() {
        this.c = null;
        this.g = null;
        this.f.setRetryCount(3);
        if (this.g == null) {
            this.g = new l();
        }
        if (this.c == null) {
            this.c = new Thread(new a(this));
        }
    }

    public static c b() {
        if (f1106a == null) {
            synchronized (c.class) {
                if (f1106a == null) {
                    f1106a = new c();
                }
            }
        }
        return f1106a;
    }

    private void c(Context context) {
        LogUtil.a("download is completed");
        j();
        this.d = 0;
        i.a(0);
        com.gigaset.update.b.d.f(context);
        com.gigaset.update.f.a.a(context, "finish", i());
        com.gigaset.update.b.d.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01eb, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01f1, code lost:
        r16 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01f3, code lost:
        r0.close();
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0207, code lost:
        if (r17.f.getDownloadTotalSize() != r17.f.getTagFileSize()) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0209, code lost:
        r17.f.setDownloadTotalSize(0);
        g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0212, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0213, code lost:
        com.gigaset.update.utils.LogUtil.b("download failed!!");
        a("download failed!!");
        r2 = r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void f() {
        /*
            Method dump skipped, instructions count: 707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gigaset.update.c.c.f():void");
    }

    private void g() {
        this.e = false;
        c(MyApplication.c());
    }

    private long h() {
        return System.currentTimeMillis();
    }

    private long i() {
        return i.g();
    }

    private void j() {
        i.b(h() - i.f());
    }

    public void d() {
        this.f1107b = com.gigaset.update.e.c.a().c();
        if (TextUtils.isEmpty(this.f.getDownloadUrl()) || !this.f.getDownloadUrl().equalsIgnoreCase(this.f1107b.getDeltaUrl())) {
            this.f.setDownloadTotalSize(0L);
        }
        this.f.setDownloadUrl(this.f1107b.getDeltaUrl());
        this.f.setDownloadDir(t.e(MyApplication.c()));
        this.f.setDownloadFileName("/update.zip");
        File file = new File(this.f.getDownloadDir());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.exists()) {
            a(MyApplication.c().getString(R.string.sdcard_crash_dir_un_build));
            LogUtil.a(this.f.getDownloadDir() + " is illness");
            return;
        }
        String e = t.e(MyApplication.c());
        LogUtil.a("download url = " + this.f.getDownloadUrl() + ",,package size =" + this.f1107b.getFileSize());
        o.b(MyApplication.c(), "update_package_path", e);
    }

    public boolean e() {
        Thread thread = this.c;
        return thread != null && thread.getState() == Thread.State.RUNNABLE;
    }

    public void a() {
        LogUtil.a("thread state = " + this.c.getState());
        if (this.c.getState() == Thread.State.NEW) {
            this.c.start();
        } else if (this.c.getState() == Thread.State.TERMINATED) {
            this.c = new Thread(new b(this));
            this.c.start();
        }
    }

    public void b(Context context) {
        LogUtil.a("pause,okhttp=" + this.g);
        if (this.g != null) {
            this.c.interrupt();
            this.g.a();
        }
    }

    private void a(String str) {
        this.e = false;
        a(MyApplication.c(), str);
        l.b();
    }

    public int c() {
        return this.d;
    }

    public void a(Context context) {
        LogUtil.a(c.class.getSimpleName());
        if (this.g != null) {
            this.c.interrupt();
            this.g.a();
        }
        DownloadBean downloadBean = this.f;
        if (downloadBean != null) {
            downloadBean.setDownloadTotalSize(0L);
        }
        j();
        this.d = 0;
        i.a(0);
        com.gigaset.update.f.a.a(context, "cancel", i());
        t.a(context, t.e(context));
    }

    private void d(Context context) {
        i.a(this.d);
        String str = context.getString(R.string.download_progress) + this.d + "%";
        h.a().a(context, context.getString(R.string.notification_content_title), str);
        e.a().b(new EventMessage(200, 2000, this.d, 0L, null));
        LogUtil.a("downloading package percent = " + str);
    }

    private void a(Context context, String str) {
        j();
        LogUtil.a("STATE_PAUSE_DOWNLOAD,pkg download fail reason : " + str);
        com.gigaset.update.b.d.a(context, 3);
        e.a().b(new EventMessage(200, 3000, 0L, 0L, str));
        com.gigaset.update.f.a.a(context, "cause_fail#" + str, i());
        g.f(context);
    }

    public void a(int i) {
        this.d = i;
    }
}
