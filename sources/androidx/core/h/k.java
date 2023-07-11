package androidx.core.h;

import android.view.View;
import android.view.ViewParent;
/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f530a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f531b;
    private final View c;
    private boolean d;
    private int[] e;

    public k(View view) {
        this.c = view;
    }

    private ViewParent d(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f531b;
        }
        return this.f530a;
    }

    public void a(boolean z) {
        if (this.d) {
            t.E(this.c);
        }
        this.d = z;
    }

    public boolean b() {
        return this.d;
    }

    public void c() {
        c(0);
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public void c(int i) {
        ViewParent d = d(i);
        if (d != null) {
            w.a(d, this.c, i);
            a(i, (ViewParent) null);
        }
    }

    public boolean a() {
        return a(0);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (b()) {
            View view = this.c;
            for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
                if (w.b(parent, view, this.c, i, i2)) {
                    a(i2, parent);
                    w.a(parent, view, this.c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent d;
        int i6;
        int i7;
        if (!b() || (d = d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        w.a(d, this.c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent d;
        int i4;
        int i5;
        if (!b() || (d = d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        w.a(d, this.c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent d;
        if (!b() || (d = d(0)) == null) {
            return false;
        }
        return w.a(d, this.c, f, f2, z);
    }

    public boolean a(float f, float f2) {
        ViewParent d;
        if (!b() || (d = d(0)) == null) {
            return false;
        }
        return w.a(d, this.c, f, f2);
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f530a = viewParent;
        } else if (i != 1) {
        } else {
            this.f531b = viewParent;
        }
    }
}
