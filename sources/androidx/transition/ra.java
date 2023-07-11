package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
class ra implements sa {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f984a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ra(View view) {
        this.f984a = view.getOverlay();
    }

    @Override // androidx.transition.sa
    public void a(Drawable drawable) {
        this.f984a.add(drawable);
    }

    @Override // androidx.transition.sa
    public void b(Drawable drawable) {
        this.f984a.remove(drawable);
    }
}
