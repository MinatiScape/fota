package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.j  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0035j implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController f105a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController.a f106b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0035j(AlertController.a aVar, AlertController alertController) {
        this.f106b = aVar;
        this.f105a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f106b.x.onClick(this.f105a.f50b, i);
        if (this.f106b.H) {
            return;
        }
        this.f105a.f50b.dismiss();
    }
}
