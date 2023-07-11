package androidx.appcompat.d;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.x;
import java.util.ArrayList;
/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f142a;

    /* renamed from: b  reason: collision with root package name */
    final b f143b;

    public f(Context context, b bVar) {
        this.f142a = context;
        this.f143b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f143b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f143b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return x.a(this.f142a, (androidx.core.b.a.a) this.f143b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f143b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f143b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f143b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f143b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f143b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f143b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f143b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f143b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f143b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f143b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f143b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f143b.a(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f143b.a(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f143b.b(i);
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f144a;

        /* renamed from: b  reason: collision with root package name */
        final Context f145b;
        final ArrayList<f> c = new ArrayList<>();
        final a.b.i<Menu, Menu> d = new a.b.i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f145b = context;
            this.f144a = callback;
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f144a.onCreateActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.d.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f144a.onPrepareActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f144a.onActionItemClicked(b(bVar), x.a(this.f145b, (androidx.core.b.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.c.get(i);
                if (fVar != null && fVar.f143b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f145b, bVar);
            this.c.add(fVar2);
            return fVar2;
        }

        @Override // androidx.appcompat.d.b.a
        public void a(b bVar) {
            this.f144a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 == null) {
                Menu a2 = x.a(this.f145b, (androidx.core.b.a.a) menu);
                this.d.put(menu, a2);
                return a2;
            }
            return menu2;
        }
    }
}
