package com.gigaset.update.manager;

import android.view.View;
import android.view.WindowManager;
import com.gigaset.update.utils.LogUtil;
import java.util.LinkedList;
/* compiled from: FloatingManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f1157a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedList<View> f1158b = new LinkedList<>();

    public d(WindowManager windowManager) {
        this.f1157a = windowManager;
    }

    public void a(View view, WindowManager.LayoutParams layoutParams) {
        if (this.f1158b.contains(view)) {
            return;
        }
        try {
            LogUtil.a("addView");
            this.f1157a.addView(view, layoutParams);
            this.f1158b.add(view);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(View view) {
        try {
            LogUtil.a("removeView");
            this.f1157a.removeView(view);
            this.f1158b.remove(view);
        } catch (IllegalStateException unused) {
        }
    }
}
