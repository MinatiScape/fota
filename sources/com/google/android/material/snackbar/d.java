package com.google.android.material.snackbar;

import androidx.core.h.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public class d implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar$SnackbarBaseLayout f1400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout) {
        this.f1400a = baseTransientBottomBar$SnackbarBaseLayout;
    }

    @Override // androidx.core.h.a.b.a
    public void onTouchExplorationStateChanged(boolean z) {
        this.f1400a.setClickableOrFocusableBasedOnAccessibility(z);
    }
}
