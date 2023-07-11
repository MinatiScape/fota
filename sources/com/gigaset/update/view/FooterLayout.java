package com.gigaset.update.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.R;
import com.gigaset.update.utils.o;
import java.util.Locale;
/* loaded from: classes.dex */
public class FooterLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1197a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1198b;
    private TextView c;
    private LinearLayout d;

    public FooterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    private void b(int i) {
        if (i == 1) {
            this.f1197a.setTag(1);
            try {
                long fileSize = com.gigaset.update.e.c.a().c().getFileSize();
                TextView textView = this.f1197a;
                textView.setText(getResources().getString(R.string.btn_download) + "(" + com.gigaset.update.utils.g.a(fileSize) + ")");
            } catch (Exception unused) {
                this.f1197a.setText(R.string.btn_download);
            }
            setState(true);
        }
    }

    public void a() {
        if (com.gigaset.update.utils.c.k().x()) {
            if (this.f1197a.getVisibility() == 0) {
                this.f1197a.setFocusable(true);
                this.f1197a.requestFocus();
                return;
            }
            this.f1198b.setFocusable(true);
            this.f1198b.requestFocus();
            this.c.setFocusable(true);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.main_footer, this);
        this.f1197a = (TextView) findViewById(R.id.bt_check);
        this.f1197a.setTag(0);
        this.d = (LinearLayout) findViewById(R.id.hl_bt_layout);
        this.d.setVisibility(8);
        this.f1198b = (TextView) findViewById(R.id.button_left);
        this.f1198b.setTag(2);
        this.c = (TextView) findViewById(R.id.button_right);
        this.c.setTag(5);
        if (com.gigaset.update.utils.c.k().x()) {
            this.f1198b.setFocusable(true);
            this.f1198b.requestFocus();
            this.c.setFocusable(true);
        }
        if (1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault())) {
            this.f1198b.setBackgroundResource(R.drawable.button_right_selector);
            this.c.setBackgroundResource(R.drawable.button_left_selector);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1197a.setOnClickListener(onClickListener);
        this.f1198b.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
    }

    public void setState(boolean z) {
        if (z) {
            this.f1197a.setVisibility(0);
            this.d.setVisibility(8);
            if (com.gigaset.update.utils.c.k().x()) {
                this.f1197a.setFocusable(true);
                this.f1197a.requestFocus();
                return;
            }
            return;
        }
        this.f1197a.setVisibility(8);
        this.d.setVisibility(0);
        if (com.gigaset.update.utils.c.k().x()) {
            this.f1198b.setFocusable(true);
            this.f1198b.requestFocus();
            this.c.setFocusable(true);
        }
    }

    public void a(int i) {
        switch (i) {
            case 0:
                this.f1197a.setTag(0);
                this.f1197a.setText(R.string.check_now);
                setState(true);
                return;
            case 1:
                b(i);
                setState(true);
                return;
            case 2:
                this.f1198b.setTag(2);
                this.c.setTag(5);
                this.f1198b.setText(R.string.btn_pause);
                this.c.setText(17039360);
                setState(false);
                return;
            case 3:
                this.f1198b.setTag(3);
                this.c.setTag(5);
                this.f1198b.setText(R.string.btn_resume);
                this.c.setText(17039360);
                setState(false);
                return;
            case 4:
                if ((((Integer) com.gigaset.update.e.c.a().a("install_notice_type", Integer.class)).intValue() == 0 && o.a(getContext(), "install_later_count", 0) >= 5) || com.gigaset.update.utils.c.k().F()) {
                    setState(true);
                    this.f1197a.setTag(7);
                    this.f1197a.setText(R.string.update_now);
                    return;
                }
                setState(false);
                this.f1198b.setTag(7);
                this.c.setTag(8);
                this.f1198b.setText(R.string.update_now);
                this.c.setText(R.string.update_later);
                return;
            case 5:
                this.f1197a.setVisibility(4);
                this.d.setVisibility(8);
                return;
            case 6:
                setState(true);
                this.f1197a.setTag(12);
                this.f1197a.setText(R.string.ab_reboot_now);
                return;
            default:
                return;
        }
    }
}
