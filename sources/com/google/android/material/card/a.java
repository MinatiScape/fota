package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.material.R$styleable;
/* compiled from: MaterialCardViewHelper.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f1304a;

    /* renamed from: b  reason: collision with root package name */
    private int f1305b;
    private int c;

    public a(MaterialCardView materialCardView) {
        this.f1304a = materialCardView;
    }

    private void d() {
        this.f1304a.a(this.f1304a.getContentPaddingLeft() + this.c, this.f1304a.getContentPaddingTop() + this.c, this.f1304a.getContentPaddingRight() + this.c, this.f1304a.getContentPaddingBottom() + this.c);
    }

    private Drawable e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f1304a.getRadius());
        int i = this.f1305b;
        if (i != -1) {
            gradientDrawable.setStroke(this.c, i);
        }
        return gradientDrawable;
    }

    public void a(TypedArray typedArray) {
        this.f1305b = typedArray.getColor(R$styleable.MaterialCardView_strokeColor, -1);
        this.c = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.c = i;
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1304a.setForeground(e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f1305b = i;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1305b;
    }
}
