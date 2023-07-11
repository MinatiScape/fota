package com.google.android.material.internal;

import android.graphics.Outline;
/* compiled from: CircularBorderDrawableLollipop.java */
/* loaded from: classes.dex */
public class d extends c {
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.f1369b);
        outline.setOval(this.f1369b);
    }
}
