package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* compiled from: TintResources.java */
/* loaded from: classes.dex */
class ha extends L {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f326b;

    public ha(Context context, Resources resources) {
        super(resources);
        this.f326b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.L, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f326b.get();
        if (drawable != null && context != null) {
            C0058q.a();
            C0058q.a(context, i, drawable);
        }
        return drawable;
    }
}
