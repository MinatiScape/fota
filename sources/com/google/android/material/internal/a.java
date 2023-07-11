package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.C0067a;
/* compiled from: CheckableImageButton.java */
/* loaded from: classes.dex */
class a extends C0067a {
    final /* synthetic */ CheckableImageButton c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CheckableImageButton checkableImageButton) {
        this.c = checkableImageButton;
    }

    @Override // androidx.core.h.C0067a
    public void a(View view, androidx.core.h.a.c cVar) {
        super.a(view, cVar);
        cVar.c(true);
        cVar.d(this.c.isChecked());
    }

    @Override // androidx.core.h.C0067a
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.c.isChecked());
    }
}
