package androidx.appcompat.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class la implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Toolbar f341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public la(Toolbar toolbar) {
        this.f341a = toolbar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f341a.c();
    }
}
