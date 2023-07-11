package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import com.google.android.material.circularreveal.e;
/* loaded from: classes.dex */
public class CircularRevealGridLayout extends GridLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f1316a;

    public CircularRevealGridLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.e
    public void a() {
        this.f1316a.a();
    }

    @Override // com.google.android.material.circularreveal.e
    public void b() {
        this.f1316a.b();
    }

    @Override // com.google.android.material.circularreveal.c.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.f1316a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f1316a.c();
    }

    @Override // com.google.android.material.circularreveal.e
    public int getCircularRevealScrimColor() {
        return this.f1316a.d();
    }

    @Override // com.google.android.material.circularreveal.e
    public e.d getRevealInfo() {
        return this.f1316a.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f1316a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f1316a.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealScrimColor(int i) {
        this.f1316a.a(i);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setRevealInfo(e.d dVar) {
        this.f1316a.a(dVar);
    }

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1316a = new c(this);
    }

    @Override // com.google.android.material.circularreveal.c.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
