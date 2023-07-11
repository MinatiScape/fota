package com.gigaset.update.h;

import android.content.Context;
import android.os.UpdateEngine;
import android.os.UpdateEngineCallback;
import com.gigaset.update.bean.EventMessage;
import com.gigaset.update.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Recovery.java */
/* loaded from: classes.dex */
public class b extends UpdateEngineCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1139a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar) {
        this.f1139a = dVar;
    }

    public void onPayloadApplicationComplete(int i) {
        Context context;
        Context context2;
        Context context3;
        LogUtil.a("onPayloadApplicationComplete,errorCode = " + i);
        if (i == 0) {
            context2 = this.f1139a.d;
            com.gigaset.update.f.a.a(context2, true, i, "ab");
            d dVar = this.f1139a;
            context3 = dVar.d;
            dVar.b(context3);
            return;
        }
        d dVar2 = this.f1139a;
        context = dVar2.d;
        dVar2.a(context, i, true);
    }

    public void onStatusUpdate(int i, float f) {
        boolean z;
        Context context;
        String str;
        UpdateEngine updateEngine;
        Context context2;
        LogUtil.a("update status,percent = " + f + ",status=" + i + ",show=" + com.gigaset.update.utils.c.k().t());
        if (i == 0) {
            z = this.f1139a.f1143b;
            if (z) {
                return;
            }
            d dVar = this.f1139a;
            context = dVar.d;
            str = this.f1139a.e;
            updateEngine = this.f1139a.c;
            dVar.a(context, str, updateEngine);
            return;
        }
        if (i == 3) {
            org.greenrobot.eventbus.e.a().b(new EventMessage(300, i, Double.valueOf(Math.floor(f * ("ShowFinalizingPro".equalsIgnoreCase(com.gigaset.update.utils.c.k().t()) ? 50.0f : 100.0f))).longValue(), 600L, "ab"));
        } else if (i == 5) {
            if ("ShowFinalizingPro".equalsIgnoreCase(com.gigaset.update.utils.c.k().t())) {
                org.greenrobot.eventbus.e.a().b(new EventMessage(300, i, Double.valueOf(Math.floor(f * 50.0f)).longValue() + 50, 600L, "ab"));
            }
        } else if (i != 6) {
        } else {
            d dVar2 = this.f1139a;
            context2 = dVar2.d;
            dVar2.b(context2);
        }
    }
}
