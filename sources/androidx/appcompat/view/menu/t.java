package androidx.appcompat.view.menu;

import android.widget.PopupWindow;
/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
class t implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(u uVar) {
        this.f193a = uVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f193a.d();
    }
}
