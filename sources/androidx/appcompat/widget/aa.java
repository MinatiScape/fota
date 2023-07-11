package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;
/* compiled from: SearchView.java */
/* loaded from: classes.dex */
class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView.SearchAutoComplete f311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f311a = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f311a.b();
    }
}
