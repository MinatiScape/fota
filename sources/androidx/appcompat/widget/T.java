package androidx.appcompat.widget;

import android.view.View;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class T implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(SearchView searchView) {
        this.f294a = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f294a.a();
    }
}
