package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.fa;
import java.util.Map;
/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    private static final String[] K = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> L = new C0118m();
    private static final Property<ImageView, Matrix> M = new C0119n(Matrix.class, "animatedTransform");

    public ChangeImageTransform() {
    }

    private static Matrix b(ImageView imageView) {
        int i = C0120o.f974a[imageView.getScaleType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return new Matrix(imageView.getImageMatrix());
            }
            return a(imageView);
        }
        return d(imageView);
    }

    private void d(ga gaVar) {
        View view = gaVar.f960b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = gaVar.f959a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", b(imageView));
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
    public String[] n() {
        return K;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ObjectAnimator c(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) M, (TypeEvaluator) L, (Object[]) new Matrix[]{null, null});
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        ObjectAnimator c;
        if (gaVar != null && gaVar2 != null) {
            Rect rect = (Rect) gaVar.f959a.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) gaVar2.f959a.get("android:changeImageTransform:bounds");
            if (rect != null && rect2 != null) {
                Matrix matrix = (Matrix) gaVar.f959a.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) gaVar2.f959a.get("android:changeImageTransform:matrix");
                boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
                if (rect.equals(rect2) && z) {
                    return null;
                }
                ImageView imageView = (ImageView) gaVar2.f960b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                G.a(imageView);
                if (intrinsicWidth != 0 && intrinsicHeight != 0) {
                    if (matrix == null) {
                        matrix = I.f921a;
                    }
                    if (matrix2 == null) {
                        matrix2 = I.f921a;
                    }
                    M.set(imageView, matrix);
                    c = a(imageView, matrix, matrix2);
                } else {
                    c = c(imageView);
                }
                G.a(imageView, c);
                return c;
            }
        }
        return null;
    }

    private static Matrix d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    private ObjectAnimator a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) M, (TypeEvaluator) new fa.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    private static Matrix a(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f2 = intrinsicHeight;
        float max = Math.max(width / f, height / f2);
        int round = Math.round((width - (f * max)) / 2.0f);
        int round2 = Math.round((height - (f2 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }
}
