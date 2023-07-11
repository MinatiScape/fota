package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.G;
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class r implements G.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f115a = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.G.a
    public void a(Rect rect) {
        rect.top = this.f115a.j(rect.top);
    }
}
