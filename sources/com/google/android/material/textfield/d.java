package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
public class d implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextInputLayout f1435a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextInputLayout textInputLayout) {
        this.f1435a = textInputLayout;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        TextInputLayout textInputLayout = this.f1435a;
        z = textInputLayout.fa;
        textInputLayout.b(!z);
        TextInputLayout textInputLayout2 = this.f1435a;
        if (textInputLayout2.e) {
            textInputLayout2.a(editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
