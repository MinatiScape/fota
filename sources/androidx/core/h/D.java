package androidx.core.h;

import android.os.Build;
import android.view.WindowInsets;
/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class D {

    /* renamed from: a  reason: collision with root package name */
    private final Object f511a;

    private D(Object obj) {
        this.f511a = obj;
    }

    public D a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new D(((WindowInsets) this.f511a).consumeSystemWindowInsets());
        }
        return null;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f511a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f511a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f511a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f511a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || D.class != obj.getClass()) {
            return false;
        }
        D d = (D) obj;
        Object obj2 = this.f511a;
        return obj2 == null ? d.f511a == null : obj2.equals(d.f511a);
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f511a).hasSystemWindowInsets();
        }
        return false;
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f511a).isConsumed();
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f511a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public D a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new D(((WindowInsets) this.f511a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static D a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new D(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(D d) {
        if (d == null) {
            return null;
        }
        return d.f511a;
    }
}
