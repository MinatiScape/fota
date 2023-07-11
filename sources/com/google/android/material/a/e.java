package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;
/* compiled from: DrawableAlphaProperty.java */
/* loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<Drawable, Integer> f1236a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f1237b;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f1237b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f1237b.containsKey(drawable)) {
            return this.f1237b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f1237b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
