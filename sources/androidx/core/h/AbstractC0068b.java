package androidx.core.h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: ActionProvider.java */
/* renamed from: androidx.core.h.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0068b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f524a;

    /* renamed from: b  reason: collision with root package name */
    private a f525b;
    private InterfaceC0015b c;

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.h.b$a */
    /* loaded from: classes.dex */
    public interface a {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0015b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public AbstractC0068b(Context context) {
        this.f524a = context;
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public void a(SubMenu subMenu) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.c = null;
        this.f525b = null;
    }

    public void a(boolean z) {
        a aVar = this.f525b;
        if (aVar != null) {
            aVar.onSubUiVisibilityChanged(z);
        }
    }

    public void a(a aVar) {
        this.f525b = aVar;
    }

    public void a(InterfaceC0015b interfaceC0015b) {
        if (this.c != null && interfaceC0015b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = interfaceC0015b;
    }
}
