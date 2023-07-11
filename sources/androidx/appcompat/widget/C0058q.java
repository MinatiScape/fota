package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$drawable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AppCompatDrawableManager.java */
/* renamed from: androidx.appcompat.widget.q  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0058q {

    /* renamed from: b  reason: collision with root package name */
    private static C0058q f354b;
    private WeakHashMap<Context, a.b.j<ColorStateList>> j;
    private a.b.b<String, d> k;
    private a.b.j<String> l;
    private final WeakHashMap<Context, a.b.f<WeakReference<Drawable.ConstantState>>> m = new WeakHashMap<>(0);
    private TypedValue n;
    private boolean o;

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f353a = PorterDuff.Mode.SRC_IN;
    private static final c c = new c(6);
    private static final int[] d = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl_dark, R$drawable.abc_text_select_handle_middle_mtrl_dark, R$drawable.abc_text_select_handle_right_mtrl_dark, R$drawable.abc_text_select_handle_left_mtrl_light, R$drawable.abc_text_select_handle_middle_mtrl_light, R$drawable.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};
    private static final int[] i = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: androidx.appcompat.widget.q$a */
    /* loaded from: classes.dex */
    public static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.C0058q.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: androidx.appcompat.widget.q$b */
    /* loaded from: classes.dex */
    public static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.C0058q.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.a.a.d.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: androidx.appcompat.widget.q$c */
    /* loaded from: classes.dex */
    public static class c extends a.b.g<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return b(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((c) Integer.valueOf(b(i, mode)), (Integer) porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: androidx.appcompat.widget.q$d */
    /* loaded from: classes.dex */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: androidx.appcompat.widget.q$e */
    /* loaded from: classes.dex */
    public static class e implements d {
        e() {
        }

        @Override // androidx.appcompat.widget.C0058q.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.a.a.k.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static synchronized C0058q a() {
        C0058q c0058q;
        synchronized (C0058q.class) {
            if (f354b == null) {
                f354b = new C0058q();
                a(f354b);
            }
            c0058q = f354b;
        }
        return c0058q;
    }

    private ColorStateList c(Context context) {
        return c(context, 0);
    }

    private Drawable d(Context context, int i2) {
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == R$drawable.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a(context, R$drawable.abc_cab_background_internal_bg), a(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    private ColorStateList e(Context context, int i2) {
        a.b.j<ColorStateList> jVar;
        WeakHashMap<Context, a.b.j<ColorStateList>> weakHashMap = this.j;
        if (weakHashMap == null || (jVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return jVar.b(i2);
    }

    private Drawable f(Context context, int i2) {
        int next;
        a.b.b<String, d> bVar = this.k;
        if (bVar == null || bVar.isEmpty()) {
            return null;
        }
        a.b.j<String> jVar = this.l;
        if (jVar != null) {
            String b2 = jVar.b(i2);
            if ("appcompat_skip_skip".equals(b2) || (b2 != null && this.k.get(b2) == null)) {
                return null;
            }
        } else {
            this.l = new a.b.j<>();
        }
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.l.a(i2, name);
                    d dVar = this.k.get(name);
                    if (dVar != null) {
                        a3 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (a3 != null) {
                        a3.setChangingConfigurations(typedValue.changingConfigurations);
                        a(context, a2, a3);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (a3 == null) {
            this.l.a(i2, "appcompat_skip_skip");
        }
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i2) {
        ColorStateList e2;
        e2 = e(context, i2);
        if (e2 == null) {
            if (i2 == R$drawable.abc_edit_text_material) {
                e2 = androidx.appcompat.a.a.a.a(context, R$color.abc_tint_edittext);
            } else if (i2 == R$drawable.abc_switch_track_mtrl_alpha) {
                e2 = androidx.appcompat.a.a.a.a(context, R$color.abc_tint_switch_track);
            } else if (i2 == R$drawable.abc_switch_thumb_material) {
                e2 = f(context);
            } else if (i2 == R$drawable.abc_btn_default_mtrl_shape) {
                e2 = e(context);
            } else if (i2 == R$drawable.abc_btn_borderless_material) {
                e2 = c(context);
            } else if (i2 == R$drawable.abc_btn_colored_material) {
                e2 = d(context);
            } else {
                if (i2 != R$drawable.abc_spinner_mtrl_am_alpha && i2 != R$drawable.abc_spinner_textfield_background_material) {
                    if (a(e, i2)) {
                        e2 = da.c(context, R$attr.colorControlNormal);
                    } else if (a(h, i2)) {
                        e2 = androidx.appcompat.a.a.a.a(context, R$color.abc_tint_default);
                    } else if (a(i, i2)) {
                        e2 = androidx.appcompat.a.a.a.a(context, R$color.abc_tint_btn_checkable);
                    } else if (i2 == R$drawable.abc_seekbar_thumb_material) {
                        e2 = androidx.appcompat.a.a.a.a(context, R$color.abc_tint_seek_thumb);
                    }
                }
                e2 = androidx.appcompat.a.a.a.a(context, R$color.abc_tint_spinner);
            }
            if (e2 != null) {
                a(context, i2, e2);
            }
        }
        return e2;
    }

    private ColorStateList c(Context context, int i2) {
        int b2 = da.b(context, R$attr.colorControlHighlight);
        return new ColorStateList(new int[][]{da.f319b, da.e, da.c, da.i}, new int[]{da.a(context, R$attr.colorButtonNormal), androidx.core.a.a.a(b2, i2), androidx.core.a.a.a(b2, i2), i2});
    }

    private ColorStateList e(Context context) {
        return c(context, da.b(context, R$attr.colorButtonNormal));
    }

    private static void a(C0058q c0058q) {
        if (Build.VERSION.SDK_INT < 24) {
            c0058q.a("vector", new e());
            c0058q.a("animated-vector", new b());
            c0058q.a("animated-selector", new a());
        }
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable f2;
        b(context);
        f2 = f(context, i2);
        if (f2 == null) {
            f2 = d(context, i2);
        }
        if (f2 == null) {
            f2 = androidx.core.content.a.c(context, i2);
        }
        if (f2 != null) {
            f2 = a(context, i2, z, f2);
        }
        if (f2 != null) {
            E.b(f2);
        }
        return f2;
    }

    private ColorStateList d(Context context) {
        return c(context, da.b(context, R$attr.colorAccent));
    }

    public synchronized void a(Context context) {
        a.b.f<WeakReference<Drawable.ConstantState>> fVar = this.m.get(context);
        if (fVar != null) {
            fVar.a();
        }
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (E.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable i3 = androidx.core.graphics.drawable.a.i(drawable);
            androidx.core.graphics.drawable.a.a(i3, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 != null) {
                androidx.core.graphics.drawable.a.a(i3, a2);
                return i3;
            }
            return i3;
        } else if (i2 == R$drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), da.b(context, R$attr.colorControlNormal), f353a);
            a(layerDrawable.findDrawableByLayerId(16908303), da.b(context, R$attr.colorControlNormal), f353a);
            a(layerDrawable.findDrawableByLayerId(16908301), da.b(context, R$attr.colorControlActivated), f353a);
            return drawable;
        } else if (i2 != R$drawable.abc_ratingbar_material && i2 != R$drawable.abc_ratingbar_indicator_material && i2 != R$drawable.abc_ratingbar_small_material) {
            if (a(context, i2, drawable) || !z) {
                return drawable;
            }
            return null;
        } else {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(16908288), da.a(context, R$attr.colorControlNormal), f353a);
            a(layerDrawable2.findDrawableByLayerId(16908303), da.b(context, R$attr.colorControlActivated), f353a);
            a(layerDrawable2.findDrawableByLayerId(16908301), da.b(context, R$attr.colorControlActivated), f353a);
            return drawable;
        }
    }

    private void b(Context context) {
        if (this.o) {
            return;
        }
        this.o = true;
        Drawable a2 = a(context, R$drawable.abc_vector_test);
        if (a2 == null || !a(a2)) {
            this.o = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private ColorStateList f(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList c2 = da.c(context, R$attr.colorSwitchThumbNormal);
        if (c2 != null && c2.isStateful()) {
            iArr[0] = da.f319b;
            iArr2[0] = c2.getColorForState(iArr[0], 0);
            iArr[1] = da.f;
            iArr2[1] = da.b(context, R$attr.colorControlActivated);
            iArr[2] = da.i;
            iArr2[2] = c2.getDefaultColor();
        } else {
            iArr[0] = da.f319b;
            iArr2[0] = da.a(context, R$attr.colorSwitchThumbNormal);
            iArr[1] = da.f;
            iArr2[1] = da.b(context, R$attr.colorControlActivated);
            iArr[2] = da.i;
            iArr2[2] = da.b(context, R$attr.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    private synchronized Drawable a(Context context, long j) {
        a.b.f<WeakReference<Drawable.ConstantState>> fVar = this.m.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> b2 = fVar.b(j);
        if (b2 != null) {
            Drawable.ConstantState constantState = b2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.a(j);
        }
        return null;
    }

    private synchronized boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            a.b.f<WeakReference<Drawable.ConstantState>> fVar = this.m.get(context);
            if (fVar == null) {
                fVar = new a.b.f<>();
                this.m.put(context, fVar);
            }
            fVar.c(j, new WeakReference<>(constantState));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, va vaVar, int i2) {
        Drawable f2 = f(context, i2);
        if (f2 == null) {
            f2 = vaVar.a(i2);
        }
        if (f2 != null) {
            return a(context, i2, false, f2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0058q.f353a
            int[] r1 = androidx.appcompat.widget.C0058q.d
            boolean r1 = a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = androidx.appcompat.R$attr.colorControlNormal
        L12:
            r7 = 1
            r1 = -1
            goto L44
        L15:
            int[] r1 = androidx.appcompat.widget.C0058q.f
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L20
            int r2 = androidx.appcompat.R$attr.colorControlActivated
            goto L12
        L20:
            int[] r1 = androidx.appcompat.widget.C0058q.g
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L44
        L3c:
            int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
            if (r7 != r1) goto L41
            goto L12
        L41:
            r7 = 0
            r1 = -1
            r2 = 0
        L44:
            if (r7 == 0) goto L61
            boolean r7 = androidx.appcompat.widget.E.a(r8)
            if (r7 == 0) goto L50
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L50:
            int r6 = androidx.appcompat.widget.da.b(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L60
            r8.setAlpha(r1)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0058q.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private void a(String str, d dVar) {
        if (this.k == null) {
            this.k = new a.b.b<>();
        }
        this.k.put(str, dVar);
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == R$drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        a.b.j<ColorStateList> jVar = this.j.get(context);
        if (jVar == null) {
            jVar = new a.b.j<>();
            this.j.put(context, jVar);
        }
        jVar.a(i2, colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, ga gaVar, int[] iArr) {
        if (E.a(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (gaVar.d || gaVar.c) {
            drawable.setColorFilter(a(gaVar.d ? gaVar.f324a : null, gaVar.c ? gaVar.f325b : f353a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (C0058q.class) {
            a2 = c.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                c.a(i2, mode, a2);
            }
        }
        return a2;
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (E.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f353a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.a.a.k) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
