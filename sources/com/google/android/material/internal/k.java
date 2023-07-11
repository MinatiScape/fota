package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;
/* compiled from: NavigationMenuPresenter.java */
/* loaded from: classes.dex */
public class k implements v {

    /* renamed from: a  reason: collision with root package name */
    private NavigationMenuView f1378a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f1379b;
    private v.a c;
    androidx.appcompat.view.menu.l d;
    private int e;
    b f;
    LayoutInflater g;
    int h;
    boolean i;
    ColorStateList j;
    ColorStateList k;
    Drawable l;
    int m;
    int n;
    private int o;
    int p;
    final View.OnClickListener q = new com.google.android.material.internal.j(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.a<j> {
        private final ArrayList<d> c = new ArrayList<>();
        private androidx.appcompat.view.menu.p d;
        private boolean e;

        b() {
            g();
        }

        private void g() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.c.clear();
            this.c.add(new c());
            int size = k.this.d.n().size();
            int i = -1;
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                androidx.appcompat.view.menu.p pVar = k.this.d.n().get(i3);
                if (pVar.isChecked()) {
                    a(pVar);
                }
                if (pVar.isCheckable()) {
                    pVar.c(false);
                }
                if (pVar.hasSubMenu()) {
                    SubMenu subMenu = pVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.c.add(new e(k.this.p, 0));
                        }
                        this.c.add(new f(pVar));
                        int size2 = this.c.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i4 = 0; i4 < size3; i4++) {
                            androidx.appcompat.view.menu.p pVar2 = (androidx.appcompat.view.menu.p) subMenu.getItem(i4);
                            if (pVar2.isVisible()) {
                                if (!z2 && pVar2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (pVar2.isCheckable()) {
                                    pVar2.c(false);
                                }
                                if (pVar.isChecked()) {
                                    a(pVar);
                                }
                                this.c.add(new f(pVar2));
                            }
                        }
                        if (z2) {
                            a(size2, this.c.size());
                        }
                    }
                } else {
                    int groupId = pVar.getGroupId();
                    if (groupId != i) {
                        i2 = this.c.size();
                        boolean z3 = pVar.getIcon() != null;
                        if (i3 != 0) {
                            i2++;
                            ArrayList<d> arrayList = this.c;
                            int i5 = k.this.p;
                            arrayList.add(new e(i5, i5));
                        }
                        z = z3;
                    } else if (!z && pVar.getIcon() != null) {
                        a(i2, this.c.size());
                        z = true;
                    }
                    f fVar = new f(pVar);
                    fVar.f1383b = z;
                    this.c.add(fVar);
                    i = groupId;
                }
            }
            this.e = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int a() {
            return this.c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public long a(int i) {
            return i;
        }

        public androidx.appcompat.view.menu.p e() {
            return this.d;
        }

        public void f() {
            g();
            c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* renamed from: a */
        public void b(j jVar, int i) {
            int b2 = b(i);
            if (b2 != 0) {
                if (b2 == 1) {
                    ((TextView) jVar.f807b).setText(((f) this.c.get(i)).a().getTitle());
                    return;
                } else if (b2 != 2) {
                    return;
                } else {
                    e eVar = (e) this.c.get(i);
                    jVar.f807b.setPadding(0, eVar.b(), 0, eVar.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.f807b;
            navigationMenuItemView.setIconTintList(k.this.k);
            k kVar = k.this;
            if (kVar.i) {
                navigationMenuItemView.setTextAppearance(kVar.h);
            }
            ColorStateList colorStateList = k.this.j;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = k.this.l;
            androidx.core.h.t.a(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            f fVar = (f) this.c.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(fVar.f1383b);
            navigationMenuItemView.setHorizontalPadding(k.this.m);
            navigationMenuItemView.setIconPadding(k.this.n);
            navigationMenuItemView.a(fVar.a(), 0);
        }

        public Bundle d() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.p pVar = this.d;
            if (pVar != null) {
                bundle.putInt("android:menu:checked", pVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.c.get(i);
                if (dVar instanceof f) {
                    androidx.appcompat.view.menu.p a2 = ((f) dVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int b(int i) {
            d dVar = this.c.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public j b(ViewGroup viewGroup, int i) {
            if (i == 0) {
                k kVar = k.this;
                return new g(kVar.g, viewGroup, kVar.q);
            } else if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return new a(k.this.f1379b);
                }
                return new h(k.this.g, viewGroup);
            } else {
                return new i(k.this.g, viewGroup);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* renamed from: a */
        public void d(j jVar) {
            if (jVar instanceof g) {
                ((NavigationMenuItemView) jVar.f807b).a();
            }
        }

        private void a(int i, int i2) {
            while (i < i2) {
                ((f) this.c.get(i)).f1383b = true;
                i++;
            }
        }

        public void a(androidx.appcompat.view.menu.p pVar) {
            if (this.d == pVar || !pVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.p pVar2 = this.d;
            if (pVar2 != null) {
                pVar2.setChecked(false);
            }
            this.d = pVar;
            pVar.setChecked(true);
        }

        public void a(Bundle bundle) {
            androidx.appcompat.view.menu.p a2;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.p a3;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.e = true;
                int size = this.c.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.c.get(i2);
                    if ((dVar instanceof f) && (a3 = ((f) dVar).a()) != null && a3.getItemId() == i) {
                        a(a3);
                        break;
                    }
                    i2++;
                }
                this.e = false;
                g();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.c.get(i3);
                    if ((dVar2 instanceof f) && (a2 = ((f) dVar2).a()) != null && (actionView = a2.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a2.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void a(boolean z) {
            this.e = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class c implements d {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f1380a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1381b;

        public e(int i, int i2) {
            this.f1380a = i;
            this.f1381b = i2;
        }

        public int a() {
            return this.f1381b;
        }

        public int b() {
            return this.f1380a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class f implements d {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.appcompat.view.menu.p f1382a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1383b;

        f(androidx.appcompat.view.menu.p pVar) {
            this.f1382a = pVar;
        }

        public androidx.appcompat.view.menu.p a() {
            return this.f1382a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.f807b.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes.dex */
    private static abstract class j extends RecyclerView.v {
        public j(View view) {
            super(view);
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(Context context, androidx.appcompat.view.menu.l lVar) {
        this.g = LayoutInflater.from(context);
        this.d = lVar;
        this.p = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(D d2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(androidx.appcompat.view.menu.l lVar, androidx.appcompat.view.menu.p pVar) {
        return false;
    }

    public void b(int i2) {
        this.e = i2;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean b(androidx.appcompat.view.menu.l lVar, androidx.appcompat.view.menu.p pVar) {
        return false;
    }

    public Drawable c() {
        return this.l;
    }

    public int d() {
        return this.m;
    }

    public void e(int i2) {
        this.h = i2;
        this.i = true;
        updateMenuView(false);
    }

    public ColorStateList f() {
        return this.j;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean flagActionItems() {
        return false;
    }

    public ColorStateList g() {
        return this.k;
    }

    @Override // androidx.appcompat.view.menu.v
    public int getId() {
        return this.e;
    }

    @Override // androidx.appcompat.view.menu.v
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f1378a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f1379b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.f1378a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f1378a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.f;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.d());
        }
        if (this.f1379b != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f1379b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.v
    public void updateMenuView(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.f();
        }
    }

    public int b() {
        return this.f1379b.getChildCount();
    }

    public void c(int i2) {
        this.m = i2;
        updateMenuView(false);
    }

    public void d(int i2) {
        this.n = i2;
        updateMenuView(false);
    }

    public void b(ColorStateList colorStateList) {
        this.j = colorStateList;
        updateMenuView(false);
    }

    public int e() {
        return this.n;
    }

    public w a(ViewGroup viewGroup) {
        if (this.f1378a == null) {
            this.f1378a = (NavigationMenuView) this.g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            if (this.f == null) {
                this.f = new b();
            }
            this.f1379b = (LinearLayout) this.g.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.f1378a, false);
            this.f1378a.setAdapter(this.f);
        }
        return this.f1378a;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(androidx.appcompat.view.menu.l lVar, boolean z) {
        v.a aVar = this.c;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    public void a(androidx.appcompat.view.menu.p pVar) {
        this.f.a(pVar);
    }

    public androidx.appcompat.view.menu.p a() {
        return this.f.e();
    }

    public View a(int i2) {
        View inflate = this.g.inflate(i2, (ViewGroup) this.f1379b, false);
        a(inflate);
        return inflate;
    }

    public void a(View view) {
        this.f1379b.addView(view);
        NavigationMenuView navigationMenuView = this.f1378a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        updateMenuView(false);
    }

    public void a(Drawable drawable) {
        this.l = drawable;
        updateMenuView(false);
    }

    public void a(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void a(androidx.core.h.D d2) {
        int e2 = d2.e();
        if (this.o != e2) {
            this.o = e2;
            if (this.f1379b.getChildCount() == 0) {
                NavigationMenuView navigationMenuView = this.f1378a;
                navigationMenuView.setPadding(0, this.o, 0, navigationMenuView.getPaddingBottom());
            }
        }
        androidx.core.h.t.a(this.f1379b, d2);
    }
}
