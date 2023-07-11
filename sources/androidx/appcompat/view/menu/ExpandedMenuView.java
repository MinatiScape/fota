package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ia;
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements l.b, w, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f158a = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private l f159b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    @Override // androidx.appcompat.view.menu.w
    public void a(l lVar) {
        this.f159b = lVar;
    }

    public int getWindowAnimations() {
        return this.c;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((p) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ia a2 = ia.a(context, attributeSet, f158a, i, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.b(0));
        }
        if (a2.g(1)) {
            setDivider(a2.b(1));
        }
        a2.a();
    }

    @Override // androidx.appcompat.view.menu.l.b
    public boolean a(p pVar) {
        return this.f159b.a(pVar, 0);
    }
}
