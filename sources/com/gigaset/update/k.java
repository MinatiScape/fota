package com.gigaset.update;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
/* compiled from: MaterialDialog.java */
/* loaded from: classes.dex */
public class k extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1148a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f1149b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;

    public k(Context context, int i) {
        super(context, i);
        a();
        b();
        setCancelable(false);
    }

    private void a() {
        super.setContentView(R.layout.dialog);
        this.c = (TextView) findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.positiveButton);
        this.f = (TextView) findViewById(R.id.negativeButton);
        this.d = (TextView) findViewById(R.id.message);
        this.f1149b = (LinearLayout) findViewById(R.id.bottom);
        this.f1148a = (LinearLayout) findViewById(R.id.content);
        this.c.setVisibility(8);
        this.f1149b.setVisibility(8);
        this.e.setVisibility(8);
        this.e.setBackgroundResource(R.drawable.dialog_selector);
        this.f.setVisibility(8);
        this.f.setBackgroundResource(R.drawable.dialog_selector);
        this.d.setVisibility(8);
        if (com.gigaset.update.utils.c.k().x()) {
            this.e.setFocusable(true);
            this.e.requestFocus();
            this.f.setFocusable(true);
            this.f.requestFocus();
        }
    }

    private void b() {
        Display defaultDisplay;
        Window window;
        WindowManager.LayoutParams attributes;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null || (window = getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        double width = defaultDisplay.getWidth();
        Double.isNaN(width);
        attributes.width = Double.valueOf(width * 0.85d).intValue();
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.d.setVisibility(8);
        this.f1148a.setVisibility(0);
        this.f1148a.removeAllViews();
        this.f1148a.addView(view, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.e.getVisibility() == 8 && this.f.getVisibility() == 8) {
            this.f1149b.setVisibility(8);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setText(str);
        this.c.setVisibility(0);
    }

    public void b(int i) {
        this.c.setGravity(i);
    }

    public void b(String str, com.gigaset.update.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setText(str);
        this.e.setOnClickListener(new i(this, aVar));
        this.e.setVisibility(0);
        this.f1149b.setVisibility(0);
    }

    public void a(int i) {
        this.f1149b.setGravity(i);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d.setVisibility(8);
            return;
        }
        this.f1148a.setVisibility(8);
        this.d.setText(str);
        this.d.setVisibility(0);
    }

    public void a(String str, com.gigaset.update.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setText(str);
        this.f.setOnClickListener(new j(this, aVar));
        this.f.setVisibility(0);
        this.f1149b.setVisibility(0);
    }
}
