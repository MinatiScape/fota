package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.i;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    private final i c;
    private final i d;

    public FabTransformationScrimBehavior() {
        this.c = new i(75L, 150L);
        this.d = new i(0L, 150L);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.b(coordinatorLayout, (CoordinatorLayout) view, motionEvent);
    }

    private void a(View view, boolean z, boolean z2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        i iVar = z ? this.c : this.d;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f);
        }
        iVar.a((Animator) ofFloat);
        list.add(ofFloat);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        a(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new g(this, z, view2));
        return animatorSet;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new i(75L, 150L);
        this.d = new i(0L, 150L);
    }
}
