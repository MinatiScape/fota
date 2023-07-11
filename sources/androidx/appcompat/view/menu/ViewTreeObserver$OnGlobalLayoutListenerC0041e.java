package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CascadingMenuPopup.java */
/* renamed from: androidx.appcompat.view.menu.e  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewTreeObserver$OnGlobalLayoutListenerC0041e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC0041e(i iVar) {
        this.f168a = iVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f168a.isShowing() || this.f168a.j.size() <= 0 || this.f168a.j.get(0).f174a.h()) {
            return;
        }
        View view = this.f168a.q;
        if (view != null && view.isShown()) {
            for (i.a aVar : this.f168a.j) {
                aVar.f174a.show();
            }
            return;
        }
        this.f168a.dismiss();
    }
}
