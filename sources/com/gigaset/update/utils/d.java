package com.gigaset.update.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gigaset.update.R;
/* compiled from: DialogUtil.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static com.gigaset.update.k f1168a;

    public static com.gigaset.update.k a(Context context, int i, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, null, null, null, null, null, null, onDismissListener, LayoutInflater.from(context).inflate(i, (ViewGroup) null), false);
    }

    public static com.gigaset.update.k b(Context context, String str, String str2, com.gigaset.update.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, context.getString(17039370), aVar, (String) null, (com.gigaset.update.a.a) null, onDismissListener);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2) {
        return a(context, str, str2, context.getString(17039370), (com.gigaset.update.a.a) null, (String) null, (com.gigaset.update.a.a) null, (DialogInterface.OnDismissListener) null);
    }

    public static com.gigaset.update.k b(Context context, String str, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, null, null, null, null, null, onDismissListener, 17, 8388613, view, false);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, context.getString(17039370), (com.gigaset.update.a.a) null, (String) null, (com.gigaset.update.a.a) null, onDismissListener);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, com.gigaset.update.a.a aVar) {
        return a(context, str, str2, context.getString(17039370), aVar, context.getString(17039360), (com.gigaset.update.a.a) null);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, com.gigaset.update.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, context.getString(17039370), aVar, context.getString(17039360), null, onDismissListener, null, false);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, com.gigaset.update.a.a aVar, com.gigaset.update.a.a aVar2) {
        return a(context, str, str2, context.getString(17039370), aVar, context.getString(17039360), aVar2);
    }

    public static com.gigaset.update.k a(Context context, int i, String str) {
        return a(context, i, str, (DialogInterface.OnDismissListener) null);
    }

    public static com.gigaset.update.k a(Context context, int i, String str, DialogInterface.OnDismissListener onDismissListener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_prompt_base, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.dialog_prompt_icon)).setBackgroundResource(i);
        ((TextView) inflate.findViewById(R.id.dialog_prompt_content)).setText(str);
        return a(context, context.getString(17039370), onDismissListener, inflate, false);
    }

    public static com.gigaset.update.k a(Context context, int i, String str, int i2, String str2, com.gigaset.update.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_prompt_base, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.dialog_prompt_icon)).setBackgroundResource(i);
        ((TextView) inflate.findViewById(R.id.dialog_prompt_content)).setText(str);
        return a(context, null, null, str2, aVar, null, null, onDismissListener, 8388611, i2, inflate, false);
    }

    public static com.gigaset.update.k a(Context context, String str, int i, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, null, null, null, null, null, onDismissListener, i, 8388613, view, false);
    }

    public static com.gigaset.update.k a(Context context, String str, View view) {
        return a(context, str, null, null, null, null, null, null, view, false);
    }

    public static com.gigaset.update.k a(Context context, String str, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, null, context.getString(17039370), null, null, null, onDismissListener, view, false);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, com.gigaset.update.a.a aVar, String str3, com.gigaset.update.a.a aVar2, DialogInterface.OnDismissListener onDismissListener, View view) {
        return a(context, str, null, str2, aVar, str3, aVar2, onDismissListener, view, false);
    }

    public static com.gigaset.update.k a(Context context, String str, DialogInterface.OnDismissListener onDismissListener, View view, boolean z) {
        return a(context, null, null, str, null, null, null, onDismissListener, view, false);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, String str3, com.gigaset.update.a.a aVar, String str4, com.gigaset.update.a.a aVar2) {
        return a(context, str, str2, str3, aVar, str4, aVar2, null, null, false);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, String str3, com.gigaset.update.a.a aVar, String str4, com.gigaset.update.a.a aVar2, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, str3, aVar, str4, aVar2, onDismissListener, null, false);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, String str3, com.gigaset.update.a.a aVar, String str4, com.gigaset.update.a.a aVar2, DialogInterface.OnDismissListener onDismissListener, View view, boolean z) {
        return a(context, str, str2, str3, aVar, str4, aVar2, onDismissListener, 8388611, 8388613, view, z);
    }

    public static com.gigaset.update.k a(Context context, String str, String str2, String str3, com.gigaset.update.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        return a(context, str, str2, str3, aVar, null, null, onDismissListener, 17, 17, null, false);
    }

    private static com.gigaset.update.k a(Context context, String str, String str2, String str3, com.gigaset.update.a.a aVar, String str4, com.gigaset.update.a.a aVar2, DialogInterface.OnDismissListener onDismissListener, int i, int i2, View view, boolean z) {
        f1168a = new com.gigaset.update.k(context, R.style.Dialog);
        f1168a.b(str);
        f1168a.b(i);
        f1168a.a(str2);
        if (!TextUtils.isEmpty(str2)) {
            LogUtil.a(str2);
        }
        f1168a.a(i2);
        f1168a.b(str3, aVar);
        f1168a.a(str4, aVar2);
        f1168a.setOnDismissListener(onDismissListener);
        if (view != null) {
            f1168a.setContentView(view);
        }
        f1168a.show();
        return f1168a;
    }

    public static void a() {
        com.gigaset.update.k kVar = f1168a;
        if (kVar != null && kVar.isShowing()) {
            try {
                try {
                    Context baseContext = ((ContextWrapper) f1168a.getContext()).getBaseContext();
                    if (baseContext instanceof Activity) {
                        if (!((Activity) baseContext).isFinishing() && !((Activity) baseContext).isDestroyed()) {
                            f1168a.dismiss();
                        }
                    } else {
                        f1168a.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                f1168a = null;
                LogUtil.a("closeDialog");
            } finally {
                f1168a = null;
            }
        }
    }
}
