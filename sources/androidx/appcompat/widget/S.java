package androidx.appcompat.widget;

import android.view.View;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class S implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f279a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(SearchView searchView) {
        this.f279a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        SearchView searchView = this.f279a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.M;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z);
        }
    }
}
