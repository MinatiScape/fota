package com.gigaset.update.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.gigaset.update.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CheckScheduleView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private List<RadioButton> f1191a;

    /* renamed from: b  reason: collision with root package name */
    private com.gigaset.update.a.c f1192b;

    public CheckScheduleView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.activity_setting_dialog_schedule_choice, this);
        this.f1191a = new ArrayList();
        this.f1191a.add((RadioButton) findViewById(R.id.RadioButton1));
        this.f1191a.add((RadioButton) findViewById(R.id.RadioButton2));
        this.f1191a.add((RadioButton) findViewById(R.id.RadioButton3));
        for (RadioButton radioButton : this.f1191a) {
            radioButton.setOnClickListener(this);
            if (com.gigaset.update.utils.c.k().x()) {
                radioButton.setFocusable(true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.RadioButton2 /* 2131230725 */:
                i = 1;
                break;
            case R.id.RadioButton3 /* 2131230726 */:
                i = 2;
                break;
        }
        com.gigaset.update.a.c cVar = this.f1192b;
        if (cVar != null) {
            cVar.onItemClick(i);
        }
    }

    public void setItemChecked(int i) {
        List<RadioButton> list = this.f1191a;
        if (list == null || list.isEmpty() || i > this.f1191a.size()) {
            return;
        }
        RadioButton radioButton = this.f1191a.get(i);
        radioButton.setChecked(true);
        if (com.gigaset.update.utils.c.k().x()) {
            radioButton.requestFocus();
        }
    }

    public void setOnItemClickListener(com.gigaset.update.a.c cVar) {
        this.f1192b = cVar;
    }

    public CheckScheduleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CheckScheduleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
