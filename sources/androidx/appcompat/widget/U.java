package androidx.appcompat.widget;

import android.view.View;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class U implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(SearchView searchView) {
        this.f300a = searchView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchView searchView = this.f300a;
        if (view == searchView.u) {
            searchView.e();
        } else if (view == searchView.w) {
            searchView.d();
        } else if (view == searchView.v) {
            searchView.f();
        } else if (view == searchView.x) {
            searchView.h();
        } else if (view == searchView.q) {
            searchView.b();
        }
    }
}
