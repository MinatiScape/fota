package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.v;
import androidx.core.h.C0069c;
/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class u implements n {

    /* renamed from: a  reason: collision with root package name */
    private final Context f194a;

    /* renamed from: b  reason: collision with root package name */
    private final l f195b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private v.a i;
    private s j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public u(Context context, l lVar, View view, boolean z, int i) {
        this(context, lVar, view, z, i, 0);
    }

    private s g() {
        s c;
        Display defaultDisplay = ((WindowManager) this.f194a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f194a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width)) {
            c = new i(this.f194a, this.f, this.d, this.e, this.c);
        } else {
            c = new C(this.f194a, this.f195b, this.f, this.d, this.e, this.c);
        }
        c.a(this.f195b);
        c.setOnDismissListener(this.l);
        c.a(this.f);
        c.a(this.i);
        c.a(this.h);
        c.a(this.g);
        return c;
    }

    public void a(View view) {
        this.f = view;
    }

    public s b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        s sVar = this.j;
        return sVar != null && sVar.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void e() {
        if (!f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean f() {
        if (c()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public u(Context context, l lVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new t(this);
        this.f194a = context;
        this.f195b = lVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public void a(boolean z) {
        this.h = z;
        s sVar = this.j;
        if (sVar != null) {
            sVar.a(z);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public boolean a(int i, int i2) {
        if (c()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        s b2 = b();
        b2.b(z2);
        if (z) {
            if ((C0069c.a(this.g, androidx.core.h.t.k(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            b2.b(i);
            b2.c(i2);
            int i3 = (int) ((this.f194a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b2.a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        b2.show();
    }

    public void a() {
        if (c()) {
            this.j.dismiss();
        }
    }

    public void a(v.a aVar) {
        this.i = aVar;
        s sVar = this.j;
        if (sVar != null) {
            sVar.a(aVar);
        }
    }
}
