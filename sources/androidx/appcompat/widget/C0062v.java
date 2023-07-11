package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatSpinner.java */
/* renamed from: androidx.appcompat.widget.v  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0062v extends H {
    final /* synthetic */ AppCompatSpinner.b j;
    final /* synthetic */ AppCompatSpinner k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0062v(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner.b bVar) {
        super(view);
        this.k = appCompatSpinner;
        this.j = bVar;
    }

    @Override // androidx.appcompat.widget.H
    public androidx.appcompat.view.menu.z a() {
        return this.j;
    }

    @Override // androidx.appcompat.widget.H
    public boolean b() {
        if (this.k.mPopup.isShowing()) {
            return true;
        }
        this.k.mPopup.show();
        return true;
    }
}
