package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {
    private final int P;
    private final com.google.android.material.i.c Q;
    private final i R;
    private Animator S;
    private Animator T;
    private Animator U;
    private int V;
    private boolean W;
    private boolean aa;
    AnimatorListenerAdapter ba;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new h();
        int c;
        boolean d;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(Context context) {
        this(context, null, 0);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private float getFabTranslationX() {
        return c(this.V);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return a(this.aa);
    }

    private void s() {
        Animator animator = this.S;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.U;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.T;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton t() {
        if (getParent() instanceof CoordinatorLayout) {
            for (View view : ((CoordinatorLayout) getParent()).c(this)) {
                if (view instanceof FloatingActionButton) {
                    return (FloatingActionButton) view;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.S;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.U) != null && animator.isRunning()) || ((animator2 = this.T) != null && animator2.isRunning());
    }

    private boolean v() {
        FloatingActionButton t = t();
        return t != null && t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.R.e(getFabTranslationX());
        FloatingActionButton t = t();
        this.Q.a((this.aa && v()) ? 1.0f : 0.0f);
        if (t != null) {
            t.setTranslationY(getFabTranslationY());
            t.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!v()) {
                a(actionMenuView, 0, false);
            } else {
                a(actionMenuView, this.V, this.aa);
            }
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.Q.b();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        return this.R.a();
    }

    public int getFabAlignmentMode() {
        return this.V;
    }

    public float getFabCradleMargin() {
        return this.R.b();
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.R.c();
    }

    public boolean getHideOnScroll() {
        return this.W;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        s();
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.V = savedState.c;
        this.aa = savedState.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.V;
        savedState.d = this.aa;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a(this.Q, colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            this.R.a(f);
            this.Q.invalidateSelf();
        }
    }

    public void setFabAlignmentMode(int i) {
        d(i);
        a(i, this.aa);
        this.V = i;
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            this.R.b(f);
            this.Q.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.R.c(f);
            this.Q.invalidateSelf();
        }
    }

    void setFabDiameter(int i) {
        float f = i;
        if (f != this.R.d()) {
            this.R.d(f);
            this.Q.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.W = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect d;

        public Behavior() {
            this.d = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.d = new Rect();
        }

        private boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void b(BottomAppBar bottomAppBar) {
            super.b((Behavior) bottomAppBar);
            FloatingActionButton t = bottomAppBar.t();
            if (t != null) {
                t.clearAnimation();
                t.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(com.google.android.material.a.a.d).setDuration(225L);
            }
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton t = bottomAppBar.t();
            if (t != null) {
                a(t, bottomAppBar);
                t.b(this.d);
                bottomAppBar.setFabDiameter(this.d.height());
            }
            if (!bottomAppBar.u()) {
                bottomAppBar.w();
            }
            coordinatorLayout.c(bottomAppBar, i);
            return super.a(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.b(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void a(BottomAppBar bottomAppBar) {
            super.a((Behavior) bottomAppBar);
            FloatingActionButton t = bottomAppBar.t();
            if (t != null) {
                t.a(this.d);
                t.clearAnimation();
                t.animate().translationY((-t.getPaddingBottom()) + (t.getMeasuredHeight() - this.d.height())).setInterpolator(com.google.android.material.a.a.c).setDuration(175L);
            }
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    private void d(int i) {
        if (this.V == i || !t.z(this)) {
            return;
        }
        Animator animator = this.T;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        a(i, arrayList);
        b(i, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.T = animatorSet;
        this.T.addListener(new a(this));
        this.T.start();
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aa = true;
        this.ba = new g(this);
        TypedArray a2 = s.a(context, attributeSet, R$styleable.BottomAppBar, i, R$style.Widget_MaterialComponents_BottomAppBar, new int[0]);
        ColorStateList a3 = com.google.android.material.f.a.a(context, a2, R$styleable.BottomAppBar_backgroundTint);
        this.V = a2.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.W = a2.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        a2.recycle();
        this.P = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.R = new i(a2.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0), a2.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0), a2.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0));
        com.google.android.material.i.e eVar = new com.google.android.material.i.e();
        eVar.a(this.R);
        this.Q = new com.google.android.material.i.c(eVar);
        this.Q.a(true);
        this.Q.a(Paint.Style.FILL);
        androidx.core.graphics.drawable.a.a(this.Q, a3);
        t.a(this, this.Q);
    }

    private void b(int i, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(t(), "translationX", c(i));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private int c(int i) {
        boolean z = t.k(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.P) * (z ? -1 : 1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (t.z(this)) {
            Animator animator = this.S;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            a(z && v(), arrayList);
            b(z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.S = animatorSet;
            this.S.addListener(new e(this));
            this.S.start();
        }
    }

    private void a(int i, List<Animator> list) {
        if (this.aa) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.R.e(), c(i));
            ofFloat.addUpdateListener(new b(this));
            ofFloat.setDuration(300L);
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        if (t.z(this)) {
            Animator animator = this.U;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!v()) {
                i = 0;
                z = false;
            }
            a(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.U = animatorSet;
            this.U.addListener(new c(this));
            this.U.start();
        }
    }

    private void b(boolean z, List<Animator> list) {
        FloatingActionButton t = t();
        if (t == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(t, "translationY", a(z));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.c(this.ba);
        floatingActionButton.d(this.ba);
    }

    private void a(int i, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.aa && (!z || !v())) || (this.V != 1 && i != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
                return;
            }
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
        ofFloat2.addListener(new d(this, actionMenuView, i, z));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.playSequentially(ofFloat2, ofFloat);
        list.add(animatorSet);
    }

    private void a(boolean z, List<Animator> list) {
        if (z) {
            this.R.e(getFabTranslationX());
        }
        float[] fArr = new float[2];
        fArr[0] = this.Q.a();
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.addUpdateListener(new f(this));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private float a(boolean z) {
        FloatingActionButton t = t();
        if (t == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        t.a(rect);
        float height = rect.height();
        if (height == 0.0f) {
            height = t.getMeasuredHeight();
        }
        float height2 = t.getHeight() - rect.height();
        float height3 = (-getCradleVerticalOffset()) + (height / 2.0f) + (t.getHeight() - rect.bottom);
        float paddingBottom = height2 - t.getPaddingBottom();
        float f = -getMeasuredHeight();
        if (z) {
            paddingBottom = height3;
        }
        return f + paddingBottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = t.k(this) == 1;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f48a & 8388615) == 8388611) {
                i2 = Math.max(i2, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i == 1 && z) ? i2 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.a(this.ba);
        floatingActionButton.b(this.ba);
    }
}
