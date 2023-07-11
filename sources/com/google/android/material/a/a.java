package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* compiled from: AnimationUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f1232a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f1233b = new a.d.a.a.b();
    public static final TimeInterpolator c = new a.d.a.a.a();
    public static final TimeInterpolator d = new a.d.a.a.c();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int a(int i, int i2, float f) {
        return i + Math.round(f * (i2 - i));
    }
}
