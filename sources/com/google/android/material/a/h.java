package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MotionSpec.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final a.b.i<String, i> f1241a = new a.b.i<>();

    public i a(String str) {
        if (b(str)) {
            return this.f1241a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean b(String str) {
        return this.f1241a.get(str) != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f1241a.equals(((h) obj).f1241a);
    }

    public int hashCode() {
        return this.f1241a.hashCode();
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f1241a + "}\n";
    }

    public void a(String str, i iVar) {
        this.f1241a.put(str, iVar);
    }

    public long a() {
        int size = this.f1241a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i d = this.f1241a.d(i);
            j = Math.max(j, d.a() + d.b());
        }
        return j;
    }

    public static h a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return a(context, resourceId);
    }

    public static h a(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return a(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loadAnimator);
                return a(arrayList);
            }
            return null;
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    private static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(hVar, list.get(i));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }
}
