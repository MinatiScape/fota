package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ActionMenuPresenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionMenuPresenter.java */
/* renamed from: androidx.appcompat.widget.g  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0048g extends H {
    final /* synthetic */ ActionMenuPresenter j;
    final /* synthetic */ ActionMenuPresenter.d k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0048g(ActionMenuPresenter.d dVar, View view, ActionMenuPresenter actionMenuPresenter) {
        super(view);
        this.k = dVar;
        this.j = actionMenuPresenter;
    }

    @Override // androidx.appcompat.widget.H
    public androidx.appcompat.view.menu.z a() {
        ActionMenuPresenter.e eVar = ActionMenuPresenter.this.z;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    @Override // androidx.appcompat.widget.H
    public boolean b() {
        ActionMenuPresenter.this.h();
        return true;
    }

    @Override // androidx.appcompat.widget.H
    public boolean c() {
        ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
        if (actionMenuPresenter.B != null) {
            return false;
        }
        actionMenuPresenter.d();
        return true;
    }
}
