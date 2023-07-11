package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public class f implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(i iVar) {
        this.f169a = iVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f169a.z;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f169a.z = view.getViewTreeObserver();
            }
            i iVar = this.f169a;
            iVar.z.removeGlobalOnLayoutListener(iVar.k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
