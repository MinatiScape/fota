package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButton.java */
/* loaded from: classes.dex */
public class a implements e.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FloatingActionButton.a f1339a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FloatingActionButton f1340b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FloatingActionButton floatingActionButton, FloatingActionButton.a aVar) {
        this.f1340b = floatingActionButton;
        this.f1339a = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.e.d
    public void a() {
        this.f1339a.a(this.f1340b);
    }

    @Override // com.google.android.material.floatingactionbutton.e.d
    public void onShown() {
        this.f1339a.b(this.f1340b);
    }
}
