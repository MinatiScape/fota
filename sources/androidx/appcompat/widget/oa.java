package androidx.appcompat.widget;

import android.view.View;
/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
class oa extends androidx.core.h.B {

    /* renamed from: a  reason: collision with root package name */
    private boolean f347a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f348b;
    final /* synthetic */ pa c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public oa(pa paVar, int i) {
        this.c = paVar;
        this.f348b = i;
    }

    @Override // androidx.core.h.B, androidx.core.h.A
    public void a(View view) {
        this.f347a = true;
    }

    @Override // androidx.core.h.A
    public void b(View view) {
        if (this.f347a) {
            return;
        }
        this.c.f351a.setVisibility(this.f348b);
    }

    @Override // androidx.core.h.B, androidx.core.h.A
    public void c(View view) {
        this.c.f351a.setVisibility(0);
    }
}
