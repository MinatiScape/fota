package com.gigaset.update.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.MyApplication;
import com.gigaset.update.R;
import com.gigaset.update.utils.LogUtil;
/* loaded from: classes.dex */
public class FloatingView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager.LayoutParams f1195a;

    /* renamed from: b  reason: collision with root package name */
    private static com.gigaset.update.manager.d f1196b;
    private static View c;
    @SuppressLint({"StaticFieldLeak"})
    private static FloatingView d;
    private LinearLayout e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private Context mContext;

    public FloatingView(Context context) {
        super(context);
        this.mContext = MyApplication.c();
        c = LayoutInflater.from(this.mContext).inflate(R.layout.dialog, (ViewGroup) null);
        f1196b = new com.gigaset.update.manager.d((WindowManager) context.getSystemService("window"));
        a(context, c);
    }

    public static FloatingView a(Context context) {
        d = new FloatingView(context);
        return d;
    }

    @SuppressLint({"WrongConstant"})
    public static void b() {
        LogUtil.a("");
        f1195a = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = f1195a;
        layoutParams.gravity = 17;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.type = 2038;
        layoutParams.format = 1;
        layoutParams.flags = 327968;
        layoutParams.width = -2;
        layoutParams.height = -2;
        c.setBackgroundResource(R.drawable.dialog_frame);
        f1196b.a(c, f1195a);
    }

    private void a(Context context, View view) {
        int c2 = com.gigaset.update.b.d.c(MyApplication.c());
        LogUtil.a("status : " + c2);
        this.g = (TextView) view.findViewById(R.id.title);
        this.i = (TextView) view.findViewById(R.id.positiveButton);
        this.j = (TextView) view.findViewById(R.id.negativeButton);
        this.h = (TextView) view.findViewById(R.id.message);
        this.f = (LinearLayout) view.findViewById(R.id.bottom);
        this.e = (LinearLayout) view.findViewById(R.id.content);
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        this.i.setVisibility(0);
        this.i.setBackgroundResource(R.drawable.dialog_selector);
        this.j.setVisibility(8);
        this.j.setBackgroundResource(R.drawable.dialog_selector);
        this.h.setVisibility(0);
        if (c2 == 1) {
            this.g.setText(R.string.sdCard_upgrade_hint);
            this.j.setVisibility(0);
            this.h.setText(com.gigaset.update.e.c.a().a(MyApplication.c(), false));
            this.i.setText(R.string.btn_download);
            this.i.setOnClickListener(new b(this));
            this.j.setText(R.string.btn_ignore);
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.gigaset.update.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FloatingView.this.a(view2);
                }
            });
        } else if (c2 != 4) {
            if (c2 != 6) {
                return;
            }
            this.j.setVisibility(0);
            this.g.setText(R.string.ab_install_success);
            this.h.setText(R.string.updated_need_reboot);
            this.i.setText(R.string.ab_reboot_now);
            this.j.setText(R.string.close);
            this.i.setOnClickListener(new g(this, context));
            this.j.setOnClickListener(new h(this));
        } else if (com.gigaset.update.d.d.a(context, com.gigaset.update.utils.c.k().b())) {
            this.j.setVisibility(0);
            if (com.gigaset.update.manager.i.n()) {
                this.g.setText(R.string.new_to_upgrade);
                this.i.setText(R.string.update_now);
                this.j.setText(R.string.update_later);
                this.i.setOnClickListener(new c(this));
                this.j.setOnClickListener(new d(this, context));
                return;
            }
            com.gigaset.update.manager.i.c(true);
            this.g.setText(R.string.new_to_upgrade);
            this.i.setText(R.string.update_now);
            this.j.setText(R.string.update_later);
            this.i.setOnClickListener(new e(this));
            this.j.setOnClickListener(new f(this, context));
        } else {
            LogUtil.a("no update reason : battery not enough");
        }
    }

    public /* synthetic */ void a(View view) {
        a();
    }

    public void a() {
        LogUtil.a("hide");
        f1196b.a(c);
    }
}
