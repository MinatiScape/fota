package androidx.core.h;

import android.view.View;
import android.view.WindowInsets;
/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
class s implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.f535a = oVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return (WindowInsets) D.a(this.f535a.a(view, D.a(windowInsets)));
    }
}
