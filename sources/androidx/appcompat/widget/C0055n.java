package androidx.appcompat.widget;

import android.database.DataSetObserver;
/* compiled from: ActivityChooserView.java */
/* renamed from: androidx.appcompat.widget.n  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0055n extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0055n(ActivityChooserView activityChooserView) {
        this.f342a = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f342a.d();
    }
}
