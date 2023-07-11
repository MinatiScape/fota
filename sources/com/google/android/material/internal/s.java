package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.ia;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
/* compiled from: ThemeEnforcement.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1392a = {R$attr.colorPrimary};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1393b = {R$attr.colorSecondary};

    public static TypedArray a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        a(context, attributeSet, i, i2);
        c(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static ia b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        a(context, attributeSet, i, i2);
        c(context, attributeSet, iArr, i, i2, iArr2);
        return ia.a(context, attributeSet, iArr, i, i2);
    }

    private static void c(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i, i2);
        if (!obtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            z = d(context, attributeSet, iArr, i, i2, iArr2);
        } else {
            z = obtainStyledAttributes.getResourceId(R$styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        }
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static boolean d(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i3, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    private static void a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            b(context);
        }
        a(context);
    }

    public static void b(Context context) {
        a(context, f1393b, "Theme.MaterialComponents");
    }

    public static void a(Context context) {
        a(context, f1392a, "Theme.AppCompat");
    }

    private static boolean a(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    private static void a(Context context, int[] iArr, String str) {
        if (a(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }
}
