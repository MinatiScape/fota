package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.material.circularreveal.e;
/* loaded from: classes.dex */
public class CircularRevealLinearLayout extends LinearLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f1317a;

    public CircularRevealLinearLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.e
    public void a() {
        this.f1317a.a();
    }

    @Override // com.google.android.material.circularreveal.e
    public void b() {
        this.f1317a.b();
    }

    @Override // com.google.android.material.circularreveal.c.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.f1317a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f1317a.c();
    }

    @Override // com.google.android.material.circularreveal.e
    public int getCircularRevealScrimColor() {
        return this.f1317a.d();
    }

    @Override // com.google.android.material.circularreveal.e
    public e.d getRevealInfo() {
        return this.f1317a.e();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f1317a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f1317a.a(drawable);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setCircularRevealScrimColor(int i) {
        this.f1317a.a(i);
    }

    @Override // com.google.android.material.circularreveal.e
    public void setRevealInfo(e.d dVar) {
        this.f1317a.a(dVar);
    }

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1317a = new c(this);
    }

    @Override // com.google.android.material.circularreveal.c.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
