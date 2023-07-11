package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class ChangeScroll extends Transition {
    private static final String[] K = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    private void d(ga gaVar) {
        gaVar.f959a.put("android:changeScroll:x", Integer.valueOf(gaVar.f960b.getScrollX()));
        gaVar.f959a.put("android:changeScroll:y", Integer.valueOf(gaVar.f960b.getScrollY()));
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

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (gaVar == null || gaVar2 == null) {
            return null;
        }
        View view = gaVar2.f960b;
        int intValue = ((Integer) gaVar.f959a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) gaVar2.f959a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) gaVar.f959a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) gaVar2.f959a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        return fa.a(objectAnimator, objectAnimator2);
    }
}
