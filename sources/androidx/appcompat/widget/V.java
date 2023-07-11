package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class V implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(SearchView searchView) {
        this.f301a = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        SearchView searchView = this.f301a;
        if (searchView.fa == null) {
            return false;
        }
        if (searchView.q.isPopupShowing() && this.f301a.q.getListSelection() != -1) {
            return this.f301a.a(view, i, keyEvent);
        }
        if (!this.f301a.q.a() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i == 66) {
            view.cancelLongPress();
            SearchView searchView2 = this.f301a;
            searchView2.a(0, (String) null, searchView2.q.getText().toString());
            return true;
        }
        return false;
    }
}
