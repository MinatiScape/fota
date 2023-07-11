package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;
/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f1386a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f1387b = null;
    ValueAnimator c = null;
    private final Animator.AnimatorListener d = new o(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListAnimator.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f1388a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f1389b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f1388a = iArr;
            this.f1389b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c = null;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.f1386a.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f1386a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f1386a.get(i);
            if (StateSet.stateSetMatches(aVar.f1388a, iArr)) {
                break;
            }
            i++;
        }
        a aVar2 = this.f1387b;
        if (aVar == aVar2) {
            return;
        }
        if (aVar2 != null) {
            b();
        }
        this.f1387b = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    private void a(a aVar) {
        this.c = aVar.f1389b;
        this.c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.c = null;
        }
    }
}
