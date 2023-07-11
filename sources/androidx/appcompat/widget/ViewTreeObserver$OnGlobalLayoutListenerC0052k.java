package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.core.h.AbstractC0068b;
/* compiled from: ActivityChooserView.java */
/* renamed from: androidx.appcompat.widget.k  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ViewTreeObserver$OnGlobalLayoutListenerC0052k implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC0052k(ActivityChooserView activityChooserView) {
        this.f338a = activityChooserView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f338a.b()) {
            if (!this.f338a.isShown()) {
                this.f338a.getListPopupWindow().dismiss();
                return;
            }
            this.f338a.getListPopupWindow().show();
            AbstractC0068b abstractC0068b = this.f338a.j;
            if (abstractC0068b != null) {
                abstractC0068b.a(true);
            }
        }
    }
}
