package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;
/* compiled from: DrawableUtils.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1375a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1376b;

    public static boolean a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return b(drawableContainer, constantState);
    }

    private static boolean b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f1376b) {
            try {
                f1375a = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                f1375a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f1376b = true;
        }
        Method method = f1375a;
        if (method != null) {
            try {
                method.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception unused2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
