package com.gigaset.update.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gigaset.update.GoogleOtaClient;
import com.gigaset.update.R;
import com.gigaset.update.R$styleable;
/* loaded from: classes.dex */
public class TitleView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1211a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f1212b;
    private ImageView c;

    public TitleView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.title_view_layout, this);
        this.f1212b = (ImageView) findViewById(R.id.image);
        this.c = (ImageView) findViewById(R.id.setting);
        this.f1211a = (TextView) findViewById(R.id.content);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.contentLayout);
        if (com.gigaset.update.utils.c.k().x()) {
            this.c.setFocusable(true);
            linearLayout.setFocusable(true);
        }
    }

    private void setViewsFromAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.view);
        String string = obtainStyledAttributes.getString(0);
        if (!TextUtils.isEmpty(string)) {
            setContent(string);
        }
        if (!com.gigaset.update.manager.a.b().a(GoogleOtaClient.class)) {
            setImage(obtainStyledAttributes.getResourceId(1, R.mipmap.back));
        }
        setSettingVisible(obtainStyledAttributes.getBoolean(3, false));
        obtainStyledAttributes.recycle();
    }

    public ImageView getSetting() {
        return this.c;
    }

    public void setContent(String str) {
        this.f1211a.setText(str);
    }

    public void setImage(int i) {
        if (i != 0) {
            this.f1212b.setBackgroundResource(i);
        }
    }

    public void setSettingClickListener(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
        this.c.setTag(10);
    }

    public void setSettingVisible(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        setViewsFromAttrs(attributeSet);
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
        setViewsFromAttrs(attributeSet);
    }
}
