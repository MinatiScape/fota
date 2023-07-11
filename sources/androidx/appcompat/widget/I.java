package androidx.appcompat.widget;

import android.view.View;
/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
class I implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListPopupWindow f258a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(ListPopupWindow listPopupWindow) {
        this.f258a = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        View b2 = this.f258a.b();
        if (b2 == null || b2.getWindowToken() == null) {
            return;
        }
        this.f258a.show();
    }
}
