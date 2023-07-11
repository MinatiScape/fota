package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.d.b;
import androidx.appcompat.d.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0058q;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ia;
import androidx.appcompat.widget.va;
import androidx.appcompat.widget.wa;
import androidx.core.h.C0070d;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.xmlpull.v1.XmlPullParser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends n implements l.a, LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f56b;
    private static final int[] c;
    private static boolean d;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private PanelFeatureState[] H;
    private PanelFeatureState I;
    private boolean J;
    boolean K;
    private boolean M;
    private e N;
    boolean O;
    int P;
    private boolean R;
    private Rect S;
    private Rect T;
    private AppCompatViewInflater U;
    final Context e;
    final Window f;
    final Window.Callback g;
    final Window.Callback h;
    final m i;
    ActionBar j;
    MenuInflater k;
    private CharSequence l;
    private androidx.appcompat.widget.C m;
    private b n;
    private g o;
    androidx.appcompat.d.b p;
    ActionBarContextView q;
    PopupWindow r;
    Runnable s;
    private boolean v;
    private ViewGroup w;
    private TextView x;
    private View y;
    private boolean z;
    androidx.core.h.z t = null;
    private boolean u = true;
    private int L = -100;
    private final Runnable Q = new p(this);

    /* loaded from: classes.dex */
    private class a implements InterfaceC0026a {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f63a;

        public c(b.a aVar) {
            this.f63a = aVar;
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(androidx.appcompat.d.b bVar, Menu menu) {
            return this.f63a.a(bVar, menu);
        }

        @Override // androidx.appcompat.d.b.a
        public boolean b(androidx.appcompat.d.b bVar, Menu menu) {
            return this.f63a.b(bVar, menu);
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(androidx.appcompat.d.b bVar, MenuItem menuItem) {
            return this.f63a.a(bVar, menuItem);
        }

        @Override // androidx.appcompat.d.b.a
        public void a(androidx.appcompat.d.b bVar) {
            this.f63a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.r != null) {
                appCompatDelegateImpl.f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.s);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.q != null) {
                appCompatDelegateImpl2.m();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                androidx.core.h.z a2 = androidx.core.h.t.a(appCompatDelegateImpl3.q);
                a2.a(0.0f);
                appCompatDelegateImpl3.t = a2;
                AppCompatDelegateImpl.this.t.a(new w(this));
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            m mVar = appCompatDelegateImpl4.i;
            if (mVar != null) {
                mVar.onSupportActionModeFinished(appCompatDelegateImpl4.p);
            }
            AppCompatDelegateImpl.this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class e {

        /* renamed from: a  reason: collision with root package name */
        private G f66a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f67b;
        private BroadcastReceiver c;
        private IntentFilter d;

        e(G g) {
            this.f66a = g;
            this.f67b = g.a();
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.c;
            if (broadcastReceiver != null) {
                AppCompatDelegateImpl.this.e.unregisterReceiver(broadcastReceiver);
                this.c = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            boolean a2 = this.f66a.a();
            if (a2 != this.f67b) {
                this.f67b = a2;
                AppCompatDelegateImpl.this.a();
            }
        }

        int c() {
            this.f67b = this.f66a.a();
            return this.f67b ? 2 : 1;
        }

        void d() {
            a();
            if (this.c == null) {
                this.c = new x(this);
            }
            if (this.d == null) {
                this.d = new IntentFilter();
                this.d.addAction("android.intent.action.TIME_SET");
                this.d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.d.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImpl.this.e.registerReceiver(this.c, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends ContentFrameLayout {
        public f(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.e(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }
    }

    static {
        f56b = Build.VERSION.SDK_INT < 21;
        c = new int[]{16842836};
        if (!f56b || d) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new o(Thread.getDefaultUncaughtExceptionHandler()));
        d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Context context, Window window, m mVar) {
        this.e = context;
        this.f = window;
        this.i = mVar;
        this.g = this.f.getCallback();
        Window.Callback callback = this.g;
        if (!(callback instanceof d)) {
            this.h = new d(callback);
            this.f.setCallback(this.h);
            ia a2 = ia.a(context, (AttributeSet) null, c);
            Drawable c2 = a2.c(0);
            if (c2 != null) {
                this.f.setBackgroundDrawable(c2);
            }
            a2.a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean A() {
        if (this.M) {
            Context context = this.e;
            if (context instanceof Activity) {
                try {
                    return (context.getPackageManager().getActivityInfo(new ComponentName(this.e, this.e.getClass()), 0).configChanges & 512) == 0;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    return true;
                }
            }
        }
        return false;
    }

    private void B() {
        if (this.v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int l(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i;
        }
    }

    private void u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.w.findViewById(16908290);
        View decorView = this.f.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private ViewGroup v() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
                b(1);
            } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
                b(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                b(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                b(10);
            }
            this.E = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.e);
            if (!this.F) {
                if (this.E) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                    this.C = false;
                    this.B = false;
                } else if (this.B) {
                    TypedValue typedValue = new TypedValue();
                    this.e.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    int i = typedValue.resourceId;
                    if (i != 0) {
                        context = new androidx.appcompat.d.d(this.e, i);
                    } else {
                        context = this.e;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                    this.m = (androidx.appcompat.widget.C) viewGroup.findViewById(R$id.decor_content_parent);
                    this.m.setWindowCallback(p());
                    if (this.C) {
                        this.m.initFeature(109);
                    }
                    if (this.z) {
                        this.m.initFeature(2);
                    }
                    if (this.A) {
                        this.m.initFeature(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    androidx.core.h.t.a(viewGroup, new q(this));
                } else {
                    ((androidx.appcompat.widget.G) viewGroup).setOnFitSystemWindowsListener(new r(this));
                }
            }
            if (viewGroup != null) {
                if (this.m == null) {
                    this.x = (TextView) viewGroup.findViewById(R$id.title);
                }
                wa.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new s(this));
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void w() {
        if (this.N == null) {
            this.N = new e(G.a(this.e));
        }
    }

    private void x() {
        if (this.v) {
            return;
        }
        this.w = v();
        CharSequence o = o();
        if (!TextUtils.isEmpty(o)) {
            androidx.appcompat.widget.C c2 = this.m;
            if (c2 != null) {
                c2.setWindowTitle(o);
            } else if (s() != null) {
                s().a(o);
            } else {
                TextView textView = this.x;
                if (textView != null) {
                    textView.setText(o);
                }
            }
        }
        u();
        a(this.w);
        this.v = true;
        PanelFeatureState a2 = a(0, false);
        if (this.K) {
            return;
        }
        if (a2 == null || a2.j == null) {
            k(108);
        }
    }

    private int y() {
        int i = this.L;
        return i != -100 ? i : n.b();
    }

    private void z() {
        x();
        if (this.B && this.j == null) {
            Window.Callback callback = this.g;
            if (callback instanceof Activity) {
                this.j = new K((Activity) callback, this.C);
            } else if (callback instanceof Dialog) {
                this.j = new K((Dialog) callback);
            }
            ActionBar actionBar = this.j;
            if (actionBar != null) {
                actionBar.b(this.R);
            }
        }
    }

    @Override // androidx.appcompat.app.n
    public void a(Bundle bundle) {
        Window.Callback callback = this.g;
        if (callback instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.b((Activity) callback);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar s = s();
                if (s == null) {
                    this.R = true;
                } else {
                    s.b(true);
                }
            }
        }
        if (bundle == null || this.L != -100) {
            return;
        }
        this.L = bundle.getInt("appcompat:local_night_mode", -100);
    }

    void a(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.n
    public void b(Bundle bundle) {
        x();
    }

    @Override // androidx.appcompat.app.n
    public void c(int i) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.e).inflate(i, viewGroup);
        this.g.onContentChanged();
    }

    @Override // androidx.appcompat.app.n
    public MenuInflater d() {
        if (this.k == null) {
            z();
            ActionBar actionBar = this.j;
            this.k = new androidx.appcompat.d.g(actionBar != null ? actionBar.d() : this.e);
        }
        return this.k;
    }

    @Override // androidx.appcompat.app.n
    public ActionBar e() {
        z();
        return this.j;
    }

    @Override // androidx.appcompat.app.n
    public void f() {
        LayoutInflater from = LayoutInflater.from(this.e);
        if (from.getFactory() == null) {
            androidx.core.h.e.a(from, this);
        } else if (from.getFactory2() instanceof AppCompatDelegateImpl) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.n
    public void g() {
        ActionBar e2 = e();
        if (e2 == null || !e2.e()) {
            k(0);
        }
    }

    @Override // androidx.appcompat.app.n
    public void h() {
        if (this.O) {
            this.f.getDecorView().removeCallbacks(this.Q);
        }
        this.K = true;
        ActionBar actionBar = this.j;
        if (actionBar != null) {
            actionBar.f();
        }
        e eVar = this.N;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // androidx.appcompat.app.n
    public void i() {
        ActionBar e2 = e();
        if (e2 != null) {
            e2.c(true);
        }
    }

    @Override // androidx.appcompat.app.n
    public void j() {
        a();
    }

    @Override // androidx.appcompat.app.n
    public void k() {
        ActionBar e2 = e();
        if (e2 != null) {
            e2.c(false);
        }
        e eVar = this.N;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        androidx.core.h.z zVar = this.t;
        if (zVar != null) {
            zVar.a();
        }
    }

    final Context n() {
        ActionBar e2 = e();
        Context d2 = e2 != null ? e2.d() : null;
        return d2 == null ? this.e : d2;
    }

    final CharSequence o() {
        Window.Callback callback = this.g;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.l;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    final Window.Callback p() {
        return this.f.getCallback();
    }

    public boolean q() {
        return this.u;
    }

    boolean r() {
        androidx.appcompat.d.b bVar = this.p;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        ActionBar e2 = e();
        return e2 != null && e2.b();
    }

    final ActionBar s() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t() {
        ViewGroup viewGroup;
        return this.v && (viewGroup = this.w) != null && androidx.core.h.t.z(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements v.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.v.a
        public boolean a(androidx.appcompat.view.menu.l lVar) {
            Window.Callback p = AppCompatDelegateImpl.this.p();
            if (p != null) {
                p.onMenuOpened(108, lVar);
                return true;
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.v.a
        public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
            AppCompatDelegateImpl.this.b(lVar);
        }
    }

    @Override // androidx.appcompat.app.n
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.g.onContentChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            if (this.q.isShown()) {
                if (this.S == null) {
                    this.S = new Rect();
                    this.T = new Rect();
                }
                Rect rect = this.S;
                Rect rect2 = this.T;
                rect.set(0, i, 0, 0);
                wa.a(this.w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    View view = this.y;
                    if (view == null) {
                        this.y = new View(this.e);
                        this.y.setBackgroundColor(this.e.getResources().getColor(R$color.abc_input_method_navigation_guard));
                        this.w.addView(this.y, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.y.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.y != null;
                if (!this.D && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.q.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.y;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f57a;

        /* renamed from: b  reason: collision with root package name */
        int f58b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.l j;
        androidx.appcompat.view.menu.j k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new y();

            /* renamed from: a  reason: collision with root package name */
            int f59a;

            /* renamed from: b  reason: collision with root package name */
            boolean f60b;
            Bundle c;

            SavedState() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f59a = parcel.readInt();
                savedState.f60b = parcel.readInt() == 1;
                if (savedState.f60b) {
                    savedState.c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f59a);
                parcel.writeInt(this.f60b ? 1 : 0);
                if (this.f60b) {
                    parcel.writeBundle(this.c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.f57a = i;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.d.d dVar = new androidx.appcompat.d.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f58b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(androidx.appcompat.view.menu.l lVar) {
            androidx.appcompat.view.menu.j jVar;
            androidx.appcompat.view.menu.l lVar2 = this.j;
            if (lVar == lVar2) {
                return;
            }
            if (lVar2 != null) {
                lVar2.b(this.k);
            }
            this.j = lVar;
            if (lVar == null || (jVar = this.k) == null) {
                return;
            }
            lVar.a(jVar);
        }

        androidx.appcompat.view.menu.w a(v.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.j(this.l, R$layout.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }
    }

    private boolean m(int i) {
        Resources resources = this.e.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 != i3) {
            if (A()) {
                ((Activity) this.e).recreate();
                return true;
            }
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
            resources.updateConfiguration(configuration2, displayMetrics);
            if (Build.VERSION.SDK_INT < 26) {
                B.a(resources);
                return true;
            }
            return true;
        }
        return false;
    }

    void e(int i) {
        a(a(i, true), true);
    }

    void i(int i) {
        if (i == 108) {
            ActionBar e2 = e();
            if (e2 != null) {
                e2.a(false);
            }
        } else if (i == 0) {
            PanelFeatureState a2 = a(i, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        androidx.appcompat.view.menu.l lVar;
        androidx.appcompat.widget.C c2 = this.m;
        if (c2 != null) {
            c2.dismissPopups();
        }
        if (this.r != null) {
            this.f.getDecorView().removeCallbacks(this.s);
            if (this.r.isShowing()) {
                try {
                    this.r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.r = null;
        }
        m();
        PanelFeatureState a2 = a(0, false);
        if (a2 == null || (lVar = a2.j) == null) {
            return;
        }
        lVar.close();
    }

    /* loaded from: classes.dex */
    class d extends androidx.appcompat.d.j {
        d(Window.Callback callback) {
            super(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.e, callback);
            androidx.appcompat.d.b a2 = AppCompatDelegateImpl.this.a(aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.b(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.l)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.h(i);
            return true;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.i(i);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.l lVar = menu instanceof androidx.appcompat.view.menu.l ? (androidx.appcompat.view.menu.l) menu : null;
            if (i == 0 && lVar == null) {
                return false;
            }
            if (lVar != null) {
                lVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (lVar != null) {
                lVar.c(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            androidx.appcompat.view.menu.l lVar;
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (a2 != null && (lVar = a2.j) != null) {
                super.onProvideKeyboardShortcuts(list, lVar, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.q()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.q() && i == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    private boolean e(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        androidx.appcompat.widget.C c2;
        if (this.p != null) {
            return false;
        }
        PanelFeatureState a2 = a(i, true);
        if (i == 0 && (c2 = this.m) != null && c2.canShowOverflowMenu() && !ViewConfiguration.get(this.e).hasPermanentMenuKey()) {
            if (!this.m.isOverflowMenuShowing()) {
                if (!this.K && b(a2, keyEvent)) {
                    z = this.m.showOverflowMenu();
                }
                z = false;
            } else {
                z = this.m.hideOverflowMenu();
            }
        } else if (!a2.o && !a2.n) {
            if (a2.m) {
                if (a2.r) {
                    a2.m = false;
                    z2 = b(a2, keyEvent);
                } else {
                    z2 = true;
                }
                if (z2) {
                    a(a2, keyEvent);
                    z = true;
                }
            }
            z = false;
        } else {
            z = a2.o;
            a(a2, true);
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.e.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    int g(int i) {
        if (i != -100) {
            if (i != 0) {
                return i;
            }
            if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.e.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                w();
                return this.N.c();
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class g implements v.a {
        g() {
        }

        @Override // androidx.appcompat.view.menu.v.a
        public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
            androidx.appcompat.view.menu.l m = lVar.m();
            boolean z2 = m != lVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                lVar = m;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) lVar);
            if (a2 != null) {
                if (z2) {
                    AppCompatDelegateImpl.this.a(a2.f57a, a2, m);
                    AppCompatDelegateImpl.this.a(a2, true);
                    return;
                }
                AppCompatDelegateImpl.this.a(a2, z);
            }
        }

        @Override // androidx.appcompat.view.menu.v.a
        public boolean a(androidx.appcompat.view.menu.l lVar) {
            Window.Callback p;
            if (lVar == null) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (!appCompatDelegateImpl.B || (p = appCompatDelegateImpl.p()) == null || AppCompatDelegateImpl.this.K) {
                    return true;
                }
                p.onMenuOpened(108, lVar);
                return true;
            }
            return true;
        }
    }

    private void k(int i) {
        this.P = (1 << i) | this.P;
        if (this.O) {
            return;
        }
        androidx.core.h.t.a(this.f.getDecorView(), this.Q);
        this.O = true;
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState a2 = a(i, true);
            if (a2.o) {
                return false;
            }
            return b(a2, keyEvent);
        }
        return false;
    }

    @Override // androidx.appcompat.app.n
    public void c(Bundle bundle) {
        int i = this.L;
        if (i != -100) {
            bundle.putInt("appcompat:local_night_mode", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.c(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.s();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i != 108 && i != 0) || this.m == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    @Override // androidx.appcompat.app.n
    public boolean b(int i) {
        int l = l(i);
        if (this.F && l == 108) {
            return false;
        }
        if (this.B && l == 1) {
            this.B = false;
        }
        if (l == 1) {
            B();
            this.F = true;
            return true;
        } else if (l == 2) {
            B();
            this.z = true;
            return true;
        } else if (l == 5) {
            B();
            this.A = true;
            return true;
        } else if (l == 10) {
            B();
            this.D = true;
            return true;
        } else if (l == 108) {
            B();
            this.B = true;
            return true;
        } else if (l != 109) {
            return this.f.requestFeature(l);
        } else {
            B();
            this.C = true;
            return true;
        }
    }

    @Override // androidx.appcompat.app.n
    public void a(Toolbar toolbar) {
        if (this.g instanceof Activity) {
            ActionBar e2 = e();
            if (!(e2 instanceof K)) {
                this.k = null;
                if (e2 != null) {
                    e2.f();
                }
                if (toolbar != null) {
                    E e3 = new E(toolbar, ((Activity) this.g).getTitle(), this.h);
                    this.j = e3;
                    this.f.setCallback(e3.h());
                } else {
                    this.j = null;
                    this.f.setCallback(this.h);
                }
                g();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    boolean c(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.J;
            this.J = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z) {
                    a(a2, true);
                }
                return true;
            } else if (r()) {
                return true;
            }
        } else if (i == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    void h(int i) {
        ActionBar e2;
        if (i != 108 || (e2 = e()) == null) {
            return;
        }
        e2.a(true);
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        Context context = this.e;
        int i = panelFeatureState.f57a;
        if ((i == 0 || i == 108) && this.m != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.d.d dVar = new androidx.appcompat.d.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.l lVar = new androidx.appcompat.view.menu.l(context);
        lVar.a(this);
        panelFeatureState.a(lVar);
        return true;
    }

    @Override // androidx.appcompat.app.n
    public <T extends View> T a(int i) {
        x();
        return (T) this.f.findViewById(i);
    }

    @Override // androidx.appcompat.app.n
    public void a(Configuration configuration) {
        ActionBar e2;
        if (this.B && this.v && (e2 = e()) != null) {
            e2.a(configuration);
        }
        C0058q.a().a(this.e);
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.appcompat.d.b b(androidx.appcompat.d.b.a r8) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.d.b$a):androidx.appcompat.d.b");
    }

    @Override // androidx.appcompat.app.n
    public void a(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.g.onContentChanged();
    }

    @Override // androidx.appcompat.app.n
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ((ViewGroup) this.w.findViewById(16908290)).addView(view, layoutParams);
        this.g.onContentChanged();
    }

    @Override // androidx.appcompat.app.n
    public final InterfaceC0026a c() {
        return new a();
    }

    @Override // androidx.appcompat.app.n
    public final void a(CharSequence charSequence) {
        this.l = charSequence;
        androidx.appcompat.widget.C c2 = this.m;
        if (c2 != null) {
            c2.setWindowTitle(charSequence);
        } else if (s() != null) {
            s().a(charSequence);
        } else {
            TextView textView = this.x;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean a(androidx.appcompat.view.menu.l lVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback p = p();
        if (p == null || this.K || (a2 = a((Menu) lVar.m())) == null) {
            return false;
        }
        return p.onMenuItemSelected(a2.f57a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void a(androidx.appcompat.view.menu.l lVar) {
        a(lVar, true);
    }

    @Override // androidx.appcompat.app.n
    public androidx.appcompat.d.b a(b.a aVar) {
        m mVar;
        if (aVar != null) {
            androidx.appcompat.d.b bVar = this.p;
            if (bVar != null) {
                bVar.a();
            }
            c cVar = new c(aVar);
            ActionBar e2 = e();
            if (e2 != null) {
                this.p = e2.a(cVar);
                androidx.appcompat.d.b bVar2 = this.p;
                if (bVar2 != null && (mVar = this.i) != null) {
                    mVar.onSupportActionModeStarted(bVar2);
                }
            }
            if (this.p == null) {
                this.p = b(cVar);
            }
            return this.p;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        Window.Callback callback = this.g;
        if (((callback instanceof C0070d.a) || (callback instanceof A)) && (decorView = this.f.getDecorView()) != null && C0070d.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.g.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? a(keyCode, keyEvent) : c(keyCode, keyEvent);
    }

    boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.J = (keyEvent.getFlags() & CpioConstants.C_IWUSR) != 0;
        } else if (i == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.U == null) {
            String string = this.e.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string != null && !AppCompatViewInflater.class.getName().equals(string)) {
                try {
                    this.U = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.U = new AppCompatViewInflater();
                }
            } else {
                this.U = new AppCompatViewInflater();
            }
        }
        if (f56b) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z2 = true;
                }
            } else {
                z2 = a((ViewParent) view);
            }
            z = z2;
        } else {
            z = false;
        }
        return this.U.createView(view, str, context, attributeSet, z, f56b, true, va.b());
    }

    boolean b(int i, KeyEvent keyEvent) {
        ActionBar e2 = e();
        if (e2 == null || !e2.a(i, keyEvent)) {
            PanelFeatureState panelFeatureState = this.I;
            if (panelFeatureState != null && a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
                PanelFeatureState panelFeatureState2 = this.I;
                if (panelFeatureState2 != null) {
                    panelFeatureState2.n = true;
                }
                return true;
            }
            if (this.I == null) {
                PanelFeatureState a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || androidx.core.h.t.y((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.o || this.K) {
            return;
        }
        if (panelFeatureState.f57a == 0) {
            if ((this.e.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback p = p();
        if (p != null && !p.onMenuOpened(panelFeatureState.f57a, panelFeatureState.j)) {
            a(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.e.getSystemService("window");
        if (windowManager != null && b(panelFeatureState, keyEvent)) {
            if (panelFeatureState.g != null && !panelFeatureState.q) {
                View view = panelFeatureState.i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
                    layoutParams2.gravity = panelFeatureState.c;
                    layoutParams2.windowAnimations = panelFeatureState.f;
                    windowManager.addView(panelFeatureState.g, layoutParams2);
                    panelFeatureState.o = true;
                }
            } else {
                ViewGroup viewGroup = panelFeatureState.g;
                if (viewGroup == null) {
                    if (!b(panelFeatureState) || panelFeatureState.g == null) {
                        return;
                    }
                } else if (panelFeatureState.q && viewGroup.getChildCount() > 0) {
                    panelFeatureState.g.removeAllViews();
                }
                if (!a(panelFeatureState) || !panelFeatureState.a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = panelFeatureState.h.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.g.setBackgroundResource(panelFeatureState.f58b);
                ViewParent parent = panelFeatureState.h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(panelFeatureState.h);
                }
                panelFeatureState.g.addView(panelFeatureState.h, layoutParams3);
                if (!panelFeatureState.h.hasFocus()) {
                    panelFeatureState.h.requestFocus();
                }
            }
            i = -2;
            panelFeatureState.n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
            layoutParams22.gravity = panelFeatureState.c;
            layoutParams22.windowAnimations = panelFeatureState.f;
            windowManager.addView(panelFeatureState.g, layoutParams22);
            panelFeatureState.o = true;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(n());
        panelFeatureState.g = new f(panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        androidx.appcompat.widget.C c2;
        androidx.appcompat.widget.C c3;
        androidx.appcompat.widget.C c4;
        if (this.K) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.I;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            a(panelFeatureState2, false);
        }
        Window.Callback p = p();
        if (p != null) {
            panelFeatureState.i = p.onCreatePanelView(panelFeatureState.f57a);
        }
        int i = panelFeatureState.f57a;
        boolean z = i == 0 || i == 108;
        if (z && (c4 = this.m) != null) {
            c4.setMenuPrepared();
        }
        if (panelFeatureState.i == null && (!z || !(s() instanceof E))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!c(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z && this.m != null) {
                    if (this.n == null) {
                        this.n = new b();
                    }
                    this.m.a(panelFeatureState.j, this.n);
                }
                panelFeatureState.j.s();
                if (!p.onCreatePanelMenu(panelFeatureState.f57a, panelFeatureState.j)) {
                    panelFeatureState.a((androidx.appcompat.view.menu.l) null);
                    if (z && (c2 = this.m) != null) {
                        c2.a(null, this.n);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.s();
            Bundle bundle = panelFeatureState.s;
            if (bundle != null) {
                panelFeatureState.j.a(bundle);
                panelFeatureState.s = null;
            }
            if (!p.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z && (c3 = this.m) != null) {
                    c3.a(null, this.n);
                }
                panelFeatureState.j.r();
                return false;
            }
            panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.p);
            panelFeatureState.j.r();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.I = panelFeatureState;
        return true;
    }

    private void a(androidx.appcompat.view.menu.l lVar, boolean z) {
        androidx.appcompat.widget.C c2 = this.m;
        if (c2 != null && c2.canShowOverflowMenu() && (!ViewConfiguration.get(this.e).hasPermanentMenuKey() || this.m.isOverflowMenuShowPending())) {
            Window.Callback p = p();
            if (this.m.isOverflowMenuShowing() && z) {
                this.m.hideOverflowMenu();
                if (this.K) {
                    return;
                }
                p.onPanelClosed(108, a(0, true).j);
                return;
            } else if (p == null || this.K) {
                return;
            } else {
                if (this.O && (this.P & 1) != 0) {
                    this.f.getDecorView().removeCallbacks(this.Q);
                    this.Q.run();
                }
                PanelFeatureState a2 = a(0, true);
                androidx.appcompat.view.menu.l lVar2 = a2.j;
                if (lVar2 == null || a2.r || !p.onPreparePanel(0, a2.i, lVar2)) {
                    return;
                }
                p.onMenuOpened(108, a2.j);
                this.m.showOverflowMenu();
                return;
            }
        }
        PanelFeatureState a3 = a(0, true);
        a3.q = true;
        a(a3, false);
        a(a3, (KeyEvent) null);
    }

    void b(androidx.appcompat.view.menu.l lVar) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.m.dismissPopups();
        Window.Callback p = p();
        if (p != null && !this.K) {
            p.onPanelClosed(108, lVar);
        }
        this.G = false;
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.i;
        if (view != null) {
            panelFeatureState.h = view;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.o == null) {
                this.o = new g();
            }
            panelFeatureState.h = (View) panelFeatureState.a(this.o);
            return panelFeatureState.h != null;
        }
    }

    void a(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.C c2;
        if (z && panelFeatureState.f57a == 0 && (c2 = this.m) != null && c2.isOverflowMenuShowing()) {
            b(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.e.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && (viewGroup = panelFeatureState.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                a(panelFeatureState.f57a, panelFeatureState, null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.I == panelFeatureState) {
            this.I = null;
        }
    }

    void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.H;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.K) {
            this.g.onPanelClosed(i, menu);
        }
    }

    PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.H;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    protected PanelFeatureState a(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.H;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.H = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState == null) {
            PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
            panelFeatureStateArr[i] = panelFeatureState2;
            return panelFeatureState2;
        }
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        androidx.appcompat.view.menu.l lVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && (lVar = panelFeatureState.j) != null) {
            z = lVar.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.m == null) {
            a(panelFeatureState, true);
        }
        return z;
    }

    @Override // androidx.appcompat.app.n
    public boolean a() {
        int y = y();
        int g2 = g(y);
        boolean m = g2 != -1 ? m(g2) : false;
        if (y == 0) {
            w();
            this.N.d();
        }
        this.M = true;
        return m;
    }
}
