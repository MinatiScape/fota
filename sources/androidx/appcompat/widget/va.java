package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;
/* compiled from: VectorEnabledTintResources.java */
/* loaded from: classes.dex */
public class va extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f365a = false;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f366b;

    public va(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f366b = new WeakReference<>(context);
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.f366b.get();
        if (context != null) {
            return C0058q.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    public static boolean a() {
        return f365a;
    }
}
