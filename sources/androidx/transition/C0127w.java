package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;
/* compiled from: FragmentTransitionSupport.java */
/* renamed from: androidx.transition.w  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0127w implements Transition.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f993a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f994b;
    final /* synthetic */ C0130z c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0127w(C0130z c0130z, View view, ArrayList arrayList) {
        this.c = c0130z;
        this.f993a = view;
        this.f994b = arrayList;
    }

    @Override // androidx.transition.Transition.c
    public void a(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void b(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void c(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        transition.b(this);
        this.f993a.setVisibility(8);
        int size = this.f994b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f994b.get(i)).setVisibility(0);
        }
    }
}
