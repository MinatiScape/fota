package androidx.appcompat.app;

import android.view.View;
/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
class J implements androidx.core.h.C {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f89a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(K k) {
        this.f89a = k;
    }

    @Override // androidx.core.h.C
    public void a(View view) {
        ((View) this.f89a.h.getParent()).invalidate();
    }
}
