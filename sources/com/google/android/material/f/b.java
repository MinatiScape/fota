package com.google.android.material.f;

import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.content.a.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextAppearance.java */
/* loaded from: classes.dex */
public class b extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextPaint f1330a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h.a f1331b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, TextPaint textPaint, h.a aVar) {
        this.c = cVar;
        this.f1330a = textPaint;
        this.f1331b = aVar;
    }

    @Override // androidx.core.content.a.h.a
    public void a(Typeface typeface) {
        c cVar = this.c;
        cVar.o = Typeface.create(typeface, cVar.e);
        this.c.a(this.f1330a, typeface);
        this.c.n = true;
        this.f1331b.a(typeface);
    }

    @Override // androidx.core.content.a.h.a
    public void a(int i) {
        this.c.a();
        this.c.n = true;
        this.f1331b.a(i);
    }
}
