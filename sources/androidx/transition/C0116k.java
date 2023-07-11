package androidx.transition;

import android.view.ViewGroup;
/* compiled from: ChangeBounds.java */
/* renamed from: androidx.transition.k  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0116k extends C0102aa {

    /* renamed from: a  reason: collision with root package name */
    boolean f969a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewGroup f970b;
    final /* synthetic */ ChangeBounds c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0116k(ChangeBounds changeBounds, ViewGroup viewGroup) {
        this.c = changeBounds;
        this.f970b = viewGroup;
    }

    @Override // androidx.transition.C0102aa, androidx.transition.Transition.c
    public void a(Transition transition) {
        ma.a(this.f970b, true);
    }

    @Override // androidx.transition.C0102aa, androidx.transition.Transition.c
    public void c(Transition transition) {
        ma.a(this.f970b, false);
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        if (!this.f969a) {
            ma.a(this.f970b, false);
        }
        transition.b(this);
    }
}
