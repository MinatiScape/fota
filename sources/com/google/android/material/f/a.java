package com.google.android.material.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
/* compiled from: MaterialResources.java */
/* loaded from: classes.dex */
public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList a2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (a2 = androidx.appcompat.a.a.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : a2;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable b2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (b2 = androidx.appcompat.a.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : b2;
    }

    public static c c(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new c(context, resourceId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }
}
