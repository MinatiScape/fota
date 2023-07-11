package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.h.t;
import com.google.android.material.R$animator;
import com.google.android.material.R$color;
import com.google.android.material.a.g;
import com.google.android.material.a.h;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.p;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static final TimeInterpolator f1346a = com.google.android.material.a.a.c;

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1347b = {16842919, 16842910};
    static final int[] c = {16843623, 16842908, 16842910};
    static final int[] d = {16842908, 16842910};
    static final int[] e = {16843623, 16842910};
    static final int[] f = {16842910};
    static final int[] g = new int[0];
    private ArrayList<Animator.AnimatorListener> A;
    final VisibilityAwareImageButton B;
    final com.google.android.material.h.b C;
    private ViewTreeObserver.OnPreDrawListener H;
    Animator i;
    h j;
    h k;
    private h l;
    private h m;
    com.google.android.material.h.a o;
    private float p;
    Drawable q;
    Drawable r;
    com.google.android.material.internal.c s;
    Drawable t;
    float u;
    float v;
    float w;
    int x;
    private ArrayList<Animator.AnimatorListener> z;
    int h = 0;
    float y = 1.0f;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private final p n = new p();

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private class a extends f {
        a() {
            super(e.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.e.f
        protected float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private class b extends f {
        b() {
            super(e.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.e.f
        protected float a() {
            e eVar = e.this;
            return eVar.u + eVar.v;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private class c extends f {
        c() {
            super(e.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.e.f
        protected float a() {
            e eVar = e.this;
            return eVar.u + eVar.w;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void onShown();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: com.google.android.material.floatingactionbutton.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0025e extends f {
        C0025e() {
            super(e.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.e.f
        protected float a() {
            return e.this.u;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1348a;

        /* renamed from: b  reason: collision with root package name */
        private float f1349b;
        private float c;

        private f() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.o.b(this.c);
            this.f1348a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f1348a) {
                this.f1349b = e.this.o.b();
                this.c = a();
                this.f1348a = true;
            }
            com.google.android.material.h.a aVar = e.this.o;
            float f = this.f1349b;
            aVar.b(f + ((this.c - f) * valueAnimator.getAnimatedFraction()));
        }

        /* synthetic */ f(e eVar, com.google.android.material.floatingactionbutton.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(VisibilityAwareImageButton visibilityAwareImageButton, com.google.android.material.h.b bVar) {
        this.B = visibilityAwareImageButton;
        this.C = bVar;
        this.n.a(f1347b, a((f) new c()));
        this.n.a(c, a((f) new b()));
        this.n.a(d, a((f) new b()));
        this.n.a(e, a((f) new b()));
        this.n.a(f, a((f) new C0025e()));
        this.n.a(g, a((f) new a()));
        this.p = this.B.getRotation();
    }

    private void t() {
        if (this.H == null) {
            this.H = new com.google.android.material.floatingactionbutton.d(this);
        }
    }

    private h u() {
        if (this.m == null) {
            this.m = h.a(this.B.getContext(), R$animator.design_fab_hide_motion_spec);
        }
        return this.m;
    }

    private h v() {
        if (this.l == null) {
            this.l = h.a(this.B.getContext(), R$animator.design_fab_show_motion_spec);
        }
        return this.l;
    }

    private boolean w() {
        return t.z(this.B) && !this.B.isInEditMode();
    }

    private void x() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.p % 90.0f != 0.0f) {
                if (this.B.getLayerType() != 1) {
                    this.B.setLayerType(1, null);
                }
            } else if (this.B.getLayerType() != 0) {
                this.B.setLayerType(0, null);
            }
        }
        com.google.android.material.h.a aVar = this.o;
        if (aVar != null) {
            aVar.a(-this.p);
        }
        com.google.android.material.internal.c cVar = this.s;
        if (cVar != null) {
            cVar.b(-this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable[] drawableArr;
        this.q = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a(this.q, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.q, mode);
        }
        this.r = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a(this.r, com.google.android.material.g.a.a(colorStateList2));
        if (i > 0) {
            this.s = a(i, colorStateList);
            drawableArr = new Drawable[]{this.s, this.q, this.r};
        } else {
            this.s = null;
            drawableArr = new Drawable[]{this.q, this.r};
        }
        this.t = new LayerDrawable(drawableArr);
        Context context = this.B.getContext();
        Drawable drawable = this.t;
        float b2 = this.C.b();
        float f2 = this.u;
        this.o = new com.google.android.material.h.a(context, drawable, b2, f2, f2 + this.w);
        this.o.a(false);
        this.C.setBackgroundDrawable(this.o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, com.google.android.material.g.a.a(colorStateList));
        }
    }

    void b(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(float f2) {
        if (this.w != f2) {
            this.w = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h g() {
        return this.j;
    }

    boolean h() {
        return this.B.getVisibility() == 0 ? this.h == 1 : this.h != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.B.getVisibility() != 0 ? this.h == 2 : this.h != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.n.a();
    }

    com.google.android.material.internal.c k() {
        return new com.google.android.material.internal.c();
    }

    GradientDrawable l() {
        return new GradientDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        if (q()) {
            t();
            this.B.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.H != null) {
            this.B.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        float rotation = this.B.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            x();
        }
    }

    boolean q() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() {
        c(this.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s() {
        Rect rect = this.D;
        a(rect);
        b(rect);
        this.C.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    final void c(float f2) {
        this.y = f2;
        Matrix matrix = this.G;
        a(f2, matrix);
        this.B.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.v != f2) {
            this.v = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.z;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.A;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(h hVar) {
        this.j = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        if (this.z == null) {
            this.z = new ArrayList<>();
        }
        this.z.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar, boolean z) {
        if (i()) {
            return;
        }
        Animator animator = this.i;
        if (animator != null) {
            animator.cancel();
        }
        if (w()) {
            if (this.B.getVisibility() != 0) {
                this.B.setAlpha(0.0f);
                this.B.setScaleY(0.0f);
                this.B.setScaleX(0.0f);
                c(0.0f);
            }
            h hVar = this.j;
            if (hVar == null) {
                hVar = v();
            }
            AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
            a2.addListener(new com.google.android.material.floatingactionbutton.c(this, z, dVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.z;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.B.a(0, z);
        this.B.setAlpha(1.0f);
        this.B.setScaleY(1.0f);
        this.B.setScaleX(1.0f);
        c(1.0f);
        if (dVar != null) {
            dVar.onShown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        com.google.android.material.internal.c cVar = this.s;
        if (cVar != null) {
            cVar.a(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.u != f2) {
            this.u = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        if (this.x != i) {
            this.x = i;
            r();
        }
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.B.getDrawable();
        if (drawable == null || this.x == 0) {
            return;
        }
        RectF rectF = this.E;
        RectF rectF2 = this.F;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i = this.x;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.x;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable b() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(h hVar) {
        this.k = hVar;
    }

    void a(float f2, float f3, float f4) {
        com.google.android.material.h.a aVar = this.o;
        if (aVar != null) {
            aVar.a(f2, this.w + f2);
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.n.a(iArr);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar, boolean z) {
        if (h()) {
            return;
        }
        Animator animator = this.i;
        if (animator != null) {
            animator.cancel();
        }
        if (w()) {
            h hVar = this.k;
            if (hVar == null) {
                hVar = u();
            }
            AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
            a2.addListener(new com.google.android.material.floatingactionbutton.b(this, z, dVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.A;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.B.a(z ? 8 : 4, z);
        if (dVar != null) {
            dVar.a();
        }
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.B, View.ALPHA, f2);
        hVar.a("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.B, View.SCALE_X, f3);
        hVar.a("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.B, View.SCALE_Y, f3);
        hVar.a("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.G);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.B, new com.google.android.material.a.f(), new g(), new Matrix(this.G));
        hVar.a("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    void a(Rect rect) {
        this.o.getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.internal.c a(int i, ColorStateList colorStateList) {
        Context context = this.B.getContext();
        com.google.android.material.internal.c k = k();
        k.a(androidx.core.content.a.a(context, R$color.design_fab_stroke_top_outer_color), androidx.core.content.a.a(context, R$color.design_fab_stroke_top_inner_color), androidx.core.content.a.a(context, R$color.design_fab_stroke_end_inner_color), androidx.core.content.a.a(context, R$color.design_fab_stroke_end_outer_color));
        k.a(i);
        k.a(colorStateList);
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GradientDrawable a() {
        GradientDrawable l = l();
        l.setShape(1);
        l.setColor(-1);
        return l;
    }

    private ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f1346a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }
}
