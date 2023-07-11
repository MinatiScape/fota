package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* compiled from: DescendantOffsetUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Matrix> f1373a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<RectF> f1374b = new ThreadLocal<>();

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        b(viewGroup, view, rect);
    }

    public static void b(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f1373a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f1373a.set(matrix);
        } else {
            matrix.reset();
        }
        a(viewGroup, view, matrix);
        RectF rectF = f1374b.get();
        if (rectF == null) {
            rectF = new RectF();
            f1374b.set(rectF);
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
