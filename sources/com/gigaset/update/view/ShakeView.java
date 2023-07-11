package com.gigaset.update.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.R;
import com.gigaset.update.utils.q;
/* loaded from: classes.dex */
public class ShakeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1208a;

    public ShakeView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.shake_view_layout, this);
        this.f1208a = (TextView) findViewById(R.id.content);
        if (q.a().a(getContext())) {
            return;
        }
        setVisibility(8);
    }

    public void setContent(int i) {
        if (q.a().a(getContext())) {
            setVisibility(0);
            this.f1208a.setText(i);
        }
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
