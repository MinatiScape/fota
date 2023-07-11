package com.gigaset.update.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class ProgressRingView extends View {

    /* renamed from: a  reason: collision with root package name */
    private RectF f1204a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1205b;
    private Paint c;
    private int d;

    public ProgressRingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1205b = true;
        this.d = 0;
    }

    public int getProgress() {
        return this.d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1205b) {
            this.f1204a = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.c = new Paint(1);
            this.c.setColor(-1);
            this.c.setAntiAlias(true);
            this.c.setStyle(Paint.Style.FILL);
            this.f1205b = false;
        }
        canvas.drawArc(this.f1204a, 272.0f, (this.d * 360) / 100, true, this.c);
        canvas.save();
        canvas.restore();
    }

    public void setProgress(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.d = i;
        invalidate();
    }
}
