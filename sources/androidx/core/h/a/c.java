package androidx.core.h.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f516a;

    /* renamed from: b  reason: collision with root package name */
    public int f517b = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;

        /* renamed from: a  reason: collision with root package name */
        public static final a f518a = new a(1, null);

        /* renamed from: b  reason: collision with root package name */
        public static final a f519b = new a(2, null);
        public static final a c = new a(4, null);
        public static final a d = new a(8, null);
        public static final a e = new a(16, null);
        public static final a f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(CpioConstants.C_IWUSR, null);
        public static final a i = new a(CpioConstants.C_IRUSR, null);
        public static final a j = new a(512, null);
        public static final a k = new a(1024, null);
        public static final a l = new a(2048, null);
        public static final a m = new a(CpioConstants.C_ISFIFO, null);
        public static final a n = new a(CpioConstants.C_ISCHR, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, null);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object H;

        static {
            w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null);
            x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
            y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null);
            z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null);
            A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null);
            B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null);
            C = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null);
            D = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null);
            E = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null);
            F = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null);
            G = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null);
        }

        public a(int i2, CharSequence charSequence) {
            this(Build.VERSION.SDK_INT >= 21 ? new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence) : null);
        }

        a(Object obj) {
            this.H = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f520a;

        b(Object obj) {
            this.f520a = obj;
        }

        public static b a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (i4 >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b(null);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: androidx.core.h.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014c {

        /* renamed from: a  reason: collision with root package name */
        final Object f521a;

        C0014c(Object obj) {
            this.f521a = obj;
        }

        public static C0014c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new C0014c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (i5 >= 19) {
                return new C0014c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0014c(null);
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f516a = accessibilityNodeInfo;
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c b(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    private static String c(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case CpioConstants.C_IWUSR /* 128 */:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case CpioConstants.C_IRUSR /* 256 */:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case CpioConstants.C_ISFIFO /* 4096 */:
                        return "ACTION_SCROLL_FORWARD";
                    case CpioConstants.C_ISCHR /* 8192 */:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    default:
                        return "ACTION_UNKNOWN";
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static c v() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public void c(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f516a.setSource(view, i);
        }
    }

    public void d(View view) {
        this.f516a.setSource(view);
    }

    public void e(boolean z) {
        this.f516a.setClickable(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f516a;
            if (accessibilityNodeInfo == null) {
                if (cVar.f516a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(cVar.f516a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int f() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f516a.getMovementGranularities();
        }
        return 0;
    }

    public void g(boolean z) {
        this.f516a.setEnabled(z);
    }

    public void h(boolean z) {
        this.f516a.setFocusable(z);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f516a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i(boolean z) {
        this.f516a.setFocused(z);
    }

    public boolean j() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f516a.isAccessibilityFocused();
        }
        return false;
    }

    public boolean k() {
        return this.f516a.isCheckable();
    }

    public boolean l() {
        return this.f516a.isChecked();
    }

    public boolean m() {
        return this.f516a.isClickable();
    }

    public void n(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f516a.setVisibleToUser(z);
        }
    }

    public boolean o() {
        return this.f516a.isFocusable();
    }

    public boolean p() {
        return this.f516a.isFocused();
    }

    public boolean q() {
        return this.f516a.isLongClickable();
    }

    public boolean r() {
        return this.f516a.isPassword();
    }

    public boolean s() {
        return this.f516a.isScrollable();
    }

    public boolean t() {
        return this.f516a.isSelected();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(g());
        sb.append("; className: ");
        sb.append(c());
        sb.append("; text: ");
        sb.append(h());
        sb.append("; contentDescription: ");
        sb.append(d());
        sb.append("; viewId: ");
        sb.append(i());
        sb.append("; checkable: ");
        sb.append(k());
        sb.append("; checked: ");
        sb.append(l());
        sb.append("; focusable: ");
        sb.append(o());
        sb.append("; focused: ");
        sb.append(p());
        sb.append("; selected: ");
        sb.append(t());
        sb.append("; clickable: ");
        sb.append(m());
        sb.append("; longClickable: ");
        sb.append(q());
        sb.append("; enabled: ");
        sb.append(n());
        sb.append("; password: ");
        sb.append(r());
        sb.append("; scrollable: " + s());
        sb.append("; [");
        int a2 = a();
        while (a2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a2);
            a2 &= numberOfTrailingZeros ^ (-1);
            sb.append(c(numberOfTrailingZeros));
            if (a2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean u() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f516a.isVisibleToUser();
        }
        return false;
    }

    public void w() {
        this.f516a.recycle();
    }

    public AccessibilityNodeInfo x() {
        return this.f516a;
    }

    public static c a(c cVar) {
        return a(AccessibilityNodeInfo.obtain(cVar.f516a));
    }

    public int b() {
        return this.f516a.getChildCount();
    }

    public void d(Rect rect) {
        this.f516a.setBoundsInScreen(rect);
    }

    public void e(CharSequence charSequence) {
        this.f516a.setPackageName(charSequence);
    }

    public CharSequence g() {
        return this.f516a.getPackageName();
    }

    public CharSequence h() {
        return this.f516a.getText();
    }

    public String i() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f516a.getViewIdResourceName();
        }
        return null;
    }

    public void k(boolean z) {
        this.f516a.setScrollable(z);
    }

    public void l(boolean z) {
        this.f516a.setSelected(z);
    }

    public void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f516a.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void a(View view) {
        this.f516a.addChild(view);
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f516a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.H);
        }
        return false;
    }

    public void c(View view) {
        this.f516a.setParent(view);
    }

    public void d(boolean z) {
        this.f516a.setChecked(z);
    }

    public Bundle e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f516a.getExtras();
        }
        return new Bundle();
    }

    public void f(CharSequence charSequence) {
        this.f516a.setText(charSequence);
    }

    public void j(boolean z) {
        this.f516a.setLongClickable(z);
    }

    public boolean n() {
        return this.f516a.isEnabled();
    }

    public void a(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f516a.addChild(view, i);
        }
    }

    public void c(Rect rect) {
        this.f516a.setBoundsInParent(rect);
    }

    public CharSequence d() {
        return this.f516a.getContentDescription();
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f516a.setContentInvalid(z);
        }
    }

    public void b(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f516a.setMovementGranularities(i);
        }
    }

    public void c(boolean z) {
        this.f516a.setCheckable(z);
    }

    public void d(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f516a.setHintText(charSequence);
        } else if (i >= 19) {
            this.f516a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public int a() {
        return this.f516a.getActions();
    }

    public CharSequence c() {
        return this.f516a.getClassName();
    }

    public void a(int i) {
        this.f516a.addAction(i);
    }

    public void b(View view, int i) {
        this.f517b = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f516a.setParent(view, i);
        }
    }

    public void c(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f516a.setError(charSequence);
        }
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f516a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.H);
        }
    }

    public void a(Rect rect) {
        this.f516a.getBoundsInParent(rect);
    }

    public void b(Rect rect) {
        this.f516a.getBoundsInScreen(rect);
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f516a.setAccessibilityFocused(z);
        }
    }

    public void b(CharSequence charSequence) {
        this.f516a.setContentDescription(charSequence);
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f516a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0014c) obj).f521a);
        }
    }

    public void a(CharSequence charSequence) {
        this.f516a.setClassName(charSequence);
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f516a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f520a);
        }
    }

    public void b(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f516a.setCanOpenPopup(z);
        }
    }

    private void a(int i, boolean z) {
        Bundle e = e();
        if (e != null) {
            int i2 = e.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ (-1));
            if (!z) {
                i = 0;
            }
            e.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
