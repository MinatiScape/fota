package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: androidx.appcompat.app.h  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0033h extends ArrayAdapter<CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f101a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController.a f102b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0033h(AlertController.a aVar, Context context, int i, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, i2, charSequenceArr);
        this.f102b = aVar;
        this.f101a = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f102b.F;
        if (zArr != null && zArr[i]) {
            this.f101a.setItemChecked(i, true);
        }
        return view2;
    }
}
