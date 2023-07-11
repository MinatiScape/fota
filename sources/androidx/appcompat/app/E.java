package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.pa;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
public class E extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    androidx.appcompat.widget.D f75a;

    /* renamed from: b  reason: collision with root package name */
    boolean f76b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<ActionBar.a> f = new ArrayList<>();
    private final Runnable g = new C(this);
    private final Toolbar.b h = new D(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class b implements l.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.l lVar) {
            E e = E.this;
            if (e.c != null) {
                if (e.f75a.isOverflowMenuShowing()) {
                    E.this.c.onPanelClosed(108, lVar);
                } else if (E.this.c.onPreparePanel(0, null, lVar)) {
                    E.this.c.onMenuOpened(108, lVar);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean a(androidx.appcompat.view.menu.l lVar, MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    private class c extends androidx.appcompat.d.j {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(E.this.f75a.getContext());
            }
            return super.onCreatePanelView(i);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                E e = E.this;
                if (!e.f76b) {
                    e.f75a.setMenuPrepared();
                    E.this.f76b = true;
                }
            }
            return onPreparePanel;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f75a = new pa(toolbar, false);
        this.c = new c(callback);
        this.f75a.setWindowCallback(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f75a.setWindowTitle(charSequence);
    }

    private Menu j() {
        if (!this.d) {
            this.f75a.a(new a(), new b());
            this.d = true;
        }
        return this.f75a.getMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.a aVar) {
        this.f.add(aVar);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean b() {
        if (this.f75a.hasExpandedActionView()) {
            this.f75a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int c() {
        return this.f75a.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context d() {
        return this.f75a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean e() {
        this.f75a.getViewGroup().removeCallbacks(this.g);
        androidx.core.h.t.a(this.f75a.getViewGroup(), this.g);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.ActionBar
    public void f() {
        this.f75a.getViewGroup().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean g() {
        return this.f75a.showOverflowMenu();
    }

    public Window.Callback h() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Menu j = j();
        androidx.appcompat.view.menu.l lVar = j instanceof androidx.appcompat.view.menu.l ? (androidx.appcompat.view.menu.l) j : null;
        if (lVar != null) {
            lVar.s();
        }
        try {
            j.clear();
            if (!this.c.onCreatePanelMenu(0, j) || !this.c.onPreparePanel(0, null, j)) {
                j.clear();
            }
        } finally {
            if (lVar != null) {
                lVar.r();
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.a aVar) {
        this.f.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class a implements v.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f77a;

        a() {
        }

        @Override // androidx.appcompat.view.menu.v.a
        public boolean a(androidx.appcompat.view.menu.l lVar) {
            Window.Callback callback = E.this.c;
            if (callback != null) {
                callback.onMenuOpened(108, lVar);
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.v.a
        public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
            if (this.f77a) {
                return;
            }
            this.f77a = true;
            E.this.f75a.dismissPopupMenus();
            Window.Callback callback = E.this.c;
            if (callback != null) {
                callback.onPanelClosed(108, lVar);
            }
            this.f77a = false;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(CharSequence charSequence) {
        this.f75a.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a() {
        return this.f75a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            g();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j != null) {
            j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return j.performShortcut(i, keyEvent, 0);
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(boolean z) {
        if (z == this.e) {
            return;
        }
        this.e = z;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).onMenuVisibilityChanged(z);
        }
    }
}
