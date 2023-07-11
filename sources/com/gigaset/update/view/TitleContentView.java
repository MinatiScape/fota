package com.gigaset.update.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.R;
import com.gigaset.update.R$styleable;
/* loaded from: classes.dex */
public class TitleContentView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1209a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1210b;
    private TextView c;
    private CheckBox d;
    private ImageView e;
    private View.OnClickListener f;

    public TitleContentView(Context context) {
        super(context);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.title_content_view_layout, this);
        this.f1209a = (TextView) findViewById(R.id.title);
        this.f1210b = (TextView) findViewById(R.id.content);
        this.c = (TextView) findViewById(R.id.tip);
        this.d = (CheckBox) findViewById(R.id.checkBox);
        this.e = (ImageView) findViewById(R.id.arrow);
        super.setOnClickListener(this);
        if (com.gigaset.update.utils.c.k().x()) {
            setFocusable(true);
        }
    }

    private void setViewsFromAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.view);
        String string = obtainStyledAttributes.getString(4);
        if (!TextUtils.isEmpty(string)) {
            setTitle(string);
        }
        String string2 = obtainStyledAttributes.getString(0);
        if (!TextUtils.isEmpty(string2)) {
            setContent(string2);
        } else {
            setContentVisible(8);
        }
        if (obtainStyledAttributes.getBoolean(2, false)) {
            b();
        }
        obtainStyledAttributes.recycle();
    }

    public boolean a() {
        return this.d.isChecked();
    }

    public void b() {
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        setChecked(!a());
        View.OnClickListener onClickListener = this.f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setChecked(boolean z) {
        this.d.setChecked(z);
    }

    public void setContent(String str) {
        this.f1210b.setText(str);
    }

    public void setContentVisible(int i) {
        this.f1210b.setVisibility(i);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void setTip(String str) {
        this.c.setText(str);
    }

    public void setTitle(String str) {
        this.f1209a.setText(str);
    }

    public void setTip(int i) {
        setTip(getContext().getString(i));
    }

    public TitleContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        setViewsFromAttrs(attributeSet);
    }

    public TitleContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
        setViewsFromAttrs(attributeSet);
    }
}
