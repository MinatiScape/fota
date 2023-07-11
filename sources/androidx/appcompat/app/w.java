package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class w extends androidx.core.h.B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl.c f120a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(AppCompatDelegateImpl.c cVar) {
        this.f120a = cVar;
    }

    @Override // androidx.core.h.A
    public void b(View view) {
        AppCompatDelegateImpl.this.q.setVisibility(8);
        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
        PopupWindow popupWindow = appCompatDelegateImpl.r;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (appCompatDelegateImpl.q.getParent() instanceof View) {
            androidx.core.h.t.D((View) AppCompatDelegateImpl.this.q.getParent());
        }
        AppCompatDelegateImpl.this.q.removeAllViews();
        AppCompatDelegateImpl.this.t.a((androidx.core.h.A) null);
        AppCompatDelegateImpl.this.t = null;
    }
}
