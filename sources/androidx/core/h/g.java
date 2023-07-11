package androidx.core.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
/* compiled from: MenuItemCompat.java */
/* loaded from: classes.dex */
public final class g {
    public static MenuItem a(MenuItem menuItem, AbstractC0068b abstractC0068b) {
        if (menuItem instanceof androidx.core.b.a.b) {
            return ((androidx.core.b.a.b) menuItem).a(abstractC0068b);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).b(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    public static void a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).a(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).b(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    public static void a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).a(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    public static void a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).a(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof androidx.core.b.a.b) {
            ((androidx.core.b.a.b) menuItem).a(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
