package com.gigaset.update.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.R;
/* loaded from: classes.dex */
public class DeviceFunctionView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1193a;

    /* renamed from: b  reason: collision with root package name */
    private com.gigaset.update.a.c f1194b;

    public DeviceFunctionView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.dialog_debug_info, this);
        this.f1193a = (TextView) findViewById(R.id.info);
        findViewById(R.id.button_export_data).setOnClickListener(this);
        findViewById(R.id.button_start_debug).setOnClickListener(this);
        findViewById(R.id.button_stop_debug).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.button_start_debug /* 2131230769 */:
                i = 1;
                break;
            case R.id.button_stop_debug /* 2131230770 */:
                i = 2;
                break;
        }
        com.gigaset.update.a.c cVar = this.f1194b;
        if (cVar != null) {
            cVar.onItemClick(i);
        }
    }

    public void setInfo(String str) {
        this.f1193a.setText(str);
    }

    public void setOnFunctionClickListener(com.gigaset.update.a.c cVar) {
        this.f1194b = cVar;
    }

    public DeviceFunctionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DeviceFunctionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
