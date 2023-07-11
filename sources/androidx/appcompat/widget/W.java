package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class W implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(SearchView searchView) {
        this.f304a = searchView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f304a.f();
        return true;
    }
}
