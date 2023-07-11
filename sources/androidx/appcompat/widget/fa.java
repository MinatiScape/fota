package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class fa extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f322a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<fa>> f323b;
    private final Resources c;
    private final Resources.Theme d;

    private fa(Context context) {
        super(context);
        if (va.b()) {
            this.c = new va(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.c = new ha(this, context.getResources());
        this.d = null;
    }

    public static Context a(Context context) {
        if (b(context)) {
            synchronized (f322a) {
                if (f323b == null) {
                    f323b = new ArrayList<>();
                } else {
                    for (int size = f323b.size() - 1; size >= 0; size--) {
                        WeakReference<fa> weakReference = f323b.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f323b.remove(size);
                        }
                    }
                    for (int size2 = f323b.size() - 1; size2 >= 0; size2--) {
                        WeakReference<fa> weakReference2 = f323b.get(size2);
                        fa faVar = weakReference2 != null ? weakReference2.get() : null;
                        if (faVar != null && faVar.getBaseContext() == context) {
                            return faVar;
                        }
                    }
                }
                fa faVar2 = new fa(context);
                f323b.add(new WeakReference<>(faVar2));
                return faVar2;
            }
        }
        return context;
    }

    private static boolean b(Context context) {
        if ((context instanceof fa) || (context.getResources() instanceof ha) || (context.getResources() instanceof va)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || va.b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
