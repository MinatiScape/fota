package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Matrix> f395a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<RectF> f396b = new ThreadLocal<>();

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        b(viewGroup, view, rect);
    }

    static void b(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f395a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f395a.set(matrix);
        } else {
            matrix.reset();
        }
        a(viewGroup, view, matrix);
        RectF rectF = f396b.get();
        if (rectF == null) {
            rectF = new RectF();
            f396b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    private static void a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            a(viewParent, view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
