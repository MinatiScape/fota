package androidx.transition;
/* compiled from: TransitionSet.java */
/* renamed from: androidx.transition.ea  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0110ea extends C0102aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Transition f953a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TransitionSet f954b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0110ea(TransitionSet transitionSet, Transition transition) {
        this.f954b = transitionSet;
        this.f953a = transition;
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        this.f953a.o();
        transition.b(this);
    }
}
