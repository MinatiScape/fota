package com.gigaset.update.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gigaset.update.R;
/* loaded from: classes.dex */
public class ProgressLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f1202a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f1203b;
    private ProgressRingView c;
    private TextView d;
    private TextView e;

    public ProgressLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(R.layout.main_pro_ring, this);
        this.f1202a = (ImageView) findViewById(R.id.def_img);
        this.f1202a.setTag(Integer.valueOf((int) R.id.def_img));
        this.f1203b = (RelativeLayout) findViewById(R.id.rl_download_pro);
        this.c = (ProgressRingView) findViewById(R.id.download_pro_ring);
        this.d = (TextView) findViewById(R.id.txt_progress);
        this.e = (TextView) findViewById(R.id.def_version_tip);
        this.d.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Bariol_Regular.ttf"));
    }

    public void a() {
        this.f1202a.setVisibility(0);
        this.e.setText("");
        this.e.setVisibility(0);
        this.f1203b.setVisibility(8);
        this.c.setProgress(0);
        this.d.setText("");
    }

    public int getProgress() {
        return this.c.getProgress();
    }

    public void setDownLoadProgress(int i) {
        this.f1202a.setVisibility(8);
        this.e.setVisibility(8);
        this.f1203b.setVisibility(0);
        this.c.setProgress(i);
        TextView textView = this.d;
        textView.setText("" + i);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1202a.setOnClickListener(onClickListener);
    }

    public void setProgress(int i) {
        this.c.setProgress(i);
    }

    public void setVersionTip(String str) {
        this.f1202a.setImageDrawable(new ColorDrawable(0));
        this.e.setText(str);
    }
}
