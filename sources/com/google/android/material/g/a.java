package com.google.android.material.g;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
/* compiled from: RippleUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1350a;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1351b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;

    static {
        f1350a = Build.VERSION.SDK_INT >= 21;
        f1351b = new int[]{16842919};
        c = new int[]{16843623, 16842908};
        d = new int[]{16842908};
        e = new int[]{16843623};
        f = new int[]{16842913, 16842919};
        g = new int[]{16842913, 16843623, 16842908};
        h = new int[]{16842913, 16842908};
        i = new int[]{16842913, 16843623};
        j = new int[]{16842913};
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f1350a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a(colorStateList, f), a(colorStateList, f1351b)});
        }
        int[] iArr = f;
        int[] iArr2 = g;
        int[] iArr3 = h;
        int[] iArr4 = i;
        int[] iArr5 = f1351b;
        int[] iArr6 = c;
        int[] iArr7 = d;
        int[] iArr8 = e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f1350a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    private static int a(int i2) {
        return androidx.core.a.a.b(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
