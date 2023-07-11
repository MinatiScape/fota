package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.Toolbar;
/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class pa implements D {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f351a;

    /* renamed from: b  reason: collision with root package name */
    private int f352b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    public pa(Toolbar toolbar, boolean z) {
        this(toolbar, z, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    private void d(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f352b & 8) != 0) {
            this.f351a.setTitle(charSequence);
        }
    }

    public void a(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.f351a.getNavigationContentDescription())) {
            b(this.p);
        }
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f352b & 8) != 0) {
            this.f351a.setSubtitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.h = true;
        d(charSequence);
    }

    @Override // androidx.appcompat.widget.D
    public boolean canShowOverflowMenu() {
        return this.f351a.b();
    }

    @Override // androidx.appcompat.widget.D
    public void collapseActionView() {
        this.f351a.c();
    }

    @Override // androidx.appcompat.widget.D
    public void dismissPopupMenus() {
        this.f351a.d();
    }

    @Override // androidx.appcompat.widget.D
    public Context getContext() {
        return this.f351a.getContext();
    }

    @Override // androidx.appcompat.widget.D
    public int getDisplayOptions() {
        return this.f352b;
    }

    @Override // androidx.appcompat.widget.D
    public Menu getMenu() {
        return this.f351a.getMenu();
    }

    @Override // androidx.appcompat.widget.D
    public int getNavigationMode() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.D
    public CharSequence getTitle() {
        return this.f351a.getTitle();
    }

    @Override // androidx.appcompat.widget.D
    public ViewGroup getViewGroup() {
        return this.f351a;
    }

    @Override // androidx.appcompat.widget.D
    public boolean hasExpandedActionView() {
        return this.f351a.f();
    }

    @Override // androidx.appcompat.widget.D
    public boolean hideOverflowMenu() {
        return this.f351a.g();
    }

    @Override // androidx.appcompat.widget.D
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.D
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.D
    public boolean isOverflowMenuShowPending() {
        return this.f351a.h();
    }

    @Override // androidx.appcompat.widget.D
    public boolean isOverflowMenuShowing() {
        return this.f351a.i();
    }

    @Override // androidx.appcompat.widget.D
    public void setCollapsible(boolean z) {
        this.f351a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.D
    public void setDisplayOptions(int i) {
        View view;
        int i2 = this.f352b ^ i;
        this.f352b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    b();
                }
                c();
            }
            if ((i2 & 3) != 0) {
                d();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f351a.setTitle(this.i);
                    this.f351a.setSubtitle(this.j);
                } else {
                    this.f351a.setTitle((CharSequence) null);
                    this.f351a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f351a.addView(view);
            } else {
                this.f351a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.D
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // androidx.appcompat.widget.D
    public void setIcon(int i) {
        setIcon(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.D
    public void setLogo(int i) {
        a(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.D
    public void setMenuPrepared() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.D
    public void setVisibility(int i) {
        this.f351a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.D
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.D
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        d(charSequence);
    }

    @Override // androidx.appcompat.widget.D
    public androidx.core.h.z setupAnimatorToVisibility(int i, long j) {
        androidx.core.h.z a2 = androidx.core.h.t.a(this.f351a);
        a2.a(i == 0 ? 1.0f : 0.0f);
        a2.a(j);
        a2.a(new oa(this, i));
        return a2;
    }

    @Override // androidx.appcompat.widget.D
    public boolean showOverflowMenu() {
        return this.f351a.k();
    }

    public pa(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f351a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        ia a2 = ia.a(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.q = a2.b(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e = a2.e(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(e)) {
                c(e);
            }
            CharSequence e2 = a2.e(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e2)) {
                b(e2);
            }
            Drawable b2 = a2.b(R$styleable.ActionBar_logo);
            if (b2 != null) {
                a(b2);
            }
            Drawable b3 = a2.b(R$styleable.ActionBar_icon);
            if (b3 != null) {
                setIcon(b3);
            }
            if (this.g == null && (drawable = this.q) != null) {
                b(drawable);
            }
            setDisplayOptions(a2.d(R$styleable.ActionBar_displayOptions, 0));
            int g = a2.g(R$styleable.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.f351a.getContext()).inflate(g, (ViewGroup) this.f351a, false));
                setDisplayOptions(this.f352b | 16);
            }
            int f = a2.f(R$styleable.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f351a.getLayoutParams();
                layoutParams.height = f;
                this.f351a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(R$styleable.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(R$styleable.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                this.f351a.a(Math.max(b4, 0), Math.max(b5, 0));
            }
            int g2 = a2.g(R$styleable.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                Toolbar toolbar2 = this.f351a;
                toolbar2.b(toolbar2.getContext(), g2);
            }
            int g3 = a2.g(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar3 = this.f351a;
                toolbar3.a(toolbar3.getContext(), g3);
            }
            int g4 = a2.g(R$styleable.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f351a.setPopupTheme(g4);
            }
        } else {
            this.f352b = a();
        }
        a2.a();
        a(i);
        this.k = this.f351a.getNavigationContentDescription();
        this.f351a.setNavigationOnClickListener(new na(this));
    }

    @Override // androidx.appcompat.widget.D
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        d();
    }

    private void c() {
        if ((this.f352b & 4) != 0) {
            Toolbar toolbar = this.f351a;
            Drawable drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f351a.setNavigationIcon((Drawable) null);
    }

    private void d() {
        Drawable drawable;
        int i = this.f352b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f;
            if (drawable == null) {
                drawable = this.e;
            }
        } else {
            drawable = this.e;
        }
        this.f351a.setLogo(drawable);
    }

    public void b(Drawable drawable) {
        this.g = drawable;
        c();
    }

    private int a() {
        if (this.f351a.getNavigationIcon() != null) {
            this.q = this.f351a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public void b(int i) {
        a(i == 0 ? null : getContext().getString(i));
    }

    private void b() {
        if ((this.f352b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f351a.setNavigationContentDescription(this.p);
            } else {
                this.f351a.setNavigationContentDescription(this.k);
            }
        }
    }

    public void a(Drawable drawable) {
        this.f = drawable;
        d();
    }

    @Override // androidx.appcompat.widget.D
    public void a(Menu menu, v.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.f351a.getContext());
            this.n.a(R$id.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f351a.a((androidx.appcompat.view.menu.l) menu, this.n);
    }

    @Override // androidx.appcompat.widget.D
    public void a(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f351a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.o != 2) {
            return;
        }
        this.f351a.addView(this.c, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.f48a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    public void a(View view) {
        View view2 = this.d;
        if (view2 != null && (this.f352b & 16) != 0) {
            this.f351a.removeView(view2);
        }
        this.d = view;
        if (view == null || (this.f352b & 16) == 0) {
            return;
        }
        this.f351a.addView(this.d);
    }

    public void a(CharSequence charSequence) {
        this.k = charSequence;
        b();
    }

    @Override // androidx.appcompat.widget.D
    public void a(v.a aVar, l.a aVar2) {
        this.f351a.a(aVar, aVar2);
    }
}
