package androidx.vectordrawable.a.a;

import android.graphics.drawable.Drawable;
/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
class c implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1003a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f1003a = dVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        this.f1003a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f1003a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f1003a.unscheduleSelf(runnable);
    }
}
