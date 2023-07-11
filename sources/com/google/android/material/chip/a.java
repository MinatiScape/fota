package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.core.content.a.h;
/* compiled from: Chip.java */
/* loaded from: classes.dex */
class a extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Chip f1310a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Chip chip) {
        this.f1310a = chip;
    }

    @Override // androidx.core.content.a.h.a
    public void a(int i) {
    }

    @Override // androidx.core.content.a.h.a
    public void a(Typeface typeface) {
        Chip chip = this.f1310a;
        chip.setText(chip.getText());
        this.f1310a.requestLayout();
        this.f1310a.invalidate();
    }
}
