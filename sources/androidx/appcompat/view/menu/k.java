package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.w;
import java.util.ArrayList;
/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class k extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    l f180a;

    /* renamed from: b  reason: collision with root package name */
    private int f181b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public k(l lVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f180a = lVar;
        this.f = i;
        a();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public l b() {
        return this.f180a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<p> j = this.d ? this.f180a.j() : this.f180a.n();
        if (this.f181b < 0) {
            return j.size();
        }
        return j.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f180a.o() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        w.a aVar = (w.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    void a() {
        p f = this.f180a.f();
        if (f != null) {
            ArrayList<p> j = this.f180a.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) == f) {
                    this.f181b = i;
                    return;
                }
            }
        }
        this.f181b = -1;
    }

    @Override // android.widget.Adapter
    public p getItem(int i) {
        ArrayList<p> j = this.d ? this.f180a.j() : this.f180a.n();
        int i2 = this.f181b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return j.get(i);
    }
}
