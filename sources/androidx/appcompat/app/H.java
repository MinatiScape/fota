package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
class H extends androidx.core.h.B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f87a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(K k) {
        this.f87a = k;
    }

    @Override // androidx.core.h.A
    public void b(View view) {
        View view2;
        K k = this.f87a;
        if (k.w && (view2 = k.k) != null) {
            view2.setTranslationY(0.0f);
            this.f87a.h.setTranslationY(0.0f);
        }
        this.f87a.h.setVisibility(8);
        this.f87a.h.setTransitioning(false);
        K k2 = this.f87a;
        k2.B = null;
        k2.h();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f87a.g;
        if (actionBarOverlayLayout != null) {
            androidx.core.h.t.D(actionBarOverlayLayout);
        }
    }
}
