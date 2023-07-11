package androidx.appcompat.widget;

import android.graphics.Typeface;
import androidx.core.content.a.h;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatTextHelper.java */
/* renamed from: androidx.appcompat.widget.z  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0066z extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WeakReference f373a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ A f374b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0066z(A a2, WeakReference weakReference) {
        this.f374b = a2;
        this.f373a = weakReference;
    }

    @Override // androidx.core.content.a.h.a
    public void a(int i) {
    }

    @Override // androidx.core.content.a.h.a
    public void a(Typeface typeface) {
        this.f374b.a(this.f373a, typeface);
    }
}
