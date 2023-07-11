package androidx.transition;

import androidx.transition.C0106ca;
import java.util.ArrayList;
/* compiled from: TransitionManager.java */
/* renamed from: androidx.transition.ba  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0104ba extends C0102aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.b.b f946a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0106ca.a f947b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0104ba(C0106ca.a aVar, a.b.b bVar) {
        this.f947b = aVar;
        this.f946a = bVar;
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        ((ArrayList) this.f946a.get(this.f947b.f952b)).remove(transition);
    }
}
