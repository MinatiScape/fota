package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
/* compiled from: GhostViewApi14.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class B extends View implements D {

    /* renamed from: a  reason: collision with root package name */
    final View f901a;

    /* renamed from: b  reason: collision with root package name */
    ViewGroup f902b;
    View c;
    int d;
    private int e;
    private int f;
    Matrix g;
    private final Matrix h;
    private final ViewTreeObserver.OnPreDrawListener i;

    B(View view) {
        super(view.getContext());
        this.h = new Matrix();
        this.i = new A(this);
        this.f901a = view;
        setLayerType(2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static D a(View view, ViewGroup viewGroup) {
        B a2 = a(view);
        if (a2 == null) {
            FrameLayout a3 = a(viewGroup);
            if (a3 == null) {
                return null;
            }
            a2 = new B(view);
            a3.addView(a2);
        }
        a2.d++;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view) {
        B a2 = a(view);
        if (a2 != null) {
            a2.d--;
            if (a2.d <= 0) {
                ViewParent parent = a2.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.endViewTransition(a2);
                    viewGroup.removeView(a2);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.f901a, this);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.f901a.getLocationOnScreen(r0);
        int[] iArr2 = {(int) (iArr2[0] - this.f901a.getTranslationX()), (int) (iArr2[1] - this.f901a.getTranslationY())};
        this.e = iArr2[0] - iArr[0];
        this.f = iArr2[1] - iArr[1];
        this.f901a.getViewTreeObserver().addOnPreDrawListener(this.i);
        this.f901a.setVisibility(4);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f901a.getViewTreeObserver().removeOnPreDrawListener(this.i);
        this.f901a.setVisibility(0);
        a(this.f901a, (B) null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.h.set(this.g);
        this.h.postTranslate(this.e, this.f);
        canvas.setMatrix(this.h);
        this.f901a.draw(canvas);
    }

    @Override // android.view.View, androidx.transition.D
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f901a.setVisibility(i == 0 ? 4 : 0);
    }

    private static FrameLayout a(ViewGroup viewGroup) {
        while (!(viewGroup instanceof FrameLayout)) {
            ViewParent parent = viewGroup.getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            viewGroup = (ViewGroup) parent;
        }
        return (FrameLayout) viewGroup;
    }

    @Override // androidx.transition.D
    public void a(ViewGroup viewGroup, View view) {
        this.f902b = viewGroup;
        this.c = view;
    }

    private static void a(View view, B b2) {
        view.setTag(R$id.ghost_view, b2);
    }

    static B a(View view) {
        return (B) view.getTag(R$id.ghost_view);
    }
}
