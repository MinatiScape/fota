package androidx.appcompat.widget;

import android.database.DataSetObserver;
/* compiled from: ActivityChooserView.java */
/* renamed from: androidx.appcompat.widget.j  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0051j extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0051j(ActivityChooserView activityChooserView) {
        this.f336a = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f336a.f208a.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f336a.f208a.notifyDataSetInvalidated();
    }
}
