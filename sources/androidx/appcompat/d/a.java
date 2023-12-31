package androidx.appcompat.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;
/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f137a;

    private a(Context context) {
        this.f137a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int b() {
        return this.f137a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.f137a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i <= 960 || i2 <= 720) {
            if (i <= 720 || i2 <= 960) {
                if (i < 500) {
                    if (i <= 640 || i2 <= 480) {
                        if (i <= 480 || i2 <= 640) {
                            return i >= 360 ? 3 : 2;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 4;
            }
            return 5;
        }
        return 5;
    }

    public int d() {
        return this.f137a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.f137a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
        Resources resources = this.f137a.getResources();
        if (!f()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.f137a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f137a).hasPermanentMenuKey();
    }

    public boolean a() {
        return this.f137a.getApplicationInfo().targetSdkVersion < 14;
    }
}
