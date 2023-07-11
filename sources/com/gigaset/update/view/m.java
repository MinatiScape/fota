package com.gigaset.update.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.gigaset.update.R;
import com.gigaset.update.utils.o;
import java.util.Locale;
/* compiled from: PopWindowsLayout.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private PopupWindow f1231a;

    @TargetApi(17)
    public void a(Activity activity, View view) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.settings_pop, (ViewGroup) null);
        this.f1231a = new PopupWindow(inflate, -2, -2, true);
        this.f1231a.setFocusable(true);
        this.f1231a.setBackgroundDrawable(new ColorDrawable(0));
        int a2 = a(activity) / 60;
        int dimension = (int) activity.getResources().getDimension(R.dimen.activity_title_height);
        int a3 = a();
        this.f1231a.showAtLocation(view, 1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) ? 8388659 : 8388661, a2, (dimension + a3) - ((int) a(activity.getBaseContext(), 8.0f)));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.pop_file_select);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.pop_full_check);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.pop_setting);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.pop_exit);
        if (com.gigaset.update.utils.c.k().x()) {
            linearLayout.requestFocus();
            linearLayout.setFocusable(true);
            linearLayout2.setFocusable(true);
            linearLayout3.setFocusable(true);
            linearLayout4.setFocusable(true);
        }
        if (com.gigaset.update.utils.c.k().E()) {
            linearLayout.setVisibility(8);
        }
        if (com.gigaset.update.utils.c.k().D()) {
            linearLayout4.setVisibility(8);
        }
        if (o.a((Context) activity, "isFull", 0) == 1) {
            linearLayout2.setVisibility(0);
        }
        linearLayout.setOnClickListener(new i(this, activity));
        linearLayout2.setOnClickListener(new j(this));
        linearLayout3.setOnClickListener(new k(this, activity));
        linearLayout4.setOnClickListener(new l(this, activity));
    }

    private float a(Context context, float f) {
        if (context == null) {
            return -1.0f;
        }
        return f * context.getResources().getDisplayMetrics().density;
    }

    private int a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int a() {
        return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }
}
