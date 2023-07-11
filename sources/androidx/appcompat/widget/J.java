package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
class J implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListPopupWindow f259a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(ListPopupWindow listPopupWindow) {
        this.f259a = listPopupWindow;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        F f;
        if (i == -1 || (f = this.f259a.f) == null) {
            return;
        }
        f.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
