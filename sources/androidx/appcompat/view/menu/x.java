package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* compiled from: MenuWrapperFactory.java */
/* loaded from: classes.dex */
public final class x {
    public static Menu a(Context context, androidx.core.b.a.a aVar) {
        return new y(context, aVar);
    }

    public static MenuItem a(Context context, androidx.core.b.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new r(context, bVar);
        }
        return new q(context, bVar);
    }

    public static SubMenu a(Context context, androidx.core.b.a.c cVar) {
        return new E(context, cVar);
    }
}
