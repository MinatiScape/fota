package com.gigaset.update.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.R;
/* loaded from: classes.dex */
public class InstallCheckView extends LinearLayout implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1199a;

    public InstallCheckView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.install_check_view_layout, this);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f1199a = (TextView) findViewById(R.id.content);
        checkBox.setOnCheckedChangeListener(this);
        checkBox.setChecked(true);
        textView.setOnClickListener(this);
        if (com.gigaset.update.utils.c.k().x()) {
            checkBox.setFocusable(true);
            textView.setFocusable(true);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        com.gigaset.update.manager.i.c(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1199a.setVisibility(0);
    }

    public InstallCheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public InstallCheckView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
