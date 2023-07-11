package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GhostViewApi14.java */
/* loaded from: classes.dex */
public class A implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B f896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(B b2) {
        this.f896a = b2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view;
        B b2 = this.f896a;
        b2.g = b2.f901a.getMatrix();
        androidx.core.h.t.C(this.f896a);
        B b3 = this.f896a;
        ViewGroup viewGroup = b3.f902b;
        if (viewGroup == null || (view = b3.c) == null) {
            return true;
        }
        viewGroup.endViewTransition(view);
        androidx.core.h.t.C(this.f896a.f902b);
        B b4 = this.f896a;
        b4.f902b = null;
        b4.c = null;
        return true;
    }
}
