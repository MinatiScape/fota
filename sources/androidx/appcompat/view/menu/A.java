package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public class A implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(C c) {
        this.f155a = c;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f155a.isShowing() || this.f155a.j.h()) {
            return;
        }
        View view = this.f155a.o;
        if (view != null && view.isShown()) {
            this.f155a.j.show();
        } else {
            this.f155a.dismiss();
        }
    }
}
