package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
/* compiled from: CutoutDrawable.java */
/* loaded from: classes.dex */
class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1429a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final RectF f1430b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        c();
        this.f1430b = new RectF();
    }

    private void c() {
        this.f1429a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f1429a.setColor(-1);
        this.f1429a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return !this.f1430b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f1430b, this.f1429a);
        a(canvas);
    }

    private void b(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            c(canvas);
        }
    }

    void a(float f, float f2, float f3, float f4) {
        RectF rectF = this.f1430b;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        this.f1430b.set(f, f2, f3, f4);
        invalidateSelf();
    }

    private void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private void a(Canvas canvas) {
        if (a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.c);
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
