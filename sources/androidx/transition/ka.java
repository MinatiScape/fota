package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class ka implements la {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ka(ViewGroup viewGroup) {
        this.f971a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.sa
    public void a(Drawable drawable) {
        this.f971a.add(drawable);
    }

    @Override // androidx.transition.sa
    public void b(Drawable drawable) {
        this.f971a.remove(drawable);
    }

    @Override // androidx.transition.la
    public void a(View view) {
        this.f971a.add(view);
    }

    @Override // androidx.transition.la
    public void b(View view) {
        this.f971a.remove(view);
    }
}
