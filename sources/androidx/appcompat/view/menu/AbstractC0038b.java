package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import java.util.ArrayList;
/* compiled from: BaseMenuPresenter.java */
/* renamed from: androidx.appcompat.view.menu.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0038b implements v {

    /* renamed from: a  reason: collision with root package name */
    protected Context f164a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f165b;
    protected l c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    private v.a f;
    private int g;
    private int h;
    protected w i;
    private int j;

    public AbstractC0038b(Context context, int i, int i2) {
        this.f164a = context;
        this.d = LayoutInflater.from(context);
        this.g = i;
        this.h = i2;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(Context context, l lVar) {
        this.f165b = context;
        this.e = LayoutInflater.from(this.f165b);
        this.c = lVar;
    }

    public abstract void a(p pVar, w.a aVar);

    public abstract boolean a(int i, p pVar);

    @Override // androidx.appcompat.view.menu.v
    public boolean a(l lVar, p pVar) {
        return false;
    }

    public w b(ViewGroup viewGroup) {
        if (this.i == null) {
            this.i = (w) this.d.inflate(this.g, viewGroup, false);
            this.i.a(this.c);
            updateMenuView(true);
        }
        return this.i;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean b(l lVar, p pVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.v
    public int getId() {
        return this.j;
    }

    @Override // androidx.appcompat.view.menu.v
    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return;
        }
        l lVar = this.c;
        int i = 0;
        if (lVar != null) {
            lVar.b();
            ArrayList<p> n = this.c.n();
            int size = n.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                p pVar = n.get(i3);
                if (a(i2, pVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    p itemData = childAt instanceof w.a ? ((w.a) childAt).getItemData() : null;
                    View a2 = a(pVar, childAt, viewGroup);
                    if (pVar != itemData) {
                        a2.setPressed(false);
                        a2.jumpDrawablesToCurrentState();
                    }
                    if (a2 != childAt) {
                        a(a2, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.i).addView(view, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(v.a aVar) {
        this.f = aVar;
    }

    public v.a a() {
        return this.f;
    }

    public w.a a(ViewGroup viewGroup) {
        return (w.a) this.d.inflate(this.h, viewGroup, false);
    }

    public View a(p pVar, View view, ViewGroup viewGroup) {
        w.a a2;
        if (view instanceof w.a) {
            a2 = (w.a) view;
        } else {
            a2 = a(viewGroup);
        }
        a(pVar, a2);
        return (View) a2;
    }

    @Override // androidx.appcompat.view.menu.v
    public void a(l lVar, boolean z) {
        v.a aVar = this.f;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(D d) {
        v.a aVar = this.f;
        if (aVar != null) {
            return aVar.a(d);
        }
        return false;
    }

    public void a(int i) {
        this.j = i;
    }
}
