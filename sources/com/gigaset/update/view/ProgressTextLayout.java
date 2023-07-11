package com.gigaset.update.view;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gigaset.update.R;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class ProgressTextLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1206a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f1207b;

    public ProgressTextLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.progress_text_layout, this);
        this.f1206a = (TextView) findViewById(R.id.progressText);
        this.f1207b = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void setProgress(int i) {
        setVisibility(0);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        long fileSize = (com.gigaset.update.e.c.a().c().getFileSize() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        this.f1206a.setText(decimalFormat.format((i * fileSize) / 100) + "MB/" + decimalFormat.format(fileSize) + "MB");
        this.f1207b.setProgress(i);
    }

    public ProgressTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ProgressTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
