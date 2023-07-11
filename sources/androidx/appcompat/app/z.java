package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.h.C0070d;
/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
class z implements C0070d.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(A a2) {
        this.f122a = a2;
    }

    @Override // androidx.core.h.C0070d.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f122a.a(keyEvent);
    }
}
