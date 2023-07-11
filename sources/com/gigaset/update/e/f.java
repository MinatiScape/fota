package com.gigaset.update.e;

import android.content.Context;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.bean.VersionBean;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueryVersion.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1121a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f1122b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar, Context context) {
        this.f1122b = gVar;
        this.f1121a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Thread.sleep(60000L);
            int intValue = ((Integer) c.a().a("clear_cache", Integer.class)).intValue();
            VersionBean c = c.a().c();
            String deltaUrl = c != null ? c.getDeltaUrl() : "";
            String a2 = o.a(this.f1121a, "cache_url", "");
            if (intValue != 1 || a2.equals(deltaUrl)) {
                return;
            }
            LogUtil.a("execute clear cache ");
            com.gigaset.update.c.c.b().a(this.f1121a);
            com.gigaset.update.b.d.e(this.f1121a);
            o.b(this.f1121a, "cache_url", deltaUrl);
            org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1006, 0L, 0L, null));
            com.gigaset.update.f.a.a(this.f1121a, "cause_clean_cache", 0L);
            Thread.sleep(5000L);
            this.f1122b.b(this.f1121a);
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
    }
}
