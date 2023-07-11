package androidx.appcompat.d;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements l.a {
    private Context c;
    private ActionBarContextView d;
    private b.a e;
    private WeakReference<View> f;
    private boolean g;
    private boolean h;
    private l i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.c = context;
        this.d = actionBarContextView;
        this.e = aVar;
        l lVar = new l(actionBarContextView.getContext());
        lVar.c(1);
        this.i = lVar;
        this.i.a(this);
        this.h = z;
    }

    @Override // androidx.appcompat.d.b
    public void a(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.d.b
    public void b(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.d.b
    public Menu c() {
        return this.i;
    }

    @Override // androidx.appcompat.d.b
    public MenuInflater d() {
        return new g(this.d.getContext());
    }

    @Override // androidx.appcompat.d.b
    public CharSequence e() {
        return this.d.getSubtitle();
    }

    @Override // androidx.appcompat.d.b
    public CharSequence g() {
        return this.d.getTitle();
    }

    @Override // androidx.appcompat.d.b
    public void i() {
        this.e.b(this, this.i);
    }

    @Override // androidx.appcompat.d.b
    public boolean j() {
        return this.d.b();
    }

    @Override // androidx.appcompat.d.b
    public void a(int i) {
        a((CharSequence) this.c.getString(i));
    }

    @Override // androidx.appcompat.d.b
    public void b(int i) {
        b(this.c.getString(i));
    }

    @Override // androidx.appcompat.d.b
    public void a(boolean z) {
        super.a(z);
        this.d.setTitleOptional(z);
    }

    @Override // androidx.appcompat.d.b
    public View b() {
        WeakReference<View> weakReference = this.f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.d.b
    public void a(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.d.b
    public void a() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.d.sendAccessibilityEvent(32);
        this.e.a(this);
    }

    @Override // androidx.appcompat.view.menu.l.a
    public boolean a(l lVar, MenuItem menuItem) {
        return this.e.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.l.a
    public void a(l lVar) {
        i();
        this.d.d();
    }
}
