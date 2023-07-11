package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.core.content.a.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChipDrawable.java */
/* loaded from: classes.dex */
public class c extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f1312a = dVar;
    }

    @Override // androidx.core.content.a.h.a
    public void a(int i) {
    }

    @Override // androidx.core.content.a.h.a
    public void a(Typeface typeface) {
        this.f1312a.da = true;
        this.f1312a.I();
        this.f1312a.invalidateSelf();
    }
}
