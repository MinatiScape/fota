package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ChangeTransform extends Transition {
    private static final String[] K = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<b, float[]> L = new C0121p(float[].class, "nonTranslations");
    private static final Property<b, PointF> M = new C0122q(PointF.class, "translations");
    private static final boolean N;
    boolean O;
    private boolean P;
    private Matrix Q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends C0102aa {

        /* renamed from: a  reason: collision with root package name */
        private View f909a;

        /* renamed from: b  reason: collision with root package name */
        private D f910b;

        a(View view, D d) {
            this.f909a = view;
            this.f910b = d;
        }

        @Override // androidx.transition.C0102aa, androidx.transition.Transition.c
        public void a(Transition transition) {
            this.f910b.setVisibility(0);
        }

        @Override // androidx.transition.C0102aa, androidx.transition.Transition.c
        public void c(Transition transition) {
            this.f910b.setVisibility(4);
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            transition.b(this);
            E.a(this.f909a);
            this.f909a.setTag(R$id.transition_transform, null);
            this.f909a.setTag(R$id.parent_matrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final float f913a;

        /* renamed from: b  reason: collision with root package name */
        final float f914b;
        final float c;
        final float d;
        final float e;
        final float f;
        final float g;
        final float h;

        c(View view) {
            this.f913a = view.getTranslationX();
            this.f914b = view.getTranslationY();
            this.c = androidx.core.h.t.r(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.a(view, this.f913a, this.f914b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.f913a == this.f913a && cVar.f914b == this.f914b && cVar.c == this.c && cVar.d == this.d && cVar.e == this.e && cVar.f == this.f && cVar.g == this.g && cVar.h == this.h;
            }
            return false;
        }

        public int hashCode() {
            float f = this.f913a;
            int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.f914b;
            int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.c;
            int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.d;
            int floatToIntBits4 = (floatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.e;
            int floatToIntBits5 = (floatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f;
            int floatToIntBits6 = (floatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.g;
            int floatToIntBits7 = (floatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.h;
            return floatToIntBits7 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
        }
    }

    static {
        N = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.O = true;
        this.P = true;
        this.Q = new Matrix();
    }

    private void b(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        View view = gaVar2.f960b;
        Matrix matrix = new Matrix((Matrix) gaVar2.f959a.get("android:changeTransform:parentMatrix"));
        va.c(viewGroup, matrix);
        D a2 = E.a(view, viewGroup, matrix);
        if (a2 == null) {
            return;
        }
        a2.a((ViewGroup) gaVar.f959a.get("android:changeTransform:parent"), gaVar.f960b);
        Transition transition = this;
        while (true) {
            Transition transition2 = transition.u;
            if (transition2 == null) {
                break;
            }
            transition = transition2;
        }
        transition.a(new a(view, a2));
        if (N) {
            View view2 = gaVar.f960b;
            if (view2 != gaVar2.f960b) {
                va.a(view2, 0.0f);
            }
            va.a(view, 1.0f);
        }
    }

    private void d(ga gaVar) {
        View view = gaVar.f960b;
        if (view.getVisibility() == 8) {
            return;
        }
        gaVar.f959a.put("android:changeTransform:parent", view.getParent());
        gaVar.f959a.put("android:changeTransform:transforms", new c(view));
        Matrix matrix = view.getMatrix();
        gaVar.f959a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.P) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            va.b(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            gaVar.f959a.put("android:changeTransform:parentMatrix", matrix2);
            gaVar.f959a.put("android:changeTransform:intermediateMatrix", view.getTag(R$id.transition_transform));
            gaVar.f959a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R$id.parent_matrix));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // androidx.transition.Transition
    public void a(ga gaVar) {
        d(gaVar);
    }

    @Override // androidx.transition.Transition
    public void c(ga gaVar) {
        d(gaVar);
        if (N) {
            return;
        }
        ((ViewGroup) gaVar.f960b.getParent()).startViewTransition(gaVar.f960b);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f911a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f912b;
        private final float[] c;
        private float d;
        private float e;

        b(View view, float[] fArr) {
            this.f912b = view;
            this.c = (float[]) fArr.clone();
            float[] fArr2 = this.c;
            this.d = fArr2[2];
            this.e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.c;
            fArr[2] = this.d;
            fArr[5] = this.e;
            this.f911a.setValues(fArr);
            va.a(this.f912b, this.f911a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(float[] fArr) {
            System.arraycopy(fArr, 0, this.c, 0, fArr.length);
            b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.d = pointF.x;
            this.e = pointF.y;
            b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Matrix a() {
            return this.f911a;
        }
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        if (gaVar == null || gaVar2 == null || !gaVar.f959a.containsKey("android:changeTransform:parent") || !gaVar2.f959a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) gaVar.f959a.get("android:changeTransform:parent");
        boolean z = this.P && !a(viewGroup2, (ViewGroup) gaVar2.f959a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) gaVar.f959a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            gaVar.f959a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) gaVar.f959a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            gaVar.f959a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            b(gaVar, gaVar2);
        }
        ObjectAnimator a2 = a(gaVar, gaVar2, z);
        if (z && a2 != null && this.O) {
            b(viewGroup, gaVar, gaVar2);
        } else if (!N) {
            viewGroup2.endViewTransition(gaVar.f960b);
        }
        return a2;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O = true;
        this.P = true;
        this.Q = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.O = androidx.core.content.a.i.a(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.P = androidx.core.content.a.i.a(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    private void b(ga gaVar, ga gaVar2) {
        Matrix matrix = (Matrix) gaVar2.f959a.get("android:changeTransform:parentMatrix");
        gaVar2.f960b.setTag(R$id.parent_matrix, matrix);
        Matrix matrix2 = this.Q;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) gaVar.f959a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            gaVar.f959a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) gaVar.f959a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    private ObjectAnimator a(ga gaVar, ga gaVar2, boolean z) {
        Matrix matrix = (Matrix) gaVar.f959a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) gaVar2.f959a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = I.f921a;
        }
        if (matrix2 == null) {
            matrix2 = I.f921a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        c cVar = (c) gaVar2.f959a.get("android:changeTransform:transforms");
        View view = gaVar2.f960b;
        f(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        b bVar = new b(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bVar, PropertyValuesHolder.ofObject(L, new C0125u(new float[9]), fArr, fArr2), L.a(M, g().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        r rVar = new r(this, z, matrix3, view, cVar, bVar);
        ofPropertyValuesHolder.addListener(rVar);
        C0101a.a(ofPropertyValuesHolder, rVar);
        return ofPropertyValuesHolder;
    }

    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (b(viewGroup) && b(viewGroup2)) {
            ga a2 = a((View) viewGroup, true);
            if (a2 == null || viewGroup2 != a2.f960b) {
                return false;
            }
        } else if (viewGroup != viewGroup2) {
            return false;
        }
        return true;
    }

    static void a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        androidx.core.h.t.b(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }
}
