package androidx.core.content.a;

import androidx.core.content.a.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f448a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h.a f449b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h.a aVar, int i) {
        this.f449b = aVar;
        this.f448a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f449b.a(this.f448a);
    }
}
