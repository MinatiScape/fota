package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.MenuPopupWindow;
/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
final class C extends s implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, v, View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f157b = R$layout.abc_popup_menu_item_layout;
    private final Context c;
    private final l d;
    private final k e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    final MenuPopupWindow j;
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private v.a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean v;
    final ViewTreeObserver.OnGlobalLayoutListener k = new A(this);
    private final View.OnAttachStateChangeListener l = new B(this);
    private int u = 0;

    public C(Context context, l lVar, View view, int i, int i2, boolean z) {
        this.c = context;
        this.d = lVar;
        this.f = z;
        this.e = new k(lVar, LayoutInflater.from(context), this.f, f157b);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new MenuPopupWindow(this.c, null, this.h, this.i);
        lVar.a(this, context);
    }

    private boolean c() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.j.setOnDismissListener(this);
        this.j.setOnItemClickListener(this);
        this.j.a(true);
        View view2 = this.o;
        boolean z = this.q == null;
        this.q = view2.getViewTreeObserver();
        if (z) {
            this.q.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.j.a(view2);
        this.j.c(this.u);
        if (!this.s) {
            this.t = s.a(this.e, null, this.c, this.g);
            this.s = true;
        }
        this.j.b(this.t);
        this.j.e(2);
        this.j.a(b());
        this.j.show();
        ListView listView = this.j.getListView();
        listView.setOnKeyListener(this);
        if (this.v && this.d.h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.d.h());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.j.a((ListAdapter) this.e);
        this.j.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(l lVar) {
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(boolean z) {
        this.e.a(z);
    }

    @Override // androidx.appcompat.view.menu.s
    public void b(int i) {
        this.j.d(i);
    }

    @Override // androidx.appcompat.view.menu.z
    public void dismiss() {
        if (isShowing()) {
            this.j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.z
    public ListView getListView() {
        return this.j.getListView();
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean isShowing() {
        return !this.r && this.j.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.v
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.s
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.z
    public void show() {
        if (!c()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public void updateMenuView(boolean z) {
        this.s = false;
        k kVar = this.e;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(int i) {
        this.u = i;
    }

    @Override // androidx.appcompat.view.menu.s
    public void b(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(v.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(D d) {
        if (d.hasVisibleItems()) {
            u uVar = new u(this.c, d, this.o, this.f, this.h, this.i);
            uVar.a(this.p);
            uVar.a(s.b(d));
            uVar.setOnDismissListener(this.m);
            this.m = null;
            this.d.a(false);
            int d2 = this.j.d();
            int e = this.j.e();
            if ((Gravity.getAbsoluteGravity(this.u, androidx.core.h.t.k(this.n)) & 7) == 5) {
                d2 += this.n.getWidth();
            }
            if (uVar.a(d2, e)) {
                v.a aVar = this.p;
                if (aVar != null) {
                    aVar.a(d);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(l lVar, boolean z) {
        if (lVar != this.d) {
            return;
        }
        dismiss();
        v.a aVar = this.p;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(View view) {
        this.n = view;
    }

    @Override // androidx.appcompat.view.menu.s
    public void c(int i) {
        this.j.h(i);
    }
}
