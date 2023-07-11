package androidx.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ImageViewUtils.java */
/* loaded from: classes.dex */
class G {

    /* renamed from: a  reason: collision with root package name */
    private static Method f919a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f920b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView) {
        if (Build.VERSION.SDK_INT < 21) {
            ImageView.ScaleType scaleType = imageView.getScaleType();
            imageView.setTag(R$id.save_scale_type, scaleType);
            ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
            if (scaleType == scaleType2) {
                imageView.setTag(R$id.save_image_matrix, imageView.getImageMatrix());
            } else {
                imageView.setScaleType(scaleType2);
            }
            imageView.setImageMatrix(I.f921a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT < 21) {
            imageView.setImageMatrix(matrix);
            return;
        }
        a();
        Method method = f919a;
        if (method != null) {
            try {
                method.invoke(imageView, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private static void a() {
        if (f920b) {
            return;
        }
        try {
            f919a = ImageView.class.getDeclaredMethod("animateTransform", Matrix.class);
            f919a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ImageViewUtils", "Failed to retrieve animateTransform method", e);
        }
        f920b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView, Animator animator) {
        if (Build.VERSION.SDK_INT < 21) {
            animator.addListener(new F(imageView));
        }
    }
}
