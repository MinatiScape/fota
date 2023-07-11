package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
/* compiled from: ViewUtilsBase.java */
/* loaded from: classes.dex */
class za {

    /* renamed from: a  reason: collision with root package name */
    private float[] f1000a;

    public void a(View view, float f) {
        Float f2 = (Float) view.getTag(R$id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public float b(View view) {
        Float f = (Float) view.getTag(R$id.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    public void c(View view) {
        if (view.getTag(R$id.save_non_transition_alpha) == null) {
            view.setTag(R$id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void c(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            c(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R$id.save_non_transition_alpha, null);
        }
    }

    public void b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            b(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void a(View view, Matrix matrix) {
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArr = this.f1000a;
            if (fArr == null) {
                fArr = new float[9];
                this.f1000a = fArr;
            }
            matrix.getValues(fArr);
            float f = fArr[3];
            float sqrt = ((float) Math.sqrt(1.0f - (f * f))) * (fArr[0] < 0.0f ? -1 : 1);
            float degrees = (float) Math.toDegrees(Math.atan2(f, sqrt));
            float f2 = fArr[0] / sqrt;
            float f3 = fArr[4] / sqrt;
            float f4 = fArr[2];
            float f5 = fArr[5];
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationX(f4);
            view.setTranslationY(f5);
            view.setRotation(degrees);
            view.setScaleX(f2);
            view.setScaleY(f3);
            return;
        }
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(0.0f);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
