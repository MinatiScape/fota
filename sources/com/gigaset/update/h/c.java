package com.gigaset.update.h;

import android.content.Context;
import android.os.Build;
import android.os.UpdateEngine;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.utils.LogUtil;
import com.gigaset.update.utils.g;
import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Recovery.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1140a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f1141b;
    final /* synthetic */ UpdateEngine c;
    final /* synthetic */ d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, String str, Context context, UpdateEngine updateEngine) {
        this.d = dVar;
        this.f1140a = str;
        this.f1141b = context;
        this.c = updateEngine;
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] strArr;
        try {
            List<String> e = g.e(this.f1140a);
            String[] strArr2 = (String[]) e.toArray(new String[e.size()]);
            LogUtil.a("headerKeyValuePairs = " + Arrays.toString(strArr2) + ",headerKeyValuePairs length = " + strArr.length);
            if (Build.VERSION.SDK_INT > 23 && strArr2.length <= 1) {
                LogUtil.a("length <= 1");
                com.gigaset.update.manager.g.c(this.f1141b, 1);
                com.gigaset.update.e.c.a().a(this.f1141b);
                this.d.a(this.f1141b, 618, false);
                return;
            }
            com.gigaset.update.b.d.a(this.f1141b, 5);
            org.greenrobot.eventbus.e.a().b(new EventMessage(300, 99, 0L, 602L, "ab"));
            long g = g.g(this.f1140a);
            long parseLong = Long.parseLong(strArr2[1].replace("FILE_SIZE=", ""));
            this.d.f1143b = true;
            this.c.applyPayload("file://" + this.f1140a, g, parseLong, strArr2);
        } catch (Exception e2) {
            LogUtil.a(e2.getMessage());
        }
    }
}
