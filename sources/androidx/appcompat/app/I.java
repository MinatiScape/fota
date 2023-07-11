package androidx.appcompat.app;

import android.view.View;
/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
class I extends androidx.core.h.B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f88a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(K k) {
        this.f88a = k;
    }

    @Override // androidx.core.h.A
    public void b(View view) {
        K k = this.f88a;
        k.B = null;
        k.h.requestLayout();
    }
}
