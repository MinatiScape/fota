package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import java.util.ArrayList;
/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class j implements v, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    Context f176a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f177b;
    l c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    private v.a h;
    a i;
    private int j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListMenuPresenter.java */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f178a = -1;

        public a() {
            a();
        }

        void a() {
            p f = j.this.c.f();
            if (f != null) {
                ArrayList<p> j = j.this.c.j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    if (j.get(i) == f) {
                        this.f178a = i;
                        return;
                    }
                }
            }
            this.f178a = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = j.this.c.j().size() - j.this.e;
            return this.f178a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                j jVar = j.this;
                view = jVar.f177b.inflate(jVar.g, viewGroup, false);
            }
            ((w.a) view).a(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public p getItem(int i) {
            ArrayList<p> j = j.this.c.j();
            int i2 = i + j.this.e;
            int i3 = this.f178a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return j.get(i2);
        }
    }

    public j(Context context, int i) {
        this(i, 0);
        this.f176a = context;
        this.f177b = LayoutInflater.from(this.f176a);
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(Context context, l lVar) {
        int i = this.f;
        if (i != 0) {
            this.f176a = new ContextThemeWrapper(context, i);
            this.f177b = LayoutInflater.from(this.f176a);
        } else if (this.f176a != null) {
            this.f176a = context;
            if (this.f177b == null) {
                this.f177b = LayoutInflater.from(this.f176a);
            }
        }
        this.c = lVar;
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(l lVar, p pVar) {
        return false;
    }

    public void b(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean b(l lVar, p pVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public int getId() {
        return this.j;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.i.getItem(i), this, 0);
    }

    @Override // androidx.appcompat.view.menu.v
    public void onRestoreInstanceState(Parcelable parcelable) {
        a((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.v
    public Parcelable onSaveInstanceState() {
        if (this.d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        b(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.v
    public void updateMenuView(boolean z) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public j(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    public w a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.f177b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.i == null) {
                this.i = new a();
            }
            this.d.setAdapter((ListAdapter) this.i);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(v.a aVar) {
        this.h = aVar;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(D d) {
        if (d.hasVisibleItems()) {
            new m(d).a((IBinder) null);
            v.a aVar = this.h;
            if (aVar != null) {
                aVar.a(d);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(l lVar, boolean z) {
        v.a aVar = this.h;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    public void a(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }
}
