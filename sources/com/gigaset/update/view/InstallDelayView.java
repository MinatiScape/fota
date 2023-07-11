package com.gigaset.update.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.gigaset.update.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class InstallDelayView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private com.gigaset.update.a.d f1200a;

    public InstallDelayView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.install_delay_dialog_schedule_choice, this);
        ArrayList<RadioButton> arrayList = new ArrayList();
        RadioButton radioButton = (RadioButton) findViewById(R.id.RadioButton1);
        arrayList.add(radioButton);
        arrayList.add((RadioButton) findViewById(R.id.RadioButton2));
        arrayList.add((RadioButton) findViewById(R.id.RadioButton3));
        for (RadioButton radioButton2 : arrayList) {
            radioButton2.setOnClickListener(this);
        }
        if (com.gigaset.update.utils.c.k().x()) {
            for (RadioButton radioButton3 : arrayList) {
                radioButton3.setFocusable(true);
            }
            radioButton.requestFocus();
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
        com.gigaset.update.a.d dVar = this.f1200a;
        if (dVar != null) {
            dVar.onClick(i);
        }
    }

    public void setOnItemClickListener(com.gigaset.update.a.d dVar) {
        this.f1200a = dVar;
    }

    public InstallDelayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public InstallDelayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
