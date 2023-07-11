package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.AbstractC0068b;
import java.lang.reflect.Method;
/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public class q extends AbstractC0039c<androidx.core.b.a.b> implements MenuItem {
    private Method e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    public class a extends AbstractC0068b {
        final ActionProvider d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.d = actionProvider;
        }

        @Override // androidx.core.h.AbstractC0068b
        public boolean a() {
            return this.d.hasSubMenu();
        }

        @Override // androidx.core.h.AbstractC0068b
        public View c() {
            return this.d.onCreateActionView();
        }

        @Override // androidx.core.h.AbstractC0068b
        public boolean d() {
            return this.d.onPerformDefaultAction();
        }

        @Override // androidx.core.h.AbstractC0068b
        public void a(SubMenu subMenu) {
            this.d.onPrepareSubMenu(q.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    static class b extends FrameLayout implements androidx.appcompat.d.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f189a;

        b(View view) {
            super(view.getContext());
            this.f189a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f189a;
        }

        @Override // androidx.appcompat.d.c
        public void onActionViewCollapsed() {
            this.f189a.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.d.c
        public void onActionViewExpanded() {
            this.f189a.onActionViewExpanded();
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class c extends C0040d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f167a).onMenuItemActionCollapse(q.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f167a).onMenuItemActionExpand(q.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class d extends C0040d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f167a).onMenuItemClick(q.this.a(menuItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context, androidx.core.b.a.b bVar) {
        super(context, bVar);
    }

    public void a(boolean z) {
        try {
            if (this.e == null) {
                this.e = ((androidx.core.b.a.b) this.f167a).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.e.invoke(this.f167a, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((androidx.core.b.a.b) this.f167a).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((androidx.core.b.a.b) this.f167a).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0068b a2 = ((androidx.core.b.a.b) this.f167a).a();
        if (a2 instanceof a) {
            return ((a) a2).d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((androidx.core.b.a.b) this.f167a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((androidx.core.b.a.b) this.f167a).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((androidx.core.b.a.b) this.f167a).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((androidx.core.b.a.b) this.f167a).getIcon();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((androidx.core.b.a.b) this.f167a).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((androidx.core.b.a.b) this.f167a).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((androidx.core.b.a.b) this.f167a).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((androidx.core.b.a.b) this.f167a).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((androidx.core.b.a.b) this.f167a).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(((androidx.core.b.a.b) this.f167a).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((androidx.core.b.a.b) this.f167a).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((androidx.core.b.a.b) this.f167a).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((androidx.core.b.a.b) this.f167a).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((androidx.core.b.a.b) this.f167a).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((androidx.core.b.a.b) this.f167a).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((androidx.core.b.a.b) this.f167a).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((androidx.core.b.a.b) this.f167a).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((androidx.core.b.a.b) this.f167a).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((androidx.core.b.a.b) this.f167a).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((androidx.core.b.a.b) this.f167a).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((androidx.core.b.a.b) this.f167a).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((androidx.core.b.a.b) this.f167a).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((androidx.core.b.a.b) this.f167a).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((androidx.core.b.a.b) this.f167a).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((androidx.core.b.a.b) this.f167a).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((androidx.core.b.a.b) this.f167a).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((androidx.core.b.a.b) this.f167a).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((androidx.core.b.a.b) this.f167a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((androidx.core.b.a.b) this.f167a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((androidx.core.b.a.b) this.f167a).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((androidx.core.b.a.b) this.f167a).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((androidx.core.b.a.b) this.f167a).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f167a).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f167a).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((androidx.core.b.a.b) this.f167a).setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((androidx.core.b.a.b) this.f167a).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((androidx.core.b.a.b) this.f167a).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((androidx.core.b.a.b) this.f167a).setActionView(i);
        View actionView = ((androidx.core.b.a.b) this.f167a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((androidx.core.b.a.b) this.f167a).setActionView(new b(actionView));
        }
        return this;
    }

    a a(ActionProvider actionProvider) {
        return new a(this.f166b, actionProvider);
    }
}
