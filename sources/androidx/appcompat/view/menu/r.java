package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.q;
import androidx.core.h.AbstractC0068b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MenuItemWrapperJB.java */
/* loaded from: classes.dex */
public class r extends q {

    /* compiled from: MenuItemWrapperJB.java */
    /* loaded from: classes.dex */
    class a extends q.a implements ActionProvider.VisibilityListener {
        AbstractC0068b.InterfaceC0015b f;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.h.AbstractC0068b
        public View a(MenuItem menuItem) {
            return this.d.onCreateActionView(menuItem);
        }

        @Override // androidx.core.h.AbstractC0068b
        public boolean b() {
            return this.d.isVisible();
        }

        @Override // androidx.core.h.AbstractC0068b
        public boolean e() {
            return this.d.overridesItemVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            AbstractC0068b.InterfaceC0015b interfaceC0015b = this.f;
            if (interfaceC0015b != null) {
                interfaceC0015b.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // androidx.core.h.AbstractC0068b
        public void a(AbstractC0068b.InterfaceC0015b interfaceC0015b) {
            this.f = interfaceC0015b;
            this.d.setVisibilityListener(interfaceC0015b != null ? this : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context, androidx.core.b.a.b bVar) {
        super(context, bVar);
    }

    @Override // androidx.appcompat.view.menu.q
    q.a a(ActionProvider actionProvider) {
        return new a(this.f166b, actionProvider);
    }
}
