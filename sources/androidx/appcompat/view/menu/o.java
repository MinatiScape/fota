package androidx.appcompat.view.menu;

import androidx.core.h.AbstractC0068b;
/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
class o implements AbstractC0068b.InterfaceC0015b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f186a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar) {
        this.f186a = pVar;
    }

    @Override // androidx.core.h.AbstractC0068b.InterfaceC0015b
    public void onActionProviderVisibilityChanged(boolean z) {
        p pVar = this.f186a;
        pVar.n.d(pVar);
    }
}
