package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
/* loaded from: classes.dex */
public class Explode extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private int[] O;

    public Explode() {
        this.O = new int[2];
        a(new C0123s());
    }

    private void e(ga gaVar) {
        View view = gaVar.f960b;
        view.getLocationOnScreen(this.O);
        int[] iArr = this.O;
        int i = iArr[0];
        int i2 = iArr[1];
        gaVar.f959a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void a(ga gaVar) {
        super.a(gaVar);
        e(gaVar);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        float f;
        float f2;
        if (gaVar == null) {
            return null;
        }
        Rect rect = (Rect) gaVar.f959a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) gaVar.f960b.getTag(R$id.transition_position);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        a(viewGroup, rect, this.O);
        int[] iArr2 = this.O;
        return ia.a(view, gaVar, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], N);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void c(ga gaVar) {
        super.c(gaVar);
        e(gaVar);
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        if (gaVar2 == null) {
            return null;
        }
        Rect rect = (Rect) gaVar2.f959a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a(viewGroup, rect, this.O);
        int[] iArr = this.O;
        return ia.a(view, gaVar2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, M);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O = new int[2];
        a(new C0123s());
    }

    private void a(View view, Rect rect, int[] iArr) {
        int centerY;
        int i;
        view.getLocationOnScreen(this.O);
        int[] iArr2 = this.O;
        int i2 = iArr2[0];
        int i3 = iArr2[1];
        Rect c = c();
        if (c == null) {
            i = (view.getWidth() / 2) + i2 + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i3 + Math.round(view.getTranslationY());
        } else {
            int centerX = c.centerX();
            centerY = c.centerY();
            i = centerX;
        }
        float centerX2 = rect.centerX() - i;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float a2 = a(centerX2, centerY2);
        float a3 = a(view, i - i2, centerY - i3);
        iArr[0] = Math.round((centerX2 / a2) * a3);
        iArr[1] = Math.round(a3 * (centerY2 / a2));
    }

    private static float a(View view, int i, int i2) {
        return a(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }
}
