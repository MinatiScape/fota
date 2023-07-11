package androidx.appcompat.widget;

import android.view.View;
/* compiled from: ActionBarContextView.java */
/* renamed from: androidx.appcompat.widget.c  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class View$OnClickListenerC0044c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ androidx.appcompat.d.b f315a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ActionBarContextView f316b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC0044c(ActionBarContextView actionBarContextView, androidx.appcompat.d.b bVar) {
        this.f316b = actionBarContextView;
        this.f315a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f315a.a();
    }
}
