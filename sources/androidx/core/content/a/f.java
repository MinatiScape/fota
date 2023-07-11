package androidx.core.content.a;

import android.graphics.Typeface;
import androidx.core.content.a.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Typeface f446a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h.a f447b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h.a aVar, Typeface typeface) {
        this.f447b = aVar;
        this.f446a = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f447b.a(this.f446a);
    }
}
