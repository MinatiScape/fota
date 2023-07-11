package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.K;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.h.C0069c;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
final class i extends s implements v, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f173b = R$layout.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;
    private final Context c;
    private final int d;
    private final int e;
    private final int f;
    private final boolean g;
    final Handler h;
    private View p;
    View q;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean x;
    private v.a y;
    ViewTreeObserver z;
    private final List<l> i = new ArrayList();
    final List<a> j = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener k = new ViewTreeObserver$OnGlobalLayoutListenerC0041e(this);
    private final View.OnAttachStateChangeListener l = new f(this);
    private final K m = new h(this);
    private int n = 0;
    private int o = 0;
    private boolean w = false;
    private int r = d();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f174a;

        /* renamed from: b  reason: collision with root package name */
        public final l f175b;
        public final int c;

        public a(MenuPopupWindow menuPopupWindow, l lVar, int i) {
            this.f174a = menuPopupWindow;
            this.f175b = lVar;
            this.c = i;
        }

        public ListView a() {
            return this.f174a.getListView();
        }
    }

    public i(Context context, View view, int i, int i2, boolean z) {
        this.c = context;
        this.p = view;
        this.e = i;
        this.f = i2;
        this.g = z;
        Resources resources = context.getResources();
        this.d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    private MenuPopupWindow c() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.c, null, this.e, this.f);
        menuPopupWindow.a(this.m);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.a(this.p);
        menuPopupWindow.c(this.o);
        menuPopupWindow.a(true);
        menuPopupWindow.e(2);
        return menuPopupWindow;
    }

    private int d() {
        return androidx.core.h.t.k(this.p) == 1 ? 0 : 1;
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(boolean z) {
        this.w = z;
    }

    @Override // androidx.appcompat.view.menu.s
    protected boolean a() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.s
    public void b(int i) {
        this.s = true;
        this.u = i;
    }

    @Override // androidx.appcompat.view.menu.z
    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.j.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.f174a.isShowing()) {
                    aVar.f174a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.z
    public ListView getListView() {
        if (this.j.isEmpty()) {
            return null;
        }
        List<a> list = this.j;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.z
    public boolean isShowing() {
        return this.j.size() > 0 && this.j.get(0).f174a.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.j.get(i);
            if (!aVar.f174a.isShowing()) {
                break;
            }
            i++;
        }
        if (aVar != null) {
            aVar.f175b.a(false);
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
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.z
    public void show() {
        if (isShowing()) {
            return;
        }
        for (l lVar : this.i) {
            d(lVar);
        }
        this.i.clear();
        this.q = this.p;
        if (this.q != null) {
            boolean z = this.z == null;
            this.z = this.q.getViewTreeObserver();
            if (z) {
                this.z.addOnGlobalLayoutListener(this.k);
            }
            this.q.addOnAttachStateChangeListener(this.l);
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public void updateMenuView(boolean z) {
        for (a aVar : this.j) {
            s.a(aVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    private int d(int i) {
        List<a> list = this.j;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        return this.r == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(l lVar) {
        lVar.a(this, this.c);
        if (isShowing()) {
            d(lVar);
        } else {
            this.i.add(lVar);
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public void b(boolean z) {
        this.x = z;
    }

    private MenuItem a(l lVar, l lVar2) {
        int size = lVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = lVar.getItem(i);
            if (item.hasSubMenu() && lVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, l lVar) {
        k kVar;
        int i;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.f175b, lVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            kVar = (k) headerViewListAdapter.getWrappedAdapter();
        } else {
            kVar = (k) adapter;
            i = 0;
        }
        int count = kVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a2 == kVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int c(l lVar) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (lVar == this.j.get(i).f175b) {
                return i;
            }
        }
        return -1;
    }

    private void d(l lVar) {
        a aVar;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.c);
        k kVar = new k(lVar, from, this.g, f173b);
        if (!isShowing() && this.w) {
            kVar.a(true);
        } else if (isShowing()) {
            kVar.a(s.b(lVar));
        }
        int a2 = s.a(kVar, null, this.c, this.d);
        MenuPopupWindow c = c();
        c.a((ListAdapter) kVar);
        c.b(a2);
        c.c(this.o);
        if (this.j.size() > 0) {
            List<a> list = this.j;
            aVar = list.get(list.size() - 1);
            view = a(aVar, lVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            c.c(false);
            c.a((Object) null);
            int d = d(a2);
            boolean z = d == 1;
            this.r = d;
            if (Build.VERSION.SDK_INT >= 26) {
                c.a(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i3 = i - a2;
                }
                i3 = i + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i3 = i + a2;
                }
                i3 = i - a2;
            }
            c.d(i3);
            c.b(true);
            c.h(i2);
        } else {
            if (this.s) {
                c.d(this.u);
            }
            if (this.t) {
                c.h(this.v);
            }
            c.a(b());
        }
        this.j.add(new a(c, lVar, this.r));
        c.show();
        ListView listView = c.getListView();
        listView.setOnKeyListener(this);
        if (aVar == null && this.x && lVar.h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(lVar.h());
            listView.addHeaderView(frameLayout, null, false);
            c.show();
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public void c(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(v.a aVar) {
        this.y = aVar;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(D d) {
        for (a aVar : this.j) {
            if (d == aVar.f175b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (d.hasVisibleItems()) {
            a((l) d);
            v.a aVar2 = this.y;
            if (aVar2 != null) {
                aVar2.a(d);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(l lVar, boolean z) {
        int c = c(lVar);
        if (c < 0) {
            return;
        }
        int i = c + 1;
        if (i < this.j.size()) {
            this.j.get(i).f175b.a(false);
        }
        a remove = this.j.remove(c);
        remove.f175b.b(this);
        if (this.B) {
            remove.f174a.b((Object) null);
            remove.f174a.a(0);
        }
        remove.f174a.dismiss();
        int size = this.j.size();
        if (size > 0) {
            this.r = this.j.get(size - 1).c;
        } else {
            this.r = d();
        }
        if (size != 0) {
            if (z) {
                this.j.get(0).f175b.a(false);
                return;
            }
            return;
        }
        dismiss();
        v.a aVar = this.y;
        if (aVar != null) {
            aVar.a(lVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.z.removeGlobalOnLayoutListener(this.k);
            }
            this.z = null;
        }
        this.q.removeOnAttachStateChangeListener(this.l);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = C0069c.a(i, androidx.core.h.t.k(this.p));
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = C0069c.a(this.n, androidx.core.h.t.k(this.p));
        }
    }
}
