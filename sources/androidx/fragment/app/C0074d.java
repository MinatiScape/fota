package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Fragment.java */
/* renamed from: androidx.fragment.app.d  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0074d extends AbstractC0078h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0074d(Fragment fragment) {
        this.f631a = fragment;
    }

    @Override // androidx.fragment.app.AbstractC0078h
    public View a(int i) {
        View view = this.f631a.K;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    @Override // androidx.fragment.app.AbstractC0078h
    public boolean a() {
        return this.f631a.K != null;
    }

    @Override // androidx.fragment.app.AbstractC0078h
    public Fragment a(Context context, String str, Bundle bundle) {
        return this.f631a.u.a(context, str, bundle);
    }
}
