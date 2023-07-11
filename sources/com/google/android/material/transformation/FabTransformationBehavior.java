package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.R$id;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.circularreveal.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final Rect c;
    private final RectF d;
    private final RectF e;
    private final int[] f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public h f1440a;

        /* renamed from: b  reason: collision with root package name */
        public j f1441b;
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    @TargetApi(21)
    private void c(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float g = t.g(view2) - t.g(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-g);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -g);
        }
        aVar.f1440a.a("elevation").a((Animator) ofFloat);
        list.add(ofFloat);
    }

    private void d(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.e) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.e eVar = (com.google.android.material.circularreveal.e) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f1236a, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f1236a, 255);
            }
            ofInt.addUpdateListener(new d(this, view2));
            aVar.f1440a.a("iconFade").a((Animator) ofInt);
            list.add(ofInt);
            list2.add(new e(this, eVar, drawable));
        }
    }

    protected abstract a a(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            if (view2 instanceof FloatingActionButton) {
                int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
                return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
            }
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        a a2 = a(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.d;
        a(view, view2, z, z2, a2, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        d(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, width, height, arrayList, arrayList2);
        b(view, view2, z, z2, a2, arrayList, arrayList2);
        a(view, view2, z, z2, a2, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new c(this, z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout.d dVar) {
        if (dVar.h == 0) {
            dVar.h = 80;
        }
    }

    private float c(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f1244a & 7;
        if (i == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f = 0.0f;
            return f + jVar.f1245b;
        }
        f = centerX - centerX2;
        return f + jVar.f1245b;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i a2;
        i a3;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float c = c(view, view2, aVar.f1441b);
        float d = d(view, view2, aVar.f1441b);
        if (c == 0.0f || d == 0.0f) {
            a2 = aVar.f1440a.a("translationXLinear");
            a3 = aVar.f1440a.a("translationYLinear");
        } else if ((z && d < 0.0f) || (!z && d > 0.0f)) {
            a2 = aVar.f1440a.a("translationXCurveUpwards");
            a3 = aVar.f1440a.a("translationYCurveUpwards");
        } else {
            a2 = aVar.f1440a.a("translationXCurveDownwards");
            a3 = aVar.f1440a.a("translationYCurveDownwards");
        }
        i iVar = a2;
        i iVar2 = a3;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-c);
                view2.setTranslationY(-d);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            a(view2, aVar, iVar, iVar2, -c, -d, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -c);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -d);
        }
        iVar.a((Animator) ofFloat);
        iVar2.a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private float d(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f1244a & 112;
        if (i == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f = 0.0f;
            return f + jVar.c;
        }
        f = centerY - centerY2;
        return f + jVar.c;
    }

    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private void b(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof com.google.android.material.circularreveal.e) {
            com.google.android.material.circularreveal.e eVar = (com.google.android.material.circularreveal.e) view2;
            int b2 = b(view);
            int i = 16777215 & b2;
            if (z) {
                if (!z2) {
                    eVar.setCircularRevealScrimColor(b2);
                }
                ofInt = ObjectAnimator.ofInt(eVar, e.c.f1325a, i);
            } else {
                ofInt = ObjectAnimator.ofInt(eVar, e.c.f1325a, b2);
            }
            ofInt.setEvaluator(com.google.android.material.a.c.a());
            aVar.f1440a.a("color").a((Animator) ofInt);
            list.add(ofInt);
        }
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof com.google.android.material.circularreveal.e) {
            com.google.android.material.circularreveal.e eVar = (com.google.android.material.circularreveal.e) view2;
            float a2 = a(view, view2, aVar.f1441b);
            float b2 = b(view, view2, aVar.f1441b);
            ((FloatingActionButton) view).a(this.c);
            float width = this.c.width() / 2.0f;
            i a3 = aVar.f1440a.a("expansion");
            if (z) {
                if (!z2) {
                    eVar.setRevealInfo(new e.d(a2, b2, width));
                }
                if (z2) {
                    width = eVar.getRevealInfo().c;
                }
                animator = com.google.android.material.circularreveal.b.a(eVar, a2, b2, com.google.android.material.e.a.a(a2, b2, 0.0f, 0.0f, f, f2));
                animator.addListener(new f(this, eVar));
                a(view2, a3.a(), (int) a2, (int) b2, width, list);
            } else {
                float f3 = eVar.getRevealInfo().c;
                Animator a4 = com.google.android.material.circularreveal.b.a(eVar, a2, b2, width);
                int i = (int) a2;
                int i2 = (int) b2;
                a(view2, a3.a(), i, i2, f3, list);
                a(view2, a3.a(), a3.b(), aVar.f1440a.a(), i, i2, width, list);
                animator = a4;
            }
            a3.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.circularreveal.b.a(eVar));
        }
    }

    private float b(View view, View view2, j jVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int b(View view) {
        ColorStateList c = t.c(view);
        if (c != null) {
            return c.getColorForState(view.getDrawableState(), c.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.e) && com.google.android.material.circularreveal.c.f1320a == 0) || (a2 = a(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    com.google.android.material.a.d.f1235a.set(a2, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(a2, com.google.android.material.a.d.f1235a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(a2, com.google.android.material.a.d.f1235a, 0.0f);
            }
            aVar.f1440a.a("contentFade").a((Animator) ofFloat);
            list.add(ofFloat);
        }
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private float a(View view, View view2, j jVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f, float f2, float f3, float f4, RectF rectF) {
        float a2 = a(aVar, iVar, f, f3);
        float a3 = a(aVar, iVar2, f2, f4);
        Rect rect = this.c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.d;
        rectF2.set(rect);
        RectF rectF3 = this.e;
        a(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(a aVar, i iVar, float f, float f2) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i a3 = aVar.f1440a.a("expansion");
        return com.google.android.material.a.a.a(f, f2, iVar.c().getInterpolation(((float) (((a3.a() + a3.b()) + 17) - a2)) / ((float) b2)));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (findViewById != null) {
            return c(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return c(view);
        }
        return c(((ViewGroup) view).getChildAt(0));
    }

    private void a(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
