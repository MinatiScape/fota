package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String[] K = {"android:clipBounds:clip"};

    public ChangeClipBounds() {
    }

    private void d(ga gaVar) {
        View view = gaVar.f960b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect e = androidx.core.h.t.e(view);
        gaVar.f959a.put("android:clipBounds:clip", e);
        if (e == null) {
            gaVar.f959a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
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

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        ObjectAnimator objectAnimator = null;
        if (gaVar != null && gaVar2 != null && gaVar.f959a.containsKey("android:clipBounds:clip") && gaVar2.f959a.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) gaVar.f959a.get("android:clipBounds:clip");
            Rect rect2 = (Rect) gaVar2.f959a.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) gaVar.f959a.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = (Rect) gaVar2.f959a.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            androidx.core.h.t.a(gaVar2.f960b, rect);
            objectAnimator = ObjectAnimator.ofObject(gaVar2.f960b, (Property<View, V>) va.e, (TypeEvaluator) new M(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z) {
                objectAnimator.addListener(new C0117l(this, gaVar2.f960b));
            }
        }
        return objectAnimator;
    }
}
