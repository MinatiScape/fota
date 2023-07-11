package androidx.core.h;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    private static Field f537b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static Field h;
    private static ThreadLocal<Rect> j;

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f536a = new AtomicInteger(1);
    private static WeakHashMap<View, z> g = null;
    private static boolean i = false;

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof j) {
            return ((j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean B(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void C(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void D(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static void E(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof j) {
            ((j) view).stopNestedScroll();
        }
    }

    private static void F(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    private static Rect a() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void b(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void c(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static void d(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void e(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static void f(View view, int i2) {
        if (view instanceof i) {
            ((i) view).a(i2);
        } else if (i2 == 0) {
            E(view);
        }
    }

    public static float g(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static boolean h(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int i(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                d = View.class.getDeclaredField("mMinHeight");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            e = true;
        }
        Field field = d;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                f537b = View.class.getDeclaredField("mMinWidth");
                f537b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            c = true;
        }
        Field field = f537b;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static ViewParent p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    public static String q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static float r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static int s(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean u(View view) {
        if (i) {
            return false;
        }
        if (h == null) {
            try {
                h = View.class.getDeclaredField("mAccessibilityDelegate");
                h.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return false;
            }
        }
        try {
            return h.get(view) != null;
        } catch (Throwable unused2) {
            i = true;
            return false;
        }
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean w(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean z(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f538a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f539b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        b() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f539b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b2 = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b2 != null) {
                            return b2;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((a) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        static b a(View view) {
            b bVar = (b) view.getTag(R$id.tag_unhandled_key_event_manager);
            if (bVar == null) {
                b bVar2 = new b();
                view.setTag(R$id.tag_unhandled_key_event_manager, bVar2);
                return bVar2;
            }
            return bVar;
        }

        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f539b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f538a.isEmpty()) {
                return;
            }
            synchronized (f538a) {
                if (this.f539b == null) {
                    this.f539b = new WeakHashMap<>();
                }
                for (int size = f538a.size() - 1; size >= 0; size--) {
                    View view = f538a.get(size).get();
                    if (view == null) {
                        f538a.remove(size);
                    } else {
                        this.f539b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f539b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b2 = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b2));
                }
            }
            return b2 != null;
        }

        boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.d;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.d = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> a2 = a();
                if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = a2.valueAt(indexOfKey);
                    a2.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = a2.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && t.y(view)) {
                        c(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static int b(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static ColorStateList c(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof r) {
            return ((r) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static Rect e(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    private static void g(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            F(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                F((View) parent);
            }
        }
    }

    private static void h(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            F(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                F((View) parent);
            }
        }
    }

    public static PorterDuff.Mode d(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof r) {
            return ((r) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static Display f(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (y(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static void a(View view, androidx.core.h.a.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.x());
    }

    public static void a(View view, C0067a c0067a) {
        view.setAccessibilityDelegate(c0067a == null ? null : c0067a.a());
    }

    public static void b(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static D b(View view, D d2) {
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets windowInsets = (WindowInsets) D.a(d2);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (onApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(onApplyWindowInsets);
            }
            return D.a(windowInsets);
        }
        return d2;
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static void b(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (i3 >= 21) {
            Rect a2 = a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            h(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
            }
        } else {
            h(view, i2);
        }
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static z a(View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        z zVar = g.get(view);
        if (zVar == null) {
            z zVar2 = new z(view);
            g.put(view, zVar2);
            return zVar2;
        }
        return zVar;
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return b.a(view).a(keyEvent);
    }

    @Deprecated
    public static void a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, o oVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (oVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new s(oVar));
            }
        }
    }

    public static D a(View view, D d2) {
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets windowInsets = (WindowInsets) D.a(d2);
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (dispatchApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(dispatchApplyWindowInsets);
            }
            return D.a(windowInsets);
        }
        return d2;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof r) {
            ((r) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof r) {
            ((r) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (i3 >= 21) {
            Rect a2 = a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            g(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
            }
        } else {
            g(view, i2);
        }
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, p pVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pVar != null ? pVar.a() : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return b.a(view).a(view, keyEvent);
    }
}
