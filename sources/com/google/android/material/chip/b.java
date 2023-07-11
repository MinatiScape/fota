package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Chip.java */
/* loaded from: classes.dex */
public class b extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Chip f1311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Chip chip) {
        this.f1311a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        if (this.f1311a.d != null) {
            this.f1311a.d.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
