package com.gigaset.update.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.R;
/* loaded from: classes.dex */
public class NetworkWarnView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1201a;

    public NetworkWarnView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.dialog_no_network, this);
        this.f1201a = (TextView) findViewById(R.id.dialog_prompt_content);
        TextView textView = (TextView) findViewById(R.id.wifi_enter);
        textView.setOnClickListener(this);
        if (com.gigaset.update.utils.c.k().x()) {
            textView.setFocusable(true);
            textView.requestFocus();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        getContext().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }

    public void setTitle(String str) {
        this.f1201a.setText(str);
    }

    public NetworkWarnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public NetworkWarnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
