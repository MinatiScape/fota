package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.w;
import androidx.core.h.AbstractC0068b;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
public final class p implements androidx.core.b.a.b {
    private View A;
    private AbstractC0068b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f187a;

    /* renamed from: b  reason: collision with root package name */
    private final int f188b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char j;
    private Drawable l;
    l n;
    private D o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private int z;
    private int i = CpioConstants.C_ISFIFO;
    private int k = CpioConstants.C_ISFIFO;
    private int m = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.z = 0;
        this.n = lVar;
        this.f187a = i2;
        this.f188b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
        this.z = i5;
    }

    @Override // androidx.core.b.a.b
    public MenuItem a(char c, int i) {
        if (this.j == c && this.k == i) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(i);
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b
    public MenuItem b(char c, int i) {
        if (this.h == c && this.i == i) {
            return this;
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.n.b(false);
        return this;
    }

    public int c() {
        return this.k;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.a(this);
        }
        return false;
    }

    public void d(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    public int e() {
        return this.i;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (j()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.n.b(this);
            }
            return false;
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.n.p() ? this.j : this.h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        AbstractC0068b abstractC0068b = this.B;
        if (abstractC0068b != null) {
            this.A = abstractC0068b.a(this);
            return this.A;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f188b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.m != 0) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.n.e(), this.m);
            this.m = 0;
            this.l = b2;
            return a(b2);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f187a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        if (charSequence == null) {
            charSequence = this.e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        char g = g();
        if (g == 0) {
            return "";
        }
        Resources resources = this.n.e().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.e()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i = this.n.p() ? this.k : this.i;
        a(sb, i, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        a(sb, i, CpioConstants.C_ISFIFO, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        a(sb, i, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        a(sb, i, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        a(sb, i, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        a(sb, i, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (g == '\b') {
            sb.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (g == '\n') {
            sb.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (g != ' ') {
            sb.append(g);
        } else {
            sb.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public CharSequence i() {
        return this.s;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0068b abstractC0068b = this.B;
        return (abstractC0068b == null || !abstractC0068b.e()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        AbstractC0068b abstractC0068b;
        if ((this.z & 8) != 0) {
            if (this.A == null && (abstractC0068b = this.B) != null) {
                this.A = abstractC0068b.a(this);
            }
            return this.A != null;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            l lVar = this.n;
            if (lVar.a(lVar, this)) {
                return true;
            }
            Runnable runnable = this.p;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.g != null) {
                try {
                    this.n.e().startActivity(this.g);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                }
            }
            AbstractC0068b abstractC0068b = this.B;
            return abstractC0068b != null && abstractC0068b.d();
        }
        return true;
    }

    public boolean l() {
        return (this.y & 32) == 32;
    }

    public boolean m() {
        return (this.y & 4) != 0;
    }

    public boolean n() {
        return (this.z & 1) == 1;
    }

    public boolean o() {
        return (this.z & 2) == 2;
    }

    public boolean p() {
        return this.n.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.n.q() && g() != 0;
    }

    public boolean r() {
        return (this.z & 4) == 4;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        setActionView(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.j == c) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        this.y = (z ? 1 : 0) | (i & (-2));
        if (i != this.y) {
            this.n.b(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.n.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.h == c) {
            return this;
        }
        this.h = c;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.j = Character.toLowerCase(c2);
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i;
        this.n.c(this);
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.b(false);
        D d = this.o;
        if (d != null) {
            d.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.e;
        }
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (e(z)) {
            this.n.d(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void c(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(boolean z) {
        int i = this.y;
        this.y = (z ? 0 : 8) | (i & (-9));
        return i != this.y;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        setActionView(view);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public androidx.core.b.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public CharSequence d() {
        return this.r;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public androidx.core.b.a.b setActionView(View view) {
        int i;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i = this.f187a) > 0) {
            view.setId(i);
        }
        this.n.c(this);
        return this;
    }

    private static void a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        int i = this.y;
        this.y = (z ? 2 : 0) | (i & (-3));
        if (i != this.y) {
            this.n.b(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.l = null;
        this.m = i;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.n.e().getString(i));
        return this;
    }

    public void a(D d) {
        this.o = d;
        d.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a(w.a aVar) {
        if (aVar != null && aVar.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public androidx.core.b.a.b setActionView(int i) {
        Context e = this.n.e();
        setActionView(LayoutInflater.from(e).inflate(i, (ViewGroup) new LinearLayout(e), false));
        return this;
    }

    public void b() {
        this.n.c(this);
    }

    @Override // androidx.core.b.a.b
    public androidx.core.b.a.b b(CharSequence charSequence) {
        this.s = charSequence;
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b
    public MenuItem a(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b
    public MenuItem a(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // androidx.core.b.a.b
    public AbstractC0068b a() {
        return this.B;
    }

    @Override // androidx.core.b.a.b
    public androidx.core.b.a.b a(AbstractC0068b abstractC0068b) {
        AbstractC0068b abstractC0068b2 = this.B;
        if (abstractC0068b2 != null) {
            abstractC0068b2.f();
        }
        this.A = null;
        this.B = abstractC0068b;
        this.n.b(true);
        AbstractC0068b abstractC0068b3 = this.B;
        if (abstractC0068b3 != null) {
            abstractC0068b3.a(new o(this));
        }
        return this;
    }

    public void a(boolean z) {
        this.D = z;
        this.n.b(false);
    }

    @Override // androidx.core.b.a.b
    public androidx.core.b.a.b a(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }
}
