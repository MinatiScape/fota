package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.material.circularreveal.e;
/* loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f1315a;

    public CircularRevealFrameLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.e
    public void a() {
        this.f1315a.a();
    }

    @Override // com.google.android.material.circularreveal.e
    public void b() {
        this.f1315a.b();
    }

    @Override // com.google.android.material.circularreveal.c.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f1315a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f1315a.c();
    }

    @Override // com.google.android.material.circularreveal.e
    public int getCircularRevealScrimColor() {
        return this.f1315a.d();
    }

    @Override // com.google.android.material.circularreveal.e
    public e.d getRevealInfo() {
        return this.f1315a.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f1315a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f1315a.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealScrimColor(int i) {
        this.f1315a.a(i);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setRevealInfo(e.d dVar) {
        this.f1315a.a(dVar);
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1315a = new c(this);
    }

    @Override // com.google.android.material.circularreveal.c.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
