package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.l;
import androidx.appcompat.view.menu.v;
/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
class m implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, v.a {

    /* renamed from: a  reason: collision with root package name */
    private l f184a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.appcompat.app.l f185b;
    j c;
    private v.a d;

    public m(l lVar) {
        this.f184a = lVar;
    }

    public void a(IBinder iBinder) {
        l lVar = this.f184a;
        l.a aVar = new l.a(lVar.e());
        this.c = new j(aVar.b(), R$layout.abc_list_menu_item_layout);
        this.c.a(this);
        this.f184a.a(this.c);
        aVar.a(this.c.a(), this);
        View i = lVar.i();
        if (i != null) {
            aVar.a(i);
        } else {
            aVar.a(lVar.g());
            aVar.a(lVar.h());
        }
        aVar.a(this);
        this.f185b = aVar.a();
        this.f185b.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f185b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f185b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f184a.a((p) this.c.a().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.c.a(this.f184a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f185b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f185b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f184a.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f184a.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        androidx.appcompat.app.l lVar = this.f185b;
        if (lVar != null) {
            lVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.v.a
    public void a(l lVar, boolean z) {
        if (z || lVar == this.f184a) {
            a();
        }
        v.a aVar = this.d;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.v.a
    public boolean a(l lVar) {
        v.a aVar = this.d;
        if (aVar != null) {
            return aVar.a(lVar);
        }
        return false;
    }
}
