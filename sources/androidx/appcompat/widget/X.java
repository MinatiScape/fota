package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class X implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f305a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(SearchView searchView) {
        this.f305a = searchView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f305a.a(i, 0, (String) null);
    }
}
