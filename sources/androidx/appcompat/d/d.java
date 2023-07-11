package androidx.appcompat.d;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;
/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f140a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f141b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public d() {
        super(null);
    }

    private Resources a() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.e;
    }

    private void b() {
        boolean z = this.f141b == null;
        if (z) {
            this.f141b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f141b.setTo(theme);
            }
        }
        a(this.f141b, this.f140a, z);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f141b;
        if (theme != null) {
            return theme;
        }
        if (this.f140a == 0) {
            this.f140a = R$style.Theme_AppCompat_Light;
        }
        b();
        return this.f141b;
    }

    public int getThemeResId() {
        return this.f140a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f140a != i) {
            this.f140a = i;
            b();
        }
    }

    public d(Context context, int i) {
        super(context);
        this.f140a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f141b = theme;
    }

    protected void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }
}
