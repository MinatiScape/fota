package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.c;
import com.google.android.material.circularreveal.e;
/* loaded from: classes.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements e {
    private final c x;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.e
    public void a() {
        this.x.a();
    }

    @Override // com.google.android.material.circularreveal.e
    public void b() {
        this.x.b();
    }

    @Override // com.google.android.material.circularreveal.c.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.x;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.x.c();
    }

    @Override // com.google.android.material.circularreveal.e
    public int getCircularRevealScrimColor() {
        return this.x.d();
    }

    @Override // com.google.android.material.circularreveal.e
    public e.d getRevealInfo() {
        return this.x.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.x;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.x.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealScrimColor(int i) {
        this.x.a(i);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setRevealInfo(e.d dVar) {
        this.x.a(dVar);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new c(this);
    }

    @Override // com.google.android.material.circularreveal.c.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
