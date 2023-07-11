package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class O implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(SearchView searchView) {
        this.f276a = searchView;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f276a.b(charSequence);
    }
}
