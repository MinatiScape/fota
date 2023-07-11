package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
/* compiled from: MotionTiming.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f1242a;

    /* renamed from: b  reason: collision with root package name */
    private long f1243b;
    private TimeInterpolator c;
    private int d;
    private int e;

    public i(long j, long j2) {
        this.f1242a = 0L;
        this.f1243b = 300L;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f1242a = j;
        this.f1243b = j2;
    }

    public void a(Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long b() {
        return this.f1243b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : a.f1233b;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return a.c;
            }
            return interpolator instanceof DecelerateInterpolator ? a.d : interpolator;
        }
        return a.f1233b;
    }

    public long a() {
        return this.f1242a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.d = valueAnimator.getRepeatCount();
        iVar.e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f1242a = 0L;
        this.f1243b = 300L;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f1242a = j;
        this.f1243b = j2;
        this.c = timeInterpolator;
    }
}
