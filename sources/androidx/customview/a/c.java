package androidx.customview.a;

import a.b.j;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.h.C0067a;
import androidx.core.h.t;
import androidx.core.h.w;
import androidx.customview.a.d;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class c extends C0067a {
    private static final Rect c = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final d.a<androidx.core.h.a.c> d = new androidx.customview.a.a();
    private static final d.b<j<androidx.core.h.a.c>, androidx.core.h.a.c> e = new b();
    private final AccessibilityManager j;
    private final View k;
    private a l;
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final int[] i = new int[2];
    int m = Integer.MIN_VALUE;
    int n = Integer.MIN_VALUE;
    private int o = Integer.MIN_VALUE;

    public c(View view) {
        if (view != null) {
            this.k = view;
            this.j = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (t.i(view) == 0) {
                t.d(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean b(int i, Rect rect) {
        androidx.core.h.a.c cVar;
        j<androidx.core.h.a.c> d2 = d();
        int i2 = this.n;
        androidx.core.h.a.c b2 = i2 == Integer.MIN_VALUE ? null : d2.b(i2);
        if (i == 1 || i == 2) {
            cVar = (androidx.core.h.a.c) d.a(d2, e, d, b2, i, t.k(this.k) == 1, false);
        } else if (i != 17 && i != 33 && i != 66 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            Rect rect2 = new Rect();
            int i3 = this.n;
            if (i3 != Integer.MIN_VALUE) {
                a(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.k, i, rect2);
            }
            cVar = (androidx.core.h.a.c) d.a(d2, e, d, b2, rect2, i);
        }
        return c(cVar != null ? d2.d(d2.a((j<androidx.core.h.a.c>) cVar)) : Integer.MIN_VALUE);
    }

    private AccessibilityEvent c(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        androidx.core.h.a.c b2 = b(i);
        obtain.getText().add(b2.h());
        obtain.setContentDescription(b2.d());
        obtain.setScrollable(b2.s());
        obtain.setPassword(b2.r());
        obtain.setEnabled(b2.n());
        obtain.setChecked(b2.l());
        a(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(b2.c());
        androidx.core.h.a.e.a(obtain, this.k, i);
        obtain.setPackageName(this.k.getContext().getPackageName());
        return obtain;
    }

    private j<androidx.core.h.a.c> d() {
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        j<androidx.core.h.a.c> jVar = new j<>();
        for (int i = 0; i < arrayList.size(); i++) {
            jVar.c(i, f(i));
        }
        return jVar;
    }

    private AccessibilityEvent e(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.k.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private androidx.core.h.a.c f(int i) {
        androidx.core.h.a.c v = androidx.core.h.a.c.v();
        v.g(true);
        v.h(true);
        v.a("android.view.View");
        v.c(c);
        v.d(c);
        v.c(this.k);
        a(i, v);
        if (v.h() == null && v.d() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        v.a(this.g);
        if (!this.g.equals(c)) {
            int a2 = v.a();
            if ((a2 & 64) == 0) {
                if ((a2 & CpioConstants.C_IWUSR) == 0) {
                    v.e(this.k.getContext().getPackageName());
                    v.c(this.k, i);
                    if (this.m == i) {
                        v.a(true);
                        v.a(CpioConstants.C_IWUSR);
                    } else {
                        v.a(false);
                        v.a(64);
                    }
                    boolean z = this.n == i;
                    if (z) {
                        v.a(2);
                    } else if (v.o()) {
                        v.a(1);
                    }
                    v.i(z);
                    this.k.getLocationOnScreen(this.i);
                    v.b(this.f);
                    if (this.f.equals(c)) {
                        v.a(this.f);
                        if (v.f517b != -1) {
                            androidx.core.h.a.c v2 = androidx.core.h.a.c.v();
                            for (int i2 = v.f517b; i2 != -1; i2 = v2.f517b) {
                                v2.b(this.k, -1);
                                v2.c(c);
                                a(i2, v2);
                                v2.a(this.g);
                                Rect rect = this.f;
                                Rect rect2 = this.g;
                                rect.offset(rect2.left, rect2.top);
                            }
                            v2.w();
                        }
                        this.f.offset(this.i[0] - this.k.getScrollX(), this.i[1] - this.k.getScrollY());
                    }
                    if (this.k.getLocalVisibleRect(this.h)) {
                        this.h.offset(this.i[0] - this.k.getScrollX(), this.i[1] - this.k.getScrollY());
                        if (this.f.intersect(this.h)) {
                            v.d(this.f);
                            if (a(this.f)) {
                                v.n(true);
                            }
                        }
                    }
                    return v;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private static int g(int i) {
        if (i != 19) {
            if (i != 21) {
                return i != 22 ? 130 : 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean h(int i) {
        int i2;
        if (this.j.isEnabled() && this.j.isTouchExplorationEnabled() && (i2 = this.m) != i) {
            if (i2 != Integer.MIN_VALUE) {
                d(i2);
            }
            this.m = i;
            this.k.invalidate();
            a(i, 32768);
            return true;
        }
        return false;
    }

    private void i(int i) {
        int i2 = this.o;
        if (i2 == i) {
            return;
        }
        this.o = i;
        a(i, CpioConstants.C_IWUSR);
        a(i2, CpioConstants.C_IRUSR);
    }

    protected abstract int a(float f, float f2);

    @Override // androidx.core.h.C0067a
    public androidx.core.h.a.d a(View view) {
        if (this.l == null) {
            this.l = new a();
        }
        return this.l;
    }

    protected void a(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void a(int i, androidx.core.h.a.c cVar);

    protected void a(int i, boolean z) {
    }

    protected void a(AccessibilityEvent accessibilityEvent) {
    }

    protected void a(androidx.core.h.a.c cVar) {
    }

    protected abstract void a(List<Integer> list);

    protected abstract boolean a(int i, int i2, Bundle bundle);

    /* compiled from: ExploreByTouchHelper.java */
    /* loaded from: classes.dex */
    private class a extends androidx.core.h.a.d {
        a() {
        }

        @Override // androidx.core.h.a.d
        public androidx.core.h.a.c a(int i) {
            return androidx.core.h.a.c.a(c.this.b(i));
        }

        @Override // androidx.core.h.a.d
        public androidx.core.h.a.c b(int i) {
            int i2 = i == 2 ? c.this.m : c.this.n;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        @Override // androidx.core.h.a.d
        public boolean a(int i, int i2, Bundle bundle) {
            return c.this.b(i, i2, bundle);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.j.isEnabled() && this.j.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action == 10 && this.o != Integer.MIN_VALUE) {
                    i(Integer.MIN_VALUE);
                    return true;
                }
                return false;
            }
            int a2 = a(motionEvent.getX(), motionEvent.getY());
            i(a2);
            return a2 != Integer.MIN_VALUE;
        }
        return false;
    }

    private boolean d(int i) {
        if (this.m == i) {
            this.m = Integer.MIN_VALUE;
            this.k.invalidate();
            a(i, 65536);
            return true;
        }
        return false;
    }

    public final boolean a(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int g = g(keyCode);
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z = false;
                                while (i < repeatCount && b(g, (Rect) null)) {
                                    i++;
                                    z = true;
                                }
                                return z;
                            }
                            return false;
                        case 23:
                            break;
                        default:
                            return false;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    b();
                    return true;
                }
                return false;
            } else if (keyEvent.hasNoModifiers()) {
                return b(2, (Rect) null);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return b(1, (Rect) null);
                }
                return false;
            }
        }
        return false;
    }

    private androidx.core.h.a.c c() {
        androidx.core.h.a.c b2 = androidx.core.h.a.c.b(this.k);
        t.a(this.k, b2);
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        if (b2.b() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b2.a(this.k, ((Integer) arrayList.get(i)).intValue());
        }
        return b2;
    }

    private boolean b() {
        int i = this.n;
        return i != Integer.MIN_VALUE && a(i, 16, (Bundle) null);
    }

    private AccessibilityEvent b(int i, int i2) {
        if (i != -1) {
            return c(i, i2);
        }
        return e(i2);
    }

    @Override // androidx.core.h.C0067a
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    androidx.core.h.a.c b(int i) {
        if (i == -1) {
            return c();
        }
        return f(i);
    }

    public final void a(boolean z, int i, Rect rect) {
        int i2 = this.n;
        if (i2 != Integer.MIN_VALUE) {
            a(i2);
        }
        if (z) {
            b(i, rect);
        }
    }

    private boolean c(int i, int i2, Bundle bundle) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 64) {
                    if (i2 != 128) {
                        return a(i, i2, bundle);
                    }
                    return d(i);
                }
                return h(i);
            }
            return a(i);
        }
        return c(i);
    }

    boolean b(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return c(i, i2, bundle);
        }
        return a(i2, bundle);
    }

    private void a(int i, Rect rect) {
        b(i).a(rect);
    }

    private static Rect a(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    public final boolean c(int i) {
        int i2;
        if ((this.k.isFocused() || this.k.requestFocus()) && (i2 = this.n) != i) {
            if (i2 != Integer.MIN_VALUE) {
                a(i2);
            }
            this.n = i;
            a(i, true);
            a(i, 8);
            return true;
        }
        return false;
    }

    public final boolean a(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.j.isEnabled() || (parent = this.k.getParent()) == null) {
            return false;
        }
        return w.a(parent, this.k, b(i, i2));
    }

    @Override // androidx.core.h.C0067a
    public void a(View view, androidx.core.h.a.c cVar) {
        super.a(view, cVar);
        a(cVar);
    }

    private boolean a(int i, Bundle bundle) {
        return t.a(this.k, i, bundle);
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.k.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.k.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public final boolean a(int i) {
        if (this.n != i) {
            return false;
        }
        this.n = Integer.MIN_VALUE;
        a(i, false);
        a(i, 8);
        return true;
    }
}
