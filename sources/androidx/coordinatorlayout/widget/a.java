package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.h.D;
import androidx.core.h.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoordinatorLayout.java */
/* loaded from: classes.dex */
public class a implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f392a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CoordinatorLayout coordinatorLayout) {
        this.f392a = coordinatorLayout;
    }

    @Override // androidx.core.h.o
    public D a(View view, D d) {
        return this.f392a.a(d);
    }
}
