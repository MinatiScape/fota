package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.ga;
import java.util.Map;
/* compiled from: TextScale.java */
/* loaded from: classes.dex */
public class r extends Transition {
    private void d(ga gaVar) {
        View view = gaVar.f960b;
        if (view instanceof TextView) {
            gaVar.f959a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void a(ga gaVar) {
        d(gaVar);
    }

    @Override // androidx.transition.Transition
    public void c(ga gaVar) {
        d(gaVar);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        if (gaVar == null || gaVar2 == null || !(gaVar.f960b instanceof TextView)) {
            return null;
        }
        View view = gaVar2.f960b;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Map<String, Object> map = gaVar.f959a;
            Map<String, Object> map2 = gaVar2.f959a;
            float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
            float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
            if (floatValue == floatValue2) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
            ofFloat.addUpdateListener(new q(this, textView));
            return ofFloat;
        }
        return null;
    }
}
