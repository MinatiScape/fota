package com.google.android.material.textfield;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextInputLayout f1436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TextInputLayout textInputLayout) {
        this.f1436a = textInputLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1436a.a(false);
    }
}
