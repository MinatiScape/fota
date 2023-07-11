package androidx.transition;

import android.view.View;
/* compiled from: Fade.java */
/* renamed from: androidx.transition.t  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0124t extends C0102aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f986a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fade f987b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0124t(Fade fade, View view) {
        this.f987b = fade;
        this.f986a = view;
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        va.a(this.f986a, 1.0f);
        va.a(this.f986a);
        transition.b(this);
    }
}
