package com.google.android.material.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.a.h;
import com.google.android.material.R$styleable;
/* compiled from: TextAppearance.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float f1332a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f1333b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final ColorStateList i;
    public final float j;
    public final float k;
    public final float l;
    private final int m;
    private boolean n = false;
    private Typeface o;

    public c(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        this.f1332a = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.f1333b = a.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        this.c = a.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.d = a.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.e = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int a2 = a.a(obtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.m = obtainStyledAttributes.getResourceId(a2, 0);
        this.g = obtainStyledAttributes.getString(a2);
        this.h = obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.i = a.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.j = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.k = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.l = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void b(Context context, TextPaint textPaint, h.a aVar) {
        c(context, textPaint, aVar);
        ColorStateList colorStateList = this.f1333b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.l;
        float f2 = this.j;
        float f3 = this.k;
        ColorStateList colorStateList2 = this.i;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void c(Context context, TextPaint textPaint, h.a aVar) {
        if (d.a()) {
            a(textPaint, a(context));
            return;
        }
        a(context, textPaint, aVar);
        if (this.n) {
            return;
        }
        a(textPaint, this.o);
    }

    public Typeface a(Context context) {
        if (this.n) {
            return this.o;
        }
        if (!context.isRestricted()) {
            try {
                this.o = h.a(context, this.m);
                if (this.o != null) {
                    this.o = Typeface.create(this.o, this.e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.g, e);
            }
        }
        a();
        this.n = true;
        return this.o;
    }

    public void a(Context context, TextPaint textPaint, h.a aVar) {
        if (this.n) {
            a(textPaint, this.o);
            return;
        }
        a();
        if (context.isRestricted()) {
            this.n = true;
            a(textPaint, this.o);
            return;
        }
        try {
            h.a(context, this.m, new b(this, textPaint, aVar), null);
        } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.g, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.o == null) {
            this.o = Typeface.create(this.g, this.e);
        }
        if (this.o == null) {
            int i = this.f;
            if (i == 1) {
                this.o = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.o = Typeface.SERIF;
            } else if (i != 3) {
                this.o = Typeface.DEFAULT;
            } else {
                this.o = Typeface.MONOSPACE;
            }
            Typeface typeface = this.o;
            if (typeface != null) {
                this.o = Typeface.create(typeface, this.e);
            }
        }
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.e;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f1332a);
    }
}
