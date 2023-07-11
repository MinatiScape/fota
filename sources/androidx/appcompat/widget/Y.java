package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class Y implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(SearchView searchView) {
        this.f306a = searchView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f306a.d(i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
