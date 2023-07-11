package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public class B implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(C c) {
        this.f156a = c;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f156a.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f156a.q = view.getViewTreeObserver();
            }
            C c = this.f156a;
            c.q.removeGlobalOnLayoutListener(c.k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
