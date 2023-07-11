package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes.dex */
public class ErrorDialogFragments {

    /* renamed from: a  reason: collision with root package name */
    public static int f1524a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f1525b;

    @TargetApi(11)
    /* loaded from: classes.dex */
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.a(dialogInterface, i, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i = f1524a;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void a(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        Class<?> cls = f1525b;
        if (cls == null) {
            if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) || activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        try {
            cls.newInstance();
            ErrorDialogManager.f1526a.f1528a.a();
            throw null;
        } catch (Exception e) {
            throw new RuntimeException("Event cannot be constructed", e);
        }
    }
}
