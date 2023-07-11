package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.k  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0036k implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f107a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController f108b;
    final /* synthetic */ AlertController.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0036k(AlertController.a aVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.c = aVar;
        this.f107a = recycleListView;
        this.f108b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.c.F;
        if (zArr != null) {
            zArr[i] = this.f107a.isItemChecked(i);
        }
        this.c.J.onClick(this.f108b.f50b, i, this.f107a.isItemChecked(i));
    }
}
