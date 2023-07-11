package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroupOverlayApi14.java */
/* loaded from: classes.dex */
public class ja extends qa implements la {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ja(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ja a(ViewGroup viewGroup) {
        return (ja) qa.c(viewGroup);
    }

    @Override // androidx.transition.la
    public void b(View view) {
        this.f979a.b(view);
    }

    @Override // androidx.transition.la
    public void a(View view) {
        this.f979a.a(view);
    }
}
