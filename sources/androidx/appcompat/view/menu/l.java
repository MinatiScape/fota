package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.h.AbstractC0068b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class l implements androidx.core.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f182a = {1, 4, 5, 3, 2, 0};
    private boolean A;

    /* renamed from: b  reason: collision with root package name */
    private final Context f183b;
    private final Resources c;
    private boolean d;
    private boolean e;
    private a f;
    private ContextMenu.ContextMenuInfo n;
    CharSequence o;
    Drawable p;
    View q;
    private p y;
    private int m = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<p> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<v>> x = new CopyOnWriteArrayList<>();
    private boolean z = false;
    private ArrayList<p> g = new ArrayList<>();
    private ArrayList<p> h = new ArrayList<>();
    private boolean i = true;
    private ArrayList<p> j = new ArrayList<>();
    private ArrayList<p> k = new ArrayList<>();
    private boolean l = true;

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(l lVar);

        boolean a(l lVar, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(p pVar);
    }

    public l(Context context) {
        this.f183b = context;
        this.c = context.getResources();
        e(true);
    }

    private void d(boolean z) {
        if (this.x.isEmpty()) {
            return;
        }
        s();
        Iterator<WeakReference<v>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<v> next = it.next();
            v vVar = next.get();
            if (vVar == null) {
                this.x.remove(next);
            } else {
                vVar.updateMenuView(z);
            }
        }
        r();
    }

    private void e(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.x.isEmpty()) {
            return;
        }
        Iterator<WeakReference<v>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<v> next = it.next();
            v vVar = next.get();
            if (vVar == null) {
                this.x.remove(next);
            } else {
                int id = vVar.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    vVar.onRestoreInstanceState(parcelable);
                }
            }
        }
    }

    private void f(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (this.x.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<v>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<v> next = it.next();
            v vVar = next.get();
            if (vVar == null) {
                this.x.remove(next);
            } else {
                int id = vVar.getId();
                if (id > 0 && (onSaveInstanceState = vVar.onSaveInstanceState()) != null) {
                    sparseArray.put(id, onSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public void a(v vVar) {
        a(vVar, this.f183b);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f183b.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(v vVar) {
        Iterator<WeakReference<v>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<v> next = it.next();
            v vVar2 = next.get();
            if (vVar2 == null || vVar2 == vVar) {
                this.x.remove(next);
            }
        }
    }

    public l c(int i) {
        this.m = i;
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        p pVar = this.y;
        if (pVar != null) {
            a(pVar);
        }
        this.g.clear();
        b(true);
    }

    public void clearHeader() {
        this.p = null;
        this.o = null;
        this.q = null;
        b(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return "android:menu:actionviewstates";
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.g.get(i2);
            if (pVar.getItemId() == i) {
                return pVar;
            }
            if (pVar.hasSubMenu() && (findItem = pVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public Drawable g() {
        return this.p;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.g.get(i);
    }

    public CharSequence h() {
        return this.o;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.g.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public View i() {
        return this.q;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public ArrayList<p> j() {
        b();
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.u;
    }

    Resources l() {
        return this.c;
    }

    public l m() {
        return this;
    }

    public ArrayList<p> n() {
        if (this.i) {
            this.h.clear();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                p pVar = this.g.get(i);
                if (pVar.isVisible()) {
                    this.h.add(pVar);
                }
            }
            this.i = false;
            this.l = true;
            return this.h;
        }
        return this.h;
    }

    public boolean o() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.d;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        p a2 = a(i, keyEvent);
        boolean a3 = a2 != null ? a(a2, i2) : false;
        if ((i2 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    public boolean q() {
        return this.e;
    }

    public void r() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int a2 = a(i);
        if (a2 >= 0) {
            int size = this.g.size() - a2;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.g.get(a2).getGroupId() != i) {
                    break;
                }
                a(a2, false);
                i2 = i3;
            }
            b(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(b(i), true);
    }

    public void s() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.s = false;
        this.t = false;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.g.get(i2);
            if (pVar.getGroupId() == i) {
                pVar.c(z2);
                pVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.g.get(i2);
            if (pVar.getGroupId() == i) {
                pVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.g.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.g.get(i2);
            if (pVar.getGroupId() == i && pVar.e(z)) {
                z2 = true;
            }
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d = z;
        b(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.g.size();
    }

    public void a(v vVar, Context context) {
        this.x.add(new WeakReference<>(vVar));
        vVar.a(context, this);
        this.l = true;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.c.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.c.getString(i));
    }

    public void c(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((D) item.getSubMenu()).c(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(d(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        p pVar = (p) a(i, i2, i3, charSequence);
        D d = new D(this.f183b, this, pVar);
        pVar.a(d);
        return d;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.c.getString(i4));
    }

    public void b(Bundle bundle) {
        e(bundle);
    }

    private boolean a(D d, v vVar) {
        if (this.x.isEmpty()) {
            return false;
        }
        boolean a2 = vVar != null ? vVar.a(d) : false;
        Iterator<WeakReference<v>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<v> next = it.next();
            v vVar2 = next.get();
            if (vVar2 == null) {
                this.x.remove(next);
            } else if (!a2) {
                a2 = vVar2.a(d);
            }
        }
        return a2;
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.g.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.c.getString(i4));
    }

    public void b(boolean z) {
        if (!this.r) {
            if (z) {
                this.i = true;
                this.l = true;
            }
            d(z);
            return;
        }
        this.s = true;
        if (z) {
            this.t = true;
        }
    }

    public void d(Bundle bundle) {
        f(bundle);
    }

    private void e(boolean z) {
        boolean z2 = true;
        this.e = (z && this.c.getConfiguration().keyboard != 1 && androidx.core.h.u.c(ViewConfiguration.get(this.f183b), this.f183b)) ? false : false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(p pVar) {
        this.i = true;
        b(true);
    }

    private static int f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = f182a;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void a(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(d());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((D) item.getSubMenu()).a(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l d(int i) {
        a(0, null, i, null, null);
        return this;
    }

    public Context e() {
        return this.f183b;
    }

    public p f() {
        return this.y;
    }

    public void b() {
        ArrayList<p> n = n();
        if (this.l) {
            Iterator<WeakReference<v>> it = this.x.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<v> next = it.next();
                v vVar = next.get();
                if (vVar == null) {
                    this.x.remove(next);
                } else {
                    z |= vVar.flagActionItems();
                }
            }
            if (z) {
                this.j.clear();
                this.k.clear();
                int size = n.size();
                for (int i = 0; i < size; i++) {
                    p pVar = n.get(i);
                    if (pVar.l()) {
                        this.j.add(pVar);
                    } else {
                        this.k.add(pVar);
                    }
                }
            } else {
                this.j.clear();
                this.k.clear();
                this.k.addAll(n());
            }
            this.l = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(p pVar) {
        this.l = true;
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l e(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    public ArrayList<p> c() {
        b();
        return this.j;
    }

    public void c(boolean z) {
        this.A = z;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int f = f(i3);
        p a2 = a(i, i2, i3, f, charSequence, this.m);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.n;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<p> arrayList = this.g;
        arrayList.add(a(arrayList, f), a2);
        b(true);
        return a2;
    }

    private p a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new p(this, i, i2, i3, i4, charSequence, i5);
    }

    public boolean b(p pVar) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        s();
        Iterator<WeakReference<v>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<v> next = it.next();
            v vVar = next.get();
            if (vVar == null) {
                this.x.remove(next);
            } else {
                z = vVar.a(this, pVar);
                if (z) {
                    break;
                }
            }
        }
        r();
        if (z) {
            this.y = pVar;
        }
        return z;
    }

    private void a(int i, boolean z) {
        if (i < 0 || i >= this.g.size()) {
            return;
        }
        this.g.remove(i);
        if (z) {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.g.size();
        s();
        for (int i = 0; i < size; i++) {
            p pVar = this.g.get(i);
            if (pVar.getGroupId() == groupId && pVar.m() && pVar.isCheckable()) {
                pVar.b(pVar == menuItem);
            }
        }
        r();
    }

    public int a(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.g.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(l lVar, MenuItem menuItem) {
        a aVar = this.f;
        return aVar != null && aVar.a(lVar, menuItem);
    }

    public void a() {
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private static int a(ArrayList<p> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    void a(List<p> list, int i, KeyEvent keyEvent) {
        boolean p = p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = this.g.get(i2);
                if (pVar.hasSubMenu()) {
                    ((l) pVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = p ? pVar.getAlphabeticShortcut() : pVar.getNumericShortcut();
                if (((modifiers & 69647) == ((p ? pVar.c() : pVar.e()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (p && alphabeticShortcut == '\b' && i == 67)) && pVar.isEnabled()) {
                        list.add(pVar);
                    }
                }
            }
        }
    }

    p a(int i, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<p> arrayList = this.w;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean p = p();
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = arrayList.get(i2);
            if (p) {
                numericShortcut = pVar.getAlphabeticShortcut();
            } else {
                numericShortcut = pVar.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (p && numericShortcut == '\b' && i == 67))) {
                return pVar;
            }
        }
        return null;
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (v) null, i);
    }

    public boolean a(MenuItem menuItem, v vVar, int i) {
        p pVar = (p) menuItem;
        if (pVar == null || !pVar.isEnabled()) {
            return false;
        }
        boolean k = pVar.k();
        AbstractC0068b a2 = pVar.a();
        boolean z = a2 != null && a2.a();
        if (pVar.j()) {
            k |= pVar.expandActionView();
            if (k) {
                a(true);
            }
        } else if (pVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                a(false);
            }
            if (!pVar.hasSubMenu()) {
                pVar.a(new D(e(), this, pVar));
            }
            D d = (D) pVar.getSubMenu();
            if (z) {
                a2.a(d);
            }
            k |= a(d, vVar);
            if (!k) {
                a(true);
            }
        } else if ((i & 1) == 0) {
            a(true);
        }
        return k;
    }

    public final void a(boolean z) {
        if (this.v) {
            return;
        }
        this.v = true;
        Iterator<WeakReference<v>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<v> next = it.next();
            v vVar = next.get();
            if (vVar == null) {
                this.x.remove(next);
            } else {
                vVar.a(this, z);
            }
        }
        this.v = false;
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources l = l();
        if (view != null) {
            this.q = view;
            this.o = null;
            this.p = null;
        } else {
            if (i > 0) {
                this.o = l.getText(i);
            } else if (charSequence != null) {
                this.o = charSequence;
            }
            if (i2 > 0) {
                this.p = androidx.core.content.a.c(e(), i2);
            } else if (drawable != null) {
                this.p = drawable;
            }
            this.q = null;
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public boolean a(p pVar) {
        boolean z = false;
        if (!this.x.isEmpty() && this.y == pVar) {
            s();
            Iterator<WeakReference<v>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference<v> next = it.next();
                v vVar = next.get();
                if (vVar == null) {
                    this.x.remove(next);
                } else {
                    z = vVar.b(this, pVar);
                    if (z) {
                        break;
                    }
                }
            }
            r();
            if (z) {
                this.y = null;
            }
        }
        return z;
    }
}
