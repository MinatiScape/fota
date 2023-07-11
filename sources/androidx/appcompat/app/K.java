package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class K extends ActionBar implements ActionBarOverlayLayout.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f90a = new AccelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f91b = new DecelerateInterpolator();
    androidx.appcompat.d.i B;
    private boolean C;
    boolean D;
    Context c;
    private Context d;
    private Activity e;
    private Dialog f;
    ActionBarOverlayLayout g;
    ActionBarContainer h;
    androidx.appcompat.widget.D i;
    ActionBarContextView j;
    View k;
    ScrollingTabContainerView l;
    private boolean o;
    a p;
    androidx.appcompat.d.b q;
    b.a r;
    private boolean s;
    private boolean u;
    boolean x;
    boolean y;
    private boolean z;
    private ArrayList<Object> m = new ArrayList<>();
    private int n = -1;
    private ArrayList<ActionBar.a> t = new ArrayList<>();
    private int v = 0;
    boolean w = true;
    private boolean A = true;
    final androidx.core.h.A E = new H(this);
    final androidx.core.h.A F = new I(this);
    final androidx.core.h.C G = new J(this);

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.d.b implements l.a {
        private final Context c;
        private final androidx.appcompat.view.menu.l d;
        private b.a e;
        private WeakReference<View> f;

        public a(Context context, b.a aVar) {
            this.c = context;
            this.e = aVar;
            androidx.appcompat.view.menu.l lVar = new androidx.appcompat.view.menu.l(context);
            lVar.c(1);
            this.d = lVar;
            this.d.a(this);
        }

        @Override // androidx.appcompat.d.b
        public void a() {
            K k = K.this;
            if (k.p != this) {
                return;
            }
            if (!K.a(k.x, k.y, false)) {
                K k2 = K.this;
                k2.q = this;
                k2.r = this.e;
            } else {
                this.e.a(this);
            }
            this.e = null;
            K.this.d(false);
            K.this.j.a();
            K.this.i.getViewGroup().sendAccessibilityEvent(32);
            K k3 = K.this;
            k3.g.setHideOnContentScrollEnabled(k3.D);
            K.this.p = null;
        }

        @Override // androidx.appcompat.d.b
        public void b(CharSequence charSequence) {
            K.this.j.setTitle(charSequence);
        }

        @Override // androidx.appcompat.d.b
        public Menu c() {
            return this.d;
        }

        @Override // androidx.appcompat.d.b
        public MenuInflater d() {
            return new androidx.appcompat.d.g(this.c);
        }

        @Override // androidx.appcompat.d.b
        public CharSequence e() {
            return K.this.j.getSubtitle();
        }

        @Override // androidx.appcompat.d.b
        public CharSequence g() {
            return K.this.j.getTitle();
        }

        @Override // androidx.appcompat.d.b
        public void i() {
            if (K.this.p != this) {
                return;
            }
            this.d.s();
            try {
                this.e.b(this, this.d);
            } finally {
                this.d.r();
            }
        }

        @Override // androidx.appcompat.d.b
        public boolean j() {
            return K.this.j.b();
        }

        public boolean k() {
            this.d.s();
            try {
                return this.e.a(this, this.d);
            } finally {
                this.d.r();
            }
        }

        @Override // androidx.appcompat.d.b
        public void b(int i) {
            b(K.this.c.getResources().getString(i));
        }

        @Override // androidx.appcompat.d.b
        public View b() {
            WeakReference<View> weakReference = this.f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.d.b
        public void a(View view) {
            K.this.j.setCustomView(view);
            this.f = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.d.b
        public void a(CharSequence charSequence) {
            K.this.j.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.d.b
        public void a(int i) {
            a((CharSequence) K.this.c.getResources().getString(i));
        }

        @Override // androidx.appcompat.d.b
        public void a(boolean z) {
            super.a(z);
            K.this.j.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean a(androidx.appcompat.view.menu.l lVar, MenuItem menuItem) {
            b.a aVar = this.e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.l lVar) {
            if (this.e == null) {
                return;
            }
            i();
            K.this.j.d();
        }
    }

    public K(Activity activity, boolean z) {
        this.e = activity;
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (z) {
            return;
        }
        this.k = decorView.findViewById(16908290);
    }

    private androidx.appcompat.widget.D a(View view) {
        if (view instanceof androidx.appcompat.widget.D) {
            return (androidx.appcompat.widget.D) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    private void b(View view) {
        this.g = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.i = a(view.findViewById(R$id.action_bar));
        this.j = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        this.h = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        androidx.appcompat.widget.D d = this.i;
        if (d != null && this.j != null && this.h != null) {
            this.c = d.getContext();
            boolean z = (this.i.getDisplayOptions() & 4) != 0;
            if (z) {
                this.o = true;
            }
            androidx.appcompat.d.a a2 = androidx.appcompat.d.a.a(this.c);
            i(a2.a() || z);
            j(a2.f());
            TypedArray obtainStyledAttributes = this.c.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
                h(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                a(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(K.class.getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void j(boolean z) {
        this.u = z;
        if (!this.u) {
            this.i.a(null);
            this.h.setTabContainer(this.l);
        } else {
            this.h.setTabContainer(null);
            this.i.a(this.l);
        }
        boolean z2 = true;
        boolean z3 = i() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.l;
        if (scrollingTabContainerView != null) {
            if (z3) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.g;
                if (actionBarOverlayLayout != null) {
                    androidx.core.h.t.D(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.i.setCollapsible(!this.u && z3);
        this.g.setHasNonEmbeddedTabs((this.u || !z3) ? false : false);
    }

    private void k(boolean z) {
        if (a(this.x, this.y, this.z)) {
            if (this.A) {
                return;
            }
            this.A = true;
            f(z);
        } else if (this.A) {
            this.A = false;
            e(z);
        }
    }

    private void l() {
        if (this.z) {
            return;
        }
        this.z = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        k(false);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.a aVar) {
        this.t.add(aVar);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean z) {
        androidx.appcompat.d.i iVar;
        this.C = z;
        if (z || (iVar = this.B) == null) {
            return;
        }
        iVar.a();
    }

    public void d(boolean z) {
        androidx.core.h.z zVar;
        androidx.core.h.z a2;
        if (z) {
            l();
        } else {
            j();
        }
        if (!k()) {
            if (z) {
                this.i.setVisibility(4);
                this.j.setVisibility(0);
                return;
            }
            this.i.setVisibility(0);
            this.j.setVisibility(8);
            return;
        }
        if (z) {
            a2 = this.i.setupAnimatorToVisibility(4, 100L);
            zVar = this.j.a(0, 200L);
        } else {
            zVar = this.i.setupAnimatorToVisibility(0, 200L);
            a2 = this.j.a(8, 100L);
        }
        androidx.appcompat.d.i iVar = new androidx.appcompat.d.i();
        iVar.a(a2, zVar);
        iVar.c();
    }

    public void e(boolean z) {
        View view;
        int[] iArr;
        androidx.appcompat.d.i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        if (this.v == 0 && (this.C || z)) {
            this.h.setAlpha(1.0f);
            this.h.setTransitioning(true);
            androidx.appcompat.d.i iVar2 = new androidx.appcompat.d.i();
            float f = -this.h.getHeight();
            if (z) {
                this.h.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            androidx.core.h.z a2 = androidx.core.h.t.a(this.h);
            a2.b(f);
            a2.a(this.G);
            iVar2.a(a2);
            if (this.w && (view = this.k) != null) {
                androidx.core.h.z a3 = androidx.core.h.t.a(view);
                a3.b(f);
                iVar2.a(a3);
            }
            iVar2.a(f90a);
            iVar2.a(250L);
            iVar2.a(this.E);
            this.B = iVar2;
            iVar2.c();
            return;
        }
        this.E.b(null);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void enableContentAnimations(boolean z) {
        this.w = z;
    }

    public void f(boolean z) {
        View view;
        View view2;
        int[] iArr;
        androidx.appcompat.d.i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        this.h.setVisibility(0);
        if (this.v == 0 && (this.C || z)) {
            this.h.setTranslationY(0.0f);
            float f = -this.h.getHeight();
            if (z) {
                this.h.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            this.h.setTranslationY(f);
            androidx.appcompat.d.i iVar2 = new androidx.appcompat.d.i();
            androidx.core.h.z a2 = androidx.core.h.t.a(this.h);
            a2.b(0.0f);
            a2.a(this.G);
            iVar2.a(a2);
            if (this.w && (view2 = this.k) != null) {
                view2.setTranslationY(f);
                androidx.core.h.z a3 = androidx.core.h.t.a(this.k);
                a3.b(0.0f);
                iVar2.a(a3);
            }
            iVar2.a(f91b);
            iVar2.a(250L);
            iVar2.a(this.F);
            this.B = iVar2;
            iVar2.c();
        } else {
            this.h.setAlpha(1.0f);
            this.h.setTranslationY(0.0f);
            if (this.w && (view = this.k) != null) {
                view.setTranslationY(0.0f);
            }
            this.F.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            androidx.core.h.t.D(actionBarOverlayLayout);
        }
    }

    public void g(boolean z) {
        a(z ? 4 : 0, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        b.a aVar = this.r;
        if (aVar != null) {
            aVar.a(this.q);
            this.q = null;
            this.r = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void hideForSystem() {
        if (this.y) {
            return;
        }
        this.y = true;
        k(true);
    }

    public void i(boolean z) {
        this.i.setHomeButtonEnabled(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void onContentScrollStarted() {
        androidx.appcompat.d.i iVar = this.B;
        if (iVar != null) {
            iVar.a();
            this.B = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void onWindowVisibilityChanged(int i) {
        this.v = i;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.a aVar) {
        this.t.remove(aVar);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void showForSystem() {
        if (this.y) {
            this.y = false;
            k(true);
        }
    }

    public int i() {
        return this.i.getNavigationMode();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int c() {
        return this.i.getDisplayOptions();
    }

    public void h(boolean z) {
        if (z && !this.g.b()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.D = z;
        this.g.setHideOnContentScrollEnabled(z);
    }

    public void a(float f) {
        androidx.core.h.t.a(this.h, f);
    }

    private boolean k() {
        return androidx.core.h.t.z(this.h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(Configuration configuration) {
        j(androidx.appcompat.d.a.a(this.c).f());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(boolean z) {
        if (z == this.s) {
            return;
        }
        this.s = z;
        int size = this.t.size();
        for (int i = 0; i < size; i++) {
            this.t.get(i).onMenuVisibilityChanged(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(CharSequence charSequence) {
        this.i.setWindowTitle(charSequence);
    }

    public void a(int i, int i2) {
        int displayOptions = this.i.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.o = true;
        }
        this.i.setDisplayOptions((i & i2) | ((i2 ^ (-1)) & displayOptions));
    }

    private void j() {
        if (this.z) {
            this.z = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            k(false);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context d() {
        if (this.d == null) {
            TypedValue typedValue = new TypedValue();
            this.c.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.d = new ContextThemeWrapper(this.c, i);
            } else {
                this.d = this.c;
            }
        }
        return this.d;
    }

    public K(Dialog dialog) {
        this.f = dialog;
        b(dialog.getWindow().getDecorView());
    }

    @Override // androidx.appcompat.app.ActionBar
    public androidx.appcompat.d.b a(b.a aVar) {
        a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.g.setHideOnContentScrollEnabled(false);
        this.j.c();
        a aVar3 = new a(this.j.getContext(), aVar);
        if (aVar3.k()) {
            this.p = aVar3;
            aVar3.i();
            this.j.a(aVar3);
            d(true);
            this.j.sendAccessibilityEvent(32);
            return aVar3;
        }
        return null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean b() {
        androidx.appcompat.widget.D d = this.i;
        if (d == null || !d.hasExpandedActionView()) {
            return false;
        }
        this.i.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(boolean z) {
        if (this.o) {
            return;
        }
        g(z);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(int i, KeyEvent keyEvent) {
        Menu c;
        a aVar = this.p;
        if (aVar == null || (c = aVar.c()) == null) {
            return false;
        }
        c.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return c.performShortcut(i, keyEvent, 0);
    }
}
