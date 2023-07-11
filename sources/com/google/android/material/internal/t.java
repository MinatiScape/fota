package com.google.android.material.internal;

import android.graphics.PorterDuff;
import android.view.View;
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class t {
    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static boolean a(View view) {
        return androidx.core.h.t.k(view) == 1;
    }
}
